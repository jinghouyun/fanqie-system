package com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes.dex */
public class ValueData {
    public String a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public native String toString();
}
