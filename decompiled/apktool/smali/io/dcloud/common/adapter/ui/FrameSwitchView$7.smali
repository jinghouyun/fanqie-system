.class Lio/dcloud/common/adapter/ui/FrameSwitchView$7;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/adapter/ui/FrameBitmapView$ClearAnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/common/adapter/ui/FrameSwitchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/dcloud/common/adapter/ui/FrameSwitchView;


# direct methods
.method constructor <init>(Lio/dcloud/common/adapter/ui/FrameSwitchView;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/common/adapter/ui/FrameSwitchView$7;->this$0:Lio/dcloud/common/adapter/ui/FrameSwitchView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/common/adapter/ui/FrameSwitchView$7;->this$0:Lio/dcloud/common/adapter/ui/FrameSwitchView;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/FrameSwitchView;->endRefreshView()V

    return-void
.end method
