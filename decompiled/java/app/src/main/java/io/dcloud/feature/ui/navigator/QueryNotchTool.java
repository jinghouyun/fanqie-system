package io.dcloud.feature.ui.navigator;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import io.dcloud.common.adapter.util.MobilePhoneModel;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class QueryNotchTool {
    public static final int NOTCH_IN_SCREEN_VOIO = 32;
    public static final int ROUNDED_IN_SCREEN_VOIO = 8;

    public static boolean hasNotchInHuawei(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method method = clsLoadClass.getMethod("hasNotchInScreen", null);
            if (method != null) {
                return ((Boolean) method.invoke(clsLoadClass, null)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNotchInOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInScreen(Activity activity) {
        if (MobilePhoneModel.isAppointPhone(MobilePhoneModel.XIAOMI)) {
            return hasNotchInXiaomi(activity);
        }
        if (MobilePhoneModel.isAppointPhone(MobilePhoneModel.VIVO)) {
            return hasNotchInVoio(activity);
        }
        if (MobilePhoneModel.isAppointPhone(MobilePhoneModel.OPPO)) {
            return hasNotchInOppo(activity);
        }
        if (MobilePhoneModel.isAppointPhone(MobilePhoneModel.HUAWEI) || MobilePhoneModel.isAppointPhone(MobilePhoneModel.HONOR)) {
            return hasNotchInHuawei(activity);
        }
        return isAndroidP(activity) != null;
    }

    public static boolean hasNotchInVoio(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNotchInXiaomi(Context context) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE).invoke(null, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
        }
    }

    public static DisplayCutout isAndroidP(Activity activity) {
        WindowInsets rootWindowInsets;
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null || Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }
}
