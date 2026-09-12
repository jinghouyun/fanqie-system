.class Lcom/taobao/weex/ui/component/WXComponent$2;
.super Lcom/taobao/weex/bridge/EventResult;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/taobao/weex/ui/component/WXComponent;->fireEventWait(Ljava/lang/String;Ljava/util/Map;)Lcom/taobao/weex/bridge/EventResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/taobao/weex/ui/component/WXComponent;

.field final synthetic val$waitLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method constructor <init>(Lcom/taobao/weex/ui/component/WXComponent;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/ui/component/WXComponent$2;->this$0:Lcom/taobao/weex/ui/component/WXComponent;

    iput-object p2, p0, Lcom/taobao/weex/ui/component/WXComponent$2;->val$waitLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-direct {p0}, Lcom/taobao/weex/bridge/EventResult;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallback(Ljava/lang/Object;)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Lcom/taobao/weex/bridge/EventResult;->onCallback(Ljava/lang/Object;)V

    .line 2
    iget-object p1, p0, Lcom/taobao/weex/ui/component/WXComponent$2;->val$waitLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {p1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    return-void
.end method
