.class public Lio/dcloud/feature/utsplugin/ParamConvertHelper;
.super Ljava/lang/Object;
.source "ParamConvertHelper.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nParamConvertHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParamConvertHelper.kt\nio/dcloud/feature/utsplugin/ParamConvertHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,484:1\n1869#2,2:485\n1285#2,2:487\n1299#2,2:489\n1869#2,2:491\n1302#2:493\n*S KotlinDebug\n*F\n+ 1 ParamConvertHelper.kt\nio/dcloud/feature/utsplugin/ParamConvertHelper\n*L\n306#1:485,2\n346#1:487,2\n346#1:489,2\n359#1:491,2\n346#1:493\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001f\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u0008\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B5\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\u0008\u000b\u0010\u000cJ\u0012\u00108\u001a\u0004\u0018\u00010\u00012\u0008\u00109\u001a\u0004\u0018\u00010\u0001R\u0014\u0010\r\u001a\u00020\u0003X\u0086D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0003X\u0086D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0003X\u0086D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015\"\u0004\u0008\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u0015\"\u0004\u0008\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015\"\u0004\u0008\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0015\"\u0004\u0008\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0015\"\u0004\u0008!\u0010\u0017R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u0015\"\u0004\u0008#\u0010\u0017R\u001c\u0010$\u001a\u0004\u0018\u00010\u0008X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008\'\u0010(R \u0010)\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R$\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R\u001a\u00105\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u00086\u0010\u0015\"\u0004\u00087\u0010\u0017\u00a8\u0006;"
    }
    d2 = {
        "Lio/dcloud/feature/utsplugin/ParamConvertHelper;",
        "",
        "classTypeName",
        "",
        "actualTypeArguments",
        "",
        "Ljava/lang/reflect/Type;",
        "hostCallback",
        "Lcom/taobao/weex/bridge/JSCallback;",
        "isKeepAlive",
        "",
        "<init>",
        "(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;Z)V",
        "UTSCallbackType",
        "getUTSCallbackType",
        "()Ljava/lang/String;",
        "UTSObjectType",
        "getUTSObjectType",
        "StringClassFlag",
        "getStringClassFlag",
        "isUTSCallback",
        "()Z",
        "setUTSCallback",
        "(Z)V",
        "isUTSObject",
        "setUTSObject",
        "isPrimitive",
        "setPrimitive",
        "isListType",
        "setListType",
        "isUTSArray",
        "setUTSArray",
        "isMapType",
        "setMapType",
        "isAnyType",
        "setAnyType",
        "mHostCallback",
        "getMHostCallback",
        "()Lcom/taobao/weex/bridge/JSCallback;",
        "setMHostCallback",
        "(Lcom/taobao/weex/bridge/JSCallback;)V",
        "tClass",
        "Ljava/lang/Class;",
        "getTClass",
        "()Ljava/lang/Class;",
        "setTClass",
        "(Ljava/lang/Class;)V",
        "hostTypeArguments",
        "getHostTypeArguments",
        "()[Ljava/lang/reflect/Type;",
        "setHostTypeArguments",
        "([Ljava/lang/reflect/Type;)V",
        "[Ljava/lang/reflect/Type;",
        "mIsKeepAlive",
        "getMIsKeepAlive",
        "setMIsKeepAlive",
        "getInstance",
        "value",
        "Companion",
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


# static fields
.field public static final Companion:Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;


# instance fields
.field private final StringClassFlag:Ljava/lang/String;

.field private final UTSCallbackType:Ljava/lang/String;

.field private final UTSObjectType:Ljava/lang/String;

.field private hostTypeArguments:[Ljava/lang/reflect/Type;

.field private isAnyType:Z

.field private isListType:Z

.field private isMapType:Z

.field private isPrimitive:Z

.field private isUTSArray:Z

.field private isUTSCallback:Z

.field private isUTSObject:Z

.field private mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

.field private mIsKeepAlive:Z

.field private tClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->Companion:Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;Z)V
    .locals 3

    const-string v0, "classTypeName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    const-string v0, "io.dcloud.uts.UTSCallback"

    iput-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->UTSCallbackType:Ljava/lang/String;

    .line 100
    const-string v1, "io.dcloud.uts.UTSJSONObject"

    iput-object v1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->UTSObjectType:Ljava/lang/String;

    .line 101
    const-string v2, "java.lang.String"

    iput-object v2, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->StringClassFlag:Ljava/lang/String;

    .line 134
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mIsKeepAlive:Z

    .line 136
    iput-object p2, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->hostTypeArguments:[Ljava/lang/reflect/Type;

    .line 138
    invoke-static {v1, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    const/4 p4, 0x1

    if-eqz p2, :cond_0

    .line 139
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSObject:Z

    return-void

    .line 143
    :cond_0
    sget-object p2, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->Companion:Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;

    invoke-virtual {p2, p1}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->isPrimitiveType(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 144
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isPrimitive:Z

    return-void

    .line 149
    :cond_1
    invoke-virtual {p2, p1}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->isListType(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 150
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isListType:Z

    return-void

    .line 154
    :cond_2
    invoke-virtual {p2, p1}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->isUTSArray(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 155
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSArray:Z

    return-void

    .line 161
    :cond_3
    invoke-virtual {p2, p1}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->isAnyType(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 162
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isAnyType:Z

    return-void

    .line 167
    :cond_4
    invoke-virtual {p2, p1}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->isMapType(Ljava/lang/String;)Z

    move-result p2

    if-eqz p2, :cond_5

    .line 168
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isMapType:Z

    return-void

    .line 173
    :cond_5
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object p1

    iput-object p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    .line 175
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_6

    .line 176
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSCallback:Z

    goto :goto_1

    .line 177
    :cond_6
    iget-object p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/lang/Class;->isPrimitive()Z

    move-result p1

    if-nez p1, :cond_8

    iget-object p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_7

    goto :goto_0

    :cond_7
    const/4 p1, 0x0

    .line 180
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSCallback:Z

    .line 181
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isPrimitive:Z

    goto :goto_1

    .line 178
    :cond_8
    :goto_0
    iput-boolean p4, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isPrimitive:Z

    .line 183
    :goto_1
    iput-object p3, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_0

    const/4 p4, 0x0

    .line 133
    :cond_0
    invoke-direct {p0, p1, p2, p3, p4}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;Z)V

    return-void
.end method


# virtual methods
.method public final getHostTypeArguments()[Ljava/lang/reflect/Type;
    .locals 1

    .line 129
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->hostTypeArguments:[Ljava/lang/reflect/Type;

    return-object v0
.end method

.method public final getInstance(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 24

    move-object/from16 v1, p0

    move-object/from16 v0, p1

    const/4 v2, 0x0

    if-nez v0, :cond_0

    return-object v2

    .line 198
    :cond_0
    const-string v3, "UTSNull"

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    return-object v2

    .line 204
    :cond_1
    iget-boolean v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSObject:Z

    if-eqz v3, :cond_2

    .line 206
    new-instance v2, Lio/dcloud/uts/UTSJSONObject;

    invoke-direct {v2}, Lio/dcloud/uts/UTSJSONObject;-><init>()V

    .line 207
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/alibaba/fastjson/JSON;->parseObject(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;

    move-result-object v0

    .line 208
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v2, v0}, Lio/dcloud/uts/UTSJSONObject;->fillJSON(Ljava/lang/Object;)V

    return-object v2

    .line 212
    :cond_2
    iget-boolean v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isMapType:Z

    if-eqz v3, :cond_3

    .line 214
    new-instance v2, Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/alibaba/fastjson/JSON;->parseObject(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;

    move-result-object v0

    const-string v3, "parseObject(...)"

    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/util/Map;

    invoke-static {v0}, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    return-object v2

    .line 217
    :cond_3
    iget-boolean v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isAnyType:Z

    if-eqz v3, :cond_5

    .line 223
    instance-of v2, v0, Lcom/alibaba/fastjson/JSONObject;

    if-eqz v2, :cond_4

    .line 224
    new-instance v2, Lio/dcloud/uts/UTSJSONObject;

    invoke-direct {v2, v0}, Lio/dcloud/uts/UTSJSONObject;-><init>(Ljava/lang/Object;)V

    return-object v2

    .line 226
    :cond_4
    instance-of v2, v0, Lcom/alibaba/fastjson/JSONArray;

    if-eqz v2, :cond_b

    .line 227
    new-instance v2, Lio/dcloud/uts/UTSArray;

    check-cast v0, Ljava/util/List;

    invoke-direct {v2, v0}, Lio/dcloud/uts/UTSArray;-><init>(Ljava/util/List;)V

    return-object v2

    .line 234
    :cond_5
    iget-boolean v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isPrimitive:Z

    if-nez v3, :cond_6

    iget-boolean v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isListType:Z

    if-nez v4, :cond_6

    iget-boolean v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSArray:Z

    if-nez v4, :cond_6

    iget-object v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    if-nez v4, :cond_6

    return-object v2

    .line 240
    :cond_6
    iget-boolean v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSCallback:Z

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-eqz v4, :cond_a

    .line 242
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 243
    invoke-static {v0}, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    if-eqz v3, :cond_9

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 247
    iget-boolean v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mIsKeepAlive:Z

    if-eqz v4, :cond_7

    .line 249
    invoke-static {}, Lio/dcloud/feature/utsplugin/ParamConvertHelperKt;->getUtsCallbackCache()Ljava/util/Map;

    move-result-object v4

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lio/dcloud/uts/UTSCallback;

    if-eqz v4, :cond_7

    .line 252
    iget-object v0, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    invoke-virtual {v4, v0}, Lio/dcloud/uts/UTSCallback;->setHostCallback(Lcom/taobao/weex/bridge/JSCallback;)V

    return-object v4

    :cond_7
    const/4 v4, -0x1

    if-ne v0, v4, :cond_8

    return-object v2

    .line 266
    :cond_8
    :try_start_0
    iget-object v0, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    const/4 v4, 0x3

    .line 269
    new-array v7, v4, [Ljava/lang/Class;

    const-class v8, Lcom/taobao/weex/bridge/JSCallback;

    aput-object v8, v7, v6

    sget-object v8, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v8, v7, v5

    const-class v8, Ljava/lang/String;

    const/4 v9, 0x2

    aput-object v8, v7, v9

    .line 266
    invoke-virtual {v0, v7}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 271
    iget-object v7, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v7, v4, v6

    aput-object v3, v4, v5

    const-string v5, ""

    aput-object v5, v4, v9

    invoke-virtual {v0, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    .line 279
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception v0

    .line 277
    invoke-virtual {v0}, Ljava/lang/NoSuchMethodException;->printStackTrace()V

    goto :goto_0

    :catch_2
    move-exception v0

    .line 275
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    :catch_3
    move-exception v0

    .line 273
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    .line 282
    :goto_0
    iget-boolean v0, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mIsKeepAlive:Z

    if-eqz v0, :cond_9

    .line 284
    invoke-static {}, Lio/dcloud/feature/utsplugin/ParamConvertHelperKt;->getUtsCallbackCache()Ljava/util/Map;

    move-result-object v0

    const-string v4, "null cannot be cast to non-null type io.dcloud.uts.UTSCallback"

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v4, v2

    check-cast v4, Lio/dcloud/uts/UTSCallback;

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_9
    return-object v2

    :cond_a
    if-eqz v3, :cond_c

    :cond_b
    return-object v0

    .line 293
    :cond_c
    iget-boolean v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSArray:Z

    if-eqz v3, :cond_10

    .line 295
    instance-of v3, v0, Lcom/alibaba/fastjson/JSONArray;

    if-nez v3, :cond_d

    return-object v2

    .line 299
    :cond_d
    iget-object v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->hostTypeArguments:[Ljava/lang/reflect/Type;

    if-eqz v3, :cond_f

    array-length v3, v3

    if-nez v3, :cond_e

    goto :goto_2

    .line 304
    :cond_e
    new-instance v2, Lio/dcloud/uts/UTSArray;

    invoke-direct {v2}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 305
    new-instance v7, Lio/dcloud/feature/utsplugin/ParamConvertHelper;

    sget-object v3, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->Companion:Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;

    iget-object v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->hostTypeArguments:[Ljava/lang/reflect/Type;

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    aget-object v4, v4, v6

    invoke-virtual {v3, v4}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->typeNameCompat(Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v8

    const/16 v12, 0x8

    const/4 v13, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-direct/range {v7 .. v13}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 306
    check-cast v0, Ljava/lang/Iterable;

    .line 485
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_f

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 307
    invoke-virtual {v7, v3}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->getInstance(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 308
    invoke-virtual {v2, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_f
    :goto_2
    return-object v2

    .line 315
    :cond_10
    iget-boolean v3, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isListType:Z

    if-eqz v3, :cond_12

    .line 316
    instance-of v3, v0, Lcom/alibaba/fastjson/JSONArray;

    if-eqz v3, :cond_11

    .line 318
    check-cast v0, Ljava/lang/Iterable;

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v0

    return-object v0

    .line 319
    :cond_11
    instance-of v3, v0, Ljava/lang/String;

    if-eqz v3, :cond_12

    .line 320
    move-object v3, v0

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Lcom/alibaba/fastjson/JSON;->parseArray(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONArray;

    move-result-object v3

    if-eqz v3, :cond_12

    .line 322
    check-cast v3, Ljava/lang/Iterable;

    invoke-static {v3}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v0

    return-object v0

    .line 329
    :cond_12
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/alibaba/fastjson/JSONObject;->parseObject(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;

    move-result-object v3

    if-nez v3, :cond_13

    return-object v2

    .line 331
    :cond_13
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast v0, Ljava/util/Set;

    .line 334
    :try_start_1
    iget-object v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    if-eqz v4, :cond_1e

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {v4}, Lkotlin/jvm/JvmClassMappingKt;->getKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v4

    invoke-interface {v4}, Lkotlin/reflect/KClass;->getConstructors()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_14

    goto/16 :goto_8

    .line 338
    :cond_14
    iget-object v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {v4}, Lkotlin/jvm/JvmClassMappingKt;->getKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v4

    invoke-interface {v4}, Lkotlin/reflect/KClass;->getConstructors()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->size()I

    move-result v4

    if-ne v4, v5, :cond_1d

    .line 342
    iget-object v4, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {v4}, Lkotlin/jvm/JvmClassMappingKt;->getKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v4

    invoke-interface {v4}, Lkotlin/reflect/KClass;->getConstructors()Ljava/util/Collection;

    move-result-object v4

    check-cast v4, Ljava/lang/Iterable;

    invoke-static {v4}, Lkotlin/collections/CollectionsKt;->first(Ljava/lang/Iterable;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lkotlin/reflect/KFunction;

    .line 343
    invoke-interface {v4}, Lkotlin/reflect/KFunction;->getParameters()Ljava/util/List;

    move-result-object v7

    check-cast v7, Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_1c

    .line 344
    invoke-virtual {v3}, Lcom/alibaba/fastjson/JSONObject;->getInnerMap()Ljava/util/Map;

    move-result-object v7

    .line 346
    invoke-interface {v4}, Lkotlin/reflect/KFunction;->getParameters()Ljava/util/List;

    move-result-object v8

    check-cast v8, Ljava/lang/Iterable;

    .line 487
    new-instance v9, Ljava/util/LinkedHashMap;

    const/16 v10, 0xa

    invoke-static {v8, v10}, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable;I)I

    move-result v10

    invoke-static {v10}, Lkotlin/collections/MapsKt;->mapCapacity(I)I

    move-result v10

    const/16 v11, 0x10

    invoke-static {v10, v11}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v10

    invoke-direct {v9, v10}, Ljava/util/LinkedHashMap;-><init>(I)V

    .line 489
    invoke-interface {v8}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1b

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    .line 490
    move-object v11, v9

    check-cast v11, Ljava/util/Map;

    move-object v12, v10

    check-cast v12, Lkotlin/reflect/KParameter;

    .line 348
    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    if-eqz v13, :cond_18

    .line 353
    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v14

    invoke-static {v14}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v14

    invoke-interface {v14}, Lkotlin/reflect/KClass;->getSupertypes()Ljava/util/List;

    move-result-object v14

    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getType()Lkotlin/reflect/KType;

    move-result-object v15

    invoke-interface {v14, v15}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_18

    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v14

    invoke-static {v14}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v14

    move-object v15, v14

    check-cast v15, Lkotlin/reflect/KClassifier;

    const/16 v19, 0x7

    const/16 v20, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    invoke-static/range {v15 .. v20}, Lkotlin/reflect/full/KClassifiers;->createType$default(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;ILjava/lang/Object;)Lkotlin/reflect/KType;

    move-result-object v14

    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getType()Lkotlin/reflect/KType;

    move-result-object v15

    invoke-static {v14, v15}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_15

    goto/16 :goto_5

    .line 355
    :cond_15
    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getType()Lkotlin/reflect/KType;

    move-result-object v14

    invoke-interface {v14}, Lkotlin/reflect/KType;->getClassifier()Lkotlin/reflect/KClassifier;

    move-result-object v14

    const-class v15, Lio/dcloud/uts/UTSArray;

    invoke-static {v15}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v15

    invoke-static {v14, v15}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_17

    instance-of v14, v13, Lcom/alibaba/fastjson/JSONArray;

    if-eqz v14, :cond_17

    .line 357
    new-instance v15, Lio/dcloud/feature/utsplugin/ParamConvertHelper;

    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getType()Lkotlin/reflect/KType;

    move-result-object v14

    invoke-interface {v14}, Lkotlin/reflect/KType;->getArguments()Ljava/util/List;

    move-result-object v14

    invoke-interface {v14, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lkotlin/reflect/KTypeProjection;

    invoke-virtual {v14}, Lkotlin/reflect/KTypeProjection;->getType()Lkotlin/reflect/KType;

    move-result-object v14

    invoke-static {v14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v14}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v16

    const/16 v20, 0x8

    const/16 v21, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    invoke-direct/range {v15 .. v21}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 358
    new-instance v14, Lio/dcloud/uts/UTSArray;

    invoke-direct {v14}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 359
    check-cast v13, Ljava/lang/Iterable;

    .line 491
    invoke-interface {v13}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_4
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v16
    :try_end_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/lang/InstantiationException; {:try_start_1 .. :try_end_1} :catch_6

    if-eqz v16, :cond_16

    move-object/from16 v16, v2

    :try_start_2
    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 360
    invoke-virtual {v15, v2}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->getInstance(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 361
    invoke-virtual {v14, v2}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    move-object/from16 v2, v16

    goto :goto_4

    :cond_16
    move-object/from16 v16, v2

    move-object v13, v14

    goto :goto_6

    :cond_17
    move-object/from16 v16, v2

    .line 364
    instance-of v2, v13, Lcom/alibaba/fastjson/JSONObject;

    if-eqz v2, :cond_19

    .line 366
    sget-object v2, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->Companion:Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;

    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getType()Lkotlin/reflect/KType;

    move-result-object v14

    invoke-static {v14}, Lkotlin/reflect/jvm/ReflectJvmMapping;->getJavaType(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;

    move-result-object v14

    invoke-virtual {v2, v14}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->typeNameCompat(Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v18

    .line 367
    new-instance v17, Lio/dcloud/feature/utsplugin/ParamConvertHelper;

    const/16 v22, 0x8

    const/16 v23, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    invoke-direct/range {v17 .. v23}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    move-object/from16 v2, v17

    .line 368
    invoke-virtual {v2, v13}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->getInstance(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    goto :goto_6

    :cond_18
    :goto_5
    move-object/from16 v16, v2

    .line 373
    :cond_19
    :goto_6
    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getName()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1a

    .line 374
    invoke-interface {v12}, Lkotlin/reflect/KParameter;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 490
    :cond_1a
    invoke-interface {v11, v10, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object/from16 v2, v16

    goto/16 :goto_3

    :cond_1b
    move-object/from16 v16, v2

    .line 493
    check-cast v9, Ljava/util/Map;

    .line 381
    invoke-interface {v4, v9}, Lkotlin/reflect/KFunction;->callBy(Ljava/util/Map;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_7

    :cond_1c
    move-object/from16 v16, v2

    .line 383
    new-array v0, v6, [Ljava/lang/Object;

    invoke-interface {v4, v0}, Lkotlin/reflect/KFunction;->call([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_7

    :cond_1d
    move-object/from16 v16, v2

    .line 387
    iget-object v0, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0
    :try_end_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/InstantiationException; {:try_start_2 .. :try_end_2} :catch_4

    :goto_7
    move-object v2, v0

    goto :goto_c

    :catch_4
    move-exception v0

    goto :goto_9

    :catch_5
    move-exception v0

    goto :goto_a

    :cond_1e
    :goto_8
    move-object/from16 v16, v2

    goto :goto_b

    :catch_6
    move-exception v0

    move-object/from16 v16, v2

    .line 394
    :goto_9
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_b

    :catch_7
    move-exception v0

    move-object/from16 v16, v2

    .line 392
    :goto_a
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    :goto_b
    move-object/from16 v2, v16

    :goto_c
    if-nez v2, :cond_1f

    return-object v16

    .line 403
    :cond_1f
    iget-object v0, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v0

    .line 406
    invoke-static {v0}, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;

    move-result-object v4

    :cond_20
    :goto_d
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_28

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/reflect/Field;

    .line 408
    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v6

    .line 409
    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v7

    .line 410
    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v10

    .line 417
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_20

    .line 418
    invoke-virtual {v0, v5}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 419
    iget-object v8, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->UTSCallbackType:Ljava/lang/String;

    invoke-static {v8, v10}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_21

    .line 421
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->getIntValue(Ljava/lang/String;)I

    move-result v7

    .line 422
    new-instance v8, Lio/dcloud/uts/UTSCallback;

    iget-object v9, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-direct {v8, v9, v7, v6}, Lio/dcloud/uts/UTSCallback;-><init>(Lcom/taobao/weex/bridge/JSCallback;ILjava/lang/String;)V

    .line 424
    :try_start_3
    invoke-virtual {v0, v2, v8}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_3 .. :try_end_3} :catch_8

    goto :goto_d

    :catch_8
    move-exception v0

    .line 426
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_d

    .line 430
    :cond_21
    invoke-virtual {v7}, Ljava/lang/Class;->isPrimitive()Z

    move-result v7

    if-nez v7, :cond_27

    sget-object v7, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->Companion:Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v7, v10}, Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;->isPrimitiveType(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_22

    goto/16 :goto_10

    .line 437
    :cond_22
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    instance-of v7, v7, Ljava/lang/Boolean;

    if-nez v7, :cond_26

    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    instance-of v7, v7, Ljava/lang/Number;

    if-eqz v7, :cond_23

    goto/16 :goto_f

    .line 445
    :cond_23
    const-string v7, "io.dcloud.uts.UTSArray"

    invoke-static {v7, v10}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_25

    .line 448
    new-instance v9, Lio/dcloud/feature/utsplugin/ParamConvertHelper;

    iget-object v12, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    const/16 v14, 0x8

    const/4 v15, 0x0

    const/4 v11, 0x0

    const/4 v13, 0x0

    invoke-direct/range {v9 .. v15}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 450
    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getGenericType()Ljava/lang/reflect/Type;

    move-result-object v7

    instance-of v7, v7, Ljava/lang/reflect/ParameterizedType;

    if-eqz v7, :cond_24

    .line 451
    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getGenericType()Ljava/lang/reflect/Type;

    move-result-object v7

    const-string v8, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType"

    invoke-static {v7, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v7, Ljava/lang/reflect/ParameterizedType;

    invoke-interface {v7}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object v7

    move-object v11, v7

    goto :goto_e

    :cond_24
    move-object/from16 v11, v16

    .line 456
    :goto_e
    new-instance v9, Lio/dcloud/feature/utsplugin/ParamConvertHelper;

    iget-object v12, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    const/16 v14, 0x8

    const/4 v15, 0x0

    const/4 v13, 0x0

    invoke-direct/range {v9 .. v15}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 457
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 458
    invoke-virtual {v9, v6}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->getInstance(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 460
    :try_start_4
    invoke-virtual {v0, v2, v6}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/lang/IllegalAccessException; {:try_start_4 .. :try_end_4} :catch_9

    goto/16 :goto_d

    :catch_9
    move-exception v0

    .line 462
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto/16 :goto_d

    .line 467
    :cond_25
    new-instance v7, Lio/dcloud/feature/utsplugin/ParamConvertHelper;

    invoke-virtual {v0}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v8

    const-string v9, "getName(...)"

    invoke-static {v8, v9}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v10, v1, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    const/16 v12, 0x8

    const/4 v13, 0x0

    const/4 v9, 0x0

    const/4 v11, 0x0

    invoke-direct/range {v7 .. v13}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;-><init>(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 468
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 469
    invoke-virtual {v7, v6}, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->getInstance(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 471
    :try_start_5
    invoke-virtual {v0, v2, v6}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_5
    .catch Ljava/lang/IllegalAccessException; {:try_start_5 .. :try_end_5} :catch_a

    goto/16 :goto_d

    :catch_a
    move-exception v0

    .line 473
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto/16 :goto_d

    .line 440
    :cond_26
    :goto_f
    :try_start_6
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v0, v2, v6}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_6
    .catch Ljava/lang/IllegalAccessException; {:try_start_6 .. :try_end_6} :catch_b

    goto/16 :goto_d

    :catch_b
    move-exception v0

    .line 442
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto/16 :goto_d

    .line 433
    :cond_27
    :goto_10
    :try_start_7
    invoke-virtual {v3, v6}, Lcom/alibaba/fastjson/JSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v0, v2, v6}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_7
    .catch Ljava/lang/IllegalAccessException; {:try_start_7 .. :try_end_7} :catch_c

    goto/16 :goto_d

    :catch_c
    move-exception v0

    .line 435
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto/16 :goto_d

    :cond_28
    return-object v2
.end method

.method public final getMHostCallback()Lcom/taobao/weex/bridge/JSCallback;
    .locals 1

    .line 125
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    return-object v0
.end method

.method public final getMIsKeepAlive()Z
    .locals 1

    .line 131
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mIsKeepAlive:Z

    return v0
.end method

.method public final getStringClassFlag()Ljava/lang/String;
    .locals 1

    .line 101
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->StringClassFlag:Ljava/lang/String;

    return-object v0
.end method

.method public final getTClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation

    .line 127
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    return-object v0
.end method

.method public final getUTSCallbackType()Ljava/lang/String;
    .locals 1

    .line 99
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->UTSCallbackType:Ljava/lang/String;

    return-object v0
.end method

.method public final getUTSObjectType()Ljava/lang/String;
    .locals 1

    .line 100
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->UTSObjectType:Ljava/lang/String;

    return-object v0
.end method

.method public final isAnyType()Z
    .locals 1

    .line 123
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isAnyType:Z

    return v0
.end method

.method public final isListType()Z
    .locals 1

    .line 113
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isListType:Z

    return v0
.end method

.method public final isMapType()Z
    .locals 1

    .line 118
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isMapType:Z

    return v0
.end method

.method public final isPrimitive()Z
    .locals 1

    .line 112
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isPrimitive:Z

    return v0
.end method

.method public final isUTSArray()Z
    .locals 1

    .line 114
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSArray:Z

    return v0
.end method

.method public final isUTSCallback()Z
    .locals 1

    .line 106
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSCallback:Z

    return v0
.end method

.method public final isUTSObject()Z
    .locals 1

    .line 111
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSObject:Z

    return v0
.end method

.method public final setAnyType(Z)V
    .locals 0

    .line 123
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isAnyType:Z

    return-void
.end method

.method public final setHostTypeArguments([Ljava/lang/reflect/Type;)V
    .locals 0

    .line 129
    iput-object p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->hostTypeArguments:[Ljava/lang/reflect/Type;

    return-void
.end method

.method public final setListType(Z)V
    .locals 0

    .line 113
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isListType:Z

    return-void
.end method

.method public final setMHostCallback(Lcom/taobao/weex/bridge/JSCallback;)V
    .locals 0

    .line 125
    iput-object p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mHostCallback:Lcom/taobao/weex/bridge/JSCallback;

    return-void
.end method

.method public final setMIsKeepAlive(Z)V
    .locals 0

    .line 131
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->mIsKeepAlive:Z

    return-void
.end method

.method public final setMapType(Z)V
    .locals 0

    .line 118
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isMapType:Z

    return-void
.end method

.method public final setPrimitive(Z)V
    .locals 0

    .line 112
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isPrimitive:Z

    return-void
.end method

.method public final setTClass(Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)V"
        }
    .end annotation

    .line 127
    iput-object p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->tClass:Ljava/lang/Class;

    return-void
.end method

.method public final setUTSArray(Z)V
    .locals 0

    .line 114
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSArray:Z

    return-void
.end method

.method public final setUTSCallback(Z)V
    .locals 0

    .line 106
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSCallback:Z

    return-void
.end method

.method public final setUTSObject(Z)V
    .locals 0

    .line 111
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/ParamConvertHelper;->isUTSObject:Z

    return-void
.end method
