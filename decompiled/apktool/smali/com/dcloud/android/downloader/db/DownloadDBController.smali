.class public interface abstract Lcom/dcloud/android/downloader/db/DownloadDBController;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# virtual methods
.method public abstract createOrUpdate(Lcom/dcloud/android/downloader/domain/DownloadInfo;)V
.end method

.method public abstract createOrUpdate(Lcom/dcloud/android/downloader/domain/DownloadThreadInfo;)V
.end method

.method public abstract delete(Lcom/dcloud/android/downloader/domain/DownloadInfo;)V
.end method

.method public abstract delete(Lcom/dcloud/android/downloader/domain/DownloadThreadInfo;)V
.end method

.method public abstract findAllDownloaded()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/dcloud/android/downloader/domain/DownloadInfo;",
            ">;"
        }
    .end annotation
.end method

.method public abstract findAllDownloading()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/dcloud/android/downloader/domain/DownloadInfo;",
            ">;"
        }
    .end annotation
.end method

.method public abstract findDownloadedInfoById(I)Lcom/dcloud/android/downloader/domain/DownloadInfo;
.end method

.method public abstract pauseAllDownloading()V
.end method
