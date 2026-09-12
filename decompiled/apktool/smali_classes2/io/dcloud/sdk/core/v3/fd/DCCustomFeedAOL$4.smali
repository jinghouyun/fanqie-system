.class Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->getFeedAOLView()Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/FrameLayout;

.field final synthetic b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;


# direct methods
.method constructor <init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/FrameLayout;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iput-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->a:Landroid/widget/FrameLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 1
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Z

    move-result p1

    if-nez p1, :cond_2

    .line 3
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Ljava/lang/Runnable;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 4
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->f(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/Handler;

    move-result-object p1

    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 5
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z

    .line 9
    :cond_0
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->a:Landroid/widget/FrameLayout;

    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object p1

    instance-of p1, p1, Landroid/view/ViewGroup;

    if-eqz p1, :cond_1

    .line 10
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->a:Landroid/widget/FrameLayout;

    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object p1

    check-cast p1, Landroid/view/ViewGroup;

    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->a:Landroid/widget/FrameLayout;

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 12
    :cond_1
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {p1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    move-result-object p1

    const-string v0, ""

    invoke-virtual {p1, v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->onClosed(Ljava/lang/String;)V

    :cond_2
    return-void
.end method
