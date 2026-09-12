.class public final Lio/dcloud/uts/JSNumberUtil;
.super Ljava/lang/Object;
.source "JSNumberUtil.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0006\n\u0000\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\u0008"
    }
    d2 = {
        "Lio/dcloud/uts/JSNumberUtil;",
        "",
        "<init>",
        "()V",
        "doubleToInt32",
        "",
        "d",
        "",
        "utsplugin_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final INSTANCE:Lio/dcloud/uts/JSNumberUtil;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lio/dcloud/uts/JSNumberUtil;

    invoke-direct {v0}, Lio/dcloud/uts/JSNumberUtil;-><init>()V

    sput-object v0, Lio/dcloud/uts/JSNumberUtil;->INSTANCE:Lio/dcloud/uts/JSNumberUtil;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final doubleToInt32(D)I
    .locals 8

    .line 7
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-static {v0}, Lio/dcloud/uts/NumberKt;->isNaN(Ljava/lang/Number;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_3

    invoke-static {p1, p2}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 10
    :cond_0
    invoke-static {p1, p2}, Ljava/lang/Double;->doubleToRawLongBits(D)J

    move-result-wide v2

    const/16 v0, 0x34

    shr-long v4, v2, v0

    const-wide/16 v6, 0x7ff

    and-long/2addr v4, v6

    long-to-int v0, v4

    const/16 v4, 0x41d

    if-gt v0, v4, :cond_1

    double-to-int p1, p1

    return p1

    :cond_1
    const/16 p1, 0x452

    if-gt v0, p1, :cond_3

    const-wide p1, 0xfffffffffffffL

    and-long/2addr p1, v2

    const-wide/high16 v4, 0x10000000000000L

    or-long/2addr p1, v4

    add-int/lit16 v0, v0, -0x413

    shl-long/2addr p1, v0

    const/16 v0, 0x20

    ushr-long/2addr p1, v0

    const/16 v0, 0x3f

    shr-long v0, v2, v0

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-eqz v4, :cond_2

    const-wide/32 v0, -0x80000000

    cmp-long v2, p1, v0

    if-eqz v2, :cond_2

    neg-long p1, p1

    :cond_2
    long-to-int p2, p1

    return p2

    :cond_3
    :goto_0
    return v1
.end method
