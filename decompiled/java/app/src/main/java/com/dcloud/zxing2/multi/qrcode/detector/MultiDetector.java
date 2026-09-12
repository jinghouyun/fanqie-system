package com.dcloud.zxing2.multi.qrcode.detector;

import com.dcloud.zxing2.DecodeHintType;
import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.ReaderException;
import com.dcloud.zxing2.ResultPointCallback;
import com.dcloud.zxing2.common.BitMatrix;
import com.dcloud.zxing2.common.DetectorResult;
import com.dcloud.zxing2.qrcode.detector.Detector;
import com.dcloud.zxing2.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiDetector extends Detector {
    private static final DetectorResult[] EMPTY_DETECTOR_RESULTS = new DetectorResult[0];

    public MultiDetector(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public DetectorResult[] detectMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        FinderPatternInfo[] finderPatternInfoArrFindMulti = new MultiFinderPatternFinder(getImage(), map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).findMulti(map);
        if (finderPatternInfoArrFindMulti.length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (FinderPatternInfo finderPatternInfo : finderPatternInfoArrFindMulti) {
            try {
                arrayList.add(processFinderPatternInfo(finderPatternInfo));
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? EMPTY_DETECTOR_RESULTS : (DetectorResult[]) arrayList.toArray(new DetectorResult[arrayList.size()]);
    }
}
