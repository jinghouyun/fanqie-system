package com.dcloud.zxing2.oned;

import com.dcloud.zxing2.BinaryBitmap;
import com.dcloud.zxing2.ChecksumException;
import com.dcloud.zxing2.DecodeHintType;
import com.dcloud.zxing2.FormatException;
import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.Reader;
import com.dcloud.zxing2.ReaderException;
import com.dcloud.zxing2.Result;
import com.dcloud.zxing2.ResultMetadataType;
import com.dcloud.zxing2.ResultPoint;
import com.dcloud.zxing2.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OneDReader implements Reader {
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2;
        Map<DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i = height >> 1;
        int i2 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, height >> (z ? 8 : 5));
        int i3 = z ? height : 15;
        int i4 = 0;
        while (i4 < i3) {
            i4++;
            int i5 = i4 / 2;
            if ((i4 & 1) != 0) {
                i5 = -i5;
            }
            int i6 = (i5 * iMax) + i;
            if (i6 < 0 || i6 >= height) {
                break;
            }
            try {
                bitArray = binaryBitmap.getBlackRow(i6, bitArray);
                int i7 = 0;
                while (i7 < 2) {
                    if (i7 == i2) {
                        bitArray.reverse();
                        if (map3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        Result resultDecodeRow = decodeRow(i6, bitArray, map3);
                        if (i7 == i2) {
                            try {
                                resultDecodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = resultDecodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    float f = width;
                                    try {
                                        map2 = map3;
                                        try {
                                            try {
                                                resultPoints[0] = new ResultPoint((f - resultPoints[0].getX()) - 1.0f, resultPoints[0].getY());
                                                resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                            } catch (ReaderException unused) {
                                                continue;
                                                i7++;
                                                map3 = map2;
                                                width = width;
                                                i2 = 1;
                                            }
                                        } catch (ReaderException unused2) {
                                            i7++;
                                            map3 = map2;
                                            width = width;
                                            i2 = 1;
                                        }
                                    } catch (ReaderException unused3) {
                                        map2 = map3;
                                    }
                                }
                            } catch (ReaderException unused4) {
                                map2 = map3;
                            }
                        }
                        return resultDecodeRow;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                    }
                }
            } catch (NotFoundException unused6) {
                i2 = 1;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
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

    protected static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !bitArray.get(i);
        while (i < size) {
            if (bitArray.get(i) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    @Override // com.dcloud.zxing2.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws FormatException, NotFoundException {
        return decode(binaryBitmap, null);
    }

    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException, NotFoundException;

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    @Override // com.dcloud.zxing2.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            BinaryBitmap binaryBitmapRotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result resultDoDecode = doDecode(binaryBitmapRotateCounterClockwise, map);
            Map<ResultMetadataType, Object> resultMetadata = resultDoDecode.getResultMetadata();
            int iIntValue = 270;
            if (resultMetadata != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (resultMetadata.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) resultMetadata.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            resultDoDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            ResultPoint[] resultPoints = resultDoDecode.getResultPoints();
            if (resultPoints != null) {
                int height = binaryBitmapRotateCounterClockwise.getHeight();
                for (int i = 0; i < resultPoints.length; i++) {
                    resultPoints[i] = new ResultPoint((height - resultPoints[i].getY()) - 1.0f, resultPoints[i].getX());
                }
            }
            return resultDoDecode;
        }
    }
}
