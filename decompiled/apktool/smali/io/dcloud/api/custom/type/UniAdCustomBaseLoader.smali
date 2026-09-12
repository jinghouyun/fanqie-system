.class public abstract Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field protected a:Lio/dcloud/p/w1;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;Lio/dcloud/p/w1;)V
    .locals 0

    .line 1
    iput-object p3, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    .line 3
    :try_start_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->load(Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    const/16 p1, -0xfa2

    .line 5
    invoke-static {p1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p0, p1, p2}, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->onLoadFail(ILjava/lang/String;)V

    return-void
.end method

.method public abstract destroy()V
.end method

.method public getBidType()I
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Lio/dcloud/p/w1;->f()I

    move-result v0

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public abstract isReady()Z
.end method

.method public abstract load(Landroid/app/Activity;Lio/dcloud/api/custom/base/UniAdSlot;)V
.end method

.method public onAdClicked()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/p/w1;->onAdClicked()V

    :cond_0
    return-void
.end method

.method public onAdClosed()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/p/w1;->j()V

    :cond_0
    return-void
.end method

.method public onAdPlayEnd()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/p/w1;->h()V

    :cond_0
    return-void
.end method

.method public onAdPlayError(ILjava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1, p2}, Lio/dcloud/p/w1;->a(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onAdShow()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/p/w1;->onAdShow()V

    :cond_0
    return-void
.end method

.method public onAdSkip()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/p/w1;->b()V

    :cond_0
    return-void
.end method

.method public onBidFail(II)V
    .locals 0

    return-void
.end method

.method public onBidSuccess(II)V
    .locals 0

    return-void
.end method

.method public onLoadFail(ILjava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1, p2}, Lio/dcloud/p/w1;->onLoadFail(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onLoadSuccess()V
    .locals 1

    .line 3
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 4
    invoke-interface {v0}, Lio/dcloud/p/w1;->d()V

    :cond_0
    return-void
.end method

.method public onLoadSuccess(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "+",
            "Lio/dcloud/api/custom/type/feed/UniAdCustomNativeAd;",
            ">;)V"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1}, Lio/dcloud/p/w1;->onLoadSuccess(Ljava/util/List;)V

    :cond_0
    return-void
.end method

.method public setBidPrice(I)V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    instance-of v1, v0, Lio/dcloud/sdk/core/module/DCBaseAOL;

    if-eqz v1, :cond_1

    .line 2
    check-cast v0, Lio/dcloud/sdk/core/module/DCBaseAOL;

    invoke-virtual {v0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->isSlotSupportBidding()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 4
    :cond_0
    iget-object v0, p0, Lio/dcloud/api/custom/type/UniAdCustomBaseLoader;->a:Lio/dcloud/p/w1;

    check-cast v0, Lio/dcloud/sdk/core/module/DCBaseAOL;

    invoke-virtual {v0, p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->setBiddingECPM(I)V

    :cond_1
    :goto_0
    return-void
.end method

.method public abstract show(Ljava/lang/Object;)V
.end method
