.class public Lcom/dcloud/android/graphics/Region;
.super Landroid/graphics/Region;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private HOLD_SCREEN_COUNT:I

.field fillScreenCounter:I


# direct methods
.method public constructor <init>()V
    .locals 1

    const/4 v0, 0x1

    .line 1
    invoke-direct {p0, v0}, Lcom/dcloud/android/graphics/Region;-><init>(I)V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 1

    .line 2
    invoke-direct {p0}, Landroid/graphics/Region;-><init>()V

    const/4 v0, 0x1

    .line 3
    iput v0, p0, Lcom/dcloud/android/graphics/Region;->fillScreenCounter:I

    .line 12
    iput p1, p0, Lcom/dcloud/android/graphics/Region;->HOLD_SCREEN_COUNT:I

    return-void
.end method


# virtual methods
.method public count()V
    .locals 1

    .line 1
    iget v0, p0, Lcom/dcloud/android/graphics/Region;->fillScreenCounter:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/dcloud/android/graphics/Region;->fillScreenCounter:I

    return-void
.end method

.method public fillWholeScreen()Z
    .locals 2

    .line 1
    iget v0, p0, Lcom/dcloud/android/graphics/Region;->fillScreenCounter:I

    iget v1, p0, Lcom/dcloud/android/graphics/Region;->HOLD_SCREEN_COUNT:I

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public getFillScreenCounter()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/dcloud/android/graphics/Region;->fillScreenCounter:I

    return v0
.end method
