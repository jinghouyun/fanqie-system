.class public final synthetic Lio/dcloud/uts/UTSKeyIterable$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# instance fields
.field public final synthetic f$0:Ljava/util/Iterator;


# direct methods
.method public synthetic constructor <init>(Ljava/util/Iterator;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/dcloud/uts/UTSKeyIterable$$ExternalSyntheticLambda0;->f$0:Ljava/util/Iterator;

    return-void
.end method


# virtual methods
.method public final invoke()Ljava/lang/Object;
    .locals 1

    .line 0
    iget-object v0, p0, Lio/dcloud/uts/UTSKeyIterable$$ExternalSyntheticLambda0;->f$0:Ljava/util/Iterator;

    invoke-static {v0}, Lio/dcloud/uts/UTSKeyIterable$-CC;->keyIterator$lambda$2(Ljava/util/Iterator;)Lio/dcloud/uts/UTSIteratorResult;

    move-result-object v0

    return-object v0
.end method
