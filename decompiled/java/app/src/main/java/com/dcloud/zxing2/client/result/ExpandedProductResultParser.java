package com.dcloud.zxing2.client.result;

import com.dcloud.zxing2.BarcodeFormat;
import com.dcloud.zxing2.Result;
import com.taobao.weex.el.parse.Operators;
import java.util.HashMap;
import org.mozilla.universalchardet.prober.HebrewProber;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedProductResultParser extends ResultParser {
    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String strSubstring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i);
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (findAIvalue(i2, strSubstring) != null) {
                    break;
                }
                sb.append(Operators.BRACKET_START);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0054  */
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public ExpandedProductParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(result);
        HashMap map = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String strSubstring = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        String strSubstring4 = null;
        int i = 0;
        while (i < massagedText.length()) {
            String strFindAIvalue = findAIvalue(i, massagedText);
            if (strFindAIvalue == null) {
                return null;
            }
            byte b = 2;
            int length = i + strFindAIvalue.length() + 2;
            String strFindValue = findValue(length, massagedText);
            int length2 = length + strFindValue.length();
            strFindAIvalue.hashCode();
            switch (strFindAIvalue.hashCode()) {
                case 1536:
                    if (!strFindAIvalue.equals("00")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1537:
                    if (!strFindAIvalue.equals("01")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1567:
                    if (!strFindAIvalue.equals("10")) {
                        b = -1;
                    }
                    break;
                case 1568:
                    if (!strFindAIvalue.equals("11")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 1570:
                    if (!strFindAIvalue.equals("13")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 1572:
                    if (!strFindAIvalue.equals("15")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1574:
                    if (!strFindAIvalue.equals("17")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 1567966:
                    if (!strFindAIvalue.equals("3100")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 1567967:
                    if (!strFindAIvalue.equals("3101")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 1567968:
                    if (!strFindAIvalue.equals("3102")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 1567969:
                    if (!strFindAIvalue.equals("3103")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 1567970:
                    if (!strFindAIvalue.equals("3104")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 1567971:
                    if (!strFindAIvalue.equals("3105")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 1567972:
                    if (!strFindAIvalue.equals("3106")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 1567973:
                    if (!strFindAIvalue.equals("3107")) {
                        b = -1;
                    } else {
                        b = 14;
                    }
                    break;
                case 1567974:
                    if (!strFindAIvalue.equals("3108")) {
                        b = -1;
                    } else {
                        b = 15;
                    }
                    break;
                case 1567975:
                    if (!strFindAIvalue.equals("3109")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 1568927:
                    if (!strFindAIvalue.equals("3200")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 1568928:
                    if (!strFindAIvalue.equals("3201")) {
                        b = -1;
                    } else {
                        b = 18;
                    }
                    break;
                case 1568929:
                    if (!strFindAIvalue.equals("3202")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 1568930:
                    if (!strFindAIvalue.equals("3203")) {
                        b = -1;
                    } else {
                        b = 20;
                    }
                    break;
                case 1568931:
                    if (!strFindAIvalue.equals("3204")) {
                        b = -1;
                    } else {
                        b = 21;
                    }
                    break;
                case 1568932:
                    if (!strFindAIvalue.equals("3205")) {
                        b = -1;
                    } else {
                        b = 22;
                    }
                    break;
                case 1568933:
                    if (!strFindAIvalue.equals("3206")) {
                        b = -1;
                    } else {
                        b = 23;
                    }
                    break;
                case 1568934:
                    if (!strFindAIvalue.equals("3207")) {
                        b = -1;
                    } else {
                        b = 24;
                    }
                    break;
                case 1568935:
                    if (!strFindAIvalue.equals("3208")) {
                        b = -1;
                    } else {
                        b = 25;
                    }
                    break;
                case 1568936:
                    if (!strFindAIvalue.equals("3209")) {
                        b = -1;
                    } else {
                        b = 26;
                    }
                    break;
                case 1575716:
                    if (!strFindAIvalue.equals("3920")) {
                        b = -1;
                    } else {
                        b = 27;
                    }
                    break;
                case 1575717:
                    if (!strFindAIvalue.equals("3921")) {
                        b = -1;
                    } else {
                        b = 28;
                    }
                    break;
                case 1575718:
                    if (!strFindAIvalue.equals("3922")) {
                        b = -1;
                    } else {
                        b = 29;
                    }
                    break;
                case 1575719:
                    if (!strFindAIvalue.equals("3923")) {
                        b = -1;
                    } else {
                        b = 30;
                    }
                    break;
                case 1575747:
                    if (!strFindAIvalue.equals("3930")) {
                        b = -1;
                    } else {
                        b = 31;
                    }
                    break;
                case 1575748:
                    if (!strFindAIvalue.equals("3931")) {
                        b = -1;
                    } else {
                        b = HebrewProber.SPACE;
                    }
                    break;
                case 1575749:
                    if (!strFindAIvalue.equals("3932")) {
                        b = -1;
                    } else {
                        b = 33;
                    }
                    break;
                case 1575750:
                    if (!strFindAIvalue.equals("3933")) {
                        b = -1;
                    } else {
                        b = 34;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    map = map;
                    str2 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 1:
                    map = map;
                    str = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 2:
                    map = map;
                    str3 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 3:
                    map = map;
                    str4 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 4:
                    map = map;
                    str5 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 5:
                    map = map;
                    str6 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 6:
                    map = map;
                    str7 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = ExpandedProductParsedResult.KILOGRAM;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = ExpandedProductParsedResult.POUND;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    map = map;
                    strSubstring3 = strFindAIvalue.substring(3);
                    strSubstring2 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (strFindValue.length() < 4) {
                        return null;
                    }
                    strSubstring2 = strFindValue.substring(3);
                    map = map;
                    strSubstring4 = strFindValue.substring(0, 3);
                    strSubstring3 = strFindAIvalue.substring(3);
                    continue;
                    map = map;
                    i = length2;
                    break;
                default:
                    map.put(strFindAIvalue, strFindValue);
                    map = map;
                    continue;
                    map = map;
                    i = length2;
                    break;
            }
            str8 = strFindValue;
            map = map;
            i = length2;
        }
        return new ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, strSubstring2, strSubstring3, strSubstring4, map);
    }
}
