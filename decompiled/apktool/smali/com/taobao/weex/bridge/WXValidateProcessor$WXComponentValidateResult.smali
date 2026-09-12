.class public Lcom/taobao/weex/bridge/WXValidateProcessor$WXComponentValidateResult;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/taobao/weex/bridge/WXValidateProcessor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WXComponentValidateResult"
.end annotation


# instance fields
.field public isSuccess:Z

.field public replacedComponent:Ljava/lang/String;

.field public validateInfo:Lcom/alibaba/fastjson/JSONObject;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
