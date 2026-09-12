.class public Lio/dcloud/js/file/FileFeatureImpl;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/IFeature;


# static fields
.field private static a:Ljava/lang/String;

.field private static b:Ljava/lang/String;

.field private static c:Ljava/lang/String;

.field private static d:Ljava/lang/String;

.field private static e:Ljava/lang/String;


# direct methods
.method public static synthetic $r8$lambda$K17Xw3biRP98C5KXwaG97KBlGmY(Lio/dcloud/js/file/FileFeatureImpl;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct/range {p0 .. p6}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Landroid/content/Context;I)Ljava/lang/String;
    .locals 5

    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x2

    .line 235
    const-string v3, "{code:%d,message:\'%s\'}"

    packed-switch p2, :pswitch_data_0

    .line 280
    :pswitch_0
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_unknown_error:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 281
    :pswitch_1
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    new-array p2, v2, [Ljava/lang/Object;

    aput-object p1, p2, v1

    sget-object p1, Lio/dcloud/common/constant/DOMException;->MSG_PATH_NOT_PRIVATE_ERROR:Ljava/lang/String;

    aput-object p1, p2, v0

    invoke-static {v3, p2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 282
    :pswitch_2
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_path_not_exist:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 283
    :pswitch_3
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_path_exists:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 284
    :pswitch_4
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_type_mismatch:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 285
    :pswitch_5
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_perform_error:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 286
    :pswitch_6
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_invalid_modification:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 287
    :pswitch_7
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_grammar_mistakes:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 288
    :pswitch_8
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_invalid_state:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 289
    :pswitch_9
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_no_modification_allowed:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 290
    :pswitch_a
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_coding_error:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 291
    :pswitch_b
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_file_not_read:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 292
    :pswitch_c
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_common_cancel:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 293
    :pswitch_d
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_without_authorization:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 294
    :pswitch_e
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget v4, Lio/dcloud/base/R$string;->dcloud_io_file_not_found:I

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p2, v2, v1

    aput-object p1, v2, v0

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private a(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 7

    .line 209
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 210
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    const-string v2, "PRIVATE_WWW"

    const-string v3, "fsRoot"

    const-string v4, "fsName"

    const-string v5, "type"

    const/4 v6, 0x1

    if-eqz v1, :cond_0

    .line 211
    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 212
    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 213
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    invoke-direct {p0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, v1, p1, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object p1

    invoke-virtual {v0, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    return-object v0

    .line 214
    :cond_0
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v1, 0x2

    .line 215
    invoke-virtual {v0, v5, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 216
    const-string v1, "PRIVATE_DOCUMENTS"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 217
    sget-object v2, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    invoke-direct {p0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, v2, p1, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object p1

    invoke-virtual {v0, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    return-object v0

    .line 218
    :cond_1
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x3

    .line 219
    invoke-virtual {v0, v5, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 220
    const-string v1, "PUBLIC_DOCUMENTS"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 221
    sget-object v2, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    invoke-direct {p0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, v2, p1, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object p1

    invoke-virtual {v0, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    return-object v0

    .line 222
    :cond_2
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const/4 v1, 0x4

    .line 223
    invoke-virtual {v0, v5, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 224
    const-string v1, "PUBLIC_DOWNLOADS"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 225
    sget-object v2, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    invoke-direct {p0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, v2, p1, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object p1

    invoke-virtual {v0, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    return-object v0

    .line 226
    :cond_3
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->b:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 227
    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 228
    invoke-virtual {v0, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 229
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->b:Ljava/lang/String;

    invoke-direct {p0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, v1, p1, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object p1

    invoke-virtual {v0, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    return-object v0

    .line 230
    :cond_4
    invoke-static {p1}, Lio/dcloud/common/util/PdrUtil;->isDeviceRootDir(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    const/4 v1, 0x5

    .line 231
    invoke-virtual {v0, v5, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 232
    const-string v1, "PUBLIC_DEVICE_ROOT"

    invoke-virtual {v0, v4, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 233
    sget-object v2, Lio/dcloud/common/adapter/util/DeviceInfo;->sDeviceRootDir:Ljava/lang/String;

    invoke-direct {p0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, v2, p1, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object p1

    invoke-virtual {v0, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_5
    return-object v0
.end method

.method private a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 7

    .line 234
    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lio/dcloud/js/file/FileFeatureImpl;->a(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v3

    sget v4, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v5, 0x1

    const/4 v6, 0x0

    move-object v1, p2

    move-object v2, p3

    invoke-static/range {v1 .. v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IApp;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 8

    const/4 v0, 0x0

    .line 31
    aget-object v3, p3, v0

    .line 32
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    filled-new-array {v3}, [Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const/16 p2, 0xf

    .line 34
    invoke-direct {p0, p2, p1, p4}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void

    .line 37
    :cond_0
    invoke-interface {p2, v3}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v1

    const/4 v2, 0x1

    .line 38
    aget-object v2, p3, v2

    invoke-static {v2, v0}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v5

    const/4 v0, 0x2

    .line 39
    aget-object p3, p3, v0

    const/4 v0, -0x1

    invoke-static {p3, v0}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v4

    if-eqz v1, :cond_1

    .line 40
    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IApp;->isOnAppRunningMode()Z

    move-result p2

    if-eqz p2, :cond_1

    const/16 p2, 0xa

    .line 41
    invoke-direct {p0, p2, p1, p4}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void

    .line 43
    :cond_1
    new-instance v1, Lio/dcloud/js/file/FileFeatureImpl$g;

    move-object v2, p0

    move-object v6, p1

    move-object v7, p4

    invoke-direct/range {v1 .. v7}, Lio/dcloud/js/file/FileFeatureImpl$g;-><init>(Lio/dcloud/js/file/FileFeatureImpl;Ljava/lang/String;IILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-static {v1}, Lio/dcloud/common/adapter/util/AsyncTaskHandler;->executeThreadTask(Lio/dcloud/common/adapter/util/AsyncTaskHandler$IAsyncTaskListener;)V

    return-void
.end method

.method private synthetic a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 8

    const/4 v1, 0x0

    .line 3
    :try_start_0
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p2

    invoke-virtual {v0, p2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 4
    invoke-static {v1, p3}, Lio/dcloud/common/util/Md5Utils;->md5(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 5
    new-instance p3, Lorg/json/JSONObject;

    invoke-direct {p3}, Lorg/json/JSONObject;-><init>()V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 7
    :try_start_1
    const-string v0, "size"

    invoke-virtual {p3, v0, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    if-eqz p2, :cond_0

    .line 9
    const-string p4, "digest"

    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p2, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p3, p4, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 12
    :catch_0
    :cond_0
    :try_start_2
    invoke-virtual {p3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    sget v5, Lio/dcloud/common/util/JSUtil;->OK:I
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v2, p1

    move-object v3, p5

    :try_start_3
    invoke-static/range {v2 .. v7}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    if-eqz v1, :cond_1

    goto :goto_1

    :catch_1
    move-object v2, p1

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object p1, v0

    goto :goto_3

    :catch_2
    :goto_0
    const/16 p1, 0xf

    .line 21
    :try_start_4
    invoke-direct {p0, p1, v2, p6}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    if-eqz v1, :cond_1

    .line 18
    :goto_1
    :try_start_5
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    goto :goto_2

    :catch_3
    move-exception v0

    move-object p1, v0

    .line 20
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_1
    :goto_2
    return-void

    :goto_3
    if-eqz v1, :cond_2

    .line 25
    :try_start_6
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_4

    :catch_4
    move-exception v0

    move-object p2, v0

    .line 27
    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 30
    :cond_2
    :goto_4
    throw p1
.end method

.method static synthetic a(Lio/dcloud/js/file/FileFeatureImpl;ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lio/dcloud/js/file/FileFeatureImpl;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1, p2, p3}, Lio/dcloud/js/file/FileFeatureImpl;->a(Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 13

    const-string v0, "/"

    const-string v1, "{code:%d,message:\'%s\'}"

    const-string v2, "file://"

    const/4 v3, 0x2

    const/16 v4, 0xd

    const/4 v5, 0x0

    const/4 v6, 0x1

    .line 295
    :try_start_0
    new-instance v7, Landroid/graphics/BitmapFactory$Options;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_3

    :try_start_1
    invoke-direct {v7}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 296
    iput-boolean v6, v7, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 297
    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8, p1}, Lio/dcloud/common/util/FileUtil;->checkPrivatePath(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v8
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_3

    const-string v9, "Orientation"

    const/4 v10, 0x0

    if-nez v8, :cond_1

    :try_start_2
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v11, 0x18

    if-lt v8, v11, :cond_1

    .line 299
    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8, p1}, Lio/dcloud/common/util/FileUtil;->getFileInputStream(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v8

    if-eqz v8, :cond_0

    .line 301
    invoke-static {v8, v10, v7}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 302
    invoke-static {}, Lio/dcloud/p/g4$$ExternalSyntheticApiModelOutline0;->m$4()V

    invoke-static {v8}, Lio/dcloud/p/g4$$ExternalSyntheticApiModelOutline0;->m(Ljava/io/InputStream;)Landroid/media/ExifInterface;

    move-result-object v11

    .line 303
    invoke-virtual {v11, v9}, Landroid/media/ExifInterface;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 304
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :cond_0
    move-object v9, v10

    goto :goto_0

    :catch_0
    move-exception v0

    move-object p1, v0

    move-object/from16 v8, p3

    goto/16 :goto_6

    .line 307
    :cond_1
    :try_start_3
    new-instance v8, Landroid/media/ExifInterface;

    invoke-direct {v8, p1}, Landroid/media/ExifInterface;-><init>(Ljava/lang/String;)V

    .line 308
    invoke-virtual {v8, v9}, Landroid/media/ExifInterface;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 309
    invoke-static {p1, v7}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 312
    :goto_0
    iget v8, v7, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .line 313
    iget v11, v7, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 314
    iget-object v7, v7, Landroid/graphics/BitmapFactory$Options;->outMimeType:Ljava/lang/String;

    .line 315
    invoke-static {v7}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v12
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    if-nez v12, :cond_2

    :try_start_4
    invoke-virtual {v7, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 316
    invoke-virtual {v7, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 317
    array-length v7, v0

    sub-int/2addr v7, v6

    aget-object v7, v0, v7
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_0

    .line 320
    :cond_2
    :try_start_5
    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_3

    if-nez v0, :cond_4

    .line 321
    :try_start_6
    invoke-virtual {v9}, Ljava/lang/String;->hashCode()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    goto :goto_2

    :pswitch_0
    const-string v0, "8"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 346
    const-string v0, "left"

    goto :goto_3

    .line 347
    :pswitch_1
    const-string v0, "7"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 369
    const-string v0, "right-mirrored"

    goto :goto_3

    .line 370
    :pswitch_2
    const-string v0, "6"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 389
    const-string v0, "right"

    goto :goto_3

    .line 390
    :pswitch_3
    const-string v0, "5"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 406
    const-string v0, "left-mirrored"

    goto :goto_3

    .line 407
    :pswitch_4
    const-string v0, "4"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 420
    const-string v0, "down-mirrored"

    goto :goto_3

    .line 421
    :pswitch_5
    const-string v0, "3"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 431
    const-string v0, "down"

    goto :goto_3

    .line 432
    :pswitch_6
    const-string v0, "2"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 439
    const-string v0, "up-mirrored"

    goto :goto_3

    .line 440
    :pswitch_7
    const-string v0, "1"

    goto :goto_1

    .line 441
    :pswitch_8
    const-string v0, "0"

    :goto_1
    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 445
    :cond_3
    :goto_2
    const-string v0, "up"
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_0

    :goto_3
    move-object v10, v0

    .line 471
    :cond_4
    :try_start_7
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 472
    const-string v9, "path"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, v9, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 473
    const-string p1, "width"

    invoke-virtual {v0, p1, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 474
    const-string p1, "height"

    invoke-virtual {v0, p1, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 475
    const-string p1, "orientation"

    invoke-virtual {v0, p1, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 476
    const-string p1, "type"

    invoke-static {v7}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    goto :goto_4

    :cond_5
    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v7, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v7

    :goto_4
    invoke-virtual {v0, p1, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 477
    sget p1, Lio/dcloud/common/util/JSUtil;->OK:I
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Lorg/json/JSONException; {:try_start_7 .. :try_end_7} :catch_3

    move-object/from16 v8, p3

    :try_start_8
    invoke-static {p2, v8, v0, p1, v5}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_4
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_1

    return-void

    :catch_1
    move-exception v0

    goto :goto_5

    :catch_2
    move-exception v0

    move-object/from16 v8, p3

    goto :goto_7

    :catch_3
    move-exception v0

    move-object/from16 v8, p3

    :goto_5
    move-object p1, v0

    .line 481
    :goto_6
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    new-array v2, v3, [Ljava/lang/Object;

    aput-object v0, v2, v5

    aput-object p1, v2, v6

    invoke-static {v1, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    sget v10, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v11, 0x1

    const/4 v12, 0x0

    move-object v7, p2

    invoke-static/range {v7 .. v12}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    goto :goto_8

    :catch_4
    move-exception v0

    :goto_7
    move-object p1, v0

    .line 482
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    new-array v2, v3, [Ljava/lang/Object;

    aput-object v0, v2, v5

    aput-object p1, v2, v6

    invoke-static {v1, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    sget v10, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v11, 0x1

    const/4 v12, 0x0

    move-object v7, p2

    move-object/from16 v8, p3

    invoke-static/range {v7 .. v12}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    :goto_8
    return-void

    :pswitch_data_0
    .packed-switch 0x30
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 17

    const-string v0, "90"

    .line 44
    invoke-static/range {p1 .. p1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1d

    invoke-static/range {p1 .. p1}, Lio/dcloud/common/util/PdrUtil;->isNetPath(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1d

    .line 45
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v1

    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v3, p1

    invoke-interface {v1, v2, v3}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 46
    const-string v2, "apps/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 47
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 48
    :cond_0
    const-string v2, "/android_asset/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    const-string v3, ""

    if-eqz v2, :cond_1

    .line 49
    const-string v2, "/android_asset"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 50
    :cond_1
    const-string v2, "android_asset/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 51
    const-string v2, "android_asset"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 53
    :cond_2
    :goto_0
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v2

    invoke-interface {v2, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDirAndCopy2Temp(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 54
    const-string v2, "content://"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    const/4 v4, 0x2

    const/4 v5, 0x0

    if-nez v3, :cond_5

    .line 56
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v3

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v6

    invoke-static {v3, v6}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v1}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    goto :goto_1

    :cond_3
    const/16 v0, 0xf

    move-object/from16 v3, p0

    move-object/from16 v6, p2

    move-object/from16 v7, p3

    .line 58
    invoke-direct {v3, v0, v7, v6}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void

    :cond_4
    :goto_1
    move-object/from16 v3, p0

    move-object/from16 v6, p2

    move-object/from16 v7, p3

    .line 61
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_6

    const/4 v0, -0x4

    .line 62
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-array v1, v4, [Ljava/lang/Object;

    aput-object v0, v1, v5

    sget-object v0, Lio/dcloud/common/constant/DOMException;->MSG_FILE_NOT_EXIST:Ljava/lang/String;

    const/4 v2, 0x1

    aput-object v0, v1, v2

    const-string v0, "{code:%d,message:\'%s\'}"

    invoke-static {v0, v1}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 63
    sget v7, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v8, 0x1

    const/4 v9, 0x0

    move-object/from16 v4, p3

    move-object v5, v6

    move-object v6, v0

    invoke-static/range {v4 .. v9}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-void

    :cond_5
    move-object/from16 v3, p0

    .line 69
    :cond_6
    :try_start_0
    new-instance v6, Landroid/media/MediaMetadataRetriever;

    invoke-direct {v6}, Landroid/media/MediaMetadataRetriever;-><init>()V

    .line 70
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v1}, Lio/dcloud/common/util/FileUtil;->checkPrivatePath(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 71
    invoke-virtual {v6, v1}, Landroid/media/MediaMetadataRetriever;->setDataSource(Ljava/lang/String;)V

    goto :goto_2

    .line 73
    :cond_7
    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 75
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 76
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v6, v8, v7}, Landroid/media/MediaMetadataRetriever;->setDataSource(Landroid/content/Context;Landroid/net/Uri;)V

    goto :goto_2

    .line 78
    :cond_8
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v1}, Lio/dcloud/common/util/FileUtil;->getVideoFileUri(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    if-eqz v7, :cond_9

    .line 80
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-virtual {v6, v8, v7}, Landroid/media/MediaMetadataRetriever;->setDataSource(Landroid/content/Context;Landroid/net/Uri;)V

    :cond_9
    :goto_2
    const/16 v7, 0x9

    .line 85
    invoke-virtual {v6, v7}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x12

    .line 86
    invoke-virtual {v6, v8}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v8

    const/16 v9, 0x13

    .line 87
    invoke-virtual {v6, v9}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x18

    .line 88
    invoke-virtual {v6, v10}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v10

    .line 89
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11}, Lorg/json/JSONObject;-><init>()V

    .line 90
    const-string v12, "getVideoInfo"

    move-object/from16 v13, p4

    invoke-virtual {v13, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_1b

    .line 92
    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_8

    const-string v14, "270"

    if-nez v12, :cond_a

    :try_start_1
    invoke-virtual {v14, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_b

    :cond_a
    move-object/from16 v16, v9

    move-object v9, v8

    move-object/from16 v8, v16

    :cond_b
    if-eqz v8, :cond_c

    if-eqz v9, :cond_c

    .line 102
    const-string v12, "resolution"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/high16 p1, 0x447a0000    # 1000.0f

    const-string v13, "*"

    invoke-virtual {v15, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v15, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v11, v12, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_8

    goto :goto_3

    :cond_c
    const/high16 p1, 0x447a0000    # 1000.0f

    :goto_3
    if-eqz v8, :cond_d

    .line 106
    :try_start_2
    const-string v12, "width"

    invoke-static {v8}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v8

    float-to-double v4, v8

    invoke-virtual {v11, v12, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;

    :cond_d
    if-eqz v9, :cond_e

    .line 109
    const-string v4, "height"

    invoke-static {v9}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v5

    float-to-double v8, v5

    invoke-virtual {v11, v4, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 112
    :catch_0
    :cond_e
    :try_start_3
    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_8

    const-string v4, "size"

    if-eqz v2, :cond_10

    .line 113
    :try_start_4
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_8

    if-eqz v2, :cond_f

    .line 116
    :try_start_5
    invoke-virtual {v2}, Ljava/io/InputStream;->available()I

    move-result v5

    invoke-virtual {v11, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_4

    :catchall_0
    move-exception v0

    goto :goto_5

    :catch_1
    const/4 v15, 0x0

    .line 122
    :try_start_6
    invoke-virtual {v11, v4, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 121
    :goto_4
    :try_start_7
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_8

    :catch_2
    const/4 v15, 0x0

    goto :goto_6

    .line 125
    :goto_5
    :try_start_8
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_3
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_8

    .line 128
    :catch_3
    :try_start_9
    throw v0

    :cond_f
    const/4 v15, 0x0

    .line 130
    invoke-virtual {v11, v4, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    goto :goto_6

    :cond_10
    const/4 v15, 0x0

    .line 133
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v8

    invoke-virtual {v11, v4, v8, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    :goto_6
    const/16 v2, 0x20

    .line 135
    invoke-virtual {v6, v2}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v2

    .line 136
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_8

    const-string v5, "fps"

    if-eqz v4, :cond_14

    .line 137
    :try_start_a
    new-instance v2, Landroid/media/MediaExtractor;

    invoke-direct {v2}, Landroid/media/MediaExtractor;-><init>()V

    .line 138
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v1}, Lio/dcloud/common/util/FileUtil;->checkPrivatePath(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_11

    .line 139
    invoke-virtual {v2, v1}, Landroid/media/MediaExtractor;->setDataSource(Ljava/lang/String;)V

    goto :goto_7

    .line 141
    :cond_11
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v1}, Lio/dcloud/common/util/FileUtil;->getVideoFileUri(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    if-eqz v1, :cond_12

    .line 143
    invoke-interface/range {p3 .. p3}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    const/4 v8, 0x0

    invoke-virtual {v2, v4, v1, v8}, Landroid/media/MediaExtractor;->setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V

    .line 146
    :cond_12
    :goto_7
    invoke-virtual {v2}, Landroid/media/MediaExtractor;->getTrackCount()I

    move-result v1

    :goto_8
    if-ge v15, v1, :cond_15

    .line 148
    invoke-virtual {v2, v15}, Landroid/media/MediaExtractor;->getTrackFormat(I)Landroid/media/MediaFormat;

    move-result-object v4
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_8

    .line 150
    :try_start_b
    const-string v8, "mime"

    invoke-virtual {v4, v8}, Landroid/media/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 151
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_13

    const-string v9, "video/"

    invoke-virtual {v8, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_13

    .line 152
    const-string v8, "frame-rate"

    invoke-virtual {v4, v8}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v4

    .line 153
    invoke-virtual {v11, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_4

    :catch_4
    :cond_13
    add-int/lit8 v15, v15, 0x1

    goto :goto_8

    .line 159
    :cond_14
    :try_start_c
    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    div-float/2addr v1, v2

    mul-float v1, v1, p1

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v1

    invoke-virtual {v11, v5, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_5

    .line 161
    :catch_5
    :cond_15
    :try_start_d
    invoke-virtual {v10}, Ljava/lang/String;->hashCode()I

    move-result v1

    const/16 v2, 0x717

    if-eq v1, v2, :cond_18

    const v0, 0xbee9

    if-eq v1, v0, :cond_17

    const v0, 0xc28b

    if-eq v1, v0, :cond_16

    goto :goto_9

    :cond_16
    invoke-virtual {v10, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 166
    const-string v0, "left"

    goto :goto_a

    .line 167
    :cond_17
    const-string v0, "180"

    invoke-virtual {v10, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 175
    const-string v0, "down"

    goto :goto_a

    .line 176
    :cond_18
    invoke-virtual {v10, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 178
    const-string v0, "right"

    goto :goto_a

    .line 187
    :cond_19
    :goto_9
    const-string v0, "up"

    .line 189
    :goto_a
    const-string v1, "orientation"

    invoke-virtual {v11, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    const/16 v0, 0xc

    .line 190
    invoke-virtual {v6, v0}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v0

    .line 191
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1a

    .line 192
    const-string v1, "type"

    invoke-virtual {v11, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_1a
    const/16 v0, 0x14

    .line 194
    invoke-virtual {v6, v0}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v0

    .line 195
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_8

    if-nez v1, :cond_1c

    .line 196
    :try_start_e
    const-string v1, "bitrate"

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    div-int/lit16 v0, v0, 0x3e8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v11, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_6

    goto :goto_b

    :cond_1b
    const/high16 p1, 0x447a0000    # 1000.0f

    .line 199
    :catch_6
    :cond_1c
    :goto_b
    :try_start_f
    const-string v0, "duration"

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    div-float v1, v1, p1

    float-to-double v1, v1

    invoke-static {v1, v2}, Ljava/math/BigDecimal;->valueOf(D)Ljava/math/BigDecimal;

    move-result-object v1

    const/4 v2, 0x4

    const/4 v13, 0x2

    invoke-virtual {v1, v13, v2}, Ljava/math/BigDecimal;->setScale(II)Ljava/math/BigDecimal;

    move-result-object v1

    invoke-virtual {v11, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_7

    .line 200
    :catch_7
    :try_start_10
    invoke-virtual {v11}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    sget v7, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v8, 0x1

    const/4 v9, 0x0

    move-object/from16 v5, p2

    move-object/from16 v4, p3

    invoke-static/range {v4 .. v9}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_8

    goto :goto_c

    :catch_8
    move-exception v0

    .line 202
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 204
    :try_start_11
    const-string v2, "code"

    const/16 v4, 0xd

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 205
    const-string v2, "message"

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_11
    .catch Lorg/json/JSONException; {:try_start_11 .. :try_end_11} :catch_9

    .line 208
    :catch_9
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    sget v7, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v8, 0x1

    const/4 v9, 0x0

    move-object/from16 v5, p2

    move-object/from16 v4, p3

    invoke-static/range {v4 .. v9}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    goto :goto_c

    :cond_1d
    move-object/from16 v3, p0

    :goto_c
    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .locals 3

    .line 483
    array-length v0, p2

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-le v0, v2, :cond_0

    aget-object v0, p2, v2

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 485
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    aget-object p2, p2, v2

    invoke-direct {v0, p2}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lio/dcloud/common/util/JSUtil;->jsonArrayToStringArr(Lorg/json/JSONArray;)[Ljava/lang/String;

    move-result-object p1
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p2

    .line 487
    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    const/16 p2, 0x8

    .line 488
    invoke-direct {p0, p2, p1, p3}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    :cond_0
    return-object v1
.end method

.method public static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .line 51
    invoke-static {p0}, Landroid/webkit/MimeTypeMap;->getFileExtensionFromUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_0

    .line 53
    invoke-static {}, Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;

    move-result-object v0

    .line 54
    invoke-virtual {v0, p0}, Landroid/webkit/MimeTypeMap;->getMimeTypeFromExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_0
    const/4 p0, 0x0

    return-object p0
.end method

.method private b(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 8

    const/4 v0, 0x0

    .line 1
    :try_start_0
    aget-object v7, p2, v0

    .line 2
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v0

    filled-new-array {v7}, [Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/16 p2, 0xf

    .line 4
    invoke-direct {p0, p2, p1, p3}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void

    .line 7
    :cond_0
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v0

    .line 8
    invoke-interface {v0, v7}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v0

    const/4 v1, 0x2

    .line 9
    aget-object v1, p2, v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v6

    const/4 v1, 0x1

    .line 10
    aget-object v1, p2, v1

    if-eqz v1, :cond_2

    if-eqz v0, :cond_1

    goto :goto_0

    .line 14
    :cond_1
    new-instance v1, Lio/dcloud/js/file/FileFeatureImpl$f;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v2, p0

    move-object v4, p1

    move-object v3, p2

    move-object v5, p3

    :try_start_1
    invoke-direct/range {v1 .. v7}, Lio/dcloud/js/file/FileFeatureImpl$f;-><init>(Lio/dcloud/js/file/FileFeatureImpl;[Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;ILjava/lang/String;)V

    invoke-static {v1}, Lio/dcloud/common/adapter/util/AsyncTaskHandler;->executeThreadTask(Lio/dcloud/common/adapter/util/AsyncTaskHandler$IAsyncTaskListener;)V

    return-void

    :cond_2
    :goto_0
    move-object v2, p0

    move-object v4, p1

    move-object v5, p3

    const/4 p1, 0x4

    .line 15
    invoke-direct {p0, p1, v4, v5}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    return-void

    :catch_0
    move-object v2, p0

    move-object v4, p1

    move-object v5, p3

    :catch_1
    const/16 p1, 0xa

    .line 50
    invoke-direct {p0, p1, v4, v5}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-void
.end method

.method private c(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .line 1
    sget-object v0, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "_www/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 3
    :cond_0
    sget-object v0, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 4
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "_doc/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 5
    :cond_1
    sget-object v0, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 6
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "_documents/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 7
    :cond_2
    sget-object v0, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 8
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "_downloads/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_3
    const/4 p1, 0x0

    return-object p1
.end method

.method private d(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .line 1
    invoke-static {p1}, Lio/dcloud/js/file/FileFeatureImpl;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 3
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    const/4 v0, -0x1

    .line 4
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    if-eqz v1, :cond_4

    .line 8
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 9
    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 10
    :cond_1
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 p1, 0x2

    .line 11
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 12
    :cond_2
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const/4 p1, 0x3

    .line 13
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 14
    :cond_3
    sget-object v1, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_4

    const/4 p1, 0x4

    .line 15
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_4
    return-object v0
.end method

.method private e(Ljava/lang/String;)Z
    .locals 1

    .line 1
    const-string v0, "_www"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "_documents"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2
    const-string v0, "_downloads"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "_doc"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 3
    const-string v0, "_www/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "_documents/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 4
    const-string v0, "_downloads/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "_doc/"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    return p1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    return p1
.end method


# virtual methods
.method public dispose(Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public execute(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 23

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    const-string v2, "MD5"

    const/4 v6, 0x0

    .line 1
    aget-object v7, v1, v6

    .line 3
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v3

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v3

    .line 4
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v8, "Io-"

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lio/dcloud/common/util/AppRuntime;->checkPrivacyComplianceAndPrompt(Landroid/content/Context;Ljava/lang/String;)V

    .line 5
    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IApp;->isOnAppRunningMode()Z

    move-result v4

    .line 6
    invoke-interface {v3, v6}, Lio/dcloud/common/DHInterface/IApp;->getPathByType(B)Ljava/lang/String;

    move-result-object v5

    sput-object v5, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    const/4 v5, -0x1

    .line 7
    invoke-interface {v3, v5}, Lio/dcloud/common/DHInterface/IApp;->getPathByType(B)Ljava/lang/String;

    move-result-object v8

    sput-object v8, Lio/dcloud/js/file/FileFeatureImpl;->b:Ljava/lang/String;

    const/4 v8, 0x1

    .line 8
    invoke-interface {v3, v8}, Lio/dcloud/common/DHInterface/IApp;->getPathByType(B)Ljava/lang/String;

    move-result-object v9

    sput-object v9, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    const/4 v9, 0x2

    .line 9
    invoke-interface {v3, v9}, Lio/dcloud/common/DHInterface/IApp;->getPathByType(B)Ljava/lang/String;

    move-result-object v10

    sput-object v10, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    const/4 v10, 0x3

    .line 10
    invoke-interface {v3, v10}, Lio/dcloud/common/DHInterface/IApp;->getPathByType(B)Ljava/lang/String;

    move-result-object v11

    sput-object v11, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    .line 11
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v11

    const/16 v17, 0x3

    sparse-switch v11, :sswitch_data_0

    :goto_0
    const/4 v11, -0x1

    goto/16 :goto_1

    :sswitch_0
    const-string v11, "chooseFile"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_0

    goto :goto_0

    :cond_0
    const/16 v11, 0x18

    goto/16 :goto_1

    :sswitch_1
    const-string v11, "readEntries"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_1

    goto :goto_0

    :cond_1
    const/16 v11, 0x17

    goto/16 :goto_1

    :sswitch_2
    const-string v11, "truncate"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_2

    goto :goto_0

    :cond_2
    const/16 v11, 0x16

    goto/16 :goto_1

    :sswitch_3
    const-string v11, "getMetadata"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_3

    goto :goto_0

    :cond_3
    const/16 v11, 0x15

    goto/16 :goto_1

    :sswitch_4
    const-string v11, "resolveLocalFileSystemURL"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_4

    goto :goto_0

    :cond_4
    const/16 v11, 0x14

    goto/16 :goto_1

    :sswitch_5
    const-string v11, "removeRecursively"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_5

    goto :goto_0

    :cond_5
    const/16 v11, 0x13

    goto/16 :goto_1

    :sswitch_6
    const-string v11, "getFileInfo"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_6

    goto :goto_0

    :cond_6
    const/16 v11, 0x12

    goto/16 :goto_1

    :sswitch_7
    const-string v11, "getVideoInfo"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_7

    goto :goto_0

    :cond_7
    const/16 v11, 0x11

    goto/16 :goto_1

    :sswitch_8
    const-string v11, "readAsBase64"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_8

    goto :goto_0

    :cond_8
    const/16 v11, 0x10

    goto/16 :goto_1

    :sswitch_9
    const-string v11, "getParent"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_9

    goto/16 :goto_0

    :cond_9
    const/16 v11, 0xf

    goto/16 :goto_1

    :sswitch_a
    const-string v11, "writeAsBinary"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_a

    goto/16 :goto_0

    :cond_a
    const/16 v11, 0xe

    goto/16 :goto_1

    :sswitch_b
    const-string v11, "readAsDataURL"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_b

    goto/16 :goto_0

    :cond_b
    const/16 v11, 0xd

    goto/16 :goto_1

    :sswitch_c
    const-string v11, "convertAbsoluteFileSystem"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_c

    goto/16 :goto_0

    :cond_c
    const/16 v11, 0xc

    goto/16 :goto_1

    :sswitch_d
    const-string v11, "getAudioInfo"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_d

    goto/16 :goto_0

    :cond_d
    const/16 v11, 0xb

    goto/16 :goto_1

    :sswitch_e
    const-string v11, "write"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_e

    goto/16 :goto_0

    :cond_e
    const/16 v11, 0xa

    goto/16 :goto_1

    :sswitch_f
    const-string v11, "getFile"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_f

    goto/16 :goto_0

    :cond_f
    const/16 v11, 0x9

    goto/16 :goto_1

    :sswitch_10
    const-string v11, "getFileMetadata"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_10

    goto/16 :goto_0

    :cond_10
    const/16 v11, 0x8

    goto/16 :goto_1

    :sswitch_11
    const-string v11, "getImageInfo"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_11

    goto/16 :goto_0

    :cond_11
    const/4 v11, 0x7

    goto :goto_1

    :sswitch_12
    const-string v11, "remove"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_12

    goto/16 :goto_0

    :cond_12
    const/4 v11, 0x6

    goto :goto_1

    :sswitch_13
    const-string v11, "convertLocalFileSystemURL"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_13

    goto/16 :goto_0

    :cond_13
    const/4 v11, 0x5

    goto :goto_1

    :sswitch_14
    const-string v11, "getDirectory"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_14

    goto/16 :goto_0

    :cond_14
    const/4 v11, 0x4

    goto :goto_1

    :sswitch_15
    const-string v11, "readAsText"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_15

    goto/16 :goto_0

    :cond_15
    const/4 v11, 0x3

    goto :goto_1

    :sswitch_16
    const-string v11, "moveTo"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_16

    goto/16 :goto_0

    :cond_16
    const/4 v11, 0x2

    goto :goto_1

    :sswitch_17
    const-string v11, "requestFileSystem"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_17

    goto/16 :goto_0

    :cond_17
    const/4 v11, 0x1

    goto :goto_1

    :sswitch_18
    const-string v11, "copyTo"

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_18

    goto/16 :goto_0

    :cond_18
    const/4 v11, 0x0

    :goto_1
    const-string v14, "/android_asset"

    const-string v13, "android_asset/"

    const-string v15, "/android_asset/"

    const/16 v19, 0x2

    const-string v9, "filePath"

    const-string v5, "apps/"

    const-string v12, ""

    const-string v10, "/"

    const/16 v20, 0x0

    packed-switch v11, :pswitch_data_0

    move-object/from16 v11, p0

    goto/16 :goto_33

    .line 927
    :pswitch_0
    aget-object v5, v1, v6

    .line 929
    array-length v0, v1

    if-le v0, v8, :cond_19

    aget-object v0, v1, v8

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 931
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    aget-object v1, v1, v8

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 932
    const-string v1, "multiple"

    invoke-virtual {v0, v1, v6}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move v7, v0

    goto :goto_2

    :catch_0
    move-exception v0

    .line 934
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_19
    const/4 v7, 0x0

    .line 937
    :goto_2
    invoke-static {}, Lio/dcloud/common/adapter/util/PermissionUtil;->getRequestCode()I

    move-result v2

    .line 938
    new-instance v0, Lio/dcloud/js/file/FileFeatureImpl$e;

    move-object/from16 v1, p0

    move-object/from16 v4, p1

    invoke-direct/range {v0 .. v5}, Lio/dcloud/js/file/FileFeatureImpl$e;-><init>(Lio/dcloud/js/file/FileFeatureImpl;ILio/dcloud/common/DHInterface/IApp;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    move-object v11, v1

    move-object v1, v0

    move v0, v2

    move-object v2, v4

    sget-object v4, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->onActivityResult:Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    invoke-interface {v3, v1, v4}, Lio/dcloud/common/DHInterface/IApp;->registerSysEventListener(Lio/dcloud/common/DHInterface/ISysEventListener;Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;)V

    .line 984
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.GET_CONTENT"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v3, "android.intent.extra.ALLOW_MULTIPLE"

    if-nez v7, :cond_1a

    .line 986
    invoke-virtual {v1, v3, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    goto :goto_3

    .line 988
    :cond_1a
    invoke-virtual {v1, v3, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 994
    :goto_3
    const-string v3, "*/*"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 995
    const-string v3, "android.intent.category.OPENABLE"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 996
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2, v1, v0}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_33

    :pswitch_1
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 997
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1b

    goto/16 :goto_33

    .line 1001
    :cond_1b
    aget-object v0, v0, v6

    .line 1002
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v5

    invoke-static {v1, v5}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1d

    invoke-static {v0}, Lio/dcloud/common/util/FileUtil;->getPathForPublicType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1c

    goto :goto_4

    :cond_1c
    const/16 v1, 0xf

    .line 1004
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 1007
    :cond_1d
    :goto_4
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1e

    if-eqz v4, :cond_1e

    :goto_5
    move-object/from16 v0, v20

    const/4 v8, 0x0

    goto :goto_6

    .line 1014
    :cond_1e
    :try_start_1
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lio/dcloud/js/file/a;->b(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_6

    :catch_1
    move-exception v0

    .line 1016
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_5

    :goto_6
    if-eqz v8, :cond_1f

    .line 1021
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONArray;IZ)V

    goto/16 :goto_33

    :cond_1f
    const/16 v1, 0xa

    .line 1023
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_2
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 1444
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_20

    goto/16 :goto_33

    .line 1451
    :cond_20
    :try_start_2
    aget-object v1, v0, v6

    .line 1452
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v3

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_21

    const/16 v3, 0xf

    .line 1454
    invoke-direct {v11, v3, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_5
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 1488
    invoke-static/range {v20 .. v20}, Lio/dcloud/common/util/IOUtil;->close(Ljava/io/InputStream;)V

    .line 1489
    invoke-static/range {v20 .. v20}, Lio/dcloud/common/util/IOUtil;->close(Ljava/io/OutputStream;)V

    goto/16 :goto_33

    .line 1490
    :cond_21
    :try_start_3
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1491
    new-instance v9, Ljava/io/FileInputStream;

    invoke-direct {v9, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_5
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 1492
    :try_start_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1493
    new-instance v4, Ljava/io/File;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v4, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1494
    new-instance v10, Ljava/io/FileOutputStream;

    invoke-direct {v10, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1495
    :try_start_5
    aget-object v1, v0, v8

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 1496
    aget-object v5, v0, v19

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    add-int v12, v5, v1

    const/16 v13, 0x2800

    .line 1497
    invoke-static {v12, v13}, Ljava/lang/Math;->min(II)I

    move-result v12

    .line 1498
    new-array v12, v12, [B

    const/4 v13, 0x0

    .line 1501
    :goto_7
    invoke-virtual {v9, v12}, Ljava/io/FileInputStream;->read([B)I

    move-result v14

    const/4 v15, -0x1

    if-eq v14, v15, :cond_25

    sub-int v15, v1, v13

    const/16 v21, 0x1

    sub-int v8, v14, v5

    .line 1502
    invoke-static {v15, v8}, Ljava/lang/Math;->min(II)I

    move-result v8

    if-lez v8, :cond_22

    .line 1504
    invoke-virtual {v10, v12, v5, v8}, Ljava/io/FileOutputStream;->write([BII)V

    add-int/2addr v13, v8

    :cond_22
    if-lt v13, v1, :cond_23

    goto :goto_9

    :cond_23
    if-lez v5, :cond_24

    sub-int/2addr v5, v14

    goto :goto_8

    :cond_24
    const/4 v5, 0x0

    :goto_8
    const/4 v8, 0x1

    goto :goto_7

    :cond_25
    const/16 v21, 0x1

    .line 1514
    :goto_9
    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    .line 1515
    invoke-virtual {v4, v3}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 1516
    aget-object v3, v0, v21

    sget v4, Lio/dcloud/common/util/JSUtil;->OK:I
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    const/4 v5, 0x1

    const/4 v6, 0x0

    move-object v1, v2

    move-object v2, v7

    :try_start_6
    invoke-static/range {v1 .. v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_b

    :catch_2
    move-exception v0

    move-object v7, v1

    move-object v8, v2

    goto :goto_a

    :catchall_0
    move-exception v0

    goto :goto_d

    :catch_3
    move-exception v0

    move-object v8, v7

    move-object v7, v2

    goto :goto_a

    :catchall_1
    move-exception v0

    goto :goto_e

    :catch_4
    move-exception v0

    move-object v8, v7

    move-object v7, v2

    move-object/from16 v10, v20

    goto :goto_a

    :catchall_2
    move-exception v0

    move-object/from16 v10, v20

    goto :goto_c

    :catch_5
    move-exception v0

    move-object v8, v7

    move-object v7, v2

    move-object/from16 v9, v20

    move-object v10, v9

    .line 1523
    :goto_a
    :try_start_7
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    const/16 v1, 0xa

    .line 1524
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 1521
    :goto_b
    invoke-static {v9}, Lio/dcloud/common/util/IOUtil;->close(Ljava/io/InputStream;)V

    .line 1522
    invoke-static {v10}, Lio/dcloud/common/util/IOUtil;->close(Ljava/io/OutputStream;)V

    goto/16 :goto_33

    :catchall_3
    move-exception v0

    move-object/from16 v20, v9

    :goto_c
    move-object/from16 v9, v20

    :goto_d
    move-object/from16 v20, v10

    .line 1526
    :goto_e
    invoke-static {v9}, Lio/dcloud/common/util/IOUtil;->close(Ljava/io/InputStream;)V

    .line 1527
    invoke-static/range {v20 .. v20}, Lio/dcloud/common/util/IOUtil;->close(Ljava/io/OutputStream;)V

    .line 1528
    throw v0

    :pswitch_3
    move-object/from16 v11, p0

    move-object v8, v7

    const/16 v21, 0x1

    move-object/from16 v7, p1

    .line 1529
    invoke-direct {v11, v7, v1, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_26

    goto/16 :goto_33

    .line 1533
    :cond_26
    aget-object v1, v0, v6

    .line 1534
    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v2

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_28

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_27

    goto :goto_f

    :cond_27
    const/16 v2, 0xf

    .line 1536
    invoke-direct {v11, v2, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 1539
    :cond_28
    :goto_f
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_29

    if-eqz v4, :cond_29

    :goto_10
    move-object/from16 v0, v20

    const/16 v21, 0x0

    goto :goto_12

    .line 1547
    :cond_29
    :try_start_8
    array-length v2, v0

    const/4 v3, 0x2

    if-ne v2, v3, :cond_2a

    aget-object v2, v0, v21

    if-eqz v2, :cond_2a

    const-string v3, "true"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2a

    .line 1548
    aget-object v0, v0, v21

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    goto :goto_11

    :cond_2a
    const/4 v0, 0x0

    .line 1550
    :goto_11
    invoke-static {v1, v0}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_6

    goto :goto_12

    :catch_6
    move-exception v0

    .line 1552
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_10

    :goto_12
    if-eqz v21, :cond_2b

    .line 1557
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v7, v8, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    goto/16 :goto_33

    :cond_2b
    const/16 v1, 0xa

    .line 1559
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_4
    move-object/from16 v11, p0

    move-object v8, v7

    const/16 v21, 0x1

    move-object/from16 v7, p1

    .line 2101
    :try_start_9
    invoke-direct {v11, v7, v1, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_2c

    goto/16 :goto_33

    .line 2109
    :cond_2c
    aget-object v0, v1, v6

    invoke-direct {v11, v0}, Lio/dcloud/js/file/FileFeatureImpl;->e(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2d

    .line 2112
    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IApp;->isOnAppRunningMode()Z

    move-result v2

    if-eqz v2, :cond_2d

    aget-object v2, v1, v6

    invoke-interface {v3, v2}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2d

    const/4 v2, 0x1

    goto :goto_13

    :cond_2d
    const/4 v2, 0x0

    .line 2114
    :goto_13
    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v4

    aget-object v5, v1, v6

    invoke-interface {v3, v4, v5}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    if-eqz v2, :cond_2e

    .line 2116
    invoke-direct {v11, v13}, Lio/dcloud/js/file/FileFeatureImpl;->a(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2117
    const-string v12, "_www"

    const-string v15, "_www"

    const-string v1, "fsName"

    .line 2118
    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v17

    const-string v1, "fsRoot"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    const/4 v14, 0x1

    .line 2119
    invoke-static/range {v12 .. v18}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2121
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v7, v8, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    goto/16 :goto_33

    .line 2123
    :cond_2e
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2124
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v3
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_8

    if-nez v3, :cond_31

    if-eqz v0, :cond_31

    .line 2127
    :try_start_a
    invoke-virtual {v2}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v0

    .line 2128
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_2f

    .line 2129
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 2131
    :cond_2f
    invoke-static {v13}, Lio/dcloud/common/adapter/io/DHFile;->createFileHandler(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/adapter/io/DHFile;->createNewFile(Ljava/lang/Object;)B

    move-result v0
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_7

    const/4 v3, 0x1

    if-ne v3, v0, :cond_30

    const/4 v3, 0x1

    goto :goto_14

    :cond_30
    const/4 v3, 0x0

    goto :goto_14

    :catch_7
    move-exception v0

    .line 2133
    :try_start_b
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_31
    :goto_14
    if-eqz v3, :cond_32

    .line 2137
    invoke-direct {v11, v13}, Lio/dcloud/js/file/FileFeatureImpl;->a(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2138
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v2}, Ljava/io/File;->isDirectory()Z

    move-result v14

    aget-object v15, v1, v6

    const-string v1, "fsName"

    .line 2139
    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v17

    const-string v1, "fsRoot"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v18

    .line 2140
    invoke-static/range {v12 .. v18}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v0

    .line 2142
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v7, v8, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    goto/16 :goto_33

    :cond_32
    const/16 v1, 0xe

    .line 2144
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_b
    .catch Lorg/json/JSONException; {:try_start_b .. :try_end_b} :catch_8

    goto/16 :goto_33

    :catch_8
    const/16 v1, 0xa

    .line 2149
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_5
    move-object/from16 v11, p0

    move-object v8, v7

    move-object/from16 v7, p1

    .line 2150
    invoke-direct {v11, v7, v1, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_33

    goto/16 :goto_33

    .line 2154
    :cond_33
    aget-object v1, v0, v6

    invoke-static {v7, v8, v1}, Lio/dcloud/common/util/JSUtil;->checkOperateDirErrorAndCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_34

    return-object v20

    .line 2157
    :cond_34
    aget-object v0, v0, v6

    .line 2158
    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_35

    const/16 v1, 0xf

    .line 2160
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 2163
    :cond_35
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2164
    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_36

    .line 2166
    :try_start_c
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    .line 2167
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Lio/dcloud/common/adapter/io/DHFile;->rename(Ljava/lang/String;Ljava/lang/String;)I

    .line 2168
    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_9

    move-object v1, v2

    goto :goto_15

    :catch_9
    move-exception v0

    .line 2170
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 2173
    :cond_36
    :goto_15
    invoke-static {v1}, Lio/dcloud/common/adapter/io/DHFile;->delete(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_37

    .line 2174
    sget v0, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v7, v8, v12, v0, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZ)V

    goto/16 :goto_33

    :cond_37
    const/16 v1, 0xa

    .line 2176
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_6
    const/4 v4, 0x0

    move-object/from16 v11, p0

    move-object v8, v7

    move-object/from16 v7, p1

    .line 2453
    aget-object v6, v1, v4

    .line 2457
    :try_start_d
    new-instance v0, Lorg/json/JSONObject;

    const/16 v21, 0x1

    aget-object v1, v1, v21

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 2458
    invoke-virtual {v0, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1
    :try_end_d
    .catch Lorg/json/JSONException; {:try_start_d .. :try_end_d} :catch_b

    .line 2459
    :try_start_e
    const-string v9, "digestAlgorithm"

    invoke-virtual {v0, v9, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2
    :try_end_e
    .catch Lorg/json/JSONException; {:try_start_e .. :try_end_e} :catch_a

    goto :goto_16

    :catch_a
    nop

    goto :goto_16

    :catch_b
    nop

    move-object v1, v12

    .line 2462
    :goto_16
    invoke-static {v1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_89

    invoke-static {v1}, Lio/dcloud/common/util/PdrUtil;->isNetPath(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_89

    .line 2463
    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v0

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v0, v9, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2464
    const-string v9, "content://"

    invoke-virtual {v0, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3a

    .line 2468
    :try_start_f
    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v9
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_10
    .catchall {:try_start_f .. :try_end_f} :catchall_6

    if-nez v9, :cond_38

    const/16 v1, 0xe

    .line 2470
    :try_start_10
    invoke-direct {v11, v1, v7, v8}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_10
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_10} :catch_f
    .catchall {:try_start_10 .. :try_end_10} :catchall_5

    if-eqz v9, :cond_89

    .line 2510
    :try_start_11
    invoke-virtual {v9}, Ljava/io/InputStream;->close()V
    :try_end_11
    .catch Ljava/io/IOException; {:try_start_11 .. :try_end_11} :catch_c

    goto/16 :goto_33

    :catch_c
    move-exception v0

    goto :goto_17

    .line 2513
    :cond_38
    :try_start_12
    invoke-virtual {v9}, Ljava/io/InputStream;->available()I

    move-result v5
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_12} :catch_f
    .catchall {:try_start_12 .. :try_end_12} :catchall_5

    .line 2515
    :try_start_13
    invoke-virtual {v9}, Ljava/io/InputStream;->close()V
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_d
    .catchall {:try_start_13 .. :try_end_13} :catchall_5

    .line 2519
    :catch_d
    :try_start_14
    invoke-static {}, Lio/dcloud/common/util/ThreadPool;->self()Lio/dcloud/common/util/ThreadPool;

    move-result-object v10

    move-object v3, v0

    new-instance v0, Lio/dcloud/js/file/FileFeatureImpl$$ExternalSyntheticLambda2;
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_14} :catch_f
    .catchall {:try_start_14 .. :try_end_14} :catchall_5

    move-object v4, v2

    move-object v2, v7

    move-object v7, v8

    move-object v1, v11

    :try_start_15
    invoke-direct/range {v0 .. v7}, Lio/dcloud/js/file/FileFeatureImpl$$ExternalSyntheticLambda2;-><init>(Lio/dcloud/js/file/FileFeatureImpl;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    :try_end_15
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_15} :catch_e
    .catchall {:try_start_15 .. :try_end_15} :catchall_4

    move-object v11, v1

    :try_start_16
    invoke-virtual {v10, v0}, Lio/dcloud/common/util/ThreadPool;->addThreadTask(Ljava/lang/Runnable;)V
    :try_end_16
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_16} :catch_f
    .catchall {:try_start_16 .. :try_end_16} :catchall_5

    .line 2550
    :try_start_17
    invoke-virtual {v9}, Ljava/io/InputStream;->close()V
    :try_end_17
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_17} :catch_c

    goto/16 :goto_33

    .line 2512
    :goto_17
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto/16 :goto_33

    :catchall_4
    move-exception v0

    move-object v11, v1

    goto :goto_18

    :catch_e
    move-exception v0

    move-object v11, v1

    goto :goto_19

    :catchall_5
    move-exception v0

    :goto_18
    move-object v1, v0

    move-object/from16 v20, v9

    goto :goto_1b

    :catch_f
    move-exception v0

    :goto_19
    move-object/from16 v20, v9

    goto :goto_1a

    :catchall_6
    move-exception v0

    move-object v1, v0

    goto :goto_1b

    :catch_10
    move-exception v0

    .line 2551
    :goto_1a
    :try_start_18
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
    :try_end_18
    .catchall {:try_start_18 .. :try_end_18} :catchall_6

    :goto_1b
    if-eqz v20, :cond_39

    .line 2555
    :try_start_19
    invoke-virtual/range {v20 .. v20}, Ljava/io/InputStream;->close()V
    :try_end_19
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_19} :catch_11

    goto :goto_1c

    :catch_11
    move-exception v0

    .line 2557
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 2560
    :cond_39
    :goto_1c
    throw v1

    :cond_3a
    move-object/from16 v22, v8

    move-object v8, v2

    move-object v2, v7

    move-object/from16 v7, v22

    .line 2563
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v9

    const/16 p2, 0x0

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v4

    invoke-static {v9, v4}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3c

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v1}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3b

    goto :goto_1d

    :cond_3b
    const/4 v1, 0x0

    goto :goto_1e

    :cond_3c
    :goto_1d
    const/4 v1, 0x1

    :goto_1e
    if-nez v1, :cond_3d

    const/16 v1, 0xf

    .line 2565
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 2568
    :cond_3d
    invoke-virtual {v0, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3e

    .line 2569
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2570
    :cond_3e
    invoke-virtual {v0, v15}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3f

    .line 2571
    invoke-virtual {v0, v14, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1f

    .line 2572
    :cond_3f
    invoke-virtual {v0, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_40

    .line 2573
    const-string v1, "android_asset"

    invoke-virtual {v0, v1, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 2575
    :cond_40
    :goto_1f
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDirAndCopy2Temp(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2576
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2577
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_41

    const/4 v0, -0x4

    .line 2578
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    const/4 v3, 0x2

    new-array v1, v3, [Ljava/lang/Object;

    aput-object v0, v1, p2

    sget-object v0, Lio/dcloud/common/constant/DOMException;->MSG_FILE_NOT_EXIST:Ljava/lang/String;

    const/16 v21, 0x1

    aput-object v0, v1, v21

    const-string v0, "{code:%d,message:\'%s\'}"

    invoke-static {v0, v1}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 2579
    sget v4, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v5, 0x1

    move-object v2, v6

    const/4 v6, 0x0

    move-object/from16 v1, p1

    invoke-static/range {v1 .. v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    goto/16 :goto_33

    .line 2582
    :cond_41
    invoke-static {}, Lio/dcloud/common/util/ThreadPool;->self()Lio/dcloud/common/util/ThreadPool;

    move-result-object v7

    new-instance v0, Lio/dcloud/js/file/FileFeatureImpl$d;

    move-object/from16 v4, p1

    move-object v5, v6

    move-object v3, v8

    move-object v1, v11

    invoke-direct/range {v0 .. v5}, Lio/dcloud/js/file/FileFeatureImpl$d;-><init>(Lio/dcloud/js/file/FileFeatureImpl;Ljava/io/File;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Lio/dcloud/common/util/ThreadPool;->addThreadTask(Ljava/lang/Runnable;)V

    goto/16 :goto_33

    :pswitch_7
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 2583
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_42

    goto/16 :goto_33

    .line 2587
    :cond_42
    invoke-direct {v11, v2, v3, v0, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IApp;[Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_8
    const/16 p2, 0x0

    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 2699
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_43

    goto/16 :goto_33

    .line 2704
    :cond_43
    aget-object v0, v0, p2

    .line 2705
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_45

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_44

    goto :goto_20

    :cond_44
    const/16 v1, 0xf

    .line 2707
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :cond_45
    :goto_20
    if-eqz v0, :cond_46

    .line 2710
    invoke-direct {v11, v0}, Lio/dcloud/js/file/FileFeatureImpl;->e(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_46

    const/4 v1, 0x4

    .line 2711
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v20

    .line 2714
    :cond_46
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2715
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_47

    .line 2716
    invoke-virtual {v1}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v0

    .line 2717
    invoke-virtual {v1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    invoke-static {v1, v0, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 2719
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v4, 0x0

    invoke-static {v2, v7, v0, v1, v4}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    const/4 v6, 0x1

    goto :goto_21

    :cond_47
    const/4 v4, 0x0

    const/4 v6, 0x0

    :goto_21
    if-nez v6, :cond_89

    const/16 v1, 0xa

    .line 2722
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_9
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 2723
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_48

    goto/16 :goto_33

    .line 2727
    :cond_48
    invoke-direct {v11, v2, v0, v7}, Lio/dcloud/js/file/FileFeatureImpl;->b(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_a
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 2915
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_49

    goto/16 :goto_33

    .line 2919
    :cond_49
    aget-object v1, v0, v6

    .line 2920
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v5

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v8

    invoke-static {v5, v8}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_4a

    const/16 v5, 0xf

    .line 2922
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 2925
    :cond_4a
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v3

    const/16 v21, 0x1

    .line 2926
    aget-object v5, v0, v21

    invoke-static {v5, v6}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v5

    const/16 v19, 0x2

    .line 2927
    aget-object v0, v0, v19

    const/4 v15, -0x1

    invoke-static {v0, v15}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v0

    if-eqz v3, :cond_4b

    if-eqz v4, :cond_4b

    const/16 v3, 0xa

    .line 2929
    invoke-direct {v11, v3, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :cond_4b
    move v3, v0

    .line 2931
    new-instance v0, Lio/dcloud/js/file/FileFeatureImpl$b;

    move v4, v5

    move-object v6, v7

    move-object v5, v2

    move-object v2, v1

    move-object v1, v11

    invoke-direct/range {v0 .. v6}, Lio/dcloud/js/file/FileFeatureImpl$b;-><init>(Lio/dcloud/js/file/FileFeatureImpl;Ljava/lang/String;IILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-static {v0}, Lio/dcloud/common/adapter/util/AsyncTaskHandler;->executeThreadTask(Lio/dcloud/common/adapter/util/AsyncTaskHandler$IAsyncTaskListener;)V

    goto/16 :goto_33

    :pswitch_b
    move-object/from16 v11, p0

    .line 3063
    aget-object v0, v1, v6

    .line 3064
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    invoke-static {v0, v3}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :pswitch_c
    const/4 v3, 0x1

    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 3291
    aget-object v4, v1, v6

    .line 3294
    :try_start_1a
    new-instance v5, Lorg/json/JSONObject;

    aget-object v1, v1, v3

    invoke-direct {v5, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 3295
    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12
    :try_end_1a
    .catch Lorg/json/JSONException; {:try_start_1a .. :try_end_1a} :catch_12

    .line 3298
    :catch_12
    invoke-direct {v11, v12, v4, v2, v0}, Lio/dcloud/js/file/FileFeatureImpl;->a(Ljava/lang/String;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_d
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 3299
    :try_start_1b
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_4c

    goto/16 :goto_33

    .line 3303
    :cond_4c
    aget-object v1, v0, v6

    .line 3304
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4d

    const/16 v5, 0xf

    .line 3306
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 3309
    :cond_4d
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v3

    const/16 v19, 0x2

    .line 3310
    aget-object v4, v0, v19

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/16 v21, 0x1

    .line 3311
    aget-object v0, v0, v21

    if-eqz v0, :cond_4f

    if-eqz v3, :cond_4e

    goto :goto_22

    .line 3315
    :cond_4e
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 3316
    invoke-static {v0, v4, v1}, Lio/dcloud/common/adapter/io/DHFile;->writeFile([BILjava/lang/String;)V

    .line 3317
    array-length v0, v0

    int-to-double v3, v0

    sget v5, Lio/dcloud/common/util/JSUtil;->OK:I
    :try_end_1b
    .catch Ljava/lang/Exception; {:try_start_1b .. :try_end_1b} :catch_14

    const/4 v6, 0x0

    move-object v1, v2

    move-object v2, v7

    :try_start_1c
    invoke-static/range {v1 .. v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;DIZ)V
    :try_end_1c
    .catch Ljava/lang/Exception; {:try_start_1c .. :try_end_1c} :catch_13

    goto/16 :goto_33

    :catch_13
    move-object v7, v2

    move-object v2, v1

    goto :goto_23

    :cond_4f
    :goto_22
    const/4 v1, 0x4

    .line 3318
    :try_start_1d
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    :try_end_1d
    .catch Ljava/lang/Exception; {:try_start_1d .. :try_end_1d} :catch_14

    return-object v20

    :catch_14
    :goto_23
    const/16 v1, 0xa

    .line 3325
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_e
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 3370
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_50

    goto/16 :goto_33

    .line 3374
    :cond_50
    aget-object v1, v0, v6

    const/16 v21, 0x1

    aget-object v4, v0, v21

    invoke-interface {v3, v1, v4}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 3375
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_51

    const/16 v5, 0xf

    .line 3377
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 3380
    :cond_51
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 3382
    :try_start_1e
    new-instance v5, Lorg/json/JSONObject;

    const/16 v19, 0x2

    aget-object v8, v0, v19

    invoke-direct {v5, v8}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const/16 v21, 0x1

    .line 3383
    aget-object v0, v0, v21

    .line 3384
    const-string v0, "create"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 3385
    const-string v8, "exclusive"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v5

    .line 3387
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_54

    if-eqz v0, :cond_53

    .line 3389
    invoke-static {v4}, Lio/dcloud/common/adapter/io/DHFile;->createNewFile(Ljava/lang/Object;)B

    move-result v0

    .line 3390
    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    const/4 v15, -0x1

    if-eq v0, v15, :cond_52

    const/4 v8, -0x2

    if-ne v0, v8, :cond_56

    if-nez v5, :cond_52

    goto :goto_24

    .line 3392
    :cond_52
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0

    :cond_53
    const/16 v1, 0xe

    .line 3395
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v20

    :cond_54
    if-eqz v0, :cond_55

    if-eqz v5, :cond_55

    const/16 v0, 0xc

    .line 3399
    invoke-direct {v11, v0, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v20

    .line 3402
    :cond_55
    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    .line 3404
    :cond_56
    :goto_24
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v1, v0, v6}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 3405
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V
    :try_end_1e
    .catch Ljava/lang/Exception; {:try_start_1e .. :try_end_1e} :catch_15

    goto/16 :goto_33

    :catch_15
    const/16 v1, 0xa

    .line 3407
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_f
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 3408
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_57

    goto/16 :goto_33

    .line 3412
    :cond_57
    aget-object v0, v0, v6

    .line 3413
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v5

    invoke-static {v1, v5}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_59

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_58

    goto :goto_25

    :cond_58
    const/16 v1, 0xf

    .line 3415
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 3418
    :cond_59
    :goto_25
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5a

    if-eqz v4, :cond_5a

    :goto_26
    move-object/from16 v0, v20

    const/4 v8, 0x0

    goto :goto_27

    .line 3425
    :cond_5a
    :try_start_1f
    invoke-direct {v11, v0}, Lio/dcloud/js/file/FileFeatureImpl;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0
    :try_end_1f
    .catch Ljava/lang/Exception; {:try_start_1f .. :try_end_1f} :catch_16

    const/4 v8, 0x1

    goto :goto_27

    :catch_16
    move-exception v0

    .line 3427
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_26

    :goto_27
    if-eqz v8, :cond_5b

    .line 3432
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    goto/16 :goto_33

    :cond_5b
    const/16 v1, 0xa

    .line 3434
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_10
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 3994
    aget-object v0, v1, v6

    const/16 v21, 0x1

    .line 3995
    aget-object v4, v1, v21

    .line 3996
    invoke-static {v4}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_89

    .line 3998
    invoke-static {v4}, Lio/dcloud/common/util/PdrUtil;->isNetPath(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5f

    .line 4001
    :try_start_20
    array-length v3, v1

    const/4 v5, 0x2

    if-le v3, v5, :cond_5e

    aget-object v3, v1, v5

    invoke-static {v3}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5e

    .line 4002
    aget-object v1, v1, v5

    .line 4003
    invoke-virtual {v1, v10}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5c

    .line 4004
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 4005
    :cond_5c
    const-string v3, "image/*"

    invoke-static {v4, v3, v4}, Lio/dcloud/common/util/PdrUtil;->getDownloadFilename(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 4006
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_5d

    .line 4007
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-virtual {v3, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v5, "_"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Math;->abs(I)I

    move-result v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 4009
    :cond_5d
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v6

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_28

    :cond_5e
    move-object/from16 v1, v20

    .line 4012
    :goto_28
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/bumptech/glide/Glide;->with(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bumptech/glide/RequestManager;->asFile()Lcom/bumptech/glide/RequestBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/bumptech/glide/RequestBuilder;->load(Ljava/lang/String;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object v3

    new-instance v4, Lio/dcloud/js/file/FileFeatureImpl$c;

    invoke-direct {v4, v11, v1, v2, v0}, Lio/dcloud/js/file/FileFeatureImpl$c;-><init>(Lio/dcloud/js/file/FileFeatureImpl;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/bumptech/glide/RequestBuilder;->into(Lcom/bumptech/glide/request/target/Target;)Lcom/bumptech/glide/request/target/Target;
    :try_end_20
    .catch Ljava/lang/Exception; {:try_start_20 .. :try_end_20} :catch_17

    goto/16 :goto_33

    .line 4037
    :catch_17
    const-string v1, "Failed to load resource"

    const/16 v3, 0xd

    invoke-static {v3, v1}, Lio/dcloud/common/constant/DOMException;->toJSON(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget v4, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v5, 0x1

    const/4 v6, 0x0

    move-object v1, v2

    move-object v2, v0

    invoke-static/range {v1 .. v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    goto/16 :goto_33

    .line 4040
    :cond_5f
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1, v4}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 4041
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_61

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v1}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_60

    goto :goto_29

    :cond_60
    const/16 v4, 0xf

    .line 4043
    invoke-direct {v11, v4, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 4046
    :cond_61
    :goto_29
    invoke-virtual {v1, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_62

    .line 4047
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 4048
    :cond_62
    invoke-virtual {v1, v15}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_63

    .line 4049
    invoke-virtual {v1, v14, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    goto :goto_2a

    .line 4050
    :cond_63
    invoke-virtual {v1, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_64

    .line 4051
    const-string v4, "android_asset"

    invoke-virtual {v1, v4, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 4053
    :cond_64
    :goto_2a
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDirAndCopy2Temp(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 4054
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_65

    const/16 v3, 0xe

    .line 4055
    invoke-direct {v11, v3, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 4057
    :cond_65
    invoke-direct {v11, v1, v2, v0}, Lio/dcloud/js/file/FileFeatureImpl;->a(Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_11
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 4058
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_66

    goto/16 :goto_33

    .line 4062
    :cond_66
    aget-object v0, v0, v6

    .line 4063
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_67

    const/16 v1, 0xf

    .line 4065
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 4068
    :cond_67
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_68

    const/4 v1, 0x4

    .line 4071
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v20

    .line 4074
    :cond_68
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 4075
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v0

    if-eqz v0, :cond_69

    .line 4076
    sget v0, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v12, v0, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZ)V

    goto/16 :goto_33

    :cond_69
    const/16 v1, 0xa

    .line 4078
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_12
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 4646
    aget-object v0, v1, v6

    .line 4647
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    invoke-static {v0, v3}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :pswitch_13
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 4648
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_6a

    goto/16 :goto_33

    .line 4652
    :cond_6a
    aget-object v1, v0, v6

    if-eqz v1, :cond_6b

    invoke-virtual {v1, v10}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6b

    .line 4653
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v4, v0, v6

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v6

    .line 4655
    :cond_6b
    aget-object v1, v0, v6

    const/16 v21, 0x1

    aget-object v4, v0, v21

    invoke-interface {v3, v1, v4}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 4656
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v4

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6c

    const/16 v5, 0xf

    .line 4658
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 4662
    :cond_6c
    aget-object v4, v0, v6

    if-eqz v4, :cond_6d

    aget-object v4, v0, v21

    if-eqz v4, :cond_6d

    const-string v5, "../"

    invoke-virtual {v4, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    const/4 v15, -0x1

    if-eq v4, v15, :cond_6d

    aget-object v4, v0, v6

    invoke-direct {v11, v4}, Lio/dcloud/js/file/FileFeatureImpl;->e(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6d

    const/4 v4, 0x4

    .line 4663
    invoke-direct {v11, v4, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v20

    .line 4666
    :cond_6d
    invoke-virtual {v1, v10}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6e

    .line 4667
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 4669
    :cond_6e
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 4671
    :try_start_21
    new-instance v5, Lorg/json/JSONObject;

    const/16 v19, 0x2

    aget-object v8, v0, v19

    invoke-direct {v5, v8}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 4672
    const-string v8, "create"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v8

    .line 4673
    const-string v9, "exclusive"

    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v5

    .line 4675
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_71

    if-eqz v8, :cond_70

    .line 4677
    invoke-static {v1}, Lio/dcloud/common/adapter/io/DHFile;->createNewFile(Ljava/lang/Object;)B

    move-result v4

    const/4 v15, -0x1

    if-eq v4, v15, :cond_6f

    const/4 v8, -0x2

    if-ne v4, v8, :cond_72

    if-nez v5, :cond_6f

    goto :goto_2b

    .line 4679
    :cond_6f
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0}, Ljava/lang/RuntimeException;-><init>()V

    throw v0

    :cond_70
    const/16 v3, 0xe

    .line 4682
    invoke-direct {v11, v3, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v20

    :cond_71
    if-eqz v5, :cond_72

    if-eqz v5, :cond_72

    const/16 v4, 0xc

    .line 4688
    invoke-direct {v11, v4, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    :cond_72
    :goto_2b
    const/4 v4, 0x1

    .line 4690
    aget-object v0, v0, v4

    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 4691
    sget v3, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v3, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V
    :try_end_21
    .catch Ljava/lang/Exception; {:try_start_21 .. :try_end_21} :catch_18

    goto/16 :goto_33

    .line 4693
    :catch_18
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v3, "Not Found "

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;)V

    const/16 v1, 0xa

    .line 4694
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_14
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 4695
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_73

    goto/16 :goto_33

    .line 4699
    :cond_73
    aget-object v1, v0, v6

    .line 4700
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v5

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v8

    invoke-static {v5, v8}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_74

    const/16 v5, 0xf

    .line 4702
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 4705
    :cond_74
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v3

    const/16 v21, 0x1

    .line 4706
    aget-object v5, v0, v21

    const/16 v19, 0x2

    .line 4707
    aget-object v8, v0, v19

    invoke-static {v8, v6}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v6

    .line 4708
    aget-object v0, v0, v17

    const/4 v15, -0x1

    invoke-static {v0, v15}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v0

    if-eqz v3, :cond_75

    if-eqz v4, :cond_75

    const/16 v3, 0xa

    .line 4710
    invoke-direct {v11, v3, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :cond_75
    move v3, v0

    .line 4712
    new-instance v0, Lio/dcloud/js/file/FileFeatureImpl$a;

    move v4, v6

    move-object v6, v2

    move-object v2, v1

    move-object v1, v11

    invoke-direct/range {v0 .. v7}, Lio/dcloud/js/file/FileFeatureImpl$a;-><init>(Lio/dcloud/js/file/FileFeatureImpl;Ljava/lang/String;IILjava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-static {v0}, Lio/dcloud/common/adapter/util/AsyncTaskHandler;->executeThreadTask(Lio/dcloud/common/adapter/util/AsyncTaskHandler$IAsyncTaskListener;)V

    goto/16 :goto_33

    :pswitch_15
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 4713
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_76

    goto/16 :goto_33

    .line 4717
    :cond_76
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v21, 0x1

    aget-object v5, v0, v21

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v19, 0x2

    aget-object v5, v0, v19

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v1, v4}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 4718
    aget-object v4, v0, v6

    invoke-interface {v3, v4}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_7c

    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_77

    goto :goto_2d

    .line 4722
    :cond_77
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v4

    aget-object v5, v0, v6

    invoke-interface {v3, v4, v5}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 4723
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v5

    filled-new-array {v1, v4}, [Ljava/lang/String;

    move-result-object v8

    invoke-static {v5, v8}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_78

    const/16 v5, 0xf

    .line 4725
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    .line 4728
    :cond_78
    new-instance v5, Ljava/io/File;

    invoke-direct {v5, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 4729
    invoke-virtual {v5}, Ljava/io/File;->isDirectory()Z

    move-result v4

    .line 4731
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 4732
    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v9

    if-nez v9, :cond_7a

    .line 4734
    invoke-virtual {v8}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v9

    .line 4735
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_79

    .line 4736
    invoke-virtual {v9}, Ljava/io/File;->mkdirs()Z

    .line 4738
    :cond_79
    invoke-virtual {v5, v8}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v5

    goto :goto_2c

    :cond_7a
    const/4 v5, 0x0

    :goto_2c
    if-eqz v5, :cond_7b

    const/16 v19, 0x2

    .line 4741
    aget-object v0, v0, v19

    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 4742
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    goto/16 :goto_33

    :cond_7b
    const/16 v1, 0xa

    .line 4744
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :cond_7c
    :goto_2d
    const/16 v1, 0xa

    .line 4720
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_16
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 5057
    :try_start_22
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_7d

    goto/16 :goto_33

    .line 5061
    :cond_7d
    aget-object v0, v0, v6

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/4 v3, 0x1

    if-eq v0, v3, :cond_81

    const/4 v3, 0x2

    if-eq v0, v3, :cond_80

    const/4 v1, 0x3

    if-eq v0, v1, :cond_7f

    const/4 v1, 0x4

    if-eq v0, v1, :cond_7e

    .line 5077
    const-string v0, "PUBLIC_DEVICE_ROOT"

    sget-object v1, Lio/dcloud/common/adapter/util/DeviceInfo;->sDeviceRootDir:Ljava/lang/String;

    const/4 v3, 0x5

    invoke-static {v0, v3, v1, v1, v1}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    goto :goto_2e

    .line 5078
    :cond_7e
    const-string v0, "PUBLIC_DOWNLOADS"

    sget-object v1, Lio/dcloud/common/util/BaseInfo;->REAL_PUBLIC_DOWNLOADS_DIR:Ljava/lang/String;

    sget-object v3, Lio/dcloud/js/file/FileFeatureImpl;->e:Ljava/lang/String;

    const-string v4, "_downloads"

    const/4 v5, 0x4

    invoke-static {v0, v5, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    goto :goto_2e

    .line 5079
    :cond_7f
    const-string v0, "PUBLIC_DOCUMENTS"

    sget-object v1, Lio/dcloud/common/util/BaseInfo;->REAL_PUBLIC_DOCUMENTS_DIR:Ljava/lang/String;

    sget-object v3, Lio/dcloud/js/file/FileFeatureImpl;->d:Ljava/lang/String;

    const-string v4, "_documents"

    const/4 v5, 0x3

    invoke-static {v0, v5, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    goto :goto_2e

    .line 5080
    :cond_80
    const-string v0, "PRIVATE_DOCUMENTS"

    sget-object v1, Lio/dcloud/common/util/BaseInfo;->REAL_PRIVATE_DOC_DIR:Ljava/lang/String;

    sget-object v3, Lio/dcloud/js/file/FileFeatureImpl;->c:Ljava/lang/String;

    const-string v4, "_doc"

    const/4 v5, 0x2

    invoke-static {v0, v5, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    goto :goto_2e

    .line 5081
    :cond_81
    const-string v0, "PRIVATE_WWW"

    sget-object v1, Lio/dcloud/common/util/BaseInfo;->REAL_PRIVATE_WWW_DIR:Ljava/lang/String;

    sget-object v3, Lio/dcloud/js/file/FileFeatureImpl;->a:Ljava/lang/String;

    const-string v4, "_www"

    const/4 v5, 0x1

    invoke-static {v0, v5, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 5096
    :goto_2e
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V
    :try_end_22
    .catch Ljava/lang/Exception; {:try_start_22 .. :try_end_22} :catch_19

    goto/16 :goto_33

    :catch_19
    move-exception v0

    .line 5098
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    const/16 v1, 0xa

    .line 5099
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto/16 :goto_33

    :pswitch_17
    move-object/from16 v11, p0

    move-object/from16 v2, p1

    .line 5100
    invoke-direct {v11, v2, v1, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;[Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_82

    goto/16 :goto_33

    :cond_82
    const/16 v21, 0x1

    .line 5104
    aget-object v1, v0, v21

    if-eqz v1, :cond_84

    .line 5105
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v4, v0, v21

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    aget-object v4, v0, v21

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_83

    goto :goto_2f

    :cond_83
    move-object v12, v5

    :goto_2f
    invoke-virtual {v1, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 5109
    :cond_84
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v19, 0x2

    aget-object v1, v0, v19

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 5110
    aget-object v4, v0, v6

    .line 5111
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v5

    filled-new-array {v1, v4}, [Ljava/lang/String;

    move-result-object v8

    invoke-static {v5, v8}, Lio/dcloud/common/util/FileUtil;->checkPathAccord(Landroid/content/Context;[Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_86

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5, v4}, Lio/dcloud/common/util/FileUtil;->isFilePathForPublic(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_85

    goto :goto_30

    :cond_85
    const/16 v5, 0xf

    .line 5113
    invoke-direct {v11, v5, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    goto :goto_33

    .line 5116
    :cond_86
    :goto_30
    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->checkPrivateDir(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_88

    .line 5120
    :try_start_23
    invoke-static {v1}, Lio/dcloud/common/adapter/io/DHFile;->isExist(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_88

    .line 5122
    invoke-static {v4}, Lio/dcloud/common/adapter/io/DHFile;->isExist(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_87

    .line 5123
    invoke-static {v4, v1}, Lio/dcloud/common/adapter/io/DHFile;->copyFile(Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_88

    :goto_31
    const/16 v19, 0x2

    goto :goto_32

    .line 5126
    :cond_87
    invoke-static {v4, v1}, Lio/dcloud/common/adapter/io/DHFile;->copyAssetsFile(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4
    :try_end_23
    .catch Ljava/io/IOException; {:try_start_23 .. :try_end_23} :catch_1a

    if-eqz v4, :cond_88

    goto :goto_31

    .line 5135
    :goto_32
    aget-object v0, v0, v19

    invoke-interface {v3, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v4

    invoke-static {v0, v1, v3, v4}, Lio/dcloud/js/file/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 5136
    sget v1, Lio/dcloud/common/util/JSUtil;->OK:I

    invoke-static {v2, v7, v0, v1, v6}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;IZ)V

    goto :goto_33

    :catch_1a
    move-exception v0

    .line 5132
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_88
    const/16 v1, 0xa

    .line 5138
    invoke-direct {v11, v1, v2, v7}, Lio/dcloud/js/file/FileFeatureImpl;->a(ILio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    :cond_89
    :goto_33
    return-object v20

    nop

    :sswitch_data_0
    .sparse-switch
        -0x50bf4f30 -> :sswitch_18
        -0x48fb9146 -> :sswitch_17
        -0x3fac69d4 -> :sswitch_16
        -0x3ca3664b -> :sswitch_15
        -0x39f27049 -> :sswitch_14
        -0x381a8bf4 -> :sswitch_13
        -0x37b5077c -> :sswitch_12
        -0x34ef320d -> :sswitch_11
        -0x574d4bf -> :sswitch_10
        -0x480a20e -> :sswitch_f
        0x6c257df -> :sswitch_e
        0xaa00aee -> :sswitch_d
        0x1350fab5 -> :sswitch_c
        0x1f8c3fdd -> :sswitch_b
        0x284c03d2 -> :sswitch_a
        0x29c22ba0 -> :sswitch_9
        0x3faaefd7 -> :sswitch_8
        0x4edba913 -> :sswitch_7
        0x4ffdedc0 -> :sswitch_6
        0x50a1221b -> :sswitch_5
        0x5db49c05 -> :sswitch_4
        0x6107b8a5 -> :sswitch_3
        0x6e724d66 -> :sswitch_2
        0x750fee1a -> :sswitch_1
        0x7897fc33 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_c
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public init(Lio/dcloud/common/DHInterface/AbsMgr;Ljava/lang/String;)V
    .locals 0

    return-void
.end method
