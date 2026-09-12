package io.dcloud.common.DHInterface;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface ICore {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface ICoreEvent {
        public static final int CHECK_IS_IBOOT_SERVICES = 1;
        public static final int GET_SDK_MODE = -1;
        public static final int WEBAPP_QUIT = 0;
        public static final int WEBAPP_START = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface ICoreStatusListener {
        void onCoreInitEnd(ICore iCore);

        void onCoreReady(ICore iCore);

        boolean onCoreStop();
    }

    Object dispatchEvent(IMgr.MgrType mgrType, int i, Object obj);

    Context obtainActivityContext();

    Context obtainContext();

    boolean onActivityExecute(Activity activity, ISysEventListener.SysEventType sysEventType, Object obj);

    void onRestart(Context context);

    void setmCoreListener(ICoreStatusListener iCoreStatusListener);
}
