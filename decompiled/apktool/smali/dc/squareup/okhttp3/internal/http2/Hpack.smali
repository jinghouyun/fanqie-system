.class final Ldc/squareup/okhttp3/internal/http2/Hpack;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ldc/squareup/okhttp3/internal/http2/Hpack$Writer;,
        Ldc/squareup/okhttp3/internal/http2/Hpack$Reader;
    }
.end annotation


# static fields
.field static final NAME_TO_FIRST_INDEX:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ldc/squareup/okio/ByteString;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final PREFIX_4_BITS:I = 0xf

.field private static final PREFIX_5_BITS:I = 0x1f

.field private static final PREFIX_6_BITS:I = 0x3f

.field private static final PREFIX_7_BITS:I = 0x7f

.field static final STATIC_HEADER_TABLE:[Ldc/squareup/okhttp3/internal/http2/Header;


# direct methods
.method static constructor <clinit>()V
    .locals 63

    .line 1
    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    sget-object v1, Ldc/squareup/okhttp3/internal/http2/Header;->TARGET_AUTHORITY:Ldc/squareup/okio/ByteString;

    const-string v2, ""

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    sget-object v3, Ldc/squareup/okhttp3/internal/http2/Header;->TARGET_METHOD:Ldc/squareup/okio/ByteString;

    const-string v4, "GET"

    invoke-direct {v1, v3, v4}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v4, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v5, "POST"

    invoke-direct {v4, v3, v5}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v3, Ldc/squareup/okhttp3/internal/http2/Header;

    sget-object v5, Ldc/squareup/okhttp3/internal/http2/Header;->TARGET_PATH:Ldc/squareup/okio/ByteString;

    const-string v6, "/"

    invoke-direct {v3, v5, v6}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v6, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v7, "/index.html"

    invoke-direct {v6, v5, v7}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v5, Ldc/squareup/okhttp3/internal/http2/Header;

    sget-object v7, Ldc/squareup/okhttp3/internal/http2/Header;->TARGET_SCHEME:Ldc/squareup/okio/ByteString;

    const-string v8, "http"

    invoke-direct {v5, v7, v8}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v8, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v9, "https"

    invoke-direct {v8, v7, v9}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v7, Ldc/squareup/okhttp3/internal/http2/Header;

    sget-object v9, Ldc/squareup/okhttp3/internal/http2/Header;->RESPONSE_STATUS:Ldc/squareup/okio/ByteString;

    const-string v10, "200"

    invoke-direct {v7, v9, v10}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v10, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v11, "204"

    invoke-direct {v10, v9, v11}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v11, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v12, "206"

    invoke-direct {v11, v9, v12}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v12, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v13, "304"

    invoke-direct {v12, v9, v13}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v13, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v14, "400"

    invoke-direct {v13, v9, v14}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v14, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v15, "404"

    invoke-direct {v14, v9, v15}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v15, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v16, v0

    const-string v0, "500"

    invoke-direct {v15, v9, v0}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ldc/squareup/okio/ByteString;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v9, "accept-charset"

    invoke-direct {v0, v9, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v9, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v17, v0

    const-string v0, "accept-encoding"

    move-object/from16 v18, v1

    const-string v1, "gzip, deflate"

    invoke-direct {v9, v0, v1}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    const-string v1, "accept-language"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v19, v0

    const-string v0, "accept-ranges"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v20, v1

    const-string v1, "accept"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v21, v0

    const-string v0, "access-control-allow-origin"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v22, v1

    const-string v1, "age"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v23, v0

    const-string v0, "allow"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v24, v1

    const-string v1, "authorization"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v25, v0

    const-string v0, "cache-control"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v26, v1

    const-string v1, "content-disposition"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v27, v0

    const-string v0, "content-encoding"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v28, v1

    const-string v1, "content-language"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v29, v0

    const-string v0, "content-length"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v30, v1

    const-string v1, "content-location"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v31, v0

    const-string v0, "content-range"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v32, v1

    const-string v1, "content-type"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v33, v0

    const-string v0, "cookie"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v34, v1

    const-string v1, "date"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v35, v0

    const-string v0, "etag"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v36, v1

    const-string v1, "expect"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v37, v0

    const-string v0, "expires"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v38, v1

    const-string v1, "from"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v39, v0

    const-string v0, "host"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v40, v1

    const-string v1, "if-match"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v41, v0

    const-string v0, "if-modified-since"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v42, v1

    const-string v1, "if-none-match"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v43, v0

    const-string v0, "if-range"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v44, v1

    const-string v1, "if-unmodified-since"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v45, v0

    const-string v0, "last-modified"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v46, v1

    const-string v1, "link"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v47, v0

    const-string v0, "location"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v48, v1

    const-string v1, "max-forwards"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v49, v0

    const-string v0, "proxy-authenticate"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v50, v1

    const-string v1, "proxy-authorization"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v51, v0

    const-string v0, "range"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v52, v1

    const-string v1, "referer"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v53, v0

    const-string v0, "refresh"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v54, v1

    const-string v1, "retry-after"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v55, v0

    const-string v0, "server"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v56, v1

    const-string v1, "set-cookie"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v57, v0

    const-string/jumbo v0, "strict-transport-security"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v58, v1

    const-string/jumbo v1, "transfer-encoding"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v59, v0

    const-string/jumbo v0, "user-agent"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v60, v1

    const-string/jumbo v1, "vary"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v61, v0

    const-string/jumbo v0, "via"

    invoke-direct {v1, v0, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ldc/squareup/okhttp3/internal/http2/Header;

    move-object/from16 v62, v1

    const-string/jumbo v1, "www-authenticate"

    invoke-direct {v0, v1, v2}, Ldc/squareup/okhttp3/internal/http2/Header;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v1, 0x3d

    new-array v1, v1, [Ldc/squareup/okhttp3/internal/http2/Header;

    const/4 v2, 0x0

    aput-object v16, v1, v2

    const/4 v2, 0x1

    aput-object v18, v1, v2

    const/4 v2, 0x2

    aput-object v4, v1, v2

    const/4 v2, 0x3

    aput-object v3, v1, v2

    const/4 v2, 0x4

    aput-object v6, v1, v2

    const/4 v2, 0x5

    aput-object v5, v1, v2

    const/4 v2, 0x6

    aput-object v8, v1, v2

    const/4 v2, 0x7

    aput-object v7, v1, v2

    const/16 v2, 0x8

    aput-object v10, v1, v2

    const/16 v2, 0x9

    aput-object v11, v1, v2

    const/16 v2, 0xa

    aput-object v12, v1, v2

    const/16 v2, 0xb

    aput-object v13, v1, v2

    const/16 v2, 0xc

    aput-object v14, v1, v2

    const/16 v2, 0xd

    aput-object v15, v1, v2

    const/16 v2, 0xe

    aput-object v17, v1, v2

    const/16 v2, 0xf

    aput-object v9, v1, v2

    const/16 v2, 0x10

    aput-object v19, v1, v2

    const/16 v2, 0x11

    aput-object v20, v1, v2

    const/16 v2, 0x12

    aput-object v21, v1, v2

    const/16 v2, 0x13

    aput-object v22, v1, v2

    const/16 v2, 0x14

    aput-object v23, v1, v2

    const/16 v2, 0x15

    aput-object v24, v1, v2

    const/16 v2, 0x16

    aput-object v25, v1, v2

    const/16 v2, 0x17

    aput-object v26, v1, v2

    const/16 v2, 0x18

    aput-object v27, v1, v2

    const/16 v2, 0x19

    aput-object v28, v1, v2

    const/16 v2, 0x1a

    aput-object v29, v1, v2

    const/16 v2, 0x1b

    aput-object v30, v1, v2

    const/16 v2, 0x1c

    aput-object v31, v1, v2

    const/16 v2, 0x1d

    aput-object v32, v1, v2

    const/16 v2, 0x1e

    aput-object v33, v1, v2

    const/16 v2, 0x1f

    aput-object v34, v1, v2

    const/16 v2, 0x20

    aput-object v35, v1, v2

    const/16 v2, 0x21

    aput-object v36, v1, v2

    const/16 v2, 0x22

    aput-object v37, v1, v2

    const/16 v2, 0x23

    aput-object v38, v1, v2

    const/16 v2, 0x24

    aput-object v39, v1, v2

    const/16 v2, 0x25

    aput-object v40, v1, v2

    const/16 v2, 0x26

    aput-object v41, v1, v2

    const/16 v2, 0x27

    aput-object v42, v1, v2

    const/16 v2, 0x28

    aput-object v43, v1, v2

    const/16 v2, 0x29

    aput-object v44, v1, v2

    const/16 v2, 0x2a

    aput-object v45, v1, v2

    const/16 v2, 0x2b

    aput-object v46, v1, v2

    const/16 v2, 0x2c

    aput-object v47, v1, v2

    const/16 v2, 0x2d

    aput-object v48, v1, v2

    const/16 v2, 0x2e

    aput-object v49, v1, v2

    const/16 v2, 0x2f

    aput-object v50, v1, v2

    const/16 v2, 0x30

    aput-object v51, v1, v2

    const/16 v2, 0x31

    aput-object v52, v1, v2

    const/16 v2, 0x32

    aput-object v53, v1, v2

    const/16 v2, 0x33

    aput-object v54, v1, v2

    const/16 v2, 0x34

    aput-object v55, v1, v2

    const/16 v2, 0x35

    aput-object v56, v1, v2

    const/16 v2, 0x36

    aput-object v57, v1, v2

    const/16 v2, 0x37

    aput-object v58, v1, v2

    const/16 v2, 0x38

    aput-object v59, v1, v2

    const/16 v2, 0x39

    aput-object v60, v1, v2

    const/16 v2, 0x3a

    aput-object v61, v1, v2

    const/16 v2, 0x3b

    aput-object v62, v1, v2

    const/16 v2, 0x3c

    aput-object v0, v1, v2

    sput-object v1, Ldc/squareup/okhttp3/internal/http2/Hpack;->STATIC_HEADER_TABLE:[Ldc/squareup/okhttp3/internal/http2/Header;

    .line 308
    invoke-static {}, Ldc/squareup/okhttp3/internal/http2/Hpack;->nameToFirstIndex()Ljava/util/Map;

    move-result-object v0

    sput-object v0, Ldc/squareup/okhttp3/internal/http2/Hpack;->NAME_TO_FIRST_INDEX:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static checkLowercase(Ldc/squareup/okio/ByteString;)Ldc/squareup/okio/ByteString;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1
    invoke-virtual {p0}, Ldc/squareup/okio/ByteString;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_2

    .line 2
    invoke-virtual {p0, v1}, Ldc/squareup/okio/ByteString;->getByte(I)B

    move-result v2

    const/16 v3, 0x41

    if-lt v2, v3, :cond_1

    const/16 v3, 0x5a

    if-le v2, v3, :cond_0

    goto :goto_1

    .line 4
    :cond_0
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PROTOCOL_ERROR response malformed: mixed case name: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ldc/squareup/okio/ByteString;->utf8()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_2
    return-object p0
.end method

.method private static nameToFirstIndex()Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ldc/squareup/okio/ByteString;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 1
    new-instance v0, Ljava/util/LinkedHashMap;

    sget-object v1, Ldc/squareup/okhttp3/internal/http2/Hpack;->STATIC_HEADER_TABLE:[Ldc/squareup/okhttp3/internal/http2/Header;

    array-length v1, v1

    invoke-direct {v0, v1}, Ljava/util/LinkedHashMap;-><init>(I)V

    const/4 v1, 0x0

    .line 2
    :goto_0
    sget-object v2, Ldc/squareup/okhttp3/internal/http2/Hpack;->STATIC_HEADER_TABLE:[Ldc/squareup/okhttp3/internal/http2/Header;

    array-length v3, v2

    if-ge v1, v3, :cond_1

    .line 3
    aget-object v3, v2, v1

    iget-object v3, v3, Ldc/squareup/okhttp3/internal/http2/Header;->name:Ldc/squareup/okio/ByteString;

    invoke-interface {v0, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 4
    aget-object v2, v2, v1

    iget-object v2, v2, Ldc/squareup/okhttp3/internal/http2/Header;->name:Ldc/squareup/okio/ByteString;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 7
    :cond_1
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method
