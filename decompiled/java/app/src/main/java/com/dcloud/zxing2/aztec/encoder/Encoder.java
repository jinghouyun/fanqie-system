package com.dcloud.zxing2.aztec.encoder;

import com.dcloud.zxing2.common.BitArray;
import com.dcloud.zxing2.common.BitMatrix;
import com.dcloud.zxing2.common.reedsolomon.GenericGF;
import com.dcloud.zxing2.common.reedsolomon.ReedSolomonEncoder;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] iArrBitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(iArrBitsToWords, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : iArrBitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i) {
        if (i == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else {
                if (i7 == 0) {
                    bitArray2.appendBits(i4 | 1, i);
                } else {
                    bitArray2.appendBits(i4, i);
                }
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        BitArray bitArrayStuffBits;
        boolean z;
        int iAbs;
        int i3;
        int i4;
        int i5;
        BitArray bitArrayEncode = new HighLevelEncoder(bArr).encode();
        int size = ((bitArrayEncode.getSize() * i) / 100) + 11;
        int size2 = bitArrayEncode.getSize() + size;
        int i6 = 0;
        int i7 = 1;
        if (i2 != 0) {
            z = i2 < 0;
            iAbs = Math.abs(i2);
            if (iAbs > (z ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
            i3 = totalBitsInLayer(iAbs, z);
            i4 = WORD_SIZE[iAbs];
            int i8 = i3 - (i3 % i4);
            bitArrayStuffBits = stuffBits(bitArrayEncode, i4);
            if (bitArrayStuffBits.getSize() + size > i8) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z && bitArrayStuffBits.getSize() > i4 * 64) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        } else {
            BitArray bitArrayStuffBits2 = null;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i9 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z2 = i9 <= 3;
                int i11 = z2 ? i9 + 1 : i9;
                int i12 = totalBitsInLayer(i11, z2);
                if (size2 <= i12) {
                    int i13 = WORD_SIZE[i11];
                    if (i10 != i13) {
                        bitArrayStuffBits2 = stuffBits(bitArrayEncode, i13);
                    } else {
                        i13 = i10;
                    }
                    int i14 = i12 - (i12 % i13);
                    if ((!z2 || bitArrayStuffBits2.getSize() <= i13 * 64) && bitArrayStuffBits2.getSize() + size <= i14) {
                        bitArrayStuffBits = bitArrayStuffBits2;
                        z = z2;
                        iAbs = i11;
                        i3 = i12;
                        i4 = i13;
                        break;
                    }
                    i10 = i13;
                }
                i9++;
                i6 = 0;
                i7 = 1;
            }
        }
        BitArray bitArrayGenerateCheckWords = generateCheckWords(bitArrayStuffBits, i3, i4);
        int size3 = bitArrayStuffBits.getSize() / i4;
        BitArray bitArrayGenerateModeMessage = generateModeMessage(z, iAbs, size3);
        int i15 = iAbs * 4;
        int i16 = z ? i15 + 11 : i15 + 14;
        int[] iArr = new int[i16];
        int i17 = 2;
        if (z) {
            for (int i18 = 0; i18 < i16; i18++) {
                iArr[i18] = i18;
            }
            i5 = i16;
        } else {
            int i19 = i16 / 2;
            i5 = i16 + 1 + (((i19 - 1) / 15) * 2);
            int i20 = i5 / 2;
            for (int i21 = 0; i21 < i19; i21++) {
                int i22 = (i21 / 15) + i21;
                iArr[(i19 - i21) - 1] = (i20 - i22) - 1;
                iArr[i19 + i21] = i22 + i20 + i7;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i5);
        int i23 = 0;
        int i24 = 0;
        while (i23 < iAbs) {
            int i25 = (iAbs - i23) * 4;
            int i26 = z ? i25 + 9 : i25 + 12;
            int i27 = 0;
            while (i27 < i26) {
                int i28 = i27 * 2;
                while (i6 < i17) {
                    if (bitArrayGenerateCheckWords.get(i24 + i28 + i6)) {
                        int i29 = i23 * 2;
                        bitMatrix.set(iArr[i29 + i6], iArr[i29 + i27]);
                    }
                    if (bitArrayGenerateCheckWords.get((i26 * 2) + i24 + i28 + i6)) {
                        int i30 = i23 * 2;
                        bitMatrix.set(iArr[i30 + i27], iArr[((i16 - 1) - i30) - i6]);
                    }
                    if (bitArrayGenerateCheckWords.get((i26 * 4) + i24 + i28 + i6)) {
                        int i31 = (i16 - 1) - (i23 * 2);
                        bitMatrix.set(iArr[i31 - i6], iArr[i31 - i27]);
                    }
                    if (bitArrayGenerateCheckWords.get((i26 * 6) + i24 + i28 + i6)) {
                        int i32 = i23 * 2;
                        bitMatrix.set(iArr[((i16 - 1) - i32) - i27], iArr[i32 + i6]);
                    }
                    i6++;
                    i17 = 2;
                }
                i27++;
                i6 = 0;
                i17 = 2;
            }
            i24 += i26 * 8;
            i23++;
            i6 = 0;
            i17 = 2;
        }
        drawModeMessage(bitMatrix, z, i5, bitArrayGenerateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i5 / 2, 5);
        } else {
            int i33 = i5 / 2;
            drawBullsEye(bitMatrix, i33, 7);
            int i34 = 0;
            int i35 = 0;
            while (i35 < (i16 / 2) - 1) {
                for (int i36 = i33 & 1; i36 < i5; i36 += 2) {
                    int i37 = i33 - i34;
                    bitMatrix.set(i37, i36);
                    int i38 = i33 + i34;
                    bitMatrix.set(i38, i36);
                    bitMatrix.set(i36, i37);
                    bitMatrix.set(i36, i38);
                }
                i35 += 15;
                i34 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i5);
        aztecCode.setLayers(iAbs);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
