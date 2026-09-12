.class public Lio/dcloud/glide/DCloudGlideModule;
.super Lcom/bumptech/glide/module/AppGlideModule;
.source "DCloudGlideModule.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Lcom/bumptech/glide/module/AppGlideModule;-><init>()V

    return-void
.end method


# virtual methods
.method public registerComponents(Landroid/content/Context;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/Registry;)V
    .locals 0

    .line 22
    invoke-virtual {p3}, Lcom/bumptech/glide/Registry;->getImageHeaderParsers()Ljava/util/List;

    move-result-object p1

    .line 25
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    .line 26
    :cond_0
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_1

    .line 27
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/bumptech/glide/load/ImageHeaderParser;

    .line 29
    instance-of p2, p2, Lcom/bumptech/glide/load/resource/bitmap/ExifInterfaceImageHeaderParser;

    if-eqz p2, :cond_0

    .line 30
    invoke-interface {p1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 34
    :cond_1
    new-instance p1, Lio/dcloud/glide/PrivacyAwareExifInterfaceImageHeaderParser;

    invoke-direct {p1}, Lio/dcloud/glide/PrivacyAwareExifInterfaceImageHeaderParser;-><init>()V

    invoke-virtual {p3, p1}, Lcom/bumptech/glide/Registry;->register(Lcom/bumptech/glide/load/ImageHeaderParser;)Lcom/bumptech/glide/Registry;

    return-void
.end method
