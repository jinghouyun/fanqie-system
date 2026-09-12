.class public final Lio/dcloud/uts/Date;
.super Ljava/lang/Object;
.source "Date2.kt"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/uts/Date$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lio/dcloud/uts/Date;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0008\u0003\n\u0002\u0010\u0004\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008+\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0007\u0018\u0000 O2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001OB\t\u0008\u0016\u00a2\u0006\u0004\u0008\u0002\u0010\u0003B\u0011\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\u0008\u0002\u0010\u0006B\u0011\u0008\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0000\u00a2\u0006\u0004\u0008\u0002\u0010\u0008B\u0011\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\t\u00a2\u0006\u0004\u0008\u0002\u0010\nBU\u0008\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0004\u0008\u0002\u0010\u0014J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010\'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u00100\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J&\u00101\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\n\u0008\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\u000e\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u001a\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\n\u0008\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\u000e\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u000e\u00106\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u00108\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u001a\u00108\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u001a\u00109\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J&\u0010:\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J&\u0010;\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010<\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J2\u0010<\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J2\u0010=\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010>\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005J\u001a\u0010?\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\n\u0008\u0002\u00103\u001a\u0004\u0018\u00010\u0005J&\u0010@\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\n\u0008\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\u0011\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0000H\u0096\u0002J\u0008\u0010D\u001a\u00020\tH\u0016J\u0006\u0010E\u001a\u00020\tJ\u0006\u0010F\u001a\u00020\tJ\u0006\u0010G\u001a\u00020\tJ\u0008\u0010H\u001a\u0004\u0018\u00010IJ\u0006\u0010J\u001a\u00020\tJ\u0006\u0010K\u001a\u00020\tJ\u0006\u0010L\u001a\u00020\tJ\u0006\u0010M\u001a\u00020\tJ\u0006\u0010N\u001a\u00020\tR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a\u00a8\u0006P"
    }
    d2 = {
        "Lio/dcloud/uts/Date;",
        "",
        "<init>",
        "()V",
        "value",
        "",
        "(Ljava/lang/Number;)V",
        "souceDate",
        "(Lio/dcloud/uts/Date;)V",
        "",
        "(Ljava/lang/String;)V",
        "year",
        "monthIndex",
        "day",
        "hours",
        "minutes",
        "seconds",
        "milliseconds",
        "isUTC",
        "",
        "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Z)V",
        "dateDouble",
        "",
        "getDateDouble",
        "()D",
        "setDateDouble",
        "(D)V",
        "getTime",
        "valueOf",
        "getDate",
        "getUTCDate",
        "getYear",
        "getFullYear",
        "getUTCFullYear",
        "getMonth",
        "getUTCMonth",
        "getHours",
        "getUTCHours",
        "getMinutes",
        "getUTCMinutes",
        "getSeconds",
        "getUTCSeconds",
        "getMilliseconds",
        "getUTCMilliseconds",
        "getDay",
        "getUTCDay",
        "getTimezoneOffset",
        "setTime",
        "setYear",
        "setFullYear",
        "month",
        "date",
        "setMonth",
        "setDate",
        "setMilliseconds",
        "setUTCMilliseconds",
        "setSeconds",
        "setUTCSeconds",
        "setMinutes",
        "setUTCMinutes",
        "setHours",
        "setUTCHours",
        "setUTCDate",
        "setUTCMonth",
        "setUTCFullYear",
        "compareTo",
        "",
        "other",
        "toString",
        "toUTCString",
        "toGMTString",
        "toISOString",
        "toJSON",
        "",
        "toDateString",
        "toTimeString",
        "toLocaleString",
        "toLocaleDateString",
        "toLocaleTimeString",
        "Companion",
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
.field public static final Companion:Lio/dcloud/uts/Date$Companion;

.field private static final MAX_TIME_VALUE:D = 8.64E15


# instance fields
.field private dateDouble:D


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lio/dcloud/uts/Date$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/dcloud/uts/Date$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lio/dcloud/uts/Date;->Companion:Lio/dcloud/uts/Date$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    long-to-double v0, v0

    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    return-void
.end method

.method public constructor <init>(Lio/dcloud/uts/Date;)V
    .locals 2

    const-string v0, "souceDate"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    iget-wide v0, p1, Lio/dcloud/uts/Date;->dateDouble:D

    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    return-void
.end method

.method public constructor <init>(Ljava/lang/Number;)V
    .locals 2

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 91
    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    return-void
.end method

.method public constructor <init>(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Z)V
    .locals 16

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    move-object/from16 v4, p5

    move-object/from16 v5, p6

    move-object/from16 v6, p7

    const-string v7, "year"

    invoke-static {v0, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v7, "monthIndex"

    invoke-static {v1, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v7, "day"

    invoke-static {v2, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v7, "hours"

    invoke-static {v3, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v7, "minutes"

    invoke-static {v4, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v7, "seconds"

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v7, "milliseconds"

    invoke-static {v6, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 113
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v7, 0x7

    .line 115
    new-array v8, v7, [D

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    .line 116
    aput-wide v10, v8, v9

    const/4 v12, 0x1

    .line 117
    aput-wide v10, v8, v12

    const-wide/high16 v13, 0x3ff0000000000000L    # 1.0

    const/4 v15, 0x2

    .line 118
    aput-wide v13, v8, v15

    .line 128
    new-array v13, v7, [Ljava/lang/Number;

    aput-object v0, v13, v9

    aput-object v1, v13, v12

    aput-object v2, v13, v15

    const/4 v0, 0x3

    aput-object v3, v13, v0

    const/4 v0, 0x4

    aput-object v4, v13, v0

    const/4 v0, 0x5

    aput-object v5, v13, v0

    const/4 v0, 0x6

    aput-object v6, v13, v0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v7, :cond_2

    .line 133
    aget-object v1, v13, v0

    invoke-virtual {v1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v1

    .line 134
    invoke-static {v1, v2}, Ljava/lang/Math;->abs(D)D

    move-result-wide v3

    const-wide v5, 0x7fefffffffffffffL    # Double.MAX_VALUE

    cmpg-double v14, v3, v5

    if-gtz v14, :cond_1

    .line 139
    invoke-static {v1, v2}, Lkotlin/math/MathKt;->truncate(D)D

    move-result-wide v1

    aput-wide v1, v8, v0

    if-nez v0, :cond_0

    .line 142
    aget-wide v1, v8, v9

    cmpl-double v3, v1, v10

    if-ltz v3, :cond_0

    const-wide/high16 v3, 0x4059000000000000L    # 100.0

    cmpg-double v5, v1, v3

    if-gez v5, :cond_0

    const/16 v3, 0x76c

    int-to-double v3, v3

    add-double/2addr v3, v1

    add-double/2addr v1, v3

    .line 144
    aput-wide v1, v8, v9

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    const-wide/high16 v0, 0x7ff8000000000000L    # Double.NaN

    :goto_1
    move-object/from16 v2, p0

    goto :goto_2

    .line 150
    :cond_2
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    xor-int/lit8 v1, p8, 0x1

    invoke-virtual {v0, v8, v1}, Lio/dcloud/uts/DateHolder;->setDateFields([DZ)D

    move-result-wide v0

    goto :goto_1

    .line 149
    :goto_2
    iput-wide v0, v2, Lio/dcloud/uts/Date;->dateDouble:D

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 9

    move/from16 v0, p9

    and-int/lit8 v1, v0, 0x4

    if-eqz v1, :cond_0

    const/4 p3, 0x1

    .line 107
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    check-cast p3, Ljava/lang/Number;

    :cond_0
    move-object v3, p3

    and-int/lit8 p3, v0, 0x8

    const/4 v1, 0x0

    if-eqz p3, :cond_1

    .line 108
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    move-object p4, p3

    check-cast p4, Ljava/lang/Number;

    :cond_1
    move-object v4, p4

    and-int/lit8 p3, v0, 0x10

    if-eqz p3, :cond_2

    .line 109
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    check-cast p3, Ljava/lang/Number;

    move-object v5, p3

    goto :goto_0

    :cond_2
    move-object v5, p5

    :goto_0
    and-int/lit8 p3, v0, 0x20

    if-eqz p3, :cond_3

    .line 110
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    check-cast p3, Ljava/lang/Number;

    move-object v6, p3

    goto :goto_1

    :cond_3
    move-object v6, p6

    :goto_1
    and-int/lit8 p3, v0, 0x40

    if-eqz p3, :cond_4

    .line 111
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    check-cast p3, Ljava/lang/Number;

    move-object v7, p3

    goto :goto_2

    :cond_4
    move-object/from16 v7, p7

    :goto_2
    and-int/lit16 p3, v0, 0x80

    if-eqz p3, :cond_5

    const/4 v8, 0x0

    goto :goto_3

    :cond_5
    move/from16 v8, p8

    :goto_3
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    .line 104
    invoke-direct/range {v0 .. v8}, Lio/dcloud/uts/Date;-><init>(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Z)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/DateParser;->parseAndValidateDate(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object p1

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    return-void
.end method

.method public static final UTC(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 8
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lio/dcloud/uts/Date;->Companion:Lio/dcloud/uts/Date$Companion;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    move-object v7, p6

    invoke-virtual/range {v0 .. v7}, Lio/dcloud/uts/Date$Companion;->UTC(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static final now()Ljava/lang/Number;
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lio/dcloud/uts/Date;->Companion:Lio/dcloud/uts/Date$Companion;

    invoke-virtual {v0}, Lio/dcloud/uts/Date$Companion;->now()Ljava/lang/Number;

    move-result-object v0

    return-object v0
.end method

.method public static final parse(Ljava/lang/String;)Ljava/lang/Number;
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lio/dcloud/uts/Date;->Companion:Lio/dcloud/uts/Date$Companion;

    invoke-virtual {v0, p0}, Lio/dcloud/uts/Date$Companion;->parse(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setFullYear$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 1

    and-int/lit8 p5, p4, 0x2

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    move-object p3, v0

    .line 378
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/uts/Date;->setFullYear(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setHours$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 1

    and-int/lit8 p6, p5, 0x2

    const/4 v0, 0x0

    if-eqz p6, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p6, p5, 0x4

    if-eqz p6, :cond_1

    move-object p3, v0

    :cond_1
    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_2

    move-object p4, v0

    .line 544
    :cond_2
    invoke-virtual {p0, p1, p2, p3, p4}, Lio/dcloud/uts/Date;->setHours(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setMinutes$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 1

    and-int/lit8 p5, p4, 0x2

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    move-object p3, v0

    .line 482
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/uts/Date;->setMinutes(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setMonth$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 405
    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/Date;->setMonth(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setSeconds$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 450
    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/Date;->setSeconds(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setUTCFullYear$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 1

    and-int/lit8 p5, p4, 0x2

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    move-object p3, v0

    .line 645
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/uts/Date;->setUTCFullYear(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setUTCHours$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 1

    and-int/lit8 p6, p5, 0x2

    const/4 v0, 0x0

    if-eqz p6, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p6, p5, 0x4

    if-eqz p6, :cond_1

    move-object p3, v0

    :cond_1
    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_2

    move-object p4, v0

    .line 583
    :cond_2
    invoke-virtual {p0, p1, p2, p3, p4}, Lio/dcloud/uts/Date;->setUTCHours(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setUTCMinutes$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 1

    and-int/lit8 p5, p4, 0x2

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    move-object p3, v0

    .line 510
    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/uts/Date;->setUTCMinutes(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setUTCMonth$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 631
    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/Date;->setUTCMonth(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic setUTCSeconds$default(Lio/dcloud/uts/Date;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/Number;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 463
    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/Date;->setUTCSeconds(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public compareTo(Lio/dcloud/uts/Date;)I
    .locals 4

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 665
    iget-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    iget-wide v2, p1, Lio/dcloud/uts/Date;->dateDouble:D

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Double;->compare(DD)I

    move-result p1

    return p1
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 0

    .line 6
    check-cast p1, Lio/dcloud/uts/Date;

    invoke-virtual {p0, p1}, Lio/dcloud/uts/Date;->compareTo(Lio/dcloud/uts/Date;)I

    move-result p1

    return p1
.end method

.method public final getDate()Ljava/lang/Number;
    .locals 4

    .line 171
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x21

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getDateDouble()D
    .locals 2

    .line 84
    iget-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    return-wide v0
.end method

.method public final getDay()Ljava/lang/Number;
    .locals 4

    .line 276
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x71

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getFullYear()Ljava/lang/Number;
    .locals 4

    .line 192
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getHours()Ljava/lang/Number;
    .locals 4

    .line 220
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x31

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getMilliseconds()Ljava/lang/Number;
    .locals 4

    .line 262
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x61

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getMinutes()Ljava/lang/Number;
    .locals 4

    .line 234
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x41

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getMonth()Ljava/lang/Number;
    .locals 4

    .line 206
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x11

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getSeconds()Ljava/lang/Number;
    .locals 4

    .line 248
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x51

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getTime()Ljava/lang/Number;
    .locals 2

    .line 160
    iget-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    double-to-long v0, v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getTimezoneOffset()Ljava/lang/Number;
    .locals 3

    .line 294
    iget-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-eqz v0, :cond_0

    const-wide/high16 v0, 0x7ff8000000000000L    # Double.NaN

    .line 295
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0

    .line 299
    :cond_0
    new-instance v0, Ljava/util/Date;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    double-to-long v1, v1

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    .line 300
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 301
    invoke-virtual {v1, v0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 304
    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeZone()Ljava/util/TimeZone;

    move-result-object v0

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    double-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Ljava/util/TimeZone;->getOffset(J)I

    move-result v0

    neg-int v0, v0

    const v1, 0xea60

    .line 307
    div-int/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCDate()Ljava/lang/Number;
    .locals 4

    .line 178
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x20

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCDay()Ljava/lang/Number;
    .locals 4

    .line 283
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x70

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCFullYear()Ljava/lang/Number;
    .locals 4

    .line 199
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCHours()Ljava/lang/Number;
    .locals 4

    .line 227
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x30

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCMilliseconds()Ljava/lang/Number;
    .locals 4

    .line 269
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x60

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCMinutes()Ljava/lang/Number;
    .locals 4

    .line 241
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x40

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCMonth()Ljava/lang/Number;
    .locals 4

    .line 213
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x10

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getUTCSeconds()Ljava/lang/Number;
    .locals 4

    .line 255
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x50

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final getYear()Ljava/lang/Number;
    .locals 4

    .line 185
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x101

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateHolder;->getDateField(DI)Ljava/lang/Number;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public final setDate(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 5

    const-string v0, "date"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 419
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Number;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/16 p1, 0x231

    invoke-virtual {v0, v1, v2, p1, v3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide v0

    .line 420
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 421
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setDateDouble(D)V
    .locals 0

    .line 84
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    return-void
.end method

.method public final setFullYear(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 1

    const-string v0, "year"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 372
    invoke-virtual {p0, p1, v0, v0}, Lio/dcloud/uts/Date;->setFullYear(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p1

    return-object p1
.end method

.method public final setFullYear(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 8

    const-string v0, "year"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x31

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    .line 385
    sget-object v4, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Number;

    aput-object p1, v7, v1

    aput-object p2, v7, v2

    aput-object p3, v7, v0

    invoke-virtual {v4, v5, v6, v3, v7}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_0
    if-eqz p2, :cond_1

    .line 388
    sget-object p3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v0, v0, [Ljava/lang/Number;

    aput-object p1, v0, v1

    aput-object p2, v0, v2

    invoke-virtual {p3, v4, v5, v3, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 391
    :cond_1
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array p3, v2, [Ljava/lang/Number;

    aput-object p1, p3, v1

    invoke-virtual {p2, v4, v5, v3, p3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 393
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 394
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setHours(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 1

    const-string v0, "hours"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 538
    invoke-virtual {p0, p1, v0, v0, v0}, Lio/dcloud/uts/Date;->setHours(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p1

    return-object p1
.end method

.method public final setHours(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 9

    const-string v0, "hours"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x3

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/16 v4, 0x371

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-eqz p4, :cond_0

    .line 552
    sget-object v5, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    .line 553
    iget-wide v6, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v8, 0x4

    .line 558
    new-array v8, v8, [Ljava/lang/Number;

    aput-object p1, v8, v2

    aput-object p2, v8, v3

    aput-object p3, v8, v1

    aput-object p4, v8, v0

    .line 552
    invoke-virtual {v5, v6, v7, v4, v8}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_0
    if-eqz p2, :cond_1

    if-eqz p3, :cond_1

    .line 562
    sget-object p4, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    .line 563
    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 567
    new-array v0, v0, [Ljava/lang/Number;

    aput-object p1, v0, v2

    aput-object p2, v0, v3

    aput-object p3, v0, v1

    .line 562
    invoke-virtual {p4, v5, v6, v4, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_1
    if-eqz p2, :cond_2

    .line 571
    sget-object p3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array p4, v1, [Ljava/lang/Number;

    aput-object p1, p4, v2

    aput-object p2, p4, v3

    invoke-virtual {p3, v5, v6, v4, p4}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 574
    :cond_2
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide p3, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v0, v3, [Ljava/lang/Number;

    aput-object p1, v0, v2

    invoke-virtual {p2, p3, p4, v4, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 576
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 577
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setMilliseconds(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 5

    const-string v0, "milliseconds"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 428
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Number;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/16 p1, 0x671

    invoke-virtual {v0, v1, v2, p1, v3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide v0

    .line 429
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 430
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setMinutes(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 1

    const-string v0, "minutes"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 476
    invoke-virtual {p0, p1, v0, v0}, Lio/dcloud/uts/Date;->setMinutes(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p1

    return-object p1
.end method

.method public final setMinutes(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 8

    const-string v0, "minutes"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x471

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    .line 489
    sget-object v4, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    .line 490
    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v7, 0x3

    .line 494
    new-array v7, v7, [Ljava/lang/Number;

    aput-object p1, v7, v1

    aput-object p2, v7, v2

    aput-object p3, v7, v0

    .line 489
    invoke-virtual {v4, v5, v6, v3, v7}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_0
    if-eqz p2, :cond_1

    .line 498
    sget-object p3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v0, v0, [Ljava/lang/Number;

    aput-object p1, v0, v1

    aput-object p2, v0, v2

    invoke-virtual {p3, v4, v5, v3, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 501
    :cond_1
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array p3, v2, [Ljava/lang/Number;

    aput-object p1, p3, v1

    invoke-virtual {p2, v4, v5, v3, p3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 503
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 504
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setMonth(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 1

    const-string v0, "month"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 402
    invoke-virtual {p0, p1, v0}, Lio/dcloud/uts/Date;->setMonth(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p1

    return-object p1
.end method

.method public final setMonth(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 7

    const-string v0, "month"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/16 v2, 0x131

    if-eqz p2, :cond_0

    .line 407
    sget-object v3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Number;

    aput-object p1, v6, v0

    aput-object p2, v6, v1

    invoke-virtual {v3, v4, v5, v2, v6}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 409
    :cond_0
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v3, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v1, v1, [Ljava/lang/Number;

    aput-object p1, v1, v0

    invoke-virtual {p2, v3, v4, v2, v1}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 411
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 412
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setSeconds(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 1

    const-string v0, "seconds"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 444
    invoke-virtual {p0, p1, v0}, Lio/dcloud/uts/Date;->setSeconds(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p1

    return-object p1
.end method

.method public final setSeconds(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 7

    const-string v0, "seconds"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/16 v2, 0x571

    if-eqz p2, :cond_0

    .line 452
    sget-object v3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Number;

    aput-object p1, v6, v0

    aput-object p2, v6, v1

    invoke-virtual {v3, v4, v5, v2, v6}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 454
    :cond_0
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v3, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v1, v1, [Ljava/lang/Number;

    aput-object p1, v1, v0

    invoke-virtual {p2, v3, v4, v2, v1}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 456
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 457
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setTime(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 6

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 321
    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    .line 325
    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result p1

    const-wide/high16 v2, 0x7ff8000000000000L    # Double.NaN

    if-eqz p1, :cond_0

    :goto_0
    move-wide v0, v2

    goto :goto_1

    :cond_0
    const-wide v4, 0x433eb208c2dc0000L    # 8.64E15

    cmpl-double p1, v0, v4

    if-lez p1, :cond_1

    goto :goto_0

    :cond_1
    const-wide v4, -0x3cc14df73d240000L    # -8.64E15

    cmpg-double p1, v0, v4

    if-gez p1, :cond_2

    goto :goto_0

    .line 332
    :cond_2
    :goto_1
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 335
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCDate(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 5

    const-string v0, "date"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 623
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Number;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/16 p1, 0x230

    invoke-virtual {v0, v1, v2, p1, v3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide v0

    .line 624
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 625
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCFullYear(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 8

    const-string v0, "year"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x30

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    .line 652
    sget-object v4, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Number;

    aput-object p1, v7, v1

    aput-object p2, v7, v2

    aput-object p3, v7, v0

    invoke-virtual {v4, v5, v6, v3, v7}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_0
    if-eqz p2, :cond_1

    .line 655
    sget-object p3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v0, v0, [Ljava/lang/Number;

    aput-object p1, v0, v1

    aput-object p2, v0, v2

    invoke-virtual {p3, v4, v5, v3, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 658
    :cond_1
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array p3, v2, [Ljava/lang/Number;

    aput-object p1, p3, v1

    invoke-virtual {p2, v4, v5, v3, p3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 660
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 661
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCHours(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 9

    const-string v0, "hours"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x3

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/16 v4, 0x370

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    if-eqz p4, :cond_0

    .line 591
    sget-object v5, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    .line 592
    iget-wide v6, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v8, 0x4

    .line 597
    new-array v8, v8, [Ljava/lang/Number;

    aput-object p1, v8, v2

    aput-object p2, v8, v3

    aput-object p3, v8, v1

    aput-object p4, v8, v0

    .line 591
    invoke-virtual {v5, v6, v7, v4, v8}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_0
    if-eqz p2, :cond_1

    if-eqz p3, :cond_1

    .line 601
    sget-object p4, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    .line 602
    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 606
    new-array v0, v0, [Ljava/lang/Number;

    aput-object p1, v0, v2

    aput-object p2, v0, v3

    aput-object p3, v0, v1

    .line 601
    invoke-virtual {p4, v5, v6, v4, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_1
    if-eqz p2, :cond_2

    .line 610
    sget-object p3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array p4, v1, [Ljava/lang/Number;

    aput-object p1, p4, v2

    aput-object p2, p4, v3

    invoke-virtual {p3, v5, v6, v4, p4}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 613
    :cond_2
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide p3, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v0, v3, [Ljava/lang/Number;

    aput-object p1, v0, v2

    invoke-virtual {p2, p3, p4, v4, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 615
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 616
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCMilliseconds(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 5

    const-string v0, "milliseconds"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 437
    sget-object v0, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Number;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/16 p1, 0x670

    invoke-virtual {v0, v1, v2, p1, v3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide v0

    .line 438
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 439
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCMinutes(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 8

    const-string v0, "minutes"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x470

    if-eqz p2, :cond_0

    if-eqz p3, :cond_0

    .line 517
    sget-object v4, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    .line 518
    iget-wide v5, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v7, 0x3

    .line 522
    new-array v7, v7, [Ljava/lang/Number;

    aput-object p1, v7, v1

    aput-object p2, v7, v2

    aput-object p3, v7, v0

    .line 517
    invoke-virtual {v4, v5, v6, v3, v7}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    :cond_0
    if-eqz p2, :cond_1

    .line 526
    sget-object p3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v0, v0, [Ljava/lang/Number;

    aput-object p1, v0, v1

    aput-object p2, v0, v2

    invoke-virtual {p3, v4, v5, v3, v0}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 529
    :cond_1
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array p3, v2, [Ljava/lang/Number;

    aput-object p1, p3, v1

    invoke-virtual {p2, v4, v5, v3, p3}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 531
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 532
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCMonth(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 7

    const-string v0, "month"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/16 v2, 0x130

    if-eqz p2, :cond_0

    .line 633
    sget-object v3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Number;

    aput-object p1, v6, v0

    aput-object p2, v6, v1

    invoke-virtual {v3, v4, v5, v2, v6}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 635
    :cond_0
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v3, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v1, v1, [Ljava/lang/Number;

    aput-object p1, v1, v0

    invoke-virtual {p2, v3, v4, v2, v1}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 637
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 638
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setUTCSeconds(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 7

    const-string v0, "seconds"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/16 v2, 0x570

    if-eqz p2, :cond_0

    .line 465
    sget-object v3, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v4, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Number;

    aput-object p1, v6, v0

    aput-object p2, v6, v1

    invoke-virtual {v3, v4, v5, v2, v6}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    goto :goto_0

    .line 467
    :cond_0
    sget-object p2, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v3, p0, Lio/dcloud/uts/Date;->dateDouble:D

    new-array v1, v1, [Ljava/lang/Number;

    aput-object p1, v1, v0

    invoke-virtual {p2, v3, v4, v2, v1}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide p1

    .line 469
    :goto_0
    iput-wide p1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 470
    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final setYear(Ljava/lang/Number;)Ljava/lang/Number;
    .locals 6

    const-string v0, "year"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 347
    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    .line 350
    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result p1

    if-eqz p1, :cond_0

    const-wide/high16 v0, 0x7ff8000000000000L    # Double.NaN

    .line 351
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 352
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1

    .line 356
    :cond_0
    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double p1, v0, v2

    if-ltz p1, :cond_1

    const-wide/high16 v2, 0x4059000000000000L    # 100.0

    cmpg-double p1, v0, v2

    if-gez p1, :cond_1

    const/16 p1, 0x76c

    int-to-double v2, p1

    add-double/2addr v0, v2

    .line 363
    :cond_1
    sget-object p1, Lio/dcloud/uts/DateHolder;->INSTANCE:Lio/dcloud/uts/DateHolder;

    iget-wide v2, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Number;

    const/4 v5, 0x0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    aput-object v0, v4, v5

    const/16 v0, 0x11

    invoke-virtual {p1, v2, v3, v0, v4}, Lio/dcloud/uts/DateHolder;->setDateField(DI[Ljava/lang/Number;)D

    move-result-wide v0

    .line 364
    iput-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    .line 365
    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public final toDateString()Ljava/lang/String;
    .locals 4

    .line 725
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x11

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toGMTString()Ljava/lang/String;
    .locals 1

    .line 692
    invoke-virtual {p0}, Lio/dcloud/uts/Date;->toUTCString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toISOString()Ljava/lang/String;
    .locals 4

    .line 700
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x23

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toJSON()Ljava/lang/Object;
    .locals 5

    .line 712
    iget-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    const-wide v2, 0x7fefffffffffffffL    # Double.MAX_VALUE

    cmpg-double v4, v0, v2

    if-gtz v4, :cond_0

    .line 717
    invoke-virtual {p0}, Lio/dcloud/uts/Date;->toISOString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method public final toLocaleDateString()Ljava/lang/String;
    .locals 4

    .line 749
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x31

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toLocaleString()Ljava/lang/String;
    .locals 4

    .line 741
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x33

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toLocaleTimeString()Ljava/lang/String;
    .locals 4

    .line 757
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x32

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .line 677
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x13

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toTimeString()Ljava/lang/String;
    .locals 4

    .line 733
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/16 v3, 0x12

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final toUTCString()Ljava/lang/String;
    .locals 4

    .line 685
    sget-object v0, Lio/dcloud/uts/DateParser;->INSTANCE:Lio/dcloud/uts/DateParser;

    iget-wide v1, p0, Lio/dcloud/uts/Date;->dateDouble:D

    const/4 v3, 0x3

    invoke-virtual {v0, v1, v2, v3}, Lio/dcloud/uts/DateParser;->getDateString(DI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final valueOf()Ljava/lang/Number;
    .locals 2

    .line 164
    iget-wide v0, p0, Lio/dcloud/uts/Date;->dateDouble:D

    double-to-long v0, v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method
