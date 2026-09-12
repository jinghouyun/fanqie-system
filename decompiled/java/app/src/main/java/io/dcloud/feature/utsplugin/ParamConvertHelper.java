package io.dcloud.feature.utsplugin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.JSCallback;
import io.dcloud.uts.UTSArray;
import io.dcloud.uts.UTSCallback;
import io.dcloud.uts.UTSJSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: ParamConvertHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u00108\u001a\u0004\u0018\u00010\u00012\b\u00109\u001a\u0004\u0018\u00010\u0001R\u0014\u0010\r\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010$\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00105\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017¨\u0006;"}, d2 = {"Lio/dcloud/feature/utsplugin/ParamConvertHelper;", "", "classTypeName", "", "actualTypeArguments", "", "Ljava/lang/reflect/Type;", "hostCallback", "Lcom/taobao/weex/bridge/JSCallback;", "isKeepAlive", "", "<init>", "(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;Z)V", "UTSCallbackType", "getUTSCallbackType", "()Ljava/lang/String;", "UTSObjectType", "getUTSObjectType", "StringClassFlag", "getStringClassFlag", "isUTSCallback", "()Z", "setUTSCallback", "(Z)V", "isUTSObject", "setUTSObject", "isPrimitive", "setPrimitive", "isListType", "setListType", "isUTSArray", "setUTSArray", "isMapType", "setMapType", "isAnyType", "setAnyType", "mHostCallback", "getMHostCallback", "()Lcom/taobao/weex/bridge/JSCallback;", "setMHostCallback", "(Lcom/taobao/weex/bridge/JSCallback;)V", "tClass", "Ljava/lang/Class;", "getTClass", "()Ljava/lang/Class;", "setTClass", "(Ljava/lang/Class;)V", "hostTypeArguments", "getHostTypeArguments", "()[Ljava/lang/reflect/Type;", "setHostTypeArguments", "([Ljava/lang/reflect/Type;)V", "[Ljava/lang/reflect/Type;", "mIsKeepAlive", "getMIsKeepAlive", "setMIsKeepAlive", "getInstance", "value", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ParamConvertHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String StringClassFlag;
    private final String UTSCallbackType;
    private final String UTSObjectType;
    private Type[] hostTypeArguments;
    private boolean isAnyType;
    private boolean isListType;
    private boolean isMapType;
    private boolean isPrimitive;
    private boolean isUTSArray;
    private boolean isUTSCallback;
    private boolean isUTSObject;
    private JSCallback mHostCallback;
    private boolean mIsKeepAlive;
    private Class<?> tClass;

    /* JADX INFO: compiled from: ParamConvertHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;", "", "<init>", "()V", "typeNameCompat", "", "type", "Ljava/lang/reflect/Type;", "isPrimitiveType", "", "classTypeName", "isListType", "isUTSArray", "isMapType", "isAnyType", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String typeNameCompat(Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof Class) {
                String name = ((Class) type).getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                return name;
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(...)");
                String strTypeNameCompat = typeNameCompat(rawType);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
                return strTypeNameCompat + Typography.less + ArraysKt.joinToString$default(actualTypeArguments, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: io.dcloud.feature.utsplugin.ParamConvertHelper$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public final Object invoke2(Object obj) {
                        return ParamConvertHelper.Companion.typeNameCompat$lambda$0((Type) obj);
                    }
                }, 30, (Object) null) + Typography.greater;
            }
            return type.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence typeNameCompat$lambda$0(Type type) {
            Companion companion = ParamConvertHelper.INSTANCE;
            Intrinsics.checkNotNull(type);
            return companion.typeNameCompat(type);
        }

        public final boolean isPrimitiveType(String classTypeName) {
            Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return Intrinsics.areEqual("int", classTypeName) || Intrinsics.areEqual("byte", classTypeName) || Intrinsics.areEqual("float", classTypeName) || Intrinsics.areEqual("double", classTypeName) || Intrinsics.areEqual("short", classTypeName) || Intrinsics.areEqual("kotlin.Int", classTypeName) || Intrinsics.areEqual("kotlin.Long", classTypeName) || Intrinsics.areEqual("kotlin.Double", classTypeName) || Intrinsics.areEqual("kotlin.Float", classTypeName) || Intrinsics.areEqual("kotlin.Byte", classTypeName) || Intrinsics.areEqual("kotlin.String", classTypeName) || Intrinsics.areEqual("java.lang.Number", classTypeName) || Intrinsics.areEqual("java.lang.String", classTypeName) || Intrinsics.areEqual("java.lang.Boolean", classTypeName) || Intrinsics.areEqual("java.lang.Byte", classTypeName) || Intrinsics.areEqual("boolean", classTypeName) || Intrinsics.areEqual("long", classTypeName);
        }

        public final boolean isListType(String classTypeName) {
            Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return StringsKt.startsWith$default(classTypeName, "java.util.List", false, 2, (Object) null);
        }

        public final boolean isUTSArray(String classTypeName) {
            Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return StringsKt.startsWith$default(classTypeName, "io.dcloud.uts.UTSArray", false, 2, (Object) null);
        }

        public final boolean isMapType(String classTypeName) {
            Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return Intrinsics.areEqual(classTypeName, "java.util.LinkedHashMap") || Intrinsics.areEqual(classTypeName, "io.dcloud.uts.Map");
        }

        public final boolean isAnyType(String classTypeName) {
            Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return Intrinsics.areEqual(classTypeName, "java.lang.Object") || Intrinsics.areEqual(classTypeName, "kotlin.Any");
        }
    }

    public final String getUTSCallbackType() {
        return this.UTSCallbackType;
    }

    public final String getUTSObjectType() {
        return this.UTSObjectType;
    }

    public final String getStringClassFlag() {
        return this.StringClassFlag;
    }

    /* JADX INFO: renamed from: isUTSCallback, reason: from getter */
    public final boolean getIsUTSCallback() {
        return this.isUTSCallback;
    }

    public final void setUTSCallback(boolean z) {
        this.isUTSCallback = z;
    }

    /* JADX INFO: renamed from: isUTSObject, reason: from getter */
    public final boolean getIsUTSObject() {
        return this.isUTSObject;
    }

    public final void setUTSObject(boolean z) {
        this.isUTSObject = z;
    }

    /* JADX INFO: renamed from: isPrimitive, reason: from getter */
    public final boolean getIsPrimitive() {
        return this.isPrimitive;
    }

    public final void setPrimitive(boolean z) {
        this.isPrimitive = z;
    }

    /* JADX INFO: renamed from: isListType, reason: from getter */
    public final boolean getIsListType() {
        return this.isListType;
    }

    public final void setListType(boolean z) {
        this.isListType = z;
    }

    /* JADX INFO: renamed from: isUTSArray, reason: from getter */
    public final boolean getIsUTSArray() {
        return this.isUTSArray;
    }

    public final void setUTSArray(boolean z) {
        this.isUTSArray = z;
    }

    /* JADX INFO: renamed from: isMapType, reason: from getter */
    public final boolean getIsMapType() {
        return this.isMapType;
    }

    public final void setMapType(boolean z) {
        this.isMapType = z;
    }

    /* JADX INFO: renamed from: isAnyType, reason: from getter */
    public final boolean getIsAnyType() {
        return this.isAnyType;
    }

    public final void setAnyType(boolean z) {
        this.isAnyType = z;
    }

    public final JSCallback getMHostCallback() {
        return this.mHostCallback;
    }

    public final void setMHostCallback(JSCallback jSCallback) {
        this.mHostCallback = jSCallback;
    }

    public final Class<?> getTClass() {
        return this.tClass;
    }

    public final void setTClass(Class<?> cls) {
        this.tClass = cls;
    }

    public final Type[] getHostTypeArguments() {
        return this.hostTypeArguments;
    }

    public final void setHostTypeArguments(Type[] typeArr) {
        this.hostTypeArguments = typeArr;
    }

    public final boolean getMIsKeepAlive() {
        return this.mIsKeepAlive;
    }

    public final void setMIsKeepAlive(boolean z) {
        this.mIsKeepAlive = z;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    public ParamConvertHelper(String classTypeName, Type[] typeArr, JSCallback jSCallback, boolean z) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
        this.UTSCallbackType = "io.dcloud.uts.UTSCallback";
        this.UTSObjectType = "io.dcloud.uts.UTSJSONObject";
        this.StringClassFlag = "java.lang.String";
        this.mIsKeepAlive = z;
        this.hostTypeArguments = typeArr;
        if (Intrinsics.areEqual("io.dcloud.uts.UTSJSONObject", classTypeName)) {
            this.isUTSObject = true;
            return;
        }
        Companion companion = INSTANCE;
        if (companion.isPrimitiveType(classTypeName)) {
            this.isPrimitive = true;
            return;
        }
        if (companion.isListType(classTypeName)) {
            this.isListType = true;
            return;
        }
        if (companion.isUTSArray(classTypeName)) {
            this.isUTSArray = true;
            return;
        }
        if (companion.isAnyType(classTypeName)) {
            this.isAnyType = true;
            return;
        }
        if (companion.isMapType(classTypeName)) {
            this.isMapType = true;
            return;
        }
        Class<?> cls = Class.forName(classTypeName);
        this.tClass = cls;
        Intrinsics.checkNotNull(cls);
        if (Intrinsics.areEqual("io.dcloud.uts.UTSCallback", cls.getName())) {
            this.isUTSCallback = true;
        } else {
            Class<?> cls2 = this.tClass;
            Intrinsics.checkNotNull(cls2);
            if (!cls2.isPrimitive()) {
                Class<?> cls3 = this.tClass;
                Intrinsics.checkNotNull(cls3);
                if (Intrinsics.areEqual("java.lang.String", cls3.getName())) {
                    this.isPrimitive = true;
                } else {
                    this.isUTSCallback = false;
                    this.isPrimitive = false;
                }
            } else {
                this.isPrimitive = true;
            }
        }
        this.mHostCallback = jSCallback;
    }

    public /* synthetic */ ParamConvertHelper(String str, Type[] typeArr, JSCallback jSCallback, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, typeArr, jSCallback, (i & 8) != 0 ? false : z);
    }

    /* JADX WARN: Code duplicated, block: B:149:0x0311 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:0x0312  */
    /* JADX WARN: Code duplicated, block: B:153:0x0325  */
    /* JADX WARN: Code duplicated, block: B:164:0x0369  */
    /* JADX WARN: Code duplicated, block: B:201:0x0410 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x0401 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0341 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x034c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0376 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x031f A[SYNTHETIC] */
    public final Object getInstance(Object value) {
        Type[] typeArr;
        Object obj;
        Iterator it;
        Field field;
        String name;
        Class<?> type;
        String name2;
        Companion companion;
        Type[] actualTypeArguments;
        Object objNewInstance;
        Type[] typeArr2;
        JSONArray array;
        UTSCallback uTSCallback;
        Type[] typeArr3 = null;
        objNewInstance = null;
        objNewInstance = null;
        objNewInstance = null;
        objNewInstance = null;
        Object objNewInstance2 = null;
        uTSArray = null;
        UTSArray uTSArray = null;
        typeArr3 = null;
        typeArr3 = null;
        if (value == null || Intrinsics.areEqual("UTSNull", value)) {
            return null;
        }
        if (this.isUTSObject) {
            UTSJSONObject uTSJSONObject = new UTSJSONObject();
            JSONObject object = JSON.parseObject(value.toString());
            Intrinsics.checkNotNull(object);
            uTSJSONObject.fillJSON(object);
            return uTSJSONObject;
        }
        if (this.isMapType) {
            JSONObject object2 = JSON.parseObject(value.toString());
            Intrinsics.checkNotNullExpressionValue(object2, "parseObject(...)");
            return new LinkedHashMap(MapsKt.toMap(object2));
        }
        if (this.isAnyType) {
            if (value instanceof JSONObject) {
                return new UTSJSONObject(value);
            }
            if (value instanceof JSONArray) {
                return new UTSArray((List) value);
            }
        } else {
            boolean z = this.isPrimitive;
            if (!z && !this.isListType && !this.isUTSArray && this.tClass == null) {
                return null;
            }
            if (this.isUTSCallback) {
                Integer intOrNull = StringsKt.toIntOrNull(value.toString());
                if (intOrNull != null) {
                    int iIntValue = intOrNull.intValue();
                    if (this.mIsKeepAlive && (uTSCallback = ParamConvertHelperKt.getUtsCallbackCache().get(intOrNull)) != null) {
                        uTSCallback.setHostCallback(this.mHostCallback);
                        return uTSCallback;
                    }
                    if (iIntValue == -1) {
                        return null;
                    }
                    try {
                        Class<?> cls = this.tClass;
                        Intrinsics.checkNotNull(cls);
                        objNewInstance2 = cls.getConstructor(JSCallback.class, Integer.TYPE, String.class).newInstance(this.mHostCallback, intOrNull, "");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (NoSuchMethodException e3) {
                        e3.printStackTrace();
                    } catch (InvocationTargetException e4) {
                        e4.printStackTrace();
                    }
                    if (this.mIsKeepAlive) {
                        Map<Integer, UTSCallback> utsCallbackCache = ParamConvertHelperKt.getUtsCallbackCache();
                        Intrinsics.checkNotNull(objNewInstance2, "null cannot be cast to non-null type io.dcloud.uts.UTSCallback");
                        utsCallbackCache.put(intOrNull, (UTSCallback) objNewInstance2);
                    }
                }
                return objNewInstance2;
            }
            if (!z) {
                if (this.isUTSArray) {
                    if (!(value instanceof JSONArray)) {
                        return null;
                    }
                    Type[] typeArr4 = this.hostTypeArguments;
                    if (typeArr4 != null && typeArr4.length != 0) {
                        uTSArray = new UTSArray();
                        Companion companion2 = INSTANCE;
                        Type[] typeArr5 = this.hostTypeArguments;
                        Intrinsics.checkNotNull(typeArr5);
                        ParamConvertHelper paramConvertHelper = new ParamConvertHelper(companion2.typeNameCompat(typeArr5[0]), null, null, false, 8, null);
                        Iterator it2 = ((Iterable) value).iterator();
                        while (it2.hasNext()) {
                            uTSArray.add(paramConvertHelper.getInstance(it2.next()));
                        }
                    }
                    return uTSArray;
                }
                if (this.isListType) {
                    if (value instanceof JSONArray) {
                        return CollectionsKt.toList((Iterable) value);
                    }
                    if ((value instanceof String) && (array = JSON.parseArray((String) value)) != null) {
                        return CollectionsKt.toList(array);
                    }
                }
                JSONObject object3 = JSONObject.parseObject(value.toString());
                if (object3 == null) {
                    return null;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    Class<?> cls2 = this.tClass;
                    if (cls2 != null) {
                        Intrinsics.checkNotNull(cls2);
                        if (!JvmClassMappingKt.getKotlinClass(cls2).getConstructors().isEmpty()) {
                            Class<?> cls3 = this.tClass;
                            Intrinsics.checkNotNull(cls3);
                            try {
                                if (JvmClassMappingKt.getKotlinClass(cls3).getConstructors().size() == 1) {
                                    Class<?> cls4 = this.tClass;
                                    Intrinsics.checkNotNull(cls4);
                                    KFunction kFunction = (KFunction) CollectionsKt.first(JvmClassMappingKt.getKotlinClass(cls4).getConstructors());
                                    if (!kFunction.getParameters().isEmpty()) {
                                        Map<String, Object> innerMap = object3.getInnerMap();
                                        List<KParameter> parameters = kFunction.getParameters();
                                        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(parameters, 10)), 16));
                                        for (Object obj2 : parameters) {
                                            LinkedHashMap linkedHashMap2 = linkedHashMap;
                                            KParameter kParameter = (KParameter) obj2;
                                            Object paramConvertHelper2 = innerMap.get(kParameter.getName());
                                            if (paramConvertHelper2 == null || Reflection.getOrCreateKotlinClass(paramConvertHelper2.getClass()).getSupertypes().contains(kParameter.getType()) || Intrinsics.areEqual(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(paramConvertHelper2.getClass()), null, false, null, 7, null), kParameter.getType())) {
                                                typeArr2 = typeArr3;
                                            } else if (Intrinsics.areEqual(kParameter.getType().getClassifier(), Reflection.getOrCreateKotlinClass(UTSArray.class)) && (paramConvertHelper2 instanceof JSONArray)) {
                                                KType type2 = kParameter.getType().getArguments().get(0).getType();
                                                Intrinsics.checkNotNull(type2);
                                                ParamConvertHelper paramConvertHelper3 = new ParamConvertHelper(type2.toString(), null, null, false, 8, null);
                                                UTSArray uTSArray2 = new UTSArray();
                                                Iterator it3 = ((Iterable) paramConvertHelper2).iterator();
                                                while (it3.hasNext()) {
                                                    Type[] typeArr6 = typeArr3;
                                                    uTSArray2.add(paramConvertHelper3.getInstance(it3.next()));
                                                    typeArr3 = typeArr6;
                                                }
                                                typeArr2 = typeArr3;
                                                paramConvertHelper2 = uTSArray2;
                                            } else {
                                                typeArr2 = typeArr3;
                                                if (paramConvertHelper2 instanceof JSONObject) {
                                                    paramConvertHelper2 = new ParamConvertHelper(INSTANCE.typeNameCompat(ReflectJvmMapping.getJavaType(kParameter.getType())), null, null, false, 8, null).getInstance(paramConvertHelper2);
                                                }
                                            }
                                            if (kParameter.getName() != null) {
                                                String name3 = kParameter.getName();
                                                Intrinsics.checkNotNull(name3);
                                                linkedHashSet.add(name3);
                                            }
                                            linkedHashMap2.put(obj2, paramConvertHelper2);
                                            typeArr3 = typeArr2;
                                        }
                                        typeArr = typeArr3;
                                        objNewInstance = kFunction.callBy(linkedHashMap);
                                    } else {
                                        typeArr = null;
                                        objNewInstance = kFunction.call(new Object[0]);
                                    }
                                } else {
                                    typeArr = null;
                                    Class<?> cls5 = this.tClass;
                                    Intrinsics.checkNotNull(cls5);
                                    objNewInstance = cls5.newInstance();
                                }
                                obj = objNewInstance;
                            } catch (IllegalAccessException e5) {
                                e = e5;
                                e.printStackTrace();
                                obj = typeArr;
                            } catch (InstantiationException e6) {
                                e = e6;
                                e.printStackTrace();
                                obj = typeArr;
                            }
                        }
                        if (obj == null) {
                            return typeArr;
                        }
                        Class<?> cls6 = this.tClass;
                        Intrinsics.checkNotNull(cls6);
                        it = ArrayIteratorKt.iterator(cls6.getDeclaredFields());
                        while (it.hasNext()) {
                            field = (Field) it.next();
                            name = field.getName();
                            type = field.getType();
                            name2 = field.getType().getName();
                            if (object3.containsKey(name)) {
                                field.setAccessible(true);
                                if (Intrinsics.areEqual(this.UTSCallbackType, name2)) {
                                    int intValue = object3.getIntValue(name);
                                    JSCallback jSCallback = this.mHostCallback;
                                    Intrinsics.checkNotNull(name);
                                    try {
                                        field.set(obj, new UTSCallback(jSCallback, intValue, name));
                                    } catch (IllegalAccessException e7) {
                                        e7.printStackTrace();
                                    }
                                } else if (type.isPrimitive()) {
                                    field.set(obj, object3.get(name));
                                } else {
                                    companion = INSTANCE;
                                    Intrinsics.checkNotNull(name2);
                                    if (companion.isPrimitiveType(name2)) {
                                        try {
                                            field.set(obj, object3.get(name));
                                        } catch (IllegalAccessException e8) {
                                            e8.printStackTrace();
                                        }
                                    } else if (!(object3.get(name) instanceof Boolean) || (object3.get(name) instanceof Number)) {
                                        try {
                                            field.set(obj, object3.get(name));
                                        } catch (IllegalAccessException e9) {
                                            e9.printStackTrace();
                                        }
                                    } else if (Intrinsics.areEqual("io.dcloud.uts.UTSArray", name2)) {
                                        new ParamConvertHelper(name2, null, this.mHostCallback, false, 8, null);
                                        if (field.getGenericType() instanceof ParameterizedType) {
                                            Type genericType = field.getGenericType();
                                            Intrinsics.checkNotNull(genericType, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                                            actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                                        } else {
                                            actualTypeArguments = typeArr;
                                        }
                                        try {
                                            field.set(obj, new ParamConvertHelper(name2, actualTypeArguments, this.mHostCallback, false, 8, null).getInstance(object3.get(name)));
                                        } catch (IllegalAccessException e10) {
                                            e10.printStackTrace();
                                        }
                                    } else {
                                        String name4 = field.getType().getName();
                                        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                                        try {
                                            field.set(obj, new ParamConvertHelper(name4, null, this.mHostCallback, false, 8, null).getInstance(object3.get(name)));
                                        } catch (IllegalAccessException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        return obj;
                    }
                    typeArr = null;
                } catch (IllegalAccessException e12) {
                    e = e12;
                    typeArr = typeArr3;
                } catch (InstantiationException e13) {
                    e = e13;
                    typeArr = typeArr3;
                }
                obj = typeArr;
                if (obj == null) {
                    return typeArr;
                }
                Class<?> cls7 = this.tClass;
                Intrinsics.checkNotNull(cls7);
                it = ArrayIteratorKt.iterator(cls7.getDeclaredFields());
                while (it.hasNext()) {
                    field = (Field) it.next();
                    name = field.getName();
                    type = field.getType();
                    name2 = field.getType().getName();
                    if (object3.containsKey(name)) {
                        field.setAccessible(true);
                        if (Intrinsics.areEqual(this.UTSCallbackType, name2)) {
                            int intValue2 = object3.getIntValue(name);
                            JSCallback jSCallback2 = this.mHostCallback;
                            Intrinsics.checkNotNull(name);
                            field.set(obj, new UTSCallback(jSCallback2, intValue2, name));
                        } else if (type.isPrimitive()) {
                            companion = INSTANCE;
                            Intrinsics.checkNotNull(name2);
                            if (companion.isPrimitiveType(name2)) {
                                field.set(obj, object3.get(name));
                            } else if (!(object3.get(name) instanceof Boolean)) {
                                field.set(obj, object3.get(name));
                            } else {
                                field.set(obj, object3.get(name));
                            }
                        } else {
                            field.set(obj, object3.get(name));
                        }
                    }
                }
                return obj;
            }
        }
        return value;
    }
}
