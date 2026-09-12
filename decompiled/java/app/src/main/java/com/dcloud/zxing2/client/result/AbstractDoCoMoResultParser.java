package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    AbstractDoCoMoResultParser() {
    }

    static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z) {
        return ResultParser.matchPrefixedField(str, str2, ';', z);
    }

    static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z) {
        return ResultParser.matchSinglePrefixedField(str, str2, ';', z);
    }
}
