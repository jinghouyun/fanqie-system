package io.dcloud.sdk.core.v3.fd;

import android.app.Activity;
import io.dcloud.p.j1;
import io.dcloud.p.k1;
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
public class DCFeedAOLLoader extends DCBaseAOL {
    protected k1 b;

    public DCFeedAOLLoader(Activity activity) {
        super(activity);
    }

    public void initLoader() {
        if (this.b == null) {
            this.b = new k1(getContext(), 4);
        }
    }

    public void load(DCloudAOLSlot dCloudAOLSlot, final DCFeedAOLLoadListener dCFeedAOLLoadListener) {
        if (getContext() != null && dCloudAOLSlot != null) {
            initLoader();
            this.b.a(dCloudAOLSlot, new z1() { // from class: io.dcloud.sdk.core.v3.fd.DCFeedAOLLoader.1
                @Override // io.dcloud.p.z1
                public void onError(int i, String str, JSONArray jSONArray) {
                    DCFeedAOLLoadListener dCFeedAOLLoadListener2 = dCFeedAOLLoadListener;
                    if (dCFeedAOLLoadListener2 != null) {
                        dCFeedAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.z1
                public void onLoaded(List<j1> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<j1> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new DCFeedAOL(it.next()));
                    }
                    DCFeedAOLLoadListener dCFeedAOLLoadListener2 = dCFeedAOLLoadListener;
                    if (dCFeedAOLLoadListener2 != null) {
                        dCFeedAOLLoadListener2.onFeedAOLLoad(arrayList);
                    }
                }
            });
        } else if (dCFeedAOLLoadListener != null) {
            dCFeedAOLLoadListener.onError(-5014, AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
