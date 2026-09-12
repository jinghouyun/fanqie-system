.class Lcom/taobao/weex/dom/transition/WXTransition$2;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/taobao/weex/dom/transition/WXTransition;->doTransitionAnimation(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/taobao/weex/dom/transition/WXTransition;


# direct methods
.method constructor <init>(Lcom/taobao/weex/dom/transition/WXTransition;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/dom/transition/WXTransition$2;->this$0:Lcom/taobao/weex/dom/transition/WXTransition;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/dom/transition/WXTransition$2;->this$0:Lcom/taobao/weex/dom/transition/WXTransition;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/taobao/weex/dom/transition/WXTransition;->access$302(Lcom/taobao/weex/dom/transition/WXTransition;Ljava/lang/Runnable;)Ljava/lang/Runnable;

    .line 2
    iget-object v0, p0, Lcom/taobao/weex/dom/transition/WXTransition$2;->this$0:Lcom/taobao/weex/dom/transition/WXTransition;

    invoke-static {v0}, Lcom/taobao/weex/dom/transition/WXTransition;->access$400(Lcom/taobao/weex/dom/transition/WXTransition;)J

    move-result-wide v0

    long-to-float v0, v0

    const/high16 v1, 0x800000

    cmpg-float v0, v0, v1

    if-gez v0, :cond_0

    goto :goto_0

    .line 5
    :cond_0
    iget-object v0, p0, Lcom/taobao/weex/dom/transition/WXTransition$2;->this$0:Lcom/taobao/weex/dom/transition/WXTransition;

    invoke-static {v0}, Lcom/taobao/weex/dom/transition/WXTransition;->access$500(Lcom/taobao/weex/dom/transition/WXTransition;)Lcom/taobao/weex/ui/component/WXComponent;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/taobao/weex/dom/transition/WXTransition$2;->this$0:Lcom/taobao/weex/dom/transition/WXTransition;

    invoke-static {v0}, Lcom/taobao/weex/dom/transition/WXTransition;->access$500(Lcom/taobao/weex/dom/transition/WXTransition;)Lcom/taobao/weex/ui/component/WXComponent;

    move-result-object v0

    invoke-virtual {v0}, Lcom/taobao/weex/ui/component/basic/WXBasicComponent;->getEvents()Lcom/taobao/weex/dom/WXEvent;

    move-result-object v0

    const-string/jumbo v1, "transitionEnd"

    invoke-virtual {v0, v1}, Ljava/util/AbstractCollection;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 6
    iget-object v0, p0, Lcom/taobao/weex/dom/transition/WXTransition$2;->this$0:Lcom/taobao/weex/dom/transition/WXTransition;

    invoke-static {v0}, Lcom/taobao/weex/dom/transition/WXTransition;->access$500(Lcom/taobao/weex/dom/transition/WXTransition;)Lcom/taobao/weex/ui/component/WXComponent;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/taobao/weex/ui/component/WXComponent;->fireEvent(Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void
.end method
