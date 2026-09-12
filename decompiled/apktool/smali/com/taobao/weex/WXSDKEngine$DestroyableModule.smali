.class public abstract Lcom/taobao/weex/WXSDKEngine$DestroyableModule;
.super Lcom/taobao/weex/common/WXModule;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"

# interfaces
.implements Lcom/taobao/weex/common/Destroyable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/taobao/weex/WXSDKEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "DestroyableModule"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/taobao/weex/common/WXModule;-><init>()V

    return-void
.end method
