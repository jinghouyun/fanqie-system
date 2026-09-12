package io.dcloud.api.custom.type;

import android.app.Activity;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.p.w1;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomBaseLoader {
    protected w1 a;

    public final void a(Activity activity, UniAdSlot uniAdSlot, w1 w1Var) {
        this.a = w1Var;
        try {
            load(activity, uniAdSlot);
        } catch (Throwable unused) {
            onLoadFail(-4002, AOLErrorUtil.getErrorMsg(-4002));
        }
    }

    public abstract void destroy();

    public int getBidType() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            return w1Var.f();
        }
        return 0;
    }

    public abstract boolean isReady();

    public abstract void load(Activity activity, UniAdSlot uniAdSlot);

    public void onAdClicked() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onAdClicked();
        }
    }

    public void onAdClosed() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.j();
        }
    }

    public void onAdPlayEnd() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.h();
        }
    }

    public void onAdPlayError(int i, String str) {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.a(i, str);
        }
    }

    public void onAdShow() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onAdShow();
        }
    }

    public void onAdSkip() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.b();
        }
    }

    public void onBidFail(int i, int i2) {
    }

    public void onBidSuccess(int i, int i2) {
    }

    public void onLoadFail(int i, String str) {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onLoadFail(i, str);
        }
    }

    public void onLoadSuccess(List<? extends UniAdCustomNativeAd> list) {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onLoadSuccess(list);
        }
    }

    public void setBidPrice(int i) {
        Object obj = this.a;
        if ((obj instanceof DCBaseAOL) && ((DCBaseAOL) obj).isSlotSupportBidding()) {
            ((DCBaseAOL) this.a).setBiddingECPM(i);
        }
    }

    public abstract void show(Object obj);

    public void onLoadSuccess() {
        w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.d();
        }
    }
}
