package com.dcloud.zxing2.pdf417.detector;

import com.dcloud.zxing2.BinaryBitmap;
import com.dcloud.zxing2.DecodeHintType;
import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.ResultPoint;
import com.dcloud.zxing2.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> listDetect = detect(z, blackMatrix);
        if (listDetect.isEmpty()) {
            blackMatrix = blackMatrix.rotate90();
            listDetect = detect(z, blackMatrix);
        }
        if (listDetect.isEmpty()) {
            blackMatrix = blackMatrix.rotate90();
            listDetect = detect(z, blackMatrix);
        }
        if (listDetect.isEmpty()) {
            blackMatrix = blackMatrix.rotate90();
            listDetect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, listDetect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (bitMatrix.get(i, i2) ^ z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                int i8 = length - 1;
                if (i6 != i8) {
                    i6++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        boolean z;
        int[] iArr2;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr3 = iArr;
        int[] iArr4 = new int[iArr3.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                i6 = i7;
                z = false;
                break;
            }
            int[] iArrFindGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, false, iArr3, iArr4);
            if (iArrFindGuardPattern != null) {
                do {
                    i6 = i7;
                    iArr2 = iArrFindGuardPattern;
                    if (i6 <= 0) {
                        break;
                    }
                    i7 = i6 - 1;
                    iArrFindGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, false, iArr, iArr4);
                } while (iArrFindGuardPattern != null);
                float f = i6;
                resultPointArr[0] = new ResultPoint(iArr2[0], f);
                resultPointArr[1] = new ResultPoint(iArr2[1], f);
                z = true;
                break;
            }
            i7 += 5;
            iArr3 = iArr;
        }
        int i8 = i6 + 1;
        if (z) {
            int[] iArr5 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i9 = i8;
            int i10 = 0;
            while (i9 < i) {
                int[] iArrFindGuardPattern2 = findGuardPattern(bitMatrix, iArr5[0], i9, i2, false, iArr, iArr4);
                if (iArrFindGuardPattern2 != null && Math.abs(iArr5[0] - iArrFindGuardPattern2[0]) < 5 && Math.abs(iArr5[1] - iArrFindGuardPattern2[1]) < 5) {
                    iArr5 = iArrFindGuardPattern2;
                    i10 = 0;
                } else {
                    if (i10 > 25) {
                        break;
                    }
                    i10++;
                }
                i9++;
            }
            i8 = i9 - (i10 + 1);
            float f2 = i8;
            resultPointArr[2] = new ResultPoint(iArr5[0], f2);
            resultPointArr[3] = new ResultPoint(iArr5[1], f2);
        }
        if (i8 - i6 < 10) {
            for (i5 = 0; i5 < 4; i5++) {
                resultPointArr[i5] = null;
            }
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        int y = i;
        int i3 = i2;
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, y, i3, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint resultPoint = resultPointArr[4];
        if (resultPoint != null) {
            int x = (int) resultPoint.getX();
            y = (int) resultPointArr[4].getY();
            i3 = x;
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, y, i3, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    private static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        int x;
        float y;
        ArrayList arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i = 0;
            boolean z2 = false;
            while (iMax < bitMatrix.getHeight()) {
                ResultPoint[] resultPointArrFindVertices = findVertices(bitMatrix, iMax, i);
                if (resultPointArrFindVertices[0] != null || resultPointArrFindVertices[3] != null) {
                    arrayList.add(resultPointArrFindVertices);
                    if (!z) {
                        break loop0;
                    }
                    ResultPoint resultPoint = resultPointArrFindVertices[2];
                    if (resultPoint != null) {
                        x = (int) resultPoint.getX();
                        y = resultPointArrFindVertices[2].getY();
                    } else {
                        x = (int) resultPointArrFindVertices[4].getX();
                        y = resultPointArrFindVertices[4].getY();
                    }
                    iMax = (int) y;
                    i = x;
                    z2 = true;
                } else {
                    if (!z2) {
                        break;
                    }
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ResultPoint[] resultPointArr = (ResultPoint[]) obj;
                        ResultPoint resultPoint2 = resultPointArr[1];
                        if (resultPoint2 != null) {
                            iMax = (int) Math.max(iMax, resultPoint2.getY());
                        }
                        ResultPoint resultPoint3 = resultPointArr[3];
                        if (resultPoint3 != null) {
                            iMax = Math.max(iMax, (int) resultPoint3.getY());
                        }
                    }
                    iMax += 5;
                }
            }
            break loop0;
        }
        return arrayList;
    }
}
