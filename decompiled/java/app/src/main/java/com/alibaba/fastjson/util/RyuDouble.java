package com.alibaba.fastjson.util;

import com.taobao.weex.el.parse.Operators;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public final class RyuDouble {
    private static final int[][] POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 326, 4);
    private static final int[][] POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 291, 4);

    static {
        BigInteger bigIntegerSubtract = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        BigInteger bigIntegerSubtract2 = BigInteger.ONE.shiftLeft(31).subtract(BigInteger.ONE);
        int i = 0;
        while (i < 326) {
            BigInteger bigIntegerPow = BigInteger.valueOf(5L).pow(i);
            int iBitLength = bigIntegerPow.bitLength();
            int i2 = i == 0 ? 1 : (int) (((((long) i) * 23219280) + 9999999) / 10000000);
            if (i2 != iBitLength) {
                throw new IllegalStateException(iBitLength + " != " + i2);
            }
            if (i < POW5_SPLIT.length) {
                for (int i3 = 0; i3 < 4; i3++) {
                    POW5_SPLIT[i][i3] = bigIntegerPow.shiftRight((iBitLength - 121) + ((3 - i3) * 31)).and(bigIntegerSubtract).intValue();
                }
            }
            if (i < POW5_INV_SPLIT.length) {
                BigInteger bigIntegerAdd = BigInteger.ONE.shiftLeft(iBitLength + 121).divide(bigIntegerPow).add(BigInteger.ONE);
                for (int i4 = 0; i4 < 4; i4++) {
                    if (i4 == 0) {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).intValue();
                    } else {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).and(bigIntegerSubtract2).intValue();
                    }
                }
            }
            i++;
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    /* JADX WARN: Code duplicated, block: B:118:0x02d6  */
    public static int toString(double d, char[] cArr, int i) {
        int i2;
        long j;
        boolean z;
        boolean z2;
        long j2;
        char c;
        long j3;
        long j4;
        int iMax;
        boolean z3;
        long j5;
        boolean z4;
        long j6;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (!Double.isNaN(d)) {
            if (d == Double.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                i6 = i + 8;
                cArr[i + 7] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                cArr[i] = '-';
                cArr[i + 1] = 'I';
                cArr[i + 2] = 'n';
                cArr[i + 3] = 'f';
                cArr[i + 4] = 'i';
                cArr[i + 5] = 'n';
                cArr[i + 6] = 'i';
                cArr[i + 7] = 't';
                i10 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(d);
                if (jDoubleToLongBits == 0) {
                    cArr[i] = '0';
                    cArr[i + 1] = Operators.DOT;
                    i10 = i + 3;
                    cArr[i + 2] = '0';
                } else if (jDoubleToLongBits == Long.MIN_VALUE) {
                    cArr[i] = '-';
                    cArr[i + 1] = '0';
                    cArr[i + 2] = Operators.DOT;
                    i6 = i + 4;
                    cArr[i + 3] = '0';
                } else {
                    int i11 = (int) ((jDoubleToLongBits >>> 52) & 2047);
                    long j7 = jDoubleToLongBits & 4503599627370495L;
                    if (i11 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = i11 - 1075;
                        j7 |= 4503599627370496L;
                    }
                    boolean z5 = jDoubleToLongBits < 0;
                    boolean z6 = (j7 & 1) == 0;
                    long j8 = 4 * j7;
                    long j9 = j8 + 2;
                    int i12 = (j7 != 4503599627370496L || i11 <= 1) ? 1 : 0;
                    long j10 = (j8 - 1) - ((long) i12);
                    int i13 = i2 - 2;
                    int i14 = 3;
                    if (i13 >= 0) {
                        j2 = 10000000;
                        iMax = Math.max(0, ((int) ((((long) i13) * 3010299) / 10000000)) - 1);
                        int i15 = (((-i13) + iMax) + ((iMax == 0 ? 1 : (int) (((((long) iMax) * 23219280) + 9999999) / 10000000)) + 121)) - 114;
                        if (i15 < 0) {
                            throw new IllegalArgumentException("" + i15);
                        }
                        int[] iArr = POW5_INV_SPLIT[iMax];
                        long j11 = j8 >>> 31;
                        long j12 = j8 & 2147483647L;
                        int i16 = iArr[0];
                        j = 0;
                        z = z5;
                        c = '0';
                        int i17 = iArr[1];
                        z2 = z6;
                        int i18 = iArr[2];
                        int i19 = iArr[3];
                        long j13 = ((((((((((((j12 * ((long) i19)) >>> 31) + (((long) i18) * j12)) + (j11 * ((long) i19))) >>> 31) + (((long) i17) * j12)) + (((long) i18) * j11)) >>> 31) + (((long) i16) * j12)) + (((long) i17) * j11)) >>> 21) + ((((long) i16) * j11) << 10)) >>> i15;
                        long j14 = j9 >>> 31;
                        long j15 = j9 & 2147483647L;
                        long j16 = ((((((((((((j15 * ((long) i19)) >>> 31) + (((long) i18) * j15)) + (j14 * ((long) i19))) >>> 31) + (((long) i17) * j15)) + (((long) i18) * j14)) >>> 31) + (((long) i16) * j15)) + (((long) i17) * j14)) >>> 21) + ((((long) i16) * j14) << 10)) >>> i15;
                        long j17 = j10 >>> 31;
                        long j18 = j10 & 2147483647L;
                        j4 = ((((((((((((j18 * ((long) i19)) >>> 31) + (((long) i18) * j18)) + (j17 * ((long) i19))) >>> 31) + (((long) i17) * j18)) + (((long) i18) * j17)) >>> 31) + (((long) i16) * j18)) + (((long) i17) * j17)) >>> 21) + ((((long) i16) * j17) << 10)) >>> i15;
                        if (iMax <= 21) {
                            long j19 = j8 % 5;
                            if (j19 == 0) {
                                if (j19 != 0) {
                                    i9 = 0;
                                } else if (j8 % 25 != 0) {
                                    i9 = 1;
                                } else if (j8 % 125 != 0) {
                                    i9 = 2;
                                } else if (j8 % 625 != 0) {
                                    i9 = 3;
                                } else {
                                    long j20 = j8 / 625;
                                    i9 = 4;
                                    while (j20 > 0 && j20 % 5 == 0) {
                                        j20 /= 5;
                                        i9++;
                                    }
                                }
                                z3 = i9 >= iMax;
                                j5 = j16;
                                z4 = false;
                            } else if (z2) {
                                if (j10 % 5 != 0) {
                                    i8 = 0;
                                } else if (j10 % 25 != 0) {
                                    i8 = 1;
                                } else if (j10 % 125 != 0) {
                                    i8 = 2;
                                } else if (j10 % 625 != 0) {
                                    i8 = 3;
                                } else {
                                    long j21 = j10 / 625;
                                    i8 = 4;
                                    while (j21 > 0 && j21 % 5 == 0) {
                                        j21 /= 5;
                                        i8++;
                                    }
                                }
                                z4 = i8 >= iMax;
                                j5 = j16;
                                z3 = false;
                            } else {
                                if (j9 % 5 != 0) {
                                    i7 = 0;
                                } else if (j9 % 25 != 0) {
                                    i7 = 1;
                                } else if (j9 % 125 != 0) {
                                    i7 = 2;
                                } else if (j9 % 625 != 0) {
                                    i7 = 3;
                                } else {
                                    long j22 = j9 / 625;
                                    i7 = 4;
                                    while (j22 > 0 && j22 % 5 == 0) {
                                        j22 /= 5;
                                        i7++;
                                    }
                                }
                                if (i7 >= iMax) {
                                    j5 = j16 - 1;
                                } else {
                                    j5 = j16;
                                }
                                z3 = false;
                                z4 = false;
                            }
                        } else {
                            j5 = j16;
                            z3 = false;
                            z4 = false;
                        }
                        j3 = j13;
                    } else {
                        j = 0;
                        z = z5;
                        z2 = z6;
                        j2 = 10000000;
                        c = '0';
                        int i20 = -i13;
                        int iMax2 = Math.max(0, ((int) ((((long) i20) * 6989700) / 10000000)) - 1);
                        int i21 = i20 - iMax2;
                        int i22 = (iMax2 - ((i21 == 0 ? 1 : (int) (((((long) i21) * 23219280) + 9999999) / 10000000)) - 121)) - 114;
                        if (i22 < 0) {
                            throw new IllegalArgumentException("" + i22);
                        }
                        int[] iArr2 = POW5_SPLIT[i21];
                        long j23 = j8 >>> 31;
                        long j24 = j8 & 2147483647L;
                        int i23 = iArr2[0];
                        long j25 = ((long) i23) * j23;
                        int i24 = iArr2[1];
                        long j26 = ((long) i24) * j23;
                        int i25 = iArr2[2];
                        long j27 = ((long) i25) * j23;
                        int i26 = iArr2[3];
                        long j28 = ((((((((((((j24 * ((long) i26)) >>> 31) + (((long) i25) * j24)) + (((long) i26) * j23)) >>> 31) + (((long) i24) * j24)) + j27) >>> 31) + (((long) i23) * j24)) + j26) >>> 21) + (j25 << 10)) >>> i22;
                        long j29 = j9 >>> 31;
                        long j30 = j9 & 2147483647L;
                        j3 = j28;
                        long j31 = ((((((((((((j30 * ((long) i26)) >>> 31) + (((long) i25) * j30)) + (j29 * ((long) i26))) >>> 31) + (((long) i24) * j30)) + (((long) i25) * j29)) >>> 31) + (((long) i23) * j30)) + (((long) i24) * j29)) >>> 21) + ((((long) i23) * j29) << 10)) >>> i22;
                        long j32 = j10 >>> 31;
                        long j33 = j10 & 2147483647L;
                        j4 = ((((((((((((j33 * ((long) i26)) >>> 31) + (((long) i25) * j33)) + (j32 * ((long) i26))) >>> 31) + (((long) i24) * j33)) + (((long) i25) * j32)) >>> 31) + (((long) i23) * j33)) + (((long) i24) * j32)) >>> 21) + ((((long) i23) * j32) << 10)) >>> i22;
                        iMax = iMax2 + i13;
                        z3 = true;
                        if (iMax2 <= 1) {
                            if (z2) {
                                boolean z7 = i12 == 1;
                                iMax = iMax;
                                j4 = j4;
                                j5 = j31;
                                z4 = z7;
                            } else {
                                j5 = j31 - 1;
                            }
                        } else if (iMax2 < 63) {
                            z3 = (((1 << (iMax2 - 1)) - 1) & j8) == 0;
                            j5 = j31;
                        } else {
                            j5 = j31;
                            z3 = false;
                        }
                        z4 = false;
                    }
                    if (j5 >= 1000000000000000000L) {
                        i14 = 19;
                    } else if (j5 >= 100000000000000000L) {
                        i14 = 18;
                    } else if (j5 >= 10000000000000000L) {
                        i14 = 17;
                    } else if (j5 >= 1000000000000000L) {
                        i14 = 16;
                    } else if (j5 >= 100000000000000L) {
                        i14 = 15;
                    } else if (j5 >= 10000000000000L) {
                        i14 = 14;
                    } else if (j5 >= 1000000000000L) {
                        i14 = 13;
                    } else if (j5 >= 100000000000L) {
                        i14 = 12;
                    } else if (j5 >= 10000000000L) {
                        i14 = 11;
                    } else if (j5 >= 1000000000) {
                        i14 = 10;
                    } else if (j5 >= 100000000) {
                        i14 = 9;
                    } else if (j5 >= j2) {
                        i14 = 8;
                    } else if (j5 >= 1000000) {
                        i14 = 7;
                    } else if (j5 >= 100000) {
                        i14 = 6;
                    } else if (j5 >= 10000) {
                        i14 = 5;
                    } else if (j5 >= 1000) {
                        i14 = 4;
                    } else if (j5 < 100) {
                        i14 = j5 >= 10 ? 2 : 1;
                    }
                    int i27 = iMax + i14;
                    int i28 = i27 - 1;
                    boolean z8 = i28 < -3 || i28 >= 7;
                    if (z4 || z3) {
                        int i29 = 0;
                        int i30 = 0;
                        while (true) {
                            long j34 = j5 / 10;
                            long j35 = j4 / 10;
                            if (j34 <= j35 || (j5 < 100 && z8)) {
                                break;
                            }
                            z4 &= j4 % 10 == j;
                            z3 &= i29 == 0;
                            i29 = (int) (j3 % 10);
                            j3 /= 10;
                            i30++;
                            j5 = j34;
                            j4 = j35;
                        }
                        if (z4 && z2) {
                            while (j4 % 10 == j && (j5 >= 100 || !z8)) {
                                z3 &= i29 == 0;
                                i29 = (int) (j3 % 10);
                                j5 /= 10;
                                j3 /= 10;
                                j4 /= 10;
                                i30++;
                            }
                        }
                        if (z3 && i29 == 5 && j3 % 2 == j) {
                            i29 = 4;
                        }
                        j6 = j3 + ((long) (((j3 != j4 || (z4 && z2)) && i29 < 5) ? 0 : 1));
                        i3 = i30;
                    } else {
                        i3 = 0;
                        int i31 = 0;
                        while (true) {
                            long j36 = j5 / 10;
                            long j37 = j4 / 10;
                            if (j36 <= j37 || (j5 < 100 && z8)) {
                                break;
                            }
                            i31 = (int) (j3 % 10);
                            j3 /= 10;
                            i3++;
                            j5 = j36;
                            j4 = j37;
                        }
                        j6 = j3 + ((long) ((j3 == j4 || i31 >= 5) ? 1 : 0));
                    }
                    int i32 = i14 - i3;
                    if (z) {
                        i4 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i4 = i;
                    }
                    if (!z8) {
                        if (i28 < 0) {
                            int i33 = i4 + 1;
                            cArr[i4] = c;
                            int i34 = i4 + 2;
                            cArr[i33] = Operators.DOT;
                            int i35 = -1;
                            while (i35 > i28) {
                                cArr[i34] = c;
                                i35--;
                                i34++;
                            }
                            i5 = i34;
                            for (int i36 = 0; i36 < i32; i36++) {
                                cArr[((i34 + i32) - i36) - 1] = (char) ((j6 % 10) + 48);
                                j6 /= 10;
                                i5++;
                            }
                        } else if (i27 >= i32) {
                            for (int i37 = 0; i37 < i32; i37++) {
                                cArr[((i4 + i32) - i37) - 1] = (char) ((j6 % 10) + 48);
                                j6 /= 10;
                            }
                            int i38 = i4 + i32;
                            while (i32 < i27) {
                                cArr[i38] = c;
                                i32++;
                                i38++;
                            }
                            cArr[i38] = Operators.DOT;
                            i5 = i38 + 2;
                            cArr[i38 + 1] = c;
                        } else {
                            int i39 = i4 + 1;
                            for (int i40 = 0; i40 < i32; i40++) {
                                if ((i32 - i40) - 1 == i28) {
                                    cArr[((i39 + i32) - i40) - 1] = Operators.DOT;
                                    i39--;
                                }
                                cArr[((i39 + i32) - i40) - 1] = (char) ((j6 % 10) + 48);
                                j6 /= 10;
                            }
                            i5 = i4 + i32 + 1;
                        }
                        return i5 - i;
                    }
                    for (int i41 = 0; i41 < i32 - 1; i41++) {
                        int i42 = (int) (j6 % 10);
                        j6 /= 10;
                        cArr[(i4 + i32) - i41] = (char) (i42 + 48);
                    }
                    cArr[i4] = (char) ((j6 % 10) + 48);
                    cArr[i4 + 1] = Operators.DOT;
                    int i43 = i4 + i32 + 1;
                    if (i32 == 1) {
                        cArr[i43] = c;
                        i43++;
                    }
                    int i44 = i43 + 1;
                    cArr[i43] = 'E';
                    if (i28 < 0) {
                        cArr[i44] = '-';
                        i28 = -i28;
                        i44 = i43 + 2;
                    }
                    if (i28 >= 100) {
                        int i45 = i44 + 1;
                        cArr[i44] = (char) ((i28 / 100) + 48);
                        i28 %= 100;
                        i44 += 2;
                        cArr[i45] = (char) ((i28 / 10) + 48);
                    } else if (i28 >= 10) {
                        cArr[i44] = (char) ((i28 / 10) + 48);
                        i44++;
                    }
                    i6 = i44 + 1;
                    cArr[i44] = (char) ((i28 % 10) + 48);
                }
            }
            return i6 - i;
        }
        cArr[i] = 'N';
        cArr[i + 1] = 'a';
        i10 = i + 3;
        cArr[i + 2] = 'N';
        return i10 - i;
    }
}
