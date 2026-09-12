package com.dcloud.zxing2.aztec.encoder;

import com.dcloud.zxing2.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
abstract class Token {
    static final Token EMPTY = new SimpleToken(null, 0, 0);
    private final Token previous;

    Token(Token token) {
        this.previous = token;
    }

    final Token add(int i, int i2) {
        return new SimpleToken(this, i, i2);
    }

    final Token addBinaryShift(int i, int i2) {
        return new BinaryShiftToken(this, i, i2);
    }

    abstract void appendTo(BitArray bitArray, byte[] bArr);

    final Token getPrevious() {
        return this.previous;
    }
}
