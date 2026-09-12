.class Lcom/dcloud/android/v4/widget/ScrollerCompat$ScrollerCompatImplBase;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lcom/dcloud/android/v4/widget/ScrollerCompat$ScrollerCompatImpl;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/dcloud/android/v4/widget/ScrollerCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ScrollerCompatImplBase"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abortAnimation(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->abortAnimation()V

    return-void
.end method

.method public computeScrollOffset(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result p1

    return p1
.end method

.method public createScroller(Landroid/content/Context;Landroid/view/animation/Interpolator;)Ljava/lang/Object;
    .locals 1

    if-eqz p2, :cond_0

    .line 1
    new-instance v0, Landroid/widget/Scroller;

    invoke-direct {v0, p1, p2}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    return-object v0

    :cond_0
    new-instance p2, Landroid/widget/Scroller;

    invoke-direct {p2, p1}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;)V

    return-object p2
.end method

.method public fling(Ljava/lang/Object;IIIIIIII)V
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual/range {p1 .. p9}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    return-void
.end method

.method public fling(Ljava/lang/Object;IIIIIIIIII)V
    .locals 0

    .line 2
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual/range {p1 .. p9}, Landroid/widget/Scroller;->fling(IIIIIIII)V

    return-void
.end method

.method public getCurrVelocity(Ljava/lang/Object;)F
    .locals 0

    const/4 p1, 0x0

    return p1
.end method

.method public getCurrX(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->getCurrX()I

    move-result p1

    return p1
.end method

.method public getCurrY(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->getCurrY()I

    move-result p1

    return p1
.end method

.method public getFinalX(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->getFinalX()I

    move-result p1

    return p1
.end method

.method public getFinalY(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->getFinalY()I

    move-result p1

    return p1
.end method

.method public isFinished(Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1}, Landroid/widget/Scroller;->isFinished()Z

    move-result p1

    return p1
.end method

.method public isOverScrolled(Ljava/lang/Object;)Z
    .locals 0

    const/4 p1, 0x0

    return p1
.end method

.method public notifyHorizontalEdgeReached(Ljava/lang/Object;III)V
    .locals 0

    return-void
.end method

.method public notifyVerticalEdgeReached(Ljava/lang/Object;III)V
    .locals 0

    return-void
.end method

.method public startScroll(Ljava/lang/Object;IIII)V
    .locals 0

    .line 1
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual {p1, p2, p3, p4, p5}, Landroid/widget/Scroller;->startScroll(IIII)V

    return-void
.end method

.method public startScroll(Ljava/lang/Object;IIIII)V
    .locals 0

    .line 2
    check-cast p1, Landroid/widget/Scroller;

    invoke-virtual/range {p1 .. p6}, Landroid/widget/Scroller;->startScroll(IIIII)V

    return-void
.end method
