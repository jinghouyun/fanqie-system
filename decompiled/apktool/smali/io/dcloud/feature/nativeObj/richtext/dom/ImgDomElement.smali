.class public Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;
.super Lio/dcloud/feature/nativeObj/richtext/dom/DomElement;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;
    }
.end annotation


# instance fields
.field public height:Ljava/lang/String;

.field public href:Ljava/lang/String;

.field mAsycLoader:Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;

.field public src:Ljava/lang/String;

.field public width:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/dcloud/feature/nativeObj/richtext/dom/DomElement;-><init>()V

    return-void
.end method


# virtual methods
.method public getSrc()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->src:Ljava/lang/String;

    return-object v0
.end method

.method public makeSpan(Lio/dcloud/feature/nativeObj/richtext/IAssets;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;)V
    .locals 13

    move-object/from16 v2, p3

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/DomElement;->style:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 2
    const-string/jumbo v1, "width"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3
    iget-object v1, p0, Lio/dcloud/feature/nativeObj/richtext/dom/DomElement;->style:Ljava/util/HashMap;

    const-string v3, "height"

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    move-object v1, v0

    .line 5
    :goto_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v1, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->height:Ljava/lang/String;

    .line 6
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->width:Ljava/lang/String;

    :cond_2
    const/high16 v3, -0x40000000    # -2.0f

    .line 7
    invoke-interface {p1, v0, v3}, Lio/dcloud/feature/nativeObj/richtext/IAssets;->convertWidth(Ljava/lang/String;F)F

    move-result v0

    float-to-int v5, v0

    .line 8
    invoke-interface {p1, v1, v3}, Lio/dcloud/feature/nativeObj/richtext/IAssets;->convertHeight(Ljava/lang/String;F)F

    move-result v0

    float-to-int v6, v0

    .line 10
    iget-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->src:Ljava/lang/String;

    invoke-static {v0}, Landroid/webkit/URLUtil;->isNetworkUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 12
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x10800a9

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    move-object v8, v1

    goto :goto_1

    .line 14
    :cond_3
    iget-object v1, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->src:Ljava/lang/String;

    invoke-interface {p1, v1}, Lio/dcloud/feature/nativeObj/richtext/IAssets;->convert2InputStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 15
    invoke-static {v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 16
    new-instance v3, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v3, v1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    move-object v8, v3

    :goto_1
    if-lez v5, :cond_4

    move v1, v5

    goto :goto_2

    .line 20
    :cond_4
    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    :goto_2
    if-lez v6, :cond_5

    move v3, v6

    goto :goto_3

    :cond_5
    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    :goto_3
    const/4 v4, 0x0

    invoke-virtual {v8, v4, v4, v1, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 22
    new-instance v3, Lio/dcloud/feature/nativeObj/richtext/span/ImgSpan;

    iget-object v9, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->src:Ljava/lang/String;

    iget-object v11, p0, Lio/dcloud/feature/nativeObj/richtext/dom/DomElement;->onClickEvent:Ljava/lang/String;

    iget-object v12, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->href:Ljava/lang/String;

    const/4 v10, 0x0

    move-object v7, v3

    invoke-direct/range {v7 .. v12}, Lio/dcloud/feature/nativeObj/richtext/span/ImgSpan;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    .line 23
    const-string/jumbo v1, "\ufffc"

    invoke-virtual {v2, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 24
    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    const/16 v7, 0x11

    invoke-virtual {v2, v3, v1, v4, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    if-eqz v0, :cond_6

    .line 26
    new-instance v0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;

    iget-object v4, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->src:Ljava/lang/String;

    iget-object v7, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->href:Ljava/lang/String;

    move-object v1, p2

    invoke-direct/range {v0 .. v7}, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;-><init>(Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;Lio/dcloud/feature/nativeObj/richtext/span/ImgSpan;Ljava/lang/String;IILjava/lang/String;)V

    invoke-interface {p1, v0}, Lio/dcloud/feature/nativeObj/richtext/IAssets;->loadResource(Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;)V

    :cond_6
    return-void
.end method

.method public parseDomElement(Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 2

    .line 1
    invoke-super {p0, p1}, Lio/dcloud/feature/nativeObj/richtext/dom/DomElement;->parseDomElement(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 2
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v0

    const-string v1, "src"

    invoke-interface {p1, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->src:Ljava/lang/String;

    .line 3
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "width"

    invoke-interface {p1, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->width:Ljava/lang/String;

    .line 4
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v0

    const-string v1, "height"

    invoke-interface {p1, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->height:Ljava/lang/String;

    .line 5
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getNamespace()Ljava/lang/String;

    move-result-object v0

    const-string v1, "href"

    invoke-interface {p1, v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement;->href:Ljava/lang/String;

    return-void
.end method
