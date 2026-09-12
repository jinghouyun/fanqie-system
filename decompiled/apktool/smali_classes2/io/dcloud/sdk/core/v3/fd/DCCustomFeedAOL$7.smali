.class Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
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
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iput-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->a:Landroid/widget/FrameLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->a:Landroid/widget/FrameLayout;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 2
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->a:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->a:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 4
    :cond_0
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z

    .line 5
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->onClosed(Ljava/lang/String;)V

    return-void
.end method
