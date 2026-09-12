.class Lio/dcloud/p/g4$h;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/g4;->b(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/app/Activity;

.field final synthetic c:Z

.field final synthetic d:Lio/dcloud/p/g4$o;


# direct methods
.method constructor <init>(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/g4$h;->a:Landroid/view/View;

    iput-object p2, p0, Lio/dcloud/p/g4$h;->b:Landroid/app/Activity;

    iput-boolean p3, p0, Lio/dcloud/p/g4$h;->c:Z

    iput-object p4, p0, Lio/dcloud/p/g4$h;->d:Lio/dcloud/p/g4$o;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 1
    iget-object v0, p0, Lio/dcloud/p/g4$h;->a:Landroid/view/View;

    iget-object v1, p0, Lio/dcloud/p/g4$h;->b:Landroid/app/Activity;

    iget-boolean v2, p0, Lio/dcloud/p/g4$h;->c:Z

    iget-object v3, p0, Lio/dcloud/p/g4$h;->d:Lio/dcloud/p/g4$o;

    invoke-static {v0, v1, v2, v3}, Lio/dcloud/p/g4;->a(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V

    return-void
.end method
