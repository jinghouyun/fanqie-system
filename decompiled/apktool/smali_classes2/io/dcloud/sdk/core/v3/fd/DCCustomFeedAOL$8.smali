.class Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;
.super Landroid/os/CountDownTimer;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/TextView;

.field final synthetic b:Landroid/widget/FrameLayout;

.field final synthetic c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;


# direct methods
.method public static synthetic $r8$lambda$XOOUUpUxp80FwLhqA7tSlF1R8Z4(Landroid/widget/TextView;I)V
    .locals 0

    invoke-static {p0, p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->a(Landroid/widget/TextView;I)V

    return-void
.end method

.method constructor <init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;JJLandroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iput-object p6, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->a:Landroid/widget/TextView;

    iput-object p7, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->b:Landroid/widget/FrameLayout;

    invoke-direct {p0, p2, p3, p4, p5}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method

.method private static synthetic a(Landroid/widget/TextView;I)V
    .locals 1

    if-eqz p0, :cond_0

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, "s"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z

    .line 2
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const-wide/16 v1, 0x0

    invoke-static {v0, v1, v2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;J)J

    .line 5
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->g(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 6
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->a:Landroid/widget/TextView;

    iget-object v2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->b:Landroid/widget/FrameLayout;

    invoke-static {v0, v1, v2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    :cond_0
    return-void
.end method

.method public onTick(J)V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0, p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;J)J

    long-to-float p1, p1

    const/high16 p2, 0x447a0000    # 1000.0f

    div-float/2addr p1, p2

    .line 3
    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result p1

    const/4 p2, 0x0

    invoke-static {p2, p1}, Ljava/lang/Math;->max(II)I

    move-result p1

    .line 4
    iget-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/app/Activity;

    move-result-object p2

    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;->a:Landroid/widget/TextView;

    new-instance v1, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8$$ExternalSyntheticLambda0;

    invoke-direct {v1, v0, p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8$$ExternalSyntheticLambda0;-><init>(Landroid/widget/TextView;I)V

    invoke-virtual {p2, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method
