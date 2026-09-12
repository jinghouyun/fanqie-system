package com.dcloud.android.downloader.callback;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsDownloadListener implements DownloadListener {
    private SoftReference<Object> userTag;

    public AbsDownloadListener() {
    }

    public SoftReference<Object> getUserTag() {
        return this.userTag;
    }

    public void setUserTag(SoftReference<Object> softReference) {
        this.userTag = softReference;
    }

    public AbsDownloadListener(SoftReference<Object> softReference) {
        this.userTag = softReference;
    }
}
