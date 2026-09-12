.class public Lio/dcloud/p/b1;
.super Lio/dcloud/p/j1;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;


# direct methods
.method public static synthetic $r8$lambda$0fdhskJ9ZXEabI6tIjDjJfPQePw(Lio/dcloud/p/b1;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/p/b1;->u()V

    return-void
.end method

.method public static synthetic $r8$lambda$60STgtwr3lpwYhG6OGRYLeKzbec(Lio/dcloud/p/b1;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/p/b1;->t()V

    return-void
.end method

.method public static synthetic $r8$lambda$9OjAt7-uT0YfiOtFxzUXpzcwr3I(Lio/dcloud/p/b1;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/p/b1;->q()V

    return-void
.end method

.method public static synthetic $r8$lambda$DPijG-nOLPtYu4ByqmScMRi-WzA(Lio/dcloud/p/b1;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/p/b1;->s()V

    return-void
.end method

.method public static synthetic $r8$lambda$m-0q4Bl7Vl_Gi8na8c0xJK_GrVs(Lio/dcloud/p/b1;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/p/b1;->r()V

    return-void
.end method

.method public constructor <init>(Lio/dcloud/sdk/core/module/DCBaseAOL;Landroid/app/Activity;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lio/dcloud/p/j1;-><init>(Lio/dcloud/sdk/core/module/DCBaseAOL;Landroid/app/Activity;)V

    return-void
.end method

.method private synthetic q()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/j1;->e:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    instance-of v1, v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    if-eqz v1, :cond_0

    .line 2
    check-cast v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;->onEnd()V

    :cond_0
    return-void
.end method

.method private synthetic r()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/j1;->e:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    instance-of v1, v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    if-eqz v1, :cond_0

    .line 2
    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;->onShowError()V

    :cond_0
    return-void
.end method

.method private synthetic s()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/j1;->e:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    instance-of v1, v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    if-eqz v1, :cond_0

    .line 2
    check-cast v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;->onPause()V

    :cond_0
    return-void
.end method

.method private synthetic t()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/j1;->e:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    instance-of v1, v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    if-eqz v1, :cond_0

    .line 2
    check-cast v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;->onResume()V

    :cond_0
    return-void
.end method

.method private synthetic u()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/j1;->e:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    instance-of v1, v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    if-eqz v1, :cond_0

    .line 2
    check-cast v0, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$DrawAOLInteractionListener;->onStart()V

    :cond_0
    return-void
.end method


# virtual methods
.method public onEnd()V
    .locals 2

    .line 1
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/b1$$ExternalSyntheticLambda2;

    invoke-direct {v1, p0}, Lio/dcloud/p/b1$$ExternalSyntheticLambda2;-><init>(Lio/dcloud/p/b1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public onError()V
    .locals 2

    .line 1
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/b1$$ExternalSyntheticLambda3;

    invoke-direct {v1, p0}, Lio/dcloud/p/b1$$ExternalSyntheticLambda3;-><init>(Lio/dcloud/p/b1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public onPause()V
    .locals 2

    .line 1
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/b1$$ExternalSyntheticLambda1;

    invoke-direct {v1, p0}, Lio/dcloud/p/b1$$ExternalSyntheticLambda1;-><init>(Lio/dcloud/p/b1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public onResume()V
    .locals 2

    .line 1
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/b1$$ExternalSyntheticLambda4;

    invoke-direct {v1, p0}, Lio/dcloud/p/b1$$ExternalSyntheticLambda4;-><init>(Lio/dcloud/p/b1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public onStart()V
    .locals 2

    .line 1
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/b1$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Lio/dcloud/p/b1$$ExternalSyntheticLambda0;-><init>(Lio/dcloud/p/b1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method
