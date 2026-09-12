.class public Lio/dcloud/feature/barcode2/BarcodeProxy;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/ISysEventListener;


# static fields
.field public static context:Landroid/content/Context; = null

.field public static save:Z = false


# instance fields
.field mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

.field public mId:Ljava/lang/String;

.field mIsRegisetedSysEvent:Z


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 5
    iput-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    const/4 v0, 0x0

    .line 6
    iput-boolean v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mIsRegisetedSysEvent:Z

    return-void
.end method


# virtual methods
.method public appendToFrameView(Lio/dcloud/common/adapter/ui/AdaFrameView;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0, p1}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->appendToFrameView(Lio/dcloud/common/adapter/ui/AdaFrameView;)V

    :cond_0
    return-void
.end method

.method execute(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 14

    move-object/from16 v0, p2

    move-object/from16 v7, p3

    .line 1
    const-string v2, "start"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    const-string/jumbo v3, "{code:%d,message:\'%s\'}"

    const/16 v4, 0x8

    .line 3
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v8, 0x1

    if-eqz v2, :cond_3

    .line 2
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    iget-object v0, v0, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->errorMsg:Ljava/lang/String;

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    iget-object v0, v0, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->errorMsg:Ljava/lang/String;

    new-array v2, v5, [Ljava/lang/Object;

    aput-object v4, v2, v6

    aput-object v0, v2, v8

    invoke-static {v3, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 4
    iget-object v2, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    sget v3, Lio/dcloud/common/util/JSUtil;->ERROR:I

    invoke-virtual {v2, v0, v3, v8, v8}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->runJsCallBack(Ljava/lang/String;IZZ)V

    return-void

    .line 8
    :cond_0
    aget-object v0, v7, v8

    invoke-static {v0}, Lio/dcloud/common/util/JSONUtil;->createJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 10
    const-string v2, "conserve"

    invoke-static {v0, v2}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v6, v6}, Lio/dcloud/common/util/PdrUtil;->parseBoolean(Ljava/lang/String;ZZ)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 12
    const-string v3, "filename"

    invoke-static {v0, v3}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "png"

    invoke-static {v3, v4}, Lio/dcloud/common/util/PdrUtil;->getDefaultPrivateDocPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 13
    iget-object v4, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v5

    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v5

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v7, v3}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->mFilename:Ljava/lang/String;

    .line 14
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Filename:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    iget-object v4, v4, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->mFilename:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;)V

    .line 16
    :cond_1
    iget-object v3, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    .line 17
    const-string/jumbo v4, "vibrate"

    invoke-static {v0, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v8, v6}, Lio/dcloud/common/util/PdrUtil;->parseBoolean(Ljava/lang/String;ZZ)Z

    move-result v4

    iput-boolean v4, v3, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->vibrate:Z

    .line 18
    iget-object v3, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    const-string v4, "sound"

    invoke-static {v0, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v4, "none"

    invoke-static {v0, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    xor-int/2addr v0, v8

    iput-boolean v0, v3, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->playBeep:Z

    move v6, v2

    .line 20
    :cond_2
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    iput-boolean v6, v0, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->mConserve:Z

    .line 21
    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->start()V

    return-void

    .line 23
    :cond_3
    const-string v2, "cancel"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 24
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->cancel_scan()V

    return-void

    .line 25
    :cond_4
    const-string v2, "setFlash"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 26
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    aget-object v2, v7, v8

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-virtual {v0, v2}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->setFlash(Z)V

    return-void

    .line 29
    :cond_5
    const-string v2, "Barcode"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    const/4 v9, 0x4

    const/4 v10, 0x0

    const/4 v11, 0x3

    if-eqz v2, :cond_a

    .line 30
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v2, "Barcode-Create"

    invoke-static {v0, v2}, Lio/dcloud/common/util/AppRuntime;->checkPrivacyComplianceAndPrompt(Landroid/content/Context;Ljava/lang/String;)V

    .line 31
    aget-object v3, v7, v6

    .line 32
    iget-boolean v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mIsRegisetedSysEvent:Z

    if-nez v0, :cond_6

    .line 33
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v0

    .line 34
    sget-object v2, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->onPause:Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    invoke-interface {v0, p0, v2}, Lio/dcloud/common/DHInterface/IApp;->registerSysEventListener(Lio/dcloud/common/DHInterface/ISysEventListener;Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;)V

    .line 35
    sget-object v2, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->onResume:Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    invoke-interface {v0, p0, v2}, Lio/dcloud/common/DHInterface/IApp;->registerSysEventListener(Lio/dcloud/common/DHInterface/ISysEventListener;Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;)V

    .line 36
    iput-boolean v8, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mIsRegisetedSysEvent:Z

    .line 40
    :cond_6
    aget-object v0, v7, v9

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 41
    aget-object v0, v7, v9

    invoke-static {v0}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    goto :goto_0

    :cond_7
    move-object v0, v10

    :goto_0
    const/4 v2, 0x5

    .line 44
    aget-object v4, v7, v2

    invoke-static {v4}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_8

    .line 45
    aget-object v2, v7, v2

    invoke-static {v2}, Lio/dcloud/common/util/JSONUtil;->createJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v10

    :cond_8
    move-object v6, v10

    .line 48
    aget-object v2, v7, v11

    invoke-static {v2}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 49
    aget-object v2, v7, v5

    iput-object v2, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mId:Ljava/lang/String;

    move-object v5, v0

    .line 50
    new-instance v0, Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;-><init>(Lio/dcloud/feature/barcode2/BarcodeProxy;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONObject;)V

    iput-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    .line 51
    aget-object v2, v7, v8

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getWebviewUUID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->addCallBackId(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    array-length v0, v7

    const/4 v2, 0x6

    if-le v0, v2, :cond_9

    .line 53
    aget-object v0, v7, v2

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 54
    iget-object v2, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    iput-boolean v0, v2, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->autoDecodeCharset:Z

    .line 56
    :cond_9
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-le v0, v11, :cond_12

    .line 57
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->toFrameView()V

    return-void

    .line 59
    :cond_a
    const-string v2, "scan"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 60
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v2

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "Barcode-"

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lio/dcloud/common/util/AppRuntime;->checkPrivacyComplianceAndPrompt(Landroid/content/Context;Ljava/lang/String;)V

    move-object v0, v3

    .line 61
    aget-object v3, v7, v6

    .line 62
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v2

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v2

    .line 63
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v12

    aget-object v13, v7, v8

    invoke-interface {v2, v12, v13}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 65
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v13

    invoke-static {v13}, Lio/dcloud/common/util/FileUtil;->needMediaStoreOpenFile(Landroid/content/Context;)Z

    move-result v13

    if-eqz v13, :cond_b

    .line 66
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-static {v2, v12}, Lio/dcloud/common/util/FileUtil;->getFileInputStream(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    if-eqz v2, :cond_c

    .line 68
    invoke-static {v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v10

    goto :goto_1

    .line 71
    :cond_b
    invoke-static {v12}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v10

    :cond_c
    :goto_1
    if-eqz v10, :cond_e

    .line 75
    array-length v2, v7

    if-le v2, v11, :cond_d

    .line 76
    aget-object v2, v7, v11

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    goto :goto_2

    :cond_d
    const/4 v2, 0x0

    .line 78
    :goto_2
    invoke-static {v10, v2}, Lio/dcloud/feature/barcode2/decoding/CaptureActivityHandler;->decode(Landroid/graphics/Bitmap;Z)Lcom/dcloud/zxing2/Result;

    move-result-object v2

    if-eqz v2, :cond_e

    .line 81
    invoke-virtual {v2}, Lcom/dcloud/zxing2/Result;->getBarcodeFormat()Lcom/dcloud/zxing2/BarcodeFormat;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->convertTypestrToNum(Lcom/dcloud/zxing2/BarcodeFormat;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2}, Lcom/dcloud/zxing2/Result;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lio/dcloud/common/util/JSONUtil;->toJSONableString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iget-object v2, v2, Lcom/dcloud/zxing2/Result;->textCharset:Ljava/lang/String;

    new-array v7, v9, [Ljava/lang/Object;

    aput-object v0, v7, v6

    aput-object v4, v7, v8

    aput-object v12, v7, v5

    aput-object v2, v7, v11

    const-string/jumbo v0, "{type:%d,message:%s,file:\'%s\',charSet:\'%s\'}"

    invoke-static {v0, v7}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 82
    sget v5, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v2, p1

    invoke-static/range {v2 .. v7}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-void

    .line 86
    :cond_e
    new-array v2, v5, [Ljava/lang/Object;

    aput-object v4, v2, v6

    const-string v4, ""

    aput-object v4, v2, v8

    invoke-static {v0, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    .line 87
    sget v5, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v2, p1

    invoke-static/range {v2 .. v7}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-void

    .line 88
    :cond_f
    const-string v2, "close"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 89
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->close_scan()V

    return-void

    .line 90
    :cond_10
    const-string v2, "setStyle"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_11

    .line 91
    aget-object v0, v7, v8

    invoke-static {v0}, Lio/dcloud/common/util/JSONUtil;->createJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_12

    .line 93
    iget-object v2, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    invoke-virtual {v2, v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->upateStyles(Lorg/json/JSONObject;)V

    return-void

    .line 95
    :cond_11
    const-string v2, "addCallBack"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 96
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    if-eqz v0, :cond_12

    .line 97
    aget-object v2, v7, v8

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getWebviewUUID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->addCallBackId(Ljava/lang/String;Ljava/lang/String;)V

    :cond_12
    return-void
.end method

.method public getJsBarcode()Lorg/json/JSONObject;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->getJsBarcode()Lorg/json/JSONObject;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onDestroy()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->onDestroy()V

    const/4 v0, 0x0

    .line 3
    iput-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    :cond_0
    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mIsRegisetedSysEvent:Z

    return-void
.end method

.method public onExecute(Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    sget-object p2, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->onResume:Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    if-ne p1, p2, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/feature/barcode2/BarcodeProxy;->onResume()V

    goto :goto_0

    .line 3
    :cond_0
    sget-object p2, Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;->onPause:Lio/dcloud/common/DHInterface/ISysEventListener$SysEventType;

    if-ne p1, p2, :cond_1

    .line 4
    invoke-virtual {p0}, Lio/dcloud/feature/barcode2/BarcodeProxy;->onPause()V

    :cond_1
    :goto_0
    const/4 p1, 0x0

    return p1
.end method

.method protected onPause()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->onPause()V

    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/BarcodeProxy;->mBarcodeView:Lio/dcloud/feature/barcode2/BarcodeFrameItem;

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 2
    invoke-virtual {v0, v1}, Lio/dcloud/feature/barcode2/BarcodeFrameItem;->onResume(Z)V

    :cond_0
    return-void
.end method
