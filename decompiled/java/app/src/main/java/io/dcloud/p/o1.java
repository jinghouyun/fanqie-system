package io.dcloud.p;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class o1 {
    private static volatile o1 a;

    private o1() {
    }

    public static o1 a() {
        if (a == null) {
            synchronized (o1.class) {
                if (a == null) {
                    a = new o1();
                }
            }
        }
        return a;
    }

    public String a(Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.containsKey("com.google.android.gms.ads.APPLICATION_ID")) {
                Method declaredMethod = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", Context.class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, context);
                Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("getId", null);
                declaredMethod2.setAccessible(true);
                return (String) declaredMethod2.invoke(objInvoke, null);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
