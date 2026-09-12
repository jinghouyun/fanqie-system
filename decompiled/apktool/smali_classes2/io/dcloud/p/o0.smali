.class public abstract Lio/dcloud/p/o0;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field private static a:Ljava/lang/String; = ""

.field private static b:Ljava/lang/String; = ""


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .line 7
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const-string v1, ""

    if-eqz v0, :cond_0

    return-object v1

    .line 10
    :cond_0
    const-string v0, " "

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static a()Z
    .locals 3

    .line 1
    :try_start_0
    const-string v0, "com.huawei.system.BuildEx"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 2
    const-string v1, "getOsBrand"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 3
    invoke-virtual {v1, v0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 4
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    xor-int/lit8 v0, v0, 0x1

    return v0

    :catch_0
    move-exception v0

    .line 6
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    const/4 v0, 0x0

    return v0
.end method

.method public static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    invoke-static {p0}, Lio/dcloud/p/o0;->e(Ljava/lang/String;)V

    .line 4
    :cond_0
    sget-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    return-object p0
.end method

.method public static c(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    invoke-static {p0}, Lio/dcloud/p/o0;->e(Ljava/lang/String;)V

    .line 4
    :cond_0
    sget-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-object p0
.end method

.method private static d(Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    .line 1
    :try_start_0
    const-string v0, "android.os.SystemProperties"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 2
    const-string v1, "get"

    const/4 v2, 0x1

    new-array v3, v2, [Ljava/lang/Class;

    const-class v4, Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v4, v3, v5

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 3
    new-array v2, v2, [Ljava/lang/Object;

    aput-object p0, v2, v5

    invoke-virtual {v1, v0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    move-exception p0

    .line 6
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    const/4 p0, 0x0

    return-object p0
.end method

.method private static e(Ljava/lang/String;)V
    .locals 6

    const-string v0, "ro.build.version.magic"

    .line 1
    :try_start_0
    invoke-static {p0}, Lio/dcloud/p/o0;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    const-string v2, "ro.build.version.emui"

    const-string v3, "EMUI"

    const-string v4, "HarmonyOS"

    const-string v5, "hw_sc.build.platform.version"

    sparse-switch v1, :sswitch_data_0

    goto/16 :goto_2

    :sswitch_0
    :try_start_1
    const-string v0, "HUAWEI"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 3
    invoke-static {}, Lio/dcloud/p/o0;->a()Z

    move-result p0

    if-eqz p0, :cond_0

    .line 4
    invoke-static {v5}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    .line 5
    sput-object v4, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    return-void

    .line 7
    :cond_0
    sput-object v3, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 8
    invoke-static {v2}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 9
    :sswitch_1
    const-string v0, "REDMI"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    goto/16 :goto_0

    :sswitch_2
    const-string v0, "NUBIA"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 65
    const-string p0, "ro.build.nubia.rom.name"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 66
    const-string p0, "ro.build.nubia.rom.code"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 67
    :sswitch_3
    const-string v0, "MEIZU"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 118
    const-string p0, "Flyme"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 119
    const-string p0, "ro.build.display.id"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 120
    :sswitch_4
    const-string v1, "HONOR"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 131
    invoke-static {}, Lio/dcloud/p/o0;->a()Z

    move-result p0

    if-eqz p0, :cond_2

    .line 132
    sput-object v4, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 133
    invoke-static {v5}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p0

    if-nez p0, :cond_1

    .line 134
    invoke-static {v5}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 136
    :cond_1
    const-string p0, ""

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 138
    :cond_2
    invoke-static {v0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p0

    if-nez p0, :cond_3

    .line 139
    const-string p0, "MagicUI"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 140
    invoke-static {v0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 143
    :cond_3
    sput-object v3, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 144
    invoke-static {v2}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 145
    :sswitch_5
    const-string v0, "VIVO"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 186
    const-string p0, "Funtouch"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 187
    const-string p0, "ro.vivo.os.version"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 188
    :sswitch_6
    const-string v0, "OPPO"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    goto :goto_1

    :sswitch_7
    const-string v0, "ONEPLUS"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 234
    const-string p0, "HydrogenOS"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 235
    const-string p0, "ro.rom.version"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 236
    :sswitch_8
    const-string v0, "XIAOMI"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 266
    :goto_0
    const-string p0, "MIUI"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 267
    const-string p0, "ro.miui.ui.version.name"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 268
    :sswitch_9
    const-string v0, "REALME"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 304
    :goto_1
    const-string p0, "ColorOS"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 305
    const-string p0, "ro.build.version.opporom"

    invoke-static {p0}, Lio/dcloud/p/o0;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;

    return-void

    .line 328
    :cond_4
    :goto_2
    const-string p0, "Android"

    sput-object p0, Lio/dcloud/p/o0;->a:Ljava/lang/String;

    .line 329
    sget-object p0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    sput-object p0, Lio/dcloud/p/o0;->b:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    return-void

    :catch_0
    move-exception p0

    .line 333
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    return-void

    :sswitch_data_0
    .sparse-switch
        -0x7027944a -> :sswitch_9
        -0x65b21745 -> :sswitch_8
        -0x23e7db20 -> :sswitch_7
        0x251fa0 -> :sswitch_6
        0x2834ac -> :sswitch_5
        0x41bb44a -> :sswitch_4
        0x45d8cac -> :sswitch_3
        0x472cdb3 -> :sswitch_2
        0x4a3edcd -> :sswitch_1
        0x7fa995e7 -> :sswitch_0
    .end sparse-switch
.end method
