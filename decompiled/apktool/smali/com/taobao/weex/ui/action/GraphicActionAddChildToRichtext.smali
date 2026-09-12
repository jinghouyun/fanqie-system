.class public Lcom/taobao/weex/ui/action/GraphicActionAddChildToRichtext;
.super Lcom/taobao/weex/ui/action/BasicGraphicAction;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# direct methods
.method public constructor <init>(Lcom/taobao/weex/WXSDKInstance;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/taobao/weex/WXSDKInstance;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 1
    invoke-direct {p0, p1, p5}, Lcom/taobao/weex/ui/action/BasicGraphicAction;-><init>(Lcom/taobao/weex/WXSDKInstance;Ljava/lang/String;)V

    .line 2
    invoke-static {}, Lcom/taobao/weex/WXSDKManager;->getInstance()Lcom/taobao/weex/WXSDKManager;

    move-result-object p1

    if-eqz p1, :cond_0

    invoke-static {}, Lcom/taobao/weex/WXSDKManager;->getInstance()Lcom/taobao/weex/WXSDKManager;

    move-result-object p1

    invoke-virtual {p1}, Lcom/taobao/weex/WXSDKManager;->getWXRenderManager()Lcom/taobao/weex/ui/WXRenderManager;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 3
    invoke-static {}, Lcom/taobao/weex/WXSDKManager;->getInstance()Lcom/taobao/weex/WXSDKManager;

    move-result-object p1

    invoke-virtual {p1}, Lcom/taobao/weex/WXSDKManager;->getWXRenderManager()Lcom/taobao/weex/ui/WXRenderManager;

    move-result-object p1

    .line 4
    invoke-virtual {p0}, Lcom/taobao/weex/ui/action/BasicGraphicAction;->getPageId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0, p5}, Lcom/taobao/weex/ui/WXRenderManager;->getWXComponent(Ljava/lang/String;Ljava/lang/String;)Lcom/taobao/weex/ui/component/WXComponent;

    move-result-object p1

    check-cast p1, Lcom/taobao/weex/ui/component/richtext/WXRichText;

    if-eqz p1, :cond_0

    move-object p5, p4

    move-object p4, p2

    move-object p2, p1

    .line 6
    invoke-virtual/range {p2 .. p7}, Lcom/taobao/weex/ui/component/richtext/WXRichText;->AddChildNode(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public executeAction()V
    .locals 0

    return-void
.end method
