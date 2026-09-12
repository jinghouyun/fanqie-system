.class public interface abstract Lcom/taobao/weex/bridge/ModuleFactory;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"

# interfaces
.implements Lcom/taobao/weex/bridge/JavascriptInvokable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/taobao/weex/common/WXModule;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/taobao/weex/bridge/JavascriptInvokable;"
    }
.end annotation


# virtual methods
.method public abstract buildInstance()Lcom/taobao/weex/common/WXModule;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method
