package com.dcloud.android.downloader.core;

import com.dcloud.android.downloader.domain.DownloadInfo;
import com.dcloud.android.downloader.exception.DownloadException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface DownloadResponse {
    void handleException(DownloadException downloadException);

    void onStatusChanged(DownloadInfo downloadInfo);
}
