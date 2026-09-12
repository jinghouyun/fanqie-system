package com.dcloud.zxing2.oned.rss.expanded.decoders;

import com.dcloud.zxing2.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
final class AI013103decoder extends AI013x0xDecoder {
    AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int i) {
        sb.append("(3103)");
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i;
    }
}
