.class final Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UTSArray.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/coroutines/jvm/internal/SuspendLambda;",
        "Lkotlin/jvm/functions/Function2<",
        "Lkotlinx/coroutines/CoroutineScope;",
        "Lkotlin/coroutines/Continuation<",
        "-",
        "Lkotlin/Unit;",
        ">;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"
    }
    d2 = {
        "<anonymous>",
        "",
        "Lkotlinx/coroutines/CoroutineScope;"
    }
    k = 0x3
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0x30
.end annotation

.annotation runtime Lkotlin/coroutines/jvm/internal/DebugMetadata;
    c = "io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1"
    f = "UTSArray.kt"
    i = {
        0x0
    }
    l = {
        0x46
    }
    m = "invokeSuspend"
    n = {
        "promiseReal"
    }
    s = {
        "L$0"
    }
.end annotation


# instance fields
.field final synthetic $any:Ljava/lang/Object;

.field final synthetic $rejectParam:Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic $utsArray:Lio/dcloud/uts/UTSArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/dcloud/uts/UTSArray<",
            "TT;>;"
        }
    .end annotation
.end field

.field L$0:Ljava/lang/Object;

.field label:I


# direct methods
.method public static synthetic $r8$lambda$HL67td7NAQhZkQ48lCiwYFX5Na0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->invokeSuspend$lambda$0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method constructor <init>(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lio/dcloud/uts/UTSArray<",
            "TT;>;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$any:Ljava/lang/Object;

    iput-object p2, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$utsArray:Lio/dcloud/uts/UTSArray;

    iput-object p3, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$rejectParam:Lkotlin/jvm/functions/Function1;

    const/4 p1, 0x2

    invoke-direct {p0, p1, p4}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method

.method private static final invokeSuspend$lambda$0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;",
            "Ljava/lang/Object;",
            ")",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 68
    invoke-interface {p0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lkotlin/coroutines/Continuation<",
            "*>;)",
            "Lkotlin/coroutines/Continuation<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    new-instance p1, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;

    iget-object v0, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$any:Ljava/lang/Object;

    iget-object v1, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$utsArray:Lio/dcloud/uts/UTSArray;

    iget-object v2, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$rejectParam:Lkotlin/jvm/functions/Function1;

    invoke-direct {p1, v0, v1, v2, p2}, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;-><init>(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V

    check-cast p1, Lkotlin/coroutines/Continuation;

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invoke(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlinx/coroutines/CoroutineScope;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lkotlin/Unit;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object p1

    check-cast p1, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;

    sget-object p2, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {p1, p2}, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 66
    iget v1, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->label:I

    const/4 v2, 0x1

    if-eqz v1, :cond_1

    if-ne v1, v2, :cond_0

    iget-object v0, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->L$0:Ljava/lang/Object;

    check-cast v0, Lio/dcloud/uts/UTSPromise;

    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto :goto_0

    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_1
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    .line 67
    iget-object p1, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$any:Ljava/lang/Object;

    check-cast p1, Lio/dcloud/uts/UTSPromise;

    iget-object v1, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$rejectParam:Lkotlin/jvm/functions/Function1;

    new-instance v3, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1$$ExternalSyntheticLambda0;

    invoke-direct {v3, v1}, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V

    invoke-virtual {p1, v3}, Lio/dcloud/uts/UTSPromise;->catch(Lkotlin/jvm/functions/Function1;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    .line 70
    move-object v1, p0

    check-cast v1, Lkotlin/coroutines/Continuation;

    invoke-static {p1}, Lkotlin/coroutines/jvm/internal/SpillingKt;->nullOutSpilledVariable(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    iput-object v3, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->L$0:Ljava/lang/Object;

    iput v2, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->label:I

    invoke-static {p1, v1}, Lio/dcloud/uts/UTSPromiseHelperKt;->await(Lio/dcloud/uts/UTSPromise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    if-ne p1, v0, :cond_2

    return-object v0

    .line 71
    :cond_2
    :goto_0
    iget-object v0, p0, Lio/dcloud/uts/UTSArray$Companion$fromAsync$p$1$1$1$1;->$utsArray:Lio/dcloud/uts/UTSArray;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    .line 72
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method
