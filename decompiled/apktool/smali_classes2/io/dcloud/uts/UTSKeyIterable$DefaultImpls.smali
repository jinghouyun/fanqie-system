.class public final Lio/dcloud/uts/UTSKeyIterable$DefaultImpls;
.super Ljava/lang/Object;
.source "UTSIterator.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/uts/UTSKeyIterable;
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
.method public static get(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    const-string v0, "propertyName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 77
    invoke-static {p0, p1}, Lio/dcloud/uts/UTSKeyIterable$-CC;->access$get$jd(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static ignoredKeys(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSArray;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSKeyIterable;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 58
    invoke-static {p0}, Lio/dcloud/uts/UTSKeyIterable$-CC;->access$ignoredKeys$jd(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    return-object p0
.end method

.method public static keyIterator(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSIterator;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSKeyIterable;",
            ")",
            "Lio/dcloud/uts/UTSIterator<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 115
    invoke-static {p0}, Lio/dcloud/uts/UTSKeyIterable$-CC;->access$keyIterator$jd(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSIterator;

    move-result-object p0

    return-object p0
.end method

.method public static set(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    const-string v0, "propertyName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 93
    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSKeyIterable$-CC;->access$set$jd(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;Ljava/lang/Object;)V

    return-void
.end method
