.class public Lio/dcloud/p/m0;
.super Lio/dcloud/sdk/core/module/DCBaseAOLLoader;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/p/w1;
.implements Lio/dcloud/p/w1$a;


# instance fields
.field private K:Lorg/json/JSONObject;

.field private L:Lio/dcloud/api/custom/UniAdCustomAdapter;

.field private M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;


# direct methods
.method public constructor <init>(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Landroid/app/Activity;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;-><init>(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic a(Lio/dcloud/p/m0;)Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    return-object p0
.end method

.method static synthetic b(Lio/dcloud/p/m0;)Lio/dcloud/api/custom/UniAdCustomAdapter;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/p/m0;->L:Lio/dcloud/api/custom/UniAdCustomAdapter;

    return-object p0
.end method


# virtual methods
.method public a(ILjava/lang/String;)V
    .locals 3

    .line 36
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 37
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "type:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ";code:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ";message:"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const/16 p2, -0x13ec

    invoke-interface {v0, p2, p1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShowError(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public a(Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;)V
    .locals 3

    .line 3
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    const/16 v1, -0xfa1

    if-eqz v0, :cond_2

    .line 4
    iget-object v0, p0, Lio/dcloud/p/m0;->L:Lio/dcloud/api/custom/UniAdCustomAdapter;

    if-eqz v0, :cond_1

    .line 5
    invoke-virtual {v0}, Lio/dcloud/api/custom/UniAdCustomAdapter;->isInitSuccess()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 6
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    invoke-virtual {v0, p1, p2, p0}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a(Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;Lio/dcloud/p/w1;)V

    return-void

    .line 9
    :cond_0
    iget-object v0, p0, Lio/dcloud/p/m0;->L:Lio/dcloud/api/custom/UniAdCustomAdapter;

    new-instance v2, Lio/dcloud/p/m0$a;

    invoke-direct {v2, p0, p1, p2}, Lio/dcloud/p/m0$a;-><init>(Lio/dcloud/p/m0;Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;)V

    invoke-virtual {v0, v2}, Lio/dcloud/api/custom/UniAdCustomAdapter;->addInitListener(Lio/dcloud/api/custom/UniAdCustomAdapter$a;)V

    .line 23
    :try_start_0
    iget-object p1, p0, Lio/dcloud/p/m0;->L:Lio/dcloud/api/custom/UniAdCustomAdapter;

    new-instance p2, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;

    invoke-static {}, Lio/dcloud/sdk/core/util/AdUtil;->getCustomPrivacyConfig()Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    move-result-object v0

    invoke-direct {p2, v0}, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;-><init>(Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;)V

    invoke-virtual {p1, p2}, Lio/dcloud/api/custom/UniAdCustomAdapter;->setPrivacyConfig(Lio/dcloud/api/custom/base/UniAdPrivacyConfig;)V

    .line 24
    iget-object p1, p0, Lio/dcloud/p/m0;->L:Lio/dcloud/api/custom/UniAdCustomAdapter;

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object p2

    iget-object v0, p0, Lio/dcloud/p/m0;->K:Lorg/json/JSONObject;

    invoke-virtual {p1, p2, v0}, Lio/dcloud/api/custom/UniAdCustomAdapter;->init(Landroid/content/Context;Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    .line 26
    :catch_0
    invoke-static {v1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, v1, p1}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void

    .line 30
    :cond_1
    invoke-static {v1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, v1, p1}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void

    .line 33
    :cond_2
    invoke-static {v1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, v1, p1}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void
.end method

.method public a(Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;)V
    .locals 0

    .line 2
    iput-object p1, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    return-void
.end method

.method public a(Lio/dcloud/sdk/core/adapter/IAdAdapter;Lorg/json/JSONObject;)V
    .locals 0

    .line 34
    check-cast p1, Lio/dcloud/api/custom/UniAdCustomAdapter;

    iput-object p1, p0, Lio/dcloud/p/m0;->L:Lio/dcloud/api/custom/UniAdCustomAdapter;

    .line 35
    iput-object p2, p0, Lio/dcloud/p/m0;->K:Lorg/json/JSONObject;

    return-void
.end method

.method public b()V
    .locals 1

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 3
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onSkip()V

    :cond_0
    return-void
.end method

.method public biddingFail(III)V
    .locals 0

    .line 1
    iget-object p2, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    if-eqz p2, :cond_0

    .line 2
    invoke-virtual {p2, p1, p3}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->onBidFail(II)V

    :cond_0
    return-void
.end method

.method public biddingSuccess(II)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0, p1, p2}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->onBidSuccess(II)V

    :cond_0
    return-void
.end method

.method public d()V
    .locals 0

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadSuccess()V

    return-void
.end method

.method public destroy()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->destroy()V

    :cond_0
    return-void
.end method

.method public f()I
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->isSlotSupportBidding()Z

    move-result v0

    return v0
.end method

.method public g()V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    instance-of v0, v0, Lio/dcloud/p/z3;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    check-cast v0, Lio/dcloud/p/z3;

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    invoke-virtual {v0, v1}, Lio/dcloud/p/z3;->onReward(Lorg/json/JSONObject;)V

    :cond_0
    return-void
.end method

.method public getBiddingECPM()I
    .locals 1

    .line 1
    invoke-super {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getBiddingECPM()I

    move-result v0

    return v0
.end method

.method public h()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onVideoPlayEnd()V

    :cond_0
    return-void
.end method

.method protected init(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public isValid()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->isReady()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public j()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onClose()V

    :cond_0
    return-void
.end method

.method public load(Ljava/util/Map;)V
    .locals 1

    .line 1
    new-instance p1, Lio/dcloud/api/custom/base/UniAdSlot;

    invoke-direct {p1}, Lio/dcloud/api/custom/base/UniAdSlot;-><init>()V

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lio/dcloud/api/custom/base/UniAdSlot;->setSlotId(Ljava/lang/String;)V

    .line 3
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getExtra()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lio/dcloud/api/custom/base/UniAdSlot;->setExtra(Ljava/lang/String;)V

    .line 4
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lio/dcloud/api/custom/base/UniAdSlot;->setUserId(Ljava/lang/String;)V

    .line 5
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getWidth()I

    move-result v0

    if-gtz v0, :cond_0

    .line 7
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/sdk/core/util/ScreenUtil;->dw(Landroid/content/Context;)I

    move-result v0

    .line 9
    :cond_0
    invoke-virtual {p1, v0}, Lio/dcloud/api/custom/base/UniAdSlot;->setWidth(I)V

    .line 10
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getHeight()I

    move-result v0

    invoke-virtual {p1, v0}, Lio/dcloud/api/custom/base/UniAdSlot;->setHeight(I)V

    .line 11
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getCount()I

    move-result v0

    invoke-virtual {p1, v0}, Lio/dcloud/api/custom/base/UniAdSlot;->setAdCount(I)V

    .line 12
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/dcloud/p/m0;->a(Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;)V

    return-void
.end method

.method public onAdClicked()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onClick()V

    :cond_0
    return-void
.end method

.method public onAdShow()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShow()V

    :cond_0
    return-void
.end method

.method public onLoadFail(ILjava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void
.end method

.method public onLoadSuccess(Ljava/util/List;)V
    .locals 5

    if-eqz p1, :cond_3

    .line 1
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_1

    .line 4
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 5
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/dcloud/api/custom/type/feed/UniAdCustomNativeAd;

    .line 6
    new-instance v2, Lio/dcloud/p/n0;

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    move-result-object v3

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lio/dcloud/p/n0;-><init>(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Landroid/app/Activity;)V

    .line 7
    invoke-virtual {v2, v1}, Lio/dcloud/p/n0;->a(Lio/dcloud/api/custom/type/feed/UniAdCustomNativeAd;)V

    .line 8
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->isSlotSupportBidding()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 9
    invoke-virtual {v1}, Lio/dcloud/api/custom/type/feed/UniAdCustomNativeAd;->getBidPrice()I

    move-result v1

    invoke-virtual {v2, v1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->setBiddingECPM(I)V

    .line 10
    :cond_1
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 12
    :cond_2
    invoke-virtual {p0, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadSuccess(Ljava/util/List;)V

    return-void

    :cond_3
    :goto_1
    const p1, 0x30d40

    .line 13
    invoke-static {p1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object p1

    const/16 v0, -0x138c

    invoke-virtual {p0, v0, p1}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void
.end method

.method public s()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public show(Landroid/app/Activity;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/p/m0;->isValid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    invoke-virtual {v0, p1}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->show(Ljava/lang/Object;)V

    return-void

    .line 4
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    if-eqz p1, :cond_1

    .line 5
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    const/16 v0, -0x1390

    invoke-static {v0}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShowError(ILjava/lang/String;)V

    :cond_1
    return-void
.end method

.method public showIn(Landroid/view/ViewGroup;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/p/m0;->isValid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    iget-object v0, p0, Lio/dcloud/p/m0;->M:Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;

    invoke-virtual {v0, p1}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->show(Ljava/lang/Object;)V

    return-void

    .line 4
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    if-eqz p1, :cond_1

    .line 5
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    const/16 v0, -0x1390

    invoke-static {v0}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShowError(ILjava/lang/String;)V

    :cond_1
    return-void
.end method
