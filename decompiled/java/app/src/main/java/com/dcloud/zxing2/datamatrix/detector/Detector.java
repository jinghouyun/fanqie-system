package com.dcloud.zxing2.datamatrix.detector;

import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.ResultPoint;
import com.dcloud.zxing2.common.BitMatrix;
import com.dcloud.zxing2.common.DetectorResult;
import com.dcloud.zxing2.common.GridSampler;
import com.dcloud.zxing2.common.detector.MathUtils;
import com.dcloud.zxing2.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        ResultPoint getFrom() {
            return this.from;
        }

        ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private static final class ResultPointsAndTransitionsComparator implements Comparator<ResultPointsAndTransitions>, Serializable {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f = i;
        float fDistance = distance(resultPoint, resultPoint2) / f;
        float fDistance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / fDistance2) * fDistance), resultPoint4.getY() + (fDistance * ((resultPoint4.getY() - resultPoint3.getY()) / fDistance2)));
        float fDistance3 = distance(resultPoint, resultPoint3) / f;
        float fDistance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / fDistance4) * fDistance3), resultPoint4.getY() + (fDistance3 * ((resultPoint4.getY() - resultPoint2.getY()) / fDistance4)));
        if (isValid(resultPoint5)) {
            if (!isValid(resultPoint6) || Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                return resultPoint5;
            }
        } else if (!isValid(resultPoint6)) {
            return null;
        }
        return resultPoint6;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        float fDistance = distance(resultPoint, resultPoint2) / i;
        float fDistance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / fDistance2) * fDistance), resultPoint4.getY() + (fDistance * ((resultPoint4.getY() - resultPoint3.getY()) / fDistance2)));
        float fDistance3 = distance(resultPoint, resultPoint3) / i2;
        float fDistance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / fDistance4) * fDistance3), resultPoint4.getY() + (fDistance3 * ((resultPoint4.getY() - resultPoint2.getY()) / fDistance4)));
        if (isValid(resultPoint5)) {
            if (!isValid(resultPoint6) || Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                return resultPoint5;
            }
        } else if (!isValid(resultPoint6)) {
            return null;
        }
        return resultPoint6;
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i = 0;
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (!z) {
            y = x;
            x = y;
            y2 = x2;
            x2 = y2;
        }
        int iAbs = Math.abs(y2 - y);
        int iAbs2 = Math.abs(x2 - x);
        int i2 = (-iAbs) / 2;
        int i3 = x < x2 ? 1 : -1;
        int i4 = y >= y2 ? -1 : 1;
        boolean z2 = this.image.get(z ? x : y, z ? y : x);
        while (y != y2) {
            boolean z3 = this.image.get(z ? x : y, z ? y : x);
            if (z3 != z2) {
                i++;
                z2 = z3;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (x == x2) {
                    break;
                }
                x += i3;
                i2 -= iAbs;
            }
            y += i4;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DetectorResult detect() throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        BitMatrix bitMatrixSampleGrid;
        ResultPoint[] resultPointArrDetect = this.rectangleDetector.detect();
        ResultPoint resultPoint4 = resultPointArrDetect[0];
        ResultPoint resultPoint5 = resultPointArrDetect[1];
        ResultPoint resultPoint6 = resultPointArrDetect[2];
        ResultPoint resultPoint7 = resultPointArrDetect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint4, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
        arrayList.add(transitionsBetween(resultPoint5, resultPoint7));
        arrayList.add(transitionsBetween(resultPoint6, resultPoint7));
        ResultPoint resultPoint8 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap map = new HashMap();
        increment(map, resultPointsAndTransitions.getFrom());
        increment(map, resultPointsAndTransitions.getTo());
        increment(map, resultPointsAndTransitions2.getFrom());
        increment(map, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint9 = null;
        ResultPoint resultPoint10 = null;
        for (Map.Entry entry : map.entrySet()) {
            ResultPoint resultPoint11 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint9 = resultPoint11;
            } else if (resultPoint8 == null) {
                resultPoint8 = resultPoint11;
            } else {
                resultPoint10 = resultPoint11;
            }
        }
        if (resultPoint8 == null || resultPoint9 == null || resultPoint10 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {resultPoint8, resultPoint9, resultPoint10};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint12 = resultPointArr[0];
        ResultPoint resultPoint13 = resultPointArr[1];
        ResultPoint resultPoint14 = resultPointArr[2];
        if (!map.containsKey(resultPoint4)) {
            resultPoint6 = resultPoint4;
        } else if (!map.containsKey(resultPoint5)) {
            resultPoint6 = resultPoint5;
        } else if (map.containsKey(resultPoint6)) {
            resultPoint6 = resultPoint7;
        }
        int transitions = transitionsBetween(resultPoint14, resultPoint6).getTransitions();
        int transitions2 = transitionsBetween(resultPoint12, resultPoint6).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i2 = transitions2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            resultPoint = resultPoint12;
            ResultPoint resultPointCorrectTopRightRectangular = correctTopRightRectangular(resultPoint13, resultPoint, resultPoint14, resultPoint6, i, i2);
            if (resultPointCorrectTopRightRectangular != null) {
                resultPoint6 = resultPointCorrectTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint14, resultPoint6).getTransitions();
            int transitions4 = transitionsBetween(resultPoint, resultPoint6).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i3 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            resultPoint2 = resultPoint13;
            resultPoint3 = resultPoint14;
            bitMatrixSampleGrid = sampleGrid(this.image, resultPoint3, resultPoint2, resultPoint, resultPoint6, i3, transitions4);
        } else {
            int iMin = Math.min(i2, i);
            resultPoint = resultPoint12;
            ResultPoint resultPointCorrectTopRight = correctTopRight(resultPoint13, resultPoint, resultPoint14, resultPoint6, iMin);
            if (resultPointCorrectTopRight != null) {
                resultPoint6 = resultPointCorrectTopRight;
            }
            int iMax = Math.max(transitionsBetween(resultPoint14, resultPoint6).getTransitions(), transitionsBetween(resultPoint, resultPoint6).getTransitions());
            int i4 = iMax + 1;
            if ((i4 & 1) == 1) {
                i4 = iMax + 2;
            }
            int i5 = i4;
            resultPoint2 = resultPoint13;
            resultPoint3 = resultPoint14;
            bitMatrixSampleGrid = sampleGrid(this.image, resultPoint3, resultPoint2, resultPoint, resultPoint6, i5, i5);
        }
        return new DetectorResult(bitMatrixSampleGrid, new ResultPoint[]{resultPoint3, resultPoint2, resultPoint, resultPoint6});
    }
}
