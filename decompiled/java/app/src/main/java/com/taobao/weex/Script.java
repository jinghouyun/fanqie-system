package com.taobao.weex;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class Script {
    private byte[] mBinary;
    private String mContent;

    public Script(String str) {
        this.mContent = str;
    }

    public byte[] getBinary() {
        return this.mBinary;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean isEmpty() {
        if (!TextUtils.isEmpty(this.mContent)) {
            return false;
        }
        byte[] bArr = this.mBinary;
        return bArr == null || bArr.length == 0;
    }

    public int length() {
        String str = this.mContent;
        if (str != null) {
            return str.length();
        }
        byte[] bArr = this.mBinary;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public Script(byte[] bArr) {
        this.mBinary = bArr;
    }
}
