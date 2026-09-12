package io.dcloud.p;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class d1 {
    private static String[] a = {"sdcard/Android/data/com.bluestacks.home", "sdcard/Android/data/com.bluestacks.settings", "sdcard/Android/data/com.microvirt.guide", "sdcard/Android/data/com.microvirt.launcher2"};

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class b {
        public int a;
        public String b;

        public b(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private static class c {
        private static final d1 a = new d1();
    }

    private String b(String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA;
    }

    private b c() {
        String strB = b("ro.build.flavor");
        if (strB == null) {
            return new b(0, null);
        }
        String lowerCase = strB.toLowerCase(Locale.ENGLISH);
        return new b((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, strB);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x0026  */
    private b d() {
        String strB = b("ro.hardware");
        if (strB == null) {
            return new b(0, null);
        }
        String lowerCase = strB.toLowerCase(Locale.ENGLISH);
        lowerCase.getClass();
        lowerCase.hashCode();
        int i = 2;
        switch (lowerCase) {
            case "cancro":
            case "vbox86":
            case "nox":
            case "ttvm":
            case "vbox":
            case "intel":
            case "android_x86":
                i = 1;
                break;
        }
        return new b(i, strB);
    }

    private b e() {
        String strB = b("ro.product.manufacturer");
        if (strB == null) {
            return new b(0, null);
        }
        String lowerCase = strB.toLowerCase(Locale.ENGLISH);
        return new b((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, strB);
    }

    private b f() {
        String strB = b("ro.product.model");
        if (strB == null) {
            return new b(0, null);
        }
        String lowerCase = strB.toLowerCase(Locale.ENGLISH);
        return new b((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2, strB);
    }

    private b g() {
        String strB = b("ro.board.platform");
        if (strB == null) {
            return new b(0, null);
        }
        return new b(strB.toLowerCase(Locale.ENGLISH).contains(WXEnvironment.OS) ? 1 : 2, strB);
    }

    public static b h() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 2;
        while (true) {
            String[] strArr = a;
            if (i2 >= strArr.length) {
                break;
            }
            if (new File(strArr[i2]).exists()) {
                i3++;
            } else {
                i4 = 0;
            }
            if (i3 > 2) {
                break;
            }
            i2++;
        }
        if (i3 != 1) {
            i = i3 != 2 ? i4 : 1;
        }
        return new b(i, "PkgName");
    }

    public static final d1 i() {
        return c.a;
    }

    public boolean a(Context context) {
        int i;
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        int i2 = d().a;
        if (i2 == 0) {
            i = 1;
        } else {
            if (i2 == 1) {
                return true;
            }
            i = 0;
        }
        int i3 = h().a;
        if (i3 == 0) {
            i++;
        } else if (i3 == 1) {
            return true;
        }
        int i4 = c().a;
        if (i4 == 0) {
            i++;
        } else if (i4 == 1) {
            return true;
        }
        int i5 = f().a;
        if (i5 == 0) {
            i++;
        } else if (i5 == 1) {
            return true;
        }
        int i6 = e().a;
        if (i6 == 0) {
            i++;
        } else if (i6 == 1) {
            return true;
        }
        int i7 = b().a;
        if (i7 == 0) {
            i++;
        } else if (i7 == 1) {
            return true;
        }
        int i8 = g().a;
        if (i8 == 0) {
            i++;
        } else if (i8 == 1) {
            return true;
        }
        int i9 = a().a;
        if (i9 == 0) {
            i += 2;
        } else if (i9 == 1) {
            return true;
        }
        if (!c(context)) {
            i++;
        }
        if (!b(context)) {
            i++;
        }
        return i > 3;
    }

    private d1() {
    }

    private b b() {
        String strB = b("ro.product.board");
        if (strB == null) {
            return new b(0, null);
        }
        String lowerCase = strB.toLowerCase(Locale.ENGLISH);
        return new b((lowerCase.contains(WXEnvironment.OS) || lowerCase.contains("goldfish")) ? 1 : 2, strB);
    }

    private boolean c(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private String a(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private b a() {
        String strB = b("gsm.version.baseband");
        if (strB == null) {
            return new b(0, null);
        }
        return new b(strB.contains("1.0.0.0") ? 1 : 2, strB);
    }
}
