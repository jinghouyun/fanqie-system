package io.dcloud.p;

import android.content.Context;
import android.text.TextUtils;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.sdk.core.DCloudAOLManager;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 {
    public static Object a() {
        try {
            String str = BaseInfo.sGlobalUserAgent;
            Field declaredField = BaseInfo.class.getDeclaredField("sBaseVersion");
            declaredField.setAccessible(true);
            return declaredField.get(BaseInfo.class);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return DCloudAOLManager.getVersion();
        }
    }

    public static int c() {
        return 0;
    }

    public static String b() {
        try {
            return Locale.forLanguageTag((String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "persist.sys.locale")).getCountry();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        String string;
        String packageName = context.getPackageName();
        try {
            string = context.getPackageManager().getApplicationInfo(packageName, 128).metaData.getString("DCLOUD_STREAMAPP_CHANNEL");
        } catch (Exception unused) {
            string = null;
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return packageName + "|" + r0.d().b().getAppId() + "|" + r0.d().b().getAdId();
    }
}
