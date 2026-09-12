package io.dcloud.sdk.core.v3.dw;

import android.app.Activity;
import android.view.View;
import io.dcloud.p.j1;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.v3.fd.DCFeedAOL;
import io.dcloud.sdk.core.v3.fd.DCFeedAOLListener;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCDrawAOL extends DCFeedAOL implements AOLLoader.DrawAOLInteractionListener {
    public DCDrawAOL(j1 j1Var) {
        super(j1Var);
    }

    public View getDrawAOLView(Activity activity) {
        return getFeedAOLView(activity);
    }

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOL, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public boolean isExpressAd() {
        return true;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onEnd() {
        DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof DCDrawAOLListener) {
            ((DCDrawAOLListener) dCFeedAOLListener).onEnd();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onError() {
        DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof DCDrawAOLListener) {
            dCFeedAOLListener.onShowError();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onPause() {
        DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof DCDrawAOLListener) {
            ((DCDrawAOLListener) dCFeedAOLListener).onPause();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onResume() {
        DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof DCDrawAOLListener) {
            ((DCDrawAOLListener) dCFeedAOLListener).onResume();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onStart() {
        DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof DCDrawAOLListener) {
            ((DCDrawAOLListener) dCFeedAOLListener).onStart();
        }
    }

    public void setDrawAOLListener(DCDrawAOLListener dCDrawAOLListener) {
        this.b = dCDrawAOLListener;
    }
}
