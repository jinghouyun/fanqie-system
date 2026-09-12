package com.taobao.weex.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
class WXRenderHandler extends Handler {
    public WXRenderHandler() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
    }

    public final boolean post(String str, Runnable runnable) {
        Message messageObtain = Message.obtain(this, runnable);
        messageObtain.what = str.hashCode();
        return sendMessageDelayed(messageObtain, 0L);
    }
}
