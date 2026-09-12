package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.taobao.weex.common.Constants;
import io.dcloud.common.DHInterface.IApp;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    public boolean f5kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String strTypeName = jSONType.typeName();
            String strTypeKey = jSONType.typeKey();
            this.typeKey = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.typeName = strTypeName;
            } else {
                this.typeName = cls.getName();
            }
            String[] strArrOrders = jSONType.orders();
            this.orders = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        int i = 0;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i2 = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i2] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i2++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                fieldInfoArr2[i2] = (FieldInfo) it.next();
                i2++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean zIsKotlin = TypeUtils.isKotlin(cls);
            this.f5kotlin = zIsKotlin;
            if (zIsKotlin) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor(null);
                } catch (Throwable unused) {
                }
                Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
                for (int i3 = 0; i3 < this.creatorConstructorParameters.length && i3 < parameterAnnotations.length; i3++) {
                    Annotation[] annotationArr = parameterAnnotations[i3];
                    int length = annotationArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i4];
                        if (annotation instanceof JSONField) {
                            jSONField = (JSONField) annotation;
                            break;
                        }
                        i4++;
                    }
                    if (jSONField != null) {
                        String strName = jSONField.name();
                        if (strName.length() > 0) {
                            this.creatorConstructorParameters[i3] = strName;
                        }
                    }
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i >= typeArr.length) {
                        return;
                    }
                    if (typeArr[i] == this.fields[i].fieldClass) {
                        i++;
                    }
                }
            }
            this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
        }
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        Field field;
        for (FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str) || ((field = fieldInfo.field) != null && fieldInfo.getAnnotation() != null && field.getName().equals(str))) {
                return fieldInfo;
            }
        }
        return null;
    }

    static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.set(size, fieldInfo);
                    return true;
                }
                if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                    return false;
                }
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i])) {
                        map.put(typeParameters[i], map.get(actualTypeArguments[i]));
                    } else {
                        map.put(typeParameters[i], actualTypeArguments[i]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    /* JADX WARN: Code duplicated, block: B:237:0x043e  */
    /* JADX WARN: Code duplicated, block: B:304:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:306:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:307:0x060a  */
    /* JADX WARN: Code duplicated, block: B:317:0x0631  */
    /* JADX WARN: Code duplicated, block: B:345:0x06ed A[PHI: r6 r7 r8
  0x06ed: PHI (r6v16 int) = (r6v15 int), (r6v21 int) binds: [B:338:0x06b3, B:343:0x06d8] A[DONT_GENERATE, DONT_INLINE]
  0x06ed: PHI (r7v7 int) = (r7v6 int), (r7v12 int) binds: [B:338:0x06b3, B:343:0x06d8] A[DONT_GENERATE, DONT_INLINE]
  0x06ed: PHI (r8v20 int) = (r8v19 int), (r8v25 int) binds: [B:338:0x06b3, B:343:0x06d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:353:0x0703  */
    /* JADX WARN: Code duplicated, block: B:356:0x0710  */
    /* JADX WARN: Code duplicated, block: B:358:0x071c  */
    /* JADX WARN: Code duplicated, block: B:360:0x0728  */
    /* JADX WARN: Code duplicated, block: B:363:0x0738  */
    /* JADX WARN: Code duplicated, block: B:393:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:395:0x07dd  */
    /* JADX WARN: Code duplicated, block: B:397:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:399:0x07f9  */
    /* JADX WARN: Code duplicated, block: B:400:0x0803  */
    /* JADX WARN: Code duplicated, block: B:402:0x080a  */
    /* JADX WARN: Code duplicated, block: B:404:0x0810  */
    /* JADX WARN: Code duplicated, block: B:407:0x0838  */
    /* JADX WARN: Code duplicated, block: B:409:0x083c  */
    /* JADX WARN: Code duplicated, block: B:411:0x0846  */
    /* JADX WARN: Code duplicated, block: B:413:0x084c  */
    /* JADX WARN: Code duplicated, block: B:414:0x085b  */
    /* JADX WARN: Code duplicated, block: B:416:0x0879  */
    /* JADX WARN: Code duplicated, block: B:418:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:420:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:425:0x0902  */
    /* JADX WARN: Code duplicated, block: B:427:0x0911  */
    /* JADX WARN: Code duplicated, block: B:458:0x0996  */
    /* JADX WARN: Code duplicated, block: B:460:0x09a0  */
    /* JADX WARN: Code duplicated, block: B:462:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:467:0x09be  */
    /* JADX WARN: Code duplicated, block: B:470:0x09cb A[PHI: r3
  0x09cb: PHI (r3v13 java.lang.String) = (r3v8 java.lang.String), (r3v8 java.lang.String), (r3v14 java.lang.String) binds: [B:459:0x099e, B:468:0x09c8, B:457:0x0991] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:472:0x09cf  */
    /* JADX WARN: Code duplicated, block: B:476:0x09db  */
    /* JADX WARN: Code duplicated, block: B:480:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:483:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:485:0x0a15  */
    /* JADX WARN: Code duplicated, block: B:487:0x0a18 A[LOOP:7: B:486:0x0a16->B:487:0x0a18, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:509:0x08e3 A[EDGE_INSN: B:509:0x08e3->B:423:0x08e3 BREAK  A[LOOP:4: B:302:0x05d8->B:422:0x08cd], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:518:0x0725 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:395:0x07dd, please report this as an issue */
    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2, boolean z3) {
        Constructor<?> defaultConstructor;
        Class<?> cls2;
        PropertyNamingStrategy propertyNamingStrategy2;
        Constructor<?> constructor;
        Class<?> cls3;
        Field[] fieldArr;
        Method[] methodArr;
        char c;
        String str;
        ArrayList arrayList;
        Field field;
        Method[] methodArr2;
        int length;
        int i;
        String str2;
        Type type2;
        Field field2;
        PropertyNamingStrategy propertyNamingStrategy3;
        Field[] fieldArr2;
        Method[] methods;
        int length2;
        int i2;
        Type type3;
        Class<?> superclass;
        Method method;
        String name;
        JSONField jSONField;
        String propertyNameByMethodName;
        Field field3;
        JSONField jSONField2;
        Method[] methodArr3;
        Type type4;
        Method[] methodArr4;
        Method method2;
        Class<?> returnType;
        Class<?>[] parameterTypes;
        int i3;
        int i4;
        Method[] methodArr5;
        Field field4;
        Class<?> cls4;
        JSONField jSONField3;
        char cCharAt;
        Method[] methodArr6;
        ArrayList arrayList2;
        Field[] fieldArr3;
        String propertyNameByMethodName2;
        Field field5;
        JSONField jSONField4;
        JSONField jSONField5;
        Field[] fieldArr4;
        String strSubstring;
        String strDecapitalize;
        String strSubstring2;
        int i5;
        Method method3;
        String str3;
        int iOrdinal;
        int i6;
        int i7;
        int i8;
        String str4;
        StringBuilder sb;
        StringBuilder sb2;
        String str5;
        char cCharAt2;
        Constructor<?> creatorConstructor;
        Method method4;
        String[] strArr;
        String[] strArrLookupParameterNames;
        String[] strArrLookupParameterNames2;
        Class<?>[] clsArr;
        JSONField jSONField6;
        int iOrdinal2;
        int iOf;
        int iOf2;
        JSONField jSONField7;
        String strName;
        int i9;
        int iOf3;
        int iOf4;
        JSONField jSONField8;
        String strName2;
        Field field6;
        int iOrdinal3;
        int iOf5;
        int iOf6;
        Annotation[][] annotationArr;
        Constructor<?> creatorConstructor2;
        PropertyNamingStrategy propertyNamingStrategyNaming;
        Class<?> cls5 = cls;
        JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls5, JSONType.class);
        PropertyNamingStrategy propertyNamingStrategy4 = (jSONType == null || (propertyNamingStrategyNaming = jSONType.naming()) == null || propertyNamingStrategyNaming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : propertyNamingStrategyNaming;
        Class<?> builderClass = getBuilderClass(cls5, jSONType);
        Field[] declaredFields = cls5.getDeclaredFields();
        Method[] methods2 = cls5.getMethods();
        Map<TypeVariable, Type> mapBuildGenericInfo = buildGenericInfo(cls5);
        boolean zIsKotlin = TypeUtils.isKotlin(cls5);
        Constructor<?>[] declaredConstructors = cls5.getDeclaredConstructors();
        if (zIsKotlin && declaredConstructors.length != 1) {
            defaultConstructor = null;
        } else if (builderClass == null) {
            defaultConstructor = getDefaultConstructor(cls5, declaredConstructors);
        } else {
            defaultConstructor = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
        }
        ArrayList arrayList3 = new ArrayList();
        if (z) {
            for (Class<?> superclass2 = cls5; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                computeFields(cls5, type, propertyNamingStrategy4, arrayList3, superclass2.getDeclaredFields());
            }
            if (defaultConstructor != null) {
                TypeUtils.setAccessible(defaultConstructor);
            }
            return new JavaBeanInfo(cls, builderClass, defaultConstructor, null, null, null, jSONType, arrayList3);
        }
        Class<?> cls6 = builderClass;
        Constructor<?> constructor2 = defaultConstructor;
        Method method5 = null;
        Method method6 = null;
        boolean z4 = cls5.isInterface() || Modifier.isAbstract(cls5.getModifiers());
        if ((constructor2 == null && cls6 == null) || z4) {
            Type mixInAnnotations = JSON.getMixInAnnotations(cls5);
            if (!(mixInAnnotations instanceof Class) || (creatorConstructor2 = getCreatorConstructor(((Class) mixInAnnotations).getConstructors())) == null) {
                creatorConstructor = null;
            } else {
                try {
                    creatorConstructor = cls5.getConstructor(creatorConstructor2.getParameterTypes());
                } catch (NoSuchMethodException unused) {
                    creatorConstructor = null;
                }
            }
            if (creatorConstructor == null) {
                creatorConstructor = getCreatorConstructor(declaredConstructors);
            }
            constructor = creatorConstructor;
            if (constructor != null && !z4) {
                TypeUtils.setAccessible(constructor);
                Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                if (parameterTypes2.length > 0) {
                    Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor);
                    int i10 = 0;
                    String[] strArrLookupParameterNames3 = null;
                    while (i10 < parameterTypes2.length && i10 < parameterAnnotations.length) {
                        Annotation[] annotationArr2 = parameterAnnotations[i10];
                        int length3 = annotationArr2.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length3) {
                                jSONField8 = null;
                                break;
                            }
                            Annotation annotation = annotationArr2[i11];
                            if (annotation instanceof JSONField) {
                                jSONField8 = (JSONField) annotation;
                                break;
                            }
                            i11++;
                        }
                        Class<?> cls7 = parameterTypes2[i10];
                        Type type5 = constructor.getGenericParameterTypes()[i10];
                        if (jSONField8 != null) {
                            field6 = TypeUtils.getField(cls5, jSONField8.name(), declaredFields);
                            iOrdinal3 = jSONField8.ordinal();
                            iOf5 = SerializerFeature.of(jSONField8.serialzeFeatures());
                            iOf6 = Feature.of(jSONField8.parseFeatures());
                            strName2 = jSONField8.name();
                        } else {
                            strName2 = null;
                            field6 = null;
                            iOrdinal3 = 0;
                            iOf5 = 0;
                            iOf6 = 0;
                        }
                        if (strName2 == null || strName2.length() == 0) {
                            if (strArrLookupParameterNames3 == null) {
                                strArrLookupParameterNames3 = ASMUtils.lookupParameterNames(constructor);
                            }
                            strName2 = strArrLookupParameterNames3[i10];
                        }
                        if (field6 == null) {
                            if (strArrLookupParameterNames3 == null) {
                                if (zIsKotlin) {
                                    strArrLookupParameterNames3 = TypeUtils.getKoltinConstructorParameters(cls5);
                                } else {
                                    strArrLookupParameterNames3 = ASMUtils.lookupParameterNames(constructor);
                                }
                            }
                            annotationArr = parameterAnnotations;
                            if (strArrLookupParameterNames3.length > i10) {
                                field6 = TypeUtils.getField(cls5, strArrLookupParameterNames3[i10], declaredFields);
                            }
                        } else {
                            annotationArr = parameterAnnotations;
                        }
                        String[] strArr2 = strArrLookupParameterNames3;
                        Class<?> cls8 = cls5;
                        ArrayList arrayList4 = arrayList3;
                        cls5 = cls8;
                        add(arrayList4, new FieldInfo(strName2, cls8, cls7, type5, field6, iOrdinal3, iOf5, iOf6));
                        i10++;
                        arrayList3 = arrayList4;
                        parameterAnnotations = annotationArr;
                        propertyNamingStrategy4 = propertyNamingStrategy4;
                        strArrLookupParameterNames3 = strArr2;
                    }
                }
                propertyNamingStrategy2 = propertyNamingStrategy4;
                cls2 = cls5;
                arrayList3 = arrayList3;
                cls6 = cls6;
            } else {
                arrayList3 = arrayList3;
                propertyNamingStrategy2 = propertyNamingStrategy4;
                char c2 = 1;
                int i12 = 2;
                Method factoryMethod = getFactoryMethod(cls5, methods2, z3);
                if (factoryMethod != null) {
                    TypeUtils.setAccessible(factoryMethod);
                    Class<?>[] parameterTypes3 = factoryMethod.getParameterTypes();
                    if (parameterTypes3.length > 0) {
                        Annotation[][] parameterAnnotations2 = TypeUtils.getParameterAnnotations(factoryMethod);
                        String[] strArrLookupParameterNames4 = null;
                        int i13 = 0;
                        while (i13 < parameterTypes3.length) {
                            Annotation[] annotationArr3 = parameterAnnotations2[i13];
                            int length4 = annotationArr3.length;
                            int i14 = 0;
                            while (true) {
                                if (i14 >= length4) {
                                    jSONField7 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr3[i14];
                                if (annotation2 instanceof JSONField) {
                                    jSONField7 = (JSONField) annotation2;
                                    break;
                                }
                                i14++;
                            }
                            if (jSONField7 == null && (!z3 || !TypeUtils.isJacksonCreator(factoryMethod))) {
                                throw new JSONException("illegal json creator");
                            }
                            if (jSONField7 != null) {
                                strName = jSONField7.name();
                                int iOrdinal4 = jSONField7.ordinal();
                                iOf3 = SerializerFeature.of(jSONField7.serialzeFeatures());
                                iOf4 = Feature.of(jSONField7.parseFeatures());
                                i9 = iOrdinal4;
                            } else {
                                strName = null;
                                i9 = 0;
                                iOf3 = 0;
                                iOf4 = 0;
                            }
                            if (strName == null || strName.length() == 0) {
                                if (strArrLookupParameterNames4 == null) {
                                    strArrLookupParameterNames4 = ASMUtils.lookupParameterNames(factoryMethod);
                                }
                                strName = strArrLookupParameterNames4[i13];
                            }
                            String[] strArr3 = strArrLookupParameterNames4;
                            String str6 = strName;
                            add(arrayList3, new FieldInfo(str6, cls5, parameterTypes3[i13], factoryMethod.getGenericParameterTypes()[i13], TypeUtils.getField(cls5, str6, declaredFields), i9, iOf3, iOf4));
                            i13++;
                            cls5 = cls;
                            strArrLookupParameterNames4 = strArr3;
                            parameterTypes3 = parameterTypes3;
                        }
                        return new JavaBeanInfo(cls, cls6, null, null, factoryMethod, null, jSONType, arrayList3);
                    }
                    method4 = factoryMethod;
                } else {
                    method4 = factoryMethod;
                    if (!z4) {
                        String name2 = cls5.getName();
                        if (zIsKotlin && declaredConstructors.length > 0) {
                            String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls5);
                            Constructor<?> kotlinConstructor = TypeUtils.getKotlinConstructor(declaredConstructors, koltinConstructorParameters);
                            TypeUtils.setAccessible(kotlinConstructor);
                            constructor = kotlinConstructor;
                            strArr = koltinConstructorParameters;
                        } else {
                            int length5 = declaredConstructors.length;
                            String[] strArr4 = null;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= length5) {
                                    strArr = strArr4;
                                    break;
                                }
                                Constructor<?> constructor3 = declaredConstructors[i15];
                                Class<?>[] parameterTypes4 = constructor3.getParameterTypes();
                                if (name2.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                    if (parameterTypes4.length == i12 && parameterTypes4[0] == String.class && parameterTypes4[c2] == String.class) {
                                        constructor3.setAccessible(true);
                                        strArrLookupParameterNames2 = ASMUtils.lookupParameterNames(constructor3);
                                        strArr = strArrLookupParameterNames2;
                                        constructor = constructor3;
                                        break;
                                    }
                                    i15++;
                                    c2 = 1;
                                    i12 = 2;
                                } else if (name2.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                    if (parameterTypes4.length == 3 && parameterTypes4[0] == Object.class && parameterTypes4[1] == Object.class && parameterTypes4[2] == Collection.class) {
                                        constructor3.setAccessible(true);
                                        strArrLookupParameterNames2 = new String[]{"principal", "credentials", "authorities"};
                                        strArr = strArrLookupParameterNames2;
                                        constructor = constructor3;
                                        break;
                                    }
                                    i15++;
                                    c2 = 1;
                                    i12 = 2;
                                } else {
                                    if (name2.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                        if (parameterTypes4.length == 1 && parameterTypes4[0] == String.class) {
                                            strArrLookupParameterNames2 = new String[]{IApp.ConfigProperty.CONFIG_AUTHORITY};
                                            strArr = strArrLookupParameterNames2;
                                            constructor = constructor3;
                                            break;
                                        }
                                    } else if (((constructor3.getModifiers() & 1) != 0) && (strArrLookupParameterNames = ASMUtils.lookupParameterNames(constructor3)) != null && strArrLookupParameterNames.length != 0 && (constructor == null || strArr4 == null || strArrLookupParameterNames.length > strArr4.length)) {
                                        constructor = constructor3;
                                        strArr4 = strArrLookupParameterNames;
                                    }
                                    i15++;
                                    c2 = 1;
                                    i12 = 2;
                                }
                            }
                        }
                        Class<?>[] parameterTypes5 = strArr != null ? constructor.getParameterTypes() : null;
                        if (strArr != null && parameterTypes5.length == strArr.length) {
                            Annotation[][] parameterAnnotations3 = TypeUtils.getParameterAnnotations(constructor);
                            int i16 = 0;
                            while (i16 < parameterTypes5.length) {
                                Annotation[] annotationArr4 = parameterAnnotations3[i16];
                                String str7 = strArr[i16];
                                int length6 = annotationArr4.length;
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= length6) {
                                        clsArr = parameterTypes5;
                                        jSONField6 = null;
                                        break;
                                    }
                                    Annotation annotation3 = annotationArr4[i17];
                                    clsArr = parameterTypes5;
                                    if (annotation3 instanceof JSONField) {
                                        jSONField6 = (JSONField) annotation3;
                                        break;
                                    }
                                    i17++;
                                    parameterTypes5 = clsArr;
                                }
                                Class<?> cls9 = clsArr[i16];
                                Type type6 = constructor.getGenericParameterTypes()[i16];
                                Field field7 = TypeUtils.getField(cls5, str7, declaredFields);
                                if (field7 != null && jSONField6 == null) {
                                    jSONField6 = (JSONField) TypeUtils.getAnnotation(field7, JSONField.class);
                                }
                                if (jSONField6 == null) {
                                    if ("org.springframework.security.core.userdetails.User".equals(name2) && Constants.Value.PASSWORD.equals(str7)) {
                                        iOf2 = Feature.InitStringFieldAsEmpty.mask;
                                        iOrdinal2 = 0;
                                    } else {
                                        iOrdinal2 = 0;
                                        iOf2 = 0;
                                    }
                                    iOf = 0;
                                } else {
                                    String strName3 = jSONField6.name();
                                    if (strName3.length() != 0) {
                                        str7 = strName3;
                                    }
                                    iOrdinal2 = jSONField6.ordinal();
                                    iOf = SerializerFeature.of(jSONField6.serialzeFeatures());
                                    iOf2 = Feature.of(jSONField6.parseFeatures());
                                    type6 = type6;
                                }
                                add(arrayList3, new FieldInfo(str7, cls, cls9, type6, field7, iOrdinal2, iOf, iOf2));
                                i16++;
                                cls5 = cls;
                                name2 = name2;
                                parameterTypes5 = clsArr;
                            }
                            if (!zIsKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                return new JavaBeanInfo(cls, cls6, null, constructor, null, null, jSONType, arrayList3);
                            }
                            cls2 = cls;
                            constructor = constructor;
                        } else {
                            throw new JSONException("default constructor not found. " + cls5);
                        }
                    }
                    method5 = method4;
                }
                cls2 = cls5;
                method5 = method4;
            }
        } else {
            cls2 = cls5;
            propertyNamingStrategy2 = propertyNamingStrategy4;
            cls6 = cls6;
            constructor = null;
        }
        if (constructor2 != null) {
            TypeUtils.setAccessible(constructor2);
        }
        String str8 = "set";
        if (cls6 == null) {
            cls3 = cls6;
            fieldArr = declaredFields;
            methodArr = methods2;
            c = 0;
            str = "set";
            arrayList = arrayList3;
        } else {
            JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls6, JSONPOJOBuilder.class);
            String strWithPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
            if (strWithPrefix == null) {
                strWithPrefix = "with";
            }
            Method[] methods3 = cls6.getMethods();
            int length7 = methods3.length;
            int i18 = 0;
            while (i18 < length7) {
                String str9 = strWithPrefix;
                Method method7 = methods3[i18];
                if (!Modifier.isStatic(method7.getModifiers()) && method7.getReturnType().equals(cls6)) {
                    JSONField superMethodAnnotation = (JSONField) TypeUtils.getAnnotation(method7, JSONField.class);
                    if (superMethodAnnotation == null) {
                        superMethodAnnotation = TypeUtils.getSuperMethodAnnotation(cls2, method7);
                    }
                    if (superMethodAnnotation == null) {
                        str3 = str9;
                        iOrdinal = 0;
                        i6 = 0;
                        i7 = 0;
                        i8 = 0;
                    } else if (superMethodAnnotation.deserialize()) {
                        iOrdinal = superMethodAnnotation.ordinal();
                        int iOf7 = SerializerFeature.of(superMethodAnnotation.serialzeFeatures());
                        int iOf8 = Feature.of(superMethodAnnotation.parseFeatures());
                        if (superMethodAnnotation.name().length() != 0) {
                            str5 = str9;
                            methods3 = methods3;
                            cls6 = cls6;
                            declaredFields = declaredFields;
                            methods2 = methods2;
                            str8 = str8;
                            i18 = i18;
                            arrayList3 = arrayList3;
                            length7 = length7;
                            add(arrayList3, new FieldInfo(superMethodAnnotation.name(), method7, null, cls, type, iOrdinal, iOf7, iOf8, superMethodAnnotation, null, null, mapBuildGenericInfo));
                        } else {
                            str3 = str9;
                            i6 = iOf7;
                            i7 = iOf8;
                            i8 = 0;
                        }
                    } else {
                        methods3 = methods3;
                        length7 = length7;
                        i18 = i18;
                        str5 = str9;
                        cls6 = cls6;
                        declaredFields = declaredFields;
                        methods2 = methods2;
                        str8 = str8;
                        arrayList3 = arrayList3;
                    }
                    String name3 = method7.getName();
                    if (name3.startsWith(str8) && name3.length() > 3) {
                        sb2 = new StringBuilder(name3.substring(3));
                    } else {
                        if (str3.length() == 0) {
                            sb2 = new StringBuilder(name3);
                        } else {
                            str4 = str3;
                            if (name3.startsWith(str4) && name3.length() > str4.length()) {
                                sb = new StringBuilder(name3.substring(str4.length()));
                                cCharAt2 = sb.charAt(i8);
                                if (str4.length() != 0 || Character.isUpperCase(cCharAt2)) {
                                    sb.setCharAt(i8, Character.toLowerCase(cCharAt2));
                                    str5 = str4;
                                    add(arrayList3, new FieldInfo(sb.toString(), method7, null, cls, type, iOrdinal, i6, i7, superMethodAnnotation, null, null, mapBuildGenericInfo));
                                }
                            }
                        }
                        str5 = str4;
                    }
                    sb = sb2;
                    str4 = str3;
                    cCharAt2 = sb.charAt(i8);
                    if (str4.length() != 0) {
                    }
                    sb.setCharAt(i8, Character.toLowerCase(cCharAt2));
                    str5 = str4;
                    add(arrayList3, new FieldInfo(sb.toString(), method7, null, cls, type, iOrdinal, i6, i7, superMethodAnnotation, null, null, mapBuildGenericInfo));
                } else {
                    methods3 = methods3;
                    length7 = length7;
                    i18 = i18;
                    str5 = str9;
                    cls6 = cls6;
                    declaredFields = declaredFields;
                    methods2 = methods2;
                    str8 = str8;
                    arrayList3 = arrayList3;
                }
                i18++;
                cls2 = cls;
                cls6 = cls6;
                arrayList3 = arrayList3;
                str8 = str8;
                length7 = length7;
                strWithPrefix = str5;
                methods3 = methods3;
                declaredFields = declaredFields;
                methods2 = methods2;
            }
            Class<?> cls10 = cls6;
            fieldArr = declaredFields;
            methodArr = methods2;
            c = 0;
            str = str8;
            arrayList = arrayList3;
            if (cls10 != null) {
                cls3 = cls10;
                JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls3, JSONPOJOBuilder.class);
                String strBuildMethod = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
                if (strBuildMethod == null || strBuildMethod.length() == 0) {
                    strBuildMethod = "build";
                }
                field = null;
                try {
                    method3 = cls3.getMethod(strBuildMethod, null);
                } catch (NoSuchMethodException | SecurityException unused2) {
                    method3 = null;
                }
                if (method3 == null) {
                    try {
                        method3 = cls3.getMethod("create", null);
                    } catch (NoSuchMethodException | SecurityException unused3) {
                    }
                }
                if (method3 == null) {
                    throw new JSONException("buildMethod not found.");
                }
                TypeUtils.setAccessible(method3);
                method6 = method3;
            } else {
                cls3 = cls10;
            }
            methodArr2 = methodArr;
            length = methodArr2.length;
            i = 0;
            while (true) {
                str2 = "get";
                if (i < length) {
                    break;
                }
                methodArr4 = methodArr2;
                method2 = methodArr4[i];
                String name4 = method2.getName();
                if (Modifier.isStatic(method2.getModifiers())) {
                    field4 = field;
                    cls4 = cls3;
                    i3 = length;
                    i4 = i;
                    methodArr6 = methodArr4;
                    fieldArr3 = fieldArr;
                } else {
                    returnType = method2.getReturnType();
                    if ((!returnType.equals(Void.TYPE) || returnType.equals(method2.getDeclaringClass())) && method2.getDeclaringClass() != Object.class) {
                        parameterTypes = method2.getParameterTypes();
                        if (parameterTypes.length != 0 || parameterTypes.length > 2) {
                            field4 = field;
                            cls4 = cls3;
                            i3 = length;
                            i4 = i;
                            methodArr6 = methodArr4;
                            fieldArr3 = fieldArr;
                        } else {
                            JSONField superMethodAnnotation2 = (JSONField) TypeUtils.getAnnotation(method2, JSONField.class);
                            int iOf9 = 0;
                            if (superMethodAnnotation2 != null && parameterTypes.length == 2 && parameterTypes[c] == String.class && parameterTypes[1] == Object.class) {
                                i4 = i;
                                i3 = length;
                                methodArr5 = methodArr4;
                                field4 = null;
                                cls4 = cls3;
                                add(arrayList, new FieldInfo("", method2, null, cls, type, 0, 0, 0, superMethodAnnotation2, null, null, mapBuildGenericInfo));
                            } else {
                                i3 = length;
                                i4 = i;
                                methodArr5 = methodArr4;
                                int iOrdinal5 = 0;
                                int iOf10 = 0;
                                field4 = null;
                                cls4 = cls3;
                                if (parameterTypes.length == 1) {
                                    if (superMethodAnnotation2 == null) {
                                        superMethodAnnotation2 = TypeUtils.getSuperMethodAnnotation(cls, method2);
                                    }
                                    if (superMethodAnnotation2 != null || name4.length() >= 4) {
                                        if (superMethodAnnotation2 != null) {
                                            if (superMethodAnnotation2.deserialize()) {
                                                iOrdinal5 = superMethodAnnotation2.ordinal();
                                                iOf10 = SerializerFeature.of(superMethodAnnotation2.serialzeFeatures());
                                                iOf9 = Feature.of(superMethodAnnotation2.parseFeatures());
                                                if (superMethodAnnotation2.name().length() != 0) {
                                                    add(arrayList, new FieldInfo(superMethodAnnotation2.name(), method2, null, cls, type, iOrdinal5, iOf10, iOf9, superMethodAnnotation2, null, null, mapBuildGenericInfo));
                                                } else {
                                                    jSONField3 = superMethodAnnotation2;
                                                    if (jSONField3 == null) {
                                                        cCharAt = name4.charAt(3);
                                                        if (zIsKotlin) {
                                                            arrayList2 = new ArrayList();
                                                            methodArr6 = methodArr5;
                                                            for (i5 = 0; i5 < methodArr6.length; i5++) {
                                                                if (methodArr6[i5].getName().startsWith("get")) {
                                                                    arrayList2.add(methodArr6[i5].getName());
                                                                }
                                                            }
                                                        } else {
                                                            methodArr6 = methodArr5;
                                                            arrayList2 = null;
                                                        }
                                                        if (Character.isUpperCase(cCharAt)) {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    } else {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        } else {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    } else {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        }
                                                    } else {
                                                        cCharAt = name4.charAt(3);
                                                        if (zIsKotlin) {
                                                            arrayList2 = new ArrayList();
                                                            methodArr6 = methodArr5;
                                                            while (i5 < methodArr6.length) {
                                                                if (methodArr6[i5].getName().startsWith("get")) {
                                                                    arrayList2.add(methodArr6[i5].getName());
                                                                }
                                                            }
                                                        } else {
                                                            methodArr6 = methodArr5;
                                                            arrayList2 = null;
                                                        }
                                                        if (Character.isUpperCase(cCharAt)) {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    } else {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        } else {
                                                            fieldArr3 = fieldArr;
                                                            if (zIsKotlin) {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                            } else if (TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name4);
                                                            }
                                                            field5 = null;
                                                            if (field5 == null) {
                                                                field5 = TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                            }
                                                            if (field5 != null) {
                                                            }
                                                            if (field5 != null) {
                                                                jSONField5 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                                                if (jSONField5 != null) {
                                                                    if (jSONField5.deserialize()) {
                                                                        methodArr6 = methodArr6;
                                                                        fieldArr3 = fieldArr3;
                                                                    } else {
                                                                        iOrdinal5 = jSONField5.ordinal();
                                                                        iOf10 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                        iOf9 = Feature.of(jSONField5.parseFeatures());
                                                                        if (jSONField5.name().length() != 0) {
                                                                            methodArr6 = methodArr6;
                                                                            fieldArr3 = fieldArr3;
                                                                            add(arrayList, new FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                        }
                                                                    }
                                                                }
                                                                jSONField4 = jSONField5;
                                                            } else {
                                                                jSONField4 = null;
                                                            }
                                                            if (propertyNamingStrategy2 != null) {
                                                                propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                            }
                                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            jSONField3 = superMethodAnnotation2;
                                            if ((jSONField3 == null || name4.startsWith(str)) && cls4 == null) {
                                                cCharAt = name4.charAt(3);
                                                if (zIsKotlin) {
                                                    arrayList2 = new ArrayList();
                                                    methodArr6 = methodArr5;
                                                    while (i5 < methodArr6.length) {
                                                        if (methodArr6[i5].getName().startsWith("get")) {
                                                            arrayList2.add(methodArr6[i5].getName());
                                                        }
                                                    }
                                                } else {
                                                    methodArr6 = methodArr5;
                                                    arrayList2 = null;
                                                }
                                                if (!Character.isUpperCase(cCharAt) || cCharAt > 512) {
                                                    fieldArr3 = fieldArr;
                                                    if (zIsKotlin) {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                                    } else if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name4);
                                                    }
                                                } else {
                                                    if (cCharAt != '_') {
                                                        fieldArr4 = fieldArr;
                                                        if (cCharAt == 'f') {
                                                            strDecapitalize = name4.substring(3);
                                                        } else if (name4.length() >= 5 && Character.isUpperCase(name4.charAt(4))) {
                                                            strDecapitalize = TypeUtils.decapitalize(name4.substring(3));
                                                        } else {
                                                            strSubstring = name4.substring(3);
                                                            field5 = TypeUtils.getField(cls, strSubstring, fieldArr4);
                                                            if (field5 == null) {
                                                                methodArr6 = methodArr6;
                                                                fieldArr3 = fieldArr4;
                                                            }
                                                        }
                                                        propertyNameByMethodName2 = strDecapitalize;
                                                        fieldArr3 = fieldArr4;
                                                    } else if (zIsKotlin) {
                                                        strSubstring = arrayList2.contains("g" + name4.substring(1)) ? name4.substring(3) : "is" + name4.substring(3);
                                                        fieldArr4 = fieldArr;
                                                        field5 = TypeUtils.getField(cls, strSubstring, fieldArr4);
                                                    } else {
                                                        fieldArr4 = fieldArr;
                                                        strSubstring = name4.substring(4);
                                                        field5 = TypeUtils.getField(cls, strSubstring, fieldArr4);
                                                        if (field5 == null && (field5 = TypeUtils.getField(cls, (strSubstring2 = name4.substring(3)), fieldArr4)) != null) {
                                                            strSubstring = strSubstring2;
                                                        }
                                                    }
                                                    propertyNameByMethodName2 = strSubstring;
                                                    fieldArr3 = fieldArr4;
                                                    if (field5 == null) {
                                                        field5 = TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                    }
                                                    if (field5 != null && parameterTypes[0] == Boolean.TYPE) {
                                                        field5 = TypeUtils.getField(cls, "is" + Character.toUpperCase(propertyNameByMethodName2.charAt(0)) + propertyNameByMethodName2.substring(1), fieldArr3);
                                                    }
                                                    if (field5 != null) {
                                                        jSONField5 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                                        if (jSONField5 != null) {
                                                            if (jSONField5.deserialize()) {
                                                                methodArr6 = methodArr6;
                                                                fieldArr3 = fieldArr3;
                                                            } else {
                                                                iOrdinal5 = jSONField5.ordinal();
                                                                iOf10 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                                iOf9 = Feature.of(jSONField5.parseFeatures());
                                                                if (jSONField5.name().length() != 0) {
                                                                    methodArr6 = methodArr6;
                                                                    fieldArr3 = fieldArr3;
                                                                    add(arrayList, new FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                                }
                                                            }
                                                        }
                                                        jSONField4 = jSONField5;
                                                    } else {
                                                        jSONField4 = null;
                                                    }
                                                    if (propertyNamingStrategy2 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                    }
                                                    add(arrayList, new FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                                }
                                                field5 = null;
                                                if (field5 == null) {
                                                    field5 = TypeUtils.getField(cls, propertyNameByMethodName2, fieldArr3);
                                                }
                                                if (field5 != null) {
                                                }
                                                if (field5 != null) {
                                                    jSONField5 = (JSONField) TypeUtils.getAnnotation(field5, JSONField.class);
                                                    if (jSONField5 != null) {
                                                        if (jSONField5.deserialize()) {
                                                            methodArr6 = methodArr6;
                                                            fieldArr3 = fieldArr3;
                                                        } else {
                                                            iOrdinal5 = jSONField5.ordinal();
                                                            iOf10 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                            iOf9 = Feature.of(jSONField5.parseFeatures());
                                                            if (jSONField5.name().length() != 0) {
                                                                methodArr6 = methodArr6;
                                                                fieldArr3 = fieldArr3;
                                                                add(arrayList, new FieldInfo(jSONField5.name(), method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField5, null, mapBuildGenericInfo));
                                                            }
                                                        }
                                                    }
                                                    jSONField4 = jSONField5;
                                                } else {
                                                    jSONField4 = null;
                                                }
                                                if (propertyNamingStrategy2 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy2.translate(propertyNameByMethodName2);
                                                }
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method2, field5, cls, type, iOrdinal5, iOf10, iOf9, jSONField3, jSONField4, null, mapBuildGenericInfo));
                                            }
                                        }
                                    }
                                }
                            }
                            methodArr6 = methodArr5;
                            fieldArr3 = fieldArr;
                        }
                    } else {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    }
                }
                methodArr2 = methodArr6;
                i = i4 + 1;
                fieldArr = fieldArr3;
                propertyNamingStrategy2 = propertyNamingStrategy2;
                cls3 = cls4;
                length = i3;
                field = field4;
                c = 0;
                str = str;
            }
            type2 = type;
            field2 = field;
            Class<?> cls11 = cls3;
            propertyNamingStrategy3 = propertyNamingStrategy2;
            fieldArr2 = fieldArr;
            computeFields(cls, type2, propertyNamingStrategy3, arrayList, cls.getFields());
            methods = cls.getMethods();
            length2 = methods.length;
            i2 = 0;
            while (i2 < length2) {
                int i19 = i2;
                method = methods[i19];
                name = method.getName();
                if (name.length() < 4 && !Modifier.isStatic(method.getModifiers()) && cls11 == null && name.startsWith(str2) && Character.isUpperCase(name.charAt(3)) && method.getParameterTypes().length == 0 && ((Collection.class.isAssignableFrom(method.getReturnType()) || Map.class.isAssignableFrom(method.getReturnType()) || AtomicBoolean.class == method.getReturnType() || AtomicInteger.class == method.getReturnType() || AtomicLong.class == method.getReturnType()) && ((jSONField = (JSONField) TypeUtils.getAnnotation(method, JSONField.class)) == null || !jSONField.deserialize()))) {
                    if (jSONField == null && jSONField.name().length() > 0) {
                        propertyNameByMethodName = jSONField.name();
                    } else {
                        propertyNameByMethodName = TypeUtils.getPropertyNameByMethodName(name);
                        field3 = TypeUtils.getField(cls, propertyNameByMethodName, fieldArr2);
                        if (field3 != null) {
                            jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, JSONField.class);
                            if (jSONField2 != null || jSONField2.deserialize()) {
                                if (!Collection.class.isAssignableFrom(method.getReturnType()) && !Map.class.isAssignableFrom(method.getReturnType())) {
                                }
                                if (propertyNamingStrategy3 != null) {
                                    propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                                }
                                if (getField(arrayList, propertyNameByMethodName) == null) {
                                    methodArr3 = methods;
                                    type4 = type;
                                    add(arrayList, new FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                                }
                            }
                        }
                        methodArr3 = methods;
                        type4 = type2;
                    }
                    field3 = field2;
                    if (propertyNamingStrategy3 != null) {
                        propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                    }
                    if (getField(arrayList, propertyNameByMethodName) == null) {
                        methodArr3 = methods;
                        type4 = type2;
                    } else {
                        methodArr3 = methods;
                        type4 = type;
                        add(arrayList, new FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                    }
                } else {
                    methodArr3 = methods;
                    type4 = type2;
                }
                i2 = i19 + 1;
                type2 = type4;
                length2 = length2;
                methods = methodArr3;
                str2 = str2;
            }
            type3 = type2;
            if (arrayList.size() == 0) {
                if (TypeUtils.isXmlField(cls) ? true : z) {
                    for (superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        computeFields(cls, type3, propertyNamingStrategy3, arrayList, fieldArr2);
                    }
                }
            }
            return new JavaBeanInfo(cls, cls11, constructor2, constructor, method5, method6, jSONType, arrayList);
        }
        field = null;
        methodArr2 = methodArr;
        length = methodArr2.length;
        i = 0;
        while (true) {
            str2 = "get";
            if (i < length) {
                break;
                break;
            }
            methodArr4 = methodArr2;
            method2 = methodArr4[i];
            String name5 = method2.getName();
            if (Modifier.isStatic(method2.getModifiers())) {
                field4 = field;
                cls4 = cls3;
                i3 = length;
                i4 = i;
                methodArr6 = methodArr4;
                fieldArr3 = fieldArr;
            } else {
                returnType = method2.getReturnType();
                if (returnType.equals(Void.TYPE)) {
                    parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length != 0) {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    } else {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    }
                } else {
                    parameterTypes = method2.getParameterTypes();
                    if (parameterTypes.length != 0) {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    } else {
                        field4 = field;
                        cls4 = cls3;
                        i3 = length;
                        i4 = i;
                        methodArr6 = methodArr4;
                        fieldArr3 = fieldArr;
                    }
                }
            }
            methodArr2 = methodArr6;
            i = i4 + 1;
            fieldArr = fieldArr3;
            propertyNamingStrategy2 = propertyNamingStrategy2;
            cls3 = cls4;
            length = i3;
            field = field4;
            c = 0;
            str = str;
        }
        type2 = type;
        field2 = field;
        Class<?> cls12 = cls3;
        propertyNamingStrategy3 = propertyNamingStrategy2;
        fieldArr2 = fieldArr;
        computeFields(cls, type2, propertyNamingStrategy3, arrayList, cls.getFields());
        methods = cls.getMethods();
        length2 = methods.length;
        i2 = 0;
        while (i2 < length2) {
            int i110 = i2;
            method = methods[i110];
            name = method.getName();
            if (name.length() < 4) {
                methodArr3 = methods;
                type4 = type2;
            } else {
                if (jSONField == null) {
                    propertyNameByMethodName = TypeUtils.getPropertyNameByMethodName(name);
                    field3 = TypeUtils.getField(cls, propertyNameByMethodName, fieldArr2);
                    if (field3 != null) {
                        jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, JSONField.class);
                        if (jSONField2 != null) {
                        }
                        if (!Collection.class.isAssignableFrom(method.getReturnType())) {
                            field3 = field2;
                        }
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    } else {
                        field3 = field2;
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    }
                } else {
                    propertyNameByMethodName = TypeUtils.getPropertyNameByMethodName(name);
                    field3 = TypeUtils.getField(cls, propertyNameByMethodName, fieldArr2);
                    if (field3 != null) {
                        jSONField2 = (JSONField) TypeUtils.getAnnotation(field3, JSONField.class);
                        if (jSONField2 != null) {
                        }
                        if (!Collection.class.isAssignableFrom(method.getReturnType())) {
                            field3 = field2;
                        }
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    } else {
                        field3 = field2;
                        if (propertyNamingStrategy3 != null) {
                            propertyNameByMethodName = propertyNamingStrategy3.translate(propertyNameByMethodName);
                        }
                        if (getField(arrayList, propertyNameByMethodName) == null) {
                            methodArr3 = methods;
                            type4 = type;
                            add(arrayList, new FieldInfo(propertyNameByMethodName, method, field3, cls, type4, 0, 0, 0, jSONField, null, null, mapBuildGenericInfo));
                        }
                    }
                }
                methodArr3 = methods;
                type4 = type2;
            }
            i2 = i110 + 1;
            type2 = type4;
            length2 = length2;
            methods = methodArr3;
            str2 = str2;
        }
        type3 = type2;
        if (arrayList.size() == 0) {
            if (TypeUtils.isXmlField(cls) ? true : z) {
                while (superclass != null) {
                    computeFields(cls, type3, propertyNamingStrategy3, arrayList, fieldArr2);
                }
            }
        }
        return new JavaBeanInfo(cls, cls12, constructor2, constructor, method5, method6, jSONType, arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x007a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:43:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:1: B:20:0x0052->B:45:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x0018  */
    private static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        Iterator<FieldInfo> it;
        String name;
        JSONField jSONField;
        int i;
        int i2;
        int i3;
        int i4;
        Map<TypeVariable, Type> mapBuildGenericInfo = buildGenericInfo(cls);
        int length = fieldArr.length;
        int i5 = 0;
        while (i5 < length) {
            Field field = fieldArr[i5];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) != 0) {
                i4 = i5;
                break;
                break;
            }
            if ((modifiers & 16) != 0) {
                Class<?> type2 = field.getType();
                if (!Map.class.isAssignableFrom(type2) && !Collection.class.isAssignableFrom(type2) && !AtomicLong.class.equals(type2) && !AtomicInteger.class.equals(type2) && !AtomicBoolean.class.equals(type2)) {
                    i4 = i5;
                    break;
                    break;
                }
                it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().name.equals(field.getName())) {
                        }
                    } else {
                        name = field.getName();
                        jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                        if (jSONField != null) {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                        } else if (!jSONField.deserialize()) {
                            int iOrdinal = jSONField.ordinal();
                            int iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                            int iOf2 = Feature.of(jSONField.parseFeatures());
                            if (jSONField.name().length() != 0) {
                                name = jSONField.name();
                            }
                            i = iOrdinal;
                            i2 = iOf;
                            i3 = iOf2;
                        }
                        if (propertyNamingStrategy != null) {
                            name = propertyNamingStrategy.translate(name);
                        }
                        i4 = i5;
                        add(list, new FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null, mapBuildGenericInfo));
                        break;
                    }
                    i4 = i5;
                    break;
                }
            }
            it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().name.equals(field.getName())) {
                    }
                } else {
                    name = field.getName();
                    jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                    if (jSONField != null) {
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                    } else if (!jSONField.deserialize()) {
                        int iOrdinal2 = jSONField.ordinal();
                        int iOf3 = SerializerFeature.of(jSONField.serialzeFeatures());
                        int iOf4 = Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        i = iOrdinal2;
                        i2 = iOf3;
                        i3 = iOf4;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    i4 = i5;
                    add(list, new FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null, mapBuildGenericInfo));
                    break;
                    break;
                }
                i4 = i5;
                break;
                break;
            }
            i5 = i4 + 1;
        }
    }

    static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (Constructor<?> constructor2 : constructorArr) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            for (Constructor<?> constructor3 : constructorArr) {
                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    return constructor3;
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        if (constructor != null) {
                            throw new JSONException("multi-JSONCreator");
                        }
                        constructor = constructor3;
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i];
                    int length2 = annotationArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        if (annotationArr[i2] instanceof JSONField) {
                            break;
                        }
                        i2++;
                    }
                    i++;
                }
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method == null && z) {
            for (Method method3 : methodArr) {
                if (TypeUtils.isJacksonCreator(method3)) {
                    return method3;
                }
            }
        }
        return method;
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass(null, jSONType);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (clsBuilder = jSONType.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }
}
