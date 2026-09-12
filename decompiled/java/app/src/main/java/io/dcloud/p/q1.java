package io.dcloud.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.weex.el.parse.Operators;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class q1 {
    private static q1 c;
    private final String a = "UNIAPP_HostPicker_0817";
    private final String b = "SP_LAST_SUIT_HOST_NAME_0817";

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class a implements Comparable, Cloneable {
        String a;
        EnumC0071a b;

        /* JADX INFO: renamed from: io.dcloud.p.q1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        public enum EnumC0071a {
            NORMAL(0),
            FIRST(1),
            BACKUP(-1);

            int a;

            EnumC0071a(int i) {
                this.a = i;
            }
        }

        public a(String str, EnumC0071a enumC0071a) {
            EnumC0071a enumC0071a2 = EnumC0071a.NORMAL;
            this.a = str;
            this.b = enumC0071a;
        }

        public String a() {
            String str = "";
            if (TextUtils.isEmpty(this.a)) {
                return "";
            }
            try {
                str = new String(Base64.decode(this.a.getBytes("UTF-8"), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return s4.d(str);
        }

        public boolean b() {
            return !TextUtils.isEmpty(this.a);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (TextUtils.isEmpty(aVar.a)) {
                return false;
            }
            return aVar.a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Host{hostUrl='" + this.a + "', priority=" + this.b + Operators.BLOCK_END;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a m482clone() {
            return new a(this.a, this.b);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (aVar == null) {
                return 1;
            }
            return aVar.b.a - this.b.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface b {
        void a(a aVar);

        boolean b(a aVar);

        void onNoOnePicked();
    }

    private q1() {
    }

    private void a(Context context, List list, String str) {
        String str2 = "SP_LAST_SUIT_HOST_NAME_0817" + str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("UNIAPP_HostPicker_0817", 0);
        String string = sharedPreferences.getString(str2, "");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.b()) {
                throw new RuntimeException("error format host");
            }
            if (!TextUtils.isEmpty(string)) {
                if (string.equals(aVar.a)) {
                    aVar.b = a.EnumC0071a.FIRST;
                } else {
                    aVar.b = a.EnumC0071a.NORMAL;
                }
            }
        }
        sharedPreferences.edit().remove(str2).apply();
    }

    public static q1 a() {
        if (c == null) {
            synchronized (q1.class) {
                if (c == null) {
                    c = new q1();
                }
            }
        }
        return c;
    }

    public void a(Context context, List list, String str, b bVar) {
        if (list != null && !list.isEmpty()) {
            a(context, list, str);
            Collections.sort(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (bVar.b(aVar)) {
                    if (aVar.b != a.EnumC0071a.BACKUP) {
                        context.getSharedPreferences("UNIAPP_HostPicker_0817", 0).edit().putString("SP_LAST_SUIT_HOST_NAME_0817" + str, aVar.a).apply();
                    }
                    bVar.a(aVar);
                    return;
                }
            }
            bVar.onNoOnePicked();
            return;
        }
        throw new RuntimeException("call initHosts first");
    }
}
