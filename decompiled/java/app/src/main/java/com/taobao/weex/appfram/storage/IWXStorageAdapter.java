package com.taobao.weex.appfram.storage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IWXStorageAdapter {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnResultReceivedListener {
        void onReceived(Map<String, Object> map);
    }

    void close();

    void getAllKeys(OnResultReceivedListener onResultReceivedListener);

    void getItem(String str, OnResultReceivedListener onResultReceivedListener);

    void length(OnResultReceivedListener onResultReceivedListener);

    void removeItem(String str, OnResultReceivedListener onResultReceivedListener);

    void setItem(String str, String str2, OnResultReceivedListener onResultReceivedListener);

    void setItemPersistent(String str, String str2, OnResultReceivedListener onResultReceivedListener);
}
