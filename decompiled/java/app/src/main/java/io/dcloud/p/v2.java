package io.dcloud.p;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import io.dcloud.sdk.base.entry.AdData;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v2 {
    protected c a;
    private Context b;
    protected String c;
    protected AdData d;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;

        a(int i, String str) {
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            v2.this.a.onError(this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v2.this.a.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface c {
        void a(int i, String str);

        void k();

        void l();

        void m();

        void onAdClicked();

        void onAdShow();

        void onError(int i, String str);
    }

    public v2(c cVar, Context context, String str) {
        this.a = cVar;
        this.b = context;
        this.c = str;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(60010, "广告容器不可见");
        } else if (this.d == null) {
            a(60005, "数据解析失败");
        } else {
            new o4(viewGroup.getContext(), this.a, this.d).a(viewGroup);
        }
    }

    public Context b() {
        return this.b;
    }

    protected void a(int i, String str) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new a(i, str));
        }
    }

    protected void a() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new b());
        }
    }
}
