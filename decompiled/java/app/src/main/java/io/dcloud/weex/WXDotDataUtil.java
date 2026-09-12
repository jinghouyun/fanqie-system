package io.dcloud.weex;

import com.alibaba.fastjson.JSONObject;
import io.dcloud.common.util.BaseInfo;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class WXDotDataUtil {
    private static JSONObject DEVICEINFO = new JSONObject();

    public static JSONObject getDeviceInfo() {
        return DEVICEINFO;
    }

    public static void setValue(String str, Object obj) {
        if (BaseInfo.SyncDebug) {
            DEVICEINFO.put(str, obj);
        }
    }
}
