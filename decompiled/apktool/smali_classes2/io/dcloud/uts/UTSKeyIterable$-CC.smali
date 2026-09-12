.class public final synthetic Lio/dcloud/uts/UTSKeyIterable$-CC;
.super Ljava/lang/Object;
.source "UTSIterator.kt"


# direct methods
.method public static $default$get(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p0, "_this"    # Lio/dcloud/uts/UTSKeyIterable;

    .line 0
    const-string v0, "propertyName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 79
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {p0, v2}, Lio/dcloud/uts/UTSKeyIterable$-CC;->$private$getAllFields(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Class;)Ljava/util/List;

    move-result-object v2

    check-cast v2, Ljava/lang/Iterable;

    invoke-interface {v2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v4, v3

    check-cast v4, Ljava/lang/reflect/Field;

    .line 80
    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    goto :goto_0

    :cond_1
    move-object v3, v1

    .line 79
    :goto_0
    check-cast v3, Ljava/lang/reflect/Field;

    if-nez v3, :cond_2

    return-object v1

    .line 83
    :cond_2
    invoke-virtual {v3, v0}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 84
    invoke-virtual {v3, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p1

    .line 87
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 88
    sget-object v2, Lio/dcloud/uts/console;->INSTANCE:Lio/dcloud/uts/console;

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v0, v3

    invoke-virtual {v2, v0}, Lio/dcloud/uts/console;->errorV1([Ljava/lang/Object;)V

    return-object v1
.end method

.method public static $default$ignoredKeys(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSArray;
    .locals 1
    .param p0, "_this"    # Lio/dcloud/uts/UTSKeyIterable;

    .line 203
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    return-object v0
.end method

.method public static $default$keyIterator(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSIterator;
    .locals 5
    .param p0, "_this"    # Lio/dcloud/uts/UTSKeyIterable;

    .line 117
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v0

    .line 119
    invoke-interface {p0}, Lio/dcloud/uts/UTSKeyIterable;->ignoredKeys()Lio/dcloud/uts/UTSArray;

    move-result-object v1

    .line 121
    invoke-static {v0}, Lkotlin/reflect/full/KClasses;->getMemberProperties(Lkotlin/reflect/KClass;)Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 122
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    check-cast v2, Ljava/util/List;

    .line 124
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 125
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lkotlin/reflect/KProperty1;

    .line 126
    invoke-interface {v3}, Lkotlin/reflect/KProperty1;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lio/dcloud/uts/UTSArray;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    goto :goto_0

    .line 129
    :cond_0
    invoke-interface {v3}, Lkotlin/reflect/KProperty1;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 135
    :cond_1
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 138
    new-instance v1, Lio/dcloud/uts/UTSIterator;

    new-instance v2, Lio/dcloud/uts/UTSKeyIterable$$ExternalSyntheticLambda0;

    invoke-direct {v2, v0}, Lio/dcloud/uts/UTSKeyIterable$$ExternalSyntheticLambda0;-><init>(Ljava/util/Iterator;)V

    invoke-direct {v1, v2}, Lio/dcloud/uts/UTSIterator;-><init>(Lkotlin/jvm/functions/Function0;)V

    return-object v1
.end method

.method public static $default$set(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 5
    .param p0, "_this"    # Lio/dcloud/uts/UTSKeyIterable;

    .line 0
    const-string v0, "propertyName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 96
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {p0, v2}, Lio/dcloud/uts/UTSKeyIterable$-CC;->$private$getAllFields(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Class;)Ljava/util/List;

    move-result-object v2

    check-cast v2, Ljava/lang/Iterable;

    invoke-interface {v2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v4, v3

    check-cast v4, Ljava/lang/reflect/Field;

    .line 97
    invoke-virtual {v4}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    goto :goto_0

    :cond_1
    const/4 v3, 0x0

    .line 96
    :goto_0
    check-cast v3, Ljava/lang/reflect/Field;

    if-nez v3, :cond_2

    .line 101
    sget-object p2, Lio/dcloud/uts/console;->INSTANCE:Lio/dcloud/uts/console;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "not found field "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    new-array v2, v1, [Ljava/lang/Object;

    aput-object p1, v2, v0

    invoke-virtual {p2, v2}, Lio/dcloud/uts/console;->errorV1([Ljava/lang/Object;)V

    return-void

    .line 104
    :cond_2
    invoke-virtual {v3, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 105
    invoke-virtual {v3, p0, p2}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 108
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 109
    sget-object p2, Lio/dcloud/uts/console;->INSTANCE:Lio/dcloud/uts/console;

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p1, v1, v0

    invoke-virtual {p2, v1}, Lio/dcloud/uts/console;->errorV1([Ljava/lang/Object;)V

    return-void
.end method

.method public static $private$getAllFields(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Class;)Ljava/util/List;
    .locals 3
    .param p0, "_this"    # Lio/dcloud/uts/UTSKeyIterable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Ljava/util/List<",
            "Ljava/lang/reflect/Field;",
            ">;"
        }
    .end annotation

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    :goto_0
    if-eqz p1, :cond_1

    .line 67
    invoke-virtual {p1}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    invoke-static {v1}, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/reflect/Field;

    .line 68
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 70
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p1

    goto :goto_0

    :cond_1
    return-object v0
.end method

.method public static synthetic access$get$jd(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 55
    invoke-static {p0, p1}, Lio/dcloud/uts/UTSKeyIterable$-CC;->$default$get(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic access$ignoredKeys$jd(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSArray;
    .locals 0

    .line 55
    invoke-static {p0}, Lio/dcloud/uts/UTSKeyIterable$-CC;->$default$ignoredKeys(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic access$keyIterator$jd(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSIterator;
    .locals 0

    .line 55
    invoke-static {p0}, Lio/dcloud/uts/UTSKeyIterable$-CC;->$default$keyIterator(Lio/dcloud/uts/UTSKeyIterable;)Lio/dcloud/uts/UTSIterator;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic access$set$jd(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .line 55
    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSKeyIterable$-CC;->$default$set(Lio/dcloud/uts/UTSKeyIterable;Ljava/lang/Object;Ljava/lang/Object;)V

    return-void
.end method

.method public static keyIterator$lambda$2(Ljava/util/Iterator;)Lio/dcloud/uts/UTSIteratorResult;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Iterator<",
            "Ljava/lang/String;",
            ">;)",
            "Lio/dcloud/uts/UTSIteratorResult<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 140
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 141
    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/String;

    .line 142
    new-instance v0, Lio/dcloud/uts/UTSIteratorResult;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p0}, Lio/dcloud/uts/UTSIteratorResult;-><init>(ZLjava/lang/Object;)V

    return-object v0

    .line 144
    :cond_0
    new-instance p0, Lio/dcloud/uts/UTSIteratorResult;

    const/4 v0, 0x1

    const-string v1, ""

    invoke-direct {p0, v0, v1}, Lio/dcloud/uts/UTSIteratorResult;-><init>(ZLjava/lang/Object;)V

    return-object p0
.end method
