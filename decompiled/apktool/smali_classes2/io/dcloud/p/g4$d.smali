.class Lio/dcloud/p/g4$d;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Landroid/view/PixelCopy$OnPixelCopyFinishedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Landroid/graphics/Bitmap;

.field final synthetic c:Ljava/util/List;

.field final synthetic d:I

.field final synthetic e:Landroid/graphics/Bitmap;

.field final synthetic f:Lio/dcloud/p/g4$o;


# direct methods
.method constructor <init>(Ljava/util/List;Landroid/graphics/Bitmap;Ljava/util/List;ILandroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/g4$d;->a:Ljava/util/List;

    iput-object p2, p0, Lio/dcloud/p/g4$d;->b:Landroid/graphics/Bitmap;

    iput-object p3, p0, Lio/dcloud/p/g4$d;->c:Ljava/util/List;

    iput p4, p0, Lio/dcloud/p/g4$d;->d:I

    iput-object p5, p0, Lio/dcloud/p/g4$d;->e:Landroid/graphics/Bitmap;

    iput-object p6, p0, Lio/dcloud/p/g4$d;->f:Lio/dcloud/p/g4$o;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPixelCopyFinished(I)V
    .locals 4

    const/4 v0, 0x1

    if-nez p1, :cond_0

    .line 1
    iget-object p1, p0, Lio/dcloud/p/g4$d;->a:Ljava/util/List;

    iget-object v1, p0, Lio/dcloud/p/g4$d;->b:Landroid/graphics/Bitmap;

    invoke-interface {p1, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 4
    :cond_0
    iget-object p1, p0, Lio/dcloud/p/g4$d;->a:Ljava/util/List;

    sget-object v1, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v0, v1}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-interface {p1, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 6
    :goto_0
    iget-object p1, p0, Lio/dcloud/p/g4$d;->c:Ljava/util/List;

    iget v1, p0, Lio/dcloud/p/g4$d;->d:I

    add-int/2addr v1, v0

    iget-object v0, p0, Lio/dcloud/p/g4$d;->e:Landroid/graphics/Bitmap;

    iget-object v2, p0, Lio/dcloud/p/g4$d;->a:Ljava/util/List;

    iget-object v3, p0, Lio/dcloud/p/g4$d;->f:Lio/dcloud/p/g4$o;

    invoke-static {p1, v1, v0, v2, v3}, Lio/dcloud/p/g4;->a(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V

    return-void
.end method
