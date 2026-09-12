package io.dcloud.share;

import android.webkit.WebView;
import io.dcloud.common.DHInterface.IReflectAble;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.ui.AdaFrameItem;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.util.Deprecated_JSUtil;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class ShareAuthorizeView extends AdaFrameItem implements IReflectAble {
    private String a;
    private WebView b;
    private IWebview c;

    public ShareAuthorizeView(IWebview iWebview, String str) {
        super(iWebview.getContext());
        this.c = iWebview;
        this.a = str;
        WebView webView = new WebView(iWebview.getContext());
        this.b = webView;
        a(webView);
        setMainView(this.b);
    }

    private void a(WebView webView) {
    }

    public void load(a aVar, String str) {
        AbsWebviewClient absWebviewClient = (AbsWebviewClient) PlatformUtil.invokeMethod(aVar.a(str), "getWebviewClient", null, new Class[]{ShareAuthorizeView.class}, new Object[]{this});
        this.b.setWebViewClient(absWebviewClient);
        this.b.loadUrl(absWebviewClient.getInitUrl());
    }

    public void onauthenticated(String str) {
        Deprecated_JSUtil.execCallback(this.c, this.a, "{type:'" + str + "'}", 1, true, true);
    }

    public void onerror(String str) {
        Deprecated_JSUtil.execCallback(this.c, this.a, str, 9, false, true);
    }

    public void onloaded() {
        Deprecated_JSUtil.execCallback(this.c, this.a, "{evt:'load'}", 1, true, true);
    }
}
