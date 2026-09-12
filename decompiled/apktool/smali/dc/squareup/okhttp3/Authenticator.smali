.class public interface abstract Ldc/squareup/okhttp3/Authenticator;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field public static final NONE:Ldc/squareup/okhttp3/Authenticator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Ldc/squareup/okhttp3/Authenticator$1;

    invoke-direct {v0}, Ldc/squareup/okhttp3/Authenticator$1;-><init>()V

    sput-object v0, Ldc/squareup/okhttp3/Authenticator;->NONE:Ldc/squareup/okhttp3/Authenticator;

    return-void
.end method


# virtual methods
.method public abstract authenticate(Ldc/squareup/okhttp3/Route;Ldc/squareup/okhttp3/Response;)Ldc/squareup/okhttp3/Request;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
