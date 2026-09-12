package com.taobao.weex.appfram.storage;

import com.taobao.weex.bridge.JSCallback;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
interface IWXStorage {
    void getAllKeys(JSCallback jSCallback);

    void getItem(String str, JSCallback jSCallback);

    void length(JSCallback jSCallback);

    void removeItem(String str, JSCallback jSCallback);

    void setItem(String str, String str2, JSCallback jSCallback);

    void setItemPersistent(String str, String str2, JSCallback jSCallback);
}
