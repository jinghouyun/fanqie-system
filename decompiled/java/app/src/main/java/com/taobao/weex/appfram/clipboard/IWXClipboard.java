package com.taobao.weex.appfram.clipboard;

import com.taobao.weex.bridge.JSCallback;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
interface IWXClipboard {
    void getString(JSCallback jSCallback);

    void setString(String str);
}
