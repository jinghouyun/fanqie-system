.class public final Lio/dcloud/uts/nativeregex/JSRegexp$Companion;
.super Ljava/lang/Object;
.source "JSRegexp.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/uts/nativeregex/JSRegexp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007\u00a8\u0006\t"
    }
    d2 = {
        "Lio/dcloud/uts/nativeregex/JSRegexp$Companion;",
        "",
        "<init>",
        "()V",
        "create",
        "Lio/dcloud/uts/nativeregex/JSRegexp;",
        "pattern",
        "",
        "flags",
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


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;-><init>()V

    return-void
.end method

.method public static synthetic create$default(Lio/dcloud/uts/nativeregex/JSRegexp$Companion;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lio/dcloud/uts/nativeregex/JSRegexp;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    .line 14
    const-string p2, ""

    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;->create(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/uts/nativeregex/JSRegexp;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final create(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/uts/nativeregex/JSRegexp;
    .locals 5

    const-string v0, "pattern"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "flags"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v1, v0, :cond_8

    invoke-virtual {p2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x64

    if-eq v3, v4, :cond_7

    const/16 v4, 0x67

    if-eq v3, v4, :cond_6

    const/16 v4, 0x69

    if-eq v3, v4, :cond_5

    const/16 v4, 0x6d

    if-eq v3, v4, :cond_4

    const/16 v4, 0x73

    if-eq v3, v4, :cond_3

    const/16 v4, 0x79

    if-eq v3, v4, :cond_2

    const/16 v4, 0x75

    if-eq v3, v4, :cond_1

    const/16 v4, 0x76

    if-ne v3, v4, :cond_0

    or-int/lit16 v2, v2, 0x80

    goto :goto_1

    .line 27
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "\u65e0\u6548\u7684\u6b63\u5219\u8868\u8fbe\u5f0f\u6807\u5fd7: "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_1
    or-int/lit8 v2, v2, 0x10

    goto :goto_1

    :cond_2
    or-int/lit8 v2, v2, 0x20

    goto :goto_1

    :cond_3
    or-int/lit8 v2, v2, 0x8

    goto :goto_1

    :cond_4
    or-int/lit8 v2, v2, 0x4

    goto :goto_1

    :cond_5
    or-int/lit8 v2, v2, 0x2

    goto :goto_1

    :cond_6
    or-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_7
    or-int/lit8 v2, v2, 0x40

    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 32
    :cond_8
    sget-object v0, Lio/dcloud/uts/nativeregex/RegexpBridge;->INSTANCE:Lio/dcloud/uts/nativeregex/RegexpBridge;

    invoke-virtual {v0, p1, v2}, Lio/dcloud/uts/nativeregex/RegexpBridge;->compileRegexp(Ljava/lang/String;I)[B

    move-result-object v0

    .line 33
    new-instance v1, Lio/dcloud/uts/nativeregex/JSRegexp;

    const/4 v2, 0x0

    invoke-direct {v1, v0, p1, p2, v2}, Lio/dcloud/uts/nativeregex/JSRegexp;-><init>([BLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-object v1
.end method
