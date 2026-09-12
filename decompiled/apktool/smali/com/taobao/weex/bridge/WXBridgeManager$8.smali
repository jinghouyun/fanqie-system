.class Lcom/taobao/weex/bridge/WXBridgeManager$8;
.super Lcom/taobao/weex/bridge/EventResult;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/taobao/weex/bridge/WXBridgeManager;->syncExecJsOnInstanceWithResult(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/taobao/weex/bridge/WXBridgeManager;

.field final synthetic val$waitLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method constructor <init>(Lcom/taobao/weex/bridge/WXBridgeManager;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/bridge/WXBridgeManager$8;->this$0:Lcom/taobao/weex/bridge/WXBridgeManager;

    iput-object p2, p0, Lcom/taobao/weex/bridge/WXBridgeManager$8;->val$waitLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-direct {p0}, Lcom/taobao/weex/bridge/EventResult;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallback(Ljava/lang/Object;)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Lcom/taobao/weex/bridge/EventResult;->onCallback(Ljava/lang/Object;)V

    .line 2
    iget-object p1, p0, Lcom/taobao/weex/bridge/WXBridgeManager$8;->val$waitLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {p1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    return-void
.end method
