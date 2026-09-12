package io.dcloud.sdk.core.module;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.nostra13.dcloudimageloader.core.download.BaseImageDownloader;
import io.dcloud.p.a3;
import io.dcloud.p.c3;
import io.dcloud.p.e;
import io.dcloud.p.m;
import io.dcloud.p.n1;
import io.dcloud.p.v4;
import io.dcloud.p.w;
import io.dcloud.sdk.core.adapter.IAdAdapter;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.util.Const;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import io.dcloud.sdk.poly.api.Platform;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DCBaseAOLLoader extends io.dcloud.sdk.core.module.a {
    private boolean F;
    private final Handler G;
    private final int H;
    private int I;
    private w.a J;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private static class a implements Runnable {
        private final DCBaseAOLLoader a;
        private final int b;
        private final int c;
        private final String d;
        private final List e;

        public a(DCBaseAOLLoader dCBaseAOLLoader, List list, int i, int i2, String str) {
            this.a = dCBaseAOLLoader;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = list;
            if (list != null) {
                c3.d("sub slot ads:" + list.size());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            n1 n1Var = new n1();
            n1Var.c(this.a.n()).e(this.a.getSlotId()).b(this.a.e).d(this.a.getType()).f(this.a.getTid()).a(this.a.t());
            if (this.a.s()) {
                n1Var.a(m.a(this.a)).b(m.b(this.a));
            }
            int i = this.b;
            if (i == 1) {
                n1Var.c(i);
                if (this.a.isSlotSupportBidding()) {
                    n1Var.a(this.a.getBiddingECPM());
                }
                this.a.J.a(this.a, this.e, n1Var);
                return;
            }
            if (i == 0) {
                n1Var.c(i);
                n1Var.a(this.c, this.d);
                this.a.J.a(this.a, n1Var);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            DCBaseAOLLoader.this.loadFail(-5000, "timeout");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public DCBaseAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.F = false;
        this.H = 1;
        this.I = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        d(-1);
        this.G = new b(a3.a().getLooper());
    }

    private boolean w() {
        if (TextUtils.isEmpty(n())) {
            return !e.b().a(getType()) || getType().equalsIgnoreCase("dcloud") || getType().equalsIgnoreCase(Const.TYPE_WM);
        }
        if (getType().equalsIgnoreCase(Const.TYPE_SGM)) {
            return !TextUtils.isEmpty(o());
        }
        return true;
    }

    private boolean x() {
        return getSlot().getType() == 10 || getSlot().getType() == 4 || getSlot().getType() == 5;
    }

    public void a(IAdAdapter iAdAdapter, JSONObject jSONObject) {
    }

    public final void b(final Map map) {
        d(-1);
        if (!w()) {
            loadFail(-9999, "");
            return;
        }
        if (TextUtils.isEmpty(getSlotId())) {
            loadFail(-9999, "");
            return;
        }
        startLoadTime();
        if (runOnMain()) {
            MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.sdk.core.module.DCBaseAOLLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(map);
                }
            });
        } else {
            try {
                load(map);
            } catch (Throwable th) {
                loadFail(-4002, th.getMessage());
            }
        }
        this.G.sendEmptyMessageDelayed(1, this.I);
    }

    protected abstract void init(String str, String str2);

    public abstract void load(Map<String, Object> map);

    public final void loadFail(int i, String str) {
        if (this.F) {
            return;
        }
        b(i, str);
        this.F = true;
        this.G.removeMessages(1);
        a3.a().post(new a(this, null, 0, i, str));
    }

    public final void loadSuccess() {
        if (x()) {
            loadFail(-5001, "回调接口调用失败，应该使用loadSuccess(List obj)");
        } else {
            loadSuccess(null);
        }
    }

    protected boolean runOnMain() {
        return false;
    }

    public void setPlatform(Platform platform, String str) {
    }

    public void show(Activity activity) {
    }

    public void showIn(ViewGroup viewGroup) {
    }

    public n1 y() {
        n1 n1Var = new n1();
        u();
        n1Var.c(n()).b(this.e).e(getSlotId()).d(getType()).f(getTid()).a(t());
        n1Var.c(getAdStatus());
        if (isSlotSupportBidding()) {
            n1Var.a(getBiddingECPM());
        }
        if (s()) {
            n1Var.a(m.a(this)).b(m.b(this));
        }
        return n1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Map map) {
        try {
            load(map);
        } catch (Throwable th) {
            loadFail(-4002, th.getMessage());
        }
    }

    public void a(v4 v4Var) {
        g(v4Var.o());
        this.s = v4Var.l();
        b(v4Var.u());
        if (!isSlotSupportBidding()) {
            setBiddingECPM(v4Var.c());
        }
        this.d = v4Var.n();
        this.I = v4Var.p();
        this.e = v4Var.f();
        this.g = v4Var.b();
        setFeedType(v4Var.d());
        e(v4Var.h());
        a(v4Var.r());
        f(v4Var.k());
        c(v4Var.i());
        a(v4Var.j());
        a(v4Var.a());
        b(v4Var.e());
        setExpressAd(v4Var.s());
        getExtraData().put(2001, v4Var.m());
        c3.d("load sub slot cfg:" + v4Var.toString());
    }

    public final void loadSuccess(List<? extends DCBaseAOL> list) {
        if (!x()) {
            list = null;
        }
        List<? extends DCBaseAOL> list2 = list;
        if (this.F) {
            return;
        }
        if (list2 != null) {
            for (DCBaseAOL dCBaseAOL : list2) {
                dCBaseAOL.e = this.e;
                dCBaseAOL.b(isSlotSupportBidding());
                dCBaseAOL.setBiddingECPM(getBiddingECPM());
                dCBaseAOL.d = this.d;
                dCBaseAOL.g = this.g;
                dCBaseAOL.g(getSlotId());
                dCBaseAOL.b(n());
                dCBaseAOL.setFeedType(getFeedType());
                dCBaseAOL.d(q());
                dCBaseAOL.s = this.s;
            }
        }
        v();
        this.F = true;
        this.G.removeMessages(1);
        a3.a().post(new a(this, list2, 1, 0, null));
    }

    public void a(String str, String str2) {
        b(str);
        c(str2);
        init(str, str2);
    }

    public final void a(String str, IAdAdapter iAdAdapter, JSONObject jSONObject) {
        b(str);
        a(iAdAdapter, jSONObject);
    }

    public void a(w.a aVar) {
        this.J = aVar;
    }
}
