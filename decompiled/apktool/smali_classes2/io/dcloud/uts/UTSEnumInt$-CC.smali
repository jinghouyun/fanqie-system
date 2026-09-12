.class public final synthetic Lio/dcloud/uts/UTSEnumInt$-CC;
.super Ljava/lang/Object;
.source "UTSEnumInt.kt"


# direct methods
.method public static $default$and(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I
    .locals 1
    .param p0, "_this"    # Lio/dcloud/uts/UTSEnumInt;

    .line 0
    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    invoke-interface {p0}, Lio/dcloud/uts/UTSEnumInt;->getValue()I

    move-result v0

    invoke-interface {p1}, Lio/dcloud/uts/UTSEnumInt;->getValue()I

    move-result p1

    and-int/2addr p1, v0

    return p1
.end method

.method public static $default$or(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I
    .locals 1
    .param p0, "_this"    # Lio/dcloud/uts/UTSEnumInt;

    .line 0
    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    invoke-interface {p0}, Lio/dcloud/uts/UTSEnumInt;->getValue()I

    move-result v0

    invoke-interface {p1}, Lio/dcloud/uts/UTSEnumInt;->getValue()I

    move-result p1

    or-int/2addr p1, v0

    return p1
.end method

.method public static synthetic access$and$jd(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I
    .locals 0

    .line 3
    invoke-static {p0, p1}, Lio/dcloud/uts/UTSEnumInt$-CC;->$default$and(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I

    move-result p0

    return p0
.end method

.method public static synthetic access$or$jd(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I
    .locals 0

    .line 3
    invoke-static {p0, p1}, Lio/dcloud/uts/UTSEnumInt$-CC;->$default$or(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I

    move-result p0

    return p0
.end method
