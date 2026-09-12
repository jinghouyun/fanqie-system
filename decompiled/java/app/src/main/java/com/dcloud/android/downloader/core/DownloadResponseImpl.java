package com.dcloud.android.downloader.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.dcloud.android.downloader.db.DownloadDBController;
import com.dcloud.android.downloader.domain.DownloadInfo;
import com.dcloud.android.downloader.domain.DownloadThreadInfo;
import com.dcloud.android.downloader.exception.DownloadException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DownloadResponseImpl implements DownloadResponse {
    private static final String TAG = "DownloadResponseImpl";
    private final DownloadDBController downloadDBController;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.dcloud.android.downloader.core.DownloadResponseImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            DownloadInfo downloadInfo = (DownloadInfo) message.obj;
            switch (downloadInfo.getStatus()) {
                case 1:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onStart();
                    }
                    break;
                case 2:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onDownloading(downloadInfo.getProgress(), downloadInfo.getSize());
                    }
                    break;
                case 3:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onWaited();
                    }
                    break;
                case 4:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onPaused();
                    }
                    break;
                case 5:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onDownloadSuccess(downloadInfo);
                    }
                    break;
                case 6:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onDownloadFailed(downloadInfo, downloadInfo.getException());
                    }
                    break;
                case 7:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onRemoved();
                    }
                    break;
            }
        }
    };

    public DownloadResponseImpl(DownloadDBController downloadDBController) {
        this.downloadDBController = downloadDBController;
    }

    @Override // com.dcloud.android.downloader.core.DownloadResponse
    public void handleException(DownloadException downloadException) {
    }

    @Override // com.dcloud.android.downloader.core.DownloadResponse
    public void onStatusChanged(DownloadInfo downloadInfo) {
        if (downloadInfo.getStatus() != 7) {
            this.downloadDBController.createOrUpdate(downloadInfo);
            if (downloadInfo.getDownloadThreadInfos() != null) {
                Iterator<DownloadThreadInfo> it = downloadInfo.getDownloadThreadInfos().iterator();
                while (it.hasNext()) {
                    this.downloadDBController.createOrUpdate(it.next());
                }
            }
        }
        Message messageObtainMessage = this.handler.obtainMessage(downloadInfo.getId());
        messageObtainMessage.obj = downloadInfo;
        messageObtainMessage.sendToTarget();
        Log.d(TAG, "progress:" + downloadInfo.getProgress() + ",size:" + downloadInfo.getSize());
    }
}
