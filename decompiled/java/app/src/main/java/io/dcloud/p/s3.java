package io.dcloud.p;

import io.dcloud.common.DHInterface.IPdrModulesInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class s3 implements IPdrModulesInfo {
    @Override // io.dcloud.common.DHInterface.IPdrModulesInfo
    public Map getPdrModuleMap() {
        HashMap map = new HashMap();
        map.put("commit", e0.class);
        return map;
    }
}
