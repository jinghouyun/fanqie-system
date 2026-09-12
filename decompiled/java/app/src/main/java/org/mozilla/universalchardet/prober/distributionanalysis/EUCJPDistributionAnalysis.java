package org.mozilla.universalchardet.prober.distributionanalysis;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class EUCJPDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN = 161;
    public static final int HIGHBYTE_END = 254;
    public static final int LOWBYTE_BEGIN = 161;
    public static final int LOWBYTE_END = 254;

    @Override // org.mozilla.universalchardet.prober.distributionanalysis.CharDistributionAnalysis
    protected int getOrder(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        if (i2 < 161) {
            return -1;
        }
        return (((i2 - 161) * 94) + (bArr[i + 1] & 255)) - 161;
    }
}
