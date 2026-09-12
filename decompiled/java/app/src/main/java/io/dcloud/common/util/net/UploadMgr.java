package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class UploadMgr {
    private static UploadMgr mUploadMgr;
    private NetWorkLoop mUploadLoop;

    private UploadMgr() {
        NetWorkLoop netWorkLoop = new NetWorkLoop();
        this.mUploadLoop = netWorkLoop;
        netWorkLoop.startThreadPool();
    }

    public static UploadMgr getUploadMgr() {
        if (mUploadMgr == null) {
            mUploadMgr = new UploadMgr();
        }
        return mUploadMgr;
    }

    public void abort(NetWork netWork) {
        removeNetWork(netWork);
    }

    public void dispose() {
    }

    public void removeNetWork(NetWork netWork) {
        this.mUploadLoop.removeNetWork(netWork);
    }

    public void start(NetWork netWork) {
        this.mUploadLoop.addNetWork(netWork);
    }
}
