package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.util.MainHandlerUtil;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class b1 extends j1 implements AOLLoader.DrawAOLInteractionListener {
    public b1(DCBaseAOL dCBaseAOL, Activity activity) {
        super(dCBaseAOL, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            feedAOLInteractionListener.onShowError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onStart();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onEnd() {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.q();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onError() {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.r();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onPause() {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.s();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onResume() {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.t();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onStart() {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.u();
            }
        });
    }
}
