package io.dcloud.p;

import android.os.Build;
import android.text.TextUtils;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.utils.tools.TimeCalculator;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 {
    private static String a = "";
    private static String b = "";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return a;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return b;
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ec, code lost:
    
        if (r6.equals("XIAOMI") != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0101, code lost:
    
        if (r6.equals("REALME") != false) goto L59;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(String str) {
        try {
            String strA = a(str);
            switch (strA.hashCode()) {
                case -1881642058:
                    break;
                case -1706170181:
                    break;
                case -602397472:
                    if (strA.equals("ONEPLUS")) {
                        a = "HydrogenOS";
                        b = d("ro.rom.version");
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 2432928:
                    if (strA.equals("OPPO")) {
                        a = "ColorOS";
                        b = d("ro.build.version.opporom");
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 2634924:
                    if (strA.equals("VIVO")) {
                        a = "Funtouch";
                        b = d("ro.vivo.os.version");
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 68924490:
                    if (strA.equals("HONOR")) {
                        if (a()) {
                            a = "HarmonyOS";
                            if (!TextUtils.isEmpty(d("hw_sc.build.platform.version"))) {
                                b = d("hw_sc.build.platform.version");
                            } else {
                                b = "";
                            }
                        } else if (!TextUtils.isEmpty(d("ro.build.version.magic"))) {
                            a = "MagicUI";
                            b = d("ro.build.version.magic");
                        } else {
                            a = "EMUI";
                            b = d("ro.build.version.emui");
                        }
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 73239724:
                    if (strA.equals("MEIZU")) {
                        a = "Flyme";
                        b = d("ro.build.display.id");
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 74632627:
                    if (strA.equals("NUBIA")) {
                        a = d("ro.build.nubia.rom.name");
                        b = d("ro.build.nubia.rom.code");
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 77852109:
                    if (strA.equals("REDMI")) {
                        a = "MIUI";
                        b = d("ro.miui.ui.version.name");
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                case 2141820391:
                    if (strA.equals("HUAWEI")) {
                        if (!a()) {
                            a = "EMUI";
                            b = d("ro.build.version.emui");
                        } else {
                            b = d("hw_sc.build.platform.version");
                            a = "HarmonyOS";
                        }
                    }
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
                default:
                    a = TimeCalculator.PLATFORM_ANDROID;
                    b = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(Operators.SPACE_STR, "").toUpperCase();
    }
}
