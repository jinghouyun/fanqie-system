.class public Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/sdk/core/entry/DCloudAOLSlot;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DramaConfig"
.end annotation


# instance fields
.field private a:I

.field private b:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    .line 3
    iput v0, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->a:I

    .line 5
    iput v0, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->b:I

    return-void
.end method


# virtual methods
.method public getFreeCount()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->a:I

    return v0
.end method

.method public getLockCount()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->b:I

    return v0
.end method

.method public setFreeCount(I)V
    .locals 1

    .line 1
    iput p1, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->a:I

    const/16 v0, 0x14

    if-le p1, v0, :cond_0

    .line 3
    iput v0, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->a:I

    :cond_0
    return-void
.end method

.method public setLockCount(I)V
    .locals 1

    .line 1
    iput p1, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->b:I

    const/16 v0, 0xa

    if-le p1, v0, :cond_0

    .line 3
    iput v0, p0, Lio/dcloud/sdk/core/entry/DCloudAOLSlot$DramaConfig;->b:I

    :cond_0
    return-void
.end method
