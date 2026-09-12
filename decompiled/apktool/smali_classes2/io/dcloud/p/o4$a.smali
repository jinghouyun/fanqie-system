.class Lio/dcloud/p/o4$a;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/o4;->a(Landroid/view/ViewGroup;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/p/o4;


# direct methods
.method constructor <init>(Lio/dcloud/p/o4;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/o4$a;->a:Lio/dcloud/p/o4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/o4$a;->a:Lio/dcloud/p/o4;

    invoke-static {v0}, Lio/dcloud/p/o4;->a(Lio/dcloud/p/o4;)Lio/dcloud/p/v2$c;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 3
    iget-object v0, p0, Lio/dcloud/p/o4$a;->a:Lio/dcloud/p/o4;

    invoke-static {v0}, Lio/dcloud/p/o4;->a(Lio/dcloud/p/o4;)Lio/dcloud/p/v2$c;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/p/v2$c;->k()V

    :cond_0
    return-void
.end method
