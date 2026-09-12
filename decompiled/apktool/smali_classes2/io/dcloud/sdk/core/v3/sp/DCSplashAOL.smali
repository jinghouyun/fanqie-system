.class public Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;
.super Lio/dcloud/sdk/core/v3/base/DCBaseAOL;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;


# instance fields
.field b:Lio/dcloud/p/k4;

.field private c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;-><init>(Landroid/app/Activity;)V

    .line 2
    new-instance v0, Lio/dcloud/p/k4;

    const/4 v1, 0x1

    invoke-direct {v0, p1, v1}, Lio/dcloud/p/k4;-><init>(Landroid/app/Activity;I)V

    iput-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->b:Lio/dcloud/p/k4;

    return-void
.end method


# virtual methods
.method public isSplashOpen()Z
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;->getContext()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/p/m;->d(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public isValid()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->b:Lio/dcloud/p/k4;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lio/dcloud/p/b5;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public load(Lio/dcloud/sdk/core/entry/SplashAOLConfig;Lio/dcloud/sdk/core/v3/sp/DCSplashAOLLoadListener;)V
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
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->b:Lio/dcloud/p/k4;

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
    new-instance v1, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL$1;

    invoke-direct {v1, p0, p2}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL$1;-><init>(Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;Lio/dcloud/sdk/core/v3/sp/DCSplashAOLLoadListener;)V

    invoke-virtual {v0, p1, v1}, Lio/dcloud/p/k4;->a(Lio/dcloud/sdk/core/entry/SplashAOLConfig;Lio/dcloud/p/w2;)V

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
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;->onClick()V

    :cond_0
    return-void
.end method

.method public onClose()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;->onClose()V

    :cond_0
    return-void
.end method

.method public onPaidGet(JLjava/lang/String;I)V
    .locals 0

    return-void
.end method

.method public onShow()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;->onShow()V

    :cond_0
    return-void
.end method

.method public onShowError(ILjava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0, p1, p2}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;->onShowError(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onSkip()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;->onSkip()V

    :cond_0
    return-void
.end method

.method public onVideoPlayEnd()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    if-eqz v0, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;->onVideoPlayEnd()V

    :cond_0
    return-void
.end method

.method public setSplashAOLListener(Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->c:Lio/dcloud/sdk/core/v3/sp/DCSplashAOLListener;

    .line 2
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->b:Lio/dcloud/p/k4;

    if-eqz p1, :cond_0

    .line 3
    invoke-virtual {p1, p0}, Lio/dcloud/p/b5;->a(Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;)V

    :cond_0
    return-void
.end method

.method public show(Landroid/app/Activity;)V
    .locals 0

    return-void
.end method

.method public show(Landroid/view/ViewGroup;)V
    .locals 0

    .line 2
    invoke-virtual {p0, p1}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->showIn(Landroid/view/ViewGroup;)V

    return-void
.end method

.method public showIn(Landroid/view/ViewGroup;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->b:Lio/dcloud/p/k4;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0, p1}, Lio/dcloud/p/k4;->a(Landroid/view/ViewGroup;)V

    :cond_0
    return-void
.end method
