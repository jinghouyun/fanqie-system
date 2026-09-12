package io.dcloud.sdk.core.v3.dw;

import android.app.Activity;
import io.dcloud.p.c1;
import io.dcloud.p.j1;
import io.dcloud.p.z1;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.util.AOLErrorUtil;
import io.dcloud.sdk.core.v3.base.DCBaseAOL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class DCDrawAOLLoader extends DCBaseAOL {
    protected c1 b;

    public DCDrawAOLLoader(Activity activity) {
        super(activity);
        this.b = new c1(activity);
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, final DCDrawAOLLoadListener dCDrawAOLLoadListener) {
        if (getContext() != null && dCloudAOLSlot != null) {
            this.b.a(dCloudAOLSlot, new z1() { // from class: io.dcloud.sdk.core.v3.dw.DCDrawAOLLoader.1
                @Override // io.dcloud.p.z1
                public void onError(int i, String str, JSONArray jSONArray) {
                    DCDrawAOLLoadListener dCDrawAOLLoadListener2 = dCDrawAOLLoadListener;
                    if (dCDrawAOLLoadListener2 != null) {
                        dCDrawAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.z1
                public void onLoaded(List<j1> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<j1> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new DCDrawAOL(it.next()));
                    }
                    DCDrawAOLLoadListener dCDrawAOLLoadListener2 = dCDrawAOLLoadListener;
                    if (dCDrawAOLLoadListener2 != null) {
                        dCDrawAOLLoadListener2.onDrawAOLLoad(arrayList);
                    }
                }
            });
        } else if (dCDrawAOLLoadListener != null) {
            dCDrawAOLLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
