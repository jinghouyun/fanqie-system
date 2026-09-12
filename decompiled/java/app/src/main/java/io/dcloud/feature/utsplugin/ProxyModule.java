package io.dcloud.feature.utsplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.DHInterface.message.EnumUniqueID;
import io.dcloud.common.DHInterface.message.IObserveAble;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.AppConsoleLogUtil;
import io.dcloud.common.util.ErrorDialogUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.TestUtil;
import io.dcloud.feature.uniapp.AbsSDKInstance;
import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.common.UniModule;
import io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0;
import io.dcloud.uts.UTSAndroid;
import io.dcloud.uts.UTSArray;
import io.dcloud.uts.UTSJSONObject;
import io.dcloud.uts.android.AndroidUTSContext;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UTSProxyModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0003;<=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J,\u0010#\u001a\u0004\u0018\u00010$2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030!2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0014H\u0086@¢\u0006\u0002\u0010'J:\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001f2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\b\u0010+\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0002J\"\u00100\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0087@¢\u0006\u0002\u00102J6\u00103\u001a\u0002H4\"\u0004\b\u0000\u00104*\b\u0012\u0004\u0012\u0002H4052\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0\u0014\"\u0004\u0018\u00010$H\u0087@¢\u0006\u0002\u00107J \u00108\u001a\u00020\u00062\u0006\u00101\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0097@¢\u0006\u0002\u00102J\b\u00109\u001a\u00020:H\u0016¨\u0006>"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule;", "Lio/dcloud/feature/uniapp/common/UniModule;", "Lio/dcloud/common/DHInterface/message/IObserveAble;", "<init>", "()V", "onActivityPause", "", "onActivityResult", WXModule.REQUEST_CODE, "", WXModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onActivityResume", "onActivityStop", "onActivityDestroy", "onActivityBack", "", "onRequestPermissionsResult", "permissions", "", "", WXModule.GRANT_RESULTS, "", "(I[Ljava/lang/String;[I)V", "findTargetMethod", "Ljava/lang/reflect/Method;", "javaClazz", "Ljava/lang/Class;", "methodName", AbsoluteConst.JSON_KEY_OPTION, "Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;", "findTargetFunc", "Lkotlin/reflect/KFunction;", "isCompanion", "getFunctionExecuteRet", "", "targetFunction", "paramArray", "(Lkotlin/reflect/KFunction;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapDoTypeAction", "Lcom/alibaba/fastjson/JSONObject;", "inputOption", "targetInstance", WXBridgeManager.METHOD_CALLBACK, "Lcom/taobao/weex/bridge/JSCallback;", "errRet", "Lio/dcloud/feature/utsplugin/ReturnResult;", "invokeSync", "options", "(Lcom/alibaba/fastjson/JSONObject;Lcom/taobao/weex/bridge/JSCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspend", "R", "Lkotlin/reflect/KCallable;", "args", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeAsync", "getActionObserverID", "Lio/dcloud/common/DHInterface/message/EnumUniqueID;", "Companion", "InputOption", "ModuleChecker", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProxyModule extends UniModule implements IObserveAble {
    private static int instanceDynamicId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Map<Integer, Object> utsInstances = new LinkedHashMap();

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$callSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule", f = "UTSProxyModule.kt", i = {0, 0}, l = {1054}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProxyModule.this.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$getFunctionExecuteRet$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule", f = "UTSProxyModule.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {646, 647, 649}, m = "getFunctionExecuteRet", n = {"targetFunction", "paramArray", "targetFunction", "paramArray", "suspendRet", "targetFunction", "paramArray"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C01031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01031(Continuation<? super C01031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProxyModule.this.getFunctionExecuteRet(null, null, this);
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityDestroy() {
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityPause() {
        Iterator<Function0<Unit>> it = AndroidUTSContext.INSTANCE.getPauseListenFunc().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<Function3<Integer, Integer, Intent, Unit>> it = AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke(Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResume() {
        Iterator<Function0<Unit>> it = AndroidUTSContext.INSTANCE.getResumeListenFunc().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityStop() {
        super.onActivityStop();
        Iterator<Function0<Unit>> it = AndroidUTSContext.INSTANCE.getStopListenFunc().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public boolean onActivityBack() {
        Iterator<Function0<Unit>> it = AndroidUTSContext.INSTANCE.getBackListenFunc().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
        return false;
    }

    @Override // com.taobao.weex.common.WXModule
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        List listMutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(permissions, permissions.length));
        ArrayList arrayList = new ArrayList();
        for (int i : grantResults) {
            arrayList.add(Integer.valueOf(i));
        }
        Iterator<Function3<Integer, UTSArray<String>, UTSArray<Number>, Unit>> it = AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke(Integer.valueOf(requestCode), UTSArray.INSTANCE.fromNative(listMutableListOf), UTSArray.INSTANCE.fromNative(arrayList));
        }
    }

    private final Method findTargetMethod(Class<?> javaClazz, String methodName, InputOption option) {
        Iterator it = ArrayIteratorKt.iterator(javaClazz.getMethods());
        Method method = null;
        while (it.hasNext()) {
            Method method2 = (Method) it.next();
            if (Intrinsics.areEqual(methodName, method2.getName()) && option.getParamArray().size() == UByte$$ExternalSyntheticBackport0.m(method2)) {
                int iM = UByte$$ExternalSyntheticBackport0.m(method2);
                boolean z = true;
                for (int i = 0; i < iM; i++) {
                    if (!method2.getParameterTypes()[i].isInstance(option.getParamArray().get(i))) {
                        z = false;
                    }
                }
                if (z) {
                    return method2;
                }
                method = method2;
            }
        }
        return method;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d9 A[EDGE_INSN: B:59:0x00d9->B:45:0x00d9 BREAK  A[LOOP:2: B:12:0x0037->B:63:0x0037], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1 A[SYNTHETIC] */
    private final KFunction<?> findTargetFunc(Class<?> javaClazz, boolean isCompanion, String methodName, InputOption option) {
        Method method;
        Method method2;
        int iM;
        boolean z;
        int i;
        int i2;
        List<KParameter> parameters;
        if (isCompanion) {
            KClass<?> companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(javaClazz));
            Intrinsics.checkNotNull(companionObject);
            for (KFunction<?> kFunction : KClasses.getMemberFunctions(companionObject)) {
                if (Intrinsics.areEqual(methodName, kFunction.getName())) {
                    return kFunction;
                }
            }
        } else {
            Iterator it = ArrayIteratorKt.iterator(javaClazz.getMethods());
            Method method3 = null;
            loop1: while (true) {
                method = method3;
                while (true) {
                    if (!it.hasNext()) {
                        break loop1;
                    }
                    method2 = (Method) it.next();
                    if (Intrinsics.areEqual(methodName, method2.getName())) {
                        if (option.getParamArray().size() == 0) {
                            Intrinsics.checkNotNull(method2);
                            KFunction<?> kotlinFunction = ReflectJvmMapping.getKotlinFunction(method2);
                            if (kotlinFunction == null || (parameters = kotlinFunction.getParameters()) == null) {
                                i2 = 0;
                            } else {
                                List<KParameter> list = parameters;
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                i2 = 0;
                                for (KParameter kParameter : list) {
                                    if (!kParameter.getType().isMarkedNullable() && !kParameter.isOptional()) {
                                        i2++;
                                    }
                                    arrayList.add(Unit.INSTANCE);
                                }
                            }
                            if (i2 == 0) {
                                break;
                            }
                            if (option.getParamArray().size() == UByte$$ExternalSyntheticBackport0.m(method2)) {
                                iM = UByte$$ExternalSyntheticBackport0.m(method2);
                                z = true;
                                for (i = 0; i < iM; i++) {
                                    if (!method2.getParameterTypes()[i].isInstance(option.getParamArray().get(i))) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                method3 = method2;
                                method = method3;
                                break;
                            }
                            method = method2;
                        } else {
                            if (option.getParamArray().size() == UByte$$ExternalSyntheticBackport0.m(method2)) {
                                iM = UByte$$ExternalSyntheticBackport0.m(method2);
                                z = true;
                                while (i < iM) {
                                    if (!method2.getParameterTypes()[i].isInstance(option.getParamArray().get(i))) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    break;
                                    break;
                                }
                                method3 = method2;
                                method = method3;
                                break;
                            }
                            method = method2;
                        }
                    }
                }
                method3 = method2;
            }
            if (method3 != null) {
                return ReflectJvmMapping.getKotlinFunction(method3);
            }
            if (method != null) {
                return ReflectJvmMapping.getKotlinFunction(method);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule$Companion;", "", "<init>", "()V", "instanceDynamicId", "", "getInstanceDynamicId", "()I", "setInstanceDynamicId", "(I)V", "utsInstances", "", "getUtsInstances", "()Ljava/util/Map;", "setUtsInstances", "(Ljava/util/Map;)V", "findTargetField", "Lkotlin/reflect/KCallable;", "javaClazz", "Ljava/lang/Class;", "isCompanion", "", "methodName", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getInstanceDynamicId() {
            return ProxyModule.instanceDynamicId;
        }

        public final void setInstanceDynamicId(int i) {
            ProxyModule.instanceDynamicId = i;
        }

        public final Map<Integer, Object> getUtsInstances() {
            return ProxyModule.utsInstances;
        }

        public final void setUtsInstances(Map<Integer, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            ProxyModule.utsInstances = map;
        }

        public final KCallable<?> findTargetField(Class<?> javaClazz, boolean isCompanion, String methodName) {
            Field[] declaredFields;
            Collection<KProperty1> memberProperties;
            Intrinsics.checkNotNullParameter(javaClazz, "javaClazz");
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            if (isCompanion) {
                KClass<?> companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(javaClazz));
                Intrinsics.checkNotNull(companionObject);
                for (KCallable<?> kCallable : companionObject.getMembers()) {
                    if (Intrinsics.areEqual(methodName, kCallable.getName())) {
                        return kCallable;
                    }
                }
                return null;
            }
            try {
                memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(javaClazz));
                declaredFields = null;
            } catch (Exception unused) {
                declaredFields = javaClazz.getDeclaredFields();
                memberProperties = null;
            }
            if (memberProperties != null) {
                for (KProperty1 kProperty1 : memberProperties) {
                    if (Intrinsics.areEqual(methodName, kProperty1.getName())) {
                        return kProperty1;
                    }
                }
                return null;
            }
            if (declaredFields == null || declaredFields.length == 0) {
                return null;
            }
            Iterator it = ArrayIteratorKt.iterator(declaredFields);
            while (it.hasNext()) {
                Field field = (Field) it.next();
                if (Intrinsics.areEqual(methodName, field.getName())) {
                    return ReflectJvmMapping.getKotlinProperty(field);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010\"\u001a\u00020\u001cJ0\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030A2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010\"\u001a\u00020\u001cH\u0016J\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020\u001cJ\u0006\u0010E\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\u000bR\u001a\u00102\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001a\u00108\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;", "", "options", "Lcom/alibaba/fastjson/JSONObject;", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "className", "getClassName", "setClassName", "methodName", "getMethodName", "setMethodName", "paramArray", "Lcom/alibaba/fastjson/JSONArray;", "getParamArray", "()Lcom/alibaba/fastjson/JSONArray;", "setParamArray", "(Lcom/alibaba/fastjson/JSONArray;)V", "methodArray", "getMethodArray", "setMethodArray", "isConstructor", "", "()Z", "setConstructor", "(Z)V", "isCompanion", "setCompanion", "isField", "setField", "moduleName", "getModuleName", "setModuleName", "isInstanceAction", "setInstanceAction", "instanceId", "", "getInstanceId", "()I", "setInstanceId", "(I)V", "inputModuleName", "getInputModuleName", "setInputModuleName", "inputModuleType", "getInputModuleType", "setInputModuleType", "keepAlive", "getKeepAlive", "setKeepAlive", "type", "getType", "setType", "obtainParamsWithDefault", "", "targetFunction", "Ljava/lang/reflect/Method;", WXBridgeManager.METHOD_CALLBACK, "Lcom/taobao/weex/bridge/JSCallback;", "Lkotlin/reflect/KFunction;", "getInputFlag", "checkErrorMsg", "isValid", "getErrorMsg", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InputOption {
        private String checkErrorMsg;
        private String className;
        private String inputModuleName;
        private String inputModuleType;
        private int instanceId;
        private boolean isCompanion;
        private boolean isConstructor;
        private boolean isField;
        private boolean isInstanceAction;
        private boolean keepAlive;
        private JSONArray methodArray;
        private String methodName;
        private String moduleName;
        private String packageName;
        private JSONArray paramArray;
        private String type;

        public final String getPackageName() {
            return this.packageName;
        }

        public final void setPackageName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.packageName = str;
        }

        public final String getClassName() {
            return this.className;
        }

        public final void setClassName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.className = str;
        }

        public final String getMethodName() {
            return this.methodName;
        }

        public final void setMethodName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.methodName = str;
        }

        public final JSONArray getParamArray() {
            return this.paramArray;
        }

        public final void setParamArray(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
            this.paramArray = jSONArray;
        }

        public final JSONArray getMethodArray() {
            return this.methodArray;
        }

        public final void setMethodArray(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
            this.methodArray = jSONArray;
        }

        /* JADX INFO: renamed from: isConstructor, reason: from getter */
        public final boolean getIsConstructor() {
            return this.isConstructor;
        }

        public final void setConstructor(boolean z) {
            this.isConstructor = z;
        }

        /* JADX INFO: renamed from: isCompanion, reason: from getter */
        public final boolean getIsCompanion() {
            return this.isCompanion;
        }

        public final void setCompanion(boolean z) {
            this.isCompanion = z;
        }

        /* JADX INFO: renamed from: isField, reason: from getter */
        public final boolean getIsField() {
            return this.isField;
        }

        public final void setField(boolean z) {
            this.isField = z;
        }

        public final String getModuleName() {
            return this.moduleName;
        }

        public final void setModuleName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.moduleName = str;
        }

        /* JADX INFO: renamed from: isInstanceAction, reason: from getter */
        public final boolean getIsInstanceAction() {
            return this.isInstanceAction;
        }

        public final void setInstanceAction(boolean z) {
            this.isInstanceAction = z;
        }

        public final int getInstanceId() {
            return this.instanceId;
        }

        public final void setInstanceId(int i) {
            this.instanceId = i;
        }

        public final String getInputModuleName() {
            return this.inputModuleName;
        }

        public final void setInputModuleName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inputModuleName = str;
        }

        public final String getInputModuleType() {
            return this.inputModuleType;
        }

        public final void setInputModuleType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inputModuleType = str;
        }

        public final boolean getKeepAlive() {
            return this.keepAlive;
        }

        public final void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public InputOption(JSONObject options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.packageName = "";
            this.className = "";
            this.methodName = "";
            this.paramArray = new JSONArray();
            this.methodArray = new JSONArray();
            this.moduleName = "";
            this.inputModuleName = "";
            this.inputModuleType = "";
            this.type = "";
            this.checkErrorMsg = "";
            if (options.containsKey("moduleName")) {
                Object obj = options.get("moduleName");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.inputModuleName = (String) obj;
            }
            if (options.containsKey("moduleType")) {
                Object obj2 = options.get("moduleType");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                this.inputModuleType = (String) obj2;
            }
            if (options.containsKey("keepAlive")) {
                Object obj3 = options.get("keepAlive");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                this.keepAlive = ((Boolean) obj3).booleanValue();
            }
            if (options.containsKey("package")) {
                Object obj4 = options.get("package");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                this.packageName = (String) obj4;
            }
            if (options.containsKey("class")) {
                Object obj5 = options.get("class");
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                this.className = (String) obj5;
            }
            if (options.containsKey("params")) {
                Object obj6 = options.get("params");
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.alibaba.fastjson.JSONArray");
                this.paramArray = (JSONArray) obj6;
                this.isField = false;
            } else {
                this.isField = true;
            }
            if (options.containsKey("name")) {
                Object obj7 = options.get("name");
                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
                this.methodName = (String) obj7;
            }
            if (options.containsKey("id")) {
                Object obj8 = options.get("id");
                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
                this.instanceId = ((Integer) obj8).intValue();
                this.isInstanceAction = true;
                this.moduleName = this.methodName;
            } else {
                this.isInstanceAction = false;
                if (options.containsKey("companion")) {
                    Object obj9 = options.get("companion");
                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                    this.isCompanion = ((Boolean) obj9).booleanValue();
                } else {
                    this.isCompanion = false;
                }
                if (!this.isField && Intrinsics.areEqual("constructor", this.methodName)) {
                    this.isConstructor = true;
                }
                this.moduleName = String.valueOf(this.packageName);
                if (!TextUtils.isEmpty(this.className)) {
                    this.moduleName = this.packageName + Operators.DOT + this.className;
                }
            }
            if (options.containsKey("method")) {
                JSONArray jSONArray = options.getJSONArray("method");
                Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                this.methodArray = jSONArray;
            }
            if (options.containsKey("type")) {
                String string = options.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.type = string;
            }
        }

        public static /* synthetic */ List obtainParamsWithDefault$default(InputOption inputOption, Method method, JSCallback jSCallback, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return inputOption.obtainParamsWithDefault(method, jSCallback, z);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0088  */
        /* JADX WARN: Code duplicated, block: B:19:0x009d  */
        /* JADX WARN: Code duplicated, block: B:20:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:21:0x00b0  */
        public final List<Object> obtainParamsWithDefault(Method targetFunction, JSCallback callback, boolean isField) {
            Type[] actualTypeArguments;
            String name;
            ParamConvertHelper paramConvertHelper;
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(targetFunction, "targetFunction");
            ArrayList arrayList = new ArrayList();
            if (targetFunction.getParameters().length > 0) {
                Iterator it = ArrayIteratorKt.iterator(targetFunction.getParameters());
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    Parameter parameterM = g4$$ExternalSyntheticApiModelOutline0.m(it.next());
                    if (isField) {
                        name = parameterM.getType().toString();
                        Intrinsics.checkNotNullExpressionValue(name, "toString(...)");
                    } else {
                        if (parameterM.getType() != null) {
                            Class type = parameterM.getType();
                            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
                            name = type.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        } else {
                            ParamConvertHelper.Companion companion = ParamConvertHelper.INSTANCE;
                            Class type2 = parameterM.getType();
                            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                            String strTypeNameCompat = companion.typeNameCompat(type2);
                            GenericDeclaration type3 = parameterM.getType();
                            Intrinsics.checkNotNull(type3, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                            actualTypeArguments = ((ParameterizedType) type3).getActualTypeArguments();
                            name = strTypeNameCompat;
                        }
                        paramConvertHelper = new ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                        if (i >= this.paramArray.size()) {
                            Object obj = this.methodArray.get(i2);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                            jSONObject = (JSONObject) obj;
                            if (jSONObject.get("default") == null) {
                                arrayList.add(null);
                            } else {
                                Object obj2 = jSONObject.get("default");
                                Intrinsics.checkNotNull(obj2);
                                arrayList.add(paramConvertHelper.getInstance(obj2));
                            }
                        } else {
                            arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                            i++;
                        }
                        i2++;
                    }
                    actualTypeArguments = null;
                    paramConvertHelper = new ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                    if (i >= this.paramArray.size()) {
                        Object obj3 = this.methodArray.get(i2);
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                        jSONObject = (JSONObject) obj3;
                        if (jSONObject.get("default") == null) {
                            arrayList.add(null);
                        } else {
                            Object obj4 = jSONObject.get("default");
                            Intrinsics.checkNotNull(obj4);
                            arrayList.add(paramConvertHelper.getInstance(obj4));
                        }
                    } else {
                        arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                        i++;
                    }
                    i2++;
                }
            }
            return arrayList;
        }

        public static /* synthetic */ List obtainParamsWithDefault$default(InputOption inputOption, KFunction kFunction, JSCallback jSCallback, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return inputOption.obtainParamsWithDefault((KFunction<?>) kFunction, jSCallback, z);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:26:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00cf  */
        public List<Object> obtainParamsWithDefault(KFunction<?> targetFunction, JSCallback callback, boolean isField) {
            Type[] actualTypeArguments;
            String name;
            ParamConvertHelper paramConvertHelper;
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(targetFunction, "targetFunction");
            ArrayList arrayList = new ArrayList();
            if (targetFunction.getParameters().size() > 0) {
                int i = 0;
                int i2 = 0;
                for (KParameter kParameter : targetFunction.getParameters()) {
                    if (kParameter.getKind() == KParameter.Kind.INSTANCE) {
                        if (kParameter.getName() != null || kParameter.isOptional()) {
                        }
                    } else {
                        if (isField) {
                            name = kParameter.getType().toString();
                        } else {
                            if (ReflectJvmMapping.getJavaType(kParameter.getType()) instanceof Class) {
                                Type javaType = ReflectJvmMapping.getJavaType(kParameter.getType());
                                Intrinsics.checkNotNull(javaType, "null cannot be cast to non-null type java.lang.Class<*>");
                                name = ((Class) javaType).getName();
                                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            } else {
                                String strTypeNameCompat = ParamConvertHelper.INSTANCE.typeNameCompat(ReflectJvmMapping.getJavaType(kParameter.getType()));
                                Type javaType2 = ReflectJvmMapping.getJavaType(kParameter.getType());
                                Intrinsics.checkNotNull(javaType2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                                actualTypeArguments = ((ParameterizedType) javaType2).getActualTypeArguments();
                                name = strTypeNameCompat;
                            }
                            paramConvertHelper = new ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                            if (i >= this.paramArray.size()) {
                                Object obj = this.methodArray.get(i2);
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                                jSONObject = (JSONObject) obj;
                                if (jSONObject.get("default") == null) {
                                    arrayList.add(null);
                                } else {
                                    Object obj2 = jSONObject.get("default");
                                    Intrinsics.checkNotNull(obj2);
                                    arrayList.add(paramConvertHelper.getInstance(obj2));
                                }
                            } else {
                                arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                                i++;
                            }
                        }
                        actualTypeArguments = null;
                        paramConvertHelper = new ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                        if (i >= this.paramArray.size()) {
                            Object obj3 = this.methodArray.get(i2);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                            jSONObject = (JSONObject) obj3;
                            if (jSONObject.get("default") == null) {
                                arrayList.add(null);
                            } else {
                                Object obj4 = jSONObject.get("default");
                                Intrinsics.checkNotNull(obj4);
                                arrayList.add(paramConvertHelper.getInstance(obj4));
                            }
                        } else {
                            arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                            i++;
                        }
                    }
                    i2++;
                }
            }
            return arrayList;
        }

        public final String getInputFlag() {
            return Operators.ARRAY_START_STR + this.moduleName + '-' + this.methodName + Operators.ARRAY_END;
        }

        public final boolean isValid() {
            if (!TextUtils.isEmpty(this.packageName) && !StringsKt.startsWith$default(this.packageName, "uts.sdk.modules", false, 2, (Object) null) && !StringsKt.startsWith$default(this.packageName, "uts.sdk", false, 2, (Object) null) && !StringsKt.startsWith$default(this.packageName, "uts.modules", false, 2, (Object) null)) {
                return false;
            }
            if (this.isInstanceAction) {
                return true;
            }
            if (!TextUtils.isEmpty(this.moduleName) && !TextUtils.isEmpty(this.methodName)) {
                return true;
            }
            this.checkErrorMsg = "param is null " + this.moduleName + ' ' + this.methodName;
            return false;
        }

        /* JADX INFO: renamed from: getErrorMsg, reason: from getter */
        public final String getCheckErrorMsg() {
            return this.checkErrorMsg;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFunctionExecuteRet(KFunction<?> kFunction, Object[] objArr, Continuation<Object> continuation) {
        C01031 c01031;
        if (continuation instanceof C01031) {
            c01031 = (C01031) continuation;
            if ((c01031.label & Integer.MIN_VALUE) != 0) {
                c01031.label -= Integer.MIN_VALUE;
            } else {
                c01031 = new C01031(continuation);
            }
        } else {
            c01031 = new C01031(continuation);
        }
        Object objCallSuspend = c01031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01031.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCallSuspend);
            if (kFunction.isSuspend()) {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                c01031.L$0 = SpillingKt.nullOutSpilledVariable(kFunction);
                c01031.L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                c01031.label = 1;
                objCallSuspend = callSuspend(kFunction, objArrCopyOf, c01031);
                if (objCallSuspend != coroutine_suspended) {
                }
            } else {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArr, objArr.length);
                c01031.L$0 = SpillingKt.nullOutSpilledVariable(kFunction);
                c01031.L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                c01031.label = 3;
                Object objCallSuspend2 = callSuspend(kFunction, objArrCopyOf2, c01031);
                if (objCallSuspend2 != coroutine_suspended) {
                    return objCallSuspend2;
                }
            }
        }
        if (i != 1) {
            if (i == 2) {
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCallSuspend);
            return objCallSuspend;
        }
        objArr = (Object[]) c01031.L$1;
        kFunction = (KFunction) c01031.L$0;
        ResultKt.throwOnFailure(objCallSuspend);
        Intrinsics.checkNotNull(objCallSuspend, "null cannot be cast to non-null type kotlinx.coroutines.Deferred<kotlin.Any?>");
        Deferred deferred = (Deferred) objCallSuspend;
        c01031.L$0 = SpillingKt.nullOutSpilledVariable(kFunction);
        c01031.L$1 = SpillingKt.nullOutSpilledVariable(objArr);
        c01031.L$2 = SpillingKt.nullOutSpilledVariable(deferred);
        c01031.label = 2;
        Object objAwait = deferred.await(c01031);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JSONObject wrapDoTypeAction(InputOption inputOption, Class<?> javaClazz, Object targetInstance, JSCallback callback, ReturnResult errRet) {
        String strValueOf;
        String methodName = inputOption.getMethodName();
        if (StringsKt.equals("setter", inputOption.getType(), true)) {
            StringBuilder sb = new StringBuilder("set");
            if (methodName.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                char cCharAt = methodName.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    strValueOf = CharsKt.titlecase(cCharAt, locale);
                } else {
                    strValueOf = String.valueOf(cCharAt);
                }
                sb2.append((Object) strValueOf);
                String strSubstring = methodName.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                methodName = sb2.toString();
            }
            sb.append(methodName);
            Method methodFindTargetMethod = findTargetMethod(javaClazz, sb.toString(), inputOption);
            if (methodFindTargetMethod == null) {
                errRet.updateError("method not found:" + inputOption.getInputFlag());
                return errRet.toJSON();
            }
            List listObtainParamsWithDefault$default = InputOption.obtainParamsWithDefault$default(inputOption, methodFindTargetMethod, callback, false, 4, (Object) null);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                BuildersKt__BuildersKt.runBlocking$default(null, new C01052(objectRef, errRet, methodFindTargetMethod, targetInstance, listObtainParamsWithDefault$default, null), 1, null);
            } catch (Exception e) {
                objectRef.element = null;
                if (e.getCause() != null) {
                    errRet.updateError("targetMethod error::" + e.getCause());
                } else {
                    errRet.updateError("targetMethod error::" + e);
                }
            }
            if (objectRef.element != 0) {
                if (objectRef.element instanceof UTSJSONObject) {
                    T t = objectRef.element;
                    Intrinsics.checkNotNull(t, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                    errRet.updateJSON(((UTSJSONObject) t).toJSONObject());
                } else {
                    errRet.updateJSON(objectRef.element);
                }
                errRet.toJSON();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ ReturnResult $errRet;
        final /* synthetic */ Ref.ObjectRef<Object> $executeRet;
        final /* synthetic */ List<Object> $paramList;
        final /* synthetic */ Object $targetInstance;
        final /* synthetic */ Method $targetMethod;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01052(Ref.ObjectRef<Object> objectRef, ReturnResult returnResult, Method method, Object obj, List<Object> list, Continuation<? super C01052> continuation) {
            super(2, continuation);
            this.$executeRet = objectRef;
            this.$errRet = returnResult;
            this.$targetMethod = method;
            this.$targetInstance = obj;
            this.$paramList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01052 c01052 = new C01052(this.$executeRet, this.$errRet, this.$targetMethod, this.$targetInstance, this.$paramList, continuation);
            c01052.L$0 = obj;
            return c01052;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C01052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, new ProxyModule$wrapDoTypeAction$2$invokeSuspend$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this.$executeRet, this.$errRet), null, new C00502(this.$executeRet, this.$targetMethod, this.$targetInstance, this.$paramList, null), 2, null);
        }

        /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UTSProxyModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2$2", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00502 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Object> $executeRet;
            final /* synthetic */ List<Object> $paramList;
            final /* synthetic */ Object $targetInstance;
            final /* synthetic */ Method $targetMethod;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00502(Ref.ObjectRef<Object> objectRef, Method method, Object obj, List<Object> list, Continuation<? super C00502> continuation) {
                super(2, continuation);
                this.$executeRet = objectRef;
                this.$targetMethod = method;
                this.$targetInstance = obj;
                this.$paramList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00502(this.$executeRet, this.$targetMethod, this.$targetInstance, this.$paramList, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<Object> objectRef = this.$executeRet;
                Method method = this.$targetMethod;
                Object obj2 = this.$targetInstance;
                Object[] array = this.$paramList.toArray(new Object[0]);
                objectRef.element = method.invoke(obj2, Arrays.copyOf(array, array.length));
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, io.dcloud.feature.utsplugin.ReturnResult] */
    /* JADX WARN: Type inference failed for: r0v92, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v13, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r9v4, types: [T, java.util.List] */
    @UniJSMethod(uiThread = false)
    public final Object invokeSync(JSONObject jSONObject, JSCallback jSCallback, Continuation<Object> continuation) {
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        String str;
        Ref.ObjectRef objectRef3;
        T t;
        ExceptionInInitializerError exceptionInInitializerError;
        Class<?> cls;
        boolean zIsFieldMethod;
        Object objCall;
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        objectRef4.element = new ReturnResult();
        AndroidUTSContext androidUTSContext = AndroidUTSContext.INSTANCE;
        AbsSDKInstance mUniSDKInstance = this.mUniSDKInstance;
        Intrinsics.checkNotNullExpressionValue(mUniSDKInstance, "mUniSDKInstance");
        androidUTSContext.initContext(mUniSDKInstance);
        InputOption inputOption = new InputOption(jSONObject);
        try {
            if (!inputOption.isValid()) {
                ((ReturnResult) objectRef4.element).updateError(inputOption.getCheckErrorMsg());
                return ((ReturnResult) objectRef4.element).toJSON();
            }
            Ref.ObjectRef objectRef5 = null;
            try {
                if (inputOption.getIsInstanceAction()) {
                    try {
                        if (utsInstances.get(Boxing.boxInt(inputOption.getInstanceId())) == null) {
                            throw new Exception("instance does not exists");
                        }
                        Object obj = utsInstances.get(Boxing.boxInt(inputOption.getInstanceId()));
                        Intrinsics.checkNotNull(obj);
                        Class<?> cls2 = obj.getClass();
                        Object obj2 = utsInstances.get(Boxing.boxInt(inputOption.getInstanceId()));
                        if (inputOption.getIsField()) {
                            Companion companion = INSTANCE;
                            Intrinsics.checkNotNull(obj2);
                            KCallable<?> kCallableFindTargetField = companion.findTargetField(obj2.getClass(), false, inputOption.getMethodName());
                            if (kCallableFindTargetField == null) {
                                ((ReturnResult) objectRef4.element).updateError("field not found:" + inputOption.getInputFlag());
                                return ((ReturnResult) objectRef4.element).toJSON();
                            }
                            ((ReturnResult) objectRef4.element).updateJSON(kCallableFindTargetField.call(obj2));
                            return ((ReturnResult) objectRef4.element).toJSON();
                        }
                        if (inputOption.getType().length() > 0 && Intrinsics.areEqual(inputOption.getType(), "setter")) {
                            JSONObject jSONObjectWrapDoTypeAction = wrapDoTypeAction(inputOption, cls2, obj2, jSCallback, (ReturnResult) objectRef4.element);
                            return jSONObjectWrapDoTypeAction != null ? jSONObjectWrapDoTypeAction : ((ReturnResult) objectRef4.element).toJSON();
                        }
                        KFunction<?> kFunctionFindTargetFunc = findTargetFunc(cls2, false, inputOption.getMethodName(), inputOption);
                        if (kFunctionFindTargetFunc == null) {
                            ((ReturnResult) objectRef4.element).updateError("method not found:" + inputOption.getInputFlag());
                            return ((ReturnResult) objectRef4.element).toJSON();
                        }
                        Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                        objectRef6.element = InputOption.obtainParamsWithDefault$default(inputOption, (KFunction) kFunctionFindTargetFunc, jSCallback, false, 4, (Object) null);
                        ((List) objectRef6.element).add(0, obj2);
                        try {
                            Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
                            try {
                                str = "targetMethod error::";
                                t = 0;
                                try {
                                    C01042 c01042 = new C01042(objectRef7, objectRef4, inputOption, objectRef6, cls2, this, kFunctionFindTargetFunc, null);
                                    objectRef3 = objectRef4;
                                    objectRef2 = objectRef7;
                                    try {
                                        BuildersKt__BuildersKt.runBlocking$default(null, c01042, 1, null);
                                    } catch (Exception e) {
                                        e = e;
                                        objectRef2.element = t;
                                        if (e.getCause() != null) {
                                            ((ReturnResult) objectRef3.element).updateError(str + e.getCause());
                                        } else {
                                            ((ReturnResult) objectRef3.element).updateError(str + e);
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    objectRef3 = objectRef4;
                                    objectRef2 = objectRef7;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                objectRef2 = objectRef7;
                                str = "targetMethod error::";
                                objectRef3 = objectRef4;
                                t = 0;
                            }
                            if (objectRef2.element != 0) {
                                if (objectRef2.element instanceof UTSJSONObject) {
                                    T t2 = objectRef2.element;
                                    Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                                    ((ReturnResult) objectRef3.element).updateJSON(((UTSJSONObject) t2).toJSONObject());
                                } else {
                                    ((ReturnResult) objectRef3.element).updateJSON(objectRef2.element);
                                }
                                objectRef = objectRef3;
                            } else {
                                return ((ReturnResult) objectRef3.element).toJSON();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            objectRef5 = objectRef4;
                            objectRef = objectRef5;
                            ((ReturnResult) objectRef.element).updateError(e.toString());
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                    objectRef5 = objectRef4;
                    objectRef = objectRef5;
                    ((ReturnResult) objectRef.element).updateError(e.toString());
                } else {
                    objectRef5 = objectRef4;
                    try {
                        cls = Class.forName(inputOption.getModuleName());
                        exceptionInInitializerError = null;
                    } catch (Throwable th) {
                        exceptionInInitializerError = th instanceof ExceptionInInitializerError ? th : null;
                        cls = null;
                    }
                    if (cls == null) {
                        ModuleChecker moduleChecker = new ModuleChecker(inputOption);
                        if (moduleChecker.shallShowErrorDialog()) {
                            moduleChecker.showErrorDialog();
                        }
                        if (exceptionInInitializerError != null) {
                            ((ReturnResult) objectRef5.element).updateError("初始化 " + inputOption.getInputModuleName() + " 失败 - " + exceptionInInitializerError.getException().getMessage());
                        } else {
                            ((ReturnResult) objectRef5.element).updateError("error: " + inputOption.getInputModuleName() + " not found.");
                        }
                        return ((ReturnResult) objectRef5.element).toJSON();
                    }
                    if (inputOption.getIsField()) {
                        KCallable<?> kCallableFindTargetField2 = INSTANCE.findTargetField(cls, inputOption.getIsCompanion(), inputOption.getMethodName());
                        if (kCallableFindTargetField2 == null) {
                            ((ReturnResult) objectRef5.element).updateError("field not found:" + inputOption.getInputFlag());
                            return ((ReturnResult) objectRef5.element).toJSON();
                        }
                        ((ReturnResult) objectRef5.element).updateJSON(inputOption.getIsCompanion() ? kCallableFindTargetField2.call(KClasses.getCompanionObjectInstance(JvmClassMappingKt.getKotlinClass(cls))) : kCallableFindTargetField2.call(cls));
                        return ((ReturnResult) objectRef5.element).toJSON();
                    }
                    if (inputOption.getIsConstructor()) {
                        Collection constructors = JvmClassMappingKt.getKotlinClass(cls).getConstructors();
                        if (constructors.isEmpty()) {
                            objCall = cls.newInstance();
                            Intrinsics.checkNotNullExpressionValue(objCall, "newInstance(...)");
                        } else {
                            KFunction kFunction = ((KFunction[]) constructors.toArray(new KFunction[0]))[0];
                            Object[] array = InputOption.obtainParamsWithDefault$default(inputOption, kFunction, jSCallback, false, 4, (Object) null).toArray(new Object[0]);
                            objCall = kFunction.call(Arrays.copyOf(array, array.length));
                            Intrinsics.checkNotNullExpressionValue(objCall, "call(...)");
                        }
                        int i = instanceDynamicId + 1;
                        instanceDynamicId = i;
                        utsInstances.put(Boxing.boxInt(i), objCall);
                        ((ReturnResult) objectRef5.element).updateJSON(Boxing.boxInt(instanceDynamicId));
                        return objectRef5.element;
                    }
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = findTargetFunc(cls, inputOption.getIsCompanion(), inputOption.getMethodName(), inputOption);
                    FieldMethodDetector fieldMethodDetector = new FieldMethodDetector(cls, inputOption);
                    if (objectRef.element == 0) {
                        fieldMethodDetector.init();
                        zIsFieldMethod = fieldMethodDetector.isFieldMethod();
                        objectRef.element = fieldMethodDetector.getTargetFunction();
                    } else {
                        zIsFieldMethod = false;
                    }
                    if (objectRef.element == 0) {
                        ((ReturnResult) objectRef5.element).updateError("method not found:" + inputOption.getInputFlag());
                        return ((ReturnResult) objectRef5.element).toJSON();
                    }
                    Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                    objectRef8.element = inputOption.obtainParamsWithDefault((KFunction<?>) objectRef.element, jSCallback, zIsFieldMethod);
                    if (inputOption.getIsCompanion()) {
                        ((List) objectRef8.element).add(0, KClasses.getCompanionObjectInstance(JvmClassMappingKt.getKotlinClass(cls)));
                    }
                    Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
                    try {
                        if (!zIsFieldMethod) {
                            try {
                                objectRef = objectRef5;
                                try {
                                    BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass3(objectRef9, objectRef, objectRef8, this, objectRef, null), 1, null);
                                } catch (Exception e6) {
                                    e = e6;
                                    objectRef9.element = null;
                                    if (e.getCause() != null) {
                                        ((ReturnResult) objectRef.element).updateError("targetMethod error::" + e.getCause());
                                    } else {
                                        ((ReturnResult) objectRef.element).updateError("targetMethod error::" + e);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                objectRef = objectRef5;
                            }
                        } else {
                            objectRef = objectRef5;
                            Object[] array2 = ((Collection) objectRef8.element).toArray(new Object[0]);
                            Method fieldFunMethod = fieldMethodDetector.getFieldFunMethod();
                            Intrinsics.checkNotNull(fieldFunMethod);
                            objectRef9.element = fieldFunMethod.invoke(fieldMethodDetector.getHostFunction(), Arrays.copyOf(array2, array2.length));
                        }
                        if (objectRef9.element != 0) {
                            if (objectRef9.element instanceof UTSJSONObject) {
                                T t3 = objectRef9.element;
                                Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                                ((ReturnResult) objectRef.element).updateJSON(((UTSJSONObject) t3).toJSONObject());
                            } else {
                                ((ReturnResult) objectRef.element).updateJSON(objectRef9.element);
                            }
                        } else {
                            return ((ReturnResult) objectRef.element).toJSON();
                        }
                    } catch (Exception e8) {
                        e = e8;
                        ((ReturnResult) objectRef.element).updateError(e.toString());
                    }
                }
            } catch (Exception e9) {
                e = e9;
            }
            return ((ReturnResult) objectRef.element).toJSON();
        } catch (Exception e10) {
            e = e10;
            objectRef = objectRef4;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Ref.ObjectRef<ReturnResult> $errRet;
        final /* synthetic */ Ref.ObjectRef<Object> $executeRet;
        final /* synthetic */ InputOption $inputOption;
        final /* synthetic */ Class<Object> $javaClazz;
        final /* synthetic */ Ref.ObjectRef<List<Object>> $paramList;
        final /* synthetic */ KFunction<?> $targetFunction;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01042(Ref.ObjectRef<Object> objectRef, Ref.ObjectRef<ReturnResult> objectRef2, InputOption inputOption, Ref.ObjectRef<List<Object>> objectRef3, Class<Object> cls, ProxyModule proxyModule, KFunction<?> kFunction, Continuation<? super C01042> continuation) {
            super(2, continuation);
            this.$executeRet = objectRef;
            this.$errRet = objectRef2;
            this.$inputOption = inputOption;
            this.$paramList = objectRef3;
            this.$javaClazz = cls;
            this.this$0 = proxyModule;
            this.$targetFunction = kFunction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01042 c01042 = new C01042(this.$executeRet, this.$errRet, this.$inputOption, this.$paramList, this.$javaClazz, this.this$0, this.$targetFunction, continuation);
            c01042.L$0 = obj;
            return c01042;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C01042) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, new ProxyModule$invokeSync$2$invokeSuspend$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this.$executeRet, this.$errRet), null, new C00492(this.$inputOption, this.$paramList, this.$javaClazz, this.$executeRet, this.this$0, this.$targetFunction, null), 2, null);
        }

        /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UTSProxyModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2$2", f = "UTSProxyModule.kt", i = {0}, l = {846}, m = "invokeSuspend", n = {"paramArray"}, s = {"L$0"})
        static final class C00492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Object> $executeRet;
            final /* synthetic */ InputOption $inputOption;
            final /* synthetic */ Class<Object> $javaClazz;
            final /* synthetic */ Ref.ObjectRef<List<Object>> $paramList;
            final /* synthetic */ KFunction<?> $targetFunction;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ ProxyModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00492(InputOption inputOption, Ref.ObjectRef<List<Object>> objectRef, Class<Object> cls, Ref.ObjectRef<Object> objectRef2, ProxyModule proxyModule, KFunction<?> kFunction, Continuation<? super C00492> continuation) {
                super(2, continuation);
                this.$inputOption = inputOption;
                this.$paramList = objectRef;
                this.$javaClazz = cls;
                this.$executeRet = objectRef2;
                this.this$0 = proxyModule;
                this.$targetFunction = kFunction;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00492(this.$inputOption, this.$paramList, this.$javaClazz, this.$executeRet, this.this$0, this.$targetFunction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Ref.ObjectRef<Object> objectRef;
                T t;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$inputOption.getIsCompanion()) {
                        List<Object> list = this.$paramList.element;
                        Object companionObject = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(this.$javaClazz));
                        Intrinsics.checkNotNull(companionObject, "null cannot be cast to non-null type kotlin.Nothing");
                        list.add(0, (Void) companionObject);
                    }
                    Object[] array = this.$paramList.element.toArray(new Object[0]);
                    Ref.ObjectRef<Object> objectRef2 = this.$executeRet;
                    ProxyModule proxyModule = this.this$0;
                    KFunction<?> kFunction = this.$targetFunction;
                    Intrinsics.checkNotNull(kFunction);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                    this.L$1 = objectRef2;
                    this.label = 1;
                    Object functionExecuteRet = proxyModule.getFunctionExecuteRet(kFunction, array, this);
                    if (functionExecuteRet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    t = functionExecuteRet;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Ref.ObjectRef<ReturnResult> $errRet;
        final /* synthetic */ Ref.ObjectRef<Object> $executeRet;
        final /* synthetic */ Ref.ObjectRef<List<Object>> $paramList;
        final /* synthetic */ Ref.ObjectRef<KFunction<?>> $targetFunction;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef<Object> objectRef, Ref.ObjectRef<ReturnResult> objectRef2, Ref.ObjectRef<List<Object>> objectRef3, ProxyModule proxyModule, Ref.ObjectRef<KFunction<?>> objectRef4, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$executeRet = objectRef;
            this.$errRet = objectRef2;
            this.$paramList = objectRef3;
            this.this$0 = proxyModule;
            this.$targetFunction = objectRef4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$executeRet, this.$errRet, this.$paramList, this.this$0, this.$targetFunction, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, new ProxyModule$invokeSync$3$invokeSuspend$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this.$executeRet, this.$errRet), null, new AnonymousClass2(this.$paramList, this.$executeRet, this.this$0, this.$targetFunction, null), 2, null);
        }

        /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: UTSProxyModule.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3$2", f = "UTSProxyModule.kt", i = {0}, l = {1001}, m = "invokeSuspend", n = {"paramArray"}, s = {"L$0"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Object> $executeRet;
            final /* synthetic */ Ref.ObjectRef<List<Object>> $paramList;
            final /* synthetic */ Ref.ObjectRef<KFunction<?>> $targetFunction;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ ProxyModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Ref.ObjectRef<List<Object>> objectRef, Ref.ObjectRef<Object> objectRef2, ProxyModule proxyModule, Ref.ObjectRef<KFunction<?>> objectRef3, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$paramList = objectRef;
                this.$executeRet = objectRef2;
                this.this$0 = proxyModule;
                this.$targetFunction = objectRef3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$paramList, this.$executeRet, this.this$0, this.$targetFunction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Ref.ObjectRef<Object> objectRef;
                T t;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Object[] array = this.$paramList.element.toArray(new Object[0]);
                    Ref.ObjectRef<Object> objectRef2 = this.$executeRet;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                    this.L$1 = objectRef2;
                    this.label = 1;
                    Object functionExecuteRet = this.this$0.getFunctionExecuteRet(this.$targetFunction.element, array, this);
                    if (functionExecuteRet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    t = functionExecuteRet;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <R> Object callSuspend(KCallable<? extends R> kCallable, Object[] objArr, Continuation<? super R> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCall = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCall);
            if (!kCallable.isSuspend()) {
                return kCallable.call(Arrays.copyOf(objArr, objArr.length));
            }
            if (!(kCallable instanceof KFunction)) {
                throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
            }
            anonymousClass1.L$0 = kCallable;
            anonymousClass1.L$1 = objArr;
            anonymousClass1.label = 1;
            AnonymousClass1 anonymousClass2 = anonymousClass1;
            List mutableList = ArraysKt.toMutableList(objArr);
            mutableList.add(anonymousClass2);
            Object[] array = mutableList.toArray(new Object[0]);
            objCall = kCallable.call(Arrays.copyOf(array, array.length));
            if (objCall == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
            }
            if (objCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kCallable = (KCallable) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCall);
        }
        KFunction kFunction = (KFunction) kCallable;
        return (!Intrinsics.areEqual(kFunction.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || kFunction.getReturnType().isMarkedNullable()) ? objCall : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule$ModuleChecker;", "", "inputOption", "Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;", "<init>", "(Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;)V", "shallShowErrorDialog", "", "showErrorDialog", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ModuleChecker {
        private final InputOption inputOption;

        public ModuleChecker(InputOption inputOption) {
            Intrinsics.checkNotNullParameter(inputOption, "inputOption");
            this.inputOption = inputOption;
        }

        public final boolean shallShowErrorDialog() {
            if (StringsKt.equals("built-in", this.inputOption.getInputModuleType(), true)) {
                return !Intrinsics.areEqual("uni-getLocation-tencent-uni1", this.inputOption.getInputModuleName());
            }
            return false;
        }

        public final void showErrorDialog() {
            if (UTSAndroid.INSTANCE.getUniActivity() != null) {
                StringBuilder sb = new StringBuilder();
                Activity uniActivity = UTSAndroid.INSTANCE.getUniActivity();
                Intrinsics.checkNotNull(uniActivity);
                sb.append(uniActivity.getString(io.dcloud.base.R.string.dcloud_feature_error_tips2));
                sb.append("https://ask.dcloud.net.cn/article/283");
                ErrorDialogUtil.getLossDialog(UTSAndroid.INSTANCE.getUniActivity(), StringUtil.format(sb.toString(), this.inputOption.getInputModuleName()), "https://ask.dcloud.net.cn/article/283", this.inputOption.getInputModuleName()).show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r0v34, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.util.List] */
    @UniJSMethod(uiThread = false)
    public Object invokeAsync(JSONObject jSONObject, JSCallback jSCallback, Continuation<? super Unit> continuation) {
        Class<?> cls;
        AndroidUTSContext androidUTSContext = AndroidUTSContext.INSTANCE;
        AbsSDKInstance mUniSDKInstance = this.mUniSDKInstance;
        Intrinsics.checkNotNullExpressionValue(mUniSDKInstance, "mUniSDKInstance");
        androidUTSContext.initContext(mUniSDKInstance);
        InputOption inputOption = new InputOption(jSONObject);
        try {
            if (!inputOption.isValid()) {
                AppConsoleLogUtil.DCLog("UTS: " + inputOption.getCheckErrorMsg(), "ERROR");
                return Unit.INSTANCE;
            }
            if (!inputOption.getIsInstanceAction()) {
                try {
                    cls = Class.forName(inputOption.getModuleName());
                } catch (ClassNotFoundException unused) {
                    cls = null;
                }
                if (cls == null) {
                    ModuleChecker moduleChecker = new ModuleChecker(inputOption);
                    if (moduleChecker.shallShowErrorDialog()) {
                        moduleChecker.showErrorDialog();
                    }
                    AppConsoleLogUtil.DCLog("error: " + inputOption.getInputModuleName() + " not found.", "ERROR");
                    return Unit.INSTANCE;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = findTargetFunc(cls, inputOption.getIsCompanion(), inputOption.getMethodName(), inputOption);
                FieldMethodDetector fieldMethodDetector = new FieldMethodDetector(cls, inputOption);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                if (objectRef.element == 0) {
                    fieldMethodDetector.init();
                    booleanRef.element = fieldMethodDetector.isFieldMethod();
                    objectRef.element = fieldMethodDetector.getTargetFunction();
                }
                if (objectRef.element == 0) {
                    AppConsoleLogUtil.DCLog("UTS: targetFunction not exists", "ERROR");
                    return Unit.INSTANCE;
                }
                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                booleanRef2.element = !Intrinsics.areEqual(((KFunction) objectRef.element).getReturnType(), Void.TYPE);
                Class<?> cls2 = cls;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = inputOption.obtainParamsWithDefault((KFunction<?>) objectRef.element, jSCallback, booleanRef.element);
                if (inputOption.getIsCompanion()) {
                    ((List) objectRef2.element).add(0, KClasses.getCompanionObjectInstance(JvmClassMappingKt.getKotlinClass(cls2)));
                }
                try {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new ProxyModule$invokeAsync$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE), null, new AnonymousClass4(objectRef2, booleanRef2, booleanRef, this, objectRef, fieldMethodDetector, jSCallback, null), 2, null);
                } catch (Exception e) {
                    AppConsoleLogUtil.DCLog("UTS: targetFunction invoke error - " + (e.getCause() != null ? String.valueOf(e.getCause()) : e.toString()), "ERROR");
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                if (utsInstances.get(Boxing.boxInt(inputOption.getInstanceId())) == null) {
                    AppConsoleLogUtil.DCLog("UTS: instance does not exists", "ERROR");
                    return Unit.INSTANCE;
                }
                Object obj = utsInstances.get(Boxing.boxInt(inputOption.getInstanceId()));
                Intrinsics.checkNotNull(obj);
                Class<?> cls3 = obj.getClass();
                Object obj2 = utsInstances.get(Boxing.boxInt(inputOption.getInstanceId()));
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = findTargetFunc(cls3, false, inputOption.getMethodName(), inputOption);
                if (objectRef3.element == 0) {
                    AppConsoleLogUtil.DCLog("UTS: targetFunction does not exists", "ERROR");
                    return Unit.INSTANCE;
                }
                Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                booleanRef3.element = !Intrinsics.areEqual(((KFunction) objectRef3.element).getReturnType(), Void.TYPE);
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                objectRef4.element = InputOption.obtainParamsWithDefault$default(inputOption, (KFunction) objectRef3.element, jSCallback, false, 4, (Object) null);
                ((List) objectRef4.element).add(0, obj2);
                try {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(objectRef4, booleanRef3, this, objectRef3, jSCallback, null), 3, null);
                } catch (Exception e2) {
                    AppConsoleLogUtil.DCLog("UTS: targetFunction invoke error - " + (e2.getCause() != null ? String.valueOf(e2.getCause()) : e2.toString()), "ERROR");
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        } catch (Exception e3) {
            AppConsoleLogUtil.DCLog("UTS: targetFunction invoke error - " + (e3.getCause() != null ? String.valueOf(e3.getCause()) : e3.toString()), "ERROR");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$2", f = "UTSProxyModule.kt", i = {0, 1, 1, 1, 2}, l = {1171, 1175, 1187}, m = "invokeSuspend", n = {"paramArray", "paramArray", "deferredRet", "ret", "paramArray"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSCallback $callback;
        final /* synthetic */ Ref.BooleanRef $needReturn;
        final /* synthetic */ Ref.ObjectRef<List<Object>> $paramList;
        final /* synthetic */ Ref.ObjectRef<KFunction<?>> $targetFunction;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<List<Object>> objectRef, Ref.BooleanRef booleanRef, ProxyModule proxyModule, Ref.ObjectRef<KFunction<?>> objectRef2, JSCallback jSCallback, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$paramList = objectRef;
            this.$needReturn = booleanRef;
            this.this$0 = proxyModule;
            this.$targetFunction = objectRef2;
            this.$callback = jSCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$paramList, this.$needReturn, this.this$0, this.$targetFunction, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0098  */
        /* JADX WARN: Code duplicated, block: B:23:0x009d  */
        /* JADX WARN: Code duplicated, block: B:24:0x00a7  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00d2, code lost:
        
            if (r9.callSuspend(r3, java.util.Arrays.copyOf(r1, r1.length), r8) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object[] array;
            ReturnResult returnResult;
            ReturnResult returnResult2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    array = (Object[]) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Deferred<kotlin.Any?>");
                    Deferred deferred = (Deferred) obj;
                    returnResult = new ReturnResult();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
                    this.L$2 = returnResult;
                    this.label = 2;
                    obj = deferred.await(this);
                    if (obj != coroutine_suspended) {
                        returnResult2 = returnResult;
                    }
                    return coroutine_suspended;
                }
                if (i == 2) {
                    returnResult2 = (ReturnResult) this.L$2;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("params", new JSONArray());
                    JSCallback jSCallback = this.$callback;
                    Intrinsics.checkNotNull(jSCallback);
                    jSCallback.invoke(jSONObject);
                }
                if (obj instanceof UTSJSONObject) {
                    returnResult2.updateJSON(((UTSJSONObject) obj).toJSONObject());
                } else {
                    returnResult2.updateJSON(obj);
                }
                JSCallback jSCallback2 = this.$callback;
                Intrinsics.checkNotNull(jSCallback2);
                jSCallback2.invoke(returnResult2);
            } else {
                ResultKt.throwOnFailure(obj);
                array = this.$paramList.element.toArray(new Object[0]);
                if (this.$needReturn.element) {
                    ProxyModule proxyModule = this.this$0;
                    KFunction<?> kFunction = this.$targetFunction.element;
                    Intrinsics.checkNotNull(kFunction);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                    this.label = 1;
                    obj = proxyModule.callSuspend(kFunction, Arrays.copyOf(array, array.length), this);
                    if (obj != coroutine_suspended) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Deferred<kotlin.Any?>");
                        Deferred deferred2 = (Deferred) obj;
                        returnResult = new ReturnResult();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(deferred2);
                        this.L$2 = returnResult;
                        this.label = 2;
                        obj = deferred2.await(this);
                        if (obj != coroutine_suspended) {
                            returnResult2 = returnResult;
                            if (obj instanceof UTSJSONObject) {
                                returnResult2.updateJSON(((UTSJSONObject) obj).toJSONObject());
                            } else {
                                returnResult2.updateJSON(obj);
                            }
                            JSCallback jSCallback3 = this.$callback;
                            Intrinsics.checkNotNull(jSCallback3);
                            jSCallback3.invoke(returnResult2);
                        }
                    }
                } else {
                    ProxyModule proxyModule2 = this.this$0;
                    KFunction<?> kFunction2 = this.$targetFunction.element;
                    Intrinsics.checkNotNull(kFunction2);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$4, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$4", f = "UTSProxyModule.kt", i = {0, 1, 1, 2}, l = {1277, 1282, TestUtil.PointTime.AC_TYPE_1_3}, m = "invokeSuspend", n = {"paramArray", "paramArray", "deferredRet", "paramArray"}, s = {"L$0", "L$0", "L$1", "L$0"})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSCallback $callback;
        final /* synthetic */ FieldMethodDetector $fieldMethodDetector;
        final /* synthetic */ Ref.BooleanRef $isFieldMethod;
        final /* synthetic */ Ref.BooleanRef $needReturn;
        final /* synthetic */ Ref.ObjectRef<List<Object>> $paramList;
        final /* synthetic */ Ref.ObjectRef<KFunction<?>> $targetFunction;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef<List<Object>> objectRef, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, ProxyModule proxyModule, Ref.ObjectRef<KFunction<?>> objectRef2, FieldMethodDetector fieldMethodDetector, JSCallback jSCallback, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$paramList = objectRef;
            this.$needReturn = booleanRef;
            this.$isFieldMethod = booleanRef2;
            this.this$0 = proxyModule;
            this.$targetFunction = objectRef2;
            this.$fieldMethodDetector = fieldMethodDetector;
            this.$callback = jSCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$paramList, this.$needReturn, this.$isFieldMethod, this.this$0, this.$targetFunction, this.$fieldMethodDetector, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
        
            if (r10 == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00ad, code lost:
        
            if (r10 == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ed, code lost:
        
            if (r9.this$0.callSuspend(r9.$targetFunction.element, java.util.Arrays.copyOf(r1, r1.length), r9) == r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IllegalAccessException, InvocationTargetException {
            Object[] array;
            Deferred deferred;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    array = (Object[]) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.Deferred<kotlin.Any?>");
                    deferred = (Deferred) obj;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
                    this.label = 2;
                    obj = deferred.await(this);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("params", new JSONArray());
                    JSCallback jSCallback = this.$callback;
                    Intrinsics.checkNotNull(jSCallback);
                    jSCallback.invoke(jSONObject);
                }
                if (obj instanceof UTSJSONObject) {
                    obj = ((UTSJSONObject) obj).toJSONObject();
                }
                ReturnResult returnResult = new ReturnResult();
                returnResult.updateJSON(obj);
                JSCallback jSCallback2 = this.$callback;
                Intrinsics.checkNotNull(jSCallback2);
                jSCallback2.invoke(returnResult);
            } else {
                ResultKt.throwOnFailure(obj);
                array = this.$paramList.element.toArray(new Object[0]);
                if (this.$needReturn.element) {
                    if (!this.$isFieldMethod.element) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                        this.label = 1;
                        obj = this.this$0.callSuspend(this.$targetFunction.element, Arrays.copyOf(array, array.length), this);
                    } else {
                        Method fieldFunMethod = this.$fieldMethodDetector.getFieldFunMethod();
                        Intrinsics.checkNotNull(fieldFunMethod);
                        Object objInvoke = fieldFunMethod.invoke(this.$fieldMethodDetector.getHostFunction(), Arrays.copyOf(array, array.length));
                        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlinx.coroutines.Deferred<kotlin.Any?>");
                        deferred = (Deferred) objInvoke;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
                        this.label = 2;
                        obj = deferred.await(this);
                    }
                } else {
                    if (this.$isFieldMethod.element) {
                        Method fieldFunMethod2 = this.$fieldMethodDetector.getFieldFunMethod();
                        Intrinsics.checkNotNull(fieldFunMethod2);
                        fieldFunMethod2.invoke(this.$fieldMethodDetector.getHostFunction(), Arrays.copyOf(array, array.length));
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(array);
                        this.label = 3;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("params", new JSONArray());
                    JSCallback jSCallback3 = this.$callback;
                    Intrinsics.checkNotNull(jSCallback3);
                    jSCallback3.invoke(jSONObject2);
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // io.dcloud.common.DHInterface.message.IObserveAble
    public EnumUniqueID getActionObserverID() {
        return EnumUniqueID.FEATURE_UTS;
    }
}
