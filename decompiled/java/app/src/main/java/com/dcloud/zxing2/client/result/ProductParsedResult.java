package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class ProductParsedResult extends ParsedResult {
    private final String normalizedProductID;
    private final String productID;

    ProductParsedResult(String str) {
        this(str, str);
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public String getDisplayResult() {
        return this.productID;
    }

    public String getNormalizedProductID() {
        return this.normalizedProductID;
    }

    public String getProductID() {
        return this.productID;
    }

    ProductParsedResult(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.productID = str;
        this.normalizedProductID = str2;
    }
}
