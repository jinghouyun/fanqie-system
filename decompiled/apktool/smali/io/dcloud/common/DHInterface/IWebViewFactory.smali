.class public interface abstract Lio/dcloud/common/DHInterface/IWebViewFactory;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# virtual methods
.method public abstract getDefWebViewUA(Landroid/content/Context;)Ljava/lang/String;
.end method

.method public abstract getWebView(Landroid/app/Activity;Lio/dcloud/common/adapter/ui/AdaWebview;)Lio/dcloud/common/adapter/ui/webview/DCWebView;
.end method

.method public abstract getWebView(Landroid/app/Activity;Lio/dcloud/common/adapter/ui/AdaWebview;Lio/dcloud/common/DHInterface/IDCloudWebviewClientListener;)Lio/dcloud/common/adapter/ui/webview/DCWebView;
.end method

.method public abstract getWebView(Landroid/app/Activity;Lio/dcloud/common/adapter/ui/AdaWebview;Lio/dcloud/common/adapter/ui/webview/OnPageFinishedCallack;)Lio/dcloud/common/adapter/ui/webview/DCWebView;
.end method
