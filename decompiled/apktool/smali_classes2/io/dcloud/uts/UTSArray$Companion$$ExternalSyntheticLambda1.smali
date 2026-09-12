.class public final synthetic Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# instance fields
.field public final synthetic f$0:Lkotlinx/coroutines/CoroutineScope;

.field public final synthetic f$1:Ljava/lang/Iterable;

.field public final synthetic f$2:Lkotlin/jvm/functions/Function2;


# direct methods
.method public synthetic constructor <init>(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;->f$0:Lkotlinx/coroutines/CoroutineScope;

    iput-object p2, p0, Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;->f$1:Ljava/lang/Iterable;

    iput-object p3, p0, Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;->f$2:Lkotlin/jvm/functions/Function2;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3

    .line 0
    iget-object v0, p0, Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;->f$0:Lkotlinx/coroutines/CoroutineScope;

    iget-object v1, p0, Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;->f$1:Ljava/lang/Iterable;

    iget-object v2, p0, Lio/dcloud/uts/UTSArray$Companion$$ExternalSyntheticLambda1;->f$2:Lkotlin/jvm/functions/Function2;

    check-cast p1, Lkotlin/jvm/functions/Function1;

    check-cast p2, Lkotlin/jvm/functions/Function1;

    invoke-static {v0, v1, v2, p1, p2}, Lio/dcloud/uts/UTSArray$Companion;->$r8$lambda$tGRgzqN8P5NfDSSV2c8d5A5MTf0(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;

    move-result-object p1

    return-object p1
.end method
