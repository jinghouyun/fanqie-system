package com.taobao.weex.ui.module;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXViewUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXDeviceInfoModule extends WXModule {
    @JSMethod(uiThread = false)
    public void enableFullScreenHeight(JSCallback jSCallback, JSONObject jSONObject) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.setEnableFullScreenHeight(true);
            if (jSCallback != null) {
                long screenHeight = WXViewUtils.getScreenHeight(this.mWXSDKInstance.getInstanceId());
                HashMap map = new HashMap();
                map.put("fullScreenHeight", String.valueOf(screenHeight));
                jSCallback.invoke(map);
            }
        }
    }
}
