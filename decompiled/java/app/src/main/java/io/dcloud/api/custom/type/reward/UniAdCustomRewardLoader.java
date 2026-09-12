package io.dcloud.api.custom.type.reward;

import android.app.Activity;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.p.w1;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomRewardLoader extends UniAdCustomBaseLoader {
    public void onReward() {
        w1 w1Var = this.a;
        if (w1Var instanceof w1.a) {
            ((w1.a) w1Var).g();
        }
    }

    public abstract void show(Activity activity);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
        show((Activity) obj);
    }
}
