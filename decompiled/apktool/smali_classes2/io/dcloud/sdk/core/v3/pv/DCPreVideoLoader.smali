.class public Lio/dcloud/sdk/core/v3/pv/DCPreVideoLoader;
.super Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;-><init>(Landroid/app/Activity;)V

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

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lio/dcloud/p/k1;-><init>(Landroid/app/Activity;I)V

    iput-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCFeedAOLLoader;->b:Lio/dcloud/p/k1;

    :cond_0
    return-void
.end method
