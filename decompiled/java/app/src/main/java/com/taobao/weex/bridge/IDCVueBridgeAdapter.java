package com.taobao.weex.bridge;

import com.taobao.weex.WXSDKInstance;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IDCVueBridgeAdapter {
    void exec(WXSDKInstance wXSDKInstance, String str, String str2);

    String execSync(WXSDKInstance wXSDKInstance, String str, String str2);
}
