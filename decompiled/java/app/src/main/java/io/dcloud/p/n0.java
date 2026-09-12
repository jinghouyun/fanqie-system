package io.dcloud.p;

import android.app.Activity;
import android.view.View;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.module.DCBaseAOL;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class n0 extends DCBaseAOL implements x1, x1.a {
    private int A;
    private UniAdCustomNativeAd z;

    public n0(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.A = 0;
    }

    public void a(UniAdCustomNativeAd uniAdCustomNativeAd) {
        this.z = uniAdCustomNativeAd;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.z;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.onBidFail(i, i3);
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.z;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.onBidSuccess(i, i2);
        }
    }

    @Override // io.dcloud.p.x1.a
    public void c() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void destroy() {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.z;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.destroy();
        }
    }

    @Override // io.dcloud.p.x1.a
    public void e() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public View getExpressAdView(Activity activity) {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.z;
        return uniAdCustomNativeAd != null ? uniAdCustomNativeAd.getNativeAd() : super.getExpressAdView(activity);
    }

    @Override // io.dcloud.p.x1.a
    public void i() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isValid() {
        return true;
    }

    @Override // io.dcloud.p.x1
    public void onAdClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // io.dcloud.p.x1
    public void onAdShow() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // io.dcloud.p.x1
    public void onRenderFail() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
        this.A = -1;
    }

    @Override // io.dcloud.p.x1
    public void onRenderSuccess() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
        this.A = 1;
    }

    @Override // io.dcloud.p.x1
    public void onShowError(int i, String str) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShowError();
        }
    }

    @Override // io.dcloud.p.x1.a
    public void onVideoPlayEnd() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void render() {
        try {
            UniAdCustomNativeAd uniAdCustomNativeAd = this.z;
            if (uniAdCustomNativeAd == null) {
                if (getFeedAdCallback() != null) {
                    getFeedAdCallback().onRenderFail();
                }
                this.A = -1;
                return;
            }
            int i = this.A;
            if (i == 1) {
                if (getFeedAdCallback() != null) {
                    getFeedAdCallback().onRenderSuccess();
                }
            } else if (i != -1) {
                uniAdCustomNativeAd.a(this);
            } else if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
            }
        } catch (Throwable unused) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
            }
            this.A = -1;
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean s() {
        return true;
    }

    @Override // io.dcloud.p.x1
    public void a(String str) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed(str);
        }
    }

    @Override // io.dcloud.p.x1.a
    public void a() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onError();
        }
    }
}
