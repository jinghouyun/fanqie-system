package com.taobao.weex.adapter;

import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IWXHttpAdapter {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnHttpListener {
        void onHeadersReceived(int i, Map<String, List<String>> map);

        void onHttpFinish(WXResponse wXResponse);

        void onHttpResponseProgress(int i);

        void onHttpStart();

        void onHttpUploadProgress(int i);
    }

    void sendRequest(WXRequest wXRequest, OnHttpListener onHttpListener);
}
