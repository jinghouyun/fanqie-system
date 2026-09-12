package io.dcloud.feature.weex.adapter.webview;

import android.view.View;
import com.taobao.weex.ui.view.IWebView;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public interface IDCWebView extends IWebView {
    View getWebView();

    void setUserAgent(String str, boolean z);
}
