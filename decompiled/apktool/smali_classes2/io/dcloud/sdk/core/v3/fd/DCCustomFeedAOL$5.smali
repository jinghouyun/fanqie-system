.class Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/sdk/core/interfaces/AOLLoader$VideoAdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->getFeedAOLView()Landroid/view/View;
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
.method constructor <init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iput-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->a:Landroid/widget/TextView;

    iput-object p3, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->b:Landroid/widget/FrameLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressUpdate(JJ)V
    .locals 0

    return-void
.end method

.method public onVideoAdComplete()V
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->i(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/CountDownTimer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->i(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/CountDownTimer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    .line 3
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/os/CountDownTimer;)Landroid/os/CountDownTimer;

    .line 5
    :cond_0
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z

    .line 6
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const-wide/16 v1, 0x0

    invoke-static {v0, v1, v2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;J)J

    .line 9
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->g(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 10
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->a:Landroid/widget/TextView;

    iget-object v2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->b:Landroid/widget/FrameLayout;

    invoke-static {v0, v1, v2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    :cond_1
    return-void
.end method

.method public onVideoAdPaused()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)V

    return-void
.end method

.method public onVideoAdResume()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)V

    return-void
.end method

.method public onVideoAdStartPlay()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->j(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)V

    return-void
.end method

.method public onVideoError(ILjava/lang/String;)V
    .locals 1

    .line 1
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->i(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/CountDownTimer;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 2
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->i(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/CountDownTimer;

    move-result-object p1

    invoke-virtual {p1}, Landroid/os/CountDownTimer;->cancel()V

    .line 3
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 p2, 0x0

    invoke-static {p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/os/CountDownTimer;)Landroid/os/CountDownTimer;

    .line 5
    :cond_0
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 p2, 0x0

    invoke-static {p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z

    .line 6
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iget-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->a:Landroid/widget/TextView;

    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->b:Landroid/widget/FrameLayout;

    invoke-static {p1, p2, v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    return-void
.end method

.method public onVideoLoad()V
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->c:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->a:Landroid/widget/TextView;

    iget-object v2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;->b:Landroid/widget/FrameLayout;

    invoke-static {v0, v1, v2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    return-void
.end method
