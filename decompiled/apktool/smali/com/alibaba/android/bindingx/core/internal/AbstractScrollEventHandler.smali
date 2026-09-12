.class public abstract Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;
.super Lcom/alibaba/android/bindingx/core/internal/AbstractEventHandler;
.source "AbstractScrollEventHandler.java"


# instance fields
.field private isStart:Z

.field protected mContentOffsetX:I

.field protected mContentOffsetY:I


# direct methods
.method public varargs constructor <init>(Landroid/content/Context;Lcom/alibaba/android/bindingx/core/PlatformManager;[Ljava/lang/Object;)V
    .locals 0

    .line 50
    invoke-direct {p0, p1, p2, p3}, Lcom/alibaba/android/bindingx/core/internal/AbstractEventHandler;-><init>(Landroid/content/Context;Lcom/alibaba/android/bindingx/core/PlatformManager;[Ljava/lang/Object;)V

    const/4 p1, 0x0

    .line 47
    iput-boolean p1, p0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->isStart:Z

    return-void
.end method


# virtual methods
.method protected varargs fireEventByState(Ljava/lang/String;DDDDDD[Ljava/lang/Object;)V
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p14

    .line 124
    iget-object v3, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mCallback:Lcom/alibaba/android/bindingx/core/BindingXCore$JavaScriptCallback;

    if-eqz v3, :cond_1

    .line 125
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 126
    const-string/jumbo v4, "state"

    invoke-interface {v3, v4, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    iget-object v4, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v4}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v4

    const/4 v5, 0x0

    new-array v6, v5, [Ljava/lang/Object;

    move-wide/from16 v7, p2

    invoke-interface {v4, v7, v8, v6}, Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;->nativeToWeb(D[Ljava/lang/Object;)D

    move-result-wide v6

    .line 128
    iget-object v4, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v4}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v4

    new-array v8, v5, [Ljava/lang/Object;

    move-wide/from16 v9, p4

    invoke-interface {v4, v9, v10, v8}, Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;->nativeToWeb(D[Ljava/lang/Object;)D

    move-result-wide v8

    .line 129
    const-string/jumbo v4, "x"

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v10

    invoke-interface {v3, v4, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    const-string/jumbo v4, "y"

    invoke-static {v8, v9}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v10

    invoke-interface {v3, v4, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    iget-object v4, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v4}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v4

    new-array v10, v5, [Ljava/lang/Object;

    move-wide/from16 v11, p6

    invoke-interface {v4, v11, v12, v10}, Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;->nativeToWeb(D[Ljava/lang/Object;)D

    move-result-wide v10

    .line 133
    iget-object v4, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v4}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v4

    new-array v12, v5, [Ljava/lang/Object;

    move-wide/from16 v13, p8

    invoke-interface {v4, v13, v14, v12}, Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;->nativeToWeb(D[Ljava/lang/Object;)D

    move-result-wide v12

    .line 134
    const-string v4, "dx"

    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v14

    invoke-interface {v3, v4, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    const-string v4, "dy"

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v14

    invoke-interface {v3, v4, v14}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    iget-object v4, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v4}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v4

    new-array v14, v5, [Ljava/lang/Object;

    move-wide/from16 p2, v6

    move-wide/from16 v5, p10

    invoke-interface {v4, v5, v6, v14}, Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;->nativeToWeb(D[Ljava/lang/Object;)D

    move-result-wide v4

    .line 138
    iget-object v6, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v6}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v6

    const/4 v15, 0x0

    new-array v7, v15, [Ljava/lang/Object;

    move-wide/from16 v14, p12

    invoke-interface {v6, v14, v15, v7}, Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;->nativeToWeb(D[Ljava/lang/Object;)D

    move-result-wide v6

    .line 139
    const-string/jumbo v14, "tdx"

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v15

    invoke-interface {v3, v14, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    const-string/jumbo v14, "tdy"

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v15

    invoke-interface {v3, v14, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    const-string/jumbo v14, "token"

    iget-object v15, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mToken:Ljava/lang/String;

    invoke-interface {v3, v14, v15}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-eqz v2, :cond_0

    .line 143
    array-length v14, v2

    if-lez v14, :cond_0

    const/4 v15, 0x0

    aget-object v2, v2, v15

    instance-of v14, v2, Ljava/util/Map;

    if-eqz v14, :cond_0

    .line 144
    check-cast v2, Ljava/util/Map;

    invoke-interface {v3, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 147
    :cond_0
    iget-object v2, v0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mCallback:Lcom/alibaba/android/bindingx/core/BindingXCore$JavaScriptCallback;

    invoke-interface {v2, v3}, Lcom/alibaba/android/bindingx/core/BindingXCore$JavaScriptCallback;->callback(Ljava/lang/Object;)V

    .line 148
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, ">>>>>>>>>>>fire event:("

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ","

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-wide/from16 v14, p2

    invoke-virtual {v2, v14, v15}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v8, v9}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v10, v11}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v12, v13}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/alibaba/android/bindingx/core/LogProxy;->d(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method protected handleScrollEvent(IIIIII)V
    .locals 19

    move-object/from16 v1, p0

    move/from16 v0, p1

    move/from16 v2, p2

    move/from16 v3, p3

    move/from16 v4, p4

    move/from16 v5, p5

    move/from16 v6, p6

    .line 97
    sget-boolean v7, Lcom/alibaba/android/bindingx/core/LogProxy;->sEnableLog:Z

    const/4 v8, 0x1

    if-eqz v7, :cond_0

    .line 98
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v7

    .line 100
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    const/16 v16, 0x0

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v10, v9, v16

    aput-object v11, v9, v8

    const/4 v10, 0x2

    aput-object v12, v9, v10

    const/4 v10, 0x3

    aput-object v13, v9, v10

    const/4 v10, 0x4

    aput-object v14, v9, v10

    const/4 v10, 0x5

    aput-object v15, v9, v10

    .line 98
    const-string v10, "[ScrollHandler] scroll changed. (contentOffsetX:%d,contentOffsetY:%d,dx:%d,dy:%d,tdx:%d,tdy:%d)"

    invoke-static {v7, v10, v9}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/alibaba/android/bindingx/core/LogProxy;->d(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    const/16 v16, 0x0

    .line 103
    :goto_0
    iput v0, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mContentOffsetX:I

    .line 104
    iput v2, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mContentOffsetY:I

    .line 106
    iget-boolean v7, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->isStart:Z

    if-nez v7, :cond_1

    .line 107
    iput-boolean v8, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->isStart:Z

    int-to-double v7, v0

    int-to-double v9, v2

    move-wide v11, v7

    int-to-double v7, v3

    move-wide v13, v9

    int-to-double v9, v4

    move-wide v3, v11

    int-to-double v11, v5

    move-wide/from16 v17, v13

    int-to-double v13, v6

    const/4 v15, 0x0

    .line 108
    new-array v15, v15, [Ljava/lang/Object;

    const-string v2, "start"

    move-wide/from16 v5, v17

    invoke-virtual/range {v1 .. v15}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->fireEventByState(Ljava/lang/String;DDDDDD[Ljava/lang/Object;)V

    .line 112
    :cond_1
    :try_start_0
    iget-object v2, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mScope:Ljava/util/Map;

    int-to-double v3, v0

    move/from16 v0, p2

    int-to-double v5, v0

    move/from16 v0, p3

    int-to-double v7, v0

    move/from16 v0, p4

    int-to-double v9, v0

    move/from16 v0, p5

    int-to-double v11, v0

    move/from16 v0, p6

    int-to-double v13, v0

    iget-object v0, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mPlatformManager:Lcom/alibaba/android/bindingx/core/PlatformManager;

    invoke-virtual {v0}, Lcom/alibaba/android/bindingx/core/PlatformManager;->getResolutionTranslator()Lcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;

    move-result-object v15

    invoke-static/range {v2 .. v15}, Lcom/alibaba/android/bindingx/core/internal/JSMath;->applyScrollValuesToScope(Ljava/util/Map;DDDDDDLcom/alibaba/android/bindingx/core/PlatformManager$IDeviceResolutionTranslator;)V

    .line 113
    iget-object v0, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mExitExpressionPair:Lcom/alibaba/android/bindingx/core/internal/ExpressionPair;

    iget-object v2, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mScope:Ljava/util/Map;

    invoke-virtual {v1, v0, v2}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->evaluateExitExpression(Lcom/alibaba/android/bindingx/core/internal/ExpressionPair;Ljava/util/Map;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 114
    iget-object v0, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mExpressionHoldersMap:Ljava/util/Map;

    iget-object v2, v1, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mScope:Ljava/util/Map;

    const-string v3, "scroll"

    invoke-virtual {v1, v0, v2, v3}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->consumeExpression(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    return-void

    :catch_0
    move-exception v0

    .line 117
    const-string v2, "runtime error"

    invoke-static {v2, v0}, Lcom/alibaba/android/bindingx/core/LogProxy;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    return-void
.end method

.method public onDestroy()V
    .locals 1

    .line 83
    invoke-super {p0}, Lcom/alibaba/android/bindingx/core/internal/AbstractEventHandler;->onDestroy()V

    const/4 v0, 0x0

    .line 84
    iput-boolean v0, p0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->isStart:Z

    return-void
.end method

.method public onDisable(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 15

    .line 56
    invoke-virtual {p0}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->clearExpressions()V

    const/4 v1, 0x0

    .line 57
    iput-boolean v1, p0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->isStart:Z

    .line 58
    iget v2, p0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mContentOffsetX:I

    int-to-double v2, v2

    iget v4, p0, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->mContentOffsetY:I

    int-to-double v4, v4

    const-wide/16 v12, 0x0

    new-array v14, v1, [Ljava/lang/Object;

    const-string v1, "end"

    const-wide/16 v6, 0x0

    const-wide/16 v8, 0x0

    const-wide/16 v10, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v14}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->fireEventByState(Ljava/lang/String;DDDDDD[Ljava/lang/Object;)V

    const/4 v0, 0x1

    return v0
.end method

.method protected onExit(Ljava/util/Map;)V
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    move-object/from16 v0, p1

    .line 64
    const-string v1, "internal_x"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    .line 65
    const-string v1, "internal_y"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    const/4 v0, 0x0

    .line 66
    new-array v0, v0, [Ljava/lang/Object;

    const-string v3, "exit"

    const-wide/16 v8, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v12, 0x0

    const-wide/16 v14, 0x0

    move-object/from16 v2, p0

    move-object/from16 v16, v0

    invoke-virtual/range {v2 .. v16}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->fireEventByState(Ljava/lang/String;DDDDDD[Ljava/lang/Object;)V

    return-void
.end method

.method protected onUserIntercept(Ljava/lang/String;Ljava/util/Map;)V
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    move-object/from16 v0, p2

    .line 71
    const-string v1, "internal_x"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    .line 72
    const-string v1, "internal_y"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    .line 73
    const-string v1, "dx"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v8

    .line 74
    const-string v1, "dy"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v10

    .line 75
    const-string/jumbo v1, "tdx"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Double;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v12

    .line 76
    const-string/jumbo v1, "tdy"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v14

    .line 77
    const-string v0, "interceptor"

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Ljava/util/Collections;->singletonMap(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    const-string v3, "interceptor"

    move-object/from16 v2, p0

    move-object/from16 v16, v1

    invoke-virtual/range {v2 .. v16}, Lcom/alibaba/android/bindingx/core/internal/AbstractScrollEventHandler;->fireEventByState(Ljava/lang/String;DDDDDD[Ljava/lang/Object;)V

    return-void
.end method
