.class public Lio/dcloud/sdk/core/v3/sp/DCB2FSplashAOL;
.super Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 2

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;-><init>(Landroid/app/Activity;)V

    .line 2
    new-instance v0, Lio/dcloud/p/t;

    const/4 v1, 0x1

    invoke-direct {v0, p1, v1}, Lio/dcloud/p/t;-><init>(Landroid/app/Activity;I)V

    iput-object v0, p0, Lio/dcloud/sdk/core/v3/sp/DCSplashAOL;->b:Lio/dcloud/p/k4;

    return-void
.end method
