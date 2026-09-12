.class public Lio/dcloud/js/camera/CameraFeatureImpl;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/IFeature;


# instance fields
.field a:Lio/dcloud/common/DHInterface/AbsMgr;

.field private b:Z

.field private final c:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 3
    iput-object v0, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->a:Lio/dcloud/common/DHInterface/AbsMgr;

    const/4 v0, 0x0

    .line 4
    iput-boolean v0, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->b:Z

    .line 5
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->c:Ljava/util/List;

    return-void
.end method

.method static synthetic a(Lio/dcloud/js/camera/CameraFeatureImpl;)Ljava/util/List;
    .locals 0

    .line 3
    iget-object p0, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->c:Ljava/util/List;

    return-object p0
.end method

.method static synthetic a(Lio/dcloud/js/camera/CameraFeatureImpl;ZLjava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lio/dcloud/js/camera/CameraFeatureImpl;->a(ZLjava/lang/String;)V

    return-void
.end method

.method private a(ZLjava/lang/String;)V
    .locals 0

    if-eqz p1, :cond_0

    .line 4
    :try_start_0
    const-string p1, ".temp"

    invoke-virtual {p2, p1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_0

    .line 5
    new-instance p1, Ljava/io/File;

    invoke-direct {p1, p2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 6
    invoke-virtual {p1}, Ljava/io/File;->delete()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    :cond_0
    return-void
.end method

.method static synthetic a(Lio/dcloud/js/camera/CameraFeatureImpl;Z)Z
    .locals 0

    .line 2
    iput-boolean p1, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->b:Z

    return p1
.end method


# virtual methods
.method public dispose(Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public execute(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 13

    .line 1
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v1

    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v2

    .line 2
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Camera-"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lio/dcloud/common/util/AppRuntime;->checkPrivacyComplianceAndPrompt(Landroid/content/Context;Ljava/lang/String;)V

    const/4 v1, 0x0

    .line 3
    aget-object v4, p3, v1

    .line 5
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x18

    if-lt v1, v3, :cond_0

    .line 6
    new-instance v1, Landroid/os/StrictMode$VmPolicy$Builder;

    invoke-direct {v1}, Landroid/os/StrictMode$VmPolicy$Builder;-><init>()V

    .line 7
    invoke-virtual {v1}, Landroid/os/StrictMode$VmPolicy$Builder;->build()Landroid/os/StrictMode$VmPolicy;

    move-result-object v1

    invoke-static {v1}, Landroid/os/StrictMode;->setVmPolicy(Landroid/os/StrictMode$VmPolicy;)V

    .line 9
    :cond_0
    const-string v1, "captureImage"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const/4 v8, 0x2

    const-string v9, "camera"

    const-string v10, "android.permission.CAMERA"

    const-string v11, "CAMERA"

    const/4 v3, 0x1

    const/4 v12, 0x0

    if-eqz v1, :cond_4

    .line 10
    aget-object v0, p3, v3

    invoke-static {v0, v3}, Lio/dcloud/js/camera/a;->a(Ljava/lang/String;Z)Lio/dcloud/js/camera/a$a;

    move-result-object v6

    .line 11
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6}, Lio/dcloud/js/camera/a$a;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v0, v1}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 12
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v5}, Lio/dcloud/common/util/FileUtil;->checkPrivatePath(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {v5}, Lio/dcloud/common/util/FileUtil;->getPathForPublicType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    .line 13
    sget-object v0, Lio/dcloud/common/constant/DOMException;->MSG_PATH_NOT_PRIVATE_ERROR:Ljava/lang/String;

    const/4 v1, -0x5

    invoke-static {v1, v0}, Lio/dcloud/common/constant/DOMException;->toJSON(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 14
    sget v6, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v7, 0x1

    const/4 v8, 0x0

    move-object v3, p1

    invoke-static/range {v3 .. v8}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-object v12

    .line 17
    :cond_1
    new-instance v0, Lio/dcloud/js/camera/CameraFeatureImpl$a;

    move-object v7, v2

    move-object v1, p0

    move-object v3, p1

    invoke-direct/range {v0 .. v7}, Lio/dcloud/js/camera/CameraFeatureImpl$a;-><init>(Lio/dcloud/js/camera/CameraFeatureImpl;Lio/dcloud/common/DHInterface/IApp;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;Lio/dcloud/js/camera/a$a;Lio/dcloud/common/DHInterface/IApp;)V

    .line 189
    iget-boolean v3, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->b:Z

    if-eqz v3, :cond_2

    .line 190
    iget-object v2, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->c:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-object v12

    .line 191
    :cond_2
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-static {v3, v10}, Lio/dcloud/common/adapter/util/PermissionUtil;->checkSelfPermission(Landroid/app/Activity;Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_3

    .line 192
    invoke-virtual {v0, v11}, Lio/dcloud/common/adapter/util/PermissionUtil$Request;->onGranted(Ljava/lang/String;)V

    return-object v12

    .line 194
    :cond_3
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-static {v2, v9, v11, v8, v0}, Lio/dcloud/common/adapter/util/PermissionUtil;->usePermission(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILio/dcloud/common/adapter/util/PermissionUtil$Request;)V

    return-object v12

    .line 196
    :cond_4
    const-string v5, "startVideoCapture"

    invoke-virtual {p2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 197
    new-instance v0, Lio/dcloud/js/camera/CameraFeatureImpl$b;

    move-object v6, v4

    move-object v4, v2

    move-object v1, p0

    move-object v5, p1

    move-object/from16 v3, p3

    invoke-direct/range {v0 .. v6}, Lio/dcloud/js/camera/CameraFeatureImpl$b;-><init>(Lio/dcloud/js/camera/CameraFeatureImpl;Lio/dcloud/common/DHInterface/IApp;[Ljava/lang/String;Lio/dcloud/common/DHInterface/IApp;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 319
    iget-boolean v3, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->b:Z

    if-eqz v3, :cond_5

    .line 320
    iget-object v2, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->c:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-object v12

    .line 321
    :cond_5
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-static {v3, v10}, Lio/dcloud/common/adapter/util/PermissionUtil;->checkSelfPermission(Landroid/app/Activity;Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_6

    .line 322
    invoke-virtual {v0, v11}, Lio/dcloud/common/adapter/util/PermissionUtil$Request;->onGranted(Ljava/lang/String;)V

    return-object v12

    .line 324
    :cond_6
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-static {v2, v9, v11, v8, v0}, Lio/dcloud/common/adapter/util/PermissionUtil;->usePermission(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILio/dcloud/common/adapter/util/PermissionUtil$Request;)V

    return-object v12

    .line 326
    :cond_7
    const-string v4, "getCamera"

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 327
    aget-object v0, p3, v3

    invoke-static {v0, v3}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v0

    .line 328
    new-instance v4, Lio/dcloud/js/camera/a;

    invoke-direct {v4, v0}, Lio/dcloud/js/camera/a;-><init>(I)V

    .line 329
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0, v10}, Lio/dcloud/common/adapter/util/PermissionUtil;->checkSelfPermission(Landroid/app/Activity;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_8

    .line 330
    invoke-virtual {v4}, Lio/dcloud/js/camera/a;->b()V

    .line 331
    invoke-virtual {v4}, Lio/dcloud/js/camera/a;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 335
    :cond_8
    iget-boolean v0, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->b:Z

    if-eqz v0, :cond_9

    goto :goto_0

    .line 338
    :cond_9
    iput-boolean v3, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->b:Z

    .line 339
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IAppInfo;->getActivity()Landroid/app/Activity;

    move-result-object v6

    new-instance v0, Lio/dcloud/js/camera/CameraFeatureImpl$c;

    move-object v1, p0

    move-object v5, p1

    move-object v3, v4

    move-object/from16 v4, p3

    invoke-direct/range {v0 .. v5}, Lio/dcloud/js/camera/CameraFeatureImpl$c;-><init>(Lio/dcloud/js/camera/CameraFeatureImpl;Lio/dcloud/common/DHInterface/IApp;Lio/dcloud/js/camera/a;[Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;)V

    invoke-static {v6, v9, v11, v8, v0}, Lio/dcloud/common/adapter/util/PermissionUtil;->usePermission(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;ILio/dcloud/common/adapter/util/PermissionUtil$Request;)V

    :cond_a
    :goto_0
    return-object v12
.end method

.method public init(Lio/dcloud/common/DHInterface/AbsMgr;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/js/camera/CameraFeatureImpl;->a:Lio/dcloud/common/DHInterface/AbsMgr;

    return-void
.end method
