package io.dcloud.uts.android;

import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.uts.Date;
import io.dcloud.uts.IUTSSourceMap;
import io.dcloud.uts.NumberKt;
import io.dcloud.uts.StringKt;
import io.dcloud.uts.UTSAndroid;
import io.dcloud.uts.UTSArray;
import io.dcloud.uts.UTSJSONObject;
import io.dcloud.uts.UTSNumber;
import io.dcloud.uts.UTSRegExp;
import io.dcloud.uts.UTSSourceMapPosition;
import io.dcloud.uts.gson.JsonArray;
import io.dcloud.uts.gson.JsonElement;
import io.dcloud.uts.gson.JsonObject;
import io.dcloud.uts.gson.JsonPrimitive;
import io.dcloud.uts.log.ILogParent;
import io.dcloud.uts.log.LogSelfV2;
import io.dcloud.uts.log.LogSelfV2Simple;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ClassLogWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001JV\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J<\u0010\u0019\u001a\u00020\u00152\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0002J:\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u0001H\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010$\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010%\u001a\u00020 H\u0002¨\u0006&"}, d2 = {"Lio/dcloud/uts/android/ClassLogWrapper;", "", "<init>", "()V", "wrapClass", "Lio/dcloud/uts/gson/JsonElement;", "objInstance", "parentField", "inputStock", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "limitCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "wrapNumberText", "", "logValue", "fillRootJsonWithMap", "", "customMap", "", "rootJsonObject", "Lio/dcloud/uts/gson/JsonObject;", "nextLimitCounter", "valueProperObject", "Lio/dcloud/uts/gson/JsonArray;", "wrapClassInfo", "classObj", "Ljava/lang/Class;", "doJsonConvert", "logClassOf", "input", "needSubType", "", "type", "value", "logSubTypeOf", "logTypeOf", "isReturnTag", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassLogWrapper {
    public static final ClassLogWrapper INSTANCE = new ClassLogWrapper();

    private ClassLogWrapper() {
    }

    public static /* synthetic */ JsonElement wrapClass$default(ClassLogWrapper classLogWrapper, Object obj, Object obj2, HashSet hashSet, AtomicInteger atomicInteger, int i, Object obj3) {
        if ((i & 8) != 0) {
            atomicInteger = new AtomicInteger(256);
        }
        return classLogWrapper.wrapClass(obj, obj2, hashSet, atomicInteger);
    }

    public final JsonElement wrapClass(Object objInstance, Object parentField, HashSet<Object> inputStock, AtomicInteger limitCounter) {
        Intrinsics.checkNotNullParameter(inputStock, "inputStock");
        Intrinsics.checkNotNullParameter(limitCounter, "limitCounter");
        if (objInstance == null) {
            if (parentField == null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("type", new JsonPrimitive("null"));
                jsonObject.add("value", new JsonPrimitive("null"));
                return jsonObject;
            }
            return new JsonPrimitive("null");
        }
        if (inputStock.contains(objInstance)) {
            inputStock.remove(objInstance);
            return new JsonPrimitive("[Circular]");
        }
        inputStock.add(objInstance);
        JsonPrimitive jsonPrimitive = new JsonPrimitive("null");
        try {
            jsonPrimitive = doJsonConvert(objInstance, parentField, inputStock, limitCounter);
        } catch (Throwable unused) {
        }
        inputStock.remove(objInstance);
        return jsonPrimitive;
    }

    public final String wrapNumberText(Object logValue) {
        if (logValue == null) {
            return "null";
        }
        if (logValue instanceof Number) {
            boolean zAreEqual = Intrinsics.areEqual(logValue, Float.valueOf(0.0f));
            String string = WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
            if (!zAreEqual && !Intrinsics.areEqual(logValue, Double.valueOf(0.0d)) && !Intrinsics.areEqual(logValue, (Object) 0L) && (!Intrinsics.areEqual(logValue, (Object) 0) || !(logValue instanceof Integer))) {
                Number number = (Number) logValue;
                if (number.intValue() != 0 || (!(logValue instanceof Short) && !(logValue instanceof Byte))) {
                    if (Intrinsics.areEqual(NumberKt.div(number, Integer.valueOf(number.intValue())), Double.valueOf(1.0d))) {
                        string = String.valueOf(number.intValue());
                    } else if ((logValue instanceof Double) || (logValue instanceof Float)) {
                        if (Intrinsics.areEqual(logValue, UTSNumber.INSTANCE.getNaN()) || Intrinsics.areEqual(logValue, UTSNumber.INSTANCE.getPOSITIVE_INFINITY()) || Intrinsics.areEqual(logValue, UTSNumber.INSTANCE.getNEGATIVE_INFINITY())) {
                            string = logValue.toString();
                        } else {
                            double dAbs = Math.abs(number.doubleValue());
                            if (dAbs >= 1.0E-6d && dAbs < 1.0E21d) {
                                string = ClassLogWrapper$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(logValue.toString()).round(new MathContext(17, RoundingMode.HALF_UP))).toPlainString();
                            } else {
                                String lowerCase = StringKt.toLowerCase(logValue.toString());
                                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".0e", false, 2, (Object) null)) {
                                    lowerCase = StringsKt.replace$default(lowerCase, ".0e", "e", false, 4, (Object) null);
                                }
                                String str = lowerCase;
                                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "e-", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) str, (CharSequence) "e", false, 2, (Object) null)) {
                                    return lowerCase;
                                }
                                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"e"}, false, 0, 6, (Object) null);
                                return ((String) listSplit$default.get(0)) + "e+" + ((String) listSplit$default.get(1));
                            }
                        }
                    } else {
                        string = ClassLogWrapper$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(number.toString()).round(new MathContext(17, RoundingMode.HALF_UP))).toPlainString();
                    }
                }
            }
            Intrinsics.checkNotNull(string);
            return string;
        }
        return logValue.toString();
    }

    private final JsonObject wrapClassInfo(Class<?> classObj, HashSet<Object> inputStock, JsonObject rootJsonObject, AtomicInteger nextLimitCounter) {
        Field[] fieldArr;
        String strLogSubTypeOf;
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        Field[] declaredFields = classObj.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        Field[] fieldArr2 = declaredFields;
        int length = fieldArr2.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            Field field = fieldArr2[i];
            Object obj = Modifier.isStatic(field.getModifiers()) ? field.get(classObj) : null;
            ClassLogWrapper classLogWrapper = INSTANCE;
            String strLogTypeOf$default = logTypeOf$default(classLogWrapper, obj, z, 2, null);
            if (Intrinsics.areEqual(field.getName(), "Companion") && obj != null) {
                Reflection.getOrCreateKotlinClass(obj.getClass()).isCompanion();
                fieldArr = fieldArr2;
            } else {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.add("type", new JsonPrimitive(strLogTypeOf$default));
                if (classLogWrapper.needSubType(strLogTypeOf$default, obj) && (strLogSubTypeOf = classLogWrapper.logSubTypeOf(obj)) != null) {
                    jsonObject2.add("subType", new JsonPrimitive(strLogSubTypeOf));
                }
                jsonObject2.add("name", new JsonPrimitive(field.getName()));
                if (obj instanceof Function) {
                    KFunction kFunctionReflect = ReflectLambdaKt.reflect((Function) obj);
                    if (kFunctionReflect != null) {
                        JsonArray jsonArray2 = new JsonArray();
                        Iterator<T> it = kFunctionReflect.getParameters().iterator();
                        while (it.hasNext()) {
                            jsonArray2.add(new JsonPrimitive(INSTANCE.logTypeOf(((KParameter) it.next()).getType().toString(), true)));
                        }
                        jsonObject2.add("parameter", jsonArray2);
                        if (!Intrinsics.areEqual("kotlin.Unit", kFunctionReflect.getReturnType().toString())) {
                            jsonObject2.add("returned", new JsonPrimitive(INSTANCE.logTypeOf(kFunctionReflect.getReturnType().toString(), true)));
                        }
                    }
                    fieldArr = fieldArr2;
                } else {
                    JsonElement jsonElementWrapClass = classLogWrapper.wrapClass(obj, classObj, inputStock, nextLimitCounter);
                    if (Intrinsics.areEqual("object", strLogTypeOf$default)) {
                        fieldArr = fieldArr2;
                        if (jsonElementWrapClass instanceof JsonObject) {
                            Set<Map.Entry<String, JsonElement>> setEntrySet = ((JsonObject) jsonElementWrapClass).entrySet();
                            Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
                            Iterator<T> it2 = setEntrySet.iterator();
                            while (it2.hasNext()) {
                                Map.Entry entry = (Map.Entry) it2.next();
                                jsonObject2.add((String) entry.getKey(), (JsonElement) entry.getValue());
                            }
                        }
                    } else {
                        fieldArr = fieldArr2;
                    }
                    if (Intrinsics.areEqual("object", strLogTypeOf$default) && Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass.toString())) {
                        jsonObject2.add("value", jsonElementWrapClass);
                        Intrinsics.checkNotNull(obj);
                        jsonObject2.add("className", new JsonPrimitive(classLogWrapper.logClassOf(obj)));
                    } else {
                        jsonObject2.add("value", jsonElementWrapClass);
                    }
                }
                jsonArray.add(jsonObject2);
            }
            i++;
            fieldArr2 = fieldArr;
            z = false;
        }
        if (UTSJSONObject.class.isAssignableFrom(classObj) && !rootJsonObject.has("__$originalPosition")) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.add("name", new JsonPrimitive("UTSJSONObject"));
            rootJsonObject.add("__$originalPosition", jsonObject3);
        }
        jsonObject.add("properties", jsonArray);
        rootJsonObject.add("value", jsonObject);
        return rootJsonObject;
    }

    /* JADX WARN: Code duplicated, block: B:179:0x067e  */
    /* JADX WARN: Code duplicated, block: B:326:0x0a98  */
    /* JADX WARN: Multi-variable type inference failed */
    private final JsonElement doJsonConvert(Object objInstance, Object parentField, HashSet<Object> inputStock, AtomicInteger nextLimitCounter) {
        JsonObject jsonObject;
        JsonObject jsonObject2;
        String strStackTraceToString;
        JsonObject jsonObject3;
        boolean z;
        Object objCall;
        String strLogTypeOf$default;
        String str;
        String str2;
        String str3;
        JsonArray jsonArray;
        String str4;
        JsonArray jsonArray2;
        HashSet<Object> hashSet;
        AtomicInteger atomicInteger;
        String str5;
        JsonArray jsonArray3;
        boolean z2;
        Object objCall2;
        String strLogTypeOf$default2;
        String str6;
        String str7;
        String str8;
        JsonArray jsonArray4;
        String strLogSubTypeOf;
        Iterator<T> it;
        KFunction kFunction;
        nextLimitCounter.decrementAndGet();
        String str9 = "type";
        if (objInstance instanceof LogSelfV2Simple) {
            Object logV2Simple = ((LogSelfV2Simple) objInstance).toLogV2Simple();
            if (logV2Simple instanceof JsonElement) {
                return (JsonElement) logV2Simple;
            }
        } else {
            if (objInstance instanceof UTSLogInfo) {
                UTSLogInfo uTSLogInfo = (UTSLogInfo) objInstance;
                String type = uTSLogInfo.getType();
                Object value = uTSLogInfo.getValue();
                String subtype = uTSLogInfo.getSubtype();
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.add("type", new JsonPrimitive(type));
                jsonObject4.add("value", new JsonPrimitive(wrapNumberText(value)));
                if (subtype.length() > 0) {
                    jsonObject4.add("subType", new JsonPrimitive(subtype));
                }
                return jsonObject4;
            }
            if (objInstance instanceof Number) {
                if (parentField == null) {
                    JsonObject jsonObject5 = new JsonObject();
                    jsonObject5.add("type", new JsonPrimitive(UTSAndroid.INSTANCE.typeof(objInstance)));
                    if (needSubType("number", objInstance)) {
                        jsonObject5.add("subType", new JsonPrimitive("number"));
                    }
                    jsonObject5.add("value", new JsonPrimitive(wrapNumberText(objInstance)));
                    return jsonObject5;
                }
                return new JsonPrimitive(wrapNumberText(objInstance));
            }
            if (objInstance instanceof String) {
                if (parentField == null) {
                    JsonObject jsonObject6 = new JsonObject();
                    jsonObject6.add("type", new JsonPrimitive("string"));
                    jsonObject6.add("value", new JsonPrimitive(((String) objInstance).toString()));
                    return jsonObject6;
                }
                return new JsonPrimitive(((String) objInstance).toString());
            }
            if (objInstance instanceof Character) {
                if (parentField == null) {
                    JsonObject jsonObject7 = new JsonObject();
                    jsonObject7.add("type", new JsonPrimitive("Char"));
                    jsonObject7.add("subType", new JsonPrimitive("string"));
                    jsonObject7.add("value", new JsonPrimitive(String.valueOf(((Character) objInstance).charValue())));
                    return jsonObject7;
                }
                return new JsonPrimitive(String.valueOf(((Character) objInstance).charValue()));
            }
            if (objInstance instanceof Boolean) {
                if (parentField == null) {
                    JsonObject jsonObject8 = new JsonObject();
                    jsonObject8.add("type", new JsonPrimitive("boolean"));
                    jsonObject8.add("value", new JsonPrimitive(String.valueOf(((Boolean) objInstance).booleanValue())));
                    return jsonObject8;
                }
                return new JsonPrimitive(String.valueOf(((Boolean) objInstance).booleanValue()));
            }
        }
        if (nextLimitCounter.get() < 0) {
            return new JsonPrimitive("[depth-max-limit]");
        }
        String str10 = "object";
        if (objInstance instanceof Map) {
            JsonObject jsonObject9 = new JsonObject();
            jsonObject9.add("type", new JsonPrimitive("object"));
            jsonObject9.add("subType", new JsonPrimitive("map"));
            StringBuilder sb = new StringBuilder("Map(");
            Map map = (Map) objInstance;
            sb.append(map.size());
            sb.append(Operators.BRACKET_END);
            String string = sb.toString();
            jsonObject9.add("description", new JsonPrimitive(string));
            JsonArray jsonArray5 = new JsonArray();
            for (Map.Entry entry : map.entrySet()) {
                JsonObject jsonObject10 = new JsonObject();
                ClassLogWrapper classLogWrapper = INSTANCE;
                jsonObject10.add(IApp.ConfigProperty.CONFIG_KEY, classLogWrapper.wrapClass(entry.getKey(), null, inputStock, nextLimitCounter));
                jsonObject10.add("value", classLogWrapper.wrapClass(entry.getValue(), null, inputStock, nextLimitCounter));
                jsonArray5.add(jsonObject10);
            }
            JsonObject jsonObject11 = new JsonObject();
            jsonObject11.add("entries", jsonArray5);
            jsonObject9.add("value", jsonObject11);
            jsonObject9.add("description", new JsonPrimitive(string));
            return jsonObject9;
        }
        if (objInstance instanceof Set) {
            JsonObject jsonObject12 = new JsonObject();
            jsonObject12.add("type", new JsonPrimitive("object"));
            jsonObject12.add("subType", new JsonPrimitive("set"));
            JsonArray jsonArray6 = new JsonArray();
            for (Object obj : (Iterable) objInstance) {
                JsonObject jsonObject13 = new JsonObject();
                jsonObject13.add("value", INSTANCE.wrapClass(obj, null, inputStock, nextLimitCounter));
                jsonArray6.add(jsonObject13);
            }
            JsonObject jsonObject14 = new JsonObject();
            jsonObject14.add("entries", jsonArray6);
            jsonObject12.add("value", jsonObject14);
            jsonObject12.add("description", new JsonPrimitive("Set(" + ((Set) objInstance).size() + Operators.BRACKET_END));
            return jsonObject12;
        }
        String str11 = "returned";
        if (objInstance instanceof Function) {
            JsonObject jsonObject15 = new JsonObject();
            if (parentField == null) {
                jsonObject15.add("type", new JsonPrimitive("function"));
            }
            KFunction kFunctionReflect = ReflectLambdaKt.reflect((Function) objInstance);
            if (kFunctionReflect != null) {
                JsonArray jsonArray7 = new JsonArray();
                Iterator<T> it2 = kFunctionReflect.getParameters().iterator();
                while (it2.hasNext()) {
                    jsonArray7.add(new JsonPrimitive(INSTANCE.logTypeOf(((KParameter) it2.next()).getType().toString(), true)));
                }
                jsonObject15.add("parameter", jsonArray7);
                if (!Intrinsics.areEqual("kotlin.Unit", kFunctionReflect.getReturnType().toString())) {
                    jsonObject15.add("returned", new JsonPrimitive(logTypeOf$default(this, kFunctionReflect.getReturnType().toString(), false, 2, null)));
                }
            }
            return jsonObject15;
        }
        JsonObject jsonObject16 = new JsonObject();
        String strLogTypeOf$default3 = logTypeOf$default(this, objInstance, false, 2, null);
        String strLogSubTypeOf2 = logSubTypeOf(objInstance);
        boolean zAreEqual = Intrinsics.areEqual("class", strLogTypeOf$default3);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(objInstance.getClass());
        boolean zIsAnonymousClass = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).isAnonymousClass();
        jsonObject16.add("className", new JsonPrimitive(logClassOf(objInstance)));
        if (parentField == null) {
            jsonObject16.add("type", new JsonPrimitive(strLogTypeOf$default3));
            if (needSubType(strLogTypeOf$default3, objInstance)) {
                jsonObject16.add("subType", new JsonPrimitive(strLogSubTypeOf2));
            }
        }
        JsonObject jsonObject17 = new JsonObject();
        JsonArray jsonArray8 = new JsonArray();
        JsonArray jsonArray9 = new JsonArray();
        if (objInstance instanceof Class) {
            return wrapClassInfo((Class) objInstance, inputStock, jsonObject16, nextLimitCounter);
        }
        String str12 = "Companion";
        String str13 = "className";
        String str14 = "kotlin.Number";
        String str15 = "value";
        if (Intrinsics.areEqual("object", strLogSubTypeOf2)) {
            if (zAreEqual || !(objInstance instanceof LogSelfV2)) {
                JsonArray jsonArray10 = jsonArray8;
                str4 = "__$originalPosition";
                char c = 0;
                if (Intrinsics.areEqual(orCreateKotlinClass.getObjectInstance(), objInstance)) {
                    str4 = str4;
                    jsonObject = jsonObject16;
                    jsonArray2 = jsonArray10;
                } else {
                    if (objInstance instanceof ILogParent) {
                        hashSet = inputStock;
                        atomicInteger = nextLimitCounter;
                        fillRootJsonWithMap(((ILogParent) objInstance).toLogMap(), hashSet, jsonObject16, atomicInteger, jsonArray10, objInstance);
                    } else {
                        hashSet = inputStock;
                        atomicInteger = nextLimitCounter;
                    }
                    JsonObject jsonObject18 = jsonObject16;
                    Iterator it3 = KClasses.getDeclaredMemberProperties(orCreateKotlinClass).iterator();
                    while (it3.hasNext()) {
                        KProperty1 kProperty1 = (KProperty1) it3.next();
                        String name = kProperty1.getName();
                        Iterator it4 = it3;
                        try {
                            jsonArray3 = jsonArray10;
                            try {
                                KCallablesJvm.setAccessible(kProperty1, true);
                                Object[] objArr = new Object[1];
                                objArr[c] = objInstance;
                                objCall2 = kProperty1.call(objArr);
                                z2 = false;
                            } catch (Throwable unused) {
                                z2 = true;
                                objCall2 = null;
                            }
                        } catch (Throwable unused2) {
                            jsonArray3 = jsonArray10;
                        }
                        if (z2) {
                            jsonObject18 = jsonObject18;
                            str14 = str14;
                            str6 = str10;
                            str7 = str13;
                            str8 = str15;
                            jsonArray4 = jsonArray3;
                        } else if ((objCall2 instanceof UTSSourceMapPosition) && Intrinsics.areEqual(str4, name)) {
                            JsonObject jsonObject19 = new JsonObject();
                            UTSSourceMapPosition uTSSourceMapPosition = (UTSSourceMapPosition) objCall2;
                            jsonObject19.addProperty("name", uTSSourceMapPosition.getName());
                            jsonObject19.addProperty("file", uTSSourceMapPosition.getFile());
                            jsonObject19.addProperty("column", Integer.valueOf(uTSSourceMapPosition.getColumn()));
                            jsonObject19.addProperty("line", Integer.valueOf(uTSSourceMapPosition.getLine()));
                            jsonObject18.add(str4, jsonObject19);
                            jsonObject18 = jsonObject18;
                            str14 = str14;
                            str6 = str10;
                            str7 = str13;
                            str8 = str15;
                            jsonArray4 = jsonArray3;
                        } else {
                            if (Intrinsics.areEqual(str14, kProperty1.getReturnType().toString())) {
                                strLogTypeOf$default2 = INSTANCE.logTypeOf(str14, true);
                            } else {
                                strLogTypeOf$default2 = logTypeOf$default(INSTANCE, objCall2, false, 2, null);
                            }
                            if (Intrinsics.areEqual(name, "Companion") && objCall2 != null) {
                                Reflection.getOrCreateKotlinClass(objCall2.getClass()).isCompanion();
                                str6 = str10;
                                str7 = str13;
                                str8 = str15;
                                jsonArray4 = jsonArray3;
                            } else {
                                JsonObject jsonObject20 = new JsonObject();
                                jsonObject20.add(str9, new JsonPrimitive(strLogTypeOf$default2));
                                ClassLogWrapper classLogWrapper2 = INSTANCE;
                                if (classLogWrapper2.needSubType(strLogTypeOf$default2, objCall2) && (strLogSubTypeOf = classLogWrapper2.logSubTypeOf(objCall2)) != null) {
                                    jsonObject20.add("subType", new JsonPrimitive(strLogSubTypeOf));
                                }
                                jsonObject20.add("name", new JsonPrimitive(name));
                                if (objCall2 instanceof Function) {
                                    KFunction kFunctionReflect2 = ReflectLambdaKt.reflect((Function) objCall2);
                                    if (kFunctionReflect2 != null) {
                                        JsonArray jsonArray11 = new JsonArray();
                                        Iterator<T> it5 = kFunctionReflect2.getParameters().iterator();
                                        while (it5.hasNext()) {
                                            jsonArray11.add(new JsonPrimitive(INSTANCE.logTypeOf(((KParameter) it5.next()).getType().toString(), true)));
                                            kFunctionReflect2 = kFunctionReflect2;
                                        }
                                        KFunction kFunction2 = kFunctionReflect2;
                                        jsonObject20.add("parameter", jsonArray11);
                                        if (!Intrinsics.areEqual("kotlin.Unit", kFunction2.getReturnType().toString())) {
                                            jsonObject20.add(str11, new JsonPrimitive(INSTANCE.logTypeOf(kFunction2.getReturnType().toString(), true)));
                                        }
                                    }
                                    str6 = str10;
                                } else {
                                    String str16 = str11;
                                    JsonElement jsonElementWrapClass = classLogWrapper2.wrapClass(objCall2, objInstance, hashSet, atomicInteger);
                                    str6 = str10;
                                    if (Intrinsics.areEqual(str6, strLogTypeOf$default2)) {
                                        str11 = str16;
                                        if (jsonElementWrapClass instanceof JsonObject) {
                                            Set<Map.Entry<String, JsonElement>> setEntrySet = ((JsonObject) jsonElementWrapClass).entrySet();
                                            Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
                                            Iterator<T> it6 = setEntrySet.iterator();
                                            while (it6.hasNext()) {
                                                Map.Entry entry2 = (Map.Entry) it6.next();
                                                jsonObject20.add((String) entry2.getKey(), (JsonElement) entry2.getValue());
                                            }
                                        }
                                        jsonArray4 = jsonArray3;
                                        jsonArray4.add(jsonObject20);
                                    } else {
                                        str11 = str16;
                                    }
                                    if (Intrinsics.areEqual(str6, strLogTypeOf$default2) && Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass.toString())) {
                                        str8 = str15;
                                        jsonObject20.add(str8, jsonElementWrapClass);
                                        Intrinsics.checkNotNull(objCall2);
                                        JsonPrimitive jsonPrimitive = new JsonPrimitive(classLogWrapper2.logClassOf(objCall2));
                                        str7 = str13;
                                        jsonObject20.add(str7, jsonPrimitive);
                                    } else {
                                        str7 = str13;
                                        str8 = str15;
                                        jsonObject20.add(str8, jsonElementWrapClass);
                                    }
                                    jsonArray4 = jsonArray3;
                                    jsonArray4.add(jsonObject20);
                                }
                                str7 = str13;
                                str8 = str15;
                                jsonArray4 = jsonArray3;
                                jsonArray4.add(jsonObject20);
                            }
                        }
                        str15 = str8;
                        str13 = str7;
                        jsonArray10 = jsonArray4;
                        str10 = str6;
                        it3 = it4;
                        str14 = str14;
                        jsonObject18 = jsonObject18;
                        str9 = str9;
                        c = 0;
                    }
                    JsonObject jsonObject21 = jsonObject18;
                    jsonArray2 = jsonArray10;
                    str5 = str15;
                    if (!zIsAnonymousClass || orCreateKotlinClass.getSupertypes().isEmpty()) {
                        jsonObject = jsonObject21;
                    } else {
                        JsonPrimitive jsonPrimitive2 = new JsonPrimitive(orCreateKotlinClass.getSupertypes().get(0).toString());
                        jsonObject = jsonObject21;
                        if (!jsonObject.has(str4)) {
                            JsonObject jsonObject22 = new JsonObject();
                            jsonObject22.add("name", jsonPrimitive2);
                            jsonObject.add(str4, jsonObject22);
                        }
                    }
                }
                jsonObject17.add("properties", jsonArray2);
                it = KClasses.getDeclaredMemberFunctions(orCreateKotlinClass).iterator();
                while (it.hasNext()) {
                    kFunction = (KFunction) it.next();
                    String name2 = kFunction.getName();
                    try {
                        KCallablesJvm.setAccessible(kFunction, true);
                        if (!(objInstance instanceof IUTSSourceMap) && Intrinsics.areEqual("__$getOriginalPosition", name2)) {
                            R rCall = kFunction.call(objInstance);
                            if (rCall instanceof UTSSourceMapPosition) {
                                JsonObject jsonObject23 = new JsonObject();
                                UTSSourceMapPosition uTSSourceMapPosition2 = (UTSSourceMapPosition) rCall;
                                jsonObject23.addProperty("name", uTSSourceMapPosition2.getName());
                                jsonObject23.addProperty("file", uTSSourceMapPosition2.getFile());
                                jsonObject23.addProperty("column", Integer.valueOf(uTSSourceMapPosition2.getColumn()));
                                jsonObject23.addProperty("line", Integer.valueOf(uTSSourceMapPosition2.getLine()));
                                jsonObject.add(str4, jsonObject23);
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
                jsonObject17.add("methods", jsonArray9);
                jsonObject.add(str5, jsonObject17);
            } else {
                fillRootJsonWithMap(((LogSelfV2) objInstance).toLogMap(), inputStock, jsonObject16, nextLimitCounter, jsonArray8, objInstance);
                jsonObject = jsonObject16;
                jsonArray2 = jsonArray8;
                str4 = "__$originalPosition";
            }
            str5 = str15;
            jsonObject17.add("properties", jsonArray2);
            it = KClasses.getDeclaredMemberFunctions(orCreateKotlinClass).iterator();
            while (it.hasNext()) {
                kFunction = (KFunction) it.next();
                String name3 = kFunction.getName();
                KCallablesJvm.setAccessible(kFunction, true);
                if (!(objInstance instanceof IUTSSourceMap)) {
                }
            }
            jsonObject17.add("methods", jsonArray9);
            jsonObject.add(str5, jsonObject17);
        } else {
            String str17 = "returned";
            Object obj2 = "kotlin.Number";
            JsonObject jsonObject24 = jsonObject17;
            JsonArray jsonArray12 = jsonArray8;
            jsonObject = jsonObject16;
            String str18 = "properties";
            if (Intrinsics.areEqual("array", strLogSubTypeOf2)) {
                if (objInstance instanceof Object[]) {
                    int i = 0;
                    for (Object obj3 : (Object[]) objInstance) {
                        JsonElement jsonElementWrapClass2 = INSTANCE.wrapClass(obj3, null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass2 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass2).addProperty("name", Integer.valueOf(i));
                        }
                        jsonArray12.add(jsonElementWrapClass2);
                        i++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof byte[]) {
                    int i2 = 0;
                    for (byte b : (byte[]) objInstance) {
                        JsonElement jsonElementWrapClass3 = INSTANCE.wrapClass(Byte.valueOf(b), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass3 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass3).addProperty("name", Integer.valueOf(i2));
                        }
                        jsonArray12.add(jsonElementWrapClass3);
                        i2++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof char[]) {
                    int i3 = 0;
                    for (char c2 : (char[]) objInstance) {
                        JsonElement jsonElementWrapClass4 = INSTANCE.wrapClass(Character.valueOf(c2), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass4 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass4).addProperty("name", Integer.valueOf(i3));
                        }
                        jsonArray12.add(jsonElementWrapClass4);
                        i3++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof short[]) {
                    int i4 = 0;
                    for (short s : (short[]) objInstance) {
                        JsonElement jsonElementWrapClass5 = INSTANCE.wrapClass(Short.valueOf(s), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass5 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass5).addProperty("name", Integer.valueOf(i4));
                        }
                        jsonArray12.add(jsonElementWrapClass5);
                        i4++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof int[]) {
                    int i5 = 0;
                    for (int i6 : (int[]) objInstance) {
                        JsonElement jsonElementWrapClass6 = INSTANCE.wrapClass(Integer.valueOf(i6), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass6 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass6).addProperty("name", Integer.valueOf(i5));
                        }
                        jsonArray12.add(jsonElementWrapClass6);
                        i5++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof long[]) {
                    int i7 = 0;
                    for (long j : (long[]) objInstance) {
                        JsonElement jsonElementWrapClass7 = INSTANCE.wrapClass(Long.valueOf(j), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass7 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass7).addProperty("name", Integer.valueOf(i7));
                        }
                        jsonArray12.add(jsonElementWrapClass7);
                        i7++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof float[]) {
                    int i8 = 0;
                    for (float f : (float[]) objInstance) {
                        JsonElement jsonElementWrapClass8 = INSTANCE.wrapClass(Float.valueOf(f), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass8 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass8).addProperty("name", Integer.valueOf(i8));
                        }
                        jsonArray12.add(jsonElementWrapClass8);
                        i8++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof double[]) {
                    int i9 = 0;
                    for (double d : (double[]) objInstance) {
                        JsonElement jsonElementWrapClass9 = INSTANCE.wrapClass(Double.valueOf(d), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass9 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass9).addProperty("name", Integer.valueOf(i9));
                        }
                        jsonArray12.add(jsonElementWrapClass9);
                        i9++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof boolean[]) {
                    int i10 = 0;
                    for (boolean z3 : (boolean[]) objInstance) {
                        JsonElement jsonElementWrapClass10 = INSTANCE.wrapClass(Boolean.valueOf(z3), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass10 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass10).addProperty("name", Integer.valueOf(i10));
                        }
                        jsonArray12.add(jsonElementWrapClass10);
                        i10++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                } else if (objInstance instanceof List) {
                    Iterator it7 = ((Iterable) objInstance).iterator();
                    int i11 = 0;
                    while (it7.hasNext()) {
                        JsonElement jsonElementWrapClass11 = INSTANCE.wrapClass(it7.next(), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass11 instanceof JsonObject) {
                            ((JsonObject) jsonElementWrapClass11).addProperty("name", Integer.valueOf(i11));
                        }
                        jsonArray12.add(jsonElementWrapClass11);
                        i11++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                jsonObject.add(str15, jsonObject24);
            } else if (Intrinsics.areEqual("error", strLogSubTypeOf2)) {
                boolean z4 = objInstance instanceof Throwable;
                if (z4) {
                    Iterator it8 = KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(objInstance.getClass())).iterator();
                    while (it8.hasNext()) {
                        boolean z5 = z4;
                        KProperty1 kProperty2 = (KProperty1) it8.next();
                        Iterator it9 = it8;
                        String name4 = kProperty2.getName();
                        JsonObject jsonObject25 = jsonObject;
                        try {
                            jsonObject3 = jsonObject24;
                            try {
                                KCallablesJvm.setAccessible(kProperty2, true);
                                objCall = kProperty2.call(objInstance);
                                z = false;
                            } catch (Throwable unused4) {
                                z = true;
                                objCall = null;
                            }
                        } catch (Throwable unused5) {
                            jsonObject3 = jsonObject24;
                        }
                        if (z) {
                            jsonArray = jsonArray12;
                            str18 = str18;
                            str = str12;
                            str2 = str17;
                            str3 = str13;
                        } else {
                            String string2 = kProperty2.getReturnType().toString();
                            obj2 = obj2;
                            if (Intrinsics.areEqual(obj2, string2)) {
                                strLogTypeOf$default = INSTANCE.logTypeOf(obj2, true);
                            } else {
                                strLogTypeOf$default = logTypeOf$default(INSTANCE, objCall, false, 2, null);
                            }
                            if (Intrinsics.areEqual(name4, str12) && objCall != null) {
                                Reflection.getOrCreateKotlinClass(objCall.getClass()).isCompanion();
                                str = str12;
                                str2 = str17;
                                str3 = str13;
                                jsonArray = jsonArray12;
                            } else {
                                JsonObject jsonObject26 = new JsonObject();
                                jsonObject26.add("type", new JsonPrimitive(strLogTypeOf$default));
                                ClassLogWrapper classLogWrapper3 = INSTANCE;
                                if (classLogWrapper3.needSubType(strLogTypeOf$default, objCall)) {
                                    String strLogSubTypeOf3 = classLogWrapper3.logSubTypeOf(objCall);
                                    str = str12;
                                    if (strLogSubTypeOf3 != null) {
                                        jsonObject26.add("subType", new JsonPrimitive(strLogSubTypeOf3));
                                    }
                                } else {
                                    str = str12;
                                }
                                jsonObject26.add("name", new JsonPrimitive(name4));
                                if (objCall instanceof Function) {
                                    KFunction kFunctionReflect3 = ReflectLambdaKt.reflect((Function) objCall);
                                    if (kFunctionReflect3 != null) {
                                        JsonArray jsonArray13 = new JsonArray();
                                        Iterator<T> it10 = kFunctionReflect3.getParameters().iterator();
                                        while (it10.hasNext()) {
                                            jsonArray13.add(new JsonPrimitive(INSTANCE.logTypeOf(((KParameter) it10.next()).getType().toString(), true)));
                                            kFunctionReflect3 = kFunctionReflect3;
                                        }
                                        KFunction kFunction3 = kFunctionReflect3;
                                        jsonObject26.add("parameter", jsonArray13);
                                        if (Intrinsics.areEqual("kotlin.Unit", kFunction3.getReturnType().toString())) {
                                            str2 = str17;
                                        } else {
                                            str2 = str17;
                                            jsonObject26.add(str2, new JsonPrimitive(INSTANCE.logTypeOf(kFunction3.getReturnType().toString(), true)));
                                        }
                                    } else {
                                        str2 = str17;
                                    }
                                } else {
                                    str2 = str17;
                                    JsonElement jsonElementWrapClass12 = classLogWrapper3.wrapClass(objCall, objInstance, inputStock, nextLimitCounter);
                                    if (Intrinsics.areEqual("object", strLogTypeOf$default) && (jsonElementWrapClass12 instanceof JsonObject)) {
                                        Set<Map.Entry<String, JsonElement>> setEntrySet2 = ((JsonObject) jsonElementWrapClass12).entrySet();
                                        Intrinsics.checkNotNullExpressionValue(setEntrySet2, "entrySet(...)");
                                        Iterator<T> it11 = setEntrySet2.iterator();
                                        while (it11.hasNext()) {
                                            Map.Entry entry3 = (Map.Entry) it11.next();
                                            jsonObject26.add((String) entry3.getKey(), (JsonElement) entry3.getValue());
                                        }
                                    } else if (Intrinsics.areEqual("object", strLogTypeOf$default) && Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass12.toString())) {
                                        jsonObject26.add(str15, jsonElementWrapClass12);
                                        Intrinsics.checkNotNull(objCall);
                                        JsonPrimitive jsonPrimitive3 = new JsonPrimitive(classLogWrapper3.logClassOf(objCall));
                                        str3 = str13;
                                        jsonObject26.add(str3, jsonPrimitive3);
                                    } else {
                                        str3 = str13;
                                        jsonObject26.add(str15, jsonElementWrapClass12);
                                    }
                                    jsonArray = jsonArray12;
                                    jsonArray.add(jsonObject26);
                                }
                                str3 = str13;
                                jsonArray = jsonArray12;
                                jsonArray.add(jsonObject26);
                            }
                        }
                        str17 = str2;
                        str13 = str3;
                        it8 = it9;
                        z4 = z5;
                        str12 = str;
                        str18 = str18;
                        jsonObject = jsonObject25;
                        jsonArray12 = jsonArray;
                        jsonObject24 = jsonObject3;
                    }
                }
                JsonObject jsonObject27 = jsonObject24;
                boolean z6 = z4;
                JsonArray jsonArray14 = jsonArray12;
                JsonObject jsonObject28 = jsonObject;
                String str19 = str18;
                if (objInstance instanceof InvocationTargetException) {
                    Throwable targetException = ((InvocationTargetException) objInstance).getTargetException();
                    Intrinsics.checkNotNull(targetException);
                    strStackTraceToString = ExceptionsKt.stackTraceToString(targetException);
                } else if (!z6) {
                    strStackTraceToString = "";
                } else {
                    strStackTraceToString = ExceptionsKt.stackTraceToString((Throwable) objInstance);
                }
                jsonObject27.add(str19, jsonArray14);
                jsonObject27.add("stack", new JsonPrimitive(strStackTraceToString));
                jsonObject2 = jsonObject28;
                jsonObject2.add(str15, jsonObject27);
            } else {
                jsonObject2 = jsonObject;
                if (objInstance instanceof UTSRegExp) {
                    jsonObject2.add(str15, new JsonPrimitive(((UTSRegExp) objInstance).toString()));
                } else if (objInstance instanceof Date) {
                    jsonObject2.add(str15, new JsonPrimitive(((Date) objInstance).toString()));
                } else if (objInstance instanceof java.util.Date) {
                    jsonObject2.add(str15, new JsonPrimitive(new Date(Long.valueOf(((java.util.Date) objInstance).getTime())).toString()));
                }
            }
            return jsonObject2;
        }
        jsonObject2 = jsonObject;
        return jsonObject2;
    }

    private final String logClassOf(Object input) {
        if (input instanceof Class) {
            return ((Class) input).getName();
        }
        if (input instanceof KClass) {
            return JvmClassMappingKt.getJavaClass((KClass) input).getName();
        }
        String qualifiedName = Reflection.getOrCreateKotlinClass(input.getClass()).getQualifiedName();
        return qualifiedName != null ? qualifiedName : input.getClass().getName();
    }

    private final boolean needSubType(String type, Object value) {
        return Intrinsics.areEqual(type, "object") || (value instanceof Number);
    }

    private final String logSubTypeOf(Object input) {
        if ((input instanceof UTSArray) || (input instanceof List) || (input instanceof Object[]) || (input instanceof byte[]) || (input instanceof char[]) || (input instanceof short[]) || (input instanceof float[]) || (input instanceof double[]) || (input instanceof int[]) || (input instanceof boolean[]) || (input instanceof long[])) {
            return "array";
        }
        if ((input instanceof UTSRegExp) || (input instanceof Regex)) {
            return "regexp";
        }
        if ((input instanceof Date) || (input instanceof java.util.Date)) {
            return "date";
        }
        if (input instanceof Number) {
            return "number";
        }
        if (input instanceof String) {
            return "string";
        }
        if (input instanceof Throwable) {
            return "error";
        }
        if (input instanceof Set) {
            return "set";
        }
        if (input instanceof Map) {
            return "map";
        }
        if (input instanceof Function) {
            return "function";
        }
        if ((input instanceof Class) || (input instanceof KClass)) {
            return "class";
        }
        return "object";
    }

    static /* synthetic */ String logTypeOf$default(ClassLogWrapper classLogWrapper, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        return classLogWrapper.logTypeOf(obj, z);
    }

    private final String logTypeOf(Object input, boolean isReturnTag) {
        if (input == null) {
            return "null";
        }
        if (isReturnTag && (input instanceof String)) {
            if (Intrinsics.areEqual("kotlin.Number", input)) {
                return "number";
            }
            if (Intrinsics.areEqual("kotlin.String", input)) {
                return "string";
            }
            return (String) input;
        }
        return UTSAndroid.INSTANCE.typeof(input);
    }

    private final void fillRootJsonWithMap(Map<String, ? extends Object> customMap, HashSet<Object> inputStock, JsonObject rootJsonObject, AtomicInteger nextLimitCounter, JsonArray valueProperObject, Object objInstance) {
        String strLogTypeOf$default;
        String strLogSubTypeOf;
        for (Map.Entry<String, ? extends Object> entry : customMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            JsonObject jsonObject = new JsonObject();
            if (Intrinsics.areEqual("__$originalPosition", key) && (value instanceof JsonObject)) {
                rootJsonObject.add("__$originalPosition", (JsonElement) value);
            } else {
                if (value instanceof UTSLogInfo) {
                    UTSLogInfo uTSLogInfo = (UTSLogInfo) value;
                    strLogTypeOf$default = INSTANCE.logTypeOf(uTSLogInfo.getType(), true);
                    value = uTSLogInfo.getValue();
                } else {
                    strLogTypeOf$default = logTypeOf$default(INSTANCE, value, false, 2, null);
                }
                jsonObject.add("type", new JsonPrimitive(strLogTypeOf$default));
                ClassLogWrapper classLogWrapper = INSTANCE;
                if (classLogWrapper.needSubType(strLogTypeOf$default, value) && (strLogSubTypeOf = classLogWrapper.logSubTypeOf(value)) != null) {
                    jsonObject.add("subType", new JsonPrimitive(strLogSubTypeOf));
                }
                jsonObject.add("name", new JsonPrimitive(key));
                if (value instanceof Function) {
                    KFunction kFunctionReflect = ReflectLambdaKt.reflect((Function) value);
                    if (kFunctionReflect != null) {
                        JsonArray jsonArray = new JsonArray();
                        Iterator<T> it = kFunctionReflect.getParameters().iterator();
                        while (it.hasNext()) {
                            jsonArray.add(new JsonPrimitive(INSTANCE.logTypeOf(((KParameter) it.next()).getType().toString(), true)));
                        }
                        jsonObject.add("parameter", jsonArray);
                        if (!Intrinsics.areEqual("kotlin.Unit", kFunctionReflect.getReturnType().toString())) {
                            jsonObject.add("returned", new JsonPrimitive(logTypeOf$default(INSTANCE, kFunctionReflect.getReturnType().toString(), false, 2, null)));
                        }
                    }
                } else {
                    JsonElement jsonElementWrapClass = classLogWrapper.wrapClass(value, objInstance, inputStock, nextLimitCounter);
                    if (Intrinsics.areEqual("object", strLogTypeOf$default) && (jsonElementWrapClass instanceof JsonObject)) {
                        Set<Map.Entry<String, JsonElement>> setEntrySet = ((JsonObject) jsonElementWrapClass).entrySet();
                        Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
                        Iterator<T> it2 = setEntrySet.iterator();
                        while (it2.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it2.next();
                            jsonObject.add((String) entry2.getKey(), (JsonElement) entry2.getValue());
                        }
                    } else if (Intrinsics.areEqual("object", strLogTypeOf$default) && Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass.toString())) {
                        jsonObject.add("value", jsonElementWrapClass);
                        Intrinsics.checkNotNull(value);
                        jsonObject.add("className", new JsonPrimitive(classLogWrapper.logClassOf(value)));
                    } else {
                        jsonObject.add("value", jsonElementWrapClass);
                    }
                }
                valueProperObject.add(jsonObject);
            }
        }
        if (objInstance instanceof UTSJSONObject) {
            if (!rootJsonObject.has("__$originalPosition")) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.add("name", new JsonPrimitive("UTSJSONObject"));
                rootJsonObject.add("__$originalPosition", jsonObject2);
            } else {
                JsonElement jsonElement = rootJsonObject.get("__$originalPosition");
                if (jsonElement instanceof JsonObject) {
                    ((JsonObject) jsonElement).add("name", new JsonPrimitive("UTSJSONObject"));
                }
                rootJsonObject.add("__$originalPosition", jsonElement);
            }
        }
    }
}
