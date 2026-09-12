.class Lio/dcloud/p/g4$m;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Landroid/view/PixelCopy$OnPixelCopyFinishedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/g4;->a(Landroid/view/View;Landroid/view/Window;Lio/dcloud/p/g4$o;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/p/g4$o;

.field final synthetic b:Landroid/graphics/Bitmap;

.field final synthetic c:Landroid/view/View;


# direct methods
.method constructor <init>(Lio/dcloud/p/g4$o;Landroid/graphics/Bitmap;Landroid/view/View;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/g4$m;->a:Lio/dcloud/p/g4$o;

    iput-object p2, p0, Lio/dcloud/p/g4$m;->b:Landroid/graphics/Bitmap;

    iput-object p3, p0, Lio/dcloud/p/g4$m;->c:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPixelCopyFinished(I)V
    .locals 2

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lio/dcloud/p/g4$m;->a:Lio/dcloud/p/g4$o;

    iget-object v0, p0, Lio/dcloud/p/g4$m;->b:Landroid/graphics/Bitmap;

    const/4 v1, 0x0

    invoke-interface {p1, v1, v0}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void

    .line 3
    :cond_0
    iget-object p1, p0, Lio/dcloud/p/g4$m;->c:Landroid/view/View;

    iget-object v0, p0, Lio/dcloud/p/g4$m;->a:Lio/dcloud/p/g4$o;

    invoke-static {p1, v0}, Lio/dcloud/p/g4;->a(Landroid/view/View;Lio/dcloud/p/g4$o;)V

    return-void
.end method
