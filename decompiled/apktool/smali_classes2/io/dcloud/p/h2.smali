.class public Lio/dcloud/p/h2;
.super Landroid/animation/ValueAnimator;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private a:Z

.field private b:Lio/dcloud/p/i2;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroid/animation/ValueAnimator;-><init>()V

    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Lio/dcloud/p/h2;->a:Z

    .line 7
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {p0, v0}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    return-void
.end method


# virtual methods
.method public a(Lio/dcloud/p/g2;Lio/dcloud/p/g2;)V
    .locals 2

    const/4 v0, 0x2

    .line 1
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/4 v1, 0x1

    aput-object p2, v0, v1

    invoke-virtual {p0, v0}, Lio/dcloud/p/h2;->setObjectValues([Ljava/lang/Object;)V

    .line 2
    invoke-static {p1, p2}, Lio/dcloud/p/g2;->a(Lio/dcloud/p/g2;Lio/dcloud/p/g2;)Z

    move-result p1

    iput-boolean p1, p0, Lio/dcloud/p/h2;->a:Z

    return-void
.end method

.method public a()Z
    .locals 1

    .line 3
    iget-boolean v0, p0, Lio/dcloud/p/h2;->a:Z

    return v0
.end method

.method public varargs setObjectValues([Ljava/lang/Object;)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Landroid/animation/ValueAnimator;->setObjectValues([Ljava/lang/Object;)V

    .line 2
    iget-object p1, p0, Lio/dcloud/p/h2;->b:Lio/dcloud/p/i2;

    if-nez p1, :cond_0

    .line 3
    new-instance p1, Lio/dcloud/p/i2;

    invoke-direct {p1}, Lio/dcloud/p/i2;-><init>()V

    iput-object p1, p0, Lio/dcloud/p/h2;->b:Lio/dcloud/p/i2;

    .line 5
    :cond_0
    iget-object p1, p0, Lio/dcloud/p/h2;->b:Lio/dcloud/p/i2;

    invoke-virtual {p0, p1}, Landroid/animation/ValueAnimator;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    return-void
.end method
