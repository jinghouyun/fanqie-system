.class Lio/dcloud/common/ui/a$c$g;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/common/ui/a$c;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/common/ui/a$c;


# direct methods
.method constructor <init>(Lio/dcloud/common/ui/a$c;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/common/ui/a$c$g;->a:Lio/dcloud/common/ui/a$c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 0

    .line 1
    iget-object p1, p0, Lio/dcloud/common/ui/a$c$g;->a:Lio/dcloud/common/ui/a$c;

    invoke-virtual {p1}, Landroid/app/Dialog;->cancel()V

    return-void
.end method
