package io.dcloud.p;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    private static HashMap a = new HashMap();
    static ArrayList b = new ArrayList();

    public static void a(String str) {
        b.add(str);
    }

    public static void b(String str) {
        b.remove(str);
    }
}
