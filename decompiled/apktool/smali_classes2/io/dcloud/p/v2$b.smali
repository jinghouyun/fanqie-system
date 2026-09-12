.class Lio/dcloud/p/v2$b;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/v2;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/p/v2;


# direct methods
.method constructor <init>(Lio/dcloud/p/v2;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/v2$b;->a:Lio/dcloud/p/v2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/v2$b;->a:Lio/dcloud/p/v2;

    iget-object v0, v0, Lio/dcloud/p/v2;->a:Lio/dcloud/p/v2$c;

    invoke-interface {v0}, Lio/dcloud/p/v2$c;->m()V

    return-void
.end method
