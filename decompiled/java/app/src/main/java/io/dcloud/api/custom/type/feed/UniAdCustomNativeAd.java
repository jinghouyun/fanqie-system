package io.dcloud.api.custom.type.feed;

import android.view.View;
import io.dcloud.p.x1;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomNativeAd {
    protected x1 a;
    private int b = 0;

    public void a(x1 x1Var) {
        this.a = x1Var;
        render();
    }

    public abstract void destroy();

    public final int getBidPrice() {
        return this.b;
    }

    public abstract View getNativeAd();

    public final void onAdClicked() {
        x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onAdClicked();
        }
    }

    public final void onAdClosed(String str) {
        x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.a(str);
        }
    }

    public final void onAdShow() {
        x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onAdShow();
        }
    }

    public void onBidFail(int i, int i2) {
    }

    public void onBidSuccess(int i, int i2) {
    }

    public void onRenderFail(int i, String str) {
        x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onRenderFail();
        }
    }

    public void onRenderSuccess() {
        x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onRenderSuccess();
        }
    }

    public final void onShowError(int i, String str) {
        x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onShowError(i, str);
        }
    }

    public abstract void render();

    public final void setBidPrice(int i) {
        this.b = i;
    }
}
