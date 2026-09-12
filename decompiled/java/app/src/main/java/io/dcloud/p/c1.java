package io.dcloud.p;

import android.app.Activity;
import io.dcloud.sdk.core.module.DCBaseAOL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class c1 extends k1 {
    public c1(Activity activity) {
        super(activity, 10);
    }

    @Override // io.dcloud.p.k1
    protected List f(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new b1((DCBaseAOL) it.next(), a()));
            }
        }
        return arrayList;
    }
}
