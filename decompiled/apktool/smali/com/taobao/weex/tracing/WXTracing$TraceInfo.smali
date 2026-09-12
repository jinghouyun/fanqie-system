.class public Lcom/taobao/weex/tracing/WXTracing$TraceInfo;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/taobao/weex/tracing/WXTracing;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TraceInfo"
.end annotation


# instance fields
.field public domQueueTime:J

.field public domThreadNanos:J

.field public domThreadStart:J

.field public rootEventId:I

.field public uiQueueTime:J

.field public uiThreadNanos:J

.field public uiThreadStart:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, -0x1

    .line 5
    iput-wide v0, p0, Lcom/taobao/weex/tracing/WXTracing$TraceInfo;->domThreadStart:J

    .line 7
    iput-wide v0, p0, Lcom/taobao/weex/tracing/WXTracing$TraceInfo;->uiThreadStart:J

    return-void
.end method
