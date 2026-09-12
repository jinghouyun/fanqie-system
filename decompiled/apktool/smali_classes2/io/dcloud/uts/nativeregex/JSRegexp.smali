.class public final Lio/dcloud/uts/nativeregex/JSRegexp;
.super Ljava/lang/Object;
.source "JSRegexp.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/uts/nativeregex/JSRegexp$Companion;,
        Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0018\u0000 (2\u00020\u0001:\u0002()B!\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\u0008\u0007\u0010\u0008J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000fJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016J\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020\u0016J\u0008\u0010\'\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018\u00a8\u0006*"
    }
    d2 = {
        "Lio/dcloud/uts/nativeregex/JSRegexp;",
        "",
        "bytecode",
        "",
        "pattern",
        "",
        "flags",
        "<init>",
        "([BLjava/lang/String;Ljava/lang/String;)V",
        "getBytecode",
        "()[B",
        "getPattern",
        "()Ljava/lang/String;",
        "getFlags",
        "value",
        "",
        "lastIndex",
        "getLastIndex",
        "()I",
        "setLastIndex",
        "(I)V",
        "hasGlobalOrSticky",
        "",
        "getHasGlobalOrSticky",
        "()Z",
        "exec",
        "Lio/dcloud/uts/RegExpExecArray;",
        "input",
        "startIndex",
        "test",
        "getSource",
        "isGlobal",
        "isIgnoreCase",
        "isMultiline",
        "isDotAll",
        "isUnicode",
        "isUnicodeSets",
        "isSticky",
        "hasIndices",
        "toString",
        "Companion",
        "MatchResult",
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
.field public static final Companion:Lio/dcloud/uts/nativeregex/JSRegexp$Companion;


# instance fields
.field private final bytecode:[B

.field private final flags:Ljava/lang/String;

.field private lastIndex:I

.field private final pattern:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lio/dcloud/uts/nativeregex/JSRegexp;->Companion:Lio/dcloud/uts/nativeregex/JSRegexp$Companion;

    return-void
.end method

.method private constructor <init>([BLjava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    iput-object p1, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->bytecode:[B

    .line 9
    iput-object p2, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->pattern:Ljava/lang/String;

    .line 10
    iput-object p3, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    return-void
.end method

.method public synthetic constructor <init>([BLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lio/dcloud/uts/nativeregex/JSRegexp;-><init>([BLjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic exec$default(Lio/dcloud/uts/nativeregex/JSRegexp;Ljava/lang/String;IILjava/lang/Object;)Lio/dcloud/uts/RegExpExecArray;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, -0x1

    .line 85
    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/nativeregex/JSRegexp;->exec(Ljava/lang/String;I)Lio/dcloud/uts/RegExpExecArray;

    move-result-object p0

    return-object p0
.end method

.method private final getHasGlobalOrSticky()Z
    .locals 5

    .line 81
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/16 v1, 0x67

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/16 v1, 0x79

    invoke-static {v0, v1, v2, v3, v4}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    return v2

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method


# virtual methods
.method public final exec(Ljava/lang/String;I)Lio/dcloud/uts/RegExpExecArray;
    .locals 3

    const-string v0, "input"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    if-ltz p2, :cond_0

    goto :goto_0

    .line 89
    :cond_0
    invoke-direct {p0}, Lio/dcloud/uts/nativeregex/JSRegexp;->getHasGlobalOrSticky()Z

    move-result p2

    if-eqz p2, :cond_1

    invoke-virtual {p0}, Lio/dcloud/uts/nativeregex/JSRegexp;->getLastIndex()I

    move-result p2

    goto :goto_0

    :cond_1
    const/4 p2, 0x0

    .line 94
    :goto_0
    sget-object v1, Lio/dcloud/uts/nativeregex/RegexpBridge;->INSTANCE:Lio/dcloud/uts/nativeregex/RegexpBridge;

    iget-object v2, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->bytecode:[B

    invoke-virtual {v1, v2, p1, p2}, Lio/dcloud/uts/nativeregex/RegexpBridge;->execRegexp([BLjava/lang/String;I)Lio/dcloud/uts/RegExpExecArray;

    move-result-object p1

    const/4 p2, 0x0

    if-nez p1, :cond_3

    .line 99
    invoke-direct {p0}, Lio/dcloud/uts/nativeregex/JSRegexp;->getHasGlobalOrSticky()Z

    move-result p1

    if-eqz p1, :cond_2

    .line 100
    invoke-virtual {p0, v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->setLastIndex(I)V

    :cond_2
    return-object p2

    .line 106
    :cond_3
    invoke-direct {p0}, Lio/dcloud/uts/nativeregex/JSRegexp;->getHasGlobalOrSticky()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 108
    move-object v1, p1

    check-cast v1, Ljava/util/List;

    invoke-static {v1, v0}, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List;I)Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Ljava/lang/String;

    if-eqz v2, :cond_4

    move-object p2, v1

    check-cast p2, Ljava/lang/String;

    .line 109
    :cond_4
    invoke-virtual {p1}, Lio/dcloud/uts/RegExpExecArray;->getIndex()I

    move-result v1

    if-eqz p2, :cond_5

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    :cond_5
    add-int/2addr v1, v0

    invoke-virtual {p0, v1}, Lio/dcloud/uts/nativeregex/JSRegexp;->setLastIndex(I)V

    :cond_6
    return-object p1
.end method

.method public final getBytecode()[B
    .locals 1

    .line 8
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->bytecode:[B

    return-object v0
.end method

.method public final getFlags()Ljava/lang/String;
    .locals 1

    .line 10
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    return-object v0
.end method

.method public final getLastIndex()I
    .locals 1

    .line 71
    iget v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->lastIndex:I

    return v0
.end method

.method public final getPattern()Ljava/lang/String;
    .locals 1

    .line 9
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->pattern:Ljava/lang/String;

    return-object v0
.end method

.method public final getSource()Ljava/lang/String;
    .locals 2

    .line 122
    sget-object v0, Lio/dcloud/uts/nativeregex/RegexpBridge;->INSTANCE:Lio/dcloud/uts/nativeregex/RegexpBridge;

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->pattern:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lio/dcloud/uts/nativeregex/RegexpBridge;->getSource(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final hasIndices()Z
    .locals 5

    .line 163
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x64

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isDotAll()Z
    .locals 5

    .line 143
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x73

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isGlobal()Z
    .locals 5

    .line 128
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x67

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isIgnoreCase()Z
    .locals 5

    .line 133
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x69

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isMultiline()Z
    .locals 5

    .line 138
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x6d

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isSticky()Z
    .locals 5

    .line 158
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x79

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isUnicode()Z
    .locals 5

    .line 148
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x75

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final isUnicodeSets()Z
    .locals 5

    .line 153
    iget-object v0, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/16 v3, 0x76

    const/4 v4, 0x0

    invoke-static {v0, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence;CZILjava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final setLastIndex(I)V
    .locals 0

    if-gez p1, :cond_0

    const/4 p1, 0x0

    .line 74
    iput p1, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->lastIndex:I

    return-void

    .line 76
    :cond_0
    iput p1, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->lastIndex:I

    return-void
.end method

.method public final test(Ljava/lang/String;)Z
    .locals 3

    const-string v0, "input"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 117
    invoke-static {p0, p1, v2, v0, v1}, Lio/dcloud/uts/nativeregex/JSRegexp;->exec$default(Lio/dcloud/uts/nativeregex/JSRegexp;Ljava/lang/String;IILjava/lang/Object;)Lio/dcloud/uts/RegExpExecArray;

    move-result-object p1

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    return v2
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 169
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->pattern:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v1, 0x2f

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lio/dcloud/uts/nativeregex/JSRegexp;->flags:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
