package io.dcloud.common.DHInterface;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IUniInstanceMgr {
    void initUniappPlugin(Application application);

    void initWeexEnv(INativeAppInfo iNativeAppInfo);

    boolean isUniAppAssetsRes();

    void loadWeexToAppid(Context context, String str, boolean z);

    void onCreateProcess(Application application, Boolean bool);

    void registerUniappService(Context context, String str);

    void restartWeex(Application application, ICallBack iCallBack, String str);
}
