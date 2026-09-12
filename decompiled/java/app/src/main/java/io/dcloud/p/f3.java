package io.dcloud.p;

import android.content.Context;
import com.bun.miitmdid.core.ErrorCode;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.util.PdrUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class f3 {
    private b a;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface b {
        void a(String str, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class c implements InvocationHandler {
        private c() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equalsIgnoreCase("OnSupport") && objArr != null && objArr.length > 0) {
                boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                Object obj2 = objArr.length > 1 ? objArr[1] : null;
                StringBuilder sb = new StringBuilder();
                if (obj2 == null) {
                    sb.append(Operators.OR);
                } else {
                    Object objInvokeMethod = PlatformUtil.invokeMethod(obj2, "getOAID", null, new Object[0]);
                    Object objInvokeMethod2 = PlatformUtil.invokeMethod(obj2, "getVAID", null, new Object[0]);
                    Object objInvokeMethod3 = PlatformUtil.invokeMethod(obj2, "getAAID", null, new Object[0]);
                    if (objInvokeMethod == null) {
                        objInvokeMethod = "";
                    }
                    sb.append(objInvokeMethod);
                    sb.append("|");
                    if (objInvokeMethod2 == null) {
                        objInvokeMethod2 = "";
                    }
                    sb.append(objInvokeMethod2);
                    sb.append("|");
                    if (objInvokeMethod3 == null) {
                        objInvokeMethod3 = "";
                    }
                    sb.append(objInvokeMethod3);
                }
                if (f3.this.a != null) {
                    f3.this.a.a(sb.toString(), zBooleanValue);
                }
            }
            return null;
        }
    }

    public f3(b bVar) {
        this.a = bVar;
    }

    public boolean b(Context context) {
        int iA;
        return (PdrUtil.checkIntl() || (iA = a(context)) == 1008612 || iA == 1008613 || iA == 1008611 || iA != 1008614) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int a(Context context) {
        Class<?> cls;
        try {
            try {
                Class<?> cls2 = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
                try {
                    cls = Class.forName("com.bun.supplier.IIdentifierListener");
                } catch (Exception unused) {
                    cls = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                }
                Object objInvoke = null;
                Object objNewProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new c());
                Method declaredMethod = cls2.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, cls);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    objInvoke = declaredMethod.invoke(null, context, Boolean.TRUE, objNewProxyInstance);
                }
                return objInvoke instanceof Integer ? ((Integer) objInvoke).intValue() : ErrorCode.INIT_HELPER_CALL_ERROR;
            } catch (Throwable unused2) {
                return ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT;
            }
        } catch (Exception unused3) {
            return ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }
}
