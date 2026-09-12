package com.taobao.weex.bridge;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class EventResult {
    private Object result;
    private boolean success = false;

    public Object getResult() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void onCallback(Object obj) {
        this.success = true;
        this.result = obj;
    }
}
