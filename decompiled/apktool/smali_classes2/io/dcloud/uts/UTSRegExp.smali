.class public final Lio/dcloud/uts/UTSRegExp;
.super Ljava/lang/Object;
.source "UTSRegExp2.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\u0008\u0016\u00a2\u0006\u0004\u0008\u0002\u0010\u0003B\u0011\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\u0008\u0002\u0010\u0006B\u0019\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\u0008\u0002\u0010\u0008B\u0011\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0000\u00a2\u0006\u0004\u0008\u0002\u0010\nJ\u0006\u0010\u001f\u001a\u00020\u0005J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0005J\u0008\u0010/\u001a\u00020\u0005H\u0016J\u0006\u00100\u001a\u000201R\u0011\u0010\u000b\u001a\u00020\u000c\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0012R\u0011\u0010 \u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\u0008#\u0010\"R$\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%8F@FX\u0086\u000e\u00a2\u0006\u000c\u001a\u0004\u0008\'\u0010(\"\u0004\u0008)\u0010*\u00a8\u00062"
    }
    d2 = {
        "Lio/dcloud/uts/UTSRegExp;",
        "",
        "<init>",
        "()V",
        "source",
        "",
        "(Ljava/lang/String;)V",
        "mode",
        "(Ljava/lang/String;Ljava/lang/String;)V",
        "reg",
        "(Lio/dcloud/uts/UTSRegExp;)V",
        "hostJSRegexp",
        "Lio/dcloud/uts/nativeregex/JSRegexp;",
        "getHostJSRegexp",
        "()Lio/dcloud/uts/nativeregex/JSRegexp;",
        "global",
        "",
        "getGlobal",
        "()Z",
        "dotAll",
        "getDotAll",
        "ignoreCase",
        "getIgnoreCase",
        "multiline",
        "getMultiline",
        "hasIndices",
        "getHasIndices",
        "sticky",
        "getSticky",
        "unicode",
        "getUnicode",
        "getQuickJSFlags",
        "flags",
        "getFlags",
        "()Ljava/lang/String;",
        "getSource",
        "value",
        "",
        "lastIndex",
        "getLastIndex",
        "()I",
        "setLastIndex",
        "(I)V",
        "exec",
        "Lio/dcloud/uts/RegExpExecArray;",
        "input",
        "test",
        "toString",
        "toRegex",
        "Lkotlin/text/Regex;",
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
.field private final hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    sget-object v0, Lio/dcloud/uts/nativeregex/JSRegexp;->Companion:Lio/dcloud/uts/nativeregex/JSRegexp$Companion;

    const-string v1, "(?:)"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;->create(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/uts/nativeregex/JSRegexp;

    move-result-object v0

    iput-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    return-void
.end method

.method public constructor <init>(Lio/dcloud/uts/UTSRegExp;)V
    .locals 1

    const-string v0, "reg"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iget-object p1, p1, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    iput-object p1, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    sget-object v0, Lio/dcloud/uts/nativeregex/JSRegexp;->Companion:Lio/dcloud/uts/nativeregex/JSRegexp$Companion;

    const-string v1, ""

    invoke-virtual {v0, p1, v1}, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;->create(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/uts/nativeregex/JSRegexp;

    move-result-object p1

    iput-object p1, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "mode"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    sget-object v0, Lio/dcloud/uts/nativeregex/JSRegexp;->Companion:Lio/dcloud/uts/nativeregex/JSRegexp$Companion;

    invoke-virtual {v0, p1, p2}, Lio/dcloud/uts/nativeregex/JSRegexp$Companion;->create(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/uts/nativeregex/JSRegexp;

    move-result-object p1

    iput-object p1, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    return-void
.end method


# virtual methods
.method public final exec(Ljava/lang/String;)Lio/dcloud/uts/RegExpExecArray;
    .locals 4

    const-string v0, "input"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 143
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static {v0, p1, v3, v1, v2}, Lio/dcloud/uts/nativeregex/JSRegexp;->exec$default(Lio/dcloud/uts/nativeregex/JSRegexp;Ljava/lang/String;IILjava/lang/Object;)Lio/dcloud/uts/RegExpExecArray;

    move-result-object p1

    return-object p1
.end method

.method public final getDotAll()Z
    .locals 1

    .line 69
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->isDotAll()Z

    move-result v0

    return v0
.end method

.method public final getFlags()Ljava/lang/String;
    .locals 1

    .line 123
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getQuickJSFlags()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getGlobal()Z
    .locals 1

    .line 65
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->isGlobal()Z

    move-result v0

    return v0
.end method

.method public final getHasIndices()Z
    .locals 1

    .line 84
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->hasIndices()Z

    move-result v0

    return v0
.end method

.method public final getHostJSRegexp()Lio/dcloud/uts/nativeregex/JSRegexp;
    .locals 1

    .line 42
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    return-object v0
.end method

.method public final getIgnoreCase()Z
    .locals 1

    .line 74
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->isIgnoreCase()Z

    move-result v0

    return v0
.end method

.method public final getLastIndex()I
    .locals 1

    .line 133
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->getLastIndex()I

    move-result v0

    return v0
.end method

.method public final getMultiline()Z
    .locals 1

    .line 79
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->isMultiline()Z

    move-result v0

    return v0
.end method

.method public final getQuickJSFlags()Ljava/lang/String;
    .locals 2

    .line 104
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 107
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getHasIndices()Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 109
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getGlobal()Z

    move-result v1

    if-eqz v1, :cond_1

    const/16 v1, 0x67

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 110
    :cond_1
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getIgnoreCase()Z

    move-result v1

    if-eqz v1, :cond_2

    const/16 v1, 0x69

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 111
    :cond_2
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getMultiline()Z

    move-result v1

    if-eqz v1, :cond_3

    const/16 v1, 0x6d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 112
    :cond_3
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getDotAll()Z

    move-result v1

    if-eqz v1, :cond_4

    const/16 v1, 0x73

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 113
    :cond_4
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getUnicode()Z

    move-result v1

    if-eqz v1, :cond_5

    const/16 v1, 0x75

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 116
    :cond_5
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRegExp;->getSticky()Z

    move-result v1

    if-eqz v1, :cond_6

    const/16 v1, 0x79

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 118
    :cond_6
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "toString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public final getSource()Ljava/lang/String;
    .locals 1

    .line 128
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->getSource()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getSticky()Z
    .locals 1

    .line 91
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->isSticky()Z

    move-result v0

    return v0
.end method

.method public final getUnicode()Z
    .locals 1

    .line 96
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->isUnicode()Z

    move-result v0

    return v0
.end method

.method public final setLastIndex(I)V
    .locals 1

    .line 136
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/nativeregex/JSRegexp;->setLastIndex(I)V

    return-void
.end method

.method public final test(Ljava/lang/String;)Z
    .locals 1

    const-string v0, "input"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 147
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/nativeregex/JSRegexp;->test(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method public final toRegex()Lkotlin/text/Regex;
    .locals 3

    .line 158
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    .line 161
    iget-object v1, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v1}, Lio/dcloud/uts/nativeregex/JSRegexp;->isIgnoreCase()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 163
    sget-object v1, Lkotlin/text/RegexOption;->IGNORE_CASE:Lkotlin/text/RegexOption;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 166
    :cond_0
    iget-object v1, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v1}, Lio/dcloud/uts/nativeregex/JSRegexp;->isMultiline()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 168
    sget-object v1, Lkotlin/text/RegexOption;->MULTILINE:Lkotlin/text/RegexOption;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 171
    :cond_1
    iget-object v1, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v1}, Lio/dcloud/uts/nativeregex/JSRegexp;->isDotAll()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 173
    sget-object v1, Lkotlin/text/RegexOption;->DOT_MATCHES_ALL:Lkotlin/text/RegexOption;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 177
    :cond_2
    new-instance v1, Lkotlin/text/Regex;

    iget-object v2, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v2}, Lio/dcloud/uts/nativeregex/JSRegexp;->getSource()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;Ljava/util/Set;)V

    return-object v1
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .line 152
    iget-object v0, p0, Lio/dcloud/uts/UTSRegExp;->hostJSRegexp:Lio/dcloud/uts/nativeregex/JSRegexp;

    invoke-virtual {v0}, Lio/dcloud/uts/nativeregex/JSRegexp;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
