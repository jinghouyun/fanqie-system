.class Lio/dcloud/p/g4$b;
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

.field final synthetic b:Landroid/graphics/Bitmap;


# direct methods
.method constructor <init>(Lio/dcloud/p/g4$o;Landroid/graphics/Bitmap;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/g4$b;->a:Lio/dcloud/p/g4$o;

    iput-object p2, p0, Lio/dcloud/p/g4$b;->b:Landroid/graphics/Bitmap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/p/g4$b;->a:Lio/dcloud/p/g4$o;

    iget-object v1, p0, Lio/dcloud/p/g4$b;->b:Landroid/graphics/Bitmap;

    const/4 v2, 0x0

    invoke-interface {v0, v2, v1}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void
.end method
