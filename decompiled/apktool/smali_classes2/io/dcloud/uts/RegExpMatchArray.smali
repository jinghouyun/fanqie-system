.class public final Lio/dcloud/uts/RegExpMatchArray;
.super Lio/dcloud/uts/UTSArray;
.source "String.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lio/dcloud/uts/UTSArray<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 String.kt\nio/dcloud/uts/RegExpMatchArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1399:1\n1869#2,2:1400\n*S KotlinDebug\n*F\n+ 1 String.kt\nio/dcloud/uts/RegExpMatchArray\n*L\n251#1:1400,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010 \n\u0002\u0008\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0008\u0016\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\u0008\u0006\u0010\u0007B\t\u0008\u0016\u00a2\u0006\u0004\u0008\u0006\u0010\u0008J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0015J\u0008\u0010\u0016\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013\u00a8\u0006\u0017"
    }
    d2 = {
        "Lio/dcloud/uts/RegExpMatchArray;",
        "Lio/dcloud/uts/UTSArray;",
        "",
        "matchResult",
        "Lkotlin/text/MatchResult;",
        "str",
        "<init>",
        "(Lkotlin/text/MatchResult;Ljava/lang/String;)V",
        "()V",
        "index",
        "",
        "getIndex",
        "()I",
        "setIndex",
        "(I)V",
        "input",
        "getInput",
        "()Ljava/lang/String;",
        "setInput",
        "(Ljava/lang/String;)V",
        "getData",
        "",
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
.field private index:I

.field private input:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 259
    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 230
    const-string v0, ""

    iput-object v0, p0, Lio/dcloud/uts/RegExpMatchArray;->input:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lkotlin/text/MatchResult;Ljava/lang/String;)V
    .locals 1

    const-string v0, "str"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 244
    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 246
    iput-object p2, p0, Lio/dcloud/uts/RegExpMatchArray;->input:Ljava/lang/String;

    if-eqz p1, :cond_1

    .line 248
    invoke-interface {p1}, Lkotlin/text/MatchResult;->getGroups()Lkotlin/text/MatchGroupCollection;

    move-result-object p2

    check-cast p2, Ljava/util/Collection;

    invoke-interface {p2}, Ljava/util/Collection;->isEmpty()Z

    move-result p2

    if-nez p2, :cond_1

    .line 249
    invoke-interface {p1}, Lkotlin/text/MatchResult;->getGroups()Lkotlin/text/MatchGroupCollection;

    move-result-object p2

    const/4 v0, 0x0

    invoke-interface {p2, v0}, Lkotlin/text/MatchGroupCollection;->get(I)Lkotlin/text/MatchGroup;

    move-result-object p2

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p2}, Lkotlin/text/MatchGroup;->getRange()Lkotlin/ranges/IntRange;

    move-result-object p2

    invoke-virtual {p2}, Lkotlin/ranges/IntRange;->getFirst()I

    move-result p2

    iput p2, p0, Lio/dcloud/uts/RegExpMatchArray;->index:I

    .line 251
    invoke-interface {p1}, Lkotlin/text/MatchResult;->getGroups()Lkotlin/text/MatchGroupCollection;

    move-result-object p1

    if-eqz p1, :cond_1

    check-cast p1, Ljava/lang/Iterable;

    .line 1400
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_0
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lkotlin/text/MatchGroup;

    if-eqz p2, :cond_0

    .line 253
    invoke-virtual {p2}, Lkotlin/text/MatchGroup;->getValue()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p0, p2}, Lio/dcloud/uts/RegExpMatchArray;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    return-void
.end method


# virtual methods
.method public final bridge contains(Ljava/lang/Object;)Z
    .locals 1

    if-nez p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    .line 228
    :cond_0
    instance-of v0, p1, Ljava/lang/String;

    :goto_0
    if-nez v0, :cond_1

    const/4 p1, 0x0

    return p1

    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lio/dcloud/uts/RegExpMatchArray;->contains(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public bridge contains(Ljava/lang/String;)Z
    .locals 0

    .line 228
    invoke-super {p0, p1}, Lio/dcloud/uts/UTSArray;->contains(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final getData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 235
    invoke-virtual {p0}, Lio/dcloud/uts/RegExpMatchArray;->toKotlinList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final getIndex()I
    .locals 1

    .line 229
    iget v0, p0, Lio/dcloud/uts/RegExpMatchArray;->index:I

    return v0
.end method

.method public final getInput()Ljava/lang/String;
    .locals 1

    .line 230
    iget-object v0, p0, Lio/dcloud/uts/RegExpMatchArray;->input:Ljava/lang/String;

    return-object v0
.end method

.method public final bridge indexOf(Ljava/lang/Object;)I
    .locals 1

    if-nez p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    .line 228
    :cond_0
    instance-of v0, p1, Ljava/lang/String;

    :goto_0
    if-nez v0, :cond_1

    const/4 p1, -0x1

    return p1

    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lio/dcloud/uts/RegExpMatchArray;->indexOf(Ljava/lang/String;)I

    move-result p1

    return p1
.end method

.method public bridge indexOf(Ljava/lang/String;)I
    .locals 0

    .line 228
    invoke-super {p0, p1}, Lio/dcloud/uts/UTSArray;->indexOf(Ljava/lang/Object;)I

    move-result p1

    return p1
.end method

.method public final bridge lastIndexOf(Ljava/lang/Object;)I
    .locals 1

    if-nez p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    .line 228
    :cond_0
    instance-of v0, p1, Ljava/lang/String;

    :goto_0
    if-nez v0, :cond_1

    const/4 p1, -0x1

    return p1

    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lio/dcloud/uts/RegExpMatchArray;->lastIndexOf(Ljava/lang/String;)I

    move-result p1

    return p1
.end method

.method public bridge lastIndexOf(Ljava/lang/String;)I
    .locals 0

    .line 228
    invoke-super {p0, p1}, Lio/dcloud/uts/UTSArray;->lastIndexOf(Ljava/lang/Object;)I

    move-result p1

    return p1
.end method

.method public final bridge remove(I)Ljava/lang/String;
    .locals 0

    .line 228
    invoke-virtual {p0, p1}, Lio/dcloud/uts/RegExpMatchArray;->removeAt(I)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public final bridge remove(Ljava/lang/Object;)Z
    .locals 1

    if-nez p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    .line 228
    :cond_0
    instance-of v0, p1, Ljava/lang/String;

    :goto_0
    if-nez v0, :cond_1

    const/4 p1, 0x0

    return p1

    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lio/dcloud/uts/RegExpMatchArray;->remove(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public bridge remove(Ljava/lang/String;)Z
    .locals 0

    .line 228
    invoke-super {p0, p1}, Lio/dcloud/uts/UTSArray;->remove(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public bridge removeAt(I)Ljava/lang/String;
    .locals 0

    .line 228
    invoke-super {p0, p1}, Lio/dcloud/uts/UTSArray;->remove(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    return-object p1
.end method

.method public final setIndex(I)V
    .locals 0

    .line 229
    iput p1, p0, Lio/dcloud/uts/RegExpMatchArray;->index:I

    return-void
.end method

.method public final setInput(Ljava/lang/String;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 230
    iput-object p1, p0, Lio/dcloud/uts/RegExpMatchArray;->input:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .line 240
    invoke-static {p0}, Lio/dcloud/uts/JSON;->stringify(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, ""

    :cond_0
    return-object v0
.end method
