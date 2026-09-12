package com.taobao.weex;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXGlobalEventModule extends WXModule {
    @JSMethod
    public void addEventListener(String str, String str2) {
        this.mWXSDKInstance.addEventListener(str, str2);
    }

    public void removeEventListener(String str, String str2) {
        this.mWXSDKInstance.removeEventListener(str, str2);
    }

    @Override // com.taobao.weex.common.WXModule
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        super.addEventListener(str, str2, map);
        addEventListener(str, str2);
    }

    @JSMethod
    public void removeEventListener(String str) {
        this.mWXSDKInstance.removeEventListener(str);
    }
}
