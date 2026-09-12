.class public final Lio/dcloud/uts/UTSPromise$Companion;
.super Ljava/lang/Object;
.source "UTSPromise.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/uts/UTSPromise;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUTSPromise.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UTSPromise.kt\nio/dcloud/uts/UTSPromise$Companion\n+ 2 UTSArray.kt\nio/dcloud/uts/UTSArrayKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,496:1\n39#2:497\n39#2:500\n39#2:501\n39#2:504\n39#2:505\n39#2:508\n1869#3,2:498\n1869#3,2:502\n1869#3,2:506\n*S KotlinDebug\n*F\n+ 1 UTSPromise.kt\nio/dcloud/uts/UTSPromise$Companion\n*L\n211#1:497\n279#1:500\n282#1:501\n287#1:504\n318#1:505\n367#1:508\n218#1:498,2\n283#1:502,2\n325#1:506,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005J\u001f\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\u0006\u0010\u0008\u001a\u0002H\u0007\u00a2\u0006\u0002\u0010\tJ \u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005J\u001e\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0001J\u001e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0001J,\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u000e0\u0005\"\u0004\u0008\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ\u001e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u000eJ&\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ\u001e\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u000eJ&\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ\u001e\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\u0008\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u000eJ2\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u00160\u000e0\u0005\"\u0004\u0008\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ*\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\u00160\u000e0\u0005\"\u0004\u0008\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u000eJ\u0012\u0010\u0018\u001a\u00020\u00062\n\u0010\u0019\u001a\u0006\u0012\u0002\u0008\u00030\u001aJ\u0010\u0010\u001b\u001a\u00020\u00062\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u001d"
    }
    d2 = {
        "Lio/dcloud/uts/UTSPromise$Companion;",
        "",
        "<init>",
        "()V",
        "resolve",
        "Lio/dcloud/uts/UTSPromise;",
        "",
        "T",
        "value",
        "(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;",
        "resolve_origin",
        "_resolve",
        "reject",
        "all",
        "Lio/dcloud/uts/UTSArray;",
        "arr",
        "all_origin",
        "race",
        "race_origin",
        "any",
        "any_origin",
        "allSettled",
        "Lio/dcloud/uts/UTSPromiseSettledResult;",
        "allSettled_origin",
        "_immediateFn",
        "fn",
        "Lkotlin/Function;",
        "_unhandledRejectionFn",
        "err",
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


# direct methods
.method public static synthetic $r8$lambda$2ci8tK8OshsWv2nzuYjd_LGkCxQ(Ljava/lang/Number;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2, p3, p4}, Lio/dcloud/uts/UTSPromise$Companion;->allSettled_origin$lambda$17$res$15$lambda$13(Ljava/lang/Number;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Object;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$C2arSpF6e-Jw825yye6iCmqLjZM(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion;->_resolve$lambda$0(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$D2WwPnwD7IM_l2hdw5YPV-ITyRg(Ljava/lang/Number;Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0

    invoke-static/range {p0 .. p5}, Lio/dcloud/uts/UTSPromise$Companion;->all_origin$lambda$5$res$lambda$3(Ljava/lang/Number;Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$GQ1n3e2yAlVYzQZEDHlrffCMmQ8(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2, p3, p4}, Lio/dcloud/uts/UTSPromise$Companion;->allSettled_origin$lambda$17$res$15$lambda$14(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Object;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$JIxrAtHqfZu4aUVmL--zhtgKNgQ(Lkotlin/Function;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0}, Lio/dcloud/uts/UTSPromise$Companion;->_immediateFn$lambda$18(Lkotlin/Function;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$KQ23jIbdtdtJCeZdT_2t0J48fLI(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion;->all_origin$lambda$5(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$V4hHHbit1Ycr698Rm5XIfN4cwNc(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion;->any_origin$lambda$11(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$mll20SNo8tDukx3r7qwmFsMiuhk(Lio/dcloud/uts/UTSArray;Lkotlin/Function;Lkotlin/Function;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion;->allSettled_origin$lambda$17(Lio/dcloud/uts/UTSArray;Lkotlin/Function;Lkotlin/Function;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$p-L_8QprV3F6-UXxgjHJTZcV8ok(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion;->reject$lambda$1(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$q754oAQ7VzTefynSVEZ_o8a3ZrQ(Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lio/dcloud/uts/UTSPromise$Companion;->any_origin$lambda$11$lambda$10$lambda$9(Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$yw4IZ9n9RwwBVHfKhmqJBc5WlqQ(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion;->race_origin$lambda$7(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method private constructor <init>()V
    .locals 0

    .line 174
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/uts/UTSPromise$Companion;-><init>()V

    return-void
.end method

.method private static final _immediateFn$lambda$18(Lkotlin/Function;)Lkotlin/Unit;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Function<",
            "*>;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 508
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 367
    invoke-static {p0, v0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 368
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private final _resolve(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            ")",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    if-eqz p1, :cond_0

    .line 188
    instance-of v0, p1, Lio/dcloud/uts/UTSPromise;

    if-eqz v0, :cond_0

    .line 189
    check-cast p1, Lio/dcloud/uts/UTSPromise;

    return-object p1

    .line 191
    :cond_0
    new-instance v0, Lio/dcloud/uts/UTSPromise;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda3;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda3;-><init>(Ljava/lang/Object;)V

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSPromise;-><init>(Lkotlin/jvm/functions/Function2;)V

    return-object v0
.end method

.method private static final _resolve$lambda$0(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Lkotlin/jvm/functions/Function1<",
            "-TT;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    const/4 p2, 0x1

    .line 193
    new-array p2, p2, [Ljava/lang/Object;

    const/4 v0, 0x0

    aput-object p0, p2, v0

    .line 192
    invoke-static {p2}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p1, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 195
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method public static final synthetic access$_resolve(Lio/dcloud/uts/UTSPromise$Companion;Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 0

    .line 174
    invoke-direct {p0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->_resolve(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object p0

    return-object p0
.end method

.method private static final allSettled_origin$lambda$17(Lio/dcloud/uts/UTSArray;Lkotlin/Function;Lkotlin/Function;)Lkotlin/Unit;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;",
            "Lkotlin/Function<",
            "*>;",
            "Lkotlin/Function<",
            "*>;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 505
    new-instance p2, Lio/dcloud/uts/UTSArray;

    invoke-direct {p2}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 319
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v3, 0x1

    if-eqz v0, :cond_0

    .line 321
    new-array p0, v3, [Ljava/lang/Object;

    aput-object p2, p0, v1

    .line 320
    invoke-static {p0}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p1, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 323
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0

    .line 325
    :cond_0
    check-cast p0, Ljava/lang/Iterable;

    .line 506
    invoke-interface {p0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_0
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .line 326
    new-array v4, v3, [Ljava/lang/Object;

    aput-object v0, v4, v1

    invoke-virtual {p2, v4}, Lio/dcloud/uts/UTSArray;->push([Ljava/lang/Object;)I

    goto :goto_0

    .line 329
    :cond_1
    new-instance p0, Lkotlin/jvm/internal/Ref$ObjectRef;

    invoke-direct {p0}, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V

    invoke-virtual {p2}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v0

    iput-object v0, p0, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    .line 355
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    .line 356
    check-cast v2, Ljava/lang/Number;

    .line 357
    :goto_1
    invoke-virtual {p2}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v0

    invoke-static {v2, v0}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v0

    if-gez v0, :cond_2

    .line 358
    move-object v0, v2

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p2, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-static {p2, p0, p1, v2, v0}, Lio/dcloud/uts/UTSPromise$Companion;->allSettled_origin$lambda$17$res$15(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Number;Ljava/lang/Object;)V

    .line 359
    invoke-virtual {v2}, Ljava/lang/Number;->intValue()I

    move-result v0

    add-int/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Ljava/lang/Number;

    goto :goto_1

    .line 362
    :cond_2
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final allSettled_origin$lambda$17$res$15(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Number;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "Ljava/lang/Number;",
            ">;",
            "Lkotlin/Function<",
            "*>;",
            "Ljava/lang/Number;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    if-eqz p4, :cond_0

    .line 332
    instance-of v0, p4, Lio/dcloud/uts/UTSPromise;

    if-eqz v0, :cond_0

    .line 333
    check-cast p4, Lio/dcloud/uts/UTSPromise;

    new-instance v0, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda10;

    invoke-direct {v0, p3, p0, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda10;-><init>(Ljava/lang/Number;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;)V

    check-cast v0, Lkotlin/Function;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda1;

    invoke-direct {v1, p0, p3, p1, p2}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda1;-><init>(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;)V

    check-cast v1, Lkotlin/Function;

    invoke-static {p4, v0, v1}, Lio/dcloud/uts/UTSPromise;->access$_then(Lio/dcloud/uts/UTSPromise;Lkotlin/Function;Lkotlin/Function;)Lio/dcloud/uts/UTSPromise;

    return-void

    .line 348
    :cond_0
    const-string v0, "null cannot be cast to non-null type kotlin.Int"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p3, Ljava/lang/Integer;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    new-instance v0, Lio/dcloud/uts/UTSPromiseFulfilledResultImpl;

    invoke-direct {v0, p4}, Lio/dcloud/uts/UTSPromiseFulfilledResultImpl;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p0, p3, v0}, Lio/dcloud/uts/UTSArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 349
    iget-object p3, p1, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    check-cast p3, Ljava/lang/Number;

    invoke-static {p3}, Lio/dcloud/uts/NumberKt;->dec(Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p3

    iput-object p3, p1, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    iget-object p1, p1, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    const/4 p3, 0x0

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p4

    invoke-static {p1, p4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_1

    const/4 p1, 0x1

    .line 351
    new-array p1, p1, [Ljava/lang/Object;

    aput-object p0, p1, p3

    .line 350
    invoke-static {p1}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p2, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    :cond_1
    return-void
.end method

.method private static final allSettled_origin$lambda$17$res$15$lambda$13(Ljava/lang/Number;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Number;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "Ljava/lang/Number;",
            ">;",
            "Lkotlin/Function<",
            "*>;",
            "Ljava/lang/Object;",
            ")",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 334
    invoke-static {p1, p2, p3, p0, p4}, Lio/dcloud/uts/UTSPromise$Companion;->allSettled_origin$lambda$17$res$15(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Number;Ljava/lang/Object;)V

    .line 335
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final allSettled_origin$lambda$17$res$15$lambda$14(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/Function;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Number;",
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "Ljava/lang/Number;",
            ">;",
            "Lkotlin/Function<",
            "*>;",
            "Ljava/lang/Object;",
            ")",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 337
    const-string v0, "null cannot be cast to non-null type kotlin.Int"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    new-instance v0, Lio/dcloud/uts/UTSPromiseRejectedResultImpl;

    invoke-direct {v0, p4}, Lio/dcloud/uts/UTSPromiseRejectedResultImpl;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p0, p1, v0}, Lio/dcloud/uts/UTSArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 338
    iget-object p1, p2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    check-cast p1, Ljava/lang/Number;

    invoke-static {p1}, Lio/dcloud/uts/NumberKt;->dec(Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p1

    iput-object p1, p2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    iget-object p1, p2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    const/4 p2, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p4

    invoke-static {p1, p4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    .line 340
    new-array p1, p1, [Ljava/lang/Object;

    aput-object p0, p1, p2

    .line 339
    invoke-static {p1}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p3, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 343
    :cond_0
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final all_origin$lambda$5(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;",
            "Lkotlin/jvm/functions/Function1<",
            "-TT;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 497
    new-instance v1, Lio/dcloud/uts/UTSArray;

    invoke-direct {v1}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 212
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v0

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v6, 0x1

    if-eqz v0, :cond_0

    .line 214
    new-array p0, v6, [Ljava/lang/Object;

    aput-object v1, p0, v2

    .line 213
    invoke-static {p0}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p1, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 216
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0

    .line 218
    :cond_0
    check-cast p0, Ljava/lang/Iterable;

    .line 498
    invoke-interface {p0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_0
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .line 219
    new-array v4, v6, [Ljava/lang/Object;

    aput-object v0, v4, v2

    invoke-virtual {v1, v4}, Lio/dcloud/uts/UTSArray;->push([Ljava/lang/Object;)I

    goto :goto_0

    .line 222
    :cond_1
    new-instance v2, Lkotlin/jvm/internal/Ref$ObjectRef;

    invoke-direct {v2}, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V

    invoke-virtual {v1}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object p0

    iput-object p0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    .line 247
    sget-object p0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    .line 248
    check-cast v3, Ljava/lang/Number;

    move-object v4, v3

    .line 249
    :goto_1
    invoke-virtual {v1}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object p0

    invoke-static {v4, p0}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result p0

    if-gez p0, :cond_2

    .line 250
    move-object p0, v4

    check-cast p0, Ljava/lang/Integer;

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    invoke-virtual {v1, p0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    move-object v3, p1

    move-object v0, p2

    invoke-static/range {v0 .. v5}, Lio/dcloud/uts/UTSPromise$Companion;->all_origin$lambda$5$res(Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;Ljava/lang/Number;Ljava/lang/Object;)V

    .line 251
    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result p0

    add-int/2addr p0, v6

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    move-object v4, p0

    check-cast v4, Ljava/lang/Number;

    goto :goto_1

    .line 254
    :cond_2
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final all_origin$lambda$5$res(Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;Ljava/lang/Number;Ljava/lang/Object;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "Ljava/lang/Number;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "-TT;",
            "Lkotlin/Unit;",
            ">;",
            "Ljava/lang/Number;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p5, :cond_0

    .line 226
    :try_start_0
    instance-of v0, p5, Lio/dcloud/uts/UTSPromise;

    if-eqz v0, :cond_0

    .line 227
    check-cast p5, Lio/dcloud/uts/UTSPromise;

    new-instance v3, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda8;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v5, p0

    move-object v6, p1

    move-object v7, p2

    move-object v8, p3

    move-object v4, p4

    :try_start_1
    invoke-direct/range {v3 .. v8}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda8;-><init>(Ljava/lang/Number;Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;)V

    check-cast v3, Lkotlin/Function;

    .line 230
    move-object p0, v5

    check-cast p0, Lkotlin/Function;

    .line 227
    invoke-static {p5, v3, p0}, Lio/dcloud/uts/UTSPromise;->access$_then(Lio/dcloud/uts/UTSPromise;Lkotlin/Function;Lkotlin/Function;)Lio/dcloud/uts/UTSPromise;

    return-void

    :catchall_0
    move-exception v0

    move-object v5, p0

    goto :goto_0

    :cond_0
    move-object v5, p0

    move-object v6, p1

    move-object v7, p2

    move-object v8, p3

    move-object v4, p4

    .line 234
    const-string p0, "null cannot be cast to non-null type kotlin.Int"

    invoke-static {v4, p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object p4, v4

    check-cast p4, Ljava/lang/Integer;

    invoke-virtual {p4}, Ljava/lang/Integer;->intValue()I

    move-result p0

    invoke-virtual {v6, p0, p5}, Lio/dcloud/uts/UTSArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 235
    iget-object p0, v7, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    check-cast p0, Ljava/lang/Number;

    invoke-static {p0}, Lio/dcloud/uts/NumberKt;->dec(Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object p0

    iput-object p0, v7, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    iget-object p0, v7, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_1

    .line 237
    new-array p0, v1, [Ljava/lang/Object;

    aput-object v6, p0, v2

    .line 236
    invoke-static {p0}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {v8, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :cond_1
    return-void

    :catchall_1
    move-exception v0

    :goto_0
    move-object p0, v0

    .line 243
    new-array p1, v1, [Ljava/lang/Object;

    aput-object p0, p1, v2

    .line 242
    invoke-static {p1}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {v5, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    return-void
.end method

.method private static final all_origin$lambda$5$res$lambda$3(Ljava/lang/Number;Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Number;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Lkotlin/jvm/internal/Ref$ObjectRef<",
            "Ljava/lang/Number;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "-TT;",
            "Lkotlin/Unit;",
            ">;",
            "Ljava/lang/Object;",
            ")",
            "Lkotlin/Unit;"
        }
    .end annotation

    move-object v0, p4

    move-object p4, p0

    move-object p0, p1

    move-object p1, p2

    move-object p2, p3

    move-object p3, v0

    .line 228
    invoke-static/range {p0 .. p5}, Lio/dcloud/uts/UTSPromise$Companion;->all_origin$lambda$5$res(Lkotlin/jvm/functions/Function1;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/internal/Ref$ObjectRef;Lkotlin/jvm/functions/Function1;Ljava/lang/Number;Ljava/lang/Object;)V

    .line 229
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final any_origin$lambda$11(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;",
            "Lkotlin/jvm/functions/Function1<",
            "-TT;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 278
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 500
    new-instance p0, Lio/dcloud/uts/UTSArray;

    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 279
    invoke-static {p2, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 280
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0

    .line 501
    :cond_0
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 283
    check-cast p0, Ljava/lang/Iterable;

    .line 502
    invoke-interface {p0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_0
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    const/4 v4, 0x1

    if-eqz v3, :cond_1

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 284
    new-array v4, v4, [Ljava/lang/Object;

    aput-object v3, v4, v1

    invoke-virtual {v0, v4}, Lio/dcloud/uts/UTSArray;->push([Ljava/lang/Object;)I

    goto :goto_0

    .line 504
    :cond_1
    new-instance p0, Lio/dcloud/uts/UTSArray;

    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 288
    sget-object v3, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    .line 289
    check-cast v2, Ljava/lang/Number;

    .line 290
    :goto_1
    invoke-virtual {v0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v3

    invoke-static {v2, v3}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v3

    if-gez v3, :cond_2

    .line 292
    :try_start_0
    sget-object v3, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    const-string v5, "null cannot be cast to non-null type kotlin.Int"

    invoke-static {v2, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v5, v2

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v0, v5}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-direct {v3, v5}, Lio/dcloud/uts/UTSPromise$Companion;->_resolve(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object v3

    move-object v5, p1

    check-cast v5, Lkotlin/Function;

    const/4 v6, 0x2

    const/4 v7, 0x0

    invoke-static {v3, v5, v7, v6, v7}, Lio/dcloud/uts/UTSPromise;->_then$default(Lio/dcloud/uts/UTSPromise;Lkotlin/Function;Lkotlin/Function;ILjava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object v3

    new-instance v5, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda6;

    invoke-direct {v5, p0, v0, p2}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda6;-><init>(Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;)V

    check-cast v5, Lkotlin/Function;

    invoke-static {v3, v5}, Lio/dcloud/uts/UTSPromise;->access$_catch(Lio/dcloud/uts/UTSPromise;Lkotlin/Function;)Lio/dcloud/uts/UTSPromise;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    :catchall_0
    move-exception v3

    .line 304
    new-array v5, v4, [Ljava/lang/Object;

    aput-object v3, v5, v1

    .line 303
    invoke-static {v5}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object v3

    invoke-static {p2, v3}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 307
    :goto_2
    invoke-static {v2}, Lio/dcloud/uts/NumberKt;->inc(Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object v2

    goto :goto_1

    .line 310
    :cond_2
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final any_origin$lambda$11$lambda$10$lambda$9(Lio/dcloud/uts/UTSArray;Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/Unit;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;",
            "Ljava/lang/Object;",
            ")",
            "Lkotlin/Unit;"
        }
    .end annotation

    const/4 v0, 0x1

    .line 293
    new-array v1, v0, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p3, v1, v2

    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->push([Ljava/lang/Object;)I

    .line 294
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object p3

    invoke-virtual {p1}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object p1

    invoke-static {p3, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    .line 296
    new-instance p1, Lio/dcloud/uts/UTSPromiseAggregateError;

    const-string p3, "All promises were rejected"

    invoke-direct {p1, p0, p3}, Lio/dcloud/uts/UTSPromiseAggregateError;-><init>(Ljava/lang/Object;Ljava/lang/String;)V

    new-array p0, v0, [Ljava/lang/Object;

    aput-object p1, p0, v2

    .line 295
    invoke-static {p0}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p2, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 299
    :cond_0
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final race_origin$lambda$7(Lio/dcloud/uts/UTSArray;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;",
            "Lkotlin/jvm/functions/Function1<",
            "-TT;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    .line 262
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    const/4 v0, 0x0

    .line 263
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    .line 264
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v1

    .line 265
    :goto_0
    invoke-static {v0, v1}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v2

    if-gez v2, :cond_0

    .line 266
    sget-object v2, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    move-object v3, v0

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {p0, v3}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-direct {v2, v3}, Lio/dcloud/uts/UTSPromise$Companion;->_resolve(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object v2

    move-object v3, p1

    check-cast v3, Lkotlin/Function;

    move-object v4, p2

    check-cast v4, Lkotlin/Function;

    invoke-static {v2, v3, v4}, Lio/dcloud/uts/UTSPromise;->access$_then(Lio/dcloud/uts/UTSPromise;Lkotlin/Function;Lkotlin/Function;)Lio/dcloud/uts/UTSPromise;

    .line 267
    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    goto :goto_0

    .line 270
    :cond_0
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method public static synthetic reject$default(Lio/dcloud/uts/UTSPromise$Companion;Ljava/lang/Object;ILjava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 0

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_0

    const/4 p1, 0x0

    .line 198
    :cond_0
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->reject(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object p0

    return-object p0
.end method

.method private static final reject$lambda$1(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lkotlin/Unit;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    const/4 p1, 0x1

    .line 201
    new-array p1, p1, [Ljava/lang/Object;

    const/4 v0, 0x0

    aput-object p0, p1, v0

    .line 200
    invoke-static {p1}, Lio/dcloud/uts/UTSArrayKt;->utsArrayOf([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    invoke-static {p2, p0}, Lio/dcloud/uts/UTSPromiseKt;->callFunction(Ljava/lang/Object;Lio/dcloud/uts/UTSArray;)Ljava/lang/Object;

    .line 203
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method public static synthetic resolve_origin$default(Lio/dcloud/uts/UTSPromise$Companion;Ljava/lang/Object;ILjava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 0

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_0

    const/4 p1, 0x0

    .line 184
    :cond_0
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->resolve_origin(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final _immediateFn(Lkotlin/Function;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Function<",
            "*>;)V"
        }
    .end annotation

    const-string v0, "fn"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 366
    new-instance v0, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda5;

    invoke-direct {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda5;-><init>(Lkotlin/Function;)V

    const/4 p1, 0x0

    .line 369
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    .line 366
    invoke-static {v0, p1}, Lio/dcloud/uts/UTSTimerKt;->setTimeout(Lkotlin/jvm/functions/Function0;Ljava/lang/Number;)Ljava/lang/Number;

    return-void
.end method

.method public final _unhandledRejectionFn(Ljava/lang/Object;)V
    .locals 3

    const/4 v0, 0x2

    .line 372
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    const-string v2, "Possible Unhandled Promise Rejection:"

    aput-object v2, v0, v1

    const/4 v2, 0x1

    aput-object p1, v0, v2

    invoke-static {v0}, Lio/dcloud/uts/console;->warn([Ljava/lang/Object;)V

    .line 373
    instance-of v0, p1, Ljava/lang/Throwable;

    if-eqz v0, :cond_0

    .line 378
    sget-object v0, Lio/dcloud/uts/console;->INSTANCE:Lio/dcloud/uts/console;

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v1

    invoke-virtual {v0, v2}, Lio/dcloud/uts/console;->errorV1WithStack([Ljava/lang/Object;)V

    :cond_0
    return-void
.end method

.method public final all(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "Lio/dcloud/uts/UTSArray<",
            "TT;>;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 207
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->all_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method

.method public final allSettled(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "Lio/dcloud/uts/UTSArray<",
            "Lio/dcloud/uts/UTSPromiseSettledResult<",
            "TT;>;>;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 314
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->allSettled_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method

.method public final allSettled_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "Lio/dcloud/uts/UTSArray<",
            "Lio/dcloud/uts/UTSPromiseSettledResult<",
            "TT;>;>;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 317
    new-instance v0, Lio/dcloud/uts/UTSPromise;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda4;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda4;-><init>(Lio/dcloud/uts/UTSArray;)V

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSPromise;-><init>(Lkotlin/jvm/functions/Function2;)V

    return-object v0
.end method

.method public final all_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 210
    new-instance v0, Lio/dcloud/uts/UTSPromise;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda2;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda2;-><init>(Lio/dcloud/uts/UTSArray;)V

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSPromise;-><init>(Lkotlin/jvm/functions/Function2;)V

    return-object v0
.end method

.method public final any(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 274
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->any_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method

.method public final any_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 277
    new-instance v0, Lio/dcloud/uts/UTSPromise;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda7;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda7;-><init>(Lio/dcloud/uts/UTSArray;)V

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSPromise;-><init>(Lkotlin/jvm/functions/Function2;)V

    return-object v0
.end method

.method public final race(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 258
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->race_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method

.method public final race_origin(Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSPromise;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "arr"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 261
    new-instance v0, Lio/dcloud/uts/UTSPromise;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda0;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda0;-><init>(Lio/dcloud/uts/UTSArray;)V

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSPromise;-><init>(Lkotlin/jvm/functions/Function2;)V

    return-object v0
.end method

.method public final reject(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Lio/dcloud/uts/UTSPromise<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    .line 199
    new-instance v0, Lio/dcloud/uts/UTSPromise;

    new-instance v1, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda9;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSPromise$Companion$$ExternalSyntheticLambda9;-><init>(Ljava/lang/Object;)V

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSPromise;-><init>(Lkotlin/jvm/functions/Function2;)V

    return-object v0
.end method

.method public final resolve()Lio/dcloud/uts/UTSPromise;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/dcloud/uts/UTSPromise<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    .line 176
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v0, v1, v2, v1}, Lio/dcloud/uts/UTSPromise$Companion;->resolve_origin$default(Lio/dcloud/uts/UTSPromise$Companion;Ljava/lang/Object;ILjava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object v0

    return-object v0
.end method

.method public final resolve(Lio/dcloud/uts/UTSPromise;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 182
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->resolve_origin(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method

.method public final resolve(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    .line 179
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->resolve_origin(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method

.method public final resolve_origin(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            ")",
            "Lio/dcloud/uts/UTSPromise<",
            "TT;>;"
        }
    .end annotation

    .line 185
    sget-object v0, Lio/dcloud/uts/UTSPromise;->Companion:Lio/dcloud/uts/UTSPromise$Companion;

    invoke-direct {v0, p1}, Lio/dcloud/uts/UTSPromise$Companion;->_resolve(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;

    move-result-object p1

    return-object p1
.end method
