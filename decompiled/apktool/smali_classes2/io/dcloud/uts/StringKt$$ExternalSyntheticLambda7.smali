.class public final synthetic Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic f$0:Z

.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$BooleanRef;

.field public final synthetic f$2:Lio/dcloud/uts/UTSRegExp;

.field public final synthetic f$3:Lkotlin/jvm/functions/Function4;

.field public final synthetic f$4:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(ZLkotlin/jvm/internal/Ref$BooleanRef;Lio/dcloud/uts/UTSRegExp;Lkotlin/jvm/functions/Function4;Ljava/lang/String;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$0:Z

    iput-object p2, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$1:Lkotlin/jvm/internal/Ref$BooleanRef;

    iput-object p3, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$2:Lio/dcloud/uts/UTSRegExp;

    iput-object p4, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$3:Lkotlin/jvm/functions/Function4;

    iput-object p5, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$4:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    .line 0
    iget-boolean v0, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$0:Z

    iget-object v1, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$1:Lkotlin/jvm/internal/Ref$BooleanRef;

    iget-object v2, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$2:Lio/dcloud/uts/UTSRegExp;

    iget-object v3, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$3:Lkotlin/jvm/functions/Function4;

    iget-object v4, p0, Lio/dcloud/uts/StringKt$$ExternalSyntheticLambda7;->f$4:Ljava/lang/String;

    move-object v5, p1

    check-cast v5, Lkotlin/text/MatchResult;

    invoke-static/range {v0 .. v5}, Lio/dcloud/uts/StringKt;->$r8$lambda$A7GtP5wHtdgOJIBAe5jsiZjIyL8(ZLkotlin/jvm/internal/Ref$BooleanRef;Lio/dcloud/uts/UTSRegExp;Lkotlin/jvm/functions/Function4;Ljava/lang/String;Lkotlin/text/MatchResult;)Ljava/lang/CharSequence;

    move-result-object p1

    return-object p1
.end method
