package io.dcloud.p;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.core.ErrorCode;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class m3 {
    private static m3 b;
    private String a = "";

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class a implements InvocationHandler {
        Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getName().equalsIgnoreCase("OnSupport") && objArr != null && objArr.length > 0) {
                ((Boolean) objArr[0]).getClass();
                Object obj2 = objArr.length > 1 ? objArr[1] : null;
                if (obj2 != null) {
                    Object objA = m3.a(obj2, "getOAID", null, new Object[0]);
                    Object objA2 = m3.a(obj2, "getVAID", null, new Object[0]);
                    Object objA3 = m3.a(obj2, "getAAID", null, new Object[0]);
                    (objA == null ? "" : objA).toString();
                    if (objA2 == null) {
                        objA2 = "";
                    }
                    objA2.toString();
                    if (objA3 == null) {
                        objA3 = "";
                    }
                    objA3.toString();
                    m3.this.a = String.valueOf(objA);
                    Context context = this.a;
                    if (context != null) {
                        e4.a(context, "dcloud-ads", "oaid", String.valueOf(objA));
                    }
                }
            }
            return null;
        }
    }

    private m3() {
    }

    private boolean b(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        int iA = a(context);
        return (iA == 1008612 || iA == 1008613 || iA == 1008611 || iA != 1008614) ? false : true;
    }

    public String c(Context context) {
        if (TextUtils.isEmpty(this.a)) {
            if (!b(context)) {
                return "";
            }
            if (context != null) {
                this.a = e4.a(context, "dcloud-ads", "oaid");
            }
        }
        return this.a;
    }

    public static m3 a() {
        if (b == null) {
            synchronized (m3.class) {
                if (b == null) {
                    b = new m3();
                }
            }
        }
        return b;
    }

    private int a(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls;
        try {
            Class<?> cls2 = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            try {
                cls = Class.forName("com.bun.supplier.IIdentifierListener");
            } catch (Exception unused) {
                cls = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
            }
            Object objNewProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new a(context));
            Method declaredMethod = cls2.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, cls);
            Object objInvoke = null;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, context, Boolean.TRUE, objNewProxyInstance);
            }
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        } catch (Exception unused2) {
        }
        return ErrorCode.INIT_HELPER_CALL_ERROR;
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
