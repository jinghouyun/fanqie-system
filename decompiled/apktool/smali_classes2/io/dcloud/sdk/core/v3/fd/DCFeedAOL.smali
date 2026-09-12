.class public Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;
.implements Lio/dcloud/sdk/core/interfaces/AOLLoader$NativeAOLInteractionListener;


# instance fields
.field private a:Lio/dcloud/p/j1;

.field protected b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;


# direct methods
.method public static synthetic $r8$lambda$av4pxi0YTKyHUT0eCAiQR1VYKtQ(Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a()V

    return-void
.end method

.method public constructor <init>(Lio/dcloud/p/j1;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    return-void
.end method

.method private synthetic a()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->p()V

    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/p/j1;->destroy()V

    :cond_0
    return-void
.end method

.method public dislike(Landroid/app/Activity;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0, p1}, Lio/dcloud/p/j1;->dislike(Landroid/app/Activity;)V

    return-void
.end method

.method public getAdLogo()Landroid/graphics/Bitmap;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getAdLogo()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getAppInfo()Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getAppInfo()Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;

    move-result-object v0

    return-object v0
.end method

.method public getButtonText()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getButtonText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getDescription()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFeedAOLView(Landroid/app/Activity;)Landroid/view/View;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Lio/dcloud/p/j1;->a(Landroid/app/Activity;)Landroid/view/View;

    move-result-object p1

    return-object p1

    :cond_0
    const/4 p1, 0x0

    return-object p1
.end method

.method public getIconUrl()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getIconUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getImageList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lio/dcloud/sdk/core/interfaces/AOLLoader$AdImage;",
            ">;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getImageList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getInteractionType()I
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getInteractionType()I

    move-result v0

    return v0
.end method

.method public getMaterialType()I
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getMaterialType()I

    move-result v0

    return v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getSource()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getType()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v0, ""

    return-object v0
.end method

.method public getVideoDuration()D
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->getVideoDuration()D

    move-result-wide v0

    return-wide v0
.end method

.method public getVideoView(Landroid/app/Activity;)Landroid/view/View;
    .locals 2

    .line 1
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 4
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0, p1}, Lio/dcloud/p/j1;->getVideoView(Landroid/app/Activity;)Landroid/view/View;

    move-result-object p1

    return-object p1

    .line 5
    :cond_0
    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "getVideoView must be called on the main thread"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public isExpressAd()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0}, Lio/dcloud/p/j1;->isExpressAd()Z

    move-result v0

    return v0
.end method

.method public isValid()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lio/dcloud/p/j1;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onClicked()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;->onClick()V

    :cond_0
    return-void
.end method

.method public onClosed(Ljava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;->onClosed(Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onPaidGet(JLjava/lang/String;I)V
    .locals 0

    return-void
.end method

.method public onRenderFail()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;->onRenderFail()V

    :cond_0
    return-void
.end method

.method public onRenderSuccess()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;->onRenderSuccess()V

    :cond_0
    return-void
.end method

.method public onShow()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;->onShow()V

    :cond_0
    return-void
.end method

.method public onShowError()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;->onShowError()V

    :cond_0
    return-void
.end method

.method public registerViewForInteraction(Landroid/app/Activity;Landroid/widget/FrameLayout;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Landroid/widget/FrameLayout;",
            "Ljava/util/List<",
            "Landroid/view/View;",
            ">;",
            "Ljava/util/List<",
            "Landroid/view/View;",
            ">;",
            "Ljava/util/List<",
            "Landroid/widget/ImageView;",
            ">;)V"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0, p0}, Lio/dcloud/p/j1;->a(Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;)V

    .line 2
    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-virtual/range {v1 .. v6}, Lio/dcloud/p/j1;->registerViewForInteraction(Landroid/app/Activity;Landroid/widget/FrameLayout;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    return-void
.end method

.method public render()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0, p0}, Lio/dcloud/p/j1;->a(Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;)V

    .line 3
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL$$ExternalSyntheticLambda0;-><init>(Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :cond_0
    return-void
.end method

.method public setAppDownloadListener(Lio/dcloud/sdk/core/interfaces/AOLLoader$AppDownloadListener;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0, p1}, Lio/dcloud/p/j1;->setAppDownloadListener(Lio/dcloud/sdk/core/interfaces/AOLLoader$AppDownloadListener;)V

    return-void
.end method

.method public setFeedAOLListener(Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->b:Lio/dcloud/sdk/core/v3/fd/DCFeedAOLListener;

    return-void
.end method

.method public setVideoAdListener(Lio/dcloud/sdk/core/interfaces/AOLLoader$VideoAdListener;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->a:Lio/dcloud/p/j1;

    invoke-virtual {v0, p1}, Lio/dcloud/p/j1;->setVideoAdListener(Lio/dcloud/sdk/core/interfaces/AOLLoader$VideoAdListener;)V

    return-void
.end method
