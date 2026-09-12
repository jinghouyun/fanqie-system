.class Lcom/dcloud/android/v4/widget/ScrollerCompatGingerbread;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# direct methods
.method constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static abortAnimation(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->abortAnimation()V

    return-void
.end method

.method public static computeScrollOffset(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->computeScrollOffset()Z

    move-result p0

    return p0
.end method

.method public static createScroller(Landroid/content/Context;Landroid/view/animation/Interpolator;)Ljava/lang/Object;
    .locals 1

    if-eqz p1, :cond_0

    .line 1
    new-instance v0, Landroid/widget/OverScroller;

    invoke-direct {v0, p0, p1}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    return-object v0

    :cond_0
    new-instance p1, Landroid/widget/OverScroller;

    invoke-direct {p1, p0}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;)V

    return-object p1
.end method

.method public static fling(Ljava/lang/Object;IIIIIIII)V
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual/range {p0 .. p8}, Landroid/widget/OverScroller;->fling(IIIIIIII)V

    return-void
.end method

.method public static fling(Ljava/lang/Object;IIIIIIIIII)V
    .locals 0

    .line 2
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual/range {p0 .. p10}, Landroid/widget/OverScroller;->fling(IIIIIIIIII)V

    return-void
.end method

.method public static getCurrX(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->getCurrX()I

    move-result p0

    return p0
.end method

.method public static getCurrY(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->getCurrY()I

    move-result p0

    return p0
.end method

.method public static getFinalX(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->getFinalX()I

    move-result p0

    return p0
.end method

.method public static getFinalY(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->getFinalY()I

    move-result p0

    return p0
.end method

.method public static isFinished(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->isFinished()Z

    move-result p0

    return p0
.end method

.method public static isOverScrolled(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0}, Landroid/widget/OverScroller;->isOverScrolled()Z

    move-result p0

    return p0
.end method

.method public static notifyHorizontalEdgeReached(Ljava/lang/Object;III)V
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0, p1, p2, p3}, Landroid/widget/OverScroller;->notifyHorizontalEdgeReached(III)V

    return-void
.end method

.method public static notifyVerticalEdgeReached(Ljava/lang/Object;III)V
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0, p1, p2, p3}, Landroid/widget/OverScroller;->notifyVerticalEdgeReached(III)V

    return-void
.end method

.method public static startScroll(Ljava/lang/Object;IIII)V
    .locals 0

    .line 1
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/widget/OverScroller;->startScroll(IIII)V

    return-void
.end method

.method public static startScroll(Ljava/lang/Object;IIIII)V
    .locals 0

    .line 2
    check-cast p0, Landroid/widget/OverScroller;

    invoke-virtual/range {p0 .. p5}, Landroid/widget/OverScroller;->startScroll(IIIII)V

    return-void
.end method
