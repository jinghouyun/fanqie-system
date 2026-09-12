.class public Lcom/dmcbig/mediapicker/PreviewActivity;
.super Landroidx/fragment/app/FragmentActivity;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/dmcbig/mediapicker/PreviewActivity$AdapterFragment;
    }
.end annotation


# instance fields
.field bar_title:Landroid/widget/TextView;

.field bottom:Landroid/view/View;

.field check_image:Landroid/widget/ImageView;

.field check_layout:Landroid/widget/LinearLayout;

.field done:Landroid/widget/Button;

.field doneBtnText:Ljava/lang/String;

.field private editActivityClass:Ljava/lang/Class;

.field private editable:Z

.field fragmentArrayList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/fragment/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field fullImage:Landroid/widget/ImageView;

.field imageEdit:Landroid/widget/TextView;

.field isSingle:Z

.field private max:I

.field preRawList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/dmcbig/mediapicker/entity/Media;",
            ">;"
        }
    .end annotation
.end field

.field selects:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/dmcbig/mediapicker/entity/Media;",
            ">;"
        }
    .end annotation
.end field

.field top:Landroid/view/View;

.field viewpager:Landroidx/viewpager/widget/ViewPager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroidx/fragment/app/FragmentActivity;-><init>()V

    const/4 v0, 0x0

    .line 11
    iput-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->isSingle:Z

    const/4 v0, 0x1

    .line 14
    iput-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editable:Z

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    return-void
.end method

.method private setTopAndBottomBarColor()V
    .locals 3

    .line 2
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/high16 v1, -0x80000000

    .line 3
    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 4
    const-string v1, "#21282C"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/view/Window;->setStatusBarColor(I)V

    .line 5
    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/Window;->setNavigationBarColor(I)V

    return-void
.end method


# virtual methods
.method public done(Ljava/util/ArrayList;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Lcom/dmcbig/mediapicker/entity/Media;",
            ">;I)V"
        }
    .end annotation

    .line 1
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 2
    const-string v1, "select_result"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 3
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object p1

    const-string v1, "original_preview_index"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getIntegerArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object p1

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putIntegerArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 4
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    const-string v1, "edited_preview_data"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 5
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fullImage:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/view/View;->isSelected()Z

    move-result p1

    const-string v1, "FULL_IMAGE"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 6
    invoke-virtual {p0, p2, v0}, Landroid/app/Activity;->setResult(ILandroid/content/Intent;)V

    .line 7
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    return-void
.end method

.method public fitAndroid16WindowInsets(Landroid/app/Activity;Landroid/view/View;I)V
    .locals 1

    .line 1
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x24

    if-lt p1, v0, :cond_0

    sget p1, Lio/dcloud/common/adapter/util/AndroidResources;->sAppTargetSdkVersion:I

    if-lt p1, v0, :cond_0

    .line 2
    new-instance p1, Lcom/dmcbig/mediapicker/PreviewActivity$$ExternalSyntheticLambda0;

    invoke-direct {p1, p0, p3}, Lcom/dmcbig/mediapicker/PreviewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/dmcbig/mediapicker/PreviewActivity;I)V

    invoke-static {p2, p1}, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    :cond_0
    return-void
.end method

.method public isSelect(Lcom/dmcbig/mediapicker/entity/Media;Ljava/util/ArrayList;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/dmcbig/mediapicker/entity/Media;",
            "Ljava/util/ArrayList<",
            "Lcom/dmcbig/mediapicker/entity/Media;",
            ">;)I"
        }
    .end annotation

    .line 1
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_0

    goto :goto_1

    :cond_0
    const/4 v0, 0x0

    .line 4
    :goto_0
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 5
    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/dmcbig/mediapicker/entity/Media;

    .line 6
    iget-object v1, v1, Lcom/dmcbig/mediapicker/entity/Media;->path:Ljava/lang/String;

    iget-object v2, p1, Lcom/dmcbig/mediapicker/entity/Media;->path:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    return v0

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    :goto_1
    const/4 p1, -0x1

    return p1
.end method

.method synthetic lambda$fitAndroid16WindowInsets$0$com-dmcbig-mediapicker-PreviewActivity(ILandroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 3

    .line 0
    if-eqz p3, :cond_2

    .line 1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x3

    const/4 v2, 0x0

    if-eq v0, v1, :cond_1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    goto :goto_0

    .line 5
    :cond_0
    invoke-virtual {p3, p1}, Landroidx/core/view/WindowInsetsCompat;->getInsets(I)Landroidx/core/graphics/Insets;

    move-result-object p1

    .line 6
    iget v0, p1, Landroidx/core/graphics/Insets;->left:I

    iget p1, p1, Landroidx/core/graphics/Insets;->right:I

    invoke-virtual {p2, v0, v2, p1, v2}, Landroid/view/View;->setPadding(IIII)V

    return-object p3

    .line 7
    :cond_1
    :goto_0
    invoke-virtual {p2, v2, v2, v2, v2}, Landroid/view/View;->setPadding(IIII)V

    :cond_2
    return-object p3
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 11

    .line 1
    invoke-super {p0, p1, p2, p3}, Landroidx/fragment/app/FragmentActivity;->onActivityResult(IILandroid/content/Intent;)V

    const/4 v0, -0x1

    if-ne p2, v0, :cond_2

    if-nez p1, :cond_2

    if-eqz p3, :cond_2

    .line 5
    const-string p1, "IMAGE_INDEX"

    invoke-virtual {p3, p1, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p1

    .line 6
    const-string p2, "_id"

    invoke-virtual {p3, p2, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v9

    if-eq v9, v0, :cond_2

    if-ne p1, v0, :cond_0

    goto :goto_0

    .line 9
    :cond_0
    const-string p2, "PATH"

    invoke-virtual {p3, p2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 10
    const-string p2, "_display_name"

    invoke-virtual {p3, p2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 11
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-string p2, "date_added"

    invoke-virtual {p3, p2, v0, v1}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v4

    .line 12
    const-string p2, "mime_type"

    const/4 v0, 0x0

    invoke-virtual {p3, p2, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v6

    .line 13
    const-string p2, "_size"

    const-wide/16 v0, 0x0

    invoke-virtual {p3, p2, v0, v1}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v7

    .line 14
    const-string p2, "PARENTPATH"

    invoke-virtual {p3, p2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 15
    new-instance v1, Lcom/dmcbig/mediapicker/entity/Media;

    invoke-direct/range {v1 .. v10}, Lcom/dmcbig/mediapicker/entity/Media;-><init>(Ljava/lang/String;Ljava/lang/String;JIJILjava/lang/String;)V

    .line 16
    iget-object p2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {p2, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/dmcbig/mediapicker/entity/Media;

    .line 17
    iget-object p3, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {p0, p2, p3}, Lcom/dmcbig/mediapicker/PreviewActivity;->isSelect(Lcom/dmcbig/mediapicker/entity/Media;Ljava/util/ArrayList;)I

    move-result p2

    if-ltz p2, :cond_1

    .line 19
    iget-object p3, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {p3, p2, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 21
    :cond_1
    iget-object p2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {p2, p1, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 22
    iget-object p2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fragmentArrayList:Ljava/util/ArrayList;

    const-string p3, ""

    invoke-static {v1, p3}, Lcom/dmcbig/mediapicker/view/PreviewFragment;->newInstance(Lcom/dmcbig/mediapicker/entity/Media;Ljava/lang/String;)Lcom/dmcbig/mediapicker/view/PreviewFragment;

    move-result-object p3

    invoke-virtual {p2, p1, p3}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 23
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->viewpager:Landroidx/viewpager/widget/ViewPager;

    invoke-virtual {p1}, Landroidx/viewpager/widget/ViewPager;->getAdapter()Landroidx/viewpager/widget/PagerAdapter;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/viewpager/widget/PagerAdapter;->notifyDataSetChanged()V

    :cond_2
    :goto_0
    return-void
.end method

.method public onBackPressed()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    const/16 v1, 0x7c6

    invoke-virtual {p0, v0, v1}, Lcom/dmcbig/mediapicker/PreviewActivity;->done(Ljava/util/ArrayList;I)V

    .line 2
    invoke-super {p0}, Landroidx/fragment/app/FragmentActivity;->onBackPressed()V

    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4

    .line 1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result p1

    .line 2
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_BTN_BACK:I

    if-ne p1, v0, :cond_0

    .line 3
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    const/16 v0, 0x7c6

    invoke-virtual {p0, p1, v0}, Lcom/dmcbig/mediapicker/PreviewActivity;->done(Ljava/util/ArrayList;I)V

    return-void

    .line 4
    :cond_0
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_DONE:I

    if-ne p1, v0, :cond_1

    .line 5
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    const v0, 0x12faa62

    invoke-virtual {p0, p1, v0}, Lcom/dmcbig/mediapicker/PreviewActivity;->done(Ljava/util/ArrayList;I)V

    return-void

    .line 6
    :cond_1
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_CHECK_LAYOUT:I

    if-ne p1, v0, :cond_3

    .line 7
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->viewpager:Landroidx/viewpager/widget/ViewPager;

    invoke-virtual {v0}, Landroidx/viewpager/widget/ViewPager;->getCurrentItem()I

    move-result v0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/dmcbig/mediapicker/entity/Media;

    .line 8
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {p0, p1, v0}, Lcom/dmcbig/mediapicker/PreviewActivity;->isSelect(Lcom/dmcbig/mediapicker/entity/Media;Ljava/util/ArrayList;)I

    move-result v0

    if-gez v0, :cond_2

    .line 10
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->check_image:Landroid/widget/ImageView;

    sget v1, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_DRAWABLE_BNT_SELECTED:I

    invoke-static {p0, v1}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 11
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 13
    :cond_2
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->check_image:Landroid/widget/ImageView;

    sget v1, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_DRAWABLE_BNT_UNSELECTED:I

    invoke-static {p0, v1}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 14
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 16
    :goto_0
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/dmcbig/mediapicker/PreviewActivity;->setDoneView(I)V

    return-void

    .line 17
    :cond_3
    sget v0, Lio/dcloud/base/R$id;->gallery_preview_edit:I

    if-ne p1, v0, :cond_4

    .line 19
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->viewpager:Landroidx/viewpager/widget/ViewPager;

    invoke-virtual {p1}, Landroidx/viewpager/widget/ViewPager;->getCurrentItem()I

    move-result p1

    .line 20
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/dmcbig/mediapicker/entity/Media;

    .line 21
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editActivityClass:Ljava/lang/Class;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 22
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v0, Lcom/dmcbig/mediapicker/entity/Media;->path:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 23
    const-string v3, "IMAGE_URI"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 24
    iget v0, v0, Lcom/dmcbig/mediapicker/entity/Media;->id:I

    const-string v2, "IMAGE_MEDIA_ID"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 25
    const-string v0, "IMAGE_INDEX"

    invoke-virtual {v1, v0, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    const/4 p1, 0x0

    .line 26
    invoke-virtual {p0, v1, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    return-void

    .line 27
    :cond_4
    sget v0, Lio/dcloud/base/R$id;->check_origin_image_layout:I

    if-ne p1, v0, :cond_5

    .line 28
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fullImage:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/view/View;->isSelected()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setSelected(Z)V

    :cond_5
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .line 1
    invoke-super {p0, p1}, Landroidx/fragment/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    const/4 p1, 0x1

    .line 2
    invoke-virtual {p0, p1}, Landroid/app/Activity;->requestWindowFeature(I)Z

    .line 3
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1d

    const/4 v2, 0x0

    if-lt v0, v1, :cond_0

    .line 4
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/taobao/weex/WXSDKInstance$$ExternalSyntheticApiModelOutline0;->m(Landroid/view/Window;Z)V

    .line 5
    :cond_0
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_LAYOUT_PREVIEW_MAIN:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->setContentView(I)V

    .line 6
    invoke-direct {p0}, Lcom/dmcbig/mediapicker/PreviewActivity;->setTopAndBottomBarColor()V

    .line 7
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_BTN_BACK:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 8
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "single_select"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->isSingle:Z

    .line 9
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_CHECK_IMAGE:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->check_image:Landroid/widget/ImageView;

    .line 10
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_CHECK_LAYOUT:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->check_layout:Landroid/widget/LinearLayout;

    .line 11
    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 12
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_BAR_TITLE:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bar_title:Landroid/widget/TextView;

    .line 13
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_DONE:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->done:Landroid/widget/Button;

    .line 14
    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 15
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_TOP:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->top:Landroid/view/View;

    .line 16
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_BOTTOM:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bottom:Landroid/view/View;

    .line 17
    sget v0, Lio/dcloud/base/R$id;->gallery_preview_edit:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->imageEdit:Landroid/widget/TextView;

    .line 18
    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 20
    sget v0, Lio/dcloud/base/R$id;->check_origin_image:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fullImage:Landroid/widget/ImageView;

    .line 21
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "FULL_IMAGE"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    .line 22
    iget-object v1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fullImage:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 23
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "size_type"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x8

    if-eqz v0, :cond_3

    .line 25
    const-string v2, "original"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "compressed"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 26
    sget v0, Lio/dcloud/base/R$id;->check_origin_image_layout:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 27
    :cond_1
    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto :goto_0

    .line 30
    :cond_2
    sget v0, Lio/dcloud/base/R$id;->check_origin_image_layout:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 33
    :cond_3
    sget v0, Lio/dcloud/base/R$id;->check_origin_image_layout:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    :goto_0
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "select_mode"

    const/16 v3, 0x65

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    const/16 v2, 0x66

    if-ne v0, v2, :cond_4

    .line 37
    sget v0, Lio/dcloud/base/R$id;->check_origin_image_layout:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 39
    :cond_4
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "image_editable"

    invoke-virtual {v0, v2, p1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editable:Z

    .line 40
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "done_button_text"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    .line 41
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 42
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->done:Landroid/widget/Button;

    iget-object v2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 44
    :cond_5
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "max_select_count"

    const v3, 0x7fffffff

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->max:I

    .line 46
    :try_start_0
    const-string v0, "io.dcloud.feature.gallery.imageedit.IMGEditActivity"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editActivityClass:Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    nop

    .line 48
    :goto_1
    iget-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->isSingle:Z

    if-eqz v0, :cond_6

    .line 49
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bottom:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 51
    :cond_6
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_ID_VIEWPAGER:I

    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/viewpager/widget/ViewPager;

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->viewpager:Landroidx/viewpager/widget/ViewPager;

    .line 52
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "pre_raw_List"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    .line 54
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    if-eqz v0, :cond_a

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_7

    goto :goto_2

    .line 58
    :cond_7
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 59
    sget-boolean v0, Lio/dcloud/common/util/BaseInfo;->sGlobalFullScreen:Z

    if-eqz v0, :cond_8

    .line 60
    invoke-virtual {p0, p0, p1}, Lcom/dmcbig/mediapicker/PreviewActivity;->setFullScreen(Landroid/app/Activity;Z)V

    .line 62
    :cond_8
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {p0, p1}, Lcom/dmcbig/mediapicker/PreviewActivity;->setView(Ljava/util/ArrayList;)V

    .line 63
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x24

    if-lt p1, v0, :cond_9

    sget p1, Lio/dcloud/common/adapter/util/AndroidResources;->sAppTargetSdkVersion:I

    if-lt p1, v0, :cond_9

    .line 64
    sget p1, Lio/dcloud/base/R$id;->top:I

    invoke-virtual {p0, p1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    invoke-static {}, Landroidx/core/util/HalfKt$$ExternalSyntheticApiModelOutline0;->m$1()I

    move-result v0

    invoke-static {p0, p1, v0}, Lcom/dmcbig/mediapicker/utils/ScreenUtils;->fitAndroid16WindowInsets(Landroid/app/Activity;Landroid/view/View;I)V

    .line 65
    sget p1, Lio/dcloud/base/R$id;->bottom:I

    invoke-virtual {p0, p1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    invoke-static {}, Landroidx/core/util/HalfKt$$ExternalSyntheticApiModelOutline0;->m$2()I

    move-result v0

    invoke-static {p0, p1, v0}, Lcom/dmcbig/mediapicker/utils/ScreenUtils;->fitAndroid16WindowInsets(Landroid/app/Activity;Landroid/view/View;I)V

    .line 66
    sget p1, Lio/dcloud/base/R$id;->root:I

    invoke-virtual {p0, p1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    invoke-static {}, Landroidx/core/util/HalfKt$$ExternalSyntheticApiModelOutline0;->m$2()I

    move-result v0

    invoke-virtual {p0, p0, p1, v0}, Lcom/dmcbig/mediapicker/PreviewActivity;->fitAndroid16WindowInsets(Landroid/app/Activity;Landroid/view/View;I)V

    :cond_9
    return-void

    .line 67
    :cond_a
    :goto_2
    invoke-virtual {p0}, Lcom/dmcbig/mediapicker/PreviewActivity;->onBackPressed()V

    return-void
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0

    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    return-void
.end method

.method public onPageSelected(I)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bar_title:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v2, p1, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 2
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/dmcbig/mediapicker/entity/Media;

    .line 4
    iget-object v0, p1, Lcom/dmcbig/mediapicker/entity/Media;->extension:Ljava/lang/String;

    const-string v1, ".gif"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editActivityClass:Ljava/lang/Class;

    if-eqz v0, :cond_1

    iget v0, p1, Lcom/dmcbig/mediapicker/entity/Media;->mediaType:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1

    iget-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editable:Z

    if-nez v0, :cond_0

    goto :goto_0

    .line 7
    :cond_0
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->imageEdit:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 8
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->imageEdit:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 12
    :goto_1
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->check_image:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->selects:Ljava/util/ArrayList;

    invoke-virtual {p0, p1, v1}, Lcom/dmcbig/mediapicker/PreviewActivity;->isSelect(Lcom/dmcbig/mediapicker/entity/Media;Ljava/util/ArrayList;)I

    move-result p1

    if-gez p1, :cond_2

    sget p1, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_DRAWABLE_BNT_UNSELECTED:I

    goto :goto_2

    :cond_2
    sget p1, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_DRAWABLE_BNT_SELECTED:I

    :goto_2
    invoke-static {p0, p1}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public setBarStatus()V
    .locals 2

    .line 1
    const-string v0, "setBarStatus"

    invoke-static {v0, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->top:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 3
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->top:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 4
    iget-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->isSingle:Z

    if-nez v0, :cond_1

    .line 5
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bottom:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void

    .line 8
    :cond_0
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->top:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 9
    iget-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->isSingle:Z

    if-nez v0, :cond_1

    .line 10
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bottom:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :cond_1
    return-void
.end method

.method setDoneView(I)V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    sget v0, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_STRING_DONE:I

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    .line 3
    :cond_0
    iget v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->max:I

    const v1, 0x7fffffff

    const-string v2, ")"

    const-string v3, "("

    if-ne v0, v1, :cond_1

    .line 4
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->done:Landroid/widget/Button;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 6
    :cond_1
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->done:Landroid/widget/Button;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->doneBtnText:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, "/"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->max:I

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public setFullScreen(Landroid/app/Activity;Z)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p1

    if-eqz p2, :cond_0

    .line 3
    invoke-virtual {p1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object p2

    .line 4
    iget v0, p2, Landroid/view/WindowManager$LayoutParams;->flags:I

    or-int/lit16 v0, v0, 0x400

    iput v0, p2, Landroid/view/WindowManager$LayoutParams;->flags:I

    .line 5
    invoke-virtual {p1, p2}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    return-void

    .line 7
    :cond_0
    invoke-virtual {p1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object p2

    .line 8
    iget v0, p2, Landroid/view/WindowManager$LayoutParams;->flags:I

    and-int/lit16 v0, v0, -0x401

    iput v0, p2, Landroid/view/WindowManager$LayoutParams;->flags:I

    .line 9
    invoke-virtual {p1, p2}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    return-void
.end method

.method setView(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Lcom/dmcbig/mediapicker/entity/Media;",
            ">;)V"
        }
    .end annotation

    .line 1
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/dmcbig/mediapicker/PreviewActivity;->setDoneView(I)V

    .line 2
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->bar_title:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "1/"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 4
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->preRawList:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/dmcbig/mediapicker/entity/Media;

    .line 5
    iget-object v2, v0, Lcom/dmcbig/mediapicker/entity/Media;->extension:Ljava/lang/String;

    const-string v3, ".gif"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editActivityClass:Ljava/lang/Class;

    if-eqz v2, :cond_0

    iget v0, v0, Lcom/dmcbig/mediapicker/entity/Media;->mediaType:I

    const/4 v2, 0x3

    if-eq v0, v2, :cond_0

    iget-boolean v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->editable:Z

    if-nez v0, :cond_1

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->imageEdit:Landroid/widget/TextView;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 7
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fragmentArrayList:Ljava/util/ArrayList;

    .line 8
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    :goto_0
    if-ge v1, v0, :cond_2

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    add-int/lit8 v1, v1, 0x1

    check-cast v2, Lcom/dmcbig/mediapicker/entity/Media;

    .line 9
    iget-object v3, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fragmentArrayList:Ljava/util/ArrayList;

    const-string v4, ""

    invoke-static {v2, v4}, Lcom/dmcbig/mediapicker/view/PreviewFragment;->newInstance(Lcom/dmcbig/mediapicker/entity/Media;Ljava/lang/String;)Lcom/dmcbig/mediapicker/view/PreviewFragment;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 11
    :cond_2
    new-instance p1, Lcom/dmcbig/mediapicker/PreviewActivity$AdapterFragment;

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    iget-object v1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->fragmentArrayList:Ljava/util/ArrayList;

    invoke-direct {p1, p0, v0, v1}, Lcom/dmcbig/mediapicker/PreviewActivity$AdapterFragment;-><init>(Lcom/dmcbig/mediapicker/PreviewActivity;Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V

    .line 12
    iget-object v0, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->viewpager:Landroidx/viewpager/widget/ViewPager;

    invoke-virtual {v0, p1}, Landroidx/viewpager/widget/ViewPager;->setAdapter(Landroidx/viewpager/widget/PagerAdapter;)V

    .line 13
    iget-object p1, p0, Lcom/dmcbig/mediapicker/PreviewActivity;->viewpager:Landroidx/viewpager/widget/ViewPager;

    invoke-virtual {p1, p0}, Landroidx/viewpager/widget/ViewPager;->addOnPageChangeListener(Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;)V

    return-void
.end method
