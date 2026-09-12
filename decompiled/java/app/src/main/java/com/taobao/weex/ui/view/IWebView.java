package com.taobao.weex.ui.view;

import android.content.Intent;
import android.view.View;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IWebView {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnErrorListener {
        void onError(String str, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnMessageListener {
        void onMessage(Map<String, Object> map);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnPageListener {
        void onPageFinish(String str, boolean z, boolean z2);

        void onPageStart(String str);

        void onReceivedTitle(String str);
    }

    void destroy();

    View getView();

    void goBack();

    void goForward();

    void loadDataWithBaseURL(String str);

    void loadUrl(String str);

    void onActivityResult(int i, int i2, Intent intent);

    void postMessage(Object obj);

    void reload();

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnMessageListener(OnMessageListener onMessageListener);

    void setOnPageListener(OnPageListener onPageListener);

    void setShowLoading(boolean z);
}
