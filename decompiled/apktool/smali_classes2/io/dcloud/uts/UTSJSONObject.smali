.class public Lio/dcloud/uts/UTSJSONObject;
.super Ljava/lang/Object;
.source "UTSJSONObject.kt"

# interfaces
.implements Ljava/lang/Iterable;
.implements Lio/dcloud/uts/IUTSObject;
.implements Lio/dcloud/uts/log/LogSelfV2;
.implements Lio/dcloud/uts/IUTSSourceMap;
.implements Lkotlin/jvm/internal/markers/KMappedMarker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/uts/UTSJSONObject$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable<",
        "Ljava/lang/String;",
        ">;",
        "Lio/dcloud/uts/IUTSObject;",
        "Lio/dcloud/uts/log/LogSelfV2;",
        "Lio/dcloud/uts/IUTSSourceMap;",
        "Lkotlin/jvm/internal/markers/KMappedMarker;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUTSJSONObject.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UTSJSONObject.kt\nio/dcloud/uts/UTSJSONObject\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 JSON.kt\nio/dcloud/uts/JSON\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,924:1\n647#1,25:1008\n675#1,4:1066\n13472#2,2:925\n13472#2,2:967\n216#3,2:927\n216#3,2:929\n216#3,2:931\n216#3,2:933\n216#3,2:969\n216#3,2:971\n65#4,20:935\n62#4:955\n86#4,7:956\n363#4:975\n65#4,20:976\n62#4:996\n86#4,7:997\n364#4,4:1004\n363#4:1033\n65#4,20:1034\n62#4:1054\n86#4,7:1055\n364#4,4:1062\n1869#5,2:963\n1869#5,2:965\n1869#5:1070\n1869#5,2:1071\n1869#5,2:1073\n1870#5:1075\n32#6,2:973\n*S KotlinDebug\n*F\n+ 1 UTSJSONObject.kt\nio/dcloud/uts/UTSJSONObject\n*L\n688#1:1008,25\n688#1:1066,4\n189#1:925,2\n458#1:967,2\n226#1:927,2\n232#1:929,2\n236#1:931,2\n261#1:933,2\n527#1:969,2\n545#1:971,2\n275#1:935,20\n275#1:955\n275#1:956,7\n671#1:975\n671#1:976,20\n671#1:996\n671#1:997,7\n671#1:1004,4\n688#1:1033\n688#1:1034,20\n688#1:1054\n688#1:1055,7\n688#1:1062,4\n385#1:963,2\n445#1:965,2\n870#1:1070\n887#1:1071,2\n895#1:1073,2\n870#1:1075\n554#1:973,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0008\t\n\u0002\u0010\u0004\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0016\u0018\u0000 a2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001aB\u0007\u00a2\u0006\u0004\u0008\u0006\u0010\u0007B\u001b\u0008\u0016\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\u0008\u0006\u0010\u000cB\u0013\u0008\u0016\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\u0008\u0006\u0010\rJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016J\u0008\u0010(\u001a\u00020)H\u0002J)\u0010*\u001a\u00020)2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\u000c\u0008-\u0012\u0008\u0008.\u0012\u0004\u0008\u0008(/\u0012\u0004\u0012\u00020)0,J\u0018\u00100\u001a\u0004\u0018\u0001H1\"\u0006\u0008\u0000\u00101\u0018\u0001H\u0086\u0008\u00a2\u0006\u0002\u00102J\u0008\u00103\u001a\u000204H\u0007J\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\tJ\u0013\u00107\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\tH\u0096\u0002J\u001b\u00108\u001a\u00020)2\u0006\u0010.\u001a\u00020\t2\u0008\u0010/\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0016\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016J\u0016\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0;H\u0016J\u000e\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\u0002J\u0014\u0010>\u001a\u00020\u00162\n\u0010?\u001a\u0006\u0012\u0002\u0008\u00030@H\u0002J\u0019\u0010>\u001a\u00020\u00162\n\u0010A\u001a\u0006\u0012\u0002\u0008\u00030BH\u0002\u00a2\u0006\u0002\u0010CJ\u0014\u0010D\u001a\u0004\u0018\u00010\t2\u0008\u0010E\u001a\u0004\u0018\u00010\tH\u0002J\u0008\u0010F\u001a\u00020GH\u0016J\u000e\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u0000J\u000e\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u0003J\u0012\u0010H\u001a\u00020)2\n\u0010I\u001a\u0006\u0012\u0002\u0008\u00030JJ\u0012\u0010H\u001a\u00020)2\n\u0010I\u001a\u0006\u0012\u0002\u0008\u00030KJ\u000f\u0010L\u001a\u0008\u0012\u0004\u0012\u00020\u00020MH\u0096\u0002J\u0008\u0010N\u001a\u00020\u0002H\u0016J\u0008\u0010O\u001a\u00020\u0002H\u0016J\u0016\u0010P\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010K2\u0006\u0010=\u001a\u00020\u0002H\u0016J \u0010P\u001a\u0006\u0012\u0002\u0008\u00030K2\u0006\u0010=\u001a\u00020\u00022\n\u0010Q\u001a\u0006\u0012\u0002\u0008\u00030KH\u0016J&\u0010P\u001a\n\u0012\u0004\u0012\u0002H1\u0018\u00010K\"\u0006\u0008\u0000\u00101\u0018\u00012\u0006\u0010=\u001a\u00020\u0002H\u0087\u0008\u00a2\u0006\u0002\u0008RJ2\u0010P\u001a\u0008\u0012\u0004\u0012\u0002H10K\"\u0006\u0008\u0000\u00101\u0018\u00012\u0006\u0010=\u001a\u00020\u00022\u000c\u0010Q\u001a\u0008\u0012\u0004\u0012\u0002H10KH\u0087\u0008\u00a2\u0006\u0002\u0008SJ\u0012\u0010T\u001a\u0004\u0018\u00010\u00002\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010T\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0000H\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010\u00022\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010U\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0002H\u0016J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010V\u001a\u00020W2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020WH\u0016J\u0017\u0010X\u001a\u0004\u0018\u0001042\u0006\u0010=\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010YJ\u0018\u0010X\u001a\u0002042\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u000204H\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010Z\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\tH\u0016J\u001a\u0010[\u001a\u0004\u0018\u00010\t2\u0008\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\u0002J\u001a\u0010[\u001a\u0004\u0018\u00010\t2\u0008\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010^\u001a\u00020_J\u0012\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020\u0002H\u0016R&\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\u0008\u000f\u0010\u0007\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R&\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\u0008\u0017\u0010\u0007\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR*\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d8\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\u0008\u001e\u0010\u0007\u001a\u0004\u0008\u001f\u0010 R4\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\u0008#\u0010\u0007\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010\'\u00a8\u0006b"
    }
    d2 = {
        "Lio/dcloud/uts/UTSJSONObject;",
        "",
        "",
        "Lio/dcloud/uts/IUTSObject;",
        "Lio/dcloud/uts/log/LogSelfV2;",
        "Lio/dcloud/uts/IUTSSourceMap;",
        "<init>",
        "()V",
        "anyObj",
        "",
        "sourceMap",
        "Lio/dcloud/uts/UTSSourceMapPosition;",
        "(Ljava/lang/Object;Lio/dcloud/uts/UTSSourceMapPosition;)V",
        "(Ljava/lang/Object;)V",
        "__$hostSourceMap",
        "get__$hostSourceMap$annotations",
        "get__$hostSourceMap",
        "()Lio/dcloud/uts/UTSSourceMapPosition;",
        "set__$hostSourceMap",
        "(Lio/dcloud/uts/UTSSourceMapPosition;)V",
        "__$getOriginalPosition",
        "__$arrayContent",
        "Lcom/alibaba/fastjson/JSONArray;",
        "get__$arrayContent$annotations",
        "get__$arrayContent",
        "()Lcom/alibaba/fastjson/JSONArray;",
        "set__$arrayContent",
        "(Lcom/alibaba/fastjson/JSONArray;)V",
        "dynamicJSONFields",
        "Lio/dcloud/uts/gson/internal/LinkedTreeMap;",
        "getDynamicJSONFields$annotations",
        "getDynamicJSONFields",
        "()Lio/dcloud/uts/gson/internal/LinkedTreeMap;",
        "__$cacheCustomFieldMap",
        "Lio/dcloud/uts/Map;",
        "get__$cacheCustomFieldMap$annotations",
        "get__$cacheCustomFieldMap",
        "()Lio/dcloud/uts/Map;",
        "set__$cacheCustomFieldMap",
        "(Lio/dcloud/uts/Map;)V",
        "initCacheField",
        "",
        "forEach",
        "action",
        "Lkotlin/Function1;",
        "Lkotlin/ParameterName;",
        "name",
        "value",
        "parse",
        "T",
        "()Ljava/lang/Object;",
        "isJSONArray",
        "",
        "fillJSON",
        "json",
        "get",
        "set",
        "toMap",
        "toLogMap",
        "",
        "hasOwnProperty",
        "key",
        "wrapToJSONArray",
        "list",
        "",
        "array",
        "",
        "([Ljava/lang/Object;)Lcom/alibaba/fastjson/JSONArray;",
        "wrapArrayItem",
        "item",
        "toJSONObject",
        "Lcom/alibaba/fastjson/JSON;",
        "mergeOther",
        "other",
        "",
        "Lio/dcloud/uts/UTSArray;",
        "iterator",
        "",
        "toString",
        "toJSONString",
        "getArray",
        "def",
        "getArray_withType",
        "getArray_withType_def",
        "getJSON",
        "getString",
        "getNumber",
        "",
        "getBoolean",
        "(Ljava/lang/String;)Ljava/lang/Boolean;",
        "getAny",
        "getCanInnerAttribute",
        "host",
        "attribute",
        "index",
        "",
        "resolveKeyPath",
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
.field public static final Companion:Lio/dcloud/uts/UTSJSONObject$Companion;


# instance fields
.field private __$arrayContent:Lcom/alibaba/fastjson/JSONArray;
    .annotation runtime Lio/dcloud/uts/GsonTransparent;
    .end annotation
.end field

.field private __$cacheCustomFieldMap:Lio/dcloud/uts/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/dcloud/uts/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation runtime Lio/dcloud/uts/GsonTransparent;
    .end annotation
.end field

.field private __$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;
    .annotation runtime Lio/dcloud/uts/GsonTransparent;
    .end annotation
.end field

.field private final dynamicJSONFields:Lio/dcloud/uts/gson/internal/LinkedTreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lio/dcloud/uts/gson/internal/LinkedTreeMap<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation runtime Lio/dcloud/uts/GsonTransparent;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lio/dcloud/uts/UTSJSONObject$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSJSONObject$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lio/dcloud/uts/UTSJSONObject;->Companion:Lio/dcloud/uts/UTSJSONObject$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 127
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 168
    new-instance v0, Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    invoke-direct {v0}, Lio/dcloud/uts/gson/internal/LinkedTreeMap;-><init>()V

    iput-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->dynamicJSONFields:Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 5

    .line 214
    invoke-direct {p0}, Lio/dcloud/uts/UTSJSONObject;-><init>()V

    if-nez p1, :cond_0

    goto/16 :goto_3

    .line 220
    :cond_0
    instance-of v0, p1, Lio/dcloud/uts/UTSSourceMapPosition;

    if-eqz v0, :cond_1

    .line 221
    check-cast p1, Lio/dcloud/uts/UTSSourceMapPosition;

    iput-object p1, p0, Lio/dcloud/uts/UTSJSONObject;->__$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;

    return-void

    .line 225
    :cond_1
    instance-of v0, p1, Lcom/alibaba/fastjson/JSONObject;

    if-eqz v0, :cond_2

    .line 226
    check-cast p1, Ljava/util/Map;

    .line 927
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 227
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 229
    :cond_2
    instance-of v0, p1, Lio/dcloud/uts/UTSJSONObject;

    if-eqz v0, :cond_3

    .line 231
    check-cast p1, Lio/dcloud/uts/UTSJSONObject;

    invoke-virtual {p1}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object p1

    .line 232
    check-cast p1, Ljava/util/Map;

    .line 929
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 233
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 235
    :cond_3
    instance-of v0, p1, Ljava/util/Map;

    if-eqz v0, :cond_6

    .line 236
    check-cast p1, Ljava/util/Map;

    .line 931
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_4
    :goto_2
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 237
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 238
    const-string v1, "__$originalPosition"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lio/dcloud/uts/UTSSourceMapPosition;

    if-eqz v1, :cond_5

    .line 243
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type io.dcloud.uts.UTSSourceMapPosition"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lio/dcloud/uts/UTSSourceMapPosition;

    iput-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;

    goto :goto_2

    .line 246
    :cond_5
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-static {v2, v4, v3, v4}, Lio/dcloud/uts/NumberKt;->toString_number_nullable$default(Ljava/lang/Object;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    :cond_6
    :goto_3
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Lio/dcloud/uts/UTSSourceMapPosition;)V
    .locals 1

    const-string v0, "sourceMap"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 154
    invoke-direct {p0, p1}, Lio/dcloud/uts/UTSJSONObject;-><init>(Ljava/lang/Object;)V

    .line 155
    iput-object p2, p0, Lio/dcloud/uts/UTSJSONObject;->__$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;

    return-void
.end method

.method public static synthetic getDynamicJSONFields$annotations()V
    .locals 0
    .annotation runtime Lio/dcloud/uts/UTSJsonTransparent;
    .end annotation

    return-void
.end method

.method public static synthetic get__$arrayContent$annotations()V
    .locals 0
    .annotation runtime Lio/dcloud/uts/UTSJsonTransparent;
    .end annotation

    return-void
.end method

.method public static synthetic get__$cacheCustomFieldMap$annotations()V
    .locals 0
    .annotation runtime Lio/dcloud/uts/UTSJsonTransparent;
    .end annotation

    return-void
.end method

.method public static synthetic get__$hostSourceMap$annotations()V
    .locals 0
    .annotation runtime Lio/dcloud/uts/UTSJsonTransparent;
    .end annotation

    return-void
.end method

.method private final initCacheField()V
    .locals 7

    .line 180
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "io.dcloud.uts.UTSJSONObject"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    .line 181
    iput-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    return-void

    .line 182
    :cond_0
    iget-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    if-nez v0, :cond_3

    .line 184
    new-instance v0, Lio/dcloud/uts/Map;

    invoke-direct {v0}, Lio/dcloud/uts/Map;-><init>()V

    iput-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    .line 186
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 187
    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v0

    .line 189
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 925
    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_3

    aget-object v3, v0, v2

    .line 191
    const-class v4, Lio/dcloud/uts/GsonTransparent;

    invoke-virtual {v3, v4}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v4

    if-eqz v4, :cond_1

    goto :goto_1

    .line 195
    :cond_1
    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Companion"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-virtual {v3, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lio/dcloud/uts/UTSJSONObject$Companion;

    if-eqz v4, :cond_2

    goto :goto_1

    :cond_2
    const/4 v4, 0x1

    .line 203
    invoke-virtual {v3, v4}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 205
    invoke-virtual {v3, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 206
    iget-object v5, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v3

    const-string v6, "getName(...)"

    invoke-static {v3, v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v5, v3, v4}, Lio/dcloud/uts/Map;->set(Ljava/lang/Object;Ljava/lang/Object;)Lio/dcloud/uts/Map;

    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_3
    return-void
.end method

.method private final wrapArrayItem(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5

    .line 469
    instance-of v0, p1, Lio/dcloud/uts/UTSJSONObject;

    if-eqz v0, :cond_0

    .line 470
    check-cast p1, Lio/dcloud/uts/UTSJSONObject;

    invoke-virtual {p1}, Lio/dcloud/uts/UTSJSONObject;->toJSONObject()Lcom/alibaba/fastjson/JSON;

    move-result-object p1

    return-object p1

    .line 473
    :cond_0
    instance-of v0, p1, Ljava/util/List;

    if-eqz v0, :cond_1

    .line 474
    check-cast p1, Ljava/util/List;

    invoke-direct {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->wrapToJSONArray(Ljava/util/List;)Lcom/alibaba/fastjson/JSONArray;

    move-result-object p1

    return-object p1

    .line 477
    :cond_1
    instance-of v0, p1, [Ljava/lang/Object;

    if-eqz v0, :cond_2

    .line 478
    check-cast p1, [Ljava/lang/Object;

    invoke-direct {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->wrapToJSONArray([Ljava/lang/Object;)Lcom/alibaba/fastjson/JSONArray;

    move-result-object p1

    return-object p1

    .line 481
    :cond_2
    instance-of v0, p1, Lcom/alibaba/fastjson/JSONObject;

    if-eqz v0, :cond_3

    goto :goto_1

    .line 486
    :cond_3
    instance-of v0, p1, Ljava/lang/String;

    if-nez v0, :cond_7

    instance-of v0, p1, Ljava/lang/Number;

    if-nez v0, :cond_7

    instance-of v0, p1, Ljava/lang/Boolean;

    if-nez v0, :cond_7

    instance-of v0, p1, Ljava/lang/Character;

    if-nez v0, :cond_7

    if-nez p1, :cond_4

    goto :goto_1

    .line 494
    :cond_4
    instance-of v0, p1, Lio/dcloud/uts/json/IJsonStringify;

    if-eqz v0, :cond_5

    .line 496
    check-cast p1, Lio/dcloud/uts/json/IJsonStringify;

    invoke-interface {p1}, Lio/dcloud/uts/json/IJsonStringify;->toJSON()Ljava/lang/Object;

    move-result-object p1

    invoke-direct {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->wrapArrayItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    .line 499
    :cond_5
    instance-of v0, p1, Lio/dcloud/uts/UTSObject;

    if-eqz v0, :cond_7

    .line 501
    new-instance v0, Lcom/alibaba/fastjson/JSONObject;

    invoke-direct {v0}, Lcom/alibaba/fastjson/JSONObject;-><init>()V

    .line 503
    check-cast p1, Lio/dcloud/uts/UTSObject;

    invoke-virtual {p1}, Lio/dcloud/uts/UTSObject;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 504
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 505
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 506
    move-object v3, v0

    check-cast v3, Ljava/util/Map;

    invoke-virtual {p1, v2}, Lio/dcloud/uts/UTSObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-direct {p0, v4}, Lio/dcloud/uts/UTSJSONObject;->wrapArrayItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v3, v2, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_6
    return-object v0

    :cond_7
    :goto_1
    return-object p1
.end method

.method private final wrapToJSONArray(Ljava/util/List;)Lcom/alibaba/fastjson/JSONArray;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "*>;)",
            "Lcom/alibaba/fastjson/JSONArray;"
        }
    .end annotation

    .line 443
    new-instance v0, Lcom/alibaba/fastjson/JSONArray;

    invoke-direct {v0}, Lcom/alibaba/fastjson/JSONArray;-><init>()V

    .line 445
    check-cast p1, Ljava/lang/Iterable;

    .line 965
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 446
    invoke-direct {p0, v1}, Lio/dcloud/uts/UTSJSONObject;->wrapArrayItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/alibaba/fastjson/JSONArray;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    return-object v0
.end method

.method private final wrapToJSONArray([Ljava/lang/Object;)Lcom/alibaba/fastjson/JSONArray;
    .locals 4

    .line 456
    new-instance v0, Lcom/alibaba/fastjson/JSONArray;

    invoke-direct {v0}, Lcom/alibaba/fastjson/JSONArray;-><init>()V

    .line 967
    array-length v1, p1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, p1, v2

    .line 459
    invoke-direct {p0, v3}, Lio/dcloud/uts/UTSJSONObject;->wrapArrayItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/alibaba/fastjson/JSONArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-object v0
.end method


# virtual methods
.method public __$getOriginalPosition()Lio/dcloud/uts/UTSSourceMapPosition;
    .locals 1

    .line 159
    iget-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;

    return-object v0
.end method

.method public final fillJSON(Ljava/lang/Object;)V
    .locals 4

    const-string v0, "json"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 291
    instance-of v0, p1, Lcom/alibaba/fastjson/JSONArray;

    if-eqz v0, :cond_0

    .line 292
    check-cast p1, Lcom/alibaba/fastjson/JSONArray;

    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->set__$arrayContent(Lcom/alibaba/fastjson/JSONArray;)V

    return-void

    .line 293
    :cond_0
    instance-of v0, p1, Lcom/alibaba/fastjson/JSONObject;

    if-eqz v0, :cond_3

    const/4 v0, 0x0

    .line 294
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSJSONObject;->set__$arrayContent(Lcom/alibaba/fastjson/JSONArray;)V

    .line 295
    check-cast p1, Lcom/alibaba/fastjson/JSONObject;

    invoke-virtual {p1}, Lcom/alibaba/fastjson/JSONObject;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "next(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/util/Map$Entry;

    .line 296
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    .line 297
    instance-of v2, v1, Lcom/alibaba/fastjson/JSONObject;

    const-string v3, "toJSONString(...)"

    if-eqz v2, :cond_1

    .line 298
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v1, Lcom/alibaba/fastjson/JSONObject;

    invoke-virtual {v1}, Lcom/alibaba/fastjson/JSONObject;->toJSONString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v1}, Lio/dcloud/uts/JSON;->parse(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 299
    :cond_1
    instance-of v2, v1, Lcom/alibaba/fastjson/JSONArray;

    if-eqz v2, :cond_2

    .line 300
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v1, Lcom/alibaba/fastjson/JSONArray;

    invoke-virtual {v1}, Lcom/alibaba/fastjson/JSONArray;->toJSONString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v1}, Lio/dcloud/uts/JSON;->parse(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 302
    :cond_2
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {v2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_3
    return-void
.end method

.method public final forEach(Lkotlin/jvm/functions/Function1;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "Ljava/lang/Object;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "action"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 259
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object v0

    .line 261
    check-cast v0, Ljava/util/Map;

    .line 933
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 262
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 264
    invoke-interface {p1, v1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_1
    return-void
.end method

.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    const-string v0, "name"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 316
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 318
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_0

    .line 319
    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v1

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v1}, Lcom/alibaba/fastjson/JSONArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 320
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    invoke-virtual {v0, p1}, Lcom/alibaba/fastjson/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_0
    const/4 p1, 0x0

    return-object p1

    .line 326
    :cond_1
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2

    return-object v0

    .line 332
    :cond_2
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object v0

    .line 333
    check-cast v0, Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public getAny(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 801
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public getAny(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "def"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 808
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->getAny(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_0

    return-object p1

    :cond_0
    return-object p2
.end method

.method public getArray(Ljava/lang/String;)Lio/dcloud/uts/UTSArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "*>;"
        }
    .end annotation

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 622
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 624
    instance-of v0, p1, Lio/dcloud/uts/UTSArray;

    if-eqz v0, :cond_0

    .line 625
    check-cast p1, Lio/dcloud/uts/UTSArray;

    return-object p1

    :cond_0
    const/4 p1, 0x0

    return-object p1
.end method

.method public getArray(Ljava/lang/String;Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lio/dcloud/uts/UTSArray<",
            "*>;)",
            "Lio/dcloud/uts/UTSArray<",
            "*>;"
        }
    .end annotation

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "def"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 635
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->getArray(Ljava/lang/String;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    if-eqz p1, :cond_0

    return-object p1

    :cond_0
    return-object p2
.end method

.method public final synthetic getArray_withType(Ljava/lang/String;)Lio/dcloud/uts/UTSArray;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 647
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 649
    instance-of v0, p1, Lio/dcloud/uts/UTSArray;

    const/4 v1, 0x0

    if-eqz v0, :cond_4

    .line 653
    move-object v0, p1

    check-cast v0, Lio/dcloud/uts/UTSArray;

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->needClassReification()V

    sget-object v2, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;->INSTANCE:Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2}, Lio/dcloud/uts/UTSArray;->find(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_0

    return-object v0

    .line 661
    :cond_0
    sget-object v2, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoUTS$1;->INSTANCE:Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoUTS$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2}, Lio/dcloud/uts/UTSArray;->find(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    return-object v1

    .line 667
    :cond_1
    invoke-static {p1}, Lio/dcloud/uts/JSON;->stringify(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    if-nez p1, :cond_2

    return-object v1

    .line 975
    :cond_2
    sget-object v0, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    .line 980
    const-class v0, Lio/dcloud/uts/UTSArray;

    const-string v0, "UTSArray"

    const-string v2, "String"

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 981
    check-cast p1, Lio/dcloud/uts/UTSArray;

    goto :goto_0

    .line 988
    :cond_3
    invoke-static {}, Lio/dcloud/uts/ObjectKt;->getGlobalError()Ljava/util/Map;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 994
    :try_start_0
    sget-object v0, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    sget-object v0, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    invoke-virtual {v0}, Lio/dcloud/uts/JSON;->getCacheParseGson()Lio/dcloud/uts/gson/Gson;

    move-result-object v0

    .line 996
    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->needClassReification()V

    new-instance v2, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$parseArrayType$1;

    invoke-direct {v2}, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$parseArrayType$1;-><init>()V

    invoke-virtual {v2}, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$parseArrayType$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Lio/dcloud/uts/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    .line 1000
    invoke-static {}, Lio/dcloud/uts/ObjectKt;->getGlobalError()Ljava/util/Map;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object p1, v1

    .line 975
    :goto_0
    check-cast p1, Lio/dcloud/uts/UTSArray;

    if-eqz p1, :cond_4

    move-object v1, p1

    :cond_4
    return-object v1
.end method

.method public final synthetic getArray_withType_def(Ljava/lang/String;Lio/dcloud/uts/UTSArray;)Lio/dcloud/uts/UTSArray;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Lio/dcloud/uts/UTSArray<",
            "TT;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "def"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1008
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 1010
    instance-of v0, p1, Lio/dcloud/uts/UTSArray;

    const/4 v1, 0x0

    if-eqz v0, :cond_4

    .line 1014
    move-object v0, p1

    check-cast v0, Lio/dcloud/uts/UTSArray;

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->needClassReification()V

    sget-object v2, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$getArray_withType$1;->INSTANCE:Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$getArray_withType$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2}, Lio/dcloud/uts/UTSArray;->find(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_0

    move-object v1, v0

    goto :goto_1

    .line 1022
    :cond_0
    sget-object v2, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoUTS$1;->INSTANCE:Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoUTS$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2}, Lio/dcloud/uts/UTSArray;->find(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    goto :goto_1

    .line 1028
    :cond_1
    invoke-static {p1}, Lio/dcloud/uts/JSON;->stringify(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    if-nez p1, :cond_2

    goto :goto_1

    .line 1033
    :cond_2
    sget-object v0, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    .line 1038
    const-class v0, Lio/dcloud/uts/UTSArray;

    const-string v0, "UTSArray"

    const-string v2, "String"

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1039
    check-cast p1, Lio/dcloud/uts/UTSArray;

    goto :goto_0

    .line 1046
    :cond_3
    invoke-static {}, Lio/dcloud/uts/ObjectKt;->getGlobalError()Ljava/util/Map;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1052
    :try_start_0
    sget-object v0, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    sget-object v0, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    invoke-virtual {v0}, Lio/dcloud/uts/JSON;->getCacheParseGson()Lio/dcloud/uts/gson/Gson;

    move-result-object v0

    .line 1054
    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->needClassReification()V

    new-instance v2, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$getArray_withType$2;

    invoke-direct {v2}, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$getArray_withType$2;-><init>()V

    invoke-virtual {v2}, Lio/dcloud/uts/UTSJSONObject$getArray$$inlined$getArray_withType$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Lio/dcloud/uts/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception p1

    .line 1058
    invoke-static {}, Lio/dcloud/uts/ObjectKt;->getGlobalError()Ljava/util/Map;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object p1, v1

    .line 1033
    :goto_0
    check-cast p1, Lio/dcloud/uts/UTSArray;

    if-eqz p1, :cond_4

    move-object v1, p1

    :cond_4
    :goto_1
    if-eqz v1, :cond_5

    return-object v1

    :cond_5
    return-object p2
.end method

.method public getBoolean(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 777
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 778
    instance-of v0, p1, Ljava/lang/Boolean;

    if-nez v0, :cond_0

    const/4 p1, 0x0

    return-object p1

    .line 782
    :cond_0
    check-cast p1, Ljava/lang/Boolean;

    return-object p1
.end method

.method public getBoolean(Ljava/lang/String;Z)Z
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 789
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->getBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 791
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    return p1

    :cond_0
    return p2
.end method

.method public final getCanInnerAttribute(Ljava/lang/Object;I)Ljava/lang/Object;
    .locals 1

    .line 834
    instance-of v0, p1, Ljava/util/List;

    if-eqz v0, :cond_0

    .line 835
    check-cast p1, Ljava/util/List;

    invoke-interface {p1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    .line 836
    :cond_0
    instance-of v0, p1, [Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 837
    check-cast p1, [Ljava/lang/Object;

    aget-object p1, p1, p2

    return-object p1

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method public final getCanInnerAttribute(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1

    const-string v0, "attribute"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 820
    instance-of v0, p1, Lio/dcloud/uts/UTSJSONObject;

    if-eqz v0, :cond_0

    .line 821
    check-cast p1, Lio/dcloud/uts/UTSJSONObject;

    invoke-virtual {p1, p2}, Lio/dcloud/uts/UTSJSONObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    .line 822
    :cond_0
    instance-of v0, p1, Lio/dcloud/uts/IUTSObject;

    if-eqz v0, :cond_1

    .line 823
    check-cast p1, Lio/dcloud/uts/IUTSObject;

    invoke-interface {p1, p2}, Lio/dcloud/uts/IUTSObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    .line 824
    :cond_1
    instance-of v0, p1, Ljava/util/Map;

    if-eqz v0, :cond_2

    .line 825
    check-cast p1, Ljava/util/Map;

    invoke-interface {p1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    :cond_2
    const/4 p1, 0x0

    return-object p1
.end method

.method public getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/dcloud/uts/gson/internal/LinkedTreeMap<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 166
    iget-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->dynamicJSONFields:Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    return-object v0
.end method

.method public getJSON(Ljava/lang/String;)Lio/dcloud/uts/UTSJSONObject;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 702
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 704
    instance-of v0, p1, Lio/dcloud/uts/UTSJSONObject;

    if-eqz v0, :cond_0

    .line 705
    check-cast p1, Lio/dcloud/uts/UTSJSONObject;

    return-object p1

    .line 707
    :cond_0
    instance-of v0, p1, Lcom/alibaba/fastjson/JSONObject;

    if-eqz v0, :cond_1

    .line 708
    new-instance v0, Lio/dcloud/uts/UTSJSONObject;

    invoke-direct {v0}, Lio/dcloud/uts/UTSJSONObject;-><init>()V

    .line 709
    invoke-virtual {v0, p1}, Lio/dcloud/uts/UTSJSONObject;->fillJSON(Ljava/lang/Object;)V

    return-object v0

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method public getJSON(Ljava/lang/String;Lio/dcloud/uts/UTSJSONObject;)Lio/dcloud/uts/UTSJSONObject;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "def"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 719
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->getJSON(Ljava/lang/String;)Lio/dcloud/uts/UTSJSONObject;

    move-result-object p1

    if-eqz p1, :cond_0

    return-object p1

    :cond_0
    return-object p2
.end method

.method public getNumber(Ljava/lang/String;)Ljava/lang/Number;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 753
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 754
    instance-of v0, p1, Ljava/lang/Number;

    if-nez v0, :cond_0

    const/4 p1, 0x0

    return-object p1

    .line 758
    :cond_0
    check-cast p1, Ljava/lang/Number;

    return-object p1
.end method

.method public getNumber(Ljava/lang/String;Ljava/lang/Number;)Ljava/lang/Number;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "def"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 765
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->getNumber(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object p1

    if-eqz p1, :cond_0

    return-object p1

    :cond_0
    return-object p2
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 730
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    .line 731
    instance-of v0, p1, Ljava/lang/String;

    if-nez v0, :cond_0

    const/4 p1, 0x0

    return-object p1

    .line 734
    :cond_0
    check-cast p1, Ljava/lang/String;

    return-object p1
.end method

.method public getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "def"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 741
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_0

    return-object p1

    :cond_0
    return-object p2
.end method

.method public get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;
    .locals 1

    .line 162
    iget-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$arrayContent:Lcom/alibaba/fastjson/JSONArray;

    return-object v0
.end method

.method public final get__$cacheCustomFieldMap()Lio/dcloud/uts/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/dcloud/uts/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 171
    iget-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    return-object v0
.end method

.method public final get__$hostSourceMap()Lio/dcloud/uts/UTSSourceMapPosition;
    .locals 1

    .line 150
    iget-object v0, p0, Lio/dcloud/uts/UTSJSONObject;->__$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;

    return-object v0
.end method

.method public final hasOwnProperty(Ljava/lang/String;)Z
    .locals 1

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 435
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final isJSONArray()Z
    .locals 1
    .annotation runtime Lkotlin/Deprecated;
        message = "UTSJSONObject never be a array"
        replaceWith = .subannotation Lkotlin/ReplaceWith;
            expression = ""
            imports = {}
        .end subannotation
    .end annotation

    .line 284
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 577
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/uts/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public final mergeOther(Lio/dcloud/uts/IUTSObject;)V
    .locals 4

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 554
    invoke-interface {p1}, Lio/dcloud/uts/IUTSObject;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 973
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 555
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-interface {p1, v1}, Lio/dcloud/uts/IUTSObject;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_0
    return-void
.end method

.method public final mergeOther(Lio/dcloud/uts/UTSArray;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSArray<",
            "*>;)V"
        }
    .end annotation

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 571
    move-object v0, p1

    check-cast v0, Ljava/util/Collection;

    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    .line 572
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method public final mergeOther(Lio/dcloud/uts/UTSJSONObject;)V
    .locals 5

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 537
    invoke-virtual {p1}, Lio/dcloud/uts/UTSJSONObject;->isJSONArray()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 539
    invoke-virtual {p1}, Lio/dcloud/uts/UTSJSONObject;->toJSONObject()Lcom/alibaba/fastjson/JSON;

    move-result-object p1

    const-string v0, "null cannot be cast to non-null type com.alibaba.fastjson.JSONArray"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Lcom/alibaba/fastjson/JSONArray;

    .line 540
    invoke-virtual {p1}, Lcom/alibaba/fastjson/JSONArray;->toArray()[Ljava/lang/Object;

    move-result-object v0

    array-length v0, v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 541
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v1}, Lcom/alibaba/fastjson/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 545
    :cond_0
    invoke-virtual {p1}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object p1

    check-cast p1, Ljava/util/Map;

    .line 971
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 546
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_1
    return-void
.end method

.method public final mergeOther(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "*>;)V"
        }
    .end annotation

    const-string v0, "other"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 564
    move-object v0, p1

    check-cast v0, Ljava/util/Collection;

    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    .line 565
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method public final synthetic parse()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()TT;"
        }
    .end annotation

    .line 275
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toJSONObject()Lcom/alibaba/fastjson/JSON;

    move-result-object v0

    invoke-virtual {v0}, Lcom/alibaba/fastjson/JSON;->toJSONString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "toJSONString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v1, v0

    check-cast v1, Ljava/lang/String;

    const/4 v1, 0x4

    .line 939
    const-string v2, "T"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(ILjava/lang/String;)V

    const-class v1, Ljava/lang/Object;

    move-object v3, v1

    check-cast v3, Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const-string v3, "String"

    invoke-static {v3, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    .line 940
    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(ILjava/lang/String;)V

    check-cast v0, Ljava/lang/Object;

    return-object v0

    .line 947
    :cond_0
    invoke-static {}, Lio/dcloud/uts/ObjectKt;->getGlobalError()Ljava/util/Map;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 953
    :try_start_0
    sget-object v1, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    sget-object v1, Lio/dcloud/uts/JSON;->INSTANCE:Lio/dcloud/uts/JSON;

    invoke-virtual {v1}, Lio/dcloud/uts/JSON;->getCacheParseGson()Lio/dcloud/uts/gson/Gson;

    move-result-object v1

    .line 955
    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->needClassReification()V

    new-instance v2, Lio/dcloud/uts/UTSJSONObject$parse$$inlined$parseType$default$1;

    invoke-direct {v2}, Lio/dcloud/uts/UTSJSONObject$parse$$inlined$parseType$default$1;-><init>()V

    invoke-virtual {v2}, Lio/dcloud/uts/UTSJSONObject$parse$$inlined$parseType$default$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lio/dcloud/uts/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    .line 959
    invoke-static {}, Lio/dcloud/uts/ObjectKt;->getGlobalError()Ljava/util/Map;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_0
    return-object v3
.end method

.method public resolveKeyPath(Ljava/lang/String;)Ljava/lang/Object;
    .locals 10

    const-string v0, "key"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 844
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "io.dcloud.uts.UTSJSONObject"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 846
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v0

    goto :goto_0

    .line 849
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object v0

    .line 853
    :goto_0
    move-object v1, v0

    check-cast v1, Ljava/util/AbstractMap;

    invoke-virtual {v1, p1}, Ljava/util/AbstractMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 857
    invoke-virtual {v1, p1}, Ljava/util/AbstractMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1

    .line 862
    :cond_1
    move-object v1, p1

    check-cast v1, Ljava/lang/CharSequence;

    const/4 p1, 0x1

    new-array v2, p1, [C

    const/16 v3, 0x2e

    const/4 v7, 0x0

    aput-char v3, v2, v7

    const/4 v5, 0x6

    const/4 v6, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {v1 .. v6}, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence;[CZIILjava/lang/Object;)Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x0

    .line 870
    :try_start_0
    check-cast v1, Ljava/lang/Iterable;

    .line 1070
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 872
    new-instance v4, Lkotlin/text/Regex;

    const-string v5, "(\\w+)((\\[\\d+])+)"

    invoke-direct {v4, v5}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    move-object v5, v3

    check-cast v5, Ljava/lang/CharSequence;

    const/4 v6, 0x2

    invoke-static {v4, v5, v7, v6, v2}, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex;Ljava/lang/CharSequence;IILjava/lang/Object;)Lkotlin/text/MatchResult;

    move-result-object v4

    if-eqz v4, :cond_6

    .line 877
    invoke-interface {v4}, Lkotlin/text/MatchResult;->getGroups()Lkotlin/text/MatchGroupCollection;

    move-result-object v4

    invoke-interface {v4, p1}, Lkotlin/text/MatchGroupCollection;->get(I)Lkotlin/text/MatchGroup;

    move-result-object v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 879
    const-string v5, ""

    if-eqz v4, :cond_3

    .line 880
    :try_start_1
    invoke-virtual {v4}, Lkotlin/text/MatchGroup;->getValue()Ljava/lang/String;

    move-result-object v8

    goto :goto_2

    :cond_3
    move-object v8, v5

    .line 883
    :goto_2
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    check-cast v9, Ljava/util/List;

    .line 885
    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v4}, Lkotlin/text/MatchGroup;->getRange()Lkotlin/ranges/IntRange;

    move-result-object v4

    invoke-virtual {v4}, Lkotlin/ranges/IntRange;->getLast()I

    move-result v4

    add-int/2addr v4, p1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-static {v3, v4, v2, v6, v2}, Lio/dcloud/uts/StringKt;->substring$default(Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 886
    const-string v4, "["

    invoke-static {v3, v4, v5}, Lio/dcloud/uts/StringKt;->replaceAll(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 887
    const-string v4, "]"

    invoke-static {v3, v4}, Lio/dcloud/uts/StringKt;->split(Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/uts/UTSArray;

    move-result-object v3

    check-cast v3, Ljava/lang/Iterable;

    .line 1071
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 888
    move-object v5, v4

    check-cast v5, Ljava/lang/CharSequence;

    invoke-interface {v5}, Ljava/lang/CharSequence;->length()I

    move-result v5

    if-lez v5, :cond_4

    .line 889
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 893
    :cond_5
    invoke-virtual {p0, v0, v8}, Lio/dcloud/uts/UTSJSONObject;->getCanInnerAttribute(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    .line 895
    check-cast v9, Ljava/lang/Iterable;

    .line 1073
    invoke-interface {v9}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {v0}, Ljava/lang/Number;->intValue()I

    move-result v0

    .line 896
    invoke-virtual {p0, v3, v0}, Lio/dcloud/uts/UTSJSONObject;->getCanInnerAttribute(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    goto :goto_4

    .line 908
    :cond_6
    invoke-virtual {p0, v0, v3}, Lio/dcloud/uts/UTSJSONObject;->getCanInnerAttribute(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    :cond_7
    return-object v0

    :catch_0
    return-object v2
.end method

.method public set(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2

    const-string v0, "name"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 339
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 341
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_0

    .line 342
    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v1

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v1}, Lcom/alibaba/fastjson/JSONArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 343
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    invoke-virtual {v0, p1, p2}, Lcom/alibaba/fastjson/JSONArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void

    .line 348
    :cond_1
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public set__$arrayContent(Lcom/alibaba/fastjson/JSONArray;)V
    .locals 0

    .line 162
    iput-object p1, p0, Lio/dcloud/uts/UTSJSONObject;->__$arrayContent:Lcom/alibaba/fastjson/JSONArray;

    return-void
.end method

.method public final set__$cacheCustomFieldMap(Lio/dcloud/uts/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .line 171
    iput-object p1, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    return-void
.end method

.method public final set__$hostSourceMap(Lio/dcloud/uts/UTSSourceMapPosition;)V
    .locals 0

    .line 150
    iput-object p1, p0, Lio/dcloud/uts/UTSJSONObject;->__$hostSourceMap:Lio/dcloud/uts/UTSSourceMapPosition;

    return-void
.end method

.method public toJSONObject()Lcom/alibaba/fastjson/JSON;
    .locals 5

    .line 525
    new-instance v0, Lcom/alibaba/fastjson/JSONObject;

    invoke-direct {v0}, Lcom/alibaba/fastjson/JSONObject;-><init>()V

    .line 526
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toMap()Lio/dcloud/uts/Map;

    move-result-object v1

    .line 527
    check-cast v1, Ljava/util/Map;

    .line 969
    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 528
    move-object v3, v0

    check-cast v3, Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-direct {p0, v2}, Lio/dcloud/uts/UTSJSONObject;->wrapArrayItem(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v3, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 530
    :cond_0
    check-cast v0, Lcom/alibaba/fastjson/JSON;

    return-object v0
.end method

.method public toJSONString()Ljava/lang/String;
    .locals 2

    .line 585
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->toJSONObject()Lcom/alibaba/fastjson/JSON;

    move-result-object v0

    invoke-virtual {v0}, Lcom/alibaba/fastjson/JSON;->toJSONString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "toJSONString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public toLogMap()Ljava/util/Map;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 381
    new-instance v0, Lio/dcloud/uts/Map;

    invoke-direct {v0}, Lio/dcloud/uts/Map;-><init>()V

    .line 382
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->get__$arrayContent()Lcom/alibaba/fastjson/JSONArray;

    move-result-object v1

    if-nez v1, :cond_5

    .line 385
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {v1}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v1

    invoke-static {v1}, Lkotlin/reflect/full/KClasses;->getMemberProperties(Lkotlin/reflect/KClass;)Ljava/util/Collection;

    move-result-object v1

    check-cast v1, Ljava/lang/Iterable;

    .line 963
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lkotlin/reflect/KProperty1;

    .line 387
    move-object v3, v2

    check-cast v3, Lkotlin/reflect/KCallable;

    const/4 v4, 0x1

    invoke-static {v3, v4}, Lkotlin/reflect/jvm/KCallablesJvm;->setAccessible(Lkotlin/reflect/KCallable;Z)V

    .line 388
    new-array v3, v4, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-interface {v2, v3}, Lkotlin/reflect/KProperty1;->call([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 390
    invoke-interface {v2}, Lkotlin/reflect/KProperty1;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "__$hostSourceMap"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 392
    instance-of v2, v3, Lio/dcloud/uts/UTSSourceMapPosition;

    if-eqz v2, :cond_0

    .line 393
    new-instance v2, Lio/dcloud/uts/gson/JsonObject;

    invoke-direct {v2}, Lio/dcloud/uts/gson/JsonObject;-><init>()V

    .line 394
    check-cast v3, Lio/dcloud/uts/UTSSourceMapPosition;

    invoke-virtual {v3}, Lio/dcloud/uts/UTSSourceMapPosition;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "name"

    invoke-virtual {v2, v5, v4}, Lio/dcloud/uts/gson/JsonObject;->addProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 395
    const-string v4, "file"

    invoke-virtual {v3}, Lio/dcloud/uts/UTSSourceMapPosition;->getFile()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lio/dcloud/uts/gson/JsonObject;->addProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 396
    invoke-virtual {v3}, Lio/dcloud/uts/UTSSourceMapPosition;->getColumn()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    const-string v5, "column"

    invoke-virtual {v2, v5, v4}, Lio/dcloud/uts/gson/JsonObject;->addProperty(Ljava/lang/String;Ljava/lang/Number;)V

    .line 397
    invoke-virtual {v3}, Lio/dcloud/uts/UTSSourceMapPosition;->getLine()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    const-string v4, "line"

    invoke-virtual {v2, v4, v3}, Lio/dcloud/uts/gson/JsonObject;->addProperty(Ljava/lang/String;Ljava/lang/Number;)V

    .line 398
    move-object v3, v0

    check-cast v3, Ljava/util/Map;

    const-string v4, "__$originalPosition"

    invoke-interface {v3, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 402
    :cond_1
    move-object v4, v2

    check-cast v4, Lkotlin/reflect/KAnnotatedElement;

    const-class v5, Lio/dcloud/uts/UTSJsonTransparent;

    invoke-static {v5}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v5

    invoke-static {v4, v5}, Lkotlin/reflect/full/KAnnotatedElements;->findAnnotations(Lkotlin/reflect/KAnnotatedElement;Lkotlin/reflect/KClass;)Ljava/util/List;

    move-result-object v4

    check-cast v4, Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    goto/16 :goto_0

    .line 406
    :cond_2
    invoke-interface {v2}, Lkotlin/reflect/KProperty1;->getReturnType()Lkotlin/reflect/KType;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "kotlin.Number"

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 408
    move-object v4, v0

    check-cast v4, Ljava/util/Map;

    invoke-interface {v2}, Lkotlin/reflect/KProperty1;->getName()Ljava/lang/String;

    move-result-object v2

    new-instance v6, Lio/dcloud/uts/android/UTSLogInfo;

    const-string v7, ""

    invoke-direct {v6, v3, v5, v7}, Lio/dcloud/uts/android/UTSLogInfo;-><init>(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 410
    :cond_3
    move-object v4, v0

    check-cast v4, Ljava/util/Map;

    invoke-interface {v2}, Lkotlin/reflect/KProperty1;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v4, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 417
    :cond_4
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 421
    move-object v4, v0

    check-cast v4, Ljava/util/Map;

    invoke-virtual {v3}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v4, v3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 425
    :cond_5
    check-cast v0, Ljava/util/Map;

    return-object v0
.end method

.method public toMap()Lio/dcloud/uts/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/dcloud/uts/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 358
    new-instance v0, Lio/dcloud/uts/Map;

    invoke-direct {v0}, Lio/dcloud/uts/Map;-><init>()V

    .line 360
    invoke-direct {p0}, Lio/dcloud/uts/UTSJSONObject;->initCacheField()V

    .line 361
    iget-object v1, p0, Lio/dcloud/uts/UTSJSONObject;->__$cacheCustomFieldMap:Lio/dcloud/uts/Map;

    if-eqz v1, :cond_0

    .line 362
    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    check-cast v1, Ljava/util/Map;

    invoke-virtual {v0, v1}, Lio/dcloud/uts/Map;->putAll(Ljava/util/Map;)V

    .line 368
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSJSONObject;->getDynamicJSONFields()Lio/dcloud/uts/gson/internal/LinkedTreeMap;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    invoke-virtual {v0, v1}, Lio/dcloud/uts/Map;->putAll(Ljava/util/Map;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .line 581
    const-string v0, "[object Object]"

    return-object v0
.end method
