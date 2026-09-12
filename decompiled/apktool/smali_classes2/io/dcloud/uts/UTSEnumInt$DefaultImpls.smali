.class public final Lio/dcloud/uts/UTSEnumInt$DefaultImpls;
.super Ljava/lang/Object;
.source "UTSEnumInt.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/uts/UTSEnumInt;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "DefaultImpls"
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static and(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    invoke-static {p0, p1}, Lio/dcloud/uts/UTSEnumInt$-CC;->access$and$jd(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I

    move-result p0

    return p0
.end method

.method public static or(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 9
    invoke-static {p0, p1}, Lio/dcloud/uts/UTSEnumInt$-CC;->access$or$jd(Lio/dcloud/uts/UTSEnumInt;Lio/dcloud/uts/UTSEnumInt;)I

    move-result p0

    return p0
.end method
