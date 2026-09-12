.class public final enum Lio/dcloud/p/k2;
.super Ljava/lang/Enum;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field public static final enum a:Lio/dcloud/p/k2;

.field public static final enum b:Lio/dcloud/p/k2;

.field public static final enum c:Lio/dcloud/p/k2;

.field public static final enum d:Lio/dcloud/p/k2;

.field private static final synthetic e:[Lio/dcloud/p/k2;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lio/dcloud/p/k2;

    const-string v1, "NONE"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lio/dcloud/p/k2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/dcloud/p/k2;->a:Lio/dcloud/p/k2;

    .line 2
    new-instance v0, Lio/dcloud/p/k2;

    const-string v1, "DOODLE"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lio/dcloud/p/k2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/dcloud/p/k2;->b:Lio/dcloud/p/k2;

    .line 3
    new-instance v0, Lio/dcloud/p/k2;

    const-string v1, "MOSAIC"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lio/dcloud/p/k2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/dcloud/p/k2;->c:Lio/dcloud/p/k2;

    .line 4
    new-instance v0, Lio/dcloud/p/k2;

    const-string v1, "CLIP"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Lio/dcloud/p/k2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lio/dcloud/p/k2;->d:Lio/dcloud/p/k2;

    .line 5
    invoke-static {}, Lio/dcloud/p/k2;->a()[Lio/dcloud/p/k2;

    move-result-object v0

    sput-object v0, Lio/dcloud/p/k2;->e:[Lio/dcloud/p/k2;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method private static synthetic a()[Lio/dcloud/p/k2;
    .locals 3

    const/4 v0, 0x4

    .line 1
    new-array v0, v0, [Lio/dcloud/p/k2;

    sget-object v1, Lio/dcloud/p/k2;->a:Lio/dcloud/p/k2;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sget-object v1, Lio/dcloud/p/k2;->b:Lio/dcloud/p/k2;

    const/4 v2, 0x1

    aput-object v1, v0, v2

    sget-object v1, Lio/dcloud/p/k2;->c:Lio/dcloud/p/k2;

    const/4 v2, 0x2

    aput-object v1, v0, v2

    sget-object v1, Lio/dcloud/p/k2;->d:Lio/dcloud/p/k2;

    const/4 v2, 0x3

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lio/dcloud/p/k2;
    .locals 1

    .line 1
    const-class v0, Lio/dcloud/p/k2;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lio/dcloud/p/k2;

    return-object p0
.end method

.method public static values()[Lio/dcloud/p/k2;
    .locals 1

    .line 1
    sget-object v0, Lio/dcloud/p/k2;->e:[Lio/dcloud/p/k2;

    invoke-virtual {v0}, [Lio/dcloud/p/k2;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lio/dcloud/p/k2;

    return-object v0
.end method
