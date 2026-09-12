package com.dcloud.zxing2.client.result;

import com.dcloud.zxing2.Result;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class SMSTOMMSTOResultParser extends ResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public SMSParsedResult parse(Result result) {
        String strSubstring;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("smsto:") && !massagedText.startsWith("SMSTO:") && !massagedText.startsWith("mmsto:") && !massagedText.startsWith("MMSTO:")) {
            return null;
        }
        String strSubstring2 = massagedText.substring(6);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = null;
        }
        return new SMSParsedResult(strSubstring2, (String) null, (String) null, strSubstring);
    }
}
