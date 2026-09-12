.class Lcom/taobao/weex/performance/WXInstanceApm$1;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/taobao/weex/performance/WXInstanceApm;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/taobao/weex/performance/WXInstanceApm;


# direct methods
.method constructor <init>(Lcom/taobao/weex/performance/WXInstanceApm;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/performance/WXInstanceApm$1;->this$0:Lcom/taobao/weex/performance/WXInstanceApm;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/performance/WXInstanceApm$1;->this$0:Lcom/taobao/weex/performance/WXInstanceApm;

    invoke-virtual {v0}, Lcom/taobao/weex/performance/WXInstanceApm;->sendPerformanceToJS()V

    return-void
.end method
