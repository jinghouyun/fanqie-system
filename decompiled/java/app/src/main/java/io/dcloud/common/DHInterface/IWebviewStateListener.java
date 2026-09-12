package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IWebviewStateListener extends ICallBack {
    public static final int ON_LOAD_RESOURCE = 2;
    public static final int ON_PAGE_FINISHED = 1;
    public static final int ON_PAGE_STARTED = 0;
    public static final int ON_PROGRESS_CHANGED = 3;
    public static final int ON_RECEIVED_ERROR = 5;
    public static final int ON_RECEIVED_TITLE = 4;
    public static final int ON_WEBVIEW_READY = -1;
    public static final int ON_WEBVIEW_RENDERING = 6;
}
