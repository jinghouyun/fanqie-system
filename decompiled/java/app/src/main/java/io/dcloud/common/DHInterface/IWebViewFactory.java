package io.dcloud.common.DHInterface;

import android.app.Activity;
import android.content.Context;
import io.dcloud.common.adapter.ui.AdaWebview;
import io.dcloud.common.adapter.ui.webview.DCWebView;
import io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IWebViewFactory {
    String getDefWebViewUA(Context context);

    DCWebView getWebView(Activity activity, AdaWebview adaWebview);

    DCWebView getWebView(Activity activity, AdaWebview adaWebview, IDCloudWebviewClientListener iDCloudWebviewClientListener);

    DCWebView getWebView(Activity activity, AdaWebview adaWebview, OnPageFinishedCallack onPageFinishedCallack);
}
