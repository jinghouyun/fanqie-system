package com.dcloud.zxing2.aztec;

import com.dcloud.zxing2.BarcodeFormat;
import com.dcloud.zxing2.BinaryBitmap;
import com.dcloud.zxing2.DecodeHintType;
import com.dcloud.zxing2.FormatException;
import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.Reader;
import com.dcloud.zxing2.Result;
import com.dcloud.zxing2.ResultMetadataType;
import com.dcloud.zxing2.ResultPoint;
import com.dcloud.zxing2.ResultPointCallback;
import com.dcloud.zxing2.aztec.decoder.Decoder;
import com.dcloud.zxing2.aztec.detector.Detector;
import com.dcloud.zxing2.common.DecoderResult;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class AztecReader implements Reader {
    @Override // com.dcloud.zxing2.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws FormatException, NotFoundException {
        return decode(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    @Override // com.dcloud.zxing2.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        ResultPoint[] points;
        ResultPoint[] points2;
        FormatException formatException;
        ResultPointCallback resultPointCallback;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        DecoderResult decoderResultDecode = null;
        try {
            AztecDetectorResult aztecDetectorResultDetect = detector.detect(false);
            points = aztecDetectorResultDetect.getPoints();
            try {
                points2 = points;
                formatException = null;
                decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect);
                e = null;
            } catch (FormatException e) {
                e = e;
                points2 = points;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                points2 = points;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            points = null;
        } catch (NotFoundException e4) {
            e = e4;
            points = null;
        }
        if (decoderResultDecode == null) {
            try {
                AztecDetectorResult aztecDetectorResultDetect2 = detector.detect(true);
                points2 = aztecDetectorResultDetect2.getPoints();
                decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : points2) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        Result result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points2, BarcodeFormat.AZTEC);
        List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }
}
