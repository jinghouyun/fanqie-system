.class public Lcom/dmcbig/mediapicker/data/MediaLoader;
.super Lcom/dmcbig/mediapicker/data/LoaderM;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# instance fields
.field MEDIA_PROJECTION:[Ljava/lang/String;

.field mContext:Landroid/content/Context;

.field mLoader:Lcom/dmcbig/mediapicker/data/DataCallback;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/dmcbig/mediapicker/data/DataCallback;)V
    .locals 7

    .line 1
    invoke-direct {p0}, Lcom/dmcbig/mediapicker/data/LoaderM;-><init>()V

    .line 2
    const-string v5, "_id"

    const-string v6, "parent"

    const-string v0, "_data"

    const-string v1, "_display_name"

    const-string v2, "date_added"

    const-string v3, "media_type"

    const-string v4, "_size"

    filled-new-array/range {v0 .. v6}, [Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->MEDIA_PROJECTION:[Ljava/lang/String;

    .line 15
    iput-object p1, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->mContext:Landroid/content/Context;

    .line 16
    iput-object p2, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->mLoader:Lcom/dmcbig/mediapicker/data/DataCallback;

    return-void
.end method


# virtual methods
.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7

    .line 1
    const-string p1, "external"

    invoke-static {p1}, Landroid/provider/MediaStore$Files;->getContentUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 2
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->MEDIA_PROJECTION:[Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "date_added DESC"

    const-string v4, "media_type=1 OR media_type=3"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 13

    .line 1
    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 2
    new-instance v0, Lcom/dmcbig/mediapicker/entity/Folder;

    iget-object v1, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_STRING_ALL_DIR_NAME:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/dmcbig/mediapicker/entity/Folder;-><init>(Ljava/lang/String;)V

    .line 3
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 4
    new-instance v1, Lcom/dmcbig/mediapicker/entity/Folder;

    iget-object v2, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/dmcbig/mediapicker/MediaPickerR;->MP_STRING_VIDEO_DIR_NAME:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/dmcbig/mediapicker/entity/Folder;-><init>(Ljava/lang/String;)V

    .line 5
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 6
    check-cast p2, Landroid/database/Cursor;

    .line 7
    :goto_0
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 8
    const-string v2, "_data"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 13
    const-string v2, "_display_name"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 14
    const-string v2, "date_added"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    .line 15
    const-string v2, "media_type"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    .line 16
    const-string v2, "_size"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 17
    const-string v2, "_id"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    const-wide/16 v2, 0x1

    cmp-long v12, v9, v2

    if-gez v12, :cond_0

    goto :goto_0

    .line 20
    :cond_0
    invoke-virtual {p0, v4}, Lcom/dmcbig/mediapicker/data/LoaderM;->getParent(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 21
    new-instance v3, Lcom/dmcbig/mediapicker/entity/Media;

    invoke-direct/range {v3 .. v12}, Lcom/dmcbig/mediapicker/entity/Media;-><init>(Ljava/lang/String;Ljava/lang/String;JIJILjava/lang/String;)V

    .line 22
    invoke-virtual {v0, v3}, Lcom/dmcbig/mediapicker/entity/Folder;->addMedias(Lcom/dmcbig/mediapicker/entity/Media;)V

    const/4 v2, 0x3

    if-ne v8, v2, :cond_1

    .line 24
    invoke-virtual {v1, v3}, Lcom/dmcbig/mediapicker/entity/Folder;->addMedias(Lcom/dmcbig/mediapicker/entity/Media;)V

    .line 27
    :cond_1
    invoke-virtual {p0, p1, v12}, Lcom/dmcbig/mediapicker/data/LoaderM;->hasDir(Ljava/util/ArrayList;Ljava/lang/String;)I

    move-result v2

    const/4 v4, -0x1

    if-eq v2, v4, :cond_2

    .line 29
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/dmcbig/mediapicker/entity/Folder;

    invoke-virtual {v2, v3}, Lcom/dmcbig/mediapicker/entity/Folder;->addMedias(Lcom/dmcbig/mediapicker/entity/Media;)V

    goto :goto_0

    .line 31
    :cond_2
    new-instance v2, Lcom/dmcbig/mediapicker/entity/Folder;

    invoke-direct {v2, v12}, Lcom/dmcbig/mediapicker/entity/Folder;-><init>(Ljava/lang/String;)V

    .line 32
    invoke-virtual {v2, v3}, Lcom/dmcbig/mediapicker/entity/Folder;->addMedias(Lcom/dmcbig/mediapicker/entity/Media;)V

    .line 33
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 36
    :cond_3
    iget-object v0, p0, Lcom/dmcbig/mediapicker/data/MediaLoader;->mLoader:Lcom/dmcbig/mediapicker/data/DataCallback;

    invoke-interface {v0, p1}, Lcom/dmcbig/mediapicker/data/DataCallback;->onData(Ljava/util/ArrayList;)V

    .line 37
    invoke-interface {p2}, Landroid/database/Cursor;->close()V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0

    return-void
.end method
