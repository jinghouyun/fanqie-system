package com.dcloud.android.downloader.db;

import com.dcloud.android.downloader.domain.DownloadInfo;
import com.dcloud.android.downloader.domain.DownloadThreadInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface DownloadDBController {
    void createOrUpdate(DownloadInfo downloadInfo);

    void createOrUpdate(DownloadThreadInfo downloadThreadInfo);

    void delete(DownloadInfo downloadInfo);

    void delete(DownloadThreadInfo downloadThreadInfo);

    List<DownloadInfo> findAllDownloaded();

    List<DownloadInfo> findAllDownloading();

    DownloadInfo findDownloadedInfoById(int i);

    void pauseAllDownloading();
}
