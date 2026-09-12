.class public final Lio/dcloud/uts/DateHolder;
.super Ljava/lang/Object;
.source "Date2.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tJ \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J/\u0010 \u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0012\u0010!\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\"\"\u00020\u0005\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"
    }
    d2 = {
        "Lio/dcloud/uts/DateHolder;",
        "",
        "<init>",
        "()V",
        "getDateField",
        "",
        "dateDouble",
        "",
        "magic",
        "",
        "getDateFields",
        "",
        "isLocal",
        "",
        "force",
        "mathMod",
        "a",
        "b",
        "floorDiv",
        "",
        "yearFromDays",
        "days",
        "setDateFields",
        "fields",
        "monthDays",
        "",
        "isLeapYear",
        "y",
        "daysInYear",
        "daysFromYear",
        "getTimezoneOffset",
        "timestamp",
        "setDateField",
        "args",
        "",
        "(DI[Ljava/lang/Number;)D",
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
.field public static final INSTANCE:Lio/dcloud/uts/DateHolder;

.field private static final monthDays:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lio/dcloud/uts/DateHolder;

    invoke-direct {v0}, Lio/dcloud/uts/DateHolder;-><init>()V

    sput-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    const/16 v0, 0xc

    .line 997
    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lio/dcloud/uts/DateHolder;->monthDays:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x1f
        0x1c
        0x1f
        0x1e
        0x1f
        0x1e
        0x1f
        0x1f
        0x1e
        0x1f
        0x1e
        0x1f
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 778
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final daysFromYear(J)J
    .locals 6

    const/16 v0, 0x16d

    int-to-long v0, v0

    const/16 v2, 0x7b2

    int-to-long v2, v2

    sub-long v2, p1, v2

    mul-long v0, v0, v2

    const/16 v2, 0x7b1

    int-to-long v2, v2

    sub-long v2, p1, v2

    const-wide/16 v4, 0x4

    .line 1017
    invoke-direct {p0, v2, v3, v4, v5}, Lio/dcloud/uts/DateHolder;->floorDiv(JJ)J

    move-result-wide v2

    add-long/2addr v0, v2

    const/16 v2, 0x76d

    int-to-long v2, v2

    sub-long v2, p1, v2

    const-wide/16 v4, 0x64

    .line 1018
    invoke-direct {p0, v2, v3, v4, v5}, Lio/dcloud/uts/DateHolder;->floorDiv(JJ)J

    move-result-wide v2

    sub-long/2addr v0, v2

    const/16 v2, 0x641

    int-to-long v2, v2

    sub-long/2addr p1, v2

    const-wide/16 v2, 0x190

    invoke-direct {p0, p1, p2, v2, v3}, Lio/dcloud/uts/DateHolder;->floorDiv(JJ)J

    move-result-wide p1

    add-long/2addr v0, p1

    return-wide v0
.end method

.method private final daysInYear(I)I
    .locals 0

    .line 1006
    invoke-direct {p0, p1}, Lio/dcloud/uts/DateHolder;->isLeapYear(I)Z

    move-result p1

    if-eqz p1, :cond_0

    const/16 p1, 0x16e

    return p1

    :cond_0
    const/16 p1, 0x16d

    return p1
.end method

.method private final floorDiv(JJ)J
    .locals 5

    .line 904
    rem-long v0, p1, p3

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-gez v4, :cond_0

    move-wide v2, p3

    :cond_0
    add-long/2addr v0, v2

    sub-long/2addr p1, v0

    .line 905
    div-long/2addr p1, p3

    return-wide p1
.end method

.method private final getTimezoneOffset(J)I
    .locals 2

    .line 1024
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p1, p2}, Ljava/util/Date;-><init>(J)V

    .line 1025
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 1026
    invoke-virtual {v1, v0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 1029
    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeZone()Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/util/TimeZone;->getOffset(J)I

    move-result p1

    neg-int p1, p1

    const p2, 0xea60

    .line 1032
    div-int/2addr p1, p2

    return p1
.end method

.method private final isLeapYear(I)Z
    .locals 1

    .line 1001
    rem-int/lit8 v0, p1, 0x4

    if-nez v0, :cond_1

    rem-int/lit8 v0, p1, 0x64

    if-nez v0, :cond_0

    rem-int/lit16 p1, p1, 0x190

    if-nez p1, :cond_1

    :cond_0
    const/4 p1, 0x1

    return p1

    :cond_1
    const/4 p1, 0x0

    return p1
.end method

.method private final mathMod(DD)D
    .locals 0

    rem-double/2addr p1, p3

    add-double/2addr p1, p3

    rem-double/2addr p1, p3

    return-wide p1
.end method

.method private final yearFromDays(J)I
    .locals 5

    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    if-gez v2, :cond_1

    const/16 v0, 0x7b1

    :goto_0
    int-to-long v1, v0

    .line 916
    invoke-direct {p0, v1, v2}, Lio/dcloud/uts/DateHolder;->daysFromYear(J)J

    move-result-wide v1

    cmp-long v3, p1, v1

    if-gez v3, :cond_0

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return v0

    :cond_1
    const/16 v0, 0x7b2

    :goto_1
    add-int/lit8 v1, v0, 0x1

    int-to-long v2, v1

    .line 921
    invoke-direct {p0, v2, v3}, Lio/dcloud/uts/DateHolder;->daysFromYear(J)J

    move-result-wide v2

    cmp-long v4, p1, v2

    if-ltz v4, :cond_2

    move v0, v1

    goto :goto_1

    :cond_2
    return v0
.end method


# virtual methods
.method public final getDateField(DI)Ljava/lang/Number;
    .locals 4

    and-int/lit8 v0, p3, 0xf

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    shr-int/lit8 v3, p3, 0x4

    and-int/lit8 v3, v3, 0xf

    and-int/lit16 p3, p3, 0x100

    if-eqz p3, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    .line 794
    :goto_1
    invoke-virtual {p0, p1, p2, v0, v2}, Lio/dcloud/uts/DateHolder;->getDateFields(DZZ)[D

    move-result-object p1

    if-nez p1, :cond_2

    const-wide/high16 p1, 0x7ff8000000000000L    # Double.NaN

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1

    :cond_2
    if-eqz v1, :cond_3

    if-nez v3, :cond_3

    .line 798
    aget-wide p2, p1, v2

    const/16 p1, 0x76c

    int-to-double v0, p1

    sub-double/2addr p2, v0

    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1

    .line 802
    :cond_3
    aget-wide p2, p1, v3

    double-to-long p1, p2

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final getDateFields(DZZ)[D
    .locals 23

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    const/16 v3, 0x9

    .line 820
    new-array v4, v3, [D

    .line 823
    invoke-static {v1, v2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v5

    const-wide/16 v6, 0x0

    if-eqz v5, :cond_2

    if-nez p4, :cond_0

    const/4 v1, 0x0

    return-object v1

    :cond_0
    const/4 v8, 0x0

    :goto_0
    if-ge v8, v3, :cond_1

    .line 826
    aput-wide v6, v4, v8

    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    :cond_1
    return-object v4

    :cond_2
    if-eqz p3, :cond_3

    double-to-long v5, v1

    .line 834
    invoke-direct {v0, v5, v6}, Lio/dcloud/uts/DateHolder;->getTimezoneOffset(J)I

    move-result v3

    int-to-double v5, v3

    neg-double v6, v5

    const-wide v9, 0x40ed4c0000000000L    # 60000.0

    mul-double v9, v9, v6

    add-double/2addr v1, v9

    :cond_3
    const-wide v9, 0x4194997000000000L    # 8.64E7

    .line 839
    invoke-direct {v0, v1, v2, v9, v10}, Lio/dcloud/uts/DateHolder;->mathMod(DD)D

    move-result-wide v11

    sub-double/2addr v1, v11

    div-double/2addr v1, v9

    double-to-long v1, v1

    const-wide v9, 0x408f400000000000L    # 1000.0

    rem-double v13, v11, v9

    sub-double/2addr v11, v13

    div-double/2addr v11, v9

    const-wide/high16 v9, 0x404e000000000000L    # 60.0

    rem-double v15, v11, v9

    sub-double/2addr v11, v15

    div-double/2addr v11, v9

    rem-double v17, v11, v9

    sub-double v11, v11, v17

    div-double/2addr v11, v9

    long-to-double v9, v1

    const-wide/high16 v19, 0x4010000000000000L    # 4.0

    add-double v9, v9, v19

    move-object v5, v4

    const-wide/high16 v3, 0x401c000000000000L    # 7.0

    .line 851
    invoke-direct {v0, v9, v10, v3, v4}, Lio/dcloud/uts/DateHolder;->mathMod(DD)D

    move-result-wide v3

    .line 854
    invoke-direct {v0, v1, v2}, Lio/dcloud/uts/DateHolder;->yearFromDays(J)I

    move-result v9

    move-wide/from16 v19, v1

    int-to-long v1, v9

    .line 857
    invoke-direct {v0, v1, v2}, Lio/dcloud/uts/DateHolder;->daysFromYear(J)J

    move-result-wide v1

    sub-long v1, v19, v1

    const/4 v10, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    :goto_1
    const/16 v8, 0xb

    move-wide/from16 p1, v3

    const/4 v3, 0x1

    if-ge v10, v8, :cond_6

    .line 863
    sget-object v4, Lio/dcloud/uts/DateHolder;->monthDays:[I

    aget v4, v4, v10

    move-object/from16 p3, v5

    int-to-double v4, v4

    if-ne v10, v3, :cond_4

    .line 865
    invoke-direct {v0, v9}, Lio/dcloud/uts/DateHolder;->daysInYear(I)I

    move-result v8

    add-int/lit16 v8, v8, -0x16d

    move-wide/from16 v21, v4

    const/16 p4, 0x1

    int-to-double v3, v8

    add-double v4, v21, v3

    goto :goto_2

    :cond_4
    move-wide/from16 v21, v4

    const/16 p4, 0x1

    :goto_2
    move-wide/from16 v21, v6

    long-to-double v6, v1

    cmpg-double v3, v6, v4

    if-gez v3, :cond_5

    goto :goto_3

    :cond_5
    double-to-long v3, v4

    sub-long/2addr v1, v3

    add-int/lit8 v19, v10, 0x1

    move-wide/from16 v3, p1

    move-object/from16 v5, p3

    move/from16 v10, v19

    move-wide/from16 v6, v21

    goto :goto_1

    :cond_6
    move-object/from16 p3, v5

    move-wide/from16 v21, v6

    const/16 p4, 0x1

    move/from16 v10, v19

    :goto_3
    int-to-double v3, v9

    .line 877
    aput-wide v3, p3, v20

    int-to-double v3, v10

    .line 878
    aput-wide v3, p3, p4

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    long-to-double v1, v1

    const/4 v3, 0x2

    .line 879
    aput-wide v1, p3, v3

    const/4 v1, 0x3

    .line 880
    aput-wide v11, p3, v1

    const/4 v1, 0x4

    .line 881
    aput-wide v17, p3, v1

    const/4 v1, 0x5

    .line 882
    aput-wide v15, p3, v1

    const/4 v1, 0x6

    .line 883
    aput-wide v13, p3, v1

    const/4 v1, 0x7

    .line 884
    aput-wide p1, p3, v1

    const/16 v1, 0x8

    .line 885
    aput-wide v21, p3, v1

    return-object p3
.end method

.method public final varargs setDateField(DI[Ljava/lang/Number;)D
    .locals 20

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    move-object/from16 v3, p4

    const-string v4, "args"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    shr-int/lit8 v4, p3, 0x8

    and-int/lit8 v4, v4, 0xf

    shr-int/lit8 v5, p3, 0x4

    and-int/lit8 v5, v5, 0xf

    and-int/lit8 v6, p3, 0xf

    const/4 v7, 0x1

    const/4 v8, 0x0

    if-eqz v6, :cond_0

    const/4 v6, 0x1

    goto :goto_0

    :cond_0
    const/4 v6, 0x0

    :goto_0
    if-nez v4, :cond_1

    const/4 v9, 0x1

    goto :goto_1

    :cond_1
    const/4 v9, 0x0

    .line 1050
    :goto_1
    invoke-virtual {v0, v1, v2, v6, v9}, Lio/dcloud/uts/DateHolder;->getDateFields(DZZ)[D

    move-result-object v9

    const-wide/high16 v10, 0x7ff8000000000000L    # Double.NaN

    if-nez v9, :cond_2

    return-wide v10

    .line 1055
    :cond_2
    array-length v12, v3

    sub-int/2addr v5, v4

    invoke-static {v12, v5}, Ljava/lang/Math;->min(II)I

    move-result v5

    const/4 v12, 0x0

    :goto_2
    if-ge v12, v5, :cond_4

    .line 1058
    aget-object v13, v3, v12

    invoke-virtual {v13}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v13

    .line 1059
    invoke-static {v13, v14}, Ljava/lang/Math;->abs(D)D

    move-result-wide v15

    const-wide v17, 0x7fefffffffffffffL    # Double.MAX_VALUE

    cmpg-double v19, v15, v17

    if-gtz v19, :cond_3

    add-int v15, v4, v12

    .line 1063
    invoke-static {v13, v14}, Ljava/lang/Math;->floor(D)D

    move-result-wide v13

    aput-wide v13, v9, v15

    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    :cond_3
    return-wide v10

    .line 1072
    :cond_4
    array-length v3, v3

    if-nez v3, :cond_5

    goto :goto_3

    :cond_5
    const/4 v7, 0x0

    :goto_3
    if-nez v7, :cond_6

    .line 1073
    invoke-virtual {v0, v9, v6}, Lio/dcloud/uts/DateHolder;->setDateFields([DZ)D

    move-result-wide v1

    :cond_6
    return-wide v1
.end method

.method public final setDateFields([DZ)D
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    const-string v2, "fields"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v2, 0x0

    .line 938
    aget-wide v3, v1, v2

    const/4 v5, 0x1

    .line 939
    aget-wide v6, v1, v5

    const/4 v8, 0x2

    .line 940
    aget-wide v8, v1, v8

    const/16 v10, 0xc

    int-to-double v10, v10

    div-double v12, v6, v10

    .line 941
    invoke-static {v12, v13}, Ljava/lang/Math;->floor(D)D

    move-result-wide v12

    add-double/2addr v3, v12

    rem-double/2addr v6, v10

    const-wide/16 v12, 0x0

    cmpg-double v14, v6, v12

    if-gez v14, :cond_0

    add-double/2addr v6, v10

    :cond_0
    const-wide v10, -0x3eef68cc00000000L    # -271821.0

    const-wide/high16 v12, 0x7ff8000000000000L    # Double.NaN

    cmpg-double v14, v3, v10

    if-ltz v14, :cond_7

    const-wide v10, 0x4110d4c000000000L    # 275760.0

    cmpl-double v14, v3, v10

    if-lez v14, :cond_1

    goto/16 :goto_2

    :cond_1
    double-to-int v3, v3

    double-to-int v4, v6

    int-to-long v6, v3

    .line 952
    invoke-direct {v0, v6, v7}, Lio/dcloud/uts/DateHolder;->daysFromYear(J)J

    move-result-wide v6

    :goto_0
    if-ge v2, v4, :cond_3

    .line 955
    sget-object v10, Lio/dcloud/uts/DateHolder;->monthDays:[I

    aget v10, v10, v2

    int-to-long v10, v10

    add-long/2addr v6, v10

    if-ne v2, v5, :cond_2

    .line 958
    invoke-direct {v0, v3}, Lio/dcloud/uts/DateHolder;->daysInYear(I)I

    move-result v10

    add-int/lit16 v10, v10, -0x16d

    int-to-long v10, v10

    add-long/2addr v6, v10

    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_3
    long-to-double v2, v6

    add-double/2addr v2, v8

    int-to-double v4, v5

    sub-double/2addr v2, v4

    const/4 v4, 0x3

    .line 964
    aget-wide v4, v1, v4

    const/4 v6, 0x4

    .line 965
    aget-wide v6, v1, v6

    const/4 v8, 0x5

    .line 966
    aget-wide v8, v1, v8

    const/4 v10, 0x6

    .line 967
    aget-wide v10, v1, v10

    const v1, 0x36ee80

    int-to-double v14, v1

    mul-double v4, v4, v14

    const v1, 0xea60

    int-to-double v14, v1

    mul-double v6, v6, v14

    add-double/2addr v4, v6

    const/16 v1, 0x3e8

    int-to-double v6, v1

    mul-double v8, v8, v6

    add-double/2addr v4, v8

    add-double/2addr v4, v10

    const v1, 0x5265c00

    int-to-double v6, v1

    mul-double v2, v2, v6

    add-double/2addr v2, v4

    .line 979
    invoke-static {v2, v3}, Ljava/lang/Math;->abs(D)D

    move-result-wide v4

    const-wide v6, 0x7fefffffffffffffL    # Double.MAX_VALUE

    cmpg-double v1, v4, v6

    if-gtz v1, :cond_7

    if-eqz p2, :cond_6

    const-wide/high16 v4, -0x3c20000000000000L    # -9.223372036854776E18

    cmpg-double v1, v2, v4

    if-gez v1, :cond_4

    const-wide/high16 v4, -0x8000000000000000L

    goto :goto_1

    :cond_4
    const-wide/high16 v4, 0x43e0000000000000L    # 9.223372036854776E18

    cmpl-double v1, v2, v4

    if-ltz v1, :cond_5

    const-wide v4, 0x7fffffffffffffffL

    goto :goto_1

    :cond_5
    double-to-long v4, v2

    .line 988
    :goto_1
    invoke-direct {v0, v4, v5}, Lio/dcloud/uts/DateHolder;->getTimezoneOffset(J)I

    move-result v1

    int-to-double v4, v1

    const-wide v6, 0x40ed4c0000000000L    # 60000.0

    mul-double v4, v4, v6

    add-double/2addr v2, v4

    .line 992
    :cond_6
    sget-object v1, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    invoke-virtual {v1, v2, v3}, Lio/dcloud/uts/DateParser;->timeClip(D)D

    move-result-wide v1

    return-wide v1

    :cond_7
    :goto_2
    return-wide v12
.end method
