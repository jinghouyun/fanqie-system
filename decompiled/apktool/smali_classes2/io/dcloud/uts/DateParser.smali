.class public final Lio/dcloud/uts/DateParser;
.super Ljava/lang/Object;
.source "Date2.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0016\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J&\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J \u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J&\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020\u0006J6\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002J&\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0002R\u0019\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u000b\u0010\u0008\u00a8\u0006+"
    }
    d2 = {
        "Lio/dcloud/uts/DateParser;",
        "",
        "<init>",
        "()V",
        "DAY_NAMES",
        "",
        "",
        "getDAY_NAMES",
        "()[Ljava/lang/String;",
        "[Ljava/lang/String;",
        "MONTH_NAMES",
        "getMONTH_NAMES",
        "getDateString",
        "dateDouble",
        "",
        "magic",
        "",
        "timeClip",
        "t",
        "parseAndValidateDate",
        "dateString",
        "(Ljava/lang/String;)Ljava/lang/Double;",
        "parseOtherString",
        "Lio/dcloud/uts/ISODateResult;",
        "skipSpaces",
        "",
        "str",
        "startPos",
        "parseMonth",
        "Lkotlin/Pair;",
        "matchString",
        "match",
        "parseTimeZoneAbbr",
        "skipSeparators",
        "skipUntil",
        "chars",
        "parseISOString",
        "isoString",
        "getDigits",
        "minDigits",
        "maxDigits",
        "parseMilliseconds",
        "parseTzOffset",
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
.field private static final DAY_NAMES:[Ljava/lang/String;

.field public static final INSTANCE:Lio/dcloud/uts/DateParser;

.field private static final MONTH_NAMES:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 13

    new-instance v0, Lio/dcloud/uts/DateParser;

    invoke-direct {v0}, Lio/dcloud/uts/DateParser;-><init>()V

    sput-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    .line 1086
    const-string v6, "Fri"

    const-string v7, "Sat"

    const-string v1, "Sun"

    const-string v2, "Mon"

    const-string v3, "Tue"

    const-string v4, "Wed"

    const-string v5, "Thu"

    filled-new-array/range {v1 .. v7}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lio/dcloud/uts/DateParser;->DAY_NAMES:[Ljava/lang/String;

    .line 1098
    const-string v11, "Nov"

    .line 1099
    const-string v12, "Dec"

    const-string v1, "Jan"

    const-string v2, "Feb"

    const-string v3, "Mar"

    const-string v4, "Apr"

    const-string v5, "May"

    const-string v6, "Jun"

    const-string v7, "Jul"

    const-string v8, "Aug"

    const-string v9, "Sep"

    const-string v10, "Oct"

    filled-new-array/range {v1 .. v12}, [Ljava/lang/String;

    move-result-object v0

    .line 1087
    sput-object v0, Lio/dcloud/uts/DateParser;->MONTH_NAMES:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 1083
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final getDigits(Ljava/lang/String;III)Lkotlin/Pair;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "III)",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 1729
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge p2, v2, :cond_0

    if-ge v0, p4, :cond_0

    .line 1730
    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x30

    if-gt v3, v2, :cond_0

    const/16 v3, 0x3a

    if-ge v2, v3, :cond_0

    mul-int/lit8 v1, v1, 0xa

    add-int/lit8 v2, v2, -0x30

    add-int/2addr v1, v2

    add-int/lit8 p2, p2, 0x1

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    if-lt v0, p3, :cond_1

    .line 1738
    new-instance p1, Lkotlin/Pair;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p1, p3, p2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method private final matchString(Ljava/lang/String;ILjava/lang/String;)Z
    .locals 2

    .line 1575
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, p2

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 1576
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr p2, v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    invoke-static {p1, v0, p2}, Lio/dcloud/uts/StringKt;->substring(Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/String;

    move-result-object p1

    const/4 p2, 0x1

    .line 1577
    invoke-static {p1, p3, p2}, Lkotlin/text/StringsKt;->equals(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result p1

    if-eqz p1, :cond_0

    return p2

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method private final parseMilliseconds(Ljava/lang/String;I)Lkotlin/Pair;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    const/16 v1, 0x64

    const/4 v1, 0x0

    const/16 v2, 0x64

    :goto_0
    const/4 v3, 0x3

    const/16 v4, 0x3a

    const/16 v5, 0x30

    if-ge v0, v3, :cond_0

    .line 1748
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge p2, v3, :cond_0

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-gt v5, v3, :cond_0

    if-ge v3, v4, :cond_0

    .line 1749
    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v3

    sub-int/2addr v3, v5

    mul-int v3, v3, v2

    add-int/2addr v1, v3

    .line 1750
    div-int/lit8 v2, v2, 0xa

    add-int/lit8 p2, p2, 0x1

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1756
    :cond_0
    :goto_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p2, v0, :cond_1

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-gt v5, v0, :cond_1

    if-ge v0, v4, :cond_1

    add-int/lit8 p2, p2, 0x1

    goto :goto_1

    .line 1758
    :cond_1
    new-instance p1, Lkotlin/Pair;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p1, v0, p2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1
.end method

.method private final parseMonth(Ljava/lang/String;I)Lkotlin/Pair;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 1554
    const-string v10, "nov"

    const-string v11, "dec"

    const-string v0, "jan"

    const-string v1, "feb"

    const-string v2, "mar"

    const-string v3, "apr"

    const-string v4, "may"

    const-string v5, "jun"

    const-string v6, "jul"

    const-string v7, "aug"

    const-string v8, "sep"

    const-string v9, "oct"

    filled-new-array/range {v0 .. v11}, [Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    :goto_0
    const/16 v2, 0xc

    if-ge v1, v2, :cond_1

    .line 1558
    aget-object v2, v0, v1

    .line 1559
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v3, p2

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    if-gt v3, v4, :cond_0

    .line 1561
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    add-int/2addr v4, p2

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-static {p1, v3, v4}, Lio/dcloud/uts/StringKt;->substring(Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "toLowerCase(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1560
    invoke-static {v3, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1563
    new-instance p1, Lkotlin/Pair;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr p2, v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p1, v0, p2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method private final parseTimeZoneAbbr(Ljava/lang/String;I)Lkotlin/Pair;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    const/16 v0, 0xb

    .line 1583
    new-array v0, v0, [Lkotlin/Pair;

    const-string v1, "ut"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v1, v3}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    aput-object v1, v0, v2

    const-string v1, "utc"

    invoke-static {v1, v3}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    const-string v1, "gmt"

    invoke-static {v1, v3}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v2, 0x2

    aput-object v1, v0, v2

    const/16 v1, -0x12c

    .line 1584
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v2, "est"

    invoke-static {v2, v1}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    const/4 v3, 0x3

    aput-object v2, v0, v3

    const/16 v2, -0xf0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v3, "edt"

    invoke-static {v3, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    const/4 v3, 0x4

    aput-object v2, v0, v3

    const/16 v2, -0x168

    .line 1585
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v3, "cst"

    invoke-static {v3, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v3

    const/4 v4, 0x5

    aput-object v3, v0, v4

    const-string v3, "cdt"

    invoke-static {v3, v1}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v3, 0x6

    aput-object v1, v0, v3

    const/16 v1, -0x1a4

    .line 1586
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string v3, "mst"

    invoke-static {v3, v1}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v3

    const/4 v4, 0x7

    aput-object v3, v0, v4

    const-string v3, "mdt"

    invoke-static {v3, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    const/16 v3, 0x8

    aput-object v2, v0, v3

    const/16 v2, -0x1e0

    .line 1587
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const-string v3, "pst"

    invoke-static {v3, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    const/16 v3, 0x9

    aput-object v2, v0, v3

    const-string v2, "pdt"

    invoke-static {v2, v1}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v2, 0xa

    aput-object v1, v0, v2

    .line 1582
    invoke-static {v0}, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;

    move-result-object v0

    .line 1590
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-virtual {v1}, Ljava/lang/Number;->intValue()I

    move-result v1

    .line 1591
    invoke-direct {p0, p1, p2, v2}, Lio/dcloud/uts/DateParser;->matchString(Ljava/lang/String;ILjava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1592
    new-instance p1, Lkotlin/Pair;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr p2, v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {p1, v0, p2}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method private final parseTzOffset(Ljava/lang/String;I)Lkotlin/Pair;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Lkotlin/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 1765
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    if-lt p2, v0, :cond_0

    return-object v1

    .line 1767
    :cond_0
    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v2, 0x2b

    const/4 v3, 0x1

    if-eq v0, v2, :cond_2

    const/16 v2, 0x2d

    if-eq v0, v2, :cond_1

    return-object v1

    :cond_1
    const/4 v0, -0x1

    goto :goto_0

    :cond_2
    const/4 v0, 0x1

    :goto_0
    add-int/2addr p2, v3

    const/4 v2, 0x2

    .line 1774
    invoke-direct {p0, p1, p2, v2, v2}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object p2

    if-nez p2, :cond_3

    return-object v1

    .line 1775
    :cond_3
    invoke-virtual {p2}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-virtual {v1}, Ljava/lang/Number;->intValue()I

    move-result v1

    .line 1776
    invoke-virtual {p2}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    mul-int/lit8 p2, p2, 0x3c

    .line 1778
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v1, v3, :cond_4

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x3a

    if-ne v3, v4, :cond_4

    add-int/lit8 v1, v1, 0x1

    .line 1780
    :cond_4
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v1, v3, :cond_5

    .line 1781
    invoke-direct {p0, p1, v1, v2, v2}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object p1

    if-eqz p1, :cond_5

    .line 1783
    invoke-virtual {p1}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-virtual {v1}, Ljava/lang/Number;->intValue()I

    move-result v1

    add-int/2addr p2, v1

    .line 1784
    invoke-virtual {p1}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v1

    .line 1788
    :cond_5
    new-instance p1, Lkotlin/Pair;

    mul-int v0, v0, p2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-direct {p1, p2, v0}, Lkotlin/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p1
.end method

.method private final skipSeparators(Ljava/lang/String;I)I
    .locals 2

    .line 1601
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p2, v0, :cond_1

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x20

    if-eq v0, v1, :cond_0

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2c

    if-eq v0, v1, :cond_0

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2d

    if-eq v0, v1, :cond_0

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2f

    if-ne v0, v1, :cond_1

    :cond_0
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    :cond_1
    return p2
.end method

.method private final skipSpaces(Ljava/lang/String;I)Z
    .locals 1

    .line 1544
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p2, v0, :cond_0

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-static {v0}, Lkotlin/text/CharsKt;->isWhitespace(C)Z

    move-result v0

    if-eqz v0, :cond_0

    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 1547
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result p1

    if-ge p2, p1, :cond_1

    const/4 p1, 0x1

    return p1

    :cond_1
    const/4 p1, 0x0

    return p1
.end method

.method private final skipUntil(Ljava/lang/String;ILjava/lang/String;)I
    .locals 7

    .line 1610
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-ge p2, v0, :cond_0

    move-object v1, p3

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/4 v5, 0x6

    const/4 v6, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {v1 .. v6}, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence;CIZILjava/lang/Object;)I

    move-result v0

    if-gez v0, :cond_0

    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    :cond_0
    return p2
.end method


# virtual methods
.method public final getDAY_NAMES()[Ljava/lang/String;
    .locals 1

    .line 1085
    sget-object v0, Lio/dcloud/uts/DateParser;->DAY_NAMES:[Ljava/lang/String;

    return-object v0
.end method

.method public final getDateString(DI)Ljava/lang/String;
    .locals 19

    shr-int/lit8 v0, p3, 0x4

    and-int/lit8 v1, v0, 0xf

    and-int/lit8 v2, p3, 0xf

    .line 1115
    sget-object v3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    const/4 v4, 0x1

    and-int/2addr v0, v4

    const/4 v5, 0x0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    move-wide/from16 v6, p1

    invoke-virtual {v3, v6, v7, v0, v5}, Lio/dcloud/uts/DateHolder;->getDateFields(DZZ)[D

    move-result-object v0

    const/4 v3, 0x2

    if-nez v0, :cond_2

    if-eq v1, v3, :cond_1

    .line 1116
    const-string v0, "Invalid Date"

    return-object v0

    :cond_1
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Date value is NaN"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1119
    :cond_2
    aget-wide v6, v0, v5

    double-to-int v6, v6

    .line 1120
    aget-wide v7, v0, v4

    double-to-int v7, v7

    .line 1121
    aget-wide v8, v0, v3

    double-to-int v8, v8

    const/4 v9, 0x3

    .line 1122
    aget-wide v10, v0, v9

    double-to-int v10, v10

    const/4 v11, 0x4

    .line 1123
    aget-wide v12, v0, v11

    double-to-int v12, v12

    const/4 v13, 0x5

    .line 1124
    aget-wide v13, v0, v13

    double-to-int v13, v13

    const/16 p1, 0x6

    .line 1125
    aget-wide v14, v0, p1

    double-to-int v14, v14

    const/4 v15, 0x7

    move/from16 v16, v12

    const/16 p2, 0x4

    .line 1126
    aget-wide v11, v0, v15

    double-to-int v11, v11

    const/16 v12, 0x8

    move/from16 v17, v6

    .line 1127
    aget-wide v5, v0, v12

    double-to-int v0, v5

    .line 1129
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    and-int/lit8 v6, p3, 0x1

    .line 1132
    const-string v12, "+"

    const/16 v15, 0x30

    if-eqz v6, :cond_d

    .line 1133
    const-string v6, ", "

    if-eqz v1, :cond_b

    if-eq v1, v4, :cond_9

    if-eq v1, v3, :cond_5

    if-eq v1, v9, :cond_3

    goto/16 :goto_6

    .line 1175
    :cond_3
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    add-int/2addr v7, v4

    .line 1176
    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v7

    .line 1175
    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v7, 0x2f

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1177
    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v8

    .line 1175
    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1178
    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    if-gez v17, :cond_4

    const/16 v18, 0x1

    goto :goto_1

    :cond_4
    const/16 v18, 0x0

    :goto_1
    add-int/lit8 v8, v18, 0x4

    invoke-static {v7, v8, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v7

    .line 1175
    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1174
    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-ne v2, v9, :cond_d

    .line 1181
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_6

    :cond_5
    if-ltz v17, :cond_6

    const/16 v2, 0x270f

    move/from16 v6, v17

    if-gt v6, v2, :cond_7

    .line 1161
    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v6, 0x4

    invoke-static {v2, v6, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    :cond_6
    move/from16 v6, v17

    .line 1163
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    if-ltz v6, :cond_8

    move-object v11, v12

    goto :goto_2

    :cond_8
    const-string v11, ""

    :goto_2
    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    const/4 v11, 0x6

    .line 1164
    invoke-static {v6, v11, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v6

    .line 1163
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1167
    :goto_3
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v2, 0x2d

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/2addr v7, v4

    .line 1168
    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v7

    .line 1167
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1169
    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v2

    .line 1167
    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v2, 0x54

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1166
    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_6

    :cond_9
    move/from16 v6, v17

    .line 1147
    sget-object v17, Lio/dcloud/uts/DateParser;->DAY_NAMES:[Ljava/lang/String;

    aget-object v11, v17, v11

    .line 1148
    sget-object v17, Lio/dcloud/uts/DateParser;->MONTH_NAMES:[Ljava/lang/String;

    aget-object v7, v17, v7

    .line 1150
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v11, 0x20

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1151
    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v7

    .line 1150
    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1153
    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    if-gez v6, :cond_a

    const/16 v18, 0x1

    goto :goto_4

    :cond_a
    const/16 v18, 0x0

    :goto_4
    const/4 v6, 0x4

    add-int/lit8 v6, v18, 0x4

    invoke-static {v7, v6, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v6

    .line 1150
    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1149
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-ne v2, v9, :cond_d

    .line 1156
    const-string v2, " "

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_6

    :cond_b
    move/from16 v2, v17

    .line 1135
    sget-object v4, Lio/dcloud/uts/DateParser;->DAY_NAMES:[Ljava/lang/String;

    aget-object v4, v4, v11

    .line 1136
    sget-object v11, Lio/dcloud/uts/DateParser;->MONTH_NAMES:[Ljava/lang/String;

    aget-object v7, v11, v7

    .line 1138
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1139
    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v4

    .line 1138
    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v4, 0x20

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1141
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    if-gez v2, :cond_c

    const/16 v18, 0x1

    goto :goto_5

    :cond_c
    const/16 v18, 0x0

    :goto_5
    const/4 v2, 0x4

    add-int/lit8 v2, v18, 0x4

    invoke-static {v6, v2, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v2

    .line 1138
    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1137
    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_d
    :goto_6
    and-int/lit8 v2, p3, 0x2

    if-eqz v2, :cond_14

    .line 1188
    const-string v2, " GMT"

    const/16 v4, 0x3a

    if-eqz v1, :cond_13

    const/4 v6, 0x1

    if-eq v1, v6, :cond_11

    if-eq v1, v3, :cond_10

    if-eq v1, v9, :cond_e

    goto/16 :goto_9

    :cond_e
    add-int/lit8 v0, v10, 0xb

    const/16 v1, 0xc

    .line 1232
    rem-int/2addr v0, v1

    add-int/2addr v0, v6

    if-ge v10, v1, :cond_f

    const/16 v1, 0x41

    goto :goto_7

    :cond_f
    const/16 v1, 0x50

    .line 1235
    :goto_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 1236
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v0

    .line 1235
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1237
    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v0

    .line 1235
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1238
    invoke-static {v13}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v0

    .line 1235
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v4, 0x20

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const/16 v0, 0x4d

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1234
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_9

    .line 1223
    :cond_10
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1224
    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1223
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1225
    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1223
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1226
    invoke-static {v13}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1223
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x2e

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1227
    invoke-static {v14}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v9, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1223
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x5a

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1222
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_9

    .line 1201
    :cond_11
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1202
    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v6

    .line 1201
    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1203
    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v6

    .line 1201
    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1204
    invoke-static {v13}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v4

    .line 1201
    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1200
    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-gez v0, :cond_12

    .line 1208
    const-string v1, "-"

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    neg-int v0, v0

    goto :goto_8

    .line 1211
    :cond_12
    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1215
    :goto_8
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1216
    div-int/lit8 v2, v0, 0x3c

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v2

    .line 1215
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1217
    rem-int/lit8 v0, v0, 0x3c

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v0

    .line 1215
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1214
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_9

    .line 1191
    :cond_13
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1192
    invoke-static {v10}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1191
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1193
    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1191
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1194
    invoke-static {v13}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3, v15}, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String;IC)Ljava/lang/String;

    move-result-object v1

    .line 1191
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1190
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1245
    :cond_14
    :goto_9
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "toString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public final getMONTH_NAMES()[Ljava/lang/String;
    .locals 1

    .line 1087
    sget-object v0, Lio/dcloud/uts/DateParser;->MONTH_NAMES:[Ljava/lang/String;

    return-object v0
.end method

.method public final parseAndValidateDate(Ljava/lang/String;)Ljava/lang/Double;
    .locals 9

    const-string v0, "dateString"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1270
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/DateParser;->parseISOString(Ljava/lang/String;)Lio/dcloud/uts/ISODateResult;

    move-result-object v1

    const/4 v2, 0x0

    if-nez v1, :cond_0

    .line 1271
    invoke-virtual {v0, p1}, Lio/dcloud/uts/DateParser;->parseOtherString(Ljava/lang/String;)Lio/dcloud/uts/ISODateResult;

    move-result-object v1

    if-nez v1, :cond_0

    return-object v2

    .line 1274
    :cond_0
    invoke-virtual {v1}, Lio/dcloud/uts/ISODateResult;->getFields()[I

    move-result-object p1

    .line 1275
    invoke-virtual {v1}, Lio/dcloud/uts/ISODateResult;->isLocal()Z

    move-result v0

    const/4 v1, 0x6

    .line 1278
    new-array v3, v1, [I

    fill-array-data v3, :array_0

    const/4 v4, 0x1

    const/4 v5, 0x1

    :goto_0
    const/4 v6, 0x0

    if-ge v5, v1, :cond_2

    .line 1283
    aget v7, p1, v5

    aget v8, v3, v5

    if-le v7, v8, :cond_1

    const/4 v4, 0x0

    goto :goto_1

    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    :cond_2
    :goto_1
    const/4 v3, 0x3

    .line 1290
    aget v3, p1, v3

    const/16 v5, 0x18

    if-ne v3, v5, :cond_4

    const/4 v3, 0x4

    aget v3, p1, v3

    if-nez v3, :cond_3

    const/4 v3, 0x5

    aget v3, p1, v3

    if-nez v3, :cond_3

    aget v1, p1, v1

    if-eqz v1, :cond_4

    :cond_3
    const/4 v4, 0x0

    :cond_4
    if-eqz v4, :cond_6

    const/4 v1, 0x7

    .line 1296
    new-array v2, v1, [D

    :goto_2
    if-ge v6, v1, :cond_5

    aget v3, p1, v6

    int-to-double v3, v3

    aput-wide v3, v2, v6

    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 1300
    :cond_5
    sget-object v1, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    invoke-virtual {v1, v2, v0}, Lio/dcloud/uts/DateHolder;->setDateFields([DZ)D

    move-result-wide v0

    const/16 v2, 0x8

    .line 1303
    aget p1, p1, v2

    int-to-double v2, p1

    const-wide v4, 0x40ed4c0000000000L    # 60000.0

    mul-double v2, v2, v4

    sub-double/2addr v0, v2

    .line 1304
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    return-object p1

    :cond_6
    return-object v2

    nop

    :array_0
    .array-data 4
        0x0
        0xb
        0x1f
        0x18
        0x3b
        0x3b
    .end array-data
.end method

.method public final parseISOString(Ljava/lang/String;)Lio/dcloud/uts/ISODateResult;
    .locals 13

    const-string v0, "isoString"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1622
    new-instance v0, Lio/dcloud/uts/ISODateResult;

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x3

    invoke-direct {v0, v1, v2, v3, v1}, Lio/dcloud/uts/ISODateResult;-><init>([IZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 1623
    invoke-virtual {v0}, Lio/dcloud/uts/ISODateResult;->getFields()[I

    move-result-object v4

    const/4 v5, 0x0

    :goto_0
    const/16 v6, 0x9

    const/4 v7, 0x2

    const/4 v8, 0x1

    if-ge v5, v6, :cond_1

    if-ne v5, v7, :cond_0

    goto :goto_1

    :cond_0
    const/4 v8, 0x0

    .line 1627
    :goto_1
    aput v8, v4, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 1633
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_14

    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x2b

    const/4 v9, 0x4

    const/4 v10, 0x6

    const/16 v11, 0x2d

    if-eq v5, v6, :cond_3

    if-eq v5, v11, :cond_3

    .line 1644
    invoke-direct {p0, p1, v2, v9, v9}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v5

    if-nez v5, :cond_2

    return-object v1

    .line 1645
    :cond_2
    invoke-virtual {v5}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1646
    invoke-virtual {v5}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    aput v5, v4, v2

    goto :goto_2

    .line 1636
    :cond_3
    invoke-direct {p0, p1, v8, v10, v10}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v6

    if-nez v6, :cond_4

    return-object v1

    .line 1637
    :cond_4
    invoke-virtual {v6}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/Number;

    invoke-virtual {v12}, Ljava/lang/Number;->intValue()I

    move-result v12

    .line 1638
    invoke-virtual {v6}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v6

    aput v6, v4, v2

    if-ne v5, v11, :cond_6

    if-nez v6, :cond_5

    return-object v1

    :cond_5
    neg-int v5, v6

    .line 1641
    aput v5, v4, v2

    :cond_6
    move v6, v12

    .line 1650
    :goto_2
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v6, v5, :cond_a

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-ne v5, v11, :cond_a

    add-int/lit8 v6, v6, 0x1

    .line 1652
    invoke-direct {p0, p1, v6, v7, v7}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v5

    if-nez v5, :cond_7

    return-object v1

    .line 1653
    :cond_7
    invoke-virtual {v5}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1654
    invoke-virtual {v5}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    sub-int/2addr v5, v8

    aput v5, v4, v8

    if-gez v5, :cond_8

    return-object v1

    .line 1657
    :cond_8
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v6, v5, :cond_a

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-ne v5, v11, :cond_a

    add-int/lit8 v6, v6, 0x1

    .line 1659
    invoke-direct {p0, p1, v6, v7, v7}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v5

    if-nez v5, :cond_9

    return-object v1

    .line 1660
    :cond_9
    invoke-virtual {v5}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1661
    invoke-virtual {v5}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    aput v5, v4, v7

    if-ge v5, v8, :cond_a

    return-object v1

    .line 1667
    :cond_a
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v6, v5, :cond_10

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v11, 0x54

    if-ne v5, v11, :cond_10

    add-int/lit8 v6, v6, 0x1

    .line 1669
    invoke-virtual {v0, v8}, Lio/dcloud/uts/ISODateResult;->setLocal(Z)V

    .line 1671
    invoke-direct {p0, p1, v6, v7, v7}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v5

    if-nez v5, :cond_b

    return-object v1

    .line 1672
    :cond_b
    invoke-virtual {v5}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1673
    invoke-virtual {v5}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    aput v5, v4, v3

    .line 1675
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v6, v5, :cond_f

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v11, 0x3a

    if-eq v5, v11, :cond_c

    goto/16 :goto_3

    :cond_c
    add-int/2addr v6, v8

    .line 1681
    invoke-direct {p0, p1, v6, v7, v7}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v3

    if-nez v3, :cond_d

    return-object v1

    .line 1682
    :cond_d
    invoke-virtual {v3}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1683
    invoke-virtual {v3}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    aput v3, v4, v9

    .line 1685
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v6, v3, :cond_10

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-ne v3, v11, :cond_10

    add-int/lit8 v6, v6, 0x1

    .line 1687
    invoke-direct {p0, p1, v6, v7, v7}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v3

    if-nez v3, :cond_e

    return-object v1

    .line 1688
    :cond_e
    invoke-virtual {v3}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1689
    invoke-virtual {v3}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    const/4 v5, 0x5

    aput v3, v4, v5

    .line 1692
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v6, v3, :cond_10

    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v5, 0x2e

    if-ne v3, v5, :cond_10

    add-int/lit8 v6, v6, 0x1

    .line 1694
    invoke-direct {p0, p1, v6}, Lio/dcloud/uts/DateParser;->parseMilliseconds(Ljava/lang/String;I)Lkotlin/Pair;

    move-result-object v3

    .line 1695
    invoke-virtual {v3}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    aput v5, v4, v10

    .line 1696
    invoke-virtual {v3}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v6

    goto :goto_4

    :cond_f
    :goto_3
    const/16 p1, 0x64

    .line 1676
    aput p1, v4, v3

    return-object v0

    .line 1702
    :cond_10
    :goto_4
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v6, v3, :cond_13

    .line 1703
    invoke-virtual {v0, v2}, Lio/dcloud/uts/ISODateResult;->setLocal(Z)V

    .line 1705
    invoke-virtual {p1, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x5a

    if-ne v2, v3, :cond_11

    add-int/lit8 v6, v6, 0x1

    goto :goto_5

    .line 1708
    :cond_11
    invoke-direct {p0, p1, v6}, Lio/dcloud/uts/DateParser;->parseTzOffset(Ljava/lang/String;I)Lkotlin/Pair;

    move-result-object v2

    if-nez v2, :cond_12

    return-object v1

    .line 1709
    :cond_12
    invoke-virtual {v2}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    const/16 v5, 0x8

    aput v3, v4, v5

    .line 1710
    invoke-virtual {v2}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Number;

    invoke-virtual {v2}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 1715
    :cond_13
    :goto_5
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result p1

    if-ne v6, p1, :cond_14

    return-object v0

    :cond_14
    return-object v1
.end method

.method public final parseOtherString(Ljava/lang/String;)Lio/dcloud/uts/ISODateResult;
    .locals 24

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    const-string v2, "dateString"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1317
    new-instance v2, Lio/dcloud/uts/ISODateResult;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x3

    invoke-direct {v2, v3, v4, v5, v3}, Lio/dcloud/uts/ISODateResult;-><init>([IZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 1318
    invoke-virtual {v2}, Lio/dcloud/uts/ISODateResult;->getFields()[I

    move-result-object v6

    .line 1324
    new-array v7, v5, [I

    const/16 v8, 0x7d1

    .line 1328
    aput v8, v6, v4

    const/4 v8, 0x1

    .line 1329
    aput v4, v6, v8

    const/4 v9, 0x2

    .line 1330
    aput v8, v6, v9

    const/4 v10, 0x3

    :goto_0
    const/16 v11, 0x9

    if-ge v10, v11, :cond_0

    .line 1333
    aput v4, v6, v10

    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 1335
    :cond_0
    invoke-virtual {v2, v8}, Lio/dcloud/uts/ISODateResult;->setLocal(Z)V

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    .line 1338
    :goto_1
    invoke-direct {v0, v1, v10}, Lio/dcloud/uts/DateParser;->skipSpaces(Ljava/lang/String;I)Z

    move-result v16

    move-object/from16 v17, v3

    const/16 v18, 0x76c

    const/16 v19, 0x0

    if-eqz v16, :cond_21

    .line 1340
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v10, v3, :cond_21

    .line 1342
    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x2b

    const/16 v21, 0x8

    const/16 v22, 0x3

    const v5, 0x7fffffff

    const/16 v9, 0x2d

    if-eq v3, v4, :cond_1b

    if-ne v3, v9, :cond_1

    goto/16 :goto_a

    :cond_1
    const/16 v4, 0x30

    if-gt v4, v3, :cond_c

    const/16 v4, 0x3a

    if-ge v3, v4, :cond_c

    .line 1370
    invoke-direct {v0, v1, v10, v8, v5}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v3

    if-eqz v3, :cond_20

    .line 1375
    invoke-virtual {v3}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    invoke-virtual {v3}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    .line 1379
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v3, v9, :cond_5

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v4, :cond_5

    add-int/lit8 v3, v3, 0x1

    .line 1381
    aput v5, v6, v22

    .line 1382
    sget-object v5, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    const/4 v9, 0x2

    invoke-direct {v5, v1, v3, v8, v9}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 1387
    invoke-virtual {v3}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    invoke-virtual {v3}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    const/4 v10, 0x4

    .line 1388
    aput v9, v6, v10

    .line 1391
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v3, v9, :cond_3

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v9

    if-ne v9, v4, :cond_3

    add-int/lit8 v3, v3, 0x1

    const/4 v9, 0x2

    .line 1393
    invoke-direct {v5, v1, v3, v8, v9}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 1398
    invoke-virtual {v3}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v4

    invoke-virtual {v3}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    const/4 v9, 0x5

    .line 1399
    aput v4, v6, v9

    .line 1403
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v3, v4, :cond_3

    invoke-virtual {v1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v9, 0x2e

    if-ne v4, v9, :cond_3

    add-int/lit8 v3, v3, 0x1

    .line 1406
    invoke-direct {v5, v1, v3}, Lio/dcloud/uts/DateParser;->parseMilliseconds(Ljava/lang/String;I)Lkotlin/Pair;

    move-result-object v3

    .line 1407
    invoke-virtual {v3}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v4

    const/4 v5, 0x6

    aput v4, v6, v5

    .line 1408
    invoke-virtual {v3}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    goto :goto_2

    :cond_2
    return-object v17

    :cond_3
    :goto_2
    move v10, v3

    const/4 v14, 0x1

    goto/16 :goto_d

    :cond_4
    return-object v17

    :cond_5
    sub-int v4, v3, v10

    const/4 v9, 0x2

    if-le v4, v9, :cond_6

    .line 1419
    aput v5, v6, v19

    :goto_3
    move v10, v3

    goto/16 :goto_c

    :cond_6
    if-lt v5, v8, :cond_9

    const/16 v4, 0x1f

    if-le v5, v4, :cond_7

    goto :goto_4

    :cond_7
    const/4 v4, 0x3

    if-lt v12, v4, :cond_8

    return-object v17

    :cond_8
    add-int/lit8 v4, v12, 0x1

    .line 1432
    aput v5, v7, v12

    move v10, v3

    move v12, v4

    goto/16 :goto_d

    :cond_9
    :goto_4
    const/16 v4, 0x64

    if-ge v5, v4, :cond_a

    goto :goto_5

    :cond_a
    const/16 v18, 0x0

    :goto_5
    add-int v18, v5, v18

    const/16 v4, 0x32

    if-ge v5, v4, :cond_b

    const/16 v20, 0x64

    goto :goto_6

    :cond_b
    const/16 v20, 0x0

    :goto_6
    add-int v18, v18, v20

    .line 1426
    aput v18, v6, v19

    goto :goto_3

    .line 1441
    :cond_c
    invoke-direct {v0, v1, v10}, Lio/dcloud/uts/DateParser;->parseMonth(Ljava/lang/String;I)Lkotlin/Pair;

    move-result-object v4

    if-eqz v4, :cond_d

    invoke-virtual {v4}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I

    move-result v3

    invoke-virtual {v4}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v4

    .line 1442
    aput v3, v6, v8

    .line 1445
    sget-object v3, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    const-string v5, "0123456789 -/("

    invoke-direct {v3, v1, v4, v5}, Lio/dcloud/uts/DateParser;->skipUntil(Ljava/lang/String;ILjava/lang/String;)I

    move-result v10

    const/4 v13, 0x1

    const/4 v15, 0x1

    goto/16 :goto_d

    :cond_d
    const/16 v4, 0xc

    if-eqz v14, :cond_f

    .line 1448
    const-string v5, "PM"

    invoke-direct {v0, v1, v10, v5}, Lio/dcloud/uts/DateParser;->matchString(Ljava/lang/String;ILjava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_f

    const/16 v22, 0x3

    .line 1449
    aget v3, v6, v22

    if-eq v3, v4, :cond_e

    add-int/lit8 v3, v3, 0xc

    aput v3, v6, v22

    :cond_e
    :goto_7
    add-int/lit8 v10, v10, 0x2

    goto/16 :goto_d

    :cond_f
    if-eqz v14, :cond_11

    .line 1453
    const-string v5, "AM"

    invoke-direct {v0, v1, v10, v5}, Lio/dcloud/uts/DateParser;->matchString(Ljava/lang/String;ILjava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_11

    const/16 v22, 0x3

    .line 1454
    aget v3, v6, v22

    if-le v3, v4, :cond_10

    return-object v17

    :cond_10
    if-ne v3, v4, :cond_e

    .line 1455
    aput v19, v6, v22

    goto :goto_7

    .line 1459
    :cond_11
    invoke-direct {v0, v1, v10}, Lio/dcloud/uts/DateParser;->parseTimeZoneAbbr(Ljava/lang/String;I)Lkotlin/Pair;

    move-result-object v4

    if-eqz v4, :cond_12

    .line 1462
    invoke-virtual {v4}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    invoke-virtual {v4}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v10

    .line 1463
    aput v5, v6, v21

    const/4 v4, 0x0

    .line 1464
    invoke-virtual {v2, v4}, Lio/dcloud/uts/ISODateResult;->setLocal(Z)V

    .line 1462
    sget-object v4, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    goto :goto_8

    :cond_12
    move-object/from16 v4, v17

    :goto_8
    if-nez v4, :cond_20

    const/16 v4, 0x29

    const/16 v5, 0x28

    if-ne v3, v5, :cond_17

    add-int/lit8 v10, v10, 0x1

    const/4 v3, 0x0

    .line 1473
    :cond_13
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v10, v9, :cond_16

    add-int/lit8 v9, v10, 0x1

    .line 1474
    invoke-virtual {v1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    if-ne v10, v5, :cond_14

    add-int/lit8 v3, v3, 0x1

    :cond_14
    if-ne v10, v4, :cond_15

    add-int/lit8 v3, v3, -0x1

    :cond_15
    move v10, v9

    if-gtz v3, :cond_13

    :cond_16
    if-lez v3, :cond_20

    return-object v17

    :cond_17
    if-ne v3, v4, :cond_18

    return-object v17

    :cond_18
    if-nez v11, :cond_1a

    if-nez v13, :cond_1a

    if-nez v14, :cond_1a

    if-lez v12, :cond_19

    goto :goto_9

    :cond_19
    add-int/lit8 v10, v10, 0x1

    .line 1491
    const-string v3, " -/("

    invoke-direct {v0, v1, v10, v3}, Lio/dcloud/uts/DateParser;->skipUntil(Ljava/lang/String;ILjava/lang/String;)I

    move-result v10

    goto :goto_d

    :cond_1a
    :goto_9
    return-object v17

    :cond_1b
    :goto_a
    if-eqz v14, :cond_1d

    .line 1346
    invoke-direct {v0, v1, v10}, Lio/dcloud/uts/DateParser;->parseTzOffset(Ljava/lang/String;I)Lkotlin/Pair;

    move-result-object v4

    if-eqz v4, :cond_1c

    .line 1347
    invoke-virtual {v4}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Number;

    invoke-virtual {v10}, Ljava/lang/Number;->intValue()I

    move-result v10

    aput v10, v6, v21

    .line 1348
    invoke-virtual {v4}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v10

    const/4 v4, 0x0

    .line 1349
    invoke-virtual {v2, v4}, Lio/dcloud/uts/ISODateResult;->setLocal(Z)V

    const/4 v4, 0x1

    goto :goto_b

    :cond_1c
    const/4 v4, 0x0

    :goto_b
    if-nez v4, :cond_20

    :cond_1d
    add-int/2addr v10, v8

    .line 1355
    invoke-direct {v0, v1, v10, v8, v5}, Lio/dcloud/uts/DateParser;->getDigits(Ljava/lang/String;III)Lkotlin/Pair;

    move-result-object v4

    if-eqz v4, :cond_20

    .line 1356
    invoke-virtual {v4}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I

    move-result v5

    .line 1357
    invoke-virtual {v4}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v10

    if-ne v3, v9, :cond_1f

    if-nez v5, :cond_1e

    return-object v17

    :cond_1e
    neg-int v5, v5

    :cond_1f
    const/16 v19, 0x0

    .line 1362
    aput v5, v6, v19

    :goto_c
    const/4 v11, 0x1

    .line 1497
    :cond_20
    :goto_d
    invoke-direct {v0, v1, v10}, Lio/dcloud/uts/DateParser;->skipSeparators(Ljava/lang/String;I)I

    move-result v10

    move-object/from16 v3, v17

    const/4 v4, 0x0

    const/4 v5, 0x3

    const/4 v9, 0x2

    goto/16 :goto_1

    :cond_21
    add-int v1, v12, v11

    add-int/2addr v1, v13

    const/4 v4, 0x3

    if-le v1, v4, :cond_22

    return-object v17

    :cond_22
    if-eqz v12, :cond_30

    if-eq v12, v8, :cond_2e

    const/4 v9, 0x2

    if-eq v12, v9, :cond_27

    if-eq v12, v4, :cond_23

    goto/16 :goto_12

    .line 1529
    :cond_23
    aget v1, v7, v9

    const/16 v4, 0x64

    if-ge v1, v4, :cond_24

    goto :goto_e

    :cond_24
    const/16 v18, 0x0

    :goto_e
    add-int v18, v1, v18

    const/16 v4, 0x32

    if-ge v1, v4, :cond_25

    const/16 v20, 0x64

    goto :goto_f

    :cond_25
    const/16 v20, 0x0

    :goto_f
    add-int v18, v18, v20

    const/16 v19, 0x0

    aput v18, v6, v19

    .line 1530
    aget v1, v7, v19

    aput v1, v6, v8

    if-nez v15, :cond_26

    add-int/lit8 v1, v1, -0x1

    .line 1531
    aput v1, v6, v8

    .line 1532
    :cond_26
    aget v1, v7, v8

    const/16 v23, 0x2

    aput v1, v6, v23

    goto :goto_12

    :cond_27
    const/16 v19, 0x0

    const/16 v23, 0x2

    if-eqz v11, :cond_29

    .line 1515
    aget v1, v7, v19

    aput v1, v6, v8

    if-nez v15, :cond_28

    add-int/lit8 v1, v1, -0x1

    .line 1516
    aput v1, v6, v8

    .line 1517
    :cond_28
    aget v1, v7, v8

    aput v1, v6, v23

    goto :goto_12

    :cond_29
    if-eqz v13, :cond_2c

    .line 1519
    aget v1, v7, v8

    const/16 v4, 0x64

    if-ge v1, v4, :cond_2a

    goto :goto_10

    :cond_2a
    const/16 v18, 0x0

    :goto_10
    add-int v18, v1, v18

    const/16 v3, 0x32

    if-ge v1, v3, :cond_2b

    goto :goto_11

    :cond_2b
    const/4 v4, 0x0

    :goto_11
    add-int v18, v18, v4

    const/16 v19, 0x0

    aput v18, v6, v19

    .line 1520
    aget v1, v7, v19

    const/16 v23, 0x2

    aput v1, v6, v23

    goto :goto_12

    :cond_2c
    const/16 v19, 0x0

    const/16 v23, 0x2

    .line 1522
    aget v1, v7, v19

    aput v1, v6, v8

    if-nez v15, :cond_2d

    add-int/lit8 v1, v1, -0x1

    .line 1523
    aput v1, v6, v8

    .line 1524
    :cond_2d
    aget v1, v7, v8

    aput v1, v6, v23

    goto :goto_12

    :cond_2e
    const/16 v19, 0x0

    const/16 v23, 0x2

    if-eqz v13, :cond_2f

    .line 1507
    aget v1, v7, v19

    aput v1, v6, v23

    goto :goto_12

    .line 1509
    :cond_2f
    aget v1, v7, v19

    aput v1, v6, v8

    if-nez v15, :cond_31

    add-int/lit8 v1, v1, -0x1

    .line 1510
    aput v1, v6, v8

    goto :goto_12

    :cond_30
    if-nez v11, :cond_31

    return-object v17

    .line 1536
    :cond_31
    :goto_12
    aget v1, v6, v8

    if-ltz v1, :cond_33

    const/16 v3, 0xb

    if-le v1, v3, :cond_32

    goto :goto_13

    :cond_32
    return-object v2

    :cond_33
    :goto_13
    return-object v17
.end method

.method public final timeClip(D)D
    .locals 3

    const-wide v0, -0x3cc14df73d240000L    # -8.64E15

    cmpl-double v2, p1, v0

    if-ltz v2, :cond_0

    const-wide v0, 0x433eb208c2dc0000L    # 8.64E15

    cmpg-double v2, p1, v0

    if-gtz v2, :cond_0

    .line 1257
    invoke-static {p1, p2}, Lkotlin/math/MathKt;->truncate(D)D

    move-result-wide p1

    const-wide/16 v0, 0x0

    add-double/2addr p1, v0

    return-wide p1

    :cond_0
    const-wide/high16 p1, 0x7ff8000000000000L    # Double.NaN

    return-wide p1
.end method
