package com.taobao.weex.common;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface WXJSEngineListener {
    void callback(boolean z, String str, String str2, String str3);

    void createInstanceFailed(String str);

    void createInstanceSuccess(String str);

    void destroyInstanceFailed(String str);

    void destroyInstanceSuccess(String str);

    void fireEvent(boolean z, String str, String str2, String str3);

    void initFramework(boolean z, String str, double d);
}
