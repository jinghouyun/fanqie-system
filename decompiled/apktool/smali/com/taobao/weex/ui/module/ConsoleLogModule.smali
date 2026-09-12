.class public Lcom/taobao/weex/ui/module/ConsoleLogModule;
.super Lcom/taobao/weex/common/WXModule;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/taobao/weex/common/WXModule;-><init>()V

    return-void
.end method

.method private getLogLevel(Ljava/lang/String;)Lio/dcloud/feature/uniapp/utils/AbsLogLevel;
    .locals 2

    .line 1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_0

    goto :goto_0

    :sswitch_0
    const-string/jumbo v0, "warning"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x4

    goto :goto_0

    :sswitch_1
    const-string v0, "error"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1

    goto :goto_0

    :cond_1
    const/4 v1, 0x3

    goto :goto_0

    :sswitch_2
    const-string v0, "debug"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_0

    :cond_2
    const/4 v1, 0x2

    goto :goto_0

    :sswitch_3
    const-string v0, "info"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_3

    goto :goto_0

    :cond_3
    const/4 v1, 0x1

    goto :goto_0

    :sswitch_4
    const-string v0, "off"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_4

    goto :goto_0

    :cond_4
    const/4 v1, 0x0

    :goto_0
    packed-switch v1, :pswitch_data_0

    goto :goto_1

    .line 10
    :pswitch_0
    sget-object p1, Lcom/taobao/weex/utils/LogLevel;->WARN:Lcom/taobao/weex/utils/LogLevel;

    return-object p1

    .line 11
    :pswitch_1
    sget-object p1, Lcom/taobao/weex/utils/LogLevel;->ERROR:Lcom/taobao/weex/utils/LogLevel;

    return-object p1

    .line 20
    :pswitch_2
    sget-object p1, Lcom/taobao/weex/utils/LogLevel;->DEBUG:Lcom/taobao/weex/utils/LogLevel;

    return-object p1

    .line 21
    :pswitch_3
    sget-object p1, Lcom/taobao/weex/utils/LogLevel;->INFO:Lcom/taobao/weex/utils/LogLevel;

    return-object p1

    .line 22
    :pswitch_4
    sget-object p1, Lcom/taobao/weex/utils/LogLevel;->OFF:Lcom/taobao/weex/utils/LogLevel;

    return-object p1

    :cond_5
    :goto_1
    const/4 p1, 0x0

    return-object p1

    nop

    :sswitch_data_0
    .sparse-switch
        0x1ad6f -> :sswitch_4
        0x3164ae -> :sswitch_3
        0x5b09653 -> :sswitch_2
        0x5c4d208 -> :sswitch_1
        0x4305af9c -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public setPerfMode(Ljava/lang/String;)V
    .locals 2
    .annotation runtime Lcom/taobao/weex/annotation/JSMethod;
        uiThread = false
    .end annotation

    .line 1
    const-string/jumbo v0, "true"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    sput-boolean p1, Lcom/taobao/weex/WXEnvironment;->isPerf:Z

    .line 2
    invoke-static {}, Lcom/taobao/weex/bridge/WXBridgeManager;->getInstance()Lcom/taobao/weex/bridge/WXBridgeManager;

    move-result-object p1

    sget-object v0, Lcom/taobao/weex/WXEnvironment;->sLogLevel:Lio/dcloud/feature/uniapp/utils/AbsLogLevel;

    invoke-interface {v0}, Lio/dcloud/feature/uniapp/utils/AbsLogLevel;->getValue()I

    move-result v0

    invoke-static {}, Lcom/taobao/weex/WXEnvironment;->isPerf()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Lcom/taobao/weex/bridge/WXBridgeManager;->setLogLevel(IZ)V

    return-void
.end method

.method public switchLogLevel(Ljava/lang/String;Lcom/taobao/weex/bridge/JSCallback;)V
    .locals 4
    .annotation runtime Lcom/taobao/weex/annotation/JSMethod;
        uiThread = false
    .end annotation

    .line 1
    invoke-direct {p0, p1}, Lcom/taobao/weex/ui/module/ConsoleLogModule;->getLogLevel(Ljava/lang/String;)Lio/dcloud/feature/uniapp/utils/AbsLogLevel;

    move-result-object p1

    .line 2
    new-instance v0, Landroidx/collection/ArrayMap;

    invoke-direct {v0}, Landroidx/collection/ArrayMap;-><init>()V

    const-string/jumbo v1, "status"

    if-eqz p1, :cond_0

    .line 4
    sput-object p1, Lcom/taobao/weex/WXEnvironment;->sLogLevel:Lio/dcloud/feature/uniapp/utils/AbsLogLevel;

    .line 5
    invoke-static {}, Lcom/taobao/weex/bridge/WXBridgeManager;->getInstance()Lcom/taobao/weex/bridge/WXBridgeManager;

    move-result-object p1

    sget-object v2, Lcom/taobao/weex/WXEnvironment;->sLogLevel:Lio/dcloud/feature/uniapp/utils/AbsLogLevel;

    invoke-interface {v2}, Lio/dcloud/feature/uniapp/utils/AbsLogLevel;->getValue()I

    move-result v2

    invoke-static {}, Lcom/taobao/weex/WXEnvironment;->isPerf()Z

    move-result v3

    invoke-virtual {p1, v2, v3}, Lcom/taobao/weex/bridge/WXBridgeManager;->setLogLevel(IZ)V

    .line 6
    const-string/jumbo p1, "success"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 8
    :cond_0
    const-string p1, "failure"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_0
    if-eqz p2, :cond_1

    .line 12
    invoke-interface {p2, v0}, Lcom/taobao/weex/bridge/JSCallback;->invoke(Ljava/lang/Object;)V

    :cond_1
    return-void
.end method
