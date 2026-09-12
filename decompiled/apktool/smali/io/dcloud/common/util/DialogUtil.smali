.class public Lio/dcloud/common/util/DialogUtil;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static initDialogTheme(Landroid/app/Activity;)Landroid/app/AlertDialog;
    .locals 3

    .line 15
    invoke-static {p0}, Lio/dcloud/common/util/PdrUtil;->isNavigationBarExist(Landroid/app/Activity;)Z

    move-result v0

    .line 17
    sget v1, Lio/dcloud/PdrR;->STREAMAPP_DELETE_THEME:I

    .line 18
    invoke-static {p0}, Lio/dcloud/common/util/AppRuntime;->getAppDarkMode(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 20
    sget v1, Lio/dcloud/PdrR;->STREAMAPP_DELETE_DARK_THEME:I

    const/16 v1, -0x3e7

    goto :goto_0

    :cond_0
    const/16 v1, -0x3e6

    .line 25
    :goto_0
    new-instance v2, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;

    invoke-direct {v2, p0, v1, v0}, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;-><init>(Landroid/content/Context;IZ)V

    return-object v2
.end method

.method public static initDialogTheme(Landroid/app/Activity;Z)Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;
    .locals 2

    .line 1
    invoke-static {p0}, Lio/dcloud/common/util/PdrUtil;->isNavigationBarExist(Landroid/app/Activity;)Z

    move-result v0

    .line 3
    sget v1, Lio/dcloud/PdrR;->STREAMAPP_DELETE_THEME:I

    .line 4
    invoke-static {p0}, Lio/dcloud/common/util/AppRuntime;->getAppDarkMode(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 6
    sget v1, Lio/dcloud/PdrR;->STREAMAPP_DELETE_DARK_THEME:I

    const/16 v1, -0x3e7

    goto :goto_0

    :cond_0
    const/16 v1, -0x3e6

    :goto_0
    if-eqz p1, :cond_1

    .line 10
    new-instance p1, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;

    invoke-direct {p1, p0, v1, v0}, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;-><init>(Landroid/content/Context;IZ)V

    return-object p1

    .line 14
    :cond_1
    new-instance p1, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;

    invoke-direct {p1, p0, v1, v0}, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;-><init>(Landroid/content/Context;IZ)V

    return-object p1
.end method

.method public static showAlertDialog(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnDismissListener;ZIII)V
    .locals 5

    if-nez p0, :cond_0

    return-void

    .line 1
    :cond_0
    invoke-static {p0}, Lio/dcloud/common/util/DialogUtil;->initDialogTheme(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 2
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object p0

    sget v1, Lio/dcloud/PdrR;->STREAMAPP_CUSTOM_ALERT_DIALOG_LAYOUT:I

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p0

    .line 3
    sget v1, Lio/dcloud/PdrR;->STREAMAPP_CUSTOM_ALERT_DIALOG_TITLE:I

    invoke-virtual {p0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 4
    sget v2, Lio/dcloud/PdrR;->STREAMAPP_CUSTOM_ALERT_DIALOG_SURE:I

    invoke-virtual {p0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 5
    sget v3, Lio/dcloud/PdrR;->STREAMAPP_CUSTOM_ALERT_DIALOG_CANCEL:I

    invoke-virtual {p0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 7
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 8
    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 9
    invoke-virtual {v1, p9}, Landroid/widget/TextView;->setGravity(I)V

    :cond_1
    if-nez p8, :cond_2

    .line 12
    sget p1, Lio/dcloud/PdrR;->STREAMAPP_CUSTOM_ALERT_DIALOG_CUSTOM_LAYOUT:I

    invoke-virtual {p0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const/16 v1, 0x8

    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    .line 14
    :cond_2
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_3

    .line 15
    invoke-virtual {v2, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 17
    :cond_3
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_4

    .line 18
    invoke-virtual {v3, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 20
    :cond_4
    new-instance p1, Lio/dcloud/common/util/DialogUtil$4;

    invoke-direct {p1, v0, p4}, Lio/dcloud/common/util/DialogUtil$4;-><init>(Landroid/app/Dialog;Landroid/view/View$OnClickListener;)V

    invoke-virtual {v2, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 30
    new-instance p1, Lio/dcloud/common/util/DialogUtil$5;

    invoke-direct {p1, v0, p5}, Lio/dcloud/common/util/DialogUtil$5;-><init>(Landroid/app/Dialog;Landroid/view/View$OnClickListener;)V

    invoke-virtual {v3, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    if-eqz p6, :cond_5

    .line 40
    invoke-virtual {v0, p6}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    :cond_5
    if-eqz p7, :cond_6

    .line 43
    invoke-virtual {v0, p7}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 45
    :cond_6
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 46
    invoke-virtual {v0, p0}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    .line 48
    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object p0

    .line 49
    invoke-virtual {p0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object p1

    const/4 p2, 0x0

    .line 50
    iput p2, p1, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 51
    iput p2, p1, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 52
    invoke-virtual {p0, p10}, Landroid/view/Window;->setGravity(I)V

    .line 53
    iget p1, p1, Landroid/view/WindowManager$LayoutParams;->height:I

    move/from16 p2, p11

    invoke-virtual {p0, p2, p1}, Landroid/view/Window;->setLayout(II)V

    return-void
.end method

.method public static showConfirm(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lio/dcloud/common/DHInterface/ICallBack;)V
    .locals 3

    .line 1
    invoke-static {p0}, Lio/dcloud/common/util/PdrUtil;->isNavigationBarExist(Landroid/app/Activity;)Z

    move-result v0

    .line 3
    invoke-static {p0}, Lio/dcloud/common/util/AppRuntime;->getAppDarkMode(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v1, -0x3e7

    goto :goto_0

    :cond_0
    const/16 v1, -0x3e6

    .line 6
    :goto_0
    new-instance v2, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;

    invoke-direct {v2, p0, v1, v0}, Lcom/dcloud/android/widget/dialog/DCloudAlertDialog;-><init>(Landroid/content/Context;IZ)V

    .line 8
    invoke-virtual {v2, p1}, Landroid/app/AlertDialog;->setTitle(Ljava/lang/CharSequence;)V

    const/4 p0, 0x0

    .line 9
    invoke-virtual {v2, p0}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 10
    invoke-virtual {v2, p2}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 11
    new-instance p1, Lio/dcloud/common/util/DialogUtil$1;

    invoke-direct {p1, v2, p4}, Lio/dcloud/common/util/DialogUtil$1;-><init>(Landroid/app/AlertDialog;Lio/dcloud/common/DHInterface/ICallBack;)V

    .line 24
    aget-object p0, p3, p0

    const/4 p2, -0x1

    invoke-virtual {v2, p2, p0, p1}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    const/4 p0, 0x1

    .line 25
    aget-object p0, p3, p0

    const/4 p2, -0x2

    invoke-virtual {v2, p2, p0, p1}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 27
    invoke-virtual {v2}, Landroid/app/Dialog;->show()V

    return-void
.end method

.method public static showDialog(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 2

    .line 1
    invoke-static {p0}, Lio/dcloud/common/util/DialogUtil;->initDialogTheme(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object p0

    const/4 v0, 0x0

    if-eqz p3, :cond_0

    .line 2
    aget-object v1, p3, v0

    invoke-static {v1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const v1, 0x104000a

    .line 3
    invoke-static {v1}, Lio/dcloud/common/adapter/util/AndroidResources;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, p3, v0

    .line 5
    :cond_0
    invoke-static {p1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 6
    invoke-virtual {p0, p1}, Landroid/app/AlertDialog;->setTitle(Ljava/lang/CharSequence;)V

    :cond_1
    const/4 p1, 0x1

    .line 8
    invoke-virtual {p0, p1}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 9
    invoke-virtual {p0, p2}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 10
    aget-object p1, p3, v0

    new-instance p2, Lio/dcloud/common/util/DialogUtil$2;

    invoke-direct {p2, p0}, Lio/dcloud/common/util/DialogUtil$2;-><init>(Landroid/app/AlertDialog;)V

    const/4 p3, -0x1

    invoke-virtual {p0, p3, p1, p2}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 16
    new-instance p1, Lio/dcloud/common/util/DialogUtil$3;

    invoke-direct {p1, p0}, Lio/dcloud/common/util/DialogUtil$3;-><init>(Landroid/app/AlertDialog;)V

    invoke-virtual {p0, p1}, Landroid/app/Dialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V

    .line 30
    invoke-virtual {p0}, Landroid/app/Dialog;->show()V

    return-void
.end method
