package io.dcloud.p;

import io.dcloud.common.DHInterface.IPdrModule;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class r3 {
    private static r3 b;
    private volatile ConcurrentMap a = new ConcurrentHashMap();

    private r3() {
    }

    public static r3 a() {
        if (b == null) {
            b = new r3();
        }
        return b;
    }

    public void b() {
        Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            IPdrModule iPdrModule = (IPdrModule) this.a.remove((String) it.next());
            if (iPdrModule != null) {
                iPdrModule.onDestroy();
            }
        }
    }

    public void a(Map map) {
        if (map != null) {
            for (String str : map.keySet()) {
                a(str, (Class) map.get(str));
            }
        }
    }

    public void a(String str, Class cls) {
        if (cls != null) {
            try {
                this.a.put(str, (IPdrModule) cls.newInstance());
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
    }

    public IPdrModule a(String str) {
        if (this.a.containsKey(str)) {
            return (IPdrModule) this.a.get(str);
        }
        return null;
    }
}
