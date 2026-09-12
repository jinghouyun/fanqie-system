package io.dcloud.uts.android;

import io.dcloud.common.DHInterface.IApp;
import io.dcloud.uts.Date;
import io.dcloud.uts.JSON;
import io.dcloud.uts.UTSArray;
import io.dcloud.uts.UTSCallback;
import io.dcloud.uts.UTSIterator;
import io.dcloud.uts.UTSJSONObject;
import io.dcloud.uts.UTSKeyIterable;
import io.dcloud.uts.UTSNumber;
import io.dcloud.uts.UTSObject;
import io.dcloud.uts.UTSRegExp;
import io.dcloud.uts.console;
import io.dcloud.uts.gson.JsonArray;
import io.dcloud.uts.gson.JsonElement;
import io.dcloud.uts.gson.JsonNull;
import io.dcloud.uts.gson.JsonObject;
import io.dcloud.uts.gson.JsonPrimitive;
import io.dcloud.uts.json.IJsonStringify;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UTSGsonEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012D\b\u0002\u0010\u0007\u001a>\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bj\u0004\u0018\u0001`\u000e¨\u0006\u0011"}, d2 = {"Lio/dcloud/uts/android/UTSGsonEncoder;", "", "<init>", "()V", "encode", "Lio/dcloud/uts/gson/JsonElement;", "obj", "replacer", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "Companion", "EncodeType", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSGsonEncoder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static List<EncodeType> allType;

    /* JADX INFO: compiled from: UTSGsonEncoder.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&Jf\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012B\u0010\t\u001a>\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/dcloud/uts/android/UTSGsonEncoder$EncodeType;", "", "typeName", "", "isType", "", "obj", "getTypeGsonInstance", "Lio/dcloud/uts/gson/JsonElement;", "replacer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "hostStock", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface EncodeType {
        JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock);

        boolean isType(Object obj);

        String typeName();
    }

    /* JADX INFO: compiled from: UTSGsonEncoder.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jf\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00012B\u0010\n\u001a>\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/dcloud/uts/android/UTSGsonEncoder$Companion;", "", "<init>", "()V", "allType", "", "Lio/dcloud/uts/android/UTSGsonEncoder$EncodeType;", "getGsonElement", "Lio/dcloud/uts/gson/JsonElement;", "input", "replacer", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "inputStock", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final JsonElement getGsonElement(Object input, Function2<? super String, Object, ? extends Object> replacer, Set<Object> inputStock) {
            JsonElement typeGsonInstance = null;
            if (input instanceof Function) {
                return null;
            }
            if (input == null) {
                return JsonNull.INSTANCE;
            }
            if (inputStock.contains(input)) {
                console.error("JSON stringify 错误 : Converting circular structure to JSON ");
                inputStock.remove(input);
                return JsonNull.INSTANCE;
            }
            inputStock.add(input);
            for (EncodeType encodeType : UTSGsonEncoder.allType) {
                if (encodeType.isType(input)) {
                    typeGsonInstance = encodeType.getTypeGsonInstance(input, replacer, inputStock);
                    break;
                }
            }
            inputStock.remove(input);
            return typeGsonInstance != null ? typeGsonInstance : new JsonObject();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        allType = arrayList;
        arrayList.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.1
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "json基础数据类型";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return obj == null || (obj instanceof String) || (obj instanceof Character) || (obj instanceof Boolean) || (obj instanceof Number);
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj == null) {
                    return JsonNull.INSTANCE;
                }
                if (obj instanceof Number) {
                    if (UTSNumber.INSTANCE.isNaN(obj)) {
                        return JsonNull.INSTANCE;
                    }
                    if (Intrinsics.areEqual(obj, Double.valueOf(Double.POSITIVE_INFINITY)) || Intrinsics.areEqual(obj, Float.valueOf(Float.POSITIVE_INFINITY)) || Intrinsics.areEqual(obj, Double.valueOf(Double.NEGATIVE_INFINITY)) || Intrinsics.areEqual(obj, Float.valueOf(Float.NEGATIVE_INFINITY))) {
                        return JsonNull.INSTANCE;
                    }
                    return new JsonPrimitive((Number) obj);
                }
                if (obj instanceof String) {
                    return new JsonPrimitive((String) obj);
                }
                if (obj instanceof Character) {
                    return new JsonPrimitive((Character) obj);
                }
                if (obj instanceof Boolean) {
                    return new JsonPrimitive((Boolean) obj);
                }
                return JsonNull.INSTANCE;
            }
        });
        allType.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.2
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "JsonSelf";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return obj instanceof IJsonStringify;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj instanceof IJsonStringify) {
                    return UTSGsonEncoder.INSTANCE.getGsonElement(((IJsonStringify) obj).toJSON(), replacer, hostStock);
                }
                return JsonNull.INSTANCE;
            }
        });
        allType.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.3
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "gson-内置对象";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return obj instanceof JsonElement;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj instanceof JsonElement) {
                    return (JsonElement) obj;
                }
                JsonNull INSTANCE2 = JsonNull.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.4
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "json-容器数据类型";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return (obj instanceof UTSArray) || (obj instanceof UTSJSONObject) || (obj instanceof List) || (obj instanceof Object[]) || (obj instanceof Set) || (obj instanceof Map);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x0039 A[PHI: r2
  0x0039: PHI (r2v12 java.lang.Object) = (r2v11 java.lang.Object), (r2v13 java.lang.Object) binds: [B:10:0x0026, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:27:0x006d A[PHI: r4
  0x006d: PHI (r4v1 java.lang.Object) = (r4v0 java.lang.Object), (r4v2 java.lang.Object) binds: [B:23:0x005a, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:43:0x00b0 A[PHI: r2
  0x00b0: PHI (r2v7 java.lang.Object) = (r2v6 java.lang.Object), (r2v8 java.lang.Object) binds: [B:39:0x009d, B:41:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                int i = 0;
                if (obj instanceof UTSArray) {
                    JsonArray jsonArray = new JsonArray();
                    for (Object objInvoke : (Iterable) obj) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (replacer == null) {
                            jsonArray.add(UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock));
                        } else {
                            objInvoke = replacer.invoke(String.valueOf(i), objInvoke);
                            if (!Intrinsics.areEqual(objInvoke, JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                                jsonArray.add(UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock));
                            }
                        }
                        i = i2;
                    }
                    return jsonArray;
                }
                if (obj instanceof Object[]) {
                    JsonArray jsonArray2 = new JsonArray();
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    int i3 = 0;
                    while (i < length) {
                        Object objInvoke2 = objArr[i];
                        int i4 = i3 + 1;
                        if (replacer == null) {
                            jsonArray2.add(UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke2, replacer, hostStock));
                        } else {
                            objInvoke2 = replacer.invoke(String.valueOf(i3), objInvoke2);
                            if (!Intrinsics.areEqual(objInvoke2, JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                                jsonArray2.add(UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke2, replacer, hostStock));
                            }
                        }
                        i++;
                        i3 = i4;
                    }
                    return jsonArray2;
                }
                if (obj instanceof List) {
                    JsonArray jsonArray3 = new JsonArray();
                    for (Object objInvoke3 : (Iterable) obj) {
                        int i5 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (replacer == null) {
                            jsonArray3.add(UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke3, replacer, hostStock));
                        } else {
                            objInvoke3 = replacer.invoke(String.valueOf(i), objInvoke3);
                            if (!Intrinsics.areEqual(objInvoke3, JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                                jsonArray3.add(UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke3, replacer, hostStock));
                            }
                        }
                        i = i5;
                    }
                    return jsonArray3;
                }
                if (obj instanceof Set) {
                    return new JsonObject();
                }
                if (obj instanceof Map) {
                    return new JsonObject();
                }
                if (obj instanceof UTSJSONObject) {
                    JsonObject jsonObject = new JsonObject();
                    for (Map.Entry<String, Object> entry : ((UTSJSONObject) obj).toMap().entrySet()) {
                        Object value = entry.getValue();
                        if (replacer != null) {
                            value = replacer.invoke(entry.getKey(), entry.getValue());
                            if (Intrinsics.areEqual(value, JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                            }
                        }
                        JsonElement gsonElement = UTSGsonEncoder.INSTANCE.getGsonElement(value, replacer, hostStock);
                        if (gsonElement != null) {
                            jsonObject.add(entry.getKey(), gsonElement);
                        }
                    }
                    return jsonObject;
                }
                JsonNull INSTANCE2 = JsonNull.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.5
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "json-开发者自定义类型";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return obj instanceof UTSObject;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) throws IllegalAccessException {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                JsonObject jsonObject = new JsonObject();
                if (obj instanceof UTSObject) {
                    UTSObject uTSObject = (UTSObject) obj;
                    for (String str : uTSObject) {
                        Object objInvoke = uTSObject.get(str);
                        if (replacer != null) {
                            objInvoke = replacer.invoke(str, uTSObject.get(str));
                            if (Intrinsics.areEqual(objInvoke, JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                            }
                        }
                        JsonElement gsonElement = UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock);
                        if (gsonElement != null) {
                            jsonObject.add(str, gsonElement);
                        }
                    }
                    return jsonObject;
                }
                JsonNull INSTANCE2 = JsonNull.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.6
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "json-可枚举接口";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return obj instanceof UTSKeyIterable;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                JsonObject jsonObject = new JsonObject();
                if (obj instanceof UTSKeyIterable) {
                    UTSKeyIterable uTSKeyIterable = (UTSKeyIterable) obj;
                    UTSIterator<String> uTSIteratorKeyIterator = uTSKeyIterable.keyIterator();
                    while (uTSIteratorKeyIterator.hasNext()) {
                        String next = uTSIteratorKeyIterator.next();
                        Object objInvoke = uTSKeyIterable.get(next);
                        if (replacer != null) {
                            objInvoke = replacer.invoke(next, objInvoke);
                            if (Intrinsics.areEqual(objInvoke, JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                            }
                        }
                        JsonElement gsonElement = UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock);
                        if (gsonElement != null) {
                            jsonObject.add(next, gsonElement);
                        }
                    }
                    return jsonObject;
                }
                JsonNull INSTANCE2 = JsonNull.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.7
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public String typeName() {
                return "UTS 内置对象";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(Object obj) {
                return (obj instanceof Date) || (obj instanceof UTSCallback) || (obj instanceof UTSRegExp);
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public JsonElement getTypeGsonInstance(Object obj, Function2<? super String, Object, ? extends Object> replacer, Set<Object> hostStock) {
                Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj == null) {
                    JsonNull INSTANCE2 = JsonNull.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                    return INSTANCE2;
                }
                if (obj instanceof Date) {
                    return new JsonPrimitive(((Date) obj).toISOString());
                }
                if (obj instanceof UTSCallback) {
                    return new JsonPrimitive(((UTSCallback) obj).toString());
                }
                if (obj instanceof UTSRegExp) {
                    return new JsonObject();
                }
                JsonNull INSTANCE3 = JsonNull.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(INSTANCE3, "INSTANCE");
                return INSTANCE3;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsonElement encode$default(UTSGsonEncoder uTSGsonEncoder, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return uTSGsonEncoder.encode(obj, function2);
    }

    public final JsonElement encode(Object obj, Function2<? super String, Object, ? extends Object> replacer) {
        return INSTANCE.getGsonElement(obj, replacer, new HashSet());
    }
}
