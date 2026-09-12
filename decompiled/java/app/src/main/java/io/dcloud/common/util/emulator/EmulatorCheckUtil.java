package io.dcloud.common.util.emulator;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class EmulatorCheckUtil {
    public static final int RESULT_EMULATOR = 1;
    public static final int RESULT_MAYBE_EMULATOR = 0;
    public static final int RESULT_UNKNOWN = 2;
    private static String[] known_pkgNames = {"sdcard/Android/data/com.bluestacks.home", "sdcard/Android/data/com.bluestacks.settings", "sdcard/Android/data/com.microvirt.guide", "sdcard/Android/data/com.microvirt.launcher2"};

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private static class SingletonHolder {
        private static final EmulatorCheckUtil INSTANCE = new EmulatorCheckUtil();

        private SingletonHolder() {
        }
    }

    private CheckResult checkFeaturesByBaseBand() {
        String property = getProperty("gsm.version.baseband");
        if (property == null) {
            return new CheckResult(0, null);
        }
        return new CheckResult(property.contains("1.0.0.0") ? 1 : 2, property);
    }

    private CheckResult checkFeaturesByBoard() {
        String property = getProperty("ro.product.board");
        if (property == null) {
            return new CheckResult(0, null);
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
        return new CheckResult((lowerCase.contains(WXEnvironment.OS) || lowerCase.contains("goldfish")) ? 1 : 2, property);
    }

    private CheckResult checkFeaturesByFlavor() {
        String property = getProperty("ro.build.flavor");
        if (property == null) {
            return new CheckResult(0, null);
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
        return new CheckResult((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, property);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x0026  */
    private CheckResult checkFeaturesByHardware() {
        String property = getProperty("ro.hardware");
        if (property == null) {
            return new CheckResult(0, null);
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
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
        return new CheckResult(i, property);
    }

    private CheckResult checkFeaturesByManufacturer() {
        String property = getProperty("ro.product.manufacturer");
        if (property == null) {
            return new CheckResult(0, null);
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
        return new CheckResult((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, property);
    }

    private CheckResult checkFeaturesByModel() {
        String property = getProperty("ro.product.model");
        if (property == null) {
            return new CheckResult(0, null);
        }
        String lowerCase = property.toLowerCase(Locale.ENGLISH);
        return new CheckResult((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2, property);
    }

    private CheckResult checkFeaturesByPlatform() {
        String property = getProperty("ro.board.platform");
        if (property == null) {
            return new CheckResult(0, null);
        }
        return new CheckResult(property.toLowerCase(Locale.ENGLISH).contains(WXEnvironment.OS) ? 1 : 2, property);
    }

    public static CheckResult checkPkgNameForEmulator() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 2;
        while (true) {
            String[] strArr = known_pkgNames;
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
        return new CheckResult(i, "PkgName");
    }

    private String getProperty(String str) {
        String property = CommandUtil.getSingleInstance().getProperty(str);
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return property;
    }

    private int getSensorNumber(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).size();
    }

    public static final EmulatorCheckUtil getSingleInstance() {
        return SingletonHolder.INSTANCE;
    }

    private int getUserAppNum(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.split("package:").length;
    }

    private boolean hasLightSensor(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) != null;
    }

    private boolean supportBluetooth(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private boolean supportCameraFlash(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public boolean emulatorCheck(Context context) {
        int i;
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        int i2 = checkFeaturesByHardware().result;
        if (i2 == 0) {
            i = 1;
        } else {
            if (i2 == 1) {
                return true;
            }
            i = 0;
        }
        int i3 = checkPkgNameForEmulator().result;
        if (i3 == 0) {
            i++;
        } else if (i3 == 1) {
            return true;
        }
        int i4 = checkFeaturesByFlavor().result;
        if (i4 == 0) {
            i++;
        } else if (i4 == 1) {
            return true;
        }
        int i5 = checkFeaturesByModel().result;
        if (i5 == 0) {
            i++;
        } else if (i5 == 1) {
            return true;
        }
        int i6 = checkFeaturesByManufacturer().result;
        if (i6 == 0) {
            i++;
        } else if (i6 == 1) {
            return true;
        }
        int i7 = checkFeaturesByBoard().result;
        if (i7 == 0) {
            i++;
        } else if (i7 == 1) {
            return true;
        }
        int i8 = checkFeaturesByPlatform().result;
        if (i8 == 0) {
            i++;
        } else if (i8 == 1) {
            return true;
        }
        int i9 = checkFeaturesByBaseBand().result;
        if (i9 == 0) {
            i += 2;
        } else if (i9 == 1) {
            return true;
        }
        if (getSensorNumber(context) <= 7) {
            i++;
        }
        if (!supportCameraFlash(context)) {
            i++;
        }
        if (!supportBluetooth(context)) {
            i++;
        }
        if (!hasLightSensor(context)) {
            i++;
        }
        return i > 3;
    }

    private EmulatorCheckUtil() {
    }
}
