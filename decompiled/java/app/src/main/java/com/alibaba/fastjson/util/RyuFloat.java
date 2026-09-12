package com.alibaba.fastjson.util;

import com.taobao.weex.el.parse.Operators;
import kotlin.time.InstantKt;

/* JADX INFO: loaded from: classes.dex */
public final class RyuFloat {
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{InstantKt.NANOS_PER_SECOND, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10;
        long j;
        int i11;
        int i12;
        int i13;
        int i14;
        if (!Float.isNaN(f)) {
            if (f == Float.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                i13 = i + 8;
                cArr[i + 7] = 'y';
            } else if (f == Float.NEGATIVE_INFINITY) {
                cArr[i] = '-';
                cArr[i + 1] = 'I';
                cArr[i + 2] = 'n';
                cArr[i + 3] = 'f';
                cArr[i + 4] = 'i';
                cArr[i + 5] = 'n';
                cArr[i + 6] = 'i';
                cArr[i + 7] = 't';
                i14 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                int iFloatToIntBits = Float.floatToIntBits(f);
                if (iFloatToIntBits == 0) {
                    cArr[i] = '0';
                    cArr[i + 1] = Operators.DOT;
                    i14 = i + 3;
                    cArr[i + 2] = '0';
                } else if (iFloatToIntBits == Integer.MIN_VALUE) {
                    cArr[i] = '-';
                    cArr[i + 1] = '0';
                    cArr[i + 2] = Operators.DOT;
                    i13 = i + 4;
                    cArr[i + 3] = '0';
                } else {
                    int i15 = (iFloatToIntBits >> 23) & 255;
                    int i16 = 8388607 & iFloatToIntBits;
                    if (i15 == 0) {
                        i2 = -149;
                    } else {
                        i2 = i15 - 150;
                        i16 |= 8388608;
                    }
                    boolean z4 = iFloatToIntBits < 0;
                    boolean z5 = (i16 & 1) == 0;
                    int i17 = i16 * 4;
                    int i18 = i17 + 2;
                    int i19 = i17 - ((((long) i16) != 8388608 || i15 <= 1) ? 2 : 1);
                    int i20 = i2 - 2;
                    if (i20 >= 0) {
                        c = '-';
                        i6 = (int) ((((long) i20) * 3010299) / 10000000);
                        if (i6 == 0) {
                            i11 = 1;
                            j = 9999999;
                        } else {
                            j = 9999999;
                            i11 = (int) (((((long) i6) * 23219280) + 9999999) / 10000000);
                        }
                        int i21 = (-i20) + i6;
                        int[][] iArr = POW5_INV_SPLIT;
                        int[] iArr2 = iArr[i6];
                        c2 = '0';
                        long j2 = iArr2[0];
                        long j3 = iArr2[1];
                        long j4 = i17;
                        int i22 = ((i11 + 58) + i21) - 31;
                        int i23 = (int) (((j4 * j2) + ((j4 * j3) >> 31)) >> i22);
                        long j5 = i18;
                        int i24 = (int) (((j5 * j2) + ((j5 * j3) >> 31)) >> i22);
                        long j6 = i19;
                        int i25 = (int) (((j2 * j6) + ((j6 * j3) >> 31)) >> i22);
                        if (i6 == 0 || (i24 - 1) / 10 > i25 / 10) {
                            i12 = 0;
                        } else {
                            int i26 = i6 - 1;
                            int i27 = i26 == 0 ? 1 : (int) (((((long) i26) * 23219280) + j) / 10000000);
                            int[] iArr3 = iArr[i26];
                            i12 = (int) ((((((long) iArr3[0]) * j4) + ((j4 * ((long) iArr3[1])) >> 31)) >> (((i21 - 1) + (i27 + 58)) - 31)) % 10);
                        }
                        int i28 = 0;
                        while (i18 > 0 && i18 % 5 == 0) {
                            i18 /= 5;
                            i28++;
                        }
                        int i29 = 0;
                        while (i17 > 0 && i17 % 5 == 0) {
                            i17 /= 5;
                            i29++;
                        }
                        int i30 = 0;
                        while (i19 > 0 && i19 % 5 == 0) {
                            i19 /= 5;
                            i30++;
                        }
                        z3 = i28 >= i6;
                        boolean z6 = i29 >= i6;
                        z2 = i30 >= i6;
                        i3 = i23;
                        z = z6;
                        i7 = i12;
                        i8 = i24;
                        i4 = i25;
                    } else {
                        c = '-';
                        c2 = '0';
                        int i31 = -i20;
                        int i32 = (int) ((((long) i31) * 6989700) / 10000000);
                        int i33 = i31 - i32;
                        int i34 = i33 == 0 ? 1 : (int) (((((long) i33) * 23219280) + 9999999) / 10000000);
                        int[][] iArr4 = POW5_SPLIT;
                        int[] iArr5 = iArr4[i33];
                        long j7 = iArr5[0];
                        long j8 = iArr5[1];
                        int i35 = (i32 - (i34 - 61)) - 31;
                        long j9 = i17;
                        i3 = (int) (((j9 * j7) + ((j9 * j8) >> 31)) >> i35);
                        long j10 = i18;
                        int i36 = (int) (((j10 * j7) + ((j10 * j8) >> 31)) >> i35);
                        long j11 = i19;
                        i4 = (int) (((j7 * j11) + ((j11 * j8) >> 31)) >> i35);
                        if (i32 == 0 || (i36 - 1) / 10 > i4 / 10) {
                            i5 = 0;
                        } else {
                            int i37 = i33 + 1;
                            int i38 = i32 - 1;
                            int i39 = i37 == 0 ? 1 : (int) (((((long) i37) * 23219280) + 9999999) / 10000000);
                            int[] iArr6 = iArr4[i37];
                            i5 = (int) ((((((long) iArr6[0]) * j9) + ((((long) iArr6[1]) * j9) >> 31)) >> ((i38 - (i39 - 61)) - 31)) % 10);
                        }
                        i6 = i32 + i20;
                        boolean z7 = 1 >= i32;
                        z = i32 < 23 && (((1 << (i32 + (-1))) - 1) & i17) == 0;
                        z2 = (i19 % 2 == 1 ? 0 : 1) >= i32;
                        i7 = i5;
                        z3 = z7;
                        i8 = i36;
                    }
                    int i40 = InstantKt.NANOS_PER_SECOND;
                    int i41 = 10;
                    while (i41 > 0 && i8 < i40) {
                        i40 /= 10;
                        i41--;
                    }
                    int i42 = i6 + i41;
                    int i43 = i42 - 1;
                    boolean z8 = i43 < -3 || i43 >= 7;
                    if (z3 && !z5) {
                        i8--;
                    }
                    int i44 = 0;
                    while (true) {
                        int i45 = i8 / 10;
                        int i46 = i4 / 10;
                        if (i45 <= i46 || (i8 < 100 && z8)) {
                            break;
                        }
                        z2 &= i4 % 10 == 0;
                        i7 = i3 % 10;
                        i3 /= 10;
                        i44++;
                        i8 = i45;
                        i4 = i46;
                    }
                    if (z2 && z5) {
                        while (i4 % 10 == 0 && (i8 >= 100 || !z8)) {
                            i8 /= 10;
                            i7 = i3 % 10;
                            i3 /= 10;
                            i4 /= 10;
                            i44++;
                        }
                    }
                    if (z && i7 == 5 && i3 % 2 == 0) {
                        i7 = 4;
                    }
                    int i47 = i3 + (((i3 != i4 || (z2 && z5)) && i7 < 5) ? 0 : 1);
                    int i48 = i41 - i44;
                    if (z4) {
                        i9 = i + 1;
                        cArr[i] = c;
                    } else {
                        i9 = i;
                    }
                    if (z8) {
                        for (int i49 = 0; i49 < i48 - 1; i49++) {
                            int i50 = i47 % 10;
                            i47 /= 10;
                            cArr[(i9 + i48) - i49] = (char) (i50 + 48);
                        }
                        cArr[i9] = (char) ((i47 % 10) + 48);
                        cArr[i9 + 1] = Operators.DOT;
                        int i51 = i9 + i48 + 1;
                        if (i48 == 1) {
                            cArr[i51] = c2;
                            i51++;
                        }
                        int i52 = i51 + 1;
                        cArr[i51] = 'E';
                        if (i43 < 0) {
                            cArr[i52] = c;
                            i43 = -i43;
                            i52 = i51 + 2;
                        }
                        if (i43 >= 10) {
                            cArr[i52] = (char) ((i43 / 10) + 48);
                            i52++;
                        }
                        i10 = i52 + 1;
                        cArr[i52] = (char) ((i43 % 10) + 48);
                    } else if (i43 < 0) {
                        int i53 = i9 + 1;
                        cArr[i9] = c2;
                        int i54 = i9 + 2;
                        cArr[i53] = Operators.DOT;
                        int i55 = -1;
                        while (i55 > i43) {
                            cArr[i54] = c2;
                            i55--;
                            i54++;
                        }
                        int i56 = i54;
                        for (int i57 = 0; i57 < i48; i57++) {
                            cArr[((i54 + i48) - i57) - 1] = (char) ((i47 % 10) + 48);
                            i47 /= 10;
                            i56++;
                        }
                        i10 = i56;
                    } else if (i42 >= i48) {
                        for (int i58 = 0; i58 < i48; i58++) {
                            cArr[((i9 + i48) - i58) - 1] = (char) ((i47 % 10) + 48);
                            i47 /= 10;
                        }
                        int i59 = i9 + i48;
                        while (i48 < i42) {
                            cArr[i59] = c2;
                            i48++;
                            i59++;
                        }
                        int i60 = i59 + 1;
                        cArr[i59] = Operators.DOT;
                        i10 = i59 + 2;
                        cArr[i60] = c2;
                    } else {
                        int i61 = i9 + 1;
                        for (int i62 = 0; i62 < i48; i62++) {
                            if ((i48 - i62) - 1 == i43) {
                                cArr[((i61 + i48) - i62) - 1] = Operators.DOT;
                                i61--;
                            }
                            cArr[((i61 + i48) - i62) - 1] = (char) ((i47 % 10) + 48);
                            i47 /= 10;
                        }
                        i10 = i9 + i48 + 1;
                    }
                    return i10 - i;
                }
            }
            return i13 - i;
        }
        cArr[i] = 'N';
        cArr[i + 1] = 'a';
        i14 = i + 3;
        cArr[i + 2] = 'N';
        return i14 - i;
    }
}
