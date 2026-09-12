.class public interface abstract Lcom/taobao/weex/ui/view/IWebView;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/taobao/weex/ui/view/IWebView$OnMessageListener;,
        Lcom/taobao/weex/ui/view/IWebView$OnPageListener;,
        Lcom/taobao/weex/ui/view/IWebView$OnErrorListener;
    }
.end annotation


# virtual methods
.method public abstract destroy()V
.end method

.method public abstract getView()Landroid/view/View;
.end method

.method public abstract goBack()V
.end method

.method public abstract goForward()V
.end method

.method public abstract loadDataWithBaseURL(Ljava/lang/String;)V
.end method

.method public abstract loadUrl(Ljava/lang/String;)V
.end method

.method public abstract onActivityResult(IILandroid/content/Intent;)V
.end method

.method public abstract postMessage(Ljava/lang/Object;)V
.end method

.method public abstract reload()V
.end method

.method public abstract setOnErrorListener(Lcom/taobao/weex/ui/view/IWebView$OnErrorListener;)V
.end method

.method public abstract setOnMessageListener(Lcom/taobao/weex/ui/view/IWebView$OnMessageListener;)V
.end method

.method public abstract setOnPageListener(Lcom/taobao/weex/ui/view/IWebView$OnPageListener;)V
.end method

.method public abstract setShowLoading(Z)V
.end method
