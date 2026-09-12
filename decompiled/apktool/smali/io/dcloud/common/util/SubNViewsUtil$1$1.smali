.class Lio/dcloud/common/util/SubNViewsUtil$1$1;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/common/util/SubNViewsUtil$1;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/dcloud/common/util/SubNViewsUtil$1;


# direct methods
.method constructor <init>(Lio/dcloud/common/util/SubNViewsUtil$1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .line 1
    iget-object v0, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v0, v0, Lio/dcloud/common/util/SubNViewsUtil$1;->val$staticNViews:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v1, :cond_0

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    add-int/lit8 v3, v3, 0x1

    check-cast v4, Lio/dcloud/common/DHInterface/INativeView;

    .line 2
    iget-object v5, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v5, v5, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webParent:Landroid/view/ViewGroup;

    invoke-interface {v4}, Lio/dcloud/common/DHInterface/INativeView;->obtanMainView()Landroid/view/View;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 3
    iget-object v5, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v5, v5, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webView:Landroid/view/ViewGroup;

    invoke-interface {v4}, Lio/dcloud/common/DHInterface/INativeView;->obtanMainView()Landroid/view/View;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 5
    :cond_0
    iget-object v0, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v1, v0, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webParent:Landroid/view/ViewGroup;

    iget-object v0, v0, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webView:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 6
    iget-object v0, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v0, v0, Lio/dcloud/common/util/SubNViewsUtil$1;->val$frameView:Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    iget v0, v0, Lio/dcloud/common/adapter/util/ViewOptions;->background:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 7
    iget-object v0, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v0, v0, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webParent:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 10
    :cond_1
    :try_start_0
    iget-object v0, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v0, v0, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webView:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v1, "onResume"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    iget-object v1, p0, Lio/dcloud/common/util/SubNViewsUtil$1$1;->this$0:Lio/dcloud/common/util/SubNViewsUtil$1;

    iget-object v1, v1, Lio/dcloud/common/util/SubNViewsUtil$1;->val$webView:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    .line 12
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    return-void
.end method
