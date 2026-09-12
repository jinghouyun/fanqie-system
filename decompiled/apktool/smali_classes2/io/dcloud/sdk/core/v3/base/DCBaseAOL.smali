.class public Lio/dcloud/sdk/core/v3/base/DCBaseAOL;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private a:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;->a:Landroid/app/Activity;

    return-void
.end method


# virtual methods
.method public getContext()Landroid/app/Activity;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/base/DCBaseAOL;->a:Landroid/app/Activity;

    return-object v0
.end method
