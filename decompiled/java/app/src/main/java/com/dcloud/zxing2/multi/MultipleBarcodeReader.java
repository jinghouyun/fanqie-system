package com.dcloud.zxing2.multi;

import com.dcloud.zxing2.BinaryBitmap;
import com.dcloud.zxing2.DecodeHintType;
import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.Result;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface MultipleBarcodeReader {
    Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException;

    Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException;
}
