package com.dcloud.zxing2.oned;

import com.dcloud.zxing2.BarcodeFormat;
import com.dcloud.zxing2.BinaryBitmap;
import com.dcloud.zxing2.ChecksumException;
import com.dcloud.zxing2.DecodeHintType;
import com.dcloud.zxing2.FormatException;
import com.dcloud.zxing2.NotFoundException;
import com.dcloud.zxing2.Result;
import com.dcloud.zxing2.common.BitArray;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class UPCAReader extends UPCEANReader {
    private final UPCEANReader ean13Reader = new EAN13Reader();

    private static Result maybeReturnResult(Result result) throws FormatException {
        String text = result.getText();
        if (text.charAt(0) == '0') {
            return new Result(text.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws FormatException, NotFoundException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    protected int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.ean13Reader.decodeMiddle(bitArray, iArr, sb);
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException, NotFoundException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, iArr, map));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader, com.dcloud.zxing2.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException, NotFoundException {
        return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, map));
    }
}
