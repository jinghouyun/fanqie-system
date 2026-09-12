package io.dcloud.p;

import com.taobao.weex.el.parse.Operators;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class v4 {
    private int a;
    private int b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private String m;
    private String n;
    private int o;
    private boolean p;
    private JSONObject q;
    private int r;
    private boolean s;
    private int t;
    private String u;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static final class b {
        private int a;
        private int b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private int i;
        private int j;
        private int k;
        private String l;
        private String m;
        private int n;
        private boolean o;
        private JSONObject p;
        private int q;
        private int r;
        private String s;
        private boolean t = true;

        public b a(String str) {
            this.l = str;
            return this;
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b c(String str) {
            this.d = str;
            return this;
        }

        public b d(int i) {
            this.k = i;
            return this;
        }

        public b e(String str) {
            this.c = str;
            return this;
        }

        public b f(int i) {
            this.a = i;
            return this;
        }

        public b g(int i) {
            this.f = i;
            return this;
        }

        public b h(int i) {
            this.n = i;
            return this;
        }

        public b i(int i) {
            this.b = i;
            return this;
        }

        public b j(int i) {
            this.i = i;
            return this;
        }

        public b k(int i) {
            this.e = i;
            return this;
        }

        public b a(boolean z) {
            this.o = z;
            return this;
        }

        public b b(String str) {
            this.m = str;
            return this;
        }

        public b c(int i) {
            this.g = i;
            return this;
        }

        public b d(String str) {
            this.s = str;
            return this;
        }

        public b e(int i) {
            this.r = i;
            return this;
        }

        public b a(JSONObject jSONObject) {
            this.p = jSONObject;
            return this;
        }

        public b b(boolean z) {
            this.t = z;
            return this;
        }

        public b c(boolean z) {
            this.h = z;
            return this;
        }

        public b a(int i) {
            this.q = i;
            return this;
        }

        public v4 a() {
            return new v4(this);
        }
    }

    public void a(int i) {
        this.b = i;
    }

    public int b() {
        return this.j;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.l;
    }

    public int e() {
        return this.t;
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.f;
    }

    public String h() {
        return this.m;
    }

    public int i() {
        return this.o;
    }

    public JSONObject j() {
        return this.q;
    }

    public String k() {
        return this.n;
    }

    public String l() {
        return this.d;
    }

    public String m() {
        return this.u;
    }

    public int n() {
        return this.b;
    }

    public String o() {
        return this.c;
    }

    public int p() {
        return this.i;
    }

    public int q() {
        return this.e;
    }

    public boolean r() {
        return this.p;
    }

    public boolean s() {
        return this.s;
    }

    public boolean t() {
        return this.k;
    }

    public String toString() {
        return "cfg{level=" + this.a + ", ss=" + this.b + ", sid='" + this.c + "', p='" + this.d + "', w=" + this.e + ", m=" + this.f + ", cpm=" + this.g + ", bdt=" + this.h + ", sto=" + this.i + ", type=" + this.j + Operators.BLOCK_END;
    }

    public boolean u() {
        return this.h;
    }

    private v4(b bVar) {
        this.k = false;
        this.o = -1;
        this.p = false;
        this.s = true;
        this.t = 1;
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = this.e > 0 || this.f > 0;
        this.l = bVar.k;
        this.m = bVar.l;
        this.n = bVar.m;
        this.o = bVar.n;
        this.p = bVar.o;
        this.q = bVar.p;
        this.r = bVar.q;
        this.t = bVar.r;
        this.s = bVar.t;
        this.u = bVar.s;
    }

    public int a() {
        return this.r;
    }
}
