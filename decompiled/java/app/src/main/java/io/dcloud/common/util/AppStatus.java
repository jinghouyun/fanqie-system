package io.dcloud.common.util;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AppStatus {
    public static final int ACTIVE = 1;
    public static final int STOPPED = 0;
    public static final int UN_ACTIVIE = 2;
    private static HashMap<String, Integer> sMaps = new HashMap<>();

    public static int getAppStatus(String str) {
        if (sMaps.containsKey(str)) {
            return sMaps.get(str).intValue();
        }
        return 0;
    }

    public static void setAppStatus(String str, int i) {
        sMaps.put(str, Integer.valueOf(i));
    }
}
