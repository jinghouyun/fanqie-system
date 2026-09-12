package io.dcloud.p;

import android.app.Activity;
import android.text.TextUtils;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.util.BaseInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
class b4 {
    r a;
    private ArrayList b = new ArrayList();
    private ArrayList c;

    b4(r rVar) {
        this.a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        BaseInfo.sRunningApp = arrayList;
        this.c = arrayList;
        this.a = rVar;
    }

    boolean a(d5 d5Var, ISysEventListener.SysEventType sysEventType, Object obj) {
        boolean z = d5Var == null;
        int size = this.b.size();
        d5 d5Var2 = null;
        boolean zOnExecute = false;
        for (int i = size - 1; i >= 0; i--) {
            d5 d5Var3 = (d5) this.b.get(i);
            if (z ? z : d5Var3 == d5Var) {
                zOnExecute |= d5Var3.onExecute(sysEventType, obj);
                if (zOnExecute && !d5.a(sysEventType)) {
                    d5Var2 = d5Var3;
                    break;
                }
                d5Var2 = d5Var3;
            }
        }
        if (zOnExecute || !sysEventType.equals(ISysEventListener.SysEventType.onKeyUp) || size <= 1 || d5Var2 == null || ((Integer) ((Object[]) obj)[0]).intValue() != 4) {
            return zOnExecute;
        }
        this.a.processEvent(IMgr.MgrType.WindowMgr, 20, d5Var2);
        return true;
    }

    d5 b(String str) {
        d5 d5Var;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d5Var = (d5) obj;
            if (TextUtils.equals(d5Var.obtainAppId(), str)) {
                Logger.d("AppCache", "removeWebApp " + d5Var + ";mAppIdList=" + this.c);
                this.b.remove(d5Var);
                this.c.remove(str);
                return d5Var;
            }
        }
        d5Var = null;
        Logger.d("AppCache", "removeWebApp " + d5Var + ";mAppIdList=" + this.c);
        this.b.remove(d5Var);
        this.c.remove(str);
        return d5Var;
    }

    public d5 c() {
        ArrayList arrayList = this.b;
        if (arrayList != null && arrayList.size() == 1) {
            return (d5) this.b.get(0);
        }
        ArrayList arrayList2 = this.b;
        if (arrayList2 == null || arrayList2.size() < 1) {
            return null;
        }
        d5 d5Var = (d5) this.b.get(0);
        long j = d5Var.h1;
        for (int i = 1; i < this.b.size(); i++) {
            d5 d5Var2 = (d5) this.b.get(i);
            long j2 = d5Var2.h1;
            if (j < j2) {
                d5Var = d5Var2;
                j = j2;
            }
        }
        return d5Var;
    }

    public d5 d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        d5 d5Var = null;
        for (int i = 0; i < this.b.size(); i++) {
            d5 d5Var2 = (d5) this.b.get(i);
            long j = d5Var2.h1;
            if (j < jCurrentTimeMillis) {
                d5Var = d5Var2;
                jCurrentTimeMillis = j;
            }
        }
        return d5Var;
    }

    protected int e() {
        return this.b.size();
    }

    protected d5 b() {
        long j = 0;
        d5 d5Var = null;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            d5 d5Var2 = (d5) this.b.get(size);
            if (d5Var2.u == 3) {
                long j2 = d5Var2.h1;
                if (j2 > j) {
                    d5Var = d5Var2;
                    j = j2;
                }
            }
        }
        return d5Var;
    }

    protected d5 a(String str) {
        int iIndexOf = this.c.indexOf(str);
        if (iIndexOf >= 0) {
            return (d5) this.b.get(iIndexOf);
        }
        return null;
    }

    void a(String str, d5 d5Var) {
        this.c.add(str);
        this.b.add(d5Var);
    }

    protected d5 a(Activity activity, d5 d5Var) {
        if (this.b.contains(d5Var)) {
            return null;
        }
        System.currentTimeMillis();
        if (this.b.size() >= BaseInfo.s_Runing_App_Count_Max) {
            return d();
        }
        return null;
    }

    void a() {
        this.b.clear();
        this.c.clear();
    }
}
