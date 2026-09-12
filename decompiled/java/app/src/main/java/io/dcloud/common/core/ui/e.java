package io.dcloud.common.core.ui;

import android.content.Context;
import android.view.animation.Animation;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IDCloudWebviewClientListener;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IJsInterface;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.adapter.ui.AdaWebview;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.util.Birdge;
import io.dcloud.common.util.DLGeolocation;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class e extends AdaWebview {
    protected e(Context context, AbsMgr absMgr, b bVar) {
        super(context, bVar);
        Logger.d("dhwebview", "DHWebview0");
        bVar.l = this;
        bVar.m = getWebviewParent();
        if (!bVar.obtainFrameOptions().mDisablePlus) {
            addJsInterface("_bridge", (IJsInterface) new Birdge(new h(this)));
        }
        addJsInterface("_dlGeolocation", (IJsInterface) new DLGeolocation(this));
        Logger.d("dhwebview", "DHWebview hashcode=" + bVar.hashCode());
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public IApp obtainApp() {
        if (obtainFrameView() != null) {
            return obtainFrameView().obtainApp();
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void show(Animation animation) {
        IFrameView iFrameViewObtainFrameView = obtainFrameView();
        ((b) iFrameViewObtainFrameView).setVisible(true, true);
        iFrameViewObtainFrameView.obtainWindowMgr().processEvent(IMgr.MgrType.WindowMgr, 1, new Object[]{iFrameViewObtainFrameView, animation});
    }

    protected e(Context context, AbsMgr absMgr, b bVar, IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        super(context, bVar, iDCloudWebviewClientListener);
        Logger.d("dhwebview", "DHWebview0");
        bVar.l = this;
        bVar.m = getWebviewParent();
        if (!bVar.obtainFrameOptions().mDisablePlus) {
            addJsInterface("_bridge", (IJsInterface) new Birdge(new h(this)));
        }
        addJsInterface("_dlGeolocation", (IJsInterface) new DLGeolocation(this));
        Logger.d("dhwebview", "DHWebview hashcode=" + bVar.hashCode());
    }
}
