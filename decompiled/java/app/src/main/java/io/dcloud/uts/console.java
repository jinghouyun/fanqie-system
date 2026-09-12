package io.dcloud.uts;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.AppConsoleLogUtil;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.uts.android.ClassLogWrapper;
import io.dcloud.uts.gson.Gson;
import io.dcloud.uts.gson.JsonArray;
import io.dcloud.uts.gson.JsonNull;
import io.dcloud.uts.gson.JsonObject;
import io.dcloud.uts.log.LogSelf;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: console.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0001H\u0016J-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0016J%\u0010\u0018\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0016J%\u0010\u0019\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0016J%\u0010\u001a\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0016J#\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0016J#\u0010\u001c\u001a\u00020\u00102\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0016J/\u0010\u001d\u001a\u00020\u00052\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J#\u0010!\u001a\u00020\u00052\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0013\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\"R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/dcloud/uts/console;", "", "<init>", "()V", "wrapClassLogStr", "", "k", "Ljava/lang/Class;", "getBasicField", "anyInstance", "getObjectJSON", "Lio/dcloud/uts/gson/JsonObject;", "consoleThreadPool", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "asyncV2Log", "", "tag", "data", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", AbsoluteConst.XML_DEBUG, "([Ljava/lang/Object;)V", "error", "info", "log", "warn", "errorV1", "errorV1WithStack", "getLog", "alwaysNeedStack", "", "([Ljava/lang/Object;Z)Ljava/lang/String;", "getLogV2", "([Ljava/lang/Object;)Ljava/lang/String;", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class console {
    public static final console INSTANCE = new console();
    private static final ExecutorService consoleThreadPool = Executors.newFixedThreadPool(1);

    private console() {
    }

    /* JADX INFO: compiled from: console.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\bJ%\u0010\n\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\bJ%\u0010\u000b\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\bJ%\u0010\f\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\b¨\u0006\r"}, d2 = {"Lio/dcloud/uts/console$Companion;", "", "<init>", "()V", AbsoluteConst.XML_DEBUG, "", "data", "", "([Ljava/lang/Object;)V", "error", "info", "log", "warn", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public static final Companion INSTANCE = new Companion();

        private Companion() {
        }

        @Deprecated(message = "use console.debug() instead", replaceWith = @ReplaceWith(expression = "console.debug(*data)", imports = {}))
        @JvmStatic
        public static final void debug(java.lang.Object... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            console.debug(Arrays.copyOf(data, data.length));
        }

        @Deprecated(message = "use console.error() instead", replaceWith = @ReplaceWith(expression = "console.error(*data)", imports = {}))
        @JvmStatic
        public static final void error(java.lang.Object... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            console.error(Arrays.copyOf(data, data.length));
        }

        @Deprecated(message = "use console.info() instead", replaceWith = @ReplaceWith(expression = "console.info(*data)", imports = {}))
        @JvmStatic
        public static final void info(java.lang.Object... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            console.info(Arrays.copyOf(data, data.length));
        }

        @Deprecated(message = "use console.log() instead", replaceWith = @ReplaceWith(expression = "console.log(*data)", imports = {}))
        @JvmStatic
        public static final void log(java.lang.Object... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            console.log(Arrays.copyOf(data, data.length));
        }

        @Deprecated(message = "use console.warn() instead", replaceWith = @ReplaceWith(expression = "console.warn(*data)", imports = {}))
        @JvmStatic
        public static final void warn(java.lang.Object... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            console.warn(Arrays.copyOf(data, data.length));
        }
    }

    public String wrapClassLogStr(Class<?> k) {
        String canonicalName;
        Intrinsics.checkNotNullParameter(k, "k");
        String canonicalName2 = k.getCanonicalName();
        if (canonicalName2 == null || canonicalName2.length() == 0) {
            canonicalName = "";
        } else {
            canonicalName = k.getCanonicalName();
            Intrinsics.checkNotNull(canonicalName);
            if (StringsKt.endsWith$default(canonicalName, ".Companion", false, 2, (java.lang.Object) null)) {
                canonicalName = StringKt.substring(canonicalName, (Number) 0, StringKt.lastIndexOf$default(canonicalName, ".Companion", null, 2, null));
            }
        }
        return "" + canonicalName + Operators.SPACE_STR;
    }

    private final java.lang.Object getBasicField(java.lang.Object anyInstance) {
        if ((anyInstance instanceof String) || (anyInstance instanceof Boolean) || (anyInstance instanceof Number)) {
            return anyInstance;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0116 A[Catch: Exception -> 0x01f9, TryCatch #0 {Exception -> 0x01f9, blocks: (B:7:0x003b, B:10:0x0046, B:12:0x004e, B:14:0x0052, B:42:0x0106, B:44:0x0116, B:15:0x005c, B:17:0x0060, B:18:0x006a, B:20:0x006e, B:22:0x007b, B:24:0x007f, B:25:0x0090, B:27:0x0094, B:29:0x0098, B:30:0x00a3, B:32:0x00a9, B:34:0x00af, B:35:0x00c4, B:37:0x00d4, B:38:0x00e0, B:40:0x00e6, B:41:0x00f7, B:45:0x017a, B:47:0x0197), top: B:59:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01f9 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0116, please report this as an issue */
    public JsonObject getObjectJSON(java.lang.Object anyInstance) {
        int i;
        String name;
        Intrinsics.checkNotNullParameter(anyInstance, "anyInstance");
        JsonObject jsonObject = new JsonObject();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Field[] declaredFields = anyInstance.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if ((field.getModifiers() & 2) == 0) {
                try {
                    java.lang.Object obj = field.get(anyInstance);
                    if (obj != null) {
                        console consoleVar = INSTANCE;
                        java.lang.Object basicField = consoleVar.getBasicField(obj);
                        if (basicField != null) {
                            if (basicField instanceof String) {
                                jsonObject.addProperty(field.getName(), (String) basicField);
                            } else if (basicField instanceof Number) {
                                jsonObject.addProperty(field.getName(), (Number) basicField);
                            } else if (basicField instanceof Boolean) {
                                jsonObject.addProperty(field.getName(), (Boolean) basicField);
                            }
                        } else {
                            if (obj instanceof java.util.Map) {
                                jsonObject.add(field.getName(), new Gson().toJsonTree(obj));
                            } else if ((obj instanceof Collection) && !(obj instanceof java.util.Map)) {
                                JsonArray jsonArray = new JsonArray();
                                for (java.lang.Object obj2 : (Iterable) obj) {
                                    if (obj2 == null) {
                                        console consoleVar2 = INSTANCE;
                                        JsonNull INSTANCE2 = JsonNull.INSTANCE;
                                        Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                                        jsonArray.add(consoleVar2.getObjectJSON(INSTANCE2));
                                    } else {
                                        jsonArray.add(INSTANCE.getObjectJSON(obj2));
                                    }
                                }
                                i = 1;
                                jsonObject.add(field.getName(), jsonArray);
                            } else {
                                i = 1;
                                if (obj instanceof UTSObject) {
                                    jsonObject.add(field.getName(), new Gson().toJsonTree(obj));
                                } else {
                                    jsonObject.addProperty(field.getName(), consoleVar.wrapClassLogStr(obj.getClass()));
                                }
                            }
                            name = field.getName();
                            Intrinsics.checkNotNull(name);
                            if (name.length() > 0) {
                                linkedHashSet.add("get" + StringKt.toUpperCase(StringKt.substring(name, (Number) 0, Integer.valueOf(i))) + StringKt.substring$default(name, Integer.valueOf(i), null, 2, null));
                                linkedHashSet.add("set" + StringKt.toUpperCase(StringKt.substring(name, (Number) 0, Integer.valueOf(i))) + StringKt.substring$default(name, Integer.valueOf(i), null, 2, null));
                            }
                        }
                        i = 1;
                        name = field.getName();
                        Intrinsics.checkNotNull(name);
                        if (name.length() > 0) {
                            linkedHashSet.add("get" + StringKt.toUpperCase(StringKt.substring(name, (Number) 0, Integer.valueOf(i))) + StringKt.substring$default(name, Integer.valueOf(i), null, 2, null));
                            linkedHashSet.add("set" + StringKt.toUpperCase(StringKt.substring(name, (Number) 0, Integer.valueOf(i))) + StringKt.substring$default(name, Integer.valueOf(i), null, 2, null));
                        }
                    } else {
                        jsonObject.add(field.getName(), JsonNull.INSTANCE);
                        String name2 = field.getName();
                        Intrinsics.checkNotNull(name2);
                        if (name2.length() > 0) {
                            linkedHashSet.add("get" + StringKt.toUpperCase(StringKt.substring(name2, (Number) 0, (Number) 1)) + StringKt.substring$default(name2, (Number) 1, null, 2, null));
                            linkedHashSet.add("set" + StringKt.toUpperCase(StringKt.substring(name2, (Number) 0, (Number) 1)) + StringKt.substring$default(name2, (Number) 1, null, 2, null));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        Method[] declaredMethods = anyInstance.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if ((method.getModifiers() & 2) == 0 && !linkedHashSet.contains(method.getName())) {
                jsonObject.addProperty(method.getName(), "f () { [native code] } ");
            }
        }
        return jsonObject;
    }

    private final void asyncV2Log(final String tag, final java.lang.Object... data) {
        consoleThreadPool.submit(new Runnable() { // from class: io.dcloud.uts.console$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                console.asyncV2Log$lambda$3(data, tag);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncV2Log$lambda$3(java.lang.Object[] objArr, String str) {
        AppConsoleLogUtil.DCLog(INSTANCE.getLogV2(Arrays.copyOf(objArr, objArr.length)), str);
    }

    @JvmStatic
    public static final void debug(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        INSTANCE.asyncV2Log("DEBUG", Arrays.copyOf(data, data.length));
    }

    @JvmStatic
    public static final void error(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        INSTANCE.asyncV2Log("ERROR", Arrays.copyOf(data, data.length));
    }

    @JvmStatic
    public static final void info(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        INSTANCE.asyncV2Log("INFO", Arrays.copyOf(data, data.length));
    }

    @JvmStatic
    public static final void log(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        INSTANCE.asyncV2Log("LOG", Arrays.copyOf(data, data.length));
    }

    @JvmStatic
    public static final void warn(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        INSTANCE.asyncV2Log("WARN", Arrays.copyOf(data, data.length));
    }

    public final void errorV1(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        AppConsoleLogUtil.DCLog(getLog$default(this, Arrays.copyOf(data, data.length), false, 2, null), "ERROR");
    }

    public final void errorV1WithStack(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        AppConsoleLogUtil.DCLog(getLog(Arrays.copyOf(data, data.length), true), "ERROR");
    }

    static /* synthetic */ String getLog$default(console consoleVar, java.lang.Object[] objArr, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return consoleVar.getLog(objArr, z);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0133  */
    private final String getLog(java.lang.Object[] data, boolean alwaysNeedStack) {
        String string;
        if (data.length == 0) {
            return "---NULL---";
        }
        String str = "";
        boolean z = false;
        for (java.lang.Object obj : data) {
            boolean z2 = obj instanceof String;
            if ((!z2 || !StringsKt.startsWith$default(StringsKt.trim((CharSequence) obj).toString(), "at ", false, 2, (java.lang.Object) null)) && z) {
                str = str + "---COMMA---";
            }
            if (obj == null) {
                str = str + "---NULL---";
            } else if (obj instanceof LogSelf) {
                java.lang.Object log = ((LogSelf) obj).toLog();
                if (log instanceof String) {
                    str = str + ((String) log);
                } else if (log instanceof UTSJSONObject) {
                    str = ((str + "---BEGIN:JSON---") + ((UTSJSONObject) log).toJSONString()) + "---END:JSON---";
                } else {
                    if (log instanceof UTSArray) {
                        str = ((str + "---BEGIN:JSON---") + JSON.stringify(obj)) + "---END:JSON---";
                    } else if (log == null) {
                        return "---NULL---";
                    }
                }
            } else if (obj instanceof Throwable) {
                StringBuilder sb = new StringBuilder();
                if ((obj instanceof UTSError) && !alwaysNeedStack) {
                    sb.append(((UTSError) obj).toString());
                } else if (obj instanceof InvocationTargetException) {
                    sb.append(ExceptionsKt.stackTraceToString(((InvocationTargetException) obj).getTargetException()));
                } else if (obj instanceof HolderUTSError) {
                    HolderUTSError holderUTSError = (HolderUTSError) obj;
                    if (holderUTSError.getHolder() instanceof Throwable) {
                        sb.append(ExceptionsKt.stackTraceToString((Throwable) holderUTSError.getHolder()));
                    } else {
                        sb.append(ExceptionsKt.stackTraceToString((Throwable) obj));
                    }
                } else {
                    sb.append(ExceptionsKt.stackTraceToString((Throwable) obj));
                }
                str = ((str + "---BEGIN:EXCEPTION---") + ((java.lang.Object) sb)) + "---END:EXCEPTION---";
            } else if (obj instanceof Function) {
                str = str + "f () { [native code] } ";
            } else if (obj instanceof Date) {
                str = str + ((Date) obj).toString();
            } else {
                boolean z3 = obj instanceof UTSJSONObject;
                if (z3 || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof UTSObject)) {
                    String str2 = str + "---BEGIN:JSON---";
                    str = (z3 ? str2 + ((UTSJSONObject) obj).toJSONObject() : str2 + JSON.stringify(obj)) + "---END:JSON---";
                } else if (obj instanceof UTSArray) {
                    str = ((str + "---BEGIN:JSON---") + JSON.stringify(obj)) + "---END:JSON---";
                } else if (obj instanceof java.util.Map) {
                    str = ((str + "---BEGIN:JSON---") + ("Map(" + ((java.util.Map) obj).size() + ") ") + JSON.stringify(obj)) + "---END:JSON---";
                } else if (obj instanceof Number) {
                    boolean zAreEqual = Intrinsics.areEqual(obj, Float.valueOf(0.0f));
                    String strValueOf = WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
                    if (!zAreEqual && !Intrinsics.areEqual(obj, Double.valueOf(0.0d)) && !Intrinsics.areEqual(obj, (java.lang.Object) 0L) && (!Intrinsics.areEqual(obj, (java.lang.Object) 0) || !(obj instanceof Integer))) {
                        Number number = (Number) obj;
                        if (number.intValue() != 0 || (!(obj instanceof Short) && !(obj instanceof Byte) && !(obj instanceof UInt) && !(obj instanceof UByte) && !(obj instanceof ULong) && !(obj instanceof UShort))) {
                            if (Intrinsics.areEqual(NumberKt.div(number, Integer.valueOf(number.intValue())), Double.valueOf(1.0d))) {
                                strValueOf = String.valueOf(number.intValue());
                            } else {
                                NumberFormat numberFormat = NumberFormat.getInstance();
                                numberFormat.setGroupingUsed(false);
                                numberFormat.setMaximumFractionDigits(16);
                                strValueOf = numberFormat.format(obj);
                                Intrinsics.checkNotNull(strValueOf);
                            }
                        }
                    }
                    str = ((str + "---BEGIN:NUMBER---") + strValueOf) + "---END:NUMBER---";
                } else if ((obj instanceof UInt) || (obj instanceof UByte) || (obj instanceof UShort) || (obj instanceof ULong)) {
                    str = ((str + "---BEGIN:NUMBER---") + obj) + "---END:NUMBER---";
                } else if (z2) {
                    str = str + ((String) obj);
                } else {
                    if (obj instanceof Class) {
                        string = "---BEGIN:CLASS---" + wrapClassLogStr(obj.getClass()) + "---END:CLASS---";
                    } else {
                        java.lang.Object basicField = getBasicField(obj);
                        if (basicField != null) {
                            string = basicField.toString();
                        } else {
                            string = getObjectJSON(obj).toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        }
                    }
                    str = str + string;
                }
            }
            z = true;
        }
        return str;
    }

    public final String getLogV2(java.lang.Object... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (BaseInfo.SyncDebug) {
            if (data.length == 0) {
                return "---BEGIN:CONSOLE------END:CONSOLE---";
            }
            if (data.length == 1) {
                String string = ClassLogWrapper.wrapClass$default(ClassLogWrapper.INSTANCE, data[0], null, new HashSet(), null, 8, null).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return "---BEGIN:CONSOLE---" + string + "---END:CONSOLE---";
            }
            JsonArray jsonArray = new JsonArray();
            for (java.lang.Object obj : data) {
                jsonArray.add(ClassLogWrapper.wrapClass$default(ClassLogWrapper.INSTANCE, obj, null, new HashSet(), null, 8, null));
            }
            String string2 = jsonArray.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return "---BEGIN:CONSOLE---" + string2 + "---END:CONSOLE---";
        }
        return "";
    }
}
