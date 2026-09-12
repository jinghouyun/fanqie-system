package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i4 extends y3 implements Runnable {
    protected DCloudAOLSlot b;
    protected final Activity c;
    protected int d;
    private b0.a e;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends b0.a {
        a(String str) {
            super(str);
        }

        @Override // io.dcloud.p.b0.a
        public void a(JSONObject jSONObject) {
            i4.this.a(jSONObject);
        }

        @Override // io.dcloud.p.b0.a
        public void a(int i, String str) {
            i4.this.b(i, str);
        }
    }

    public i4(Activity activity) {
        this.c = activity;
    }

    private void d() {
        if (this.e == null) {
            this.e = new a(this.b.getAdpid());
        }
        b0.a().a(this.c, c(), this.e);
    }

    protected abstract void a(int i, String str);

    protected abstract void a(t0 t0Var);

    protected final void a(DCloudAOLSlot dCloudAOLSlot) {
        this.b = dCloudAOLSlot;
        dCloudAOLSlot.setType(this.d);
    }

    protected void b(int i, String str) {
        a(i, str);
    }

    protected int c() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
    }

    protected void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            a(new t0().a(jSONObject, c()));
        } else {
            a(-5001, AOLErrorUtil.getErrorMsg(-5001));
        }
    }

    protected void a(b0.a aVar) {
        this.e = aVar;
    }
}
