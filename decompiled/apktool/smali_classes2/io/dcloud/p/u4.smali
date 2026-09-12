.class public abstract Lio/dcloud/p/u4;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field private static a:Ljava/lang/String; = ""

.field private static b:Ljava/lang/String;

.field private static c:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public static a(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    const/4 v0, 0x0

    .line 148
    :try_start_0
    invoke-static {p0}, Lio/dcloud/p/l1;->a(Landroid/content/Context;)Z

    .line 149
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ".imei.txt"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 150
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 151
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 152
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ".DC4278477faeb9.txt"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 153
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 168
    :cond_0
    invoke-virtual {v3}, Ljava/io/File;->isDirectory()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 169
    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    .line 171
    :cond_1
    invoke-static {v3, v0, v1, v0, p0}, Lio/dcloud/p/u4;->a(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object p0

    :catchall_0
    move-exception p0

    .line 176
    throw p0

    :catch_0
    move-exception p0

    .line 177
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    return-object v0
.end method

.method private static a(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .line 187
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    if-eqz p0, :cond_0

    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result p0

    if-nez p0, :cond_0

    .line 188
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 189
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    .line 192
    :cond_0
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object p0

    .line 193
    invoke-virtual {p0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object p0

    .line 194
    const-string p2, "-"

    const-string p3, ""

    invoke-virtual {p0, p2, p3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    const-string p2, "\n"

    invoke-virtual {p0, p2, p3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p0

    .line 195
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p2

    .line 197
    :try_start_0
    new-instance p3, Ljava/io/FileOutputStream;

    invoke-direct {p3, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 198
    invoke-virtual {p3, p2}, Ljava/io/FileOutputStream;->write([B)V

    .line 199
    invoke-virtual {p3}, Ljava/io/OutputStream;->flush()V

    .line 200
    invoke-virtual {p3}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    move-exception p1

    .line 204
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception p1

    .line 205
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_0
    return-object p0
.end method

.method public static a(Landroid/content/Context;ZZ)Ljava/lang/String;
    .locals 11

    .line 2
    const-string v0, "\n"

    const/4 v1, 0x0

    const/4 v2, 0x2

    :try_start_0
    const-class v3, Lio/dcloud/common/util/TelephonyUtil;

    sget-object v4, Lio/dcloud/common/util/TelephonyUtil;->TAG:Ljava/lang/String;

    .line 3
    const-string v4, "getSBBS"

    const/4 v5, 0x4

    new-array v6, v5, [Ljava/lang/Class;

    const-class v7, Landroid/content/Context;

    const/4 v8, 0x0

    aput-object v7, v6, v8

    sget-object v7, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    const/4 v9, 0x1

    aput-object v7, v6, v9

    aput-object v7, v6, v2

    const/4 v10, 0x3

    aput-object v7, v6, v10

    invoke-virtual {v3, v4, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 4
    invoke-static {}, Lio/dcloud/p/b0;->a()Lio/dcloud/p/b0;

    move-result-object v4

    invoke-virtual {v4, p0}, Lio/dcloud/p/b0;->a(Landroid/content/Context;)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p0, v5, v8

    sget-object v6, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    aput-object v6, v5, v9

    aput-object v6, v5, v2

    aput-object v4, v5, v10

    invoke-virtual {v3, v1, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v3

    :catch_0
    move-exception v3

    .line 6
    sget-boolean v4, Lio/dcloud/p/w0;->a:Z

    if-eqz v4, :cond_0

    .line 7
    invoke-virtual {v3}, Ljava/lang/Throwable;->printStackTrace()V

    .line 10
    :cond_0
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "|"

    if-eqz p1, :cond_1

    .line 13
    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_1
    const-string v5, ""

    if-nez p0, :cond_3

    if-eqz p1, :cond_2

    .line 16
    const-string v5, "|||||"

    :cond_2
    return-object v5

    :cond_3
    if-eqz p2, :cond_5

    if-eqz p1, :cond_4

    .line 19
    sget-object v6, Lio/dcloud/p/u4;->c:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 20
    sget-object p0, Lio/dcloud/p/u4;->c:Ljava/lang/String;

    return-object p0

    .line 22
    :cond_4
    sget-object v6, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    invoke-static {v6}, Lio/dcloud/p/u4;->a(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_7

    if-nez p1, :cond_7

    .line 23
    sget-object p0, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    return-object p0

    :cond_5
    if-eqz p1, :cond_6

    .line 27
    sget-object v6, Lio/dcloud/p/u4;->b:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_6

    .line 28
    sget-object p0, Lio/dcloud/p/u4;->b:Ljava/lang/String;

    return-object p0

    .line 30
    :cond_6
    sget-object v6, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    invoke-static {v6}, Lio/dcloud/p/u4;->a(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_7

    if-nez p1, :cond_7

    .line 31
    sget-object p0, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    return-object p0

    .line 35
    :cond_7
    invoke-static {p0}, Lio/dcloud/p/y1;->e(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v6

    .line 37
    sget-object v7, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    invoke-static {v7}, Lio/dcloud/p/u4;->a(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_9

    if-eqz p1, :cond_8

    goto :goto_0

    .line 48
    :cond_8
    sget-object p0, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    return-object p0

    :cond_9
    :goto_0
    if-eqz v6, :cond_a

    .line 49
    const-string v7, ","

    invoke-static {v7, v6}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    sput-object v6, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    goto :goto_1

    .line 51
    :cond_a
    sput-object v5, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    :goto_1
    if-eqz p1, :cond_b

    .line 54
    sget-object v6, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_b
    if-eqz p1, :cond_c

    .line 62
    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 65
    :cond_c
    sget-object v6, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    invoke-static {v6}, Lio/dcloud/p/u4;->a(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_e

    if-eqz p1, :cond_d

    goto :goto_2

    .line 75
    :cond_d
    sget-object p0, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    return-object p0

    .line 76
    :cond_e
    :goto_2
    invoke-static {p0}, Lio/dcloud/p/y1;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    if-eqz v6, :cond_f

    .line 78
    sput-object v7, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    :cond_f
    if-eqz p1, :cond_11

    .line 81
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_10

    move-object v7, v5

    :cond_10
    invoke-virtual {v3, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 88
    :cond_11
    sget-object v6, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    invoke-static {v6}, Lio/dcloud/p/u4;->a(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_13

    if-eqz p1, :cond_12

    goto :goto_3

    .line 113
    :cond_12
    sget-object p0, Lio/dcloud/p/u4;->a:Ljava/lang/String;

    return-object p0

    .line 114
    :cond_13
    :goto_3
    :try_start_1
    invoke-static {p0}, Lio/dcloud/p/u4;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    if-eqz v6, :cond_14

    .line 116
    sput-object v1, Lio/dcloud/p/u4;->a:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_14
    if-eqz p1, :cond_16

    .line 122
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p0

    if-eqz p0, :cond_15

    goto :goto_4

    :catchall_0
    move-exception p0

    goto :goto_5

    :catch_1
    move-exception p0

    .line 123
    :try_start_2
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    if-eqz p1, :cond_16

    .line 126
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p0

    if-eqz p0, :cond_15

    goto :goto_4

    .line 122
    :cond_15
    invoke-virtual {v1, v0, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    :goto_4
    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object p0

    invoke-virtual {p0, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 129
    :cond_16
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {}, Lio/dcloud/p/f1;->b()Ljava/lang/String;

    move-result-object p1

    invoke-static {}, Lio/dcloud/p/f1;->a()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lio/dcloud/p/d;->b([BLjava/lang/String;Ljava/lang/String;)[B

    move-result-object p0

    .line 130
    invoke-static {p0, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object p0

    .line 131
    invoke-static {p0}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 132
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, "&ie=1"

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 134
    sput-object p0, Lio/dcloud/p/u4;->b:Ljava/lang/String;

    .line 135
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    sput-object p0, Lio/dcloud/p/u4;->c:Ljava/lang/String;

    if-eqz p2, :cond_17

    return-object p0

    .line 144
    :cond_17
    sget-object p0, Lio/dcloud/p/u4;->b:Ljava/lang/String;

    return-object p0

    :goto_5
    if-eqz p1, :cond_19

    .line 145
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_18

    goto :goto_6

    :cond_18
    invoke-virtual {v1, v0, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    :goto_6
    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object p1

    invoke-virtual {p1, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 147
    :cond_19
    throw p0
.end method

.method private static a(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    .locals 4

    .line 178
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result p2

    const-string p3, ".DC4278477faeb9.txt"

    if-eqz p2, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->length()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long p2, v0, v2

    if-lez p2, :cond_0

    .line 180
    :try_start_0
    new-instance p2, Ljava/io/FileInputStream;

    invoke-direct {p2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-static {p2}, Lio/dcloud/p/u4;->a(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    .line 183
    :catch_0
    invoke-static {p4, p0, p1, p3}, Lio/dcloud/p/u4;->a(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 186
    :cond_0
    invoke-static {p4, p0, p1, p3}, Lio/dcloud/p/u4;->a(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static a(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 0

    if-nez p0, :cond_0

    .line 206
    const-string p0, ""

    return-object p0

    .line 208
    :cond_0
    invoke-static {p0}, Lio/dcloud/p/u4;->b(Ljava/io/InputStream;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static a(Ljava/lang/String;)Z
    .locals 1

    .line 1
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "Unknown"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "00000000"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result p0

    if-eqz p0, :cond_0

    goto :goto_0

    :cond_0
    const/4 p0, 0x0

    return p0

    :cond_1
    :goto_0
    const/4 p0, 0x1

    return p0
.end method

.method private static b(Ljava/io/InputStream;)Ljava/lang/StringBuilder;
    .locals 3

    if-nez p0, :cond_0

    const/4 p0, 0x0

    return-object p0

    .line 1
    :cond_0
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    invoke-direct {v1, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    :goto_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 5
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 7
    :cond_1
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V

    return-object v1
.end method
