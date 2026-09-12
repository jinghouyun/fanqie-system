.class Lio/dcloud/common/adapter/ui/AdaFrameItem$DefaultView;
.super Landroid/view/View;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/common/adapter/ui/AdaFrameItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DefaultView"
.end annotation


# instance fields
.field final synthetic this$0:Lio/dcloud/common/adapter/ui/AdaFrameItem;


# direct methods
.method public constructor <init>(Lio/dcloud/common/adapter/ui/AdaFrameItem;Landroid/content/Context;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/common/adapter/ui/AdaFrameItem$DefaultView;->this$0:Lio/dcloud/common/adapter/ui/AdaFrameItem;

    .line 2
    invoke-direct {p0, p2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Landroid/view/View;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 2
    iget-object p1, p0, Lio/dcloud/common/adapter/ui/AdaFrameItem$DefaultView;->this$0:Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->onResize()V

    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/common/adapter/ui/AdaFrameItem$DefaultView;->this$0:Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0, p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->paint(Landroid/graphics/Canvas;)V

    return-void
.end method
