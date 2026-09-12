package io.dcloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;
import com.dcloud.android.widget.toast.ToastCompat;
import io.dcloud.application.DCLoudApplicationImpl;
import io.dcloud.common.DHInterface.ICore;
import io.dcloud.common.DHInterface.IOnCreateSplashView;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.core.ui.DCKeyboardManager;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.RuningAcitvityUtil;
import io.dcloud.feature.internal.sdk.SDK;
import io.dcloud.p.q3;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class EntryProxy {
    public static boolean d = false;
    private static EntryProxy e;
    private ArrayList a = new ArrayList(1);
    boolean b = false;
    q3 c = null;

    private EntryProxy() {
    }

    private void clearData() {
        Logger.d("EntryProxy", " clearData");
        e = null;
        d = false;
        this.b = false;
        AndroidResources.clearData();
        BaseInfo.clearData();
        this.c = null;
    }

    public static EntryProxy getInstnace() {
        return e;
    }

    public static EntryProxy init(Activity activity, ICore.ICoreStatusListener iCoreStatusListener) {
        d = true;
        Context applicationContext = activity.getApplicationContext();
        DCLoudApplicationImpl.self().setContext(applicationContext);
        AndroidResources.initAndroidResources(applicationContext);
        EntryProxy entryProxy = e;
        if (entryProxy != null) {
            entryProxy.c.a().setmCoreListener(iCoreStatusListener);
            if (e.c.b() != applicationContext) {
                e.destroy(activity);
            }
        }
        if (e == null) {
            e = new EntryProxy();
            CookieSyncManager.createInstance(applicationContext);
            e.c = new q3(applicationContext, iCoreStatusListener);
        }
        e.a.add(activity);
        return e;
    }

    public void destroy(Activity activity) {
        onStop(activity);
    }

    public boolean didCreate() {
        return this.b;
    }

    public ICore getCoreHandler() {
        q3 q3Var = this.c;
        if (q3Var != null) {
            return q3Var.a();
        }
        return null;
    }

    public Activity getEntryActivity() {
        if (this.a.size() > 0) {
            return (Activity) this.a.get(0);
        }
        return null;
    }

    public boolean onActivityExecute(Activity activity, ISysEventListener.SysEventType sysEventType, Object obj) {
        q3 q3Var = this.c;
        if (q3Var != null) {
            return q3Var.a(activity, sysEventType, obj);
        }
        return false;
    }

    public void onConfigurationChanged(Activity activity, int i) {
        q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.a(activity, i);
        }
    }

    @Deprecated
    public boolean onCreate(Bundle bundle, FrameLayout frameLayout, SDK.IntegratedMode integratedMode, IOnCreateSplashView iOnCreateSplashView) {
        return onCreate(bundle, integratedMode, iOnCreateSplashView);
    }

    public void onNewIntent(Activity activity, Intent intent) {
        q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.a(activity, intent);
        }
    }

    public void onPause(Activity activity) {
        q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.a(activity);
        }
        CookieSyncManager.getInstance().stopSync();
    }

    public void onResume(Activity activity) {
        q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.b(activity);
        }
        CookieSyncManager.getInstance().startSync();
    }

    public void onStop(Activity activity) {
        try {
            DCKeyboardManager.getInstance().onStop();
            RuningAcitvityUtil.isRuningActivity = false;
            BaseInfo.isFirstRun = false;
            this.a.remove(activity);
            if (this.a.size() == 0) {
                q3 q3Var = this.c;
                if (q3Var == null) {
                    clearData();
                } else if (q3Var.c(activity)) {
                    clearData();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public boolean onCreate(Bundle bundle, SDK.IntegratedMode integratedMode, IOnCreateSplashView iOnCreateSplashView) {
        ArrayList arrayList = this.a;
        return onCreate((Activity) arrayList.get(arrayList.size() - 1), bundle, integratedMode, iOnCreateSplashView);
    }

    public boolean onCreate(Activity activity, Bundle bundle, SDK.IntegratedMode integratedMode, IOnCreateSplashView iOnCreateSplashView) {
        RuningAcitvityUtil.isRuningActivity = true;
        DCKeyboardManager.getInstance().onCreate(activity);
        AndroidResources.initAndroidResources(activity.getBaseContext());
        this.c.a(activity, bundle, integratedMode, iOnCreateSplashView);
        if (BaseInfo.SyncDebug && !activity.getPackageName().equals(activity.getResources().getString(PdrR.DCLOUD_PACKAGE_NAME_BASE))) {
            ToastCompat.makeText((Context) activity, PdrR.DCLOUD_SYNC_DEBUD_MESSAGE, 0).show();
        }
        return true;
    }

    @Deprecated
    public boolean onCreate(Bundle bundle) {
        return onCreate(bundle, (FrameLayout) null, (SDK.IntegratedMode) null, (IOnCreateSplashView) null);
    }

    public static EntryProxy init(Activity activity) {
        return init(activity, null);
    }
}
