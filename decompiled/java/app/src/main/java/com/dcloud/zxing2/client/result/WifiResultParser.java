package com.dcloud.zxing2.client.result;

import com.dcloud.zxing2.Result;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class WifiResultParser extends ResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        String strMatchSinglePrefixedField;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("WIFI:") || (strMatchSinglePrefixedField = ResultParser.matchSinglePrefixedField("S:", massagedText, ';', false)) == null || strMatchSinglePrefixedField.isEmpty()) {
            return null;
        }
        String strMatchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("P:", massagedText, ';', false);
        String strMatchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("T:", massagedText, ';', false);
        if (strMatchSinglePrefixedField3 == null) {
            strMatchSinglePrefixedField3 = "nopass";
        }
        return new WifiParsedResult(strMatchSinglePrefixedField3, strMatchSinglePrefixedField, strMatchSinglePrefixedField2, Boolean.parseBoolean(ResultParser.matchSinglePrefixedField("H:", massagedText, ';', false)));
    }
}
