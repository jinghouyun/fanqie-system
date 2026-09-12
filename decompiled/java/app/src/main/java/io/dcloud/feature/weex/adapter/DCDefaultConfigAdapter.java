package io.dcloud.feature.weex.adapter;

import com.taobao.weex.adapter.IWXConfigAdapter;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCDefaultConfigAdapter implements IWXConfigAdapter {
    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public boolean checkMode(String str) {
        return false;
    }

    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public String getConfig(String str, String str2, String str3) {
        return str3;
    }

    @Override // com.taobao.weex.adapter.IWXConfigAdapter
    public String getConfigWhenInit(String str, String str2, String str3) {
        return str3;
    }
}
