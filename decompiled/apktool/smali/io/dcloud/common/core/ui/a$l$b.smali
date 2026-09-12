.class Lio/dcloud/common/core/ui/a$l$b;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/common/core/ui/a$l;->onSizeChanged(IIII)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/common/core/ui/a$l;


# direct methods
.method constructor <init>(Lio/dcloud/common/core/ui/a$l;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/common/core/ui/a$l$b;->a:Lio/dcloud/common/core/ui/a$l;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 1
    iget-object v0, p0, Lio/dcloud/common/core/ui/a$l$b;->a:Lio/dcloud/common/core/ui/a$l;

    iget-object v0, v0, Lio/dcloud/common/core/ui/a$l;->A:Lio/dcloud/common/core/ui/a;

    invoke-static {v0}, Lio/dcloud/common/core/ui/a;->c(Lio/dcloud/common/core/ui/a;)Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 2
    iget-object v0, p0, Lio/dcloud/common/core/ui/a$l$b;->a:Lio/dcloud/common/core/ui/a$l;

    iget-object v0, v0, Lio/dcloud/common/core/ui/a$l;->A:Lio/dcloud/common/core/ui/a;

    invoke-static {v0}, Lio/dcloud/common/core/ui/a;->c(Lio/dcloud/common/core/ui/a;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x0

    :cond_0
    :goto_0
    if-ge v2, v1, :cond_1

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    add-int/lit8 v2, v2, 0x1

    check-cast v3, Lio/dcloud/common/core/ui/b;

    .line 3
    iget-boolean v4, v3, Lio/dcloud/common/adapter/ui/AdaFrameView;->isChildOfFrameView:Z

    if-nez v4, :cond_0

    .line 4
    invoke-virtual {v3}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->resize()V

    goto :goto_0

    :cond_1
    return-void
.end method
