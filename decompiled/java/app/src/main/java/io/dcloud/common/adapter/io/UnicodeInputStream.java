package io.dcloud.common.adapter.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class UnicodeInputStream extends InputStream {
    private static final int BOM_SIZE = 4;
    String defaultEnc;
    String encoding;
    PushbackInputStream internalIn;
    boolean isInited = false;

    public UnicodeInputStream(InputStream inputStream, String str) {
        this.internalIn = new PushbackInputStream(inputStream, 4);
        this.defaultEnc = str;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.isInited = true;
        this.internalIn.close();
    }

    public String getDefaultEncoding() {
        return this.defaultEnc;
    }

    public String getEncoding() throws Throwable {
        if (!this.isInited) {
            try {
                init();
            } catch (IOException unused) {
                Throwable illegalStateException = new IllegalStateException("Init method failed.");
                illegalStateException.initCause(illegalStateException);
                throw illegalStateException;
            }
        }
        return this.encoding;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    protected void init() throws IOException {
        int i;
        if (this.isInited) {
            return;
        }
        byte[] bArr = new byte[4];
        int i2 = this.internalIn.read(bArr, 0, 4);
        byte b = bArr[0];
        if (b != 0 || bArr[1] != 0 || bArr[2] != -2 || bArr[3] != -1) {
            if (b == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0) {
                this.encoding = "UTF-32LE";
            } else if (b == -17 && bArr[1] == -69 && bArr[2] == -65) {
                this.encoding = "UTF-8";
                i = i2 - 3;
            } else {
                if (b == -2 && bArr[1] == -1) {
                    this.encoding = "UTF-16BE";
                } else if (b == -1 && bArr[1] == -2) {
                    this.encoding = "UTF-16LE";
                } else {
                    this.encoding = this.defaultEnc;
                    i = i2;
                }
                i = i2 - 2;
            }
            if (i > 0) {
                this.internalIn.unread(bArr, i2 - i, i);
            }
            this.isInited = true;
        }
        this.encoding = "UTF-32BE";
        i = i2 - 4;
        if (i > 0) {
            this.internalIn.unread(bArr, i2 - i, i);
        }
        this.isInited = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        init();
        this.isInited = true;
        return this.internalIn.read();
    }
}
