package com.dcloud.zxing2;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface Reader {
    Result decode(BinaryBitmap binaryBitmap) throws ChecksumException, FormatException, NotFoundException;

    Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException, NotFoundException;

    void reset();
}
