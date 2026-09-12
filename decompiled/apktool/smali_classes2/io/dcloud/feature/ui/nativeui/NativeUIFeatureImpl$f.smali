.class Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;
.super Landroid/app/DatePickerDialog;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONObject;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field a:I

.field b:I

.field c:I

.field final synthetic d:I

.field final synthetic e:I

.field final synthetic f:I

.field final synthetic g:Z

.field final synthetic h:Lio/dcloud/common/DHInterface/IWebview;

.field final synthetic i:Ljava/lang/String;

.field final synthetic j:Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;


# direct methods
.method constructor <init>(Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;Landroid/content/Context;ILandroid/app/DatePickerDialog$OnDateSetListener;IIIIIIZLio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->j:Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;

    iput p8, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->d:I

    iput p9, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->e:I

    iput p10, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->f:I

    iput-boolean p11, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->g:Z

    iput-object p12, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->h:Lio/dcloud/common/DHInterface/IWebview;

    iput-object p13, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->i:Ljava/lang/String;

    move-object p1, p0

    invoke-direct/range {p1 .. p7}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;ILandroid/app/DatePickerDialog$OnDateSetListener;III)V

    .line 12
    iput p8, p1, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->a:I

    iput p9, p1, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->b:I

    iput p10, p1, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->c:I

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 12

    .line 1
    invoke-super {p0, p1, p2}, Landroid/app/DatePickerDialog;->onClick(Landroid/content/DialogInterface;I)V

    const/4 p1, -0x2

    if-eq p2, p1, :cond_2

    const/4 p1, -0x1

    if-eq p2, p1, :cond_0

    goto :goto_1

    .line 4
    :cond_0
    new-instance v0, Ljava/util/GregorianCalendar;

    .line 5
    const-string p1, "GMT"

    invoke-static {p1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/util/GregorianCalendar;-><init>(Ljava/util/TimeZone;)V

    .line 6
    sget p1, Lio/dcloud/common/adapter/util/DeviceInfo;->sDeviceSdkVer:I

    const/16 p2, 0x15

    if-lt p1, p2, :cond_1

    .line 7
    iget-object p1, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->j:Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;

    iget v1, p1, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;->d:I

    iget v2, p1, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;->e:I

    iget v3, p1, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;->f:I

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v4, 0x0

    invoke-virtual/range {v0 .. v6}, Ljava/util/Calendar;->set(IIIIII)V

    goto :goto_0

    .line 9
    :cond_1
    iget v1, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->a:I

    iget v2, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->b:I

    iget v3, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->c:I

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v4, 0x0

    invoke-virtual/range {v0 .. v6}, Ljava/util/Calendar;->set(IIIIII)V

    .line 12
    :goto_0
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide p1

    .line 13
    iget-object v0, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->h:Lio/dcloud/common/DHInterface/IWebview;

    iget-object v1, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->i:Ljava/lang/String;

    .line 14
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    sget v3, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 15
    invoke-static/range {v0 .. v5}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    goto :goto_1

    .line 19
    :cond_2
    iget-object v6, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->h:Lio/dcloud/common/DHInterface/IWebview;

    iget-object v7, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->i:Ljava/lang/String;

    sget-object p2, Lio/dcloud/common/constant/DOMException;->MSG_USER_CANCEL:Ljava/lang/String;

    .line 20
    invoke-static {p1, p2}, Lio/dcloud/common/constant/DOMException;->toJSON(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v8

    sget v9, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 21
    invoke-static/range {v6 .. v11}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    .line 27
    :goto_1
    iget-object p1, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->j:Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;

    invoke-static {p1}, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;->a(Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl;)V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1

    .line 1
    invoke-super {p0, p1}, Landroid/app/DatePickerDialog;->onCreate(Landroid/os/Bundle;)V

    .line 3
    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object p1

    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Landroid/view/Window;->setSoftInputMode(I)V

    return-void
.end method

.method public onDateChanged(Landroid/widget/DatePicker;III)V
    .locals 2

    .line 1
    iput p2, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->a:I

    .line 2
    iput p3, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->b:I

    .line 3
    iput p4, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->c:I

    .line 4
    iget-boolean v0, p0, Lio/dcloud/feature/ui/nativeui/NativeUIFeatureImpl$f;->g:Z

    if-nez v0, :cond_0

    .line 5
    sget-object v0, Lio/dcloud/common/adapter/util/DeviceInfo;->sVersion_release:Ljava/lang/String;

    const-string v1, "4.0.3"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lio/dcloud/common/adapter/util/DeviceInfo;->sVersion_release:Ljava/lang/String;

    .line 6
    const-string v1, "4.0.4"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 9
    invoke-super {p0, p1, p2, p3, p4}, Landroid/app/DatePickerDialog;->onDateChanged(Landroid/widget/DatePicker;III)V

    :cond_0
    return-void
.end method
