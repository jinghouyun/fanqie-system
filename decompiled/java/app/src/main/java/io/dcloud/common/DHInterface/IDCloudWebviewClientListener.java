package io.dcloud.common.DHInterface;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IDCloudWebviewClientListener extends IReflectAble {
    void doUpdateVisitedHistory(WebView webView, String str, boolean z);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedError(WebView webView, int i, String str, String str2);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest);

    WebResourceResponse shouldInterceptRequest(WebView webView, String str);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
