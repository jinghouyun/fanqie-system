package io.dcloud.common.util.net;

import io.dcloud.common.adapter.util.Logger;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DownloadMgr {
    private static DownloadMgr mDownloadMgr;
    private NetWorkLoop mDownloadLoop;

    private DownloadMgr() {
        NetWorkLoop netWorkLoop = new NetWorkLoop();
        this.mDownloadLoop = netWorkLoop;
        netWorkLoop.startThreadPool();
    }

    public static DownloadMgr getDownloadMgr() {
        if (mDownloadMgr == null) {
            mDownloadMgr = new DownloadMgr();
        }
        return mDownloadMgr;
    }

    public void addQuestTask(NetWork netWork) {
        this.mDownloadLoop.addNetWork(netWork);
    }

    public void dispose() {
        Logger.d("DownloadMgr: dispose");
        this.mDownloadLoop.dispose();
        this.mDownloadLoop = null;
        mDownloadMgr = null;
    }

    public void removeTask(NetWork netWork) {
        this.mDownloadLoop.removeNetWork(netWork);
    }
}
