.class public Lio/dcloud/sdk/core/v3/drama/DCDramaPage;
.super Lio/dcloud/sdk/core/v3/base/DCBaseAOL;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/sdk/core/interfaces/AOLLoader$RewVAOLInteractionListener;


# instance fields
.field private final b:Lio/dcloud/p/a1;

.field private c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

.field private d:Lio/dcloud/sdk/core/v3/drama/DCDramaPageListener;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;-><init>(Landroid/app/Activity;)V

    .line 2
    new-instance v0, Lio/dcloud/p/a1;

    const/16 v1, 0xb

    invoke-direct {v0, p1, v1}, Lio/dcloud/p/a1;-><init>(Landroid/app/Activity;I)V

    iput-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/p/b5;->destroy()V

    :cond_0
    return-void
.end method

.method public getDramaPage()Landroidx/fragment/app/Fragment;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return-object v0

    :cond_0
    invoke-virtual {v0}, Lio/dcloud/p/a1;->s()Landroidx/fragment/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-nez v0, :cond_0

    const-string v0, ""

    return-object v0

    :cond_0
    invoke-virtual {v0}, Lio/dcloud/p/b5;->getType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isValid()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/p/b5;->l()Z

    move-result v0

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public load(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Lio/dcloud/sdk/core/v3/drama/DCDramaPageLoadListener;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;->getContext()Landroid/app/Activity;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_2

    if-nez p1, :cond_0

    goto :goto_0

    .line 7
    :cond_0
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-nez v0, :cond_1

    if-eqz p2, :cond_3

    const/16 p1, -0x1397

    .line 9
    invoke-static {p1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, p1, v0, v1}, Lio/dcloud/sdk/core/v3/base/DCBaseAOLLoadListener;->onError(ILjava/lang/String;Lorg/json/JSONArray;)V

    return-void

    .line 12
    :cond_1
    new-instance v1, Lio/dcloud/sdk/core/v3/drama/DCDramaPage$1;

    invoke-direct {v1, p0, p2}, Lio/dcloud/sdk/core/v3/drama/DCDramaPage$1;-><init>(Lio/dcloud/sdk/core/v3/drama/DCDramaPage;Lio/dcloud/sdk/core/v3/drama/DCDramaPageLoadListener;)V

    invoke-virtual {v0, p1, v1}, Lio/dcloud/p/a1;->a(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Lio/dcloud/p/w2;)V

    return-void

    :cond_2
    :goto_0
    if-eqz p2, :cond_3

    const/16 p1, -0x1396

    .line 13
    invoke-static {p1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, p1, v0, v1}, Lio/dcloud/sdk/core/v3/base/DCBaseAOLLoadListener;->onError(ILjava/lang/String;Lorg/json/JSONArray;)V

    :cond_3
    return-void
.end method

.method public onClick()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onClick()V

    .line 4
    :cond_0
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->d:Lio/dcloud/sdk/core/v3/drama/DCDramaPageListener;

    if-eqz v0, :cond_1

    .line 5
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/drama/DCDramaPageListener;->onDramaClicked()V

    :cond_1
    return-void
.end method

.method public onClose()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onClose()V

    :cond_0
    return-void
.end method

.method public onPaidGet(JLjava/lang/String;I)V
    .locals 0

    return-void
.end method

.method public onReward(Lorg/json/JSONObject;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onReward(Lorg/json/JSONObject;)V

    :cond_0
    return-void
.end method

.method public onShow()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onShow()V

    :cond_0
    return-void
.end method

.method public onShowError(ILjava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1, p2}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onShowError(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onSkip()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onSkip()V

    :cond_0
    return-void
.end method

.method public onVideoPlayEnd()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/rew/DCRewAOLListener;->onVideoPlayEnd()V

    :cond_0
    return-void
.end method

.method public setDramaPageAdListener(Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->c:Lio/dcloud/sdk/core/v3/drama/DCDramaPageAdListener;

    .line 2
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-eqz p1, :cond_0

    .line 3
    invoke-virtual {p1, p0}, Lio/dcloud/p/b5;->a(Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;)V

    :cond_0
    return-void
.end method

.method public setDramaPageListener(Lio/dcloud/sdk/core/v3/drama/DCDramaPageListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->d:Lio/dcloud/sdk/core/v3/drama/DCDramaPageListener;

    return-void
.end method

.method public setLockCount(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/drama/DCDramaPage;->b:Lio/dcloud/p/a1;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0, p1}, Lio/dcloud/p/a1;->a(I)V

    :cond_0
    return-void
.end method
