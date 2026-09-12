.class public interface abstract Lio/dcloud/common/DHInterface/IDCloudWebviewClientListener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/IReflectAble;


# virtual methods
.method public abstract doUpdateVisitedHistory(Landroid/webkit/WebView;Ljava/lang/String;Z)V
.end method

.method public abstract onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
.end method

.method public abstract onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
.end method

.method public abstract onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
.end method

.method public abstract shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;
.end method

.method public abstract shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
.end method

.method public abstract shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
.end method
