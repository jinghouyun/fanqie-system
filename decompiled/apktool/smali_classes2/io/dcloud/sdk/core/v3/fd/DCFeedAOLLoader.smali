.class public Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;
.super Lio/dcloud/sdk/core/v3/base/DCBaseAOL;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field protected b:Lio/dcloud/p/k1;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;-><init>(Landroid/app/Activity;)V

    return-void
.end method


# virtual methods
.method public initLoader()V
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;->b:Lio/dcloud/p/k1;

    if-nez v0, :cond_0

    .line 2
    new-instance v0, Lio/dcloud/p/k1;

    invoke-virtual {p0}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;->getContext()Landroid/app/Activity;

    move-result-object v1

    const/4 v2, 0x4

    invoke-direct {v0, v1, v2}, Lio/dcloud/p/k1;-><init>(Landroid/app/Activity;I)V

    iput-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;->b:Lio/dcloud/p/k1;

    :cond_0
    return-void
.end method

.method public load(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoadListener;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;->getContext()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_1

    if-nez p1, :cond_0

    goto :goto_0

    .line 7
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;->initLoader()V

    .line 8
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;->b:Lio/dcloud/p/k1;

    new-instance v1, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader$1;

    invoke-direct {v1, p0, p2}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader$1;-><init>(Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoadListener;)V

    invoke-virtual {v0, p1, v1}, Lio/dcloud/p/k1;->a(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Lio/dcloud/p/z1;)V

    return-void

    :cond_1
    :goto_0
    if-eqz p2, :cond_2

    const/16 p1, -0x1396

    .line 9
    invoke-static {p1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {p2, p1, v0, v1}, Lio/dcloud/sdk/core/v3/base/DCBaseAOLLoadListener;->onError(ILjava/lang/String;Lorg/json/JSONArray;)V

    :cond_2
    return-void
.end method
