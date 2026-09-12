package io.dcloud.common.DHInterface;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IReqListener {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public enum NetState {
        NET_INIT,
        NET_REQUEST_BEGIN,
        NET_TIMEOUT,
        NET_CONNECTED,
        NET_ERROR,
        NET_HANDLE_BEGIN,
        NET_HANDLE_ING,
        NET_HANDLE_END,
        NET_PAUSE
    }

    void onNetStateChanged(NetState netState, boolean z);

    int onReceiving(InputStream inputStream) throws Exception;

    void onResponsing(InputStream inputStream);
}
