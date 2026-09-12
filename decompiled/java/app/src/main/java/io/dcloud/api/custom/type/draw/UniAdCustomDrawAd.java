package io.dcloud.api.custom.type.draw;

import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.p.x1;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomDrawAd extends UniAdCustomNativeAd {
    public void onVideoPlayEnd() {
        x1 x1Var = this.a;
        if (x1Var instanceof x1.a) {
            ((x1.a) x1Var).onVideoPlayEnd();
        }
    }

    public void onVideoPlayError() {
        x1 x1Var = this.a;
        if (x1Var instanceof x1.a) {
            ((x1.a) x1Var).a();
        }
    }

    public void onVideoPlayPause() {
        x1 x1Var = this.a;
        if (x1Var instanceof x1.a) {
            ((x1.a) x1Var).c();
        }
    }

    public void onVideoPlayResume() {
        x1 x1Var = this.a;
        if (x1Var instanceof x1.a) {
            ((x1.a) x1Var).i();
        }
    }

    public void onVideoPlayStart() {
        x1 x1Var = this.a;
        if (x1Var instanceof x1.a) {
            ((x1.a) x1Var).e();
        }
    }
}
