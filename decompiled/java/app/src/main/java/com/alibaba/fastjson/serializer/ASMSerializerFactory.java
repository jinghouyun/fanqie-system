package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.facebook.common.callercontext.ContextChain;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.dcloud.common.constant.AbsoluteConst;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class ASMSerializerFactory implements Opcodes {
    static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
    static final String JavaBeanSerializer;
    static final String JavaBeanSerializer_desc;
    static final String ObjectSerializer;
    static final String ObjectSerializer_desc;
    static final String SerialContext_desc;
    static final String SerializeFilterable_desc;
    static final String SerializeWriter;
    static final String SerializeWriter_desc;
    protected final ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    static {
        String strType = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer = strType;
        ObjectSerializer_desc = "L" + strType + ";";
        String strType2 = ASMUtils.type(SerializeWriter.class);
        SerializeWriter = strType2;
        SerializeWriter_desc = "L" + strType2 + ";";
        JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
        JavaBeanSerializer_desc = "L" + ASMUtils.type(JavaBeanSerializer.class) + ";";
        SerialContext_desc = ASMUtils.desc((Class<?>) SerialContext.class);
        SerializeFilterable_desc = ASMUtils.desc((Class<?>) SerializeFilterable.class);
    }

    static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        private final SerializeBeanInfo beanInfo;
        private final String className;
        private final FieldInfo[] getters;
        private final boolean nonContext;
        private final boolean writeDirect;
        private Map<String, Integer> variants = new HashMap();
        private int variantIndex = 9;

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z, boolean z2) {
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z;
            this.nonContext = z2 || serializeBeanInfo.beanType.isEnum();
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int getFieldOrinal(String str) {
            int length = this.getters.length;
            for (int i = 0; i < length; i++) {
                if (this.getters[i].name.equals(str)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        String str;
        boolean z;
        boolean z2;
        ClassWriter classWriter;
        String str2;
        boolean z3;
        boolean z4;
        String str3;
        boolean z5;
        boolean z6;
        int i;
        SerializeBeanInfo serializeBeanInfo2 = serializeBeanInfo;
        Class<?> cls = serializeBeanInfo2.beanType;
        if (cls.isPrimitive()) {
            throw new JSONException("unsupportd class " + cls.getName());
        }
        JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
        FieldInfo[] fieldInfoArr = serializeBeanInfo2.fields;
        for (FieldInfo fieldInfo : fieldInfoArr) {
            if (fieldInfo.field == null && fieldInfo.method != null && fieldInfo.method.getDeclaringClass().isInterface()) {
                return new JavaBeanSerializer(serializeBeanInfo2);
            }
        }
        FieldInfo[] fieldInfoArr2 = serializeBeanInfo2.sortedFields;
        boolean z7 = serializeBeanInfo2.sortedFields == serializeBeanInfo2.fields;
        if (fieldInfoArr2.length > 256) {
            return new JavaBeanSerializer(serializeBeanInfo2);
        }
        for (FieldInfo fieldInfo2 : fieldInfoArr2) {
            if (!ASMUtils.checkName(fieldInfo2.getMember().getName())) {
                return new JavaBeanSerializer(serializeBeanInfo2);
            }
        }
        String str4 = "ASMSerializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
        Package r4 = ASMSerializerFactory.class.getPackage();
        if (r4 != null) {
            String name = r4.getName();
            String str5 = name.replace(Operators.DOT, '/') + "/" + str4;
            str4 = name + Operators.DOT_STR + str4;
            str = str5;
        } else {
            str = str4;
        }
        ClassWriter classWriter2 = new ClassWriter();
        classWriter2.visit(49, 33, str, JavaBeanSerializer, new String[]{ObjectSerializer});
        ClassWriter classWriter3 = classWriter2;
        int length = fieldInfoArr2.length;
        int i2 = 0;
        while (i2 < length) {
            FieldInfo fieldInfo3 = fieldInfoArr2[i2];
            if (!fieldInfo3.fieldClass.isPrimitive() && fieldInfo3.fieldClass != String.class) {
                new FieldWriter(classWriter3, 1, fieldInfo3.name + "_asm_fieldType", "Ljava/lang/reflect/Type;").visitEnd();
                if (List.class.isAssignableFrom(fieldInfo3.fieldClass)) {
                    new FieldWriter(classWriter3, 1, fieldInfo3.name + "_asm_list_item_ser_", ObjectSerializer_desc).visitEnd();
                }
                new FieldWriter(classWriter3, 1, fieldInfo3.name + "_asm_ser_", ObjectSerializer_desc).visitEnd();
            }
            i2++;
            str4 = str4;
        }
        String str6 = str4;
        MethodWriter methodWriter = new MethodWriter(classWriter3, 1, "<init>", Operators.BRACKET_START_STR + ASMUtils.desc((Class<?>) SerializeBeanInfo.class) + ")V", null, null);
        int i3 = 25;
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "<init>", Operators.BRACKET_START_STR + ASMUtils.desc((Class<?>) SerializeBeanInfo.class) + ")V");
        int i4 = 0;
        while (i4 < fieldInfoArr2.length) {
            FieldInfo fieldInfo4 = fieldInfoArr2[i4];
            if (!fieldInfo4.fieldClass.isPrimitive() && fieldInfo4.fieldClass != String.class) {
                methodWriter.visitVarInsn(i3, 0);
                if (fieldInfo4.method != null) {
                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo4.declaringClass)));
                    methodWriter.visitLdcInsn(fieldInfo4.method.getName());
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitLdcInsn(Integer.valueOf(i4));
                    methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                methodWriter.visitFieldInsn(Opcodes.PUTFIELD, str, fieldInfo4.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i4++;
            i3 = 25;
        }
        methodWriter.visitInsn(Opcodes.RETURN);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
        if (jSONType == null) {
            z = false;
            break;
        }
        SerializerFeature[] serializerFeatureArrSerialzeFeatures = jSONType.serialzeFeatures();
        int length2 = serializerFeatureArrSerialzeFeatures.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length2) {
                z = false;
                break;
            }
            if (serializerFeatureArrSerialzeFeatures[i5] == SerializerFeature.DisableCircularReferenceDetect) {
                z = true;
                break;
            }
            i5++;
        }
        int i6 = 0;
        while (true) {
            JSONType jSONType2 = jSONType;
            z2 = z7;
            if (i6 >= 3) {
                break;
            }
            if (i6 == 0) {
                str3 = "write";
                z6 = z;
                z5 = true;
            } else if (i6 == 1) {
                str3 = "writeNormal";
                z6 = z;
                z5 = false;
            } else {
                str3 = "writeDirectNonContext";
                z5 = true;
                z6 = true;
            }
            String str7 = str6;
            Context context = new Context(fieldInfoArr2, serializeBeanInfo2, str, z5, z6);
            int i7 = i6;
            StringBuilder sb = new StringBuilder("(L");
            String str8 = JSONSerializer;
            sb.append(str8);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            MethodWriter methodWriter2 = new MethodWriter(classWriter3, 1, str3, sb.toString(), null, new String[]{"java/io/IOException"});
            Label label = new Label();
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodWriter2.visitVarInsn(25, 1);
            boolean z8 = z6;
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "writeNull", "()V");
            methodWriter2.visitInsn(Opcodes.RETURN);
            methodWriter2.visitLabel(label);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitFieldInsn(180, str8, "out", SerializeWriter_desc);
            methodWriter2.visitVarInsn(58, context.var("out"));
            if (!z2 && !context.writeDirect && (jSONType2 == null || jSONType2.alphabetic())) {
                Label label2 = new Label();
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isSortField", "()Z");
                methodWriter2.visitJumpInsn(Opcodes.IFNE, label2);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeUnsorted", "(L" + str8 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label2);
            }
            if (!context.writeDirect || z8) {
                i = Opcodes.RETURN;
            } else {
                Label label3 = new Label();
                Label label4 = new Label();
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeDirect", "(L" + str8 + ";)Z");
                methodWriter2.visitJumpInsn(Opcodes.IFNE, label4);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeNormal", "(L" + str8 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label4);
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodWriter2.visitJumpInsn(Opcodes.IFEQ, label3);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeDirectNonContext", "(L" + str8 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i = Opcodes.RETURN;
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label3);
            }
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitTypeInsn(192, ASMUtils.type(cls));
            methodWriter2.visitVarInsn(58, context.var("entity"));
            generateWriteMethod(cls, methodWriter2, fieldInfoArr2, context);
            methodWriter2.visitInsn(i);
            methodWriter2.visitMaxs(7, context.variantIndex + 2);
            methodWriter2.visitEnd();
            i6 = i7 + 1;
            serializeBeanInfo2 = serializeBeanInfo;
            jSONType = jSONType2;
            z7 = z2;
            str6 = str7;
            classWriter3 = classWriter3;
            fieldInfoArr = fieldInfoArr;
        }
        FieldInfo[] fieldInfoArr3 = fieldInfoArr;
        ClassWriter classWriter4 = classWriter3;
        String str9 = "(L";
        String str10 = str6;
        if (z2) {
            classWriter = classWriter4;
        } else {
            Context context2 = new Context(fieldInfoArr2, serializeBeanInfo, str, false, z);
            StringBuilder sb2 = new StringBuilder(str9);
            String str11 = JSONSerializer;
            sb2.append(str11);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            str9 = str9;
            classWriter = classWriter4;
            MethodWriter methodWriter3 = new MethodWriter(classWriter, 1, "writeUnsorted", sb2.toString(), null, new String[]{"java/io/IOException"});
            methodWriter3.visitVarInsn(25, 1);
            methodWriter3.visitFieldInsn(180, str11, "out", SerializeWriter_desc);
            methodWriter3.visitVarInsn(58, context2.var("out"));
            methodWriter3.visitVarInsn(25, 2);
            methodWriter3.visitTypeInsn(192, ASMUtils.type(cls));
            methodWriter3.visitVarInsn(58, context2.var("entity"));
            generateWriteMethod(cls, methodWriter3, fieldInfoArr3, context2);
            methodWriter3.visitInsn(Opcodes.RETURN);
            methodWriter3.visitMaxs(7, context2.variantIndex + 2);
            methodWriter3.visitEnd();
        }
        int i8 = 0;
        while (i8 < 3) {
            if (i8 == 0) {
                str2 = "writeAsArray";
                z4 = z;
                z3 = true;
            } else if (i8 == 1) {
                str2 = "writeAsArrayNormal";
                z4 = z;
                z3 = false;
            } else {
                str2 = "writeAsArrayNonContext";
                z3 = true;
                z4 = true;
            }
            String str12 = str9;
            Context context3 = new Context(fieldInfoArr2, serializeBeanInfo, str, z3, z4);
            StringBuilder sb3 = new StringBuilder(str12);
            String str13 = JSONSerializer;
            sb3.append(str13);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            MethodWriter methodWriter4 = new MethodWriter(classWriter, 1, str2, sb3.toString(), null, new String[]{"java/io/IOException"});
            methodWriter4.visitVarInsn(25, 1);
            methodWriter4.visitFieldInsn(180, str13, "out", SerializeWriter_desc);
            methodWriter4.visitVarInsn(58, context3.var("out"));
            methodWriter4.visitVarInsn(25, 2);
            methodWriter4.visitTypeInsn(192, ASMUtils.type(cls));
            methodWriter4.visitVarInsn(58, context3.var("entity"));
            generateWriteAsArray(cls, methodWriter4, fieldInfoArr2, context3);
            methodWriter4.visitInsn(Opcodes.RETURN);
            methodWriter4.visitMaxs(7, context3.variantIndex + 2);
            methodWriter4.visitEnd();
            i8++;
            str9 = str12;
        }
        byte[] byteArray = classWriter.toByteArray();
        return (JavaBeanSerializer) this.classLoader.defineClassPublic(str10, byteArray, 0, byteArray.length).getConstructor(SerializeBeanInfo.class).newInstance(serializeBeanInfo);
    }

    private void generateWriteAsArray(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        String str;
        ASMSerializerFactory aSMSerializerFactory;
        int i;
        java.lang.reflect.Type type;
        Class<?> cls2;
        Class<?> cls3;
        String str2;
        int i2;
        int i3;
        String str3;
        int i4;
        ASMSerializerFactory aSMSerializerFactory2 = this;
        FieldInfo[] fieldInfoArr2 = fieldInfoArr;
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        String str4 = JSONSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "hasPropertyFilters", Operators.BRACKET_START_STR + SerializeFilterable_desc + ")Z");
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, 3);
        methodVisitor.visitVarInsn(25, 4);
        methodVisitor.visitVarInsn(21, 5);
        String str5 = JavaBeanSerializer;
        String str6 = "(L";
        StringBuilder sb = new StringBuilder("(L");
        sb.append(str4);
        String str7 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, str5, "writeNoneASM", sb.toString());
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitLabel(label);
        String str8 = "out";
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(16, 91);
        String str9 = SerializeWriter;
        String str10 = "(I)V";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str9, "write", "(I)V");
        char c = 0;
        int length = fieldInfoArr2.length;
        if (length == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str9, "write", "(I)V");
            return;
        }
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 == length + (-1) ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr2[i5];
            Class<?> cls4 = fieldInfo.fieldClass;
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitVarInsn(58, Context.fieldName);
            if (cls4 == Byte.TYPE || cls4 == Short.TYPE || cls4 == Integer.TYPE) {
                str8 = str8;
                int i7 = i6;
                length = length;
                i5 = i5;
                str6 = str6;
                str10 = str10;
                str = str7;
                methodVisitor.visitVarInsn(25, context.var(str8));
                methodVisitor.visitInsn(89);
                aSMSerializerFactory = this;
                aSMSerializerFactory._get(methodVisitor, context, fieldInfo);
                String str11 = SerializeWriter;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "writeInt", str10);
                methodVisitor.visitVarInsn(16, i7);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "write", str10);
            } else {
                if (cls4 == Long.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str12 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "writeLong", "(J)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "write", str10);
                } else if (cls4 == Float.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    String str13 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "writeFloat", "(FZ)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "write", str10);
                } else if (cls4 == Double.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    String str14 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "writeDouble", "(DZ)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "write", str10);
                } else if (cls4 == Boolean.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str15 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "write", "(Z)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "write", str10);
                } else if (cls4 == Character.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                } else {
                    if (cls4 == String.class) {
                        methodVisitor.visitVarInsn(25, context.var(str8));
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitVarInsn(16, i6);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls4.isEnum()) {
                        methodVisitor.visitVarInsn(25, context.var(str8));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        String str16 = SerializeWriter;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "writeEnum", "(Ljava/lang/Enum;)V");
                        methodVisitor.visitVarInsn(16, i6);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "write", str10);
                    } else if (List.class.isAssignableFrom(cls4)) {
                        java.lang.reflect.Type type2 = fieldInfo.fieldType;
                        if (type2 instanceof Class) {
                            type = Object.class;
                        } else {
                            type = ((ParameterizedType) type2).getActualTypeArguments()[c];
                        }
                        if (!(type instanceof Class) || (cls2 = (Class) type) == Object.class) {
                            cls2 = null;
                        }
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        java.lang.reflect.Type type3 = type;
                        methodVisitor.visitTypeInsn(192, "java/util/List");
                        length = length;
                        methodVisitor.visitVarInsn(58, context.var(WXBasicComponentType.LIST));
                        if (cls2 == String.class && context.writeDirect) {
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(Ljava/util/List;)V");
                            str2 = str8;
                            str6 = str6;
                            str3 = str10;
                            i3 = 16;
                            i2 = 25;
                            str = str7;
                            i4 = Opcodes.INVOKEVIRTUAL;
                        } else {
                            Label label2 = new Label();
                            Label label3 = new Label();
                            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
                            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            String str17 = SerializeWriter;
                            String str18 = str7;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "writeNull", "()V");
                            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
                            methodVisitor.visitLabel(label3);
                            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", AbsoluteConst.JSON_KEY_SIZE, "()I");
                            methodVisitor.visitVarInsn(54, context.var(AbsoluteConst.JSON_KEY_SIZE));
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            methodVisitor.visitVarInsn(16, 91);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "write", str10);
                            Label label4 = new Label();
                            Label label5 = new Label();
                            Label label6 = new Label();
                            methodVisitor.visitInsn(3);
                            String str19 = str6;
                            methodVisitor.visitVarInsn(54, context.var(ContextChain.TAG_INFRA));
                            methodVisitor.visitLabel(label4);
                            methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                            methodVisitor.visitVarInsn(21, context.var(AbsoluteConst.JSON_KEY_SIZE));
                            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label6);
                            methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label5);
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            methodVisitor.visitVarInsn(16, 44);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "write", str10);
                            methodVisitor.visitLabel(label5);
                            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
                            methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
                            methodVisitor.visitVarInsn(58, context.var("list_item"));
                            Label label7 = new Label();
                            Label label8 = new Label();
                            String str20 = str10;
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label8);
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            String str21 = str8;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "writeNull", "()V");
                            methodVisitor.visitJumpInsn(Opcodes.GOTO, label7);
                            methodVisitor.visitLabel(label8);
                            Label label9 = new Label();
                            Label label10 = new Label();
                            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                label4 = label4;
                                cls3 = cls2;
                                str = str18;
                                str6 = str19;
                                label7 = label7;
                            } else {
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                                methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label10);
                                aSMSerializerFactory2._getListFieldItemSer(context, methodVisitor, fieldInfo, cls2);
                                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                                Label label11 = new Label();
                                Label label12 = new Label();
                                if (context.writeDirect) {
                                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                    String str22 = JavaBeanSerializer;
                                    methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str22);
                                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, label11);
                                    cls3 = cls2;
                                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                    methodVisitor.visitTypeInsn(192, str22);
                                    methodVisitor.visitVarInsn(25, 1);
                                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                                    if (context.nonContext) {
                                        methodVisitor.visitInsn(1);
                                    } else {
                                        methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                                        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                    str6 = str19;
                                    StringBuilder sb2 = new StringBuilder(str6);
                                    sb2.append(JSONSerializer);
                                    str = str18;
                                    sb2.append(str);
                                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str22, "writeAsArrayNonContext", sb2.toString());
                                    methodVisitor.visitJumpInsn(Opcodes.GOTO, label12);
                                    methodVisitor.visitLabel(label11);
                                } else {
                                    label4 = label4;
                                    cls3 = cls2;
                                    str = str18;
                                    str6 = str19;
                                }
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                methodVisitor.visitVarInsn(25, 1);
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                if (context.nonContext) {
                                    methodVisitor.visitInsn(1);
                                } else {
                                    methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", str6 + JSONSerializer + str);
                                methodVisitor.visitLabel(label12);
                                methodVisitor.visitJumpInsn(Opcodes.GOTO, label9);
                            }
                            methodVisitor.visitLabel(label10);
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            if (context.nonContext) {
                                methodVisitor.visitInsn(1);
                            } else {
                                methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            if (cls3 != null && Modifier.isPublic(cls3.getModifiers())) {
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) type3)));
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            } else {
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            }
                            methodVisitor.visitLabel(label9);
                            methodVisitor.visitLabel(label7);
                            methodVisitor.visitIincInsn(context.var(ContextChain.TAG_INFRA), 1);
                            methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
                            methodVisitor.visitLabel(label6);
                            str2 = str21;
                            i2 = 25;
                            methodVisitor.visitVarInsn(25, context.var(str2));
                            i3 = 16;
                            methodVisitor.visitVarInsn(16, 93);
                            str3 = str20;
                            i4 = Opcodes.INVOKEVIRTUAL;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "write", str3);
                            methodVisitor.visitLabel(label2);
                        }
                        methodVisitor.visitVarInsn(i2, context.var(str2));
                        methodVisitor.visitVarInsn(i3, i6);
                        methodVisitor.visitMethodInsn(i4, SerializeWriter, "write", str3);
                        aSMSerializerFactory = this;
                        str8 = str2;
                        str10 = str3;
                    } else {
                        String str23 = str8;
                        int i8 = i6;
                        length = length;
                        i5 = i5;
                        str6 = str6;
                        String str24 = str10;
                        str = str7;
                        Label label13 = new Label();
                        Label label14 = new Label();
                        _get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitVarInsn(58, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label14);
                        methodVisitor.visitVarInsn(25, context.var(str23));
                        String str25 = SerializeWriter;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str25, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label13);
                        methodVisitor.visitLabel(label14);
                        Label label15 = new Label();
                        Label label16 = new Label();
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls4)));
                        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label16);
                        _getFieldSer(context, methodVisitor, fieldInfo);
                        methodVisitor.visitVarInsn(58, context.var("fied_ser"));
                        Label label17 = new Label();
                        Label label18 = new Label();
                        if (context.writeDirect && Modifier.isPublic(cls4.getModifiers())) {
                            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                            String str26 = JavaBeanSerializer;
                            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str26);
                            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label17);
                            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                            methodVisitor.visitTypeInsn(192, str26);
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                            methodVisitor.visitVarInsn(25, Context.fieldName);
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls4)));
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str26, "writeAsArrayNonContext", str6 + JSONSerializer + str);
                            methodVisitor.visitJumpInsn(Opcodes.GOTO, label18);
                            methodVisitor.visitLabel(label17);
                        }
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitVarInsn(25, Context.fieldName);
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls4)));
                        methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                        String str27 = ObjectSerializer;
                        StringBuilder sb3 = new StringBuilder(str6);
                        String str28 = JSONSerializer;
                        sb3.append(str28);
                        sb3.append(str);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, str27, "write", sb3.toString());
                        methodVisitor.visitLabel(label18);
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label15);
                        methodVisitor.visitLabel(label16);
                        String format = fieldInfo.getFormat();
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        if (format != null) {
                            methodVisitor.visitLdcInsn(format);
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str28, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                            i = Opcodes.INVOKEVIRTUAL;
                        } else {
                            methodVisitor.visitVarInsn(25, Context.fieldName);
                            if ((fieldInfo.fieldType instanceof Class) && ((Class) fieldInfo.fieldType).isPrimitive()) {
                                i = Opcodes.INVOKEVIRTUAL;
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str28, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                methodVisitor.visitVarInsn(25, 0);
                                methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                i = Opcodes.INVOKEVIRTUAL;
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str28, r7, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                        }
                        methodVisitor.visitLabel(label15);
                        methodVisitor.visitLabel(label13);
                        str8 = str23;
                        methodVisitor.visitVarInsn(25, context.var(str8));
                        methodVisitor.visitVarInsn(16, i8);
                        str10 = str24;
                        methodVisitor.visitMethodInsn(i, str25, "write", str10);
                        aSMSerializerFactory = this;
                    }
                    str = str7;
                    aSMSerializerFactory = aSMSerializerFactory2;
                }
                str = str7;
                aSMSerializerFactory = aSMSerializerFactory2;
            }
            i5++;
            str6 = str6;
            aSMSerializerFactory2 = aSMSerializerFactory;
            str7 = str;
            length = length;
            c = 0;
            str8 = str8;
            str10 = str10;
            fieldInfoArr2 = fieldInfoArr;
        }
    }

    private void generateWriteMethod(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        String str;
        int i;
        ASMSerializerFactory aSMSerializerFactory = this;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label = new Label();
        if (!context.writeDirect) {
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(Opcodes.IFNE, label3);
            int length = fieldInfoArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (fieldInfoArr[i2].method != null) {
                        methodVisitor2.visitVarInsn(25, context.var("out"));
                        methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                        methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label2);
                        break;
                    }
                    i2++;
                } else {
                    methodVisitor2.visitJumpInsn(Opcodes.GOTO, label2);
                    break;
                }
            }
            methodVisitor2.visitLabel(label3);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(Opcodes.RETURN);
            methodVisitor2.visitLabel(label2);
        }
        if (!context.nonContext) {
            Label label4 = new Label();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeReference", "(L" + JSONSerializer + ";Ljava/lang/Object;I)Z");
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label4);
            methodVisitor2.visitInsn(Opcodes.RETURN);
            methodVisitor2.visitLabel(label4);
        }
        if (context.writeDirect) {
            if (context.nonContext) {
                str = "writeAsArrayNonContext";
            } else {
                str = "writeAsArray";
            }
        } else {
            str = "writeAsArrayNormal";
        }
        if ((context.beanInfo.features & SerializerFeature.BeanToArray.mask) == 0) {
            Label label5 = new Label();
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitLdcInsn(Integer.valueOf(SerializerFeature.BeanToArray.mask));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label5);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, context.className, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(Opcodes.RETURN);
            methodVisitor2.visitLabel(label5);
        } else {
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, context.className, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(Opcodes.RETURN);
        }
        String str2 = "parent";
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            String str3 = JSONSerializer;
            StringBuilder sb = new StringBuilder("()");
            String str4 = SerialContext_desc;
            sb.append(str4);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str3, "getContext", sb.toString());
            methodVisitor2.visitVarInsn(58, context.var("parent"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context.var("parent"));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitLdcInsn(Integer.valueOf(context.beanInfo.features));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str3, "setContext", Operators.BRACKET_START_STR + str4 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z = (context.beanInfo.features & SerializerFeature.WriteClassName.mask) != 0;
        if (z || !context.writeDirect) {
            Label label6 = new Label();
            Label label7 = new Label();
            Label label8 = new Label();
            if (z) {
                i = Opcodes.INVOKEVIRTUAL;
            } else {
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitVarInsn(25, 4);
                methodVisitor2.visitVarInsn(25, 2);
                String str5 = JSONSerializer;
                i = Opcodes.INVOKEVIRTUAL;
                methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                methodVisitor2.visitJumpInsn(Opcodes.IFEQ, label7);
            }
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(i, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitJumpInsn(Opcodes.IF_ACMPEQ, label7);
            methodVisitor2.visitLabel(label8);
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitMethodInsn(i, SerializeWriter, "write", "(I)V");
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            if (context.beanInfo.typeKey != null) {
                methodVisitor2.visitLdcInsn(context.beanInfo.typeKey);
            } else {
                methodVisitor2.visitInsn(1);
            }
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeClassName", "(L" + JSONSerializer + ";Ljava/lang/String;Ljava/lang/Object;)V");
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitJumpInsn(Opcodes.GOTO, label6);
            methodVisitor2.visitLabel(label7);
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitLabel(label6);
        } else {
            methodVisitor2.visitVarInsn(16, 123);
            str2 = "parent";
        }
        methodVisitor2.visitVarInsn(54, context.var("seperator"));
        if (!context.writeDirect) {
            aSMSerializerFactory._before(methodVisitor2, context);
        }
        if (!context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isNotWriteDefaultValue", "()Z");
            methodVisitor2.visitVarInsn(54, context.var("notWriteDefaultValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            String str6 = JSONSerializer;
            StringBuilder sb2 = new StringBuilder(Operators.BRACKET_START_STR);
            String str7 = SerializeFilterable_desc;
            sb2.append(str7);
            sb2.append(")Z");
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "checkValue", sb2.toString());
            methodVisitor2.visitVarInsn(54, context.var("checkValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "hasNameFilters", Operators.BRACKET_START_STR + str7 + ")Z");
            methodVisitor2.visitVarInsn(54, context.var("hasNameFilters"));
        }
        for (FieldInfo fieldInfo : fieldInfoArr) {
            Class<?> cls2 = fieldInfo.fieldClass;
            methodVisitor2.visitLdcInsn(fieldInfo.name);
            methodVisitor2.visitVarInsn(58, Context.fieldName);
            if (cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo, context, context.var(cls2.getName()), 'I');
            } else if (cls2 == Long.TYPE) {
                aSMSerializerFactory._long(cls, methodVisitor2, fieldInfo, context);
            } else if (cls2 == Float.TYPE) {
                aSMSerializerFactory._float(cls, methodVisitor2, fieldInfo, context);
            } else if (cls2 == Double.TYPE) {
                aSMSerializerFactory._double(cls, methodVisitor2, fieldInfo, context);
            } else if (cls2 == Boolean.TYPE) {
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo, context, context.var("boolean"), 'Z');
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
            } else if (cls2 == Character.TYPE) {
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo, context, context.var("char"), 'C');
            } else {
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
                if (cls2 == String.class) {
                    aSMSerializerFactory._string(cls, methodVisitor2, fieldInfo, context);
                } else if (cls2 == BigDecimal.class) {
                    aSMSerializerFactory._decimal(cls, methodVisitor2, fieldInfo, context);
                } else if (List.class.isAssignableFrom(cls2)) {
                    aSMSerializerFactory._list(cls, methodVisitor2, fieldInfo, context);
                } else if (cls2.isEnum()) {
                    aSMSerializerFactory._enum(cls, methodVisitor2, fieldInfo, context);
                } else {
                    aSMSerializerFactory._object(cls, methodVisitor2, fieldInfo, context);
                }
            }
        }
        if (!context.writeDirect) {
            aSMSerializerFactory._after(methodVisitor2, context);
        }
        Label label9 = new Label();
        Label label10 = new Label();
        methodVisitor2.visitVarInsn(21, context.var("seperator"));
        methodVisitor2.visitIntInsn(16, 123);
        methodVisitor2.visitJumpInsn(Opcodes.IF_ICMPNE, label9);
        methodVisitor2.visitVarInsn(25, context.var("out"));
        methodVisitor2.visitVarInsn(16, 123);
        String str8 = SerializeWriter;
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "write", "(I)V");
        methodVisitor2.visitLabel(label9);
        methodVisitor2.visitVarInsn(25, context.var("out"));
        methodVisitor2.visitVarInsn(16, 125);
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "write", "(I)V");
        methodVisitor2.visitLabel(label10);
        methodVisitor2.visitLabel(label);
        if (context.nonContext) {
            return;
        }
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context.var(str2));
        methodVisitor2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", Operators.BRACKET_START_STR + SerialContext_desc + ")V");
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Enum", "name", "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i, char c) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(21, i);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;" + c + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var("float"));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var("float"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            methodVisitor.visitMethodInsn(declaringClass.isInterface() ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
            if (method.getReturnType().equals(fieldInfo.fieldClass)) {
                return;
            }
            methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(180, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
        if (field.getType().equals(fieldInfo.fieldClass)) {
            return;
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("string"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("string"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label3);
        methodVisitor.visitLabel(label2);
        if (AbsoluteConst.XML_TRIM.equals(fieldInfo.format)) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", AbsoluteConst.XML_TRIM, "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, context.var("string"));
        }
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls2;
        Label label;
        FieldInfo fieldInfo2;
        int i;
        int i2;
        int i3;
        java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo.fieldType);
        Class<?> cls3 = null;
        Class<?> cls4 = collectionItemType instanceof Class ? (Class) collectionItemType : null;
        if (cls4 != Object.class && cls4 != Serializable.class) {
            cls3 = cls4;
        }
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label2);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/util/List");
        methodVisitor.visitVarInsn(58, context.var(WXBasicComponentType.LIST));
        _filters(methodVisitor, fieldInfo, context, label2);
        methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", AbsoluteConst.JSON_KEY_SIZE, "()I");
        methodVisitor.visitVarInsn(54, context.var(AbsoluteConst.JSON_KEY_SIZE));
        Label label5 = new Label();
        Label label6 = new Label();
        methodVisitor.visitVarInsn(21, context.var(AbsoluteConst.JSON_KEY_SIZE));
        methodVisitor.visitInsn(3);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label5);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn("[]");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(Ljava/lang/String;)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label6);
        methodVisitor.visitLabel(label5);
        if (!context.nonContext) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (collectionItemType == String.class && context.writeDirect) {
            i2 = 25;
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
            i3 = Opcodes.INVOKEVIRTUAL;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(Ljava/util/List;)V");
            i = 1;
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 91);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            Label label7 = new Label();
            Label label8 = new Label();
            Label label9 = new Label();
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, context.var(ContextChain.TAG_INFRA));
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
            methodVisitor.visitVarInsn(21, context.var(AbsoluteConst.JSON_KEY_SIZE));
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label9);
            methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label8);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitLabel(label8);
            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
            methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
            methodVisitor.visitVarInsn(58, context.var("list_item"));
            Label label10 = new Label();
            Label label11 = new Label();
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label11);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeNull", "()V");
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label10);
            methodVisitor.visitLabel(label11);
            Label label12 = new Label();
            Label label13 = new Label();
            if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                label10 = label10;
                cls2 = cls3;
                label = label12;
                fieldInfo2 = fieldInfo;
            } else {
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label13);
                fieldInfo2 = fieldInfo;
                _getListFieldItemSer(context, methodVisitor, fieldInfo2, cls3);
                cls2 = cls3;
                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                Label label14 = new Label();
                Label label15 = new Label();
                if (context.writeDirect) {
                    String str2 = (context.nonContext && context.writeDirect) ? "writeDirectNonContext" : "write";
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    String str3 = JavaBeanSerializer;
                    methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str3);
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, label14);
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    methodVisitor.visitTypeInsn(192, str3);
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor.visitInsn(1);
                    } else {
                        methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str3, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, label15);
                    methodVisitor.visitLabel(label14);
                }
                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                if (context.nonContext) {
                    methodVisitor.visitInsn(1);
                } else {
                    methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitLabel(label15);
                label = label12;
                methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
            }
            methodVisitor.visitLabel(label13);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            if (context.nonContext) {
                methodVisitor.visitInsn(1);
            } else {
                methodVisitor.visitVarInsn(21, context.var(ContextChain.TAG_INFRA));
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 != null && Modifier.isPublic(cls2.getModifiers())) {
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) collectionItemType)));
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
            methodVisitor.visitLabel(label);
            methodVisitor.visitLabel(label10);
            i = 1;
            methodVisitor.visitIincInsn(context.var(ContextChain.TAG_INFRA), 1);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label7);
            methodVisitor.visitLabel(label9);
            i2 = 25;
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            i3 = Opcodes.INVOKEVIRTUAL;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
        }
        methodVisitor.visitVarInsn(i2, i);
        methodVisitor.visitMethodInsn(i3, JSONSerializer, "popContext", "()V");
        methodVisitor.visitLabel(label6);
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label2);
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (context.writeDirect) {
            return;
        }
        _apply(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        _processKey(methodVisitor, fieldInfo, context);
        _processValue(methodVisitor, fieldInfo, context, label);
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Label label2;
        Label label3;
        String str;
        String format = fieldInfo.getFormat();
        Class<?> cls = fieldInfo.fieldClass;
        Label label4 = new Label();
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, Context.processValue);
        }
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(58, context.var("object"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.isPrimitive2(cls)) {
            label2 = label5;
            label3 = label6;
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label6);
            _getFieldSer(context, methodVisitor, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            String str2 = JavaBeanSerializer;
            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str2);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label7);
            boolean z = (fieldInfo.serialzeFeatures & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
            boolean z2 = (fieldInfo.serialzeFeatures & SerializerFeature.BeanToArray.mask) != 0;
            if (z || (context.nonContext && context.writeDirect)) {
                str = z2 ? "writeAsArrayNonContext" : "writeDirectNonContext";
            } else {
                str = z2 ? "writeAsArray" : "write";
            }
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitTypeInsn(192, str2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            StringBuilder sb = new StringBuilder("(L");
            String str3 = JSONSerializer;
            sb.append(str3);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str, sb.toString());
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label8);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", "(L" + str3 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitLabel(label8);
            label2 = label5;
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
            label3 = label6;
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, Context.processValue);
        }
        if (format != 0) {
            methodVisitor.visitLdcInsn(format);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, Context.fieldName);
            if ((fieldInfo.fieldType instanceof Class) && ((Class) fieldInfo.fieldType).isPrimitive()) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (fieldInfo.fieldClass == String.class) {
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) String.class)));
                } else {
                    methodVisitor.visitVarInsn(25, 0);
                    methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        methodVisitor.visitLabel(label2);
        _seperator(methodVisitor, context);
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (context.writeDirect) {
            return;
        }
        Label label2 = new Label();
        methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
        Class<?> cls = fieldInfo.fieldClass;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long"));
            methodVisitor.visitInsn(9);
            methodVisitor.visitInsn(Opcodes.LCMP);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitInsn(11);
            methodVisitor.visitInsn(Opcodes.FCMPL);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double"));
            methodVisitor.visitInsn(14);
            methodVisitor.visitInsn(Opcodes.DCMPL);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        }
        methodVisitor.visitLabel(label2);
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Label label2 = new Label();
        Class<?> cls = fieldInfo.fieldClass;
        if (cls.isPrimitive()) {
            Label label3 = new Label();
            methodVisitor.visitVarInsn(21, context.var("checkValue"));
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label3);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(58, Context.processValue);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor.visitLabel(label3);
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(Integer.valueOf(context.getFieldOrinal(fieldInfo.name)));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getBeanContext", "(I)" + ASMUtils.desc((Class<?>) BeanContext.class));
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processValue", "(L" + JSONSerializer + ";" + ASMUtils.desc((Class<?>) BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, Context.processValue);
        methodVisitor.visitVarInsn(25, Context.original);
        methodVisitor.visitVarInsn(25, Context.processValue);
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPEQ, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor.visitLabel(label2);
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var(WXBasicComponentType.LIST));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        methodVisitor.visitVarInsn(58, Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0094  */
    /* JADX WARN: Code duplicated, block: B:44:0x0130  */
    private void _if_write_null(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        int i;
        int mask;
        int mask2;
        Class<?> cls = fieldInfo.fieldClass;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label);
        JSONField annotation = fieldInfo.getAnnotation();
        int iOf = annotation != null ? SerializerFeature.of(annotation.serialzeFeatures()) : 0;
        JSONType jSONType = context.beanInfo.jsonType;
        if (jSONType != null) {
            iOf |= SerializerFeature.of(jSONType.serialzeFeatures());
        }
        if (cls == String.class) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullStringAsEmpty.getMask();
        } else if (Number.class.isAssignableFrom(cls)) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullNumberAsZero.getMask();
        } else if (Collection.class.isAssignableFrom(cls)) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullListAsEmpty.getMask();
        } else {
            if (Boolean.class == cls) {
                mask = SerializerFeature.WriteMapNullValue.getMask();
                mask2 = SerializerFeature.WriteNullBooleanAsFalse.getMask();
            } else {
                i = SerializerFeature.WRITE_MAP_NULL_FEATURES;
            }
            if ((iOf & i) == 0) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(Integer.valueOf(i));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
            }
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            _writeFieldName(methodVisitor, context);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(iOf));
            if (cls != String.class || cls == Character.class) {
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
            } else if (Number.class.isAssignableFrom(cls)) {
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
            } else if (cls == Boolean.class) {
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
            } else if (Collection.class.isAssignableFrom(cls) || cls.isArray()) {
                methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
            } else {
                methodVisitor.visitLdcInsn(0);
            }
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeNull", "(II)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLabel(label4);
        }
        i = mask | mask2;
        if ((iOf & i) == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(i));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str2 = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn(Integer.valueOf(iOf));
        if (cls != String.class) {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        } else {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "writeNull", "(II)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label4);
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        String str2 = fieldInfo.name + "_asm_list_item_ser_";
        String str3 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, str, str2, str3);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_list_item_ser_", str3);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str3);
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        String str2 = fieldInfo.name + "_asm_ser_";
        String str3 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, str, str2, str3);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_ser_", str3);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str3);
    }
}
