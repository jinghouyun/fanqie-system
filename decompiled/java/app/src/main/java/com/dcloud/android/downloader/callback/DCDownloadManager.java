package com.dcloud.android.downloader.callback;

import com.dcloud.android.downloader.db.DownloadDBController;
import com.dcloud.android.downloader.domain.DownloadInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface DCDownloadManager {
    void download(DownloadInfo downloadInfo);

    List<DownloadInfo> findAllDownloaded();

    List<DownloadInfo> findAllDownloading();

    DownloadInfo getDownloadById(int i);

    DownloadDBController getDownloadDBController();

    void onDestroy();

    void pause(DownloadInfo downloadInfo);

    void remove(DownloadInfo downloadInfo);

    void resume(DownloadInfo downloadInfo);
}
