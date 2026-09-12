package com.taobao.weex.http;

import android.content.Context;
import android.text.TextUtils;
import dc.squareup.HttpConstants;
import io.dcloud.common.util.BaseInfo;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXHttpUtil {
    public static final String KEY_USER_AGENT = "user-agent";

    public static String assembleUserAgent() {
        String defaultUA = HttpConstants.getDefaultUA();
        if (!TextUtils.isEmpty(defaultUA)) {
            return defaultUA;
        }
        HttpConstants.setUA(BaseInfo.sDefWebViewUserAgent);
        return HttpConstants.getDefaultUA();
    }

    public static String assembleUserAgent(Context context, Map<String, String> map) {
        return assembleUserAgent();
    }
}
