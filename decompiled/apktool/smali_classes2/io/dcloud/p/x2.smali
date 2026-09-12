.class public Lio/dcloud/p/x2;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/IEventCallback;


# static fields
.field static b:Ljava/util/HashMap;

.field static c:Lio/dcloud/p/x2;


# instance fields
.field a:Ljava/util/ArrayList;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    sput-object v0, Lio/dcloud/p/x2;->b:Ljava/util/HashMap;

    const/4 v0, 0x0

    .line 2
    sput-object v0, Lio/dcloud/p/x2;->c:Lio/dcloud/p/x2;

    return-void
.end method

.method public constructor <init>(Lio/dcloud/common/DHInterface/AbsMgr;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Lio/dcloud/p/x2;->a:Ljava/util/ArrayList;

    .line 9
    sput-object p0, Lio/dcloud/p/x2;->c:Lio/dcloud/p/x2;

    return-void
.end method

.method private static a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/Object;)Lio/dcloud/p/j3;
    .locals 3

    .line 619
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 621
    new-instance v1, Lio/dcloud/p/j3;

    sget-object v2, Lio/dcloud/p/x2;->c:Lio/dcloud/p/x2;

    invoke-direct {v1, v2, v0, p1, p2}, Lio/dcloud/p/j3;-><init>(Lio/dcloud/p/x2;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V

    .line 622
    invoke-static {p0, p1, v1}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lio/dcloud/p/j3;)V

    return-object v1
.end method

.method static a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;
    .locals 10

    .line 541
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 542
    invoke-static {v0}, Lio/dcloud/p/k3;->b(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    .line 545
    const-class v2, Ljava/lang/String;

    const-string v3, "{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}"

    const/4 v4, 0x3

    const/4 v5, 0x2

    const/4 v6, 0x4

    const/4 v7, 0x1

    const-string v8, "\""

    const/4 v9, 0x0

    if-eq v0, v2, :cond_2

    const-class v2, Ljava/lang/CharSequence;

    if-ne v0, v2, :cond_0

    goto :goto_0

    .line 547
    :cond_0
    invoke-static {v0}, Lio/dcloud/p/k3;->a(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 548
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    goto :goto_1

    .line 551
    :cond_1
    invoke-static {p1}, Lio/dcloud/p/x2;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 552
    invoke-static {p0, v2, p1}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/Object;)Lio/dcloud/p/j3;

    .line 553
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 555
    invoke-static {v0}, Lio/dcloud/p/x2;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object p1

    new-array v0, v6, [Ljava/lang/Object;

    const-string v2, "object"

    aput-object v2, v0, v9

    aput-object p0, v0, v7

    aput-object v1, v0, v5

    aput-object p1, v0, v4

    invoke-static {v3, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0, v9}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object p0

    .line 556
    new-array p1, v7, [Ljava/lang/Object;

    aput-object p0, p1, v9

    const-string p0, "plus.ios.__Tool.New(%s, true)"

    invoke-static {p0, p1}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 557
    :cond_2
    :goto_0
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 569
    :goto_1
    invoke-static {v0}, Lio/dcloud/p/x2;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object p1

    new-array v0, v6, [Ljava/lang/Object;

    const-string v2, "basic"

    aput-object v2, v0, v9

    aput-object p0, v0, v7

    aput-object v1, v0, v5

    aput-object p1, v0, v4

    invoke-static {v3, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0, v9}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static a(Ljava/lang/Class;)Ljava/lang/String;
    .locals 2

    .line 570
    new-instance v0, Lorg/json/JSONStringer;

    invoke-direct {v0}, Lorg/json/JSONStringer;-><init>()V

    .line 571
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 573
    :try_start_0
    invoke-virtual {v0}, Lorg/json/JSONStringer;->array()Lorg/json/JSONStringer;

    .line 574
    invoke-static {p0, v0, v1}, Lio/dcloud/p/x2;->b(Ljava/lang/Class;Lorg/json/JSONStringer;Ljava/util/ArrayList;)V

    .line 575
    invoke-virtual {v0}, Lorg/json/JSONStringer;->endArray()Lorg/json/JSONStringer;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p0

    .line 577
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 579
    :goto_0
    invoke-virtual {v0}, Lorg/json/JSONStringer;->toString()Ljava/lang/String;

    move-result-object p0

    if-nez p0, :cond_0

    .line 580
    const-string p0, "[]"

    :cond_0
    return-object p0
.end method

.method private static a(Ljava/lang/Exception;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .line 514
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    :goto_0
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p0, ";at "

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const/4 p1, 0x1

    new-array p1, p1, [Ljava/lang/Object;

    const/4 v0, 0x0

    aput-object p0, p1, v0

    const-string p0, "throw \'%s\';"

    invoke-static {p0, p1}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static a(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2

    .line 623
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Invocation"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static a(Lio/dcloud/common/DHInterface/IWebview;)Ljava/util/HashMap;
    .locals 2

    .line 611
    sget-object v0, Lio/dcloud/p/x2;->b:Ljava/util/HashMap;

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 613
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    .line 614
    sget-object v1, Lio/dcloud/p/x2;->b:Ljava/util/HashMap;

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result p0

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-virtual {v1, p0, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-object v0
.end method

.method static a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/StringBuffer;)V
    .locals 3

    .line 591
    const-class v0, Ljava/lang/String;

    if-eq p2, v0, :cond_5

    const-class v0, Ljava/lang/CharSequence;

    if-ne p2, v0, :cond_0

    goto :goto_1

    .line 593
    :cond_0
    invoke-static {p2}, Lio/dcloud/p/k3;->a(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 594
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p3, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    return-void

    .line 595
    :cond_1
    invoke-virtual {p2}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 596
    invoke-static {p1}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result v0

    .line 597
    const-string v1, "["

    invoke-virtual {p3, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_3

    .line 599
    invoke-static {p1, v1}, Ljava/lang/reflect/Array;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2, p2}, Lio/dcloud/p/k3;->a(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .line 600
    invoke-static {p0, v2}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p3, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    add-int/lit8 v2, v0, -0x1

    if-eq v1, v2, :cond_2

    .line 602
    const-string v2, ","

    invoke-virtual {p3, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 605
    :cond_3
    const-string p0, "]"

    invoke-virtual {p3, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    return-void

    .line 607
    :cond_4
    invoke-static {p1}, Lio/dcloud/p/x2;->a(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    .line 608
    invoke-static {p0, p2, p1}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/Object;)Lio/dcloud/p/j3;

    .line 609
    const-string p0, "\""

    invoke-virtual {p3, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object p1

    invoke-virtual {p1, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object p1

    invoke-virtual {p1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    return-void

    .line 610
    :cond_5
    :goto_1
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p3, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    return-void
.end method

.method private static a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lio/dcloud/p/j3;)V
    .locals 0

    .line 617
    invoke-static {p0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;)Ljava/util/HashMap;

    move-result-object p0

    .line 618
    invoke-virtual {p0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 515
    invoke-static {p2}, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->valueOf(Ljava/lang/String;)Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    move-result-object p2

    .line 516
    sget-object v0, Lio/dcloud/p/x2$d;->a:[I

    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    move-result p2

    aget p2, v0, p2

    const/4 v0, 0x1

    if-eq p2, v0, :cond_0

    return-void

    .line 518
    :cond_0
    new-instance p2, Lio/dcloud/p/x2$b;

    invoke-direct {p2, p0, p1, p3}, Lio/dcloud/p/x2$b;-><init>(Lio/dcloud/p/x2;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 539
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object p3

    sget-object v0, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->onActivityResult:Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    invoke-interface {p3, p2, v0}, Lio/dcloud/common/DHInterface/IApp;->registerSysEventListener(Lio/dcloud/common/DHInterface/ISysEventListener;Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;)V

    .line 540
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object p3

    new-instance v0, Lio/dcloud/p/x2$c;

    invoke-direct {v0, p0, p1, p2}, Lio/dcloud/p/x2$c;-><init>(Lio/dcloud/p/x2;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/ISysEventListener;)V

    invoke-interface {p3, v0}, Lio/dcloud/common/DHInterface/IFrameViewStatus;->addFrameViewListener(Lio/dcloud/common/DHInterface/IEventCallback;)V

    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    .locals 7

    .line 504
    invoke-virtual {p3}, Lorg/json/JSONArray;->length()I

    move-result p3

    invoke-virtual {p4}, Lorg/json/JSONArray;->length()I

    move-result v0

    invoke-virtual {p5}, Lorg/json/JSONArray;->length()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p6}, Lorg/json/JSONArray;->length()I

    move-result v1

    add-int/2addr v0, v1

    if-ne p3, v0, :cond_0

    .line 505
    new-instance p3, Lorg/json/JSONObject;

    invoke-direct {p3}, Lorg/json/JSONObject;-><init>()V

    .line 507
    :try_start_0
    const-string v0, "granted"

    invoke-virtual {p3, v0, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 508
    const-string p4, "deniedPresent"

    invoke-virtual {p3, p4, p5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 509
    const-string p4, "deniedAlways"

    invoke-virtual {p3, p4, p6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    move-object p4, v0

    .line 511
    invoke-virtual {p4}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_0
    const/4 p4, 0x0

    .line 513
    aget-object v2, p2, p4

    invoke-virtual {p3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    sget v4, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v5, 0x1

    const/4 v6, 0x0

    move-object v1, p1

    invoke-static/range {v1 .. v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    :cond_0
    return-void
.end method

.method static synthetic a(Lio/dcloud/p/x2;Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p6}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V

    return-void
.end method

.method static a(Ljava/lang/Class;Lorg/json/JSONStringer;Ljava/util/ArrayList;)V
    .locals 4

    .line 581
    invoke-virtual {p0}, Ljava/lang/Class;->getInterfaces()[Ljava/lang/Class;

    move-result-object p0

    if-eqz p0, :cond_1

    const/4 v0, 0x0

    .line 583
    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_1

    .line 584
    aget-object v1, p0, v0

    .line 585
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    .line 586
    invoke-virtual {p2, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 587
    invoke-virtual {p1, v2}, Lorg/json/JSONStringer;->value(Ljava/lang/Object;)Lorg/json/JSONStringer;

    .line 588
    invoke-virtual {p2, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 590
    invoke-static {v1, p1, p2}, Lio/dcloud/p/x2;->a(Ljava/lang/Class;Lorg/json/JSONStringer;Ljava/util/ArrayList;)V

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;)Z
    .locals 2

    const/4 v0, 0x0

    if-eqz p3, :cond_3

    .line 624
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 625
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_1

    .line 629
    :cond_0
    invoke-interface {p3}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object p3

    .line 630
    const-string v1, "use_encryption"

    invoke-interface {p3, v1}, Lio/dcloud/common/DHInterface/IApp;->obtainConfigProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p3

    .line 631
    invoke-static {p3}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result p3

    if-eqz p3, :cond_3

    .line 634
    const-string p3, "setWebContentsDebuggingEnabled"

    invoke-virtual {p3, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p2

    if-eqz p2, :cond_3

    .line 635
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p2

    if-eqz p2, :cond_1

    goto :goto_0

    .line 636
    :cond_1
    const-string p2, "WebView"

    invoke-virtual {p2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p2

    if-nez p2, :cond_2

    .line 637
    const-string p2, "android.webkit.WebView"

    invoke-virtual {p2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_3

    :cond_2
    :goto_0
    const/4 p1, 0x1

    return p1

    :cond_3
    :goto_1
    return v0
.end method

.method static b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;
    .locals 4

    .line 11
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 12
    invoke-static {v0}, Lio/dcloud/p/k3;->b(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    .line 14
    invoke-static {v0}, Lio/dcloud/p/k3;->a(Ljava/lang/Class;)Z

    move-result v2

    if-nez v2, :cond_0

    const-class v2, Ljava/lang/String;

    if-eq v0, v2, :cond_0

    const-class v2, Ljava/lang/CharSequence;

    if-eq v0, v2, :cond_0

    .line 17
    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    move-result v2

    if-nez v2, :cond_0

    .line 19
    const-string v2, "object"

    goto :goto_0

    .line 21
    :cond_0
    const-string v2, "basic"

    :goto_0
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 22
    invoke-static {p0, p1, v0, v3}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/StringBuffer;)V

    .line 23
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0}, Lio/dcloud/p/x2;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object p1

    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v2, v0, v3

    const/4 v2, 0x1

    aput-object p0, v0, v2

    const/4 p0, 0x2

    aput-object v1, v0, p0

    const/4 p0, 0x3

    aput-object p1, v0, p0

    const-string p0, "{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}"

    invoke-static {p0, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0, v3}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static b(Ljava/lang/Class;Lorg/json/JSONStringer;Ljava/util/ArrayList;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p0

    :goto_0
    if-nez p0, :cond_0

    goto :goto_1

    .line 3
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 4
    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 5
    invoke-virtual {p1, v0}, Lorg/json/JSONStringer;->value(Ljava/lang/Object;)Lorg/json/JSONStringer;

    .line 6
    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 7
    invoke-static {p0, p1, p2}, Lio/dcloud/p/x2;->a(Ljava/lang/Class;Lorg/json/JSONStringer;Ljava/util/ArrayList;)V

    .line 9
    :cond_1
    const-class v0, Ljava/lang/Object;

    if-ne p0, v0, :cond_2

    :goto_1
    return-void

    .line 10
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p0

    goto :goto_0
.end method


# virtual methods
.method a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/p/j3;
    .locals 0

    .line 616
    invoke-static {p1}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;)Ljava/util/HashMap;

    move-result-object p1

    invoke-virtual {p0, p1, p2}, Lio/dcloud/p/x2;->a(Ljava/util/HashMap;Ljava/lang/String;)Lio/dcloud/p/j3;

    move-result-object p1

    return-object p1
.end method

.method a(Ljava/util/HashMap;Ljava/lang/String;)Lio/dcloud/p/j3;
    .locals 0

    .line 615
    invoke-virtual {p1, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/dcloud/p/j3;

    return-object p1
.end method

.method public a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 17

    move-object/from16 v1, p0

    move-object/from16 v0, p2

    move-object/from16 v3, p3

    .line 2
    iget-object v2, v1, Lio/dcloud/p/x2;->a:Ljava/util/ArrayList;

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 3
    iget-object v2, v1, Lio/dcloud/p/x2;->a:Ljava/util/ArrayList;

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v2

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaFrameView;

    .line 5
    invoke-virtual {v2, v1}, Lio/dcloud/common/adapter/ui/AdaFrameView;->addFrameViewListener(Lio/dcloud/common/DHInterface/IEventCallback;)V

    .line 8
    :cond_0
    const-string v2, "__Instance"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    const-string v6, "InvProxy"

    const-string v7, " method ; params="

    const/4 v8, 0x0

    const/4 v4, 0x2

    const/4 v9, 0x1

    const/4 v10, 0x0

    if-eqz v2, :cond_4

    .line 9
    aget-object v0, v3, v10

    .line 10
    aget-object v11, v3, v9

    .line 13
    array-length v2, v3

    if-le v2, v4, :cond_3

    aget-object v2, v3, v4

    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 14
    aget-object v2, v3, v4

    invoke-static {v2}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 15
    invoke-static {v2, v10}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 17
    const-string v4, "type"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "boolean"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    const-string v5, "value"

    if-eqz v4, :cond_1

    .line 18
    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v9

    goto :goto_0

    .line 20
    :cond_1
    invoke-static {v3, v5}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "__super__constructor__"

    invoke-static {v4, v3}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    xor-int/2addr v9, v3

    :cond_2
    :goto_0
    move-object v5, v2

    goto :goto_1

    :cond_3
    move-object v5, v8

    :goto_1
    if-eqz v9, :cond_2a

    move-object v4, v0

    .line 26
    :try_start_0
    new-instance v0, Lio/dcloud/p/j3;

    invoke-static {v11}, Lio/dcloud/p/k3;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-object v2, v1

    move-object/from16 v1, p1

    :try_start_1
    invoke-direct/range {v0 .. v5}, Lio/dcloud/p/j3;-><init>(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/p/x2;Ljava/lang/Class;Ljava/lang/String;Lorg/json/JSONArray;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-object/from16 v16, v2

    move-object v2, v1

    move-object/from16 v1, v16

    .line 27
    :try_start_2
    invoke-static {v2, v4, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lio/dcloud/p/j3;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    return-object v8

    :catch_0
    move-exception v0

    move-object v1, v2

    goto :goto_2

    :catch_1
    move-exception v0

    .line 30
    :goto_2
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "new "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/Exception;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 31
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "NativeObject.execMethod __Instance "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_6

    :cond_4
    move-object/from16 v2, p1

    .line 33
    const-string v5, "release"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_29

    const-string v5, "__autoCollection"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    goto/16 :goto_d

    .line 42
    :cond_5
    const-string v5, "getWebviewById"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 43
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IApp;->obtainAppId()Ljava/lang/String;

    move-result-object v0

    .line 44
    aget-object v3, v3, v10

    .line 45
    invoke-static {v0, v3}, Lio/dcloud/feature/internal/sdk/SDK;->obtainWebview(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainWebview()Landroid/webkit/WebView;

    move-result-object v0

    invoke-static {v2, v0}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 46
    :cond_6
    const-string v5, "currentWebview"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    const-string v11, ""

    if-eqz v5, :cond_8

    .line 47
    instance-of v0, v2, Lio/dcloud/common/adapter/ui/AdaUniWebView;

    if-eqz v0, :cond_7

    return-object v11

    .line 269
    :cond_7
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainWebview()Landroid/webkit/WebView;

    move-result-object v0

    invoke-static {v2, v0}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 271
    :cond_8
    const-string v5, "getContext"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 272
    aget-object v0, v3, v10

    .line 273
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v3

    .line 274
    invoke-static {v2, v3}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 275
    const-string v4, "onActivityResult"

    invoke-direct {v1, v2, v4, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;)V

    return-object v3

    .line 276
    :cond_9
    const-string v5, "importFields"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 277
    aget-object v0, v3, v10

    .line 278
    invoke-virtual {v1, v2, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/p/j3;

    move-result-object v0

    if-eqz v0, :cond_2a

    .line 280
    iget-object v3, v0, Lio/dcloud/p/j3;->a:Lio/dcloud/p/x2;

    invoke-virtual {v0, v2, v3}, Lio/dcloud/p/j3;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/p/x2;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 282
    :cond_a
    const-string v5, "import"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 283
    aget-object v0, v3, v10

    .line 285
    invoke-static {v2, v1, v0}, Lio/dcloud/p/k3;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/p/x2;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v10}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 287
    :cond_b
    const-string v5, "__plusGetAttribute"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 288
    aget-object v0, v3, v10

    .line 289
    aget-object v3, v3, v9

    .line 290
    invoke-virtual {v1, v2, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/p/j3;

    move-result-object v0

    if-eqz v0, :cond_2a

    .line 292
    iget-object v4, v0, Lio/dcloud/p/j3;->b:Ljava/lang/Class;

    iget-object v0, v0, Lio/dcloud/p/j3;->c:Ljava/lang/Object;

    invoke-static {v4, v0, v3}, Lio/dcloud/p/j3;->a(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2a

    .line 294
    invoke-static {v2, v0}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 297
    :cond_c
    const-string v5, "__plusSetAttribute"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_d

    .line 298
    aget-object v0, v3, v10

    const/4 v5, 0x2

    .line 299
    aget-object v4, v3, v9

    .line 300
    aget-object v3, v3, v5

    invoke-static {v3}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 301
    invoke-virtual {v1, v2, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/p/j3;

    move-result-object v0

    if-eqz v0, :cond_2a

    .line 303
    iget-object v2, v0, Lio/dcloud/p/j3;->b:Ljava/lang/Class;

    iget-object v3, v0, Lio/dcloud/p/j3;->c:Ljava/lang/Object;

    move-object/from16 v0, p1

    invoke-static/range {v0 .. v5}, Lio/dcloud/p/j3;->b(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/p/x2;Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Lorg/json/JSONArray;)V

    return-object v8

    :cond_d
    const/4 v5, 0x2

    .line 305
    const-string v4, "implements"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    .line 306
    aget-object v0, v3, v10

    .line 307
    aget-object v4, v3, v9

    .line 308
    aget-object v5, v3, v5

    invoke-static {v5}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    const/4 v6, 0x3

    .line 309
    aget-object v3, v3, v6

    .line 310
    new-instance v6, Lio/dcloud/p/y2;

    invoke-direct {v6, v2, v4, v5, v3}, Lio/dcloud/p/y2;-><init>(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)V

    .line 311
    iput-object v0, v6, Lio/dcloud/p/y2;->a:Ljava/lang/String;

    .line 313
    invoke-virtual {v6, v8}, Lio/dcloud/p/y2;->a(Lorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v0

    .line 314
    invoke-static {v2, v0}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 315
    :cond_e
    const-string v4, "__loadDylib"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_f

    goto/16 :goto_e

    .line 316
    :cond_f
    const-string v4, "__release"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_10

    goto/16 :goto_e

    .line 317
    :cond_10
    const-string v4, "__inheritList"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_13

    .line 318
    aget-object v4, v3, v10

    .line 320
    :try_start_3
    aget-object v0, v3, v9

    .line 321
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_12

    .line 322
    invoke-virtual {v1, v2, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/p/j3;

    move-result-object v0

    if-eqz v0, :cond_11

    .line 324
    iget-object v0, v0, Lio/dcloud/p/j3;->b:Ljava/lang/Class;

    invoke-static {v0}, Lio/dcloud/p/k3;->c(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 326
    :cond_11
    invoke-static {v4}, Lio/dcloud/p/k3;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 329
    :cond_12
    invoke-static {v4}, Lio/dcloud/p/k3;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    return-object v0

    :catch_2
    move-exception v0

    .line 332
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "importClass "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/Exception;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_6

    .line 334
    :cond_13
    const-string v4, "__execCFunction"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_14

    goto/16 :goto_e

    .line 335
    :cond_14
    const-string v4, "__newObject"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_15

    .line 336
    aget-object v4, v3, v10

    .line 337
    aget-object v0, v3, v9

    invoke-static {v0}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 339
    :try_start_4
    invoke-static {v4}, Lio/dcloud/p/k3;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-static {v2, v1, v0, v3}, Lio/dcloud/p/j3;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/p/x2;Ljava/lang/Class;Lorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v0

    .line 340
    invoke-static {v2, v0}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    return-object v0

    :catch_3
    move-exception v0

    .line 342
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v5, "newObject "

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/Exception;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 343
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v8, "NativeObject.execMethod __newObject "

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_6

    .line 345
    :cond_15
    const-string v4, "__execStatic"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    const-string v12, "NativeObject.execMethod "

    const-string v13, "."

    if-eqz v4, :cond_19

    .line 346
    aget-object v0, v3, v10

    .line 347
    aget-object v4, v3, v9

    .line 348
    invoke-direct {v1, v0, v4, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/String;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;)Z

    move-result v9

    if-eqz v9, :cond_16

    goto/16 :goto_e

    .line 352
    :cond_16
    array-length v9, v3

    if-le v9, v5, :cond_17

    aget-object v9, v3, v5

    invoke-static {v9}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_17

    .line 353
    aget-object v3, v3, v5

    invoke-static {v3}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    move-object v5, v3

    goto :goto_3

    :cond_17
    move-object v5, v8

    .line 355
    :goto_3
    invoke-static {v0}, Lio/dcloud/p/k3;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    if-nez v3, :cond_18

    .line 358
    const-class v3, Ljava/lang/String;

    move-object/from16 v16, v3

    move-object v3, v0

    move-object v0, v2

    move-object/from16 v2, v16

    goto :goto_4

    :cond_18
    move-object v0, v2

    move-object v2, v3

    move-object v3, v8

    .line 362
    :goto_4
    :try_start_5
    invoke-static/range {v0 .. v5}, Lio/dcloud/p/j3;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/p/x2;Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Lorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v3
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    move-object v5, v2

    move-object v2, v0

    if-eqz v3, :cond_2a

    .line 364
    :try_start_6
    invoke-static {v2, v3}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    return-object v0

    :catch_4
    move-exception v0

    goto :goto_5

    :catch_5
    move-exception v0

    move-object v5, v2

    .line 367
    :goto_5
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "static "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/Exception;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 368
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6

    .line 370
    :cond_19
    const-string v4, "__exec"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1b

    .line 371
    aget-object v0, v3, v10

    .line 372
    aget-object v4, v3, v9

    .line 373
    invoke-direct {v1, v11, v4, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/String;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;)Z

    move-result v9

    if-eqz v9, :cond_1a

    goto/16 :goto_e

    .line 377
    :cond_1a
    aget-object v3, v3, v5

    invoke-static {v3}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 378
    invoke-virtual {v1, v2, v0}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/p/j3;

    move-result-object v5

    if-eqz v5, :cond_2a

    .line 381
    :try_start_7
    invoke-virtual {v5, v2, v4, v3}, Lio/dcloud/p/j3;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2a

    .line 383
    invoke-static {v2, v0}, Lio/dcloud/p/x2;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_6

    return-object v0

    :catch_6
    move-exception v0

    .line 386
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, v5, Lio/dcloud/p/j3;->b:Ljava/lang/Class;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/p/x2;->a(Ljava/lang/Exception;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 387
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_6
    return-object v2

    .line 390
    :cond_1b
    const-string v4, "__saveContent"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1c

    .line 391
    aget-object v0, v3, v10

    .line 392
    aget-object v3, v3, v9

    .line 393
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v4

    invoke-interface {v4}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v4

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v4, v2, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 394
    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-static {v2, v10, v0}, Lio/dcloud/common/adapter/io/DHFile;->writeFile([BILjava/lang/String;)V

    return-object v8

    .line 395
    :cond_1c
    const-string v4, "requestPermissions"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_25

    .line 396
    aget-object v0, v3, v9

    invoke-static {v0}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 397
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 398
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    .line 399
    new-instance v6, Lorg/json/JSONArray;

    invoke-direct {v6}, Lorg/json/JSONArray;-><init>()V

    .line 400
    new-instance v11, Lorg/json/JSONArray;

    invoke-direct {v11}, Lorg/json/JSONArray;-><init>()V

    .line 401
    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    const/4 v13, 0x0

    .line 402
    :goto_7
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v7

    if-ge v13, v7, :cond_1f

    .line 403
    invoke-virtual {v4, v13}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v7

    .line 404
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v14

    invoke-static {v14, v7}, Landroidx/core/content/PermissionChecker;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v14

    .line 405
    invoke-interface {v12, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    if-eqz v14, :cond_1e

    .line 414
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v14

    invoke-virtual {v14}, Landroid/app/Activity;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v14

    iget v14, v14, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v15, 0x17

    if-lt v14, v15, :cond_1d

    sget v14, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v14, v15, :cond_1d

    .line 415
    invoke-virtual {v0, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_8

    .line 418
    :cond_1d
    invoke-virtual {v11, v7}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move-object v7, v6

    .line 419
    invoke-direct/range {v1 .. v7}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V

    :goto_8
    move-object v7, v11

    goto :goto_9

    .line 420
    :cond_1e
    invoke-virtual {v5, v7}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p3

    move-object v7, v11

    .line 421
    invoke-direct/range {v1 .. v7}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V

    :goto_9
    add-int/lit8 v13, v13, 0x1

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p3

    move-object v11, v7

    goto :goto_7

    :cond_1f
    move-object v7, v11

    .line 436
    sget-object v1, Lio/dcloud/common/DHInterface/message/action/PermissionRequestAction;->TYPE_REQUEST:Ljava/lang/String;

    new-array v2, v10, [Ljava/lang/String;

    invoke-interface {v12, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    invoke-static {v1, v2}, Lio/dcloud/common/core/permission/PermissionControler;->invokeUTSAndroidPermissionRequest(Ljava/lang/String;[Ljava/lang/String;)V

    .line 438
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_20

    .line 439
    sget-object v0, Lio/dcloud/common/DHInterface/message/action/PermissionRequestAction;->TYPE_COMPLETE:Ljava/lang/String;

    new-array v1, v10, [Ljava/lang/String;

    invoke-interface {v12, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lio/dcloud/common/core/permission/PermissionControler;->invokeUTSAndroidPermissionRequest(Ljava/lang/String;[Ljava/lang/String;)V

    return-object v8

    .line 442
    :cond_20
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-gtz v1, :cond_21

    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_24

    .line 443
    :cond_21
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    const/4 v2, 0x0

    .line 444
    :goto_a
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v2, v3, :cond_22

    .line 445
    invoke-virtual {v5, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    :cond_22
    const/4 v2, 0x0

    .line 447
    :goto_b
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v2, v3, :cond_23

    .line 448
    invoke-virtual {v7, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    .line 450
    :cond_23
    sget-object v2, Lio/dcloud/common/DHInterface/message/action/PermissionRequestAction;->TYPE_COMPLETE:Ljava/lang/String;

    new-array v3, v10, [Ljava/lang/String;

    invoke-interface {v1, v3}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    invoke-static {v2, v1}, Lio/dcloud/common/core/permission/PermissionControler;->invokeUTSAndroidPermissionRequest(Ljava/lang/String;[Ljava/lang/String;)V

    .line 452
    :cond_24
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    move-object v11, v0

    check-cast v11, [Ljava/lang/String;

    .line 453
    new-instance v0, Lio/dcloud/p/x2$a;

    move-object/from16 v1, p0

    move-object/from16 v3, p1

    move-object v2, v5

    move-object v5, v4

    move-object/from16 v4, p3

    invoke-direct/range {v0 .. v7}, Lio/dcloud/p/x2$a;-><init>(Lio/dcloud/p/x2;Lorg/json/JSONArray;Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V

    .line 475
    invoke-virtual {v0, v9}, Lio/dcloud/common/adapter/util/PermissionUtil$Request;->setTriggerRequestEvent(Z)V

    .line 476
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {}, Lio/dcloud/common/adapter/util/PermissionUtil;->getRequestCode()I

    move-result v2

    invoke-static {v1, v11, v2, v0, v10}, Lio/dcloud/common/adapter/util/PermissionUtil;->requestSystemPermissions(Landroid/app/Activity;[Ljava/lang/String;ILio/dcloud/common/adapter/util/PermissionUtil$Request;Z)V

    return-object v8

    .line 477
    :cond_25
    const-string v1, "checkPermission"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2a

    .line 478
    aget-object v1, p3, v10

    .line 479
    aget-object v0, p3, v9

    .line 480
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-static {v2, v0}, Landroidx/core/content/PermissionChecker;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    const/4 v2, -0x2

    if-eq v0, v2, :cond_27

    const/4 v2, -0x1

    if-eq v0, v2, :cond_26

    if-eqz v0, :cond_28

    move v10, v0

    goto :goto_c

    :cond_26
    const/4 v10, -0x1

    goto :goto_c

    :cond_27
    const/4 v10, -0x2

    .line 496
    :cond_28
    :goto_c
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "{checkResult:+"

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, "}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 497
    sget v3, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v4, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-static/range {v0 .. v5}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-object v8

    .line 498
    :cond_29
    :goto_d
    aget-object v0, p3, v10

    .line 499
    invoke-static/range {p1 .. p1}, Lio/dcloud/p/x2;->a(Lio/dcloud/common/DHInterface/IWebview;)Ljava/util/HashMap;

    move-result-object v1

    if-eqz v1, :cond_2a

    .line 501
    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/dcloud/p/j3;

    if-eqz v0, :cond_2a

    .line 503
    invoke-virtual {v0}, Lio/dcloud/p/j3;->a()V

    :cond_2a
    :goto_e
    return-object v8
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .line 638
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    return-void
.end method

.method public onCallBack(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .line 1
    const-string v0, "close"

    invoke-static {p1, v0}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_0

    instance-of p1, p2, Lio/dcloud/common/DHInterface/IWebview;

    if-eqz p1, :cond_0

    .line 4
    :try_start_0
    move-object p1, p2

    check-cast p1, Lio/dcloud/common/DHInterface/IWebview;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object p1

    check-cast p1, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {p1, p0}, Lio/dcloud/common/adapter/ui/AdaFrameView;->removeFrameViewListener(Lio/dcloud/common/DHInterface/IEventCallback;)V

    .line 5
    iget-object p1, p0, Lio/dcloud/p/x2;->a:Ljava/util/ArrayList;

    move-object v0, p2

    check-cast v0, Lio/dcloud/common/DHInterface/IWebview;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 6
    sget-object p1, Lio/dcloud/p/x2;->b:Ljava/util/HashMap;

    check-cast p2, Lio/dcloud/common/DHInterface/IWebview;

    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result p2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/HashMap;

    if-eqz p1, :cond_0

    .line 8
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    .line 10
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_0

    .line 11
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/util/Map$Entry;

    .line 12
    sget-object v0, Lio/dcloud/p/x2;->b:Ljava/util/HashMap;

    invoke-interface {p2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 13
    invoke-interface {p2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lio/dcloud/p/j3;

    invoke-virtual {p2}, Lio/dcloud/p/j3;->a()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    .line 18
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_0
    const/4 p1, 0x0

    return-object p1
.end method
