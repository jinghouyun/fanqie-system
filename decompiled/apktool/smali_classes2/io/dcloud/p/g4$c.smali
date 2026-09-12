.class Lio/dcloud/p/g4$c;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/g4;->b(Landroid/view/View;Lio/dcloud/p/g4$o;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/p/g4$o;


# direct methods
.method constructor <init>(Lio/dcloud/p/g4$o;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/g4$c;->a:Lio/dcloud/p/g4$o;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/g4$c;->a:Lio/dcloud/p/g4$o;

    const/4 v1, 0x0

    invoke-interface {v0, v1, v1}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void
.end method
