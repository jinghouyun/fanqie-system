package io.dcloud.p;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.v3.cp.DCContentPage;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class j0 extends b5 implements AOLLoader.ContentPageVideoListener {
    public j0(Activity activity, int i) {
        super(activity, i);
    }

    @Override // io.dcloud.p.b5
    public void a(DCloudAOLSlot dCloudAOLSlot, w2 w2Var) {
        try {
            Class.forName("com.kwad.sdk.api.KsContentPage");
            super.a(dCloudAOLSlot, w2Var);
        } catch (ClassNotFoundException unused) {
            if (w2Var != null) {
                w2Var.onError(-5050, "当前环境没有快手内容联盟SDK", null);
            }
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onComplete(DCContentPage.ContentPageItem contentPageItem) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onComplete(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onError(DCContentPage.ContentPageItem contentPageItem) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onError(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onPause(DCContentPage.ContentPageItem contentPageItem) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onPause(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onResume(DCContentPage.ContentPageItem contentPageItem) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onResume(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onStart(DCContentPage.ContentPageItem contentPageItem) {
        AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof AOLLoader.ContentPageVideoListener) {
            ((AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onStart(contentPageItem);
        }
    }

    public Fragment s() {
        DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            try {
                return (Fragment) dCBaseAOL.getClass().getDeclaredMethod("getContentPage", null).invoke(this.t, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
