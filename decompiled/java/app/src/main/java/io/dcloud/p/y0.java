package io.dcloud.p;

import android.content.Context;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class y0 implements Runnable {
    private a a;
    private Context b;
    private String c;
    private String d;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface a {
        void a(y0 y0Var);

        void b(y0 y0Var);
    }

    public void a(Context context, String str, String str2) {
        this.b = context;
        this.c = str;
        this.d = str2;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    @Override // java.lang.Runnable
    public void run() {
        InputStream inputStreamA = l3.a(this.c, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, true, new String[1]);
        a aVar = this.a;
        if (aVar != null) {
            if (inputStreamA == null) {
                aVar.b(this);
            } else {
                v0.a(inputStreamA, this.d);
                this.a.a(this);
            }
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public Context a() {
        return this.b;
    }
}
