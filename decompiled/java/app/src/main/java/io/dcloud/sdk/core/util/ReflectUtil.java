package io.dcloud.sdk.core.util;

import com.taobao.weex.common.RenderTypes;
import io.dcloud.p.c3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class ReflectUtil {
    public static Object invokeField(String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr == null || objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object newInstance(String str, Class[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            c3.a(RenderTypes.RENDER_TYPE_NATIVE, th.toString());
            return null;
        }
    }

    public static Object invokeMethod(String str, String str2, Object obj, Class[] clsArr, Object[] objArr) {
        String message;
        Object objInvoke;
        String str3 = null;
        try {
            Method method = Class.forName(str).getMethod(str2, clsArr);
            if (method != null) {
                method.setAccessible(true);
                objInvoke = method.invoke(obj, objArr);
            } else {
                objInvoke = null;
            }
        } catch (ClassNotFoundException unused) {
            message = "ClassNotFoundException";
            str3 = message;
            objInvoke = null;
        } catch (NoSuchMethodException unused2) {
            message = "NoSuchMethodException";
            str3 = message;
            objInvoke = null;
        } catch (Exception e) {
            message = e.getMessage();
            str3 = message;
            objInvoke = null;
        }
        if (str3 != null) {
            "getJsContent".equals(str2);
        }
        return objInvoke;
    }

    public static Object invokeMethod(String str, String str2, Object obj) {
        return invokeMethod(str, str2, obj, new Class[0], new Object[0]);
    }
}
