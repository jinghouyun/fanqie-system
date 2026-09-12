.class Lio/dcloud/p/y4$a;
.super Ljava/util/HashMap;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/y4;->a(Lio/dcloud/sdk/core/adapter/IAdAdapter;Lio/dcloud/p/v4;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/p/y4;


# direct methods
.method constructor <init>(Lio/dcloud/p/y4;)V
    .locals 1

    .line 1
    iput-object p1, p0, Lio/dcloud/p/y4$a;->a:Lio/dcloud/p/y4;

    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 2
    const-string v0, "dc_adn"

    invoke-virtual {p0, v0, p1}, Ljava/util/AbstractMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
