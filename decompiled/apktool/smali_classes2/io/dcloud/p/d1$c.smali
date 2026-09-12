.class abstract Lio/dcloud/p/d1$c;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/p/d1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "c"
.end annotation


# static fields
.field private static final a:Lio/dcloud/p/d1;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lio/dcloud/p/d1;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/dcloud/p/d1;-><init>(Lio/dcloud/p/d1$a;)V

    sput-object v0, Lio/dcloud/p/d1$c;->a:Lio/dcloud/p/d1;

    return-void
.end method

.method static synthetic a()Lio/dcloud/p/d1;
    .locals 1

    .line 1
    sget-object v0, Lio/dcloud/p/d1$c;->a:Lio/dcloud/p/d1;

    return-object v0
.end method
