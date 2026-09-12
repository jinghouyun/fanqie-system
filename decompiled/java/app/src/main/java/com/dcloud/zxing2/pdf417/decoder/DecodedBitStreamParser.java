package com.dcloud.zxing2.pdf417.decoder;

import com.dcloud.zxing2.FormatException;
import com.dcloud.zxing2.common.CharacterSetECI;
import com.dcloud.zxing2.common.DecoderResult;
import com.dcloud.zxing2.pdf417.PDF417ResultMetadata;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.utils.WXUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = {';', Typography.less, Typography.greater, TemplateDom.SEPARATOR, Operators.ARRAY_START, '\\', Operators.ARRAY_END, '_', '`', '~', '!', '\r', '\t', Operators.ARRAY_SEPRATOR, Operators.CONDITION_IF_MIDDLE, '\n', '-', Operators.DOT, '$', '/', '\"', '|', '*', Operators.BRACKET_START, Operators.BRACKET_END, Operators.CONDITION_IF, Operators.BLOCK_START, Operators.BLOCK_END, Operators.SINGLE_QUOTE};
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', Typography.amp, '\r', '\t', Operators.ARRAY_SEPRATOR, Operators.CONDITION_IF_MIDDLE, '#', '-', Operators.DOT, '$', '/', '+', WXUtils.PERCENT, '*', '=', '^'};
    private static final Charset DEFAULT_ENCODING = Charset.forName(InternalZipConstants.AES_HASH_CHARSET);

    /* JADX INFO: renamed from: com.dcloud.zxing2.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        int i6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        char c = 0;
        if (i == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i7 = i2 + 1;
            int i8 = iArr[i2];
            boolean z = false;
            int i9 = 0;
            long j = 0;
            while (true) {
                i4 = iArr[c];
                if (i7 >= i4 || z) {
                    break;
                }
                int i10 = i9 + 1;
                iArr2[i9] = i8;
                j = (j * 900) + ((long) i8);
                i7++;
                int i11 = iArr[i7];
                if (i11 == TEXT_COMPACTION_MODE_LATCH || i11 == BYTE_COMPACTION_MODE_LATCH || i11 == NUMERIC_COMPACTION_MODE_LATCH || i11 == BYTE_COMPACTION_MODE_LATCH_6 || i11 == 928 || i11 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i11 == MACRO_PDF417_TERMINATOR) {
                    i8 = i11;
                    i9 = i10;
                    c = 0;
                    z = true;
                } else {
                    if (i10 % 5 != 0 || i10 <= 0) {
                        i6 = i11;
                        i9 = i10;
                        c = 0;
                    } else {
                        int i12 = 0;
                        while (i12 < 6) {
                            byteArrayOutputStream.write((byte) (j >> ((5 - i12) * 8)));
                            i12++;
                            i11 = i11;
                        }
                        i6 = i11;
                        c = 0;
                        i9 = 0;
                        j = 0;
                    }
                    i8 = i6;
                }
            }
            if (i7 != i4 || i8 >= TEXT_COMPACTION_MODE_LATCH) {
                i5 = i9;
            } else {
                i5 = i9 + 1;
                iArr2[i9] = i8;
            }
            for (int i13 = 0; i13 < i5; i13++) {
                byteArrayOutputStream.write((byte) iArr2[i13]);
            }
            i3 = i7;
        } else if (i == BYTE_COMPACTION_MODE_LATCH_6) {
            i3 = i2;
            boolean z2 = false;
            loop3: while (true) {
                int i14 = 0;
                long j2 = 0;
                while (true) {
                    if (i3 >= iArr[0] || z2) {
                        break loop3;
                    }
                    int i15 = i3 + 1;
                    int i16 = iArr[i3];
                    if (i16 < TEXT_COMPACTION_MODE_LATCH) {
                        i14++;
                        j2 = (j2 * 900) + ((long) i16);
                        i3 = i15;
                    } else {
                        if (i16 != TEXT_COMPACTION_MODE_LATCH && i16 != BYTE_COMPACTION_MODE_LATCH && i16 != NUMERIC_COMPACTION_MODE_LATCH && i16 != BYTE_COMPACTION_MODE_LATCH_6 && i16 != 928) {
                            if (i16 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD && i16 != MACRO_PDF417_TERMINATOR) {
                                i3 = i15;
                            }
                        }
                        z2 = true;
                    }
                    if (i14 % 5 != 0 || i14 <= 0) {
                    }
                }
                for (int i17 = 0; i17 < 6; i17++) {
                    byteArrayOutputStream.write((byte) (j2 >> ((5 - i17) * 8)));
                }
            }
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int iByteCompaction;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charsetForName = Charset.forName("UTF-8");
        int i = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        for (int i2 = 2; i2 < iArr[0]; i2 = iByteCompaction + 1) {
            if (i != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i) {
                    case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                        iByteCompaction = textCompaction(iArr, i2, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        iByteCompaction = byteCompaction(i, iArr, charsetForName, i2, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                        iByteCompaction = numericCompaction(iArr, i2, sb);
                        break;
                    default:
                        switch (i) {
                            case MACRO_PDF417_TERMINATOR /* 922 */:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                iByteCompaction = byteCompaction(i, iArr, charsetForName, i2, sb);
                                break;
                            case ECI_USER_DEFINED /* 925 */:
                                iByteCompaction = i2 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /* 926 */:
                                iByteCompaction = i2 + 2;
                                break;
                            case ECI_CHARSET /* 927 */:
                                int i3 = i2 + 1;
                                Charset charsetForName2 = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                iByteCompaction = i3;
                                charsetForName = charsetForName2;
                                break;
                            case 928:
                                iByteCompaction = decodeMacroBlock(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                iByteCompaction = textCompaction(iArr, i2 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                sb.append((char) iArr[i2]);
                iByteCompaction = i2 + 1;
            }
            if (iByteCompaction >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i = iArr[iByteCompaction];
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iTextCompaction = textCompaction(iArr, i, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i3 = iArr[iTextCompaction];
        if (i3 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            if (i3 != MACRO_PDF417_TERMINATOR) {
                return iTextCompaction;
            }
            pDF417ResultMetadata.setLastSegment(true);
            return iTextCompaction + 1;
        }
        int i4 = iTextCompaction + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < TEXT_COMPACTION_MODE_LATCH) {
                iArr3[i5] = i7;
                i5++;
                i4 = i6;
            } else {
                if (i7 != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                }
                pDF417ResultMetadata.setLastSegment(true);
                i4 += 2;
                z = true;
            }
        }
        pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        int i2;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c = ' ';
            switch (AnonymousClass1.$SwitchMap$com$dcloud$zxing2$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 == 27) {
                            mode = Mode.LOWER;
                        } else if (i4 != 28) {
                            if (i4 != 29) {
                                if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                    sb.append((char) iArr2[i3]);
                                } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                    mode = Mode.ALPHA;
                                }
                                c = 0;
                            } else {
                                mode3 = Mode.PUNCT_SHIFT;
                            }
                            c = 0;
                            Mode mode4 = mode3;
                            mode3 = mode2;
                            mode2 = mode4;
                        } else {
                            mode = Mode.MIXED;
                        }
                        Mode mode5 = mode3;
                        mode3 = mode;
                        mode2 = mode5;
                        c = 0;
                        Mode mode6 = mode3;
                        mode3 = mode2;
                        mode2 = mode6;
                    }
                    break;
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 == 27) {
                            mode3 = Mode.ALPHA_SHIFT;
                        } else {
                            if (i4 == 28) {
                                mode = Mode.MIXED;
                            } else if (i4 != 29) {
                                if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                    sb.append((char) iArr2[i3]);
                                } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                    mode = Mode.ALPHA;
                                }
                                c = 0;
                            } else {
                                mode3 = Mode.PUNCT_SHIFT;
                            }
                            Mode mode7 = mode3;
                            mode3 = mode;
                            mode2 = mode7;
                        }
                        c = 0;
                        Mode mode8 = mode3;
                        mode3 = mode2;
                        mode2 = mode8;
                    }
                    break;
                case 3:
                    if (i4 < 25) {
                        c = MIXED_CHARS[i4];
                    } else {
                        if (i4 == 25) {
                            mode = Mode.PUNCT;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                mode = Mode.LOWER;
                            } else if (i4 != 28) {
                                if (i4 != 29) {
                                    if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                        sb.append((char) iArr2[i3]);
                                    } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                        mode = Mode.ALPHA;
                                    }
                                    c = 0;
                                } else {
                                    mode3 = Mode.PUNCT_SHIFT;
                                }
                                c = 0;
                                Mode mode9 = mode3;
                                mode3 = mode2;
                                mode2 = mode9;
                            } else {
                                mode = Mode.ALPHA;
                            }
                        }
                        Mode mode10 = mode3;
                        mode3 = mode;
                        mode2 = mode10;
                        c = 0;
                        Mode mode11 = mode3;
                        mode3 = mode2;
                        mode2 = mode11;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                    } else {
                        if (i4 != 29) {
                            if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                mode = Mode.ALPHA;
                            }
                            c = 0;
                        } else {
                            mode = Mode.ALPHA;
                        }
                        Mode mode12 = mode3;
                        mode3 = mode;
                        mode2 = mode12;
                        c = 0;
                        Mode mode13 = mode3;
                        mode3 = mode2;
                        mode2 = mode13;
                    }
                    break;
                case 5:
                    if (i4 >= 26) {
                        if (i4 != 26) {
                            if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                mode = Mode.ALPHA;
                                Mode mode14 = mode3;
                                mode3 = mode;
                                mode2 = mode14;
                            } else {
                                mode2 = mode3;
                            }
                            c = 0;
                        }
                        Mode mode15 = mode3;
                        mode3 = mode2;
                        mode2 = mode15;
                    } else {
                        c = (char) (i4 + 65);
                    }
                    mode2 = mode3;
                    Mode mode16 = mode3;
                    mode3 = mode2;
                    mode2 = mode16;
                    break;
                case 6:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                        mode2 = mode3;
                        Mode mode17 = mode3;
                        mode3 = mode2;
                        mode2 = mode17;
                    } else {
                        if (i4 != 29) {
                            if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                if (i4 == TEXT_COMPACTION_MODE_LATCH) {
                                    mode = Mode.ALPHA;
                                }
                                c = 0;
                                Mode mode18 = mode3;
                                mode3 = mode2;
                                mode2 = mode18;
                            } else {
                                sb.append((char) iArr2[i3]);
                            }
                            mode2 = mode3;
                            c = 0;
                            Mode mode19 = mode3;
                            mode3 = mode2;
                            mode2 = mode19;
                        } else {
                            mode = Mode.ALPHA;
                        }
                        Mode mode110 = mode3;
                        mode3 = mode;
                        mode2 = mode110;
                        c = 0;
                        Mode mode111 = mode3;
                        mode3 = mode2;
                        mode2 = mode111;
                    }
                    break;
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0007 A[SYNTHETIC] */
    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        loop0: while (true) {
            int i2 = 0;
            while (true) {
                int i3 = iArr[0];
                if (i >= i3 || z) {
                    break loop0;
                }
                int i4 = i + 1;
                int i5 = iArr[i];
                if (i4 == i3) {
                    z = true;
                }
                if (i5 < TEXT_COMPACTION_MODE_LATCH) {
                    iArr2[i2] = i5;
                    i2++;
                } else {
                    if (i5 == TEXT_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH_6 || i5 == 928 || i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i5 == MACRO_PDF417_TERMINATOR) {
                        z = true;
                    }
                    if (i2 % 15 != 0 || i5 == NUMERIC_COMPACTION_MODE_LATCH || z) {
                        if (i2 > 0) {
                            break;
                        }
                    }
                }
                i = i4;
                if (i2 % 15 != 0) {
                }
                if (i2 > 0) {
                    break;
                }
            }
            sb.append(decodeBase900toBase10(iArr2, i2));
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0030. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0033. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int i2 = (iArr[0] - i) * 2;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i5 != 928) {
                    switch (i5) {
                        case TEXT_COMPACTION_MODE_LATCH /* 900 */:
                            iArr2[i3] = TEXT_COMPACTION_MODE_LATCH;
                            i3++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /* 901 */:
                        case NUMERIC_COMPACTION_MODE_LATCH /* 902 */:
                            break;
                        default:
                            switch (i5) {
                                case MACRO_PDF417_TERMINATOR /* 922 */:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /* 923 */:
                                case BYTE_COMPACTION_MODE_LATCH_6 /* 924 */:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                z = true;
            } else {
                iArr2[i3] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i;
    }
}
