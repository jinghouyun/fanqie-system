package com.taobao.weex.bridge;

import io.dcloud.feature.uniapp.bridge.UniJSCallback;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleJSCallback implements UniJSCallback {
    String mCallbackId;
    String mInstanceId;
    private InvokerCallback mInvokerCallback;

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    interface InvokerCallback {
        void onInvokeSuccess();
    }

    public SimpleJSCallback(String str, String str2) {
        this.mCallbackId = str2;
        this.mInstanceId = str;
    }

    public String getCallbackId() {
        return this.mCallbackId;
    }

    @Override // com.taobao.weex.bridge.JSCallback
    public void invoke(Object obj) {
        WXBridgeManager.getInstance().callbackJavascript(this.mInstanceId, this.mCallbackId, obj, false);
        InvokerCallback invokerCallback = this.mInvokerCallback;
        if (invokerCallback != null) {
            invokerCallback.onInvokeSuccess();
        }
    }

    @Override // com.taobao.weex.bridge.JSCallback
    public void invokeAndKeepAlive(Object obj) {
        WXBridgeManager.getInstance().callbackJavascript(this.mInstanceId, this.mCallbackId, obj, true);
    }

    public void setInvokerCallback(InvokerCallback invokerCallback) {
        this.mInvokerCallback = invokerCallback;
    }
}
