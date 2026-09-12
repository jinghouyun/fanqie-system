package io.dcloud.p;

import android.text.TextUtils;
import com.taobao.weex.el.parse.Operators;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class r2 {
    private String a;
    private int b;
    private int c;

    public r2(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return TextUtils.isEmpty(this.a);
    }

    public String toString() {
        return "IMGText{text='" + this.a + "', color=" + this.b + Operators.BLOCK_END;
    }
}
