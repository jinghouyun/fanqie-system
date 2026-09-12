.class Lio/dcloud/p/g4$f;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/p/g4$o;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/g4;->a(Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/app/Activity;

.field final synthetic c:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/g4$f;->a:Landroid/view/View;

    iput-object p2, p0, Lio/dcloud/p/g4$f;->b:Landroid/app/Activity;

    iput-object p3, p0, Lio/dcloud/p/g4$f;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 6

    .line 1
    iget-object v3, p0, Lio/dcloud/p/g4$f;->a:Landroid/view/View;

    iget-object v4, p0, Lio/dcloud/p/g4$f;->b:Landroid/app/Activity;

    iget-object v5, p0, Lio/dcloud/p/g4$f;->c:Ljava/lang/String;

    const-string v0, "captureAndSaveAuto"

    move-object v1, p1

    move-object v2, p2

    invoke-static/range {v0 .. v5}, Lio/dcloud/p/g4;->a(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V

    return-void
.end method
