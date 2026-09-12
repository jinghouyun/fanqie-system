package io.dcloud.common.adapter.util;

import android.content.Context;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.emulator.EmulatorCheckUtil;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class SecuritySupport {
    public static String getAppId() {
        return BaseInfo.sDefaultBootApp;
    }

    public static String getDeviceId(Context context) {
        return AppRuntime.getDCloudDeviceID(context);
    }

    public static boolean isRoot() {
        return DeviceInfo.hasRootPrivilege();
    }

    public static boolean isSimulator(Context context) {
        return EmulatorCheckUtil.getSingleInstance().emulatorCheck(context);
    }
}
