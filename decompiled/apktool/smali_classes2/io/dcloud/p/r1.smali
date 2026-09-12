.class public abstract Lio/dcloud/p/r1;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field public static final a:Ljava/util/List;

.field public static final b:Ljava/util/Map;

.field public static final c:Ljava/util/Map;

.field public static final d:Ljava/util/List;

.field public static final e:Ljava/util/List;

.field public static final f:Ljava/util/List;

.field public static final g:Lio/dcloud/p/q1$a;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Lio/dcloud/p/r1$a;

    invoke-direct {v0}, Lio/dcloud/p/r1$a;-><init>()V

    sput-object v0, Lio/dcloud/p/r1;->a:Ljava/util/List;

    .line 26
    new-instance v0, Lio/dcloud/p/r1$b;

    invoke-direct {v0}, Lio/dcloud/p/r1$b;-><init>()V

    sput-object v0, Lio/dcloud/p/r1;->b:Ljava/util/Map;

    .line 52
    new-instance v0, Lio/dcloud/p/r1$c;

    invoke-direct {v0}, Lio/dcloud/p/r1$c;-><init>()V

    sput-object v0, Lio/dcloud/p/r1;->c:Ljava/util/Map;

    .line 79
    new-instance v0, Lio/dcloud/p/r1$d;

    invoke-direct {v0}, Lio/dcloud/p/r1$d;-><init>()V

    sput-object v0, Lio/dcloud/p/r1;->d:Ljava/util/List;

    .line 105
    new-instance v0, Lio/dcloud/p/r1$e;

    invoke-direct {v0}, Lio/dcloud/p/r1$e;-><init>()V

    sput-object v0, Lio/dcloud/p/r1;->e:Ljava/util/List;

    .line 131
    new-instance v0, Lio/dcloud/p/r1$f;

    invoke-direct {v0}, Lio/dcloud/p/r1$f;-><init>()V

    sput-object v0, Lio/dcloud/p/r1;->f:Ljava/util/List;

    .line 161
    new-instance v0, Lio/dcloud/p/q1$a;

    sget-object v1, Lio/dcloud/p/q1$a$a;->c:Lio/dcloud/p/q1$a$a;

    const-string v2, "YHx8eHsyJydvaWs5JmxrZGd9bCZmbXwma2YnaXh4JW8nams="

    invoke-direct {v0, v2, v1}, Lio/dcloud/p/q1$a;-><init>(Ljava/lang/String;Lio/dcloud/p/q1$a$a;)V

    sput-object v0, Lio/dcloud/p/r1;->g:Lio/dcloud/p/q1$a;

    return-void
.end method

.method static synthetic a()Z
    .locals 1

    .line 1
    invoke-static {}, Lio/dcloud/p/r1;->c()Z

    move-result v0

    return v0
.end method

.method static synthetic b()Z
    .locals 1

    .line 1
    invoke-static {}, Lio/dcloud/p/r1;->d()Z

    move-result v0

    return v0
.end method

.method private static c()Z
    .locals 1

    .line 1
    :try_start_0
    const-string v0, "io.dcloud.common.DHInterface.IntlCallback"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    return v0

    :catch_0
    const/4 v0, 0x0

    return v0
.end method

.method private static d()Z
    .locals 2

    .line 1
    invoke-static {}, Lio/dcloud/p/l0;->b()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lio/dcloud/p/l0;->b()Ljava/lang/String;

    move-result-object v0

    const-string v1, "CN"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method
