.class public final Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;
.super Ljava/lang/Object;
.source "JSRegexp.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/uts/nativeregex/JSRegexp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MatchResult"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0086\u0008\u0018\u00002\u00020\u0001BY\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0018\u0008\u0002\u0010\u0008\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t\u0012\u0016\u0008\u0002\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003\u00a2\u0006\u0004\u0008\u000b\u0010\u000cJ\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001f\u001a\u00020\u0006H\u0016J\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0004H\u00c6\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\tH\u00c6\u0003J\u001c\u0010$\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017Jf\u0010%\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00042\u0018\u0008\u0002\u0010\u0008\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t2\u0016\u0008\u0002\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010&J\t\u0010\'\u001a\u00020\u0004H\u00d6\u0001R\u001b\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R!\u0010\u0008\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R!\u0010\n\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0011\u00a8\u0006("
    }
    d2 = {
        "Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;",
        "",
        "matches",
        "",
        "",
        "index",
        "",
        "input",
        "namedGroups",
        "",
        "matchIndices",
        "<init>",
        "([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)V",
        "getMatches",
        "()[Ljava/lang/String;",
        "[Ljava/lang/String;",
        "getIndex",
        "()I",
        "getInput",
        "()Ljava/lang/String;",
        "getNamedGroups",
        "()Ljava/util/Map;",
        "getMatchIndices",
        "()[[Ljava/lang/Integer;",
        "[[Ljava/lang/Integer;",
        "length",
        "getLength",
        "get",
        "equals",
        "",
        "other",
        "hashCode",
        "component1",
        "component2",
        "component3",
        "component4",
        "component5",
        "copy",
        "([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;",
        "toString",
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


# instance fields
.field private final index:I

.field private final input:Ljava/lang/String;

.field private final matchIndices:[[Ljava/lang/Integer;

.field private final matches:[Ljava/lang/String;

.field private final namedGroups:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;[[",
            "Ljava/lang/Integer;",
            ")V"
        }
    .end annotation

    const-string v0, "matches"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "input"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    .line 40
    iput p2, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    .line 41
    iput-object p3, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    .line 42
    iput-object p4, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->namedGroups:Ljava/util/Map;

    .line 43
    iput-object p5, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matchIndices:[[Ljava/lang/Integer;

    return-void
.end method

.method public synthetic constructor <init>([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 1

    and-int/lit8 p7, p6, 0x8

    const/4 v0, 0x0

    if-eqz p7, :cond_0

    move-object p4, v0

    :cond_0
    and-int/lit8 p6, p6, 0x10

    if-eqz p6, :cond_1

    move-object p6, v0

    goto :goto_0

    :cond_1
    move-object p6, p5

    :goto_0
    move-object p5, p4

    move-object p4, p3

    move p3, p2

    move-object p2, p1

    move-object p1, p0

    .line 38
    invoke-direct/range {p1 .. p6}, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;-><init>([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)V

    return-void
.end method

.method public static synthetic copy$default(Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;[Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;ILjava/lang/Object;)Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;
    .locals 0

    and-int/lit8 p7, p6, 0x1

    if-eqz p7, :cond_0

    iget-object p1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    :cond_0
    and-int/lit8 p7, p6, 0x2

    if-eqz p7, :cond_1

    iget p2, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    :cond_1
    and-int/lit8 p7, p6, 0x4

    if-eqz p7, :cond_2

    iget-object p3, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    :cond_2
    and-int/lit8 p7, p6, 0x8

    if-eqz p7, :cond_3

    iget-object p4, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->namedGroups:Ljava/util/Map;

    :cond_3
    and-int/lit8 p6, p6, 0x10

    if-eqz p6, :cond_4

    iget-object p5, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matchIndices:[[Ljava/lang/Integer;

    :cond_4
    move-object p6, p4

    move-object p7, p5

    move p4, p2

    move-object p5, p3

    move-object p2, p0

    move-object p3, p1

    invoke-virtual/range {p2 .. p7}, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->copy([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()[Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    return-object v0
.end method

.method public final component2()I
    .locals 1

    iget v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    return v0
.end method

.method public final component3()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    return-object v0
.end method

.method public final component4()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->namedGroups:Ljava/util/Map;

    return-object v0
.end method

.method public final component5()[[Ljava/lang/Integer;
    .locals 1

    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matchIndices:[[Ljava/lang/Integer;

    return-object v0
.end method

.method public final copy([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;[[",
            "Ljava/lang/Integer;",
            ")",
            "Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;"
        }
    .end annotation

    const-string v0, "matches"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "input"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v1, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v1 .. v6}, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;-><init>([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)V

    return-object v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    .line 51
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    :goto_0
    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_2

    return v2

    .line 53
    :cond_2
    const-string v1, "null cannot be cast to non-null type io.dcloud.uts.nativeregex.JSRegexp.MatchResult"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;

    .line 54
    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    iget-object v3, p1, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    invoke-static {v1, v3}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    return v2

    .line 55
    :cond_3
    iget v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    iget v3, p1, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    if-eq v1, v3, :cond_4

    return v2

    .line 56
    :cond_4
    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    iget-object p1, p1, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    invoke-static {v1, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_5

    return v2

    :cond_5
    return v0
.end method

.method public final get(I)Ljava/lang/String;
    .locals 1

    .line 47
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    aget-object p1, v0, p1

    return-object p1
.end method

.method public final getIndex()I
    .locals 1

    .line 40
    iget v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    return v0
.end method

.method public final getInput()Ljava/lang/String;
    .locals 1

    .line 41
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    return-object v0
.end method

.method public final getLength()I
    .locals 1

    .line 45
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public final getMatchIndices()[[Ljava/lang/Integer;
    .locals 1

    .line 43
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matchIndices:[[Ljava/lang/Integer;

    return-object v0
.end method

.method public final getMatches()[Ljava/lang/String;
    .locals 1

    .line 39
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    return-object v0
.end method

.method public final getNamedGroups()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 42
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->namedGroups:Ljava/util/Map;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    .line 62
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    .line 63
    iget v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    .line 64
    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "MatchResult(matches="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matches:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", index="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->index:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", input="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->input:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", namedGroups="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->namedGroups:Ljava/util/Map;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", matchIndices="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;->matchIndices:[[Ljava/lang/Integer;

    invoke-static {v1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
