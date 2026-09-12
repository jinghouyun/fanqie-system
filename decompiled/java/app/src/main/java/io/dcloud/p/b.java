package io.dcloud.p;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.common.adapter.util.CanvasHelper;
import io.dcloud.common.util.AESUtil;
import io.dcloud.common.util.Base64;
import io.dcloud.common.util.CreateShortResultReceiver;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.language.LanguageUtil;
import io.dcloud.feature.internal.sdk.SDK;
import io.dcloud.sdk.core.util.Const;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static b j;
    private volatile Context a;
    private boolean b = false;
    private JSONObject c = new JSONObject();
    private JSONObject d = new JSONObject();
    private JSONObject e = new JSONObject();
    private JSONObject f = new JSONObject();
    private JSONObject g = new JSONObject();
    private JSONObject h = new JSONObject();
    private Handler i = new a();

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                b.this.a();
            } catch (Exception unused) {
            }
            sendEmptyMessageDelayed(1, Double.valueOf((Math.random() + 1.0d) * 1000.0d * 60.0d).longValue());
        }
    }

    /* JADX INFO: renamed from: io.dcloud.p.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class HandlerC0068b extends Handler {
        HandlerC0068b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                b.this.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
            sendEmptyMessageDelayed(1, Double.valueOf((Math.random() + 1.0d) * 1000.0d * 60.0d).longValue());
        }
    }

    private b() {
        if (j != null) {
            throw new IllegalStateException();
        }
    }

    private String b(String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 128).applicationInfo;
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    private void c() {
        if (this.d.length() > 0) {
            return;
        }
        try {
            this.d.put("r", "1");
            this.d.put(CreateShortResultReceiver.KEY_VERSIONNAME, (String) Class.forName(e1.b("kge&jmara&n}{agf&JmaRa{")).getMethod(e1.b("om|[lc^mz{agf"), null).invoke(null, null));
        } catch (Exception unused) {
        }
        try {
            try {
                Class.forName(e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&k}{|ge&jr&K}{|geJRIlix|mz"));
                this.d.put("ada", "1");
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            this.d.put("ada", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0079 A[Catch: Exception -> 0x007e, TRY_LEAVE, TryCatch #1 {Exception -> 0x007e, blocks: (B:3:0x000d, B:5:0x0018, B:7:0x001c, B:9:0x002a, B:13:0x0033, B:16:0x005e, B:18:0x0079), top: B:22:0x000d }] */
    private Map d() {
        HashMap map = new HashMap();
        map.put("app_id", "");
        try {
            byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(1));
            if (bArrDecode2bytes == null) {
                a(4);
                return map;
            }
            String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
            if (strDecrypt == null) {
                a(4);
                return map;
            }
            Class<?> cls = null;
            try {
                try {
                    Class<?> cls2 = Class.forName(strDecrypt);
                    return (Map) cls2.getMethod("NM_getCustomInfo", null).invoke(cls2.newInstance(), null);
                } catch (Exception unused) {
                    Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(8))));
                    if (cls == null) {
                        map.put("app_id", "unknow");
                    }
                    return map;
                }
            } catch (Exception unused2) {
                cls = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(9))));
                Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(8))));
                if (cls == null) {
                    map.put("app_id", "unknow");
                }
                return map;
            }
        } catch (Exception unused3) {
        }
    }

    private String e() {
        byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(12));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            Field declaredField = Class.forName(strDecrypt).getDeclaredField("appId");
            declaredField.setAccessible(true);
            return (String) declaredField.get(null);
        } catch (Exception unused) {
            return "";
        }
    }

    private String f() {
        byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(2));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        for (List list : r4.b()) {
            try {
                Class<?> cls = Class.forName(e1.b((String) list.get(0)));
                return (String) cls.getMethod(e1.b((String) list.get(2)), null).invoke(cls.getDeclaredMethod(e1.b((String) list.get(1)), null).invoke(null, null), null);
            } catch (Exception unused) {
            }
        }
        try {
            Class<?> cls2 = Class.forName(strDecrypt);
            Object objInvoke = cls2.getMethod("getAppStatus", null).invoke(cls2.getMethod("getInstance", null).invoke(null, null), null);
            if (objInvoke != null) {
                return (String) objInvoke.getClass().getMethod("getAPPID", null).invoke(objInvoke, null);
            }
        } catch (Exception unused2) {
        }
        return "";
    }

    private void g() {
        if (this.f.length() > 0) {
            return;
        }
        try {
            this.f.put("r", "1");
            this.f.put(CreateShortResultReceiver.KEY_VERSIONNAME, (String) Class.forName(e1.b("kge&iddaifkm&{{x&il&ixa&[IIddaifkmIl[lc")).getMethod(e1.b("om|Qg}\\}aILF[LC^mz{agf"), null).invoke(null, null));
        } catch (Exception unused) {
        }
        try {
            try {
                Class.forName(e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&k}{|ge&q|&K}{|geQ\\Ilix|mz"));
                this.f.put("ada", "1");
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            this.f.put("ada", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private void h() {
        if (this.e.length() > 0) {
            return;
        }
        try {
            this.e.put("r", "1");
            this.e.put(CreateShortResultReceiver.KEY_VERSIONNAME, (String) Class.forName(e1.b("kge&baiil{&il~a{|i&{lc&Il~a{|i[lc")).getMethod(e1.b("om^mz{agf"), null).invoke(null, null));
        } catch (Exception unused) {
        }
        try {
            try {
                Class.forName(e1.b("kge&baiil{&}fail&Il~a{|iK}{|geIlix|mz"));
                this.e.put("ada", "1");
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            this.e.put("ada", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private String i() {
        byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(10));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            return (String) Class.forName(strDecrypt).getMethod("getAppId", null).invoke(null, null);
        } catch (Exception unused) {
            return "";
        }
    }

    private String j() {
        try {
            for (List list : r4.c()) {
                try {
                    Class<?> cls = Class.forName(e1.b((String) list.get(0)));
                    Method declaredMethod = cls.getDeclaredMethod(e1.b((String) list.get(1)), null);
                    declaredMethod.setAccessible(true);
                    return (String) cls.getMethod(e1.b((String) list.get(2)), null).invoke(declaredMethod.invoke(null, null), null);
                } catch (Exception unused) {
                }
            }
            return "";
        } catch (Exception unused2) {
            return "";
        }
    }

    private String k() {
        byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(11));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            Class<?> cls = Class.forName(strDecrypt);
            Object objInvoke = cls.getMethod("sharedAds", null).invoke(null, null);
            Method method = cls.getMethod("getAppId", null);
            method.setAccessible(true);
            return (String) method.invoke(objInvoke, null);
        } catch (Exception unused) {
            return "";
        }
    }

    private void l() {
        if (this.h.length() > 0) {
            return;
        }
        try {
            this.h.put("r", "1");
            this.h.put(CreateShortResultReceiver.KEY_VERSIONNAME, (String) Class.forName(e1.b("kge&\u007fifoeia&ixx{lclmp&_EIl[lc")).getMethod(e1.b("om|[lc^mz{agf"), null).invoke(null, null));
        } catch (Exception unused) {
        }
        try {
            try {
                Class.forName(e1.b("kge&\u007fe&\u007feilix|mz}fail&_E[lcAfa|"));
                this.h.put("ada", "1");
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            this.h.put("ada", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private void m() {
        if (this.g.length() > 0) {
            return;
        }
        try {
            this.g.put("r", "1");
            this.g.put(CreateShortResultReceiver.KEY_VERSIONNAME, (String) Class.forName(e1.b("kge&gk|gx}{&il&Gk|gx}{")).getMethod(e1.b("om|[lc^mz{agf"), null).invoke(null, null));
        } catch (Exception unused) {
        }
        try {
            try {
                Class.forName(e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&rq&RQILIlix|mz"));
                this.g.put("ada", "1");
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            this.g.put("ada", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    public static b o() {
        if (j == null) {
            synchronized (b.class) {
                if (j == null) {
                    j = new b();
                }
            }
        }
        return j;
    }

    public List n() {
        ArrayList arrayList = new ArrayList();
        try {
            ActivityInfo[] activityInfoArr = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    arrayList.add(activityInfo.name);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public void p() {
        Handler handler = this.i;
        if (handler != null) {
            this.b = false;
            handler.removeMessages(1);
            this.i = null;
        }
    }

    public void a(Context context) {
        Handler handler;
        if (!PdrUtil.checkIntl() || LanguageUtil.getDeviceDefCountry().equalsIgnoreCase(e1.b("KF"))) {
            this.a = context;
            try {
                if (SDK.isUniMPSDK()) {
                    return;
                }
                if (Math.abs(Math.random() * 5.0d) == 5.0d && (handler = this.i) != null) {
                    handler.removeMessages(1);
                    this.i = null;
                }
                if (this.i == null) {
                    this.i = new HandlerC0068b();
                }
                if (this.i.hasMessages(1)) {
                    return;
                }
                this.i.sendEmptyMessage(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void b() {
        if (this.c.length() > 0) {
            return;
        }
        try {
            this.c.put("r", "1");
            this.c.put(CreateShortResultReceiver.KEY_VERSIONNAME, (String) Class.forName(e1.b("kge&jial}&egjil{&{lc&ixa&Il[m||afo{")).getMethod(e1.b("om|[LC^mz{agf"), null).invoke(null, null));
        } catch (Exception unused) {
        }
        try {
            try {
                Class.forName(e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&jl&JLIlIlix|mz"));
                this.c.put("ada", "1");
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            this.c.put("ada", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x026f A[Catch: Exception -> 0x02ac, TRY_LEAVE, TryCatch #5 {Exception -> 0x02ac, blocks: (B:99:0x0269, B:101:0x026f), top: B:268:0x0269 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:120:0x02b9 A[Catch: Exception -> 0x02ee, TRY_LEAVE, TryCatch #2 {Exception -> 0x02ee, blocks: (B:118:0x02b3, B:120:0x02b9), top: B:262:0x02b3 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:125:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:129:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:134:0x02fb A[Catch: Exception -> 0x0330, TRY_LEAVE, TryCatch #0 {Exception -> 0x0330, blocks: (B:132:0x02f5, B:134:0x02fb), top: B:258:0x02f5 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0330  */
    /* JADX WARN: Code duplicated, block: B:148:0x033b A[Catch: Exception -> 0x036f, TRY_LEAVE, TryCatch #1 {Exception -> 0x036f, blocks: (B:146:0x0335, B:148:0x033b), top: B:260:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0369  */
    /* JADX WARN: Code duplicated, block: B:166:0x03a4 A[Catch: Exception -> 0x03c6, TRY_LEAVE, TryCatch #20 {Exception -> 0x03c6, blocks: (B:164:0x0396, B:166:0x03a4), top: B:298:0x0396 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:176:0x03cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:200:0x0435 A[Catch: Exception -> 0x050d, TryCatch #3 {Exception -> 0x050d, blocks: (B:198:0x0415, B:200:0x0435, B:205:0x0448, B:240:0x04f1, B:203:0x0444), top: B:264:0x0415 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x0444 A[Catch: Exception -> 0x050d, LOOP:0: B:199:0x0433->B:203:0x0444, LOOP_END, TryCatch #3 {Exception -> 0x050d, blocks: (B:198:0x0415, B:200:0x0435, B:205:0x0448, B:240:0x04f1, B:203:0x0444), top: B:264:0x0415 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0465 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x0467 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:211:0x046c A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:213:0x0473 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0478 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0483 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:221:0x0490 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:224:0x049f A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:227:0x04ae A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:230:0x04bd A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:233:0x04cc A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:236:0x04db A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:239:0x04ea A[Catch: Exception -> 0x04f1, TRY_LEAVE, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:274:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x045d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:302:0x03b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x0447 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x0443 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0110  */
    /* JADX WARN: Code duplicated, block: B:38:0x0124  */
    /* JADX WARN: Code duplicated, block: B:39:0x0127  */
    /* JADX WARN: Code duplicated, block: B:49:0x0158 A[PHI: r24 r28
  0x0158: PHI (r24v9 java.lang.String) = (r24v2 java.lang.String), (r24v2 java.lang.String), (r24v10 java.lang.String) binds: [B:41:0x0135, B:43:0x013b, B:38:0x0124] A[DONT_GENERATE, DONT_INLINE]
  0x0158: PHI (r28v2 java.util.Map) = (r28v0 java.util.Map), (r28v0 java.util.Map), (r28v3 java.util.Map) binds: [B:41:0x0135, B:43:0x013b, B:38:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x0162  */
    /* JADX WARN: Code duplicated, block: B:54:0x0174  */
    /* JADX WARN: Code duplicated, block: B:56:0x0180 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x018b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0191  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x01df  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:85:0x0203  */
    /* JADX WARN: Code duplicated, block: B:87:0x0215  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0230  */
    /* JADX WARN: Code duplicated, block: B:95:0x0239  */
    /* JADX WARN: Code duplicated, block: B:97:0x024b  */
    public void a() {
        Map mapD;
        String str;
        boolean zEquals;
        String strA;
        String strF;
        String strA2;
        String strI;
        String strA3;
        int i;
        String strA4;
        String str2;
        boolean z;
        String strB;
        String str3;
        String strB2;
        String strB3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str4;
        String str5;
        String str6;
        String strK;
        Map map;
        String str7;
        String strE;
        String strA5;
        JSONObject jSONObject3;
        JSONArray jSONArrayA;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        HashMap map2;
        JSONObject jSONObject8;
        String str8;
        String str9;
        boolean z2;
        boolean z3;
        String str10;
        String str11;
        boolean z4;
        boolean z5;
        String str12;
        boolean z6;
        boolean z7;
        String str13;
        boolean z8;
        boolean z9;
        String strB4;
        String str14;
        String strA6;
        JSONArray jSONArrayA2;
        boolean z10;
        Method[] declaredMethods;
        int length;
        int i2;
        Method method;
        JSONObject jSONObject9;
        String str15;
        JSONArray jSONArrayA3;
        List listN = n();
        List listA = r4.a();
        if (listN.size() == 0 || listN.contains(e1.b((String) listA.get(1))) || listN.contains(e1.b((String) listA.get(4)))) {
            mapD = d();
            str = (String) mapD.remove("app_id");
            zEquals = "unknow".equals(str);
            strA = a("UNIAD_CSJ_APPID", Const.TYPE_CSJ);
        } else {
            mapD = null;
            str = null;
            zEquals = true;
            strA = null;
        }
        if (listN.size() == 0 || listN.contains(e1.b((String) listA.get(0)))) {
            strF = f();
            strA2 = a("UNIAD_GDT_APPID", Const.TYPE_GDT);
        } else {
            strF = null;
            strA2 = null;
        }
        if (listN.size() == 0 || listN.contains(e1.b((String) listA.get(2)))) {
            strI = i();
            strA3 = a("UNIAD_KS_APPID", Const.TYPE_KS);
        } else {
            strA3 = null;
            strI = null;
        }
        try {
            try {
                try {
                    try {
                        try {
                            if (listN.size() != 0) {
                                i = 1;
                                if (!listN.contains(e1.b((String) listA.get(5)))) {
                                    z = zEquals;
                                    str2 = null;
                                    strA4 = null;
                                }
                                strB = e1.b("kWixxal");
                                str3 = str2;
                                strB2 = e1.b("{Wixxal");
                                String str16 = strA4;
                                strB3 = e1.b("{WixxalW`");
                                jSONObject = new JSONObject();
                                String str17 = strA3;
                                jSONObject2 = new JSONObject();
                                str4 = strI;
                                str5 = strF;
                                if (listN.size() != 0) {
                                    str6 = strA2;
                                    if (listN.contains(e1.b((String) listA.get(3)))) {
                                        map = mapD;
                                    }
                                    str7 = Const.TYPE_CSJ;
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(8)))) {
                                        strE = e();
                                        strA5 = a("", "10028");
                                        if (strE == null) {
                                            jSONObject3 = jSONObject;
                                        } else {
                                            if (strA5 == null) {
                                                try {
                                                    jSONObject2.put("r", "1");
                                                    jSONObject2.put(strB, strE);
                                                } catch (Exception unused) {
                                                }
                                            } else if (!strE.equals(strA5)) {
                                                jSONObject3 = jSONObject;
                                                jSONArrayA = a("10028");
                                                if (!a(strE, jSONArrayA)) {
                                                    try {
                                                        jSONObject2.put("r", "1");
                                                        jSONObject2.put(strB, strE);
                                                        jSONObject2.put(strB2, strA5);
                                                        jSONObject2.put(strB3, jSONArrayA);
                                                    } catch (Exception unused2) {
                                                    }
                                                }
                                            }
                                            jSONObject3 = jSONObject;
                                        }
                                    } else {
                                        jSONObject3 = jSONObject;
                                    }
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(6)))) {
                                        c();
                                    }
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(7)))) {
                                        h();
                                    }
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(9)))) {
                                        g();
                                    }
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(10)))) {
                                        m();
                                    }
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(11)))) {
                                        b();
                                    }
                                    if (listN.size() != 0 || listN.contains(e1.b((String) listA.get(12)))) {
                                        l();
                                    }
                                    jSONObject4 = new JSONObject();
                                    jSONObject5 = new JSONObject();
                                    jSONObject6 = new JSONObject();
                                    jSONObject7 = new JSONObject();
                                    map2 = new HashMap();
                                    if (!TextUtils.isEmpty(str) || str.equals(strA)) {
                                        jSONObject8 = jSONObject2;
                                        str8 = str7;
                                        str9 = "10028";
                                    } else {
                                        String str18 = strA;
                                        str8 = str7;
                                        str9 = "10028";
                                        try {
                                            JSONArray jSONArrayA4 = a(str8);
                                            if (!a(str, jSONArrayA4)) {
                                                if (z) {
                                                    jSONObject8 = jSONObject2;
                                                    try {
                                                        a(6);
                                                    } catch (Exception unused3) {
                                                        z2 = true;
                                                    }
                                                } else {
                                                    jSONObject8 = jSONObject2;
                                                }
                                                try {
                                                    map2.put("r", "1");
                                                    map2.put(strB, str);
                                                    map2.put(strB2, String.valueOf(str18));
                                                    map2.put(strB3, jSONArrayA4);
                                                    if (map != null) {
                                                        map2.putAll(map);
                                                    }
                                                    while (true) {
                                                        if (i2 < length) {
                                                            method = null;
                                                            break;
                                                        }
                                                        method = declaredMethods[i2];
                                                        if (method.getName().equals("pr")) {
                                                            break;
                                                        } else {
                                                            i2++;
                                                        }
                                                    }
                                                } catch (Exception unused4) {
                                                }
                                                z2 = false;
                                                if (TextUtils.isEmpty(str5)) {
                                                    z3 = z2;
                                                    str10 = Const.TYPE_SGM;
                                                    str11 = Const.TYPE_GDT;
                                                    z4 = true;
                                                } else {
                                                    str15 = str6;
                                                    if (str5.equals(str15)) {
                                                        z3 = z2;
                                                        str10 = Const.TYPE_SGM;
                                                        str11 = Const.TYPE_GDT;
                                                    } else {
                                                        z3 = z2;
                                                        str11 = Const.TYPE_GDT;
                                                        try {
                                                            jSONArrayA3 = a(str11);
                                                            if (a(str5, jSONArrayA3)) {
                                                                str10 = Const.TYPE_SGM;
                                                            } else {
                                                                str10 = Const.TYPE_SGM;
                                                                try {
                                                                    a(6);
                                                                    try {
                                                                        jSONObject4.put("r", "1");
                                                                        jSONObject4.put(strB, str5);
                                                                        jSONObject4.put(strB2, String.valueOf(str15));
                                                                        jSONObject4.put(strB3, jSONArrayA3);
                                                                    } catch (Exception unused5) {
                                                                    }
                                                                    z4 = false;
                                                                } catch (Exception unused6) {
                                                                    z4 = true;
                                                                }
                                                            }
                                                        } catch (Exception unused7) {
                                                        }
                                                    }
                                                    z4 = true;
                                                }
                                                if (!TextUtils.isEmpty(str4) || str4.equals(str17)) {
                                                    z5 = z4;
                                                    str12 = Const.TYPE_KS;
                                                } else {
                                                    z5 = z4;
                                                    try {
                                                        JSONArray jSONArrayA5 = a(Const.TYPE_KS);
                                                        if (!a(str4, jSONArrayA5)) {
                                                            str12 = Const.TYPE_KS;
                                                            try {
                                                                a(6);
                                                                try {
                                                                    jSONObject5.put("r", "1");
                                                                    jSONObject5.put(strB, str4);
                                                                    jSONObject5.put(strB2, String.valueOf(str17));
                                                                    jSONObject5.put(strB3, jSONArrayA5);
                                                                    while (true) {
                                                                        if (i2 < length) {
                                                                            method = null;
                                                                            break;
                                                                        }
                                                                        method = declaredMethods[i2];
                                                                        if (method.getName().equals("pr")) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i2++;
                                                                    }
                                                                } catch (Exception unused8) {
                                                                }
                                                                z6 = false;
                                                            } catch (Exception unused9) {
                                                                z6 = true;
                                                            }
                                                            if (TextUtils.isEmpty(str3) && !str3.equals(str16)) {
                                                                z7 = z6;
                                                                str13 = Const.TYPE_PG;
                                                                try {
                                                                    JSONArray jSONArrayA6 = a(str13);
                                                                    if (!a(str3, jSONArrayA6)) {
                                                                        try {
                                                                            jSONObject7.put("r", "1");
                                                                            jSONObject7.put(strB, str3);
                                                                            jSONObject7.put(strB2, String.valueOf(str16));
                                                                            jSONObject7.put(strB3, jSONArrayA6);
                                                                        } catch (Exception unused10) {
                                                                        }
                                                                        z8 = false;
                                                                    }
                                                                    while (true) {
                                                                        if (i2 < length) {
                                                                            method = null;
                                                                            break;
                                                                        }
                                                                        method = declaredMethods[i2];
                                                                        if (method.getName().equals("pr")) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i2++;
                                                                    }
                                                                } catch (Exception unused11) {
                                                                }
                                                                z9 = z8;
                                                                strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                                                if (!TextUtils.isEmpty(strB4)) {
                                                                    try {
                                                                        Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                                                        str14 = str13;
                                                                        try {
                                                                            strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                                                                            if (!strB4.equals(strA6)) {
                                                                                jSONArrayA2 = a(Const.TYPE_GG);
                                                                                if (!a(strB4, jSONArrayA2)) {
                                                                                    try {
                                                                                        jSONObject6.put("r", "1");
                                                                                        jSONObject6.put(strB, strB4);
                                                                                        jSONObject6.put(strB2, String.valueOf(strA6));
                                                                                        jSONObject6.put(strB3, jSONArrayA2);
                                                                                    } catch (Exception unused12) {
                                                                                    }
                                                                                    z10 = false;
                                                                                }
                                                                            }
                                                                        } catch (Exception unused13) {
                                                                        }
                                                                    } catch (Exception unused14) {
                                                                        str14 = str13;
                                                                    }
                                                                    if ((z3 || !z5 || !z7 || !z10 || !z9 || jSONObject3.length() > 0 || jSONObject8.length() > 0 || this.c.length() > 0 || this.g.length() > 0 || this.e.length() > 0 || this.d.length() > 0 || this.f.length() > 0 || this.h.length() > 0) && !this.b) {
                                                                        declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                                                        length = declaredMethods.length;
                                                                        i2 = 0;
                                                                        while (true) {
                                                                            if (i2 < length) {
                                                                                method = null;
                                                                                break;
                                                                            }
                                                                            method = declaredMethods[i2];
                                                                            if (method.getName().equals("pr")) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            i2++;
                                                                        }
                                                                        HashMap map3 = new HashMap();
                                                                        map3.put("t", Integer.valueOf(i));
                                                                        jSONObject9 = new JSONObject();
                                                                        if (!z3) {
                                                                            try {
                                                                                jSONObject9.put(str8, new JSONObject(map2));
                                                                                if (!z5) {
                                                                                    jSONObject9.put(str11, jSONObject4);
                                                                                }
                                                                                if (!z7) {
                                                                                    jSONObject9.put(str12, jSONObject5);
                                                                                }
                                                                                if (!z10) {
                                                                                    jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                                }
                                                                                if (!z9) {
                                                                                    jSONObject9.put(str14, jSONObject7);
                                                                                }
                                                                                if (jSONObject3.length() > 0) {
                                                                                    jSONObject9.put(str10, jSONObject3);
                                                                                }
                                                                                if (jSONObject8.length() > 0) {
                                                                                    jSONObject9.put(str9, jSONObject8);
                                                                                }
                                                                                if (this.c.length() > 0) {
                                                                                    jSONObject9.put(Const.TYPE_BD, this.c);
                                                                                }
                                                                                if (this.d.length() > 0) {
                                                                                    jSONObject9.put("10025", this.d);
                                                                                }
                                                                                if (this.e.length() > 0) {
                                                                                    jSONObject9.put("10033", this.e);
                                                                                }
                                                                                if (this.f.length() > 0) {
                                                                                    jSONObject9.put("10031", this.f);
                                                                                }
                                                                                if (this.g.length() > 0) {
                                                                                    jSONObject9.put("10026", this.g);
                                                                                }
                                                                                if (this.h.length() > 0) {
                                                                                    jSONObject9.put("10034", this.h);
                                                                                }
                                                                            } catch (Exception unused15) {
                                                                            }
                                                                        } else {
                                                                            if (!z5) {
                                                                                jSONObject9.put(str11, jSONObject4);
                                                                            }
                                                                            if (!z7) {
                                                                                jSONObject9.put(str12, jSONObject5);
                                                                            }
                                                                            if (!z10) {
                                                                                jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                            }
                                                                            if (!z9) {
                                                                                jSONObject9.put(str14, jSONObject7);
                                                                            }
                                                                            if (jSONObject3.length() > 0) {
                                                                                jSONObject9.put(str10, jSONObject3);
                                                                            }
                                                                            if (jSONObject8.length() > 0) {
                                                                                jSONObject9.put(str9, jSONObject8);
                                                                            }
                                                                            if (this.c.length() > 0) {
                                                                                jSONObject9.put(Const.TYPE_BD, this.c);
                                                                            }
                                                                            if (this.d.length() > 0) {
                                                                                jSONObject9.put("10025", this.d);
                                                                            }
                                                                            if (this.e.length() > 0) {
                                                                                jSONObject9.put("10033", this.e);
                                                                            }
                                                                            if (this.f.length() > 0) {
                                                                                jSONObject9.put("10031", this.f);
                                                                            }
                                                                            if (this.g.length() > 0) {
                                                                                jSONObject9.put("10026", this.g);
                                                                            }
                                                                            if (this.h.length() > 0) {
                                                                                jSONObject9.put("10034", this.h);
                                                                            }
                                                                        }
                                                                        map3.put("rad", jSONObject9.toString());
                                                                        method.setAccessible(true);
                                                                        method.invoke(null, this.a, map3);
                                                                        this.b = true;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                str14 = str13;
                                                                z10 = true;
                                                                if (z3) {
                                                                }
                                                                declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                                                length = declaredMethods.length;
                                                                i2 = 0;
                                                                HashMap map4 = new HashMap();
                                                                map4.put("t", Integer.valueOf(i));
                                                                jSONObject9 = new JSONObject();
                                                                if (!z3) {
                                                                    jSONObject9.put(str8, new JSONObject(map2));
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                } else {
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                }
                                                                map4.put("rad", jSONObject9.toString());
                                                                method.setAccessible(true);
                                                                method.invoke(null, this.a, map4);
                                                                this.b = true;
                                                                return;
                                                            }
                                                            z7 = z6;
                                                            str13 = Const.TYPE_PG;
                                                            z8 = true;
                                                            z9 = z8;
                                                            strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                                            if (!TextUtils.isEmpty(strB4)) {
                                                                Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                                                str14 = str13;
                                                                strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                                                                if (!strB4.equals(strA6)) {
                                                                    jSONArrayA2 = a(Const.TYPE_GG);
                                                                    if (!a(strB4, jSONArrayA2)) {
                                                                        jSONObject6.put("r", "1");
                                                                        jSONObject6.put(strB, strB4);
                                                                        jSONObject6.put(strB2, String.valueOf(strA6));
                                                                        jSONObject6.put(strB3, jSONArrayA2);
                                                                        z10 = false;
                                                                    }
                                                                }
                                                                if (z3) {
                                                                }
                                                                declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                                                length = declaredMethods.length;
                                                                i2 = 0;
                                                                while (true) {
                                                                    if (i2 < length) {
                                                                        method = null;
                                                                        break;
                                                                    }
                                                                    method = declaredMethods[i2];
                                                                    if (method.getName().equals("pr")) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    i2++;
                                                                }
                                                                HashMap map5 = new HashMap();
                                                                map5.put("t", Integer.valueOf(i));
                                                                jSONObject9 = new JSONObject();
                                                                if (!z3) {
                                                                    jSONObject9.put(str8, new JSONObject(map2));
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                } else {
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                }
                                                                map5.put("rad", jSONObject9.toString());
                                                                method.setAccessible(true);
                                                                method.invoke(null, this.a, map5);
                                                                this.b = true;
                                                                return;
                                                            }
                                                            str14 = str13;
                                                            z10 = true;
                                                            if (z3) {
                                                            }
                                                            declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                                            length = declaredMethods.length;
                                                            i2 = 0;
                                                            HashMap map6 = new HashMap();
                                                            map6.put("t", Integer.valueOf(i));
                                                            jSONObject9 = new JSONObject();
                                                            if (!z3) {
                                                                jSONObject9.put(str8, new JSONObject(map2));
                                                                if (!z5) {
                                                                    jSONObject9.put(str11, jSONObject4);
                                                                }
                                                                if (!z7) {
                                                                    jSONObject9.put(str12, jSONObject5);
                                                                }
                                                                if (!z10) {
                                                                    jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                }
                                                                if (!z9) {
                                                                    jSONObject9.put(str14, jSONObject7);
                                                                }
                                                                if (jSONObject3.length() > 0) {
                                                                    jSONObject9.put(str10, jSONObject3);
                                                                }
                                                                if (jSONObject8.length() > 0) {
                                                                    jSONObject9.put(str9, jSONObject8);
                                                                }
                                                                if (this.c.length() > 0) {
                                                                    jSONObject9.put(Const.TYPE_BD, this.c);
                                                                }
                                                                if (this.d.length() > 0) {
                                                                    jSONObject9.put("10025", this.d);
                                                                }
                                                                if (this.e.length() > 0) {
                                                                    jSONObject9.put("10033", this.e);
                                                                }
                                                                if (this.f.length() > 0) {
                                                                    jSONObject9.put("10031", this.f);
                                                                }
                                                                if (this.g.length() > 0) {
                                                                    jSONObject9.put("10026", this.g);
                                                                }
                                                                if (this.h.length() > 0) {
                                                                    jSONObject9.put("10034", this.h);
                                                                }
                                                            } else {
                                                                if (!z5) {
                                                                    jSONObject9.put(str11, jSONObject4);
                                                                }
                                                                if (!z7) {
                                                                    jSONObject9.put(str12, jSONObject5);
                                                                }
                                                                if (!z10) {
                                                                    jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                                }
                                                                if (!z9) {
                                                                    jSONObject9.put(str14, jSONObject7);
                                                                }
                                                                if (jSONObject3.length() > 0) {
                                                                    jSONObject9.put(str10, jSONObject3);
                                                                }
                                                                if (jSONObject8.length() > 0) {
                                                                    jSONObject9.put(str9, jSONObject8);
                                                                }
                                                                if (this.c.length() > 0) {
                                                                    jSONObject9.put(Const.TYPE_BD, this.c);
                                                                }
                                                                if (this.d.length() > 0) {
                                                                    jSONObject9.put("10025", this.d);
                                                                }
                                                                if (this.e.length() > 0) {
                                                                    jSONObject9.put("10033", this.e);
                                                                }
                                                                if (this.f.length() > 0) {
                                                                    jSONObject9.put("10031", this.f);
                                                                }
                                                                if (this.g.length() > 0) {
                                                                    jSONObject9.put("10026", this.g);
                                                                }
                                                                if (this.h.length() > 0) {
                                                                    jSONObject9.put("10034", this.h);
                                                                }
                                                            }
                                                            map6.put("rad", jSONObject9.toString());
                                                            method.setAccessible(true);
                                                            method.invoke(null, this.a, map6);
                                                            this.b = true;
                                                            return;
                                                        }
                                                        str12 = Const.TYPE_KS;
                                                    } catch (Exception unused16) {
                                                    }
                                                }
                                                z6 = true;
                                                if (TextUtils.isEmpty(str3)) {
                                                    z7 = z6;
                                                    str13 = Const.TYPE_PG;
                                                    z8 = true;
                                                } else {
                                                    z7 = z6;
                                                    str13 = Const.TYPE_PG;
                                                    z8 = true;
                                                }
                                                z9 = z8;
                                                strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                                if (!TextUtils.isEmpty(strB4)) {
                                                    Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                                    str14 = str13;
                                                    strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                                                    if (!strB4.equals(strA6)) {
                                                        jSONArrayA2 = a(Const.TYPE_GG);
                                                        if (!a(strB4, jSONArrayA2)) {
                                                            jSONObject6.put("r", "1");
                                                            jSONObject6.put(strB, strB4);
                                                            jSONObject6.put(strB2, String.valueOf(strA6));
                                                            jSONObject6.put(strB3, jSONArrayA2);
                                                            z10 = false;
                                                        }
                                                    }
                                                    if (z3) {
                                                    }
                                                    declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                                    length = declaredMethods.length;
                                                    i2 = 0;
                                                    while (true) {
                                                        if (i2 < length) {
                                                            method = null;
                                                            break;
                                                        }
                                                        method = declaredMethods[i2];
                                                        if (method.getName().equals("pr")) {
                                                            break;
                                                            break;
                                                        }
                                                        i2++;
                                                    }
                                                    HashMap map7 = new HashMap();
                                                    map7.put("t", Integer.valueOf(i));
                                                    jSONObject9 = new JSONObject();
                                                    if (!z3) {
                                                        jSONObject9.put(str8, new JSONObject(map2));
                                                        if (!z5) {
                                                            jSONObject9.put(str11, jSONObject4);
                                                        }
                                                        if (!z7) {
                                                            jSONObject9.put(str12, jSONObject5);
                                                        }
                                                        if (!z10) {
                                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                        }
                                                        if (!z9) {
                                                            jSONObject9.put(str14, jSONObject7);
                                                        }
                                                        if (jSONObject3.length() > 0) {
                                                            jSONObject9.put(str10, jSONObject3);
                                                        }
                                                        if (jSONObject8.length() > 0) {
                                                            jSONObject9.put(str9, jSONObject8);
                                                        }
                                                        if (this.c.length() > 0) {
                                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                                        }
                                                        if (this.d.length() > 0) {
                                                            jSONObject9.put("10025", this.d);
                                                        }
                                                        if (this.e.length() > 0) {
                                                            jSONObject9.put("10033", this.e);
                                                        }
                                                        if (this.f.length() > 0) {
                                                            jSONObject9.put("10031", this.f);
                                                        }
                                                        if (this.g.length() > 0) {
                                                            jSONObject9.put("10026", this.g);
                                                        }
                                                        if (this.h.length() > 0) {
                                                            jSONObject9.put("10034", this.h);
                                                        }
                                                    } else {
                                                        if (!z5) {
                                                            jSONObject9.put(str11, jSONObject4);
                                                        }
                                                        if (!z7) {
                                                            jSONObject9.put(str12, jSONObject5);
                                                        }
                                                        if (!z10) {
                                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                        }
                                                        if (!z9) {
                                                            jSONObject9.put(str14, jSONObject7);
                                                        }
                                                        if (jSONObject3.length() > 0) {
                                                            jSONObject9.put(str10, jSONObject3);
                                                        }
                                                        if (jSONObject8.length() > 0) {
                                                            jSONObject9.put(str9, jSONObject8);
                                                        }
                                                        if (this.c.length() > 0) {
                                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                                        }
                                                        if (this.d.length() > 0) {
                                                            jSONObject9.put("10025", this.d);
                                                        }
                                                        if (this.e.length() > 0) {
                                                            jSONObject9.put("10033", this.e);
                                                        }
                                                        if (this.f.length() > 0) {
                                                            jSONObject9.put("10031", this.f);
                                                        }
                                                        if (this.g.length() > 0) {
                                                            jSONObject9.put("10026", this.g);
                                                        }
                                                        if (this.h.length() > 0) {
                                                            jSONObject9.put("10034", this.h);
                                                        }
                                                    }
                                                    map7.put("rad", jSONObject9.toString());
                                                    method.setAccessible(true);
                                                    method.invoke(null, this.a, map7);
                                                    this.b = true;
                                                    return;
                                                }
                                                str14 = str13;
                                                z10 = true;
                                                if (z3) {
                                                }
                                                declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                                length = declaredMethods.length;
                                                i2 = 0;
                                                HashMap map8 = new HashMap();
                                                map8.put("t", Integer.valueOf(i));
                                                jSONObject9 = new JSONObject();
                                                if (!z3) {
                                                    jSONObject9.put(str8, new JSONObject(map2));
                                                    if (!z5) {
                                                        jSONObject9.put(str11, jSONObject4);
                                                    }
                                                    if (!z7) {
                                                        jSONObject9.put(str12, jSONObject5);
                                                    }
                                                    if (!z10) {
                                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                    }
                                                    if (!z9) {
                                                        jSONObject9.put(str14, jSONObject7);
                                                    }
                                                    if (jSONObject3.length() > 0) {
                                                        jSONObject9.put(str10, jSONObject3);
                                                    }
                                                    if (jSONObject8.length() > 0) {
                                                        jSONObject9.put(str9, jSONObject8);
                                                    }
                                                    if (this.c.length() > 0) {
                                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                                    }
                                                    if (this.d.length() > 0) {
                                                        jSONObject9.put("10025", this.d);
                                                    }
                                                    if (this.e.length() > 0) {
                                                        jSONObject9.put("10033", this.e);
                                                    }
                                                    if (this.f.length() > 0) {
                                                        jSONObject9.put("10031", this.f);
                                                    }
                                                    if (this.g.length() > 0) {
                                                        jSONObject9.put("10026", this.g);
                                                    }
                                                    if (this.h.length() > 0) {
                                                        jSONObject9.put("10034", this.h);
                                                    }
                                                } else {
                                                    if (!z5) {
                                                        jSONObject9.put(str11, jSONObject4);
                                                    }
                                                    if (!z7) {
                                                        jSONObject9.put(str12, jSONObject5);
                                                    }
                                                    if (!z10) {
                                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                                    }
                                                    if (!z9) {
                                                        jSONObject9.put(str14, jSONObject7);
                                                    }
                                                    if (jSONObject3.length() > 0) {
                                                        jSONObject9.put(str10, jSONObject3);
                                                    }
                                                    if (jSONObject8.length() > 0) {
                                                        jSONObject9.put(str9, jSONObject8);
                                                    }
                                                    if (this.c.length() > 0) {
                                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                                    }
                                                    if (this.d.length() > 0) {
                                                        jSONObject9.put("10025", this.d);
                                                    }
                                                    if (this.e.length() > 0) {
                                                        jSONObject9.put("10033", this.e);
                                                    }
                                                    if (this.f.length() > 0) {
                                                        jSONObject9.put("10031", this.f);
                                                    }
                                                    if (this.g.length() > 0) {
                                                        jSONObject9.put("10026", this.g);
                                                    }
                                                    if (this.h.length() > 0) {
                                                        jSONObject9.put("10034", this.h);
                                                    }
                                                }
                                                map8.put("rad", jSONObject9.toString());
                                                method.setAccessible(true);
                                                method.invoke(null, this.a, map8);
                                                this.b = true;
                                                return;
                                            }
                                            jSONObject8 = jSONObject2;
                                        } catch (Exception unused17) {
                                        }
                                    }
                                    z2 = true;
                                    if (TextUtils.isEmpty(str5)) {
                                        str15 = str6;
                                        if (str5.equals(str15)) {
                                            z3 = z2;
                                            str11 = Const.TYPE_GDT;
                                            jSONArrayA3 = a(str11);
                                            if (a(str5, jSONArrayA3)) {
                                                str10 = Const.TYPE_SGM;
                                                a(6);
                                                jSONObject4.put("r", "1");
                                                jSONObject4.put(strB, str5);
                                                jSONObject4.put(strB2, String.valueOf(str15));
                                                jSONObject4.put(strB3, jSONArrayA3);
                                                z4 = false;
                                            } else {
                                                str10 = Const.TYPE_SGM;
                                            }
                                        } else {
                                            z3 = z2;
                                            str10 = Const.TYPE_SGM;
                                            str11 = Const.TYPE_GDT;
                                        }
                                        z4 = true;
                                    } else {
                                        z3 = z2;
                                        str10 = Const.TYPE_SGM;
                                        str11 = Const.TYPE_GDT;
                                        z4 = true;
                                    }
                                    if (TextUtils.isEmpty(str4)) {
                                        z5 = z4;
                                        str12 = Const.TYPE_KS;
                                        z6 = true;
                                    } else {
                                        z5 = z4;
                                        str12 = Const.TYPE_KS;
                                        z6 = true;
                                    }
                                    if (TextUtils.isEmpty(str3)) {
                                        z7 = z6;
                                        str13 = Const.TYPE_PG;
                                        z8 = true;
                                    } else {
                                        z7 = z6;
                                        str13 = Const.TYPE_PG;
                                        z8 = true;
                                    }
                                    z9 = z8;
                                    strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                    if (!TextUtils.isEmpty(strB4)) {
                                        Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                        str14 = str13;
                                        strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                                        if (!strB4.equals(strA6)) {
                                            jSONArrayA2 = a(Const.TYPE_GG);
                                            if (!a(strB4, jSONArrayA2)) {
                                                jSONObject6.put("r", "1");
                                                jSONObject6.put(strB, strB4);
                                                jSONObject6.put(strB2, String.valueOf(strA6));
                                                jSONObject6.put(strB3, jSONArrayA2);
                                                z10 = false;
                                            }
                                        }
                                        if (z3) {
                                        }
                                        declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                        length = declaredMethods.length;
                                        i2 = 0;
                                        while (true) {
                                            if (i2 < length) {
                                                method = null;
                                                break;
                                            }
                                            method = declaredMethods[i2];
                                            if (method.getName().equals("pr")) {
                                                break;
                                                break;
                                            }
                                            i2++;
                                        }
                                        HashMap map9 = new HashMap();
                                        map9.put("t", Integer.valueOf(i));
                                        jSONObject9 = new JSONObject();
                                        if (!z3) {
                                            jSONObject9.put(str8, new JSONObject(map2));
                                            if (!z5) {
                                                jSONObject9.put(str11, jSONObject4);
                                            }
                                            if (!z7) {
                                                jSONObject9.put(str12, jSONObject5);
                                            }
                                            if (!z10) {
                                                jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                            }
                                            if (!z9) {
                                                jSONObject9.put(str14, jSONObject7);
                                            }
                                            if (jSONObject3.length() > 0) {
                                                jSONObject9.put(str10, jSONObject3);
                                            }
                                            if (jSONObject8.length() > 0) {
                                                jSONObject9.put(str9, jSONObject8);
                                            }
                                            if (this.c.length() > 0) {
                                                jSONObject9.put(Const.TYPE_BD, this.c);
                                            }
                                            if (this.d.length() > 0) {
                                                jSONObject9.put("10025", this.d);
                                            }
                                            if (this.e.length() > 0) {
                                                jSONObject9.put("10033", this.e);
                                            }
                                            if (this.f.length() > 0) {
                                                jSONObject9.put("10031", this.f);
                                            }
                                            if (this.g.length() > 0) {
                                                jSONObject9.put("10026", this.g);
                                            }
                                            if (this.h.length() > 0) {
                                                jSONObject9.put("10034", this.h);
                                            }
                                        } else {
                                            if (!z5) {
                                                jSONObject9.put(str11, jSONObject4);
                                            }
                                            if (!z7) {
                                                jSONObject9.put(str12, jSONObject5);
                                            }
                                            if (!z10) {
                                                jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                            }
                                            if (!z9) {
                                                jSONObject9.put(str14, jSONObject7);
                                            }
                                            if (jSONObject3.length() > 0) {
                                                jSONObject9.put(str10, jSONObject3);
                                            }
                                            if (jSONObject8.length() > 0) {
                                                jSONObject9.put(str9, jSONObject8);
                                            }
                                            if (this.c.length() > 0) {
                                                jSONObject9.put(Const.TYPE_BD, this.c);
                                            }
                                            if (this.d.length() > 0) {
                                                jSONObject9.put("10025", this.d);
                                            }
                                            if (this.e.length() > 0) {
                                                jSONObject9.put("10033", this.e);
                                            }
                                            if (this.f.length() > 0) {
                                                jSONObject9.put("10031", this.f);
                                            }
                                            if (this.g.length() > 0) {
                                                jSONObject9.put("10026", this.g);
                                            }
                                            if (this.h.length() > 0) {
                                                jSONObject9.put("10034", this.h);
                                            }
                                        }
                                        map9.put("rad", jSONObject9.toString());
                                        method.setAccessible(true);
                                        method.invoke(null, this.a, map9);
                                        this.b = true;
                                        return;
                                    }
                                    str14 = str13;
                                    z10 = true;
                                    if (z3) {
                                    }
                                    declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                    length = declaredMethods.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            method = null;
                                            break;
                                        }
                                        method = declaredMethods[i2];
                                        if (method.getName().equals("pr")) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                    HashMap map10 = new HashMap();
                                    map10.put("t", Integer.valueOf(i));
                                    jSONObject9 = new JSONObject();
                                    if (!z3) {
                                        jSONObject9.put(str8, new JSONObject(map2));
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    } else {
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    }
                                    map10.put("rad", jSONObject9.toString());
                                    method.setAccessible(true);
                                    method.invoke(null, this.a, map10);
                                    this.b = true;
                                    return;
                                }
                                str6 = strA2;
                                strK = k();
                                map = mapD;
                                String strA7 = a("UNIAD_SGM_APPID", Const.TYPE_SGM);
                                if (strK != null || strK.equals(strA7)) {
                                    str7 = Const.TYPE_CSJ;
                                } else {
                                    str7 = Const.TYPE_CSJ;
                                    JSONArray jSONArrayA7 = a(Const.TYPE_SGM);
                                    if (!a(strK, jSONArrayA7)) {
                                        try {
                                            jSONObject.put("r", "1");
                                            jSONObject.put(strB, strK);
                                            jSONObject.put(strB2, strA7);
                                            jSONObject.put(strB3, jSONArrayA7);
                                        } catch (Exception unused18) {
                                        }
                                    }
                                }
                                if (listN.size() != 0) {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                } else {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                }
                                if (listN.size() != 0) {
                                    c();
                                } else {
                                    c();
                                }
                                if (listN.size() != 0) {
                                    h();
                                } else {
                                    h();
                                }
                                if (listN.size() != 0) {
                                    g();
                                } else {
                                    g();
                                }
                                if (listN.size() != 0) {
                                    m();
                                } else {
                                    m();
                                }
                                if (listN.size() != 0) {
                                    b();
                                } else {
                                    b();
                                }
                                if (listN.size() != 0) {
                                    l();
                                } else {
                                    l();
                                }
                                jSONObject4 = new JSONObject();
                                jSONObject5 = new JSONObject();
                                jSONObject6 = new JSONObject();
                                jSONObject7 = new JSONObject();
                                map2 = new HashMap();
                                if (TextUtils.isEmpty(str)) {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                } else {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                }
                                if (TextUtils.isEmpty(str5)) {
                                    str15 = str6;
                                    if (str5.equals(str15)) {
                                        z3 = z2;
                                        str11 = Const.TYPE_GDT;
                                        jSONArrayA3 = a(str11);
                                        if (a(str5, jSONArrayA3)) {
                                            str10 = Const.TYPE_SGM;
                                            a(6);
                                            jSONObject4.put("r", "1");
                                            jSONObject4.put(strB, str5);
                                            jSONObject4.put(strB2, String.valueOf(str15));
                                            jSONObject4.put(strB3, jSONArrayA3);
                                            z4 = false;
                                        } else {
                                            str10 = Const.TYPE_SGM;
                                        }
                                    } else {
                                        z3 = z2;
                                        str10 = Const.TYPE_SGM;
                                        str11 = Const.TYPE_GDT;
                                    }
                                    z4 = true;
                                } else {
                                    z3 = z2;
                                    str10 = Const.TYPE_SGM;
                                    str11 = Const.TYPE_GDT;
                                    z4 = true;
                                }
                                if (TextUtils.isEmpty(str4)) {
                                    z5 = z4;
                                    str12 = Const.TYPE_KS;
                                    z6 = true;
                                } else {
                                    z5 = z4;
                                    str12 = Const.TYPE_KS;
                                    z6 = true;
                                }
                                if (TextUtils.isEmpty(str3)) {
                                    z7 = z6;
                                    str13 = Const.TYPE_PG;
                                    z8 = true;
                                } else {
                                    z7 = z6;
                                    str13 = Const.TYPE_PG;
                                    z8 = true;
                                }
                                z9 = z8;
                                strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                if (!TextUtils.isEmpty(strB4)) {
                                    Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                    str14 = str13;
                                    strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                                    if (!strB4.equals(strA6)) {
                                        jSONArrayA2 = a(Const.TYPE_GG);
                                        if (!a(strB4, jSONArrayA2)) {
                                            jSONObject6.put("r", "1");
                                            jSONObject6.put(strB, strB4);
                                            jSONObject6.put(strB2, String.valueOf(strA6));
                                            jSONObject6.put(strB3, jSONArrayA2);
                                            z10 = false;
                                        }
                                    }
                                    if (z3) {
                                    }
                                    declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                    length = declaredMethods.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            method = null;
                                            break;
                                        }
                                        method = declaredMethods[i2];
                                        if (method.getName().equals("pr")) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                    HashMap map11 = new HashMap();
                                    map11.put("t", Integer.valueOf(i));
                                    jSONObject9 = new JSONObject();
                                    if (!z3) {
                                        jSONObject9.put(str8, new JSONObject(map2));
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    } else {
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    }
                                    map11.put("rad", jSONObject9.toString());
                                    method.setAccessible(true);
                                    method.invoke(null, this.a, map11);
                                    this.b = true;
                                    return;
                                }
                                str14 = str13;
                                z10 = true;
                                if (z3) {
                                }
                                declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                length = declaredMethods.length;
                                i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        method = null;
                                        break;
                                    }
                                    method = declaredMethods[i2];
                                    if (method.getName().equals("pr")) {
                                        break;
                                        break;
                                    }
                                    i2++;
                                }
                                HashMap map12 = new HashMap();
                                map12.put("t", Integer.valueOf(i));
                                jSONObject9 = new JSONObject();
                                if (!z3) {
                                    jSONObject9.put(str8, new JSONObject(map2));
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                } else {
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                }
                                map12.put("rad", jSONObject9.toString());
                                method.setAccessible(true);
                                method.invoke(null, this.a, map12);
                                this.b = true;
                                return;
                            }
                            i = 1;
                            if (listN.size() != 0) {
                                str6 = strA2;
                                if (listN.contains(e1.b((String) listA.get(3)))) {
                                    map = mapD;
                                }
                                str7 = Const.TYPE_CSJ;
                                if (listN.size() != 0) {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                } else {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                }
                                if (listN.size() != 0) {
                                    c();
                                } else {
                                    c();
                                }
                                if (listN.size() != 0) {
                                    h();
                                } else {
                                    h();
                                }
                                if (listN.size() != 0) {
                                    g();
                                } else {
                                    g();
                                }
                                if (listN.size() != 0) {
                                    m();
                                } else {
                                    m();
                                }
                                if (listN.size() != 0) {
                                    b();
                                } else {
                                    b();
                                }
                                if (listN.size() != 0) {
                                    l();
                                } else {
                                    l();
                                }
                                jSONObject4 = new JSONObject();
                                jSONObject5 = new JSONObject();
                                jSONObject6 = new JSONObject();
                                jSONObject7 = new JSONObject();
                                map2 = new HashMap();
                                if (TextUtils.isEmpty(str)) {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                } else {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                }
                                if (TextUtils.isEmpty(str5)) {
                                    str15 = str6;
                                    if (str5.equals(str15)) {
                                        z3 = z2;
                                        str11 = Const.TYPE_GDT;
                                        jSONArrayA3 = a(str11);
                                        if (a(str5, jSONArrayA3)) {
                                            str10 = Const.TYPE_SGM;
                                            a(6);
                                            jSONObject4.put("r", "1");
                                            jSONObject4.put(strB, str5);
                                            jSONObject4.put(strB2, String.valueOf(str15));
                                            jSONObject4.put(strB3, jSONArrayA3);
                                            z4 = false;
                                        } else {
                                            str10 = Const.TYPE_SGM;
                                        }
                                    } else {
                                        z3 = z2;
                                        str10 = Const.TYPE_SGM;
                                        str11 = Const.TYPE_GDT;
                                    }
                                    z4 = true;
                                } else {
                                    z3 = z2;
                                    str10 = Const.TYPE_SGM;
                                    str11 = Const.TYPE_GDT;
                                    z4 = true;
                                }
                                if (TextUtils.isEmpty(str4)) {
                                    z5 = z4;
                                    str12 = Const.TYPE_KS;
                                    z6 = true;
                                } else {
                                    z5 = z4;
                                    str12 = Const.TYPE_KS;
                                    z6 = true;
                                }
                                if (TextUtils.isEmpty(str3)) {
                                    z7 = z6;
                                    str13 = Const.TYPE_PG;
                                    z8 = true;
                                } else {
                                    z7 = z6;
                                    str13 = Const.TYPE_PG;
                                    z8 = true;
                                }
                                z9 = z8;
                                strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                if (!TextUtils.isEmpty(strB4)) {
                                    Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                    str14 = str13;
                                    strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                                    if (!strB4.equals(strA6)) {
                                        jSONArrayA2 = a(Const.TYPE_GG);
                                        if (!a(strB4, jSONArrayA2)) {
                                            jSONObject6.put("r", "1");
                                            jSONObject6.put(strB, strB4);
                                            jSONObject6.put(strB2, String.valueOf(strA6));
                                            jSONObject6.put(strB3, jSONArrayA2);
                                            z10 = false;
                                        }
                                    }
                                    if (z3) {
                                    }
                                    declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                    length = declaredMethods.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            method = null;
                                            break;
                                        }
                                        method = declaredMethods[i2];
                                        if (method.getName().equals("pr")) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                    HashMap map13 = new HashMap();
                                    map13.put("t", Integer.valueOf(i));
                                    jSONObject9 = new JSONObject();
                                    if (!z3) {
                                        jSONObject9.put(str8, new JSONObject(map2));
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    } else {
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    }
                                    map13.put("rad", jSONObject9.toString());
                                    method.setAccessible(true);
                                    method.invoke(null, this.a, map13);
                                    this.b = true;
                                    return;
                                }
                                str14 = str13;
                                z10 = true;
                                if (z3) {
                                }
                                declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                                length = declaredMethods.length;
                                i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        method = null;
                                        break;
                                    }
                                    method = declaredMethods[i2];
                                    if (method.getName().equals("pr")) {
                                        break;
                                        break;
                                    }
                                    i2++;
                                }
                                HashMap map14 = new HashMap();
                                map14.put("t", Integer.valueOf(i));
                                jSONObject9 = new JSONObject();
                                if (!z3) {
                                    jSONObject9.put(str8, new JSONObject(map2));
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                } else {
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                }
                                map14.put("rad", jSONObject9.toString());
                                method.setAccessible(true);
                                method.invoke(null, this.a, map14);
                                this.b = true;
                                return;
                            }
                            str6 = strA2;
                            if (TextUtils.isEmpty(str)) {
                                jSONObject8 = jSONObject2;
                                str8 = str7;
                                str9 = "10028";
                                z2 = true;
                            } else {
                                jSONObject8 = jSONObject2;
                                str8 = str7;
                                str9 = "10028";
                                z2 = true;
                            }
                            while (true) {
                                if (i2 < length) {
                                    method = null;
                                    break;
                                }
                                method = declaredMethods[i2];
                                if (method.getName().equals("pr")) {
                                    break;
                                    break;
                                }
                                i2++;
                            }
                        } catch (Exception unused19) {
                        }
                        if (!TextUtils.isEmpty(strB4)) {
                            Class.forName(e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                            str14 = str13;
                            strA6 = a(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), Const.TYPE_GG);
                            if (!strB4.equals(strA6)) {
                                jSONArrayA2 = a(Const.TYPE_GG);
                                if (!a(strB4, jSONArrayA2)) {
                                    jSONObject6.put("r", "1");
                                    jSONObject6.put(strB, strB4);
                                    jSONObject6.put(strB2, String.valueOf(strA6));
                                    jSONObject6.put(strB3, jSONArrayA2);
                                    z10 = false;
                                }
                            }
                            if (z3) {
                            }
                            declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                            length = declaredMethods.length;
                            i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    method = null;
                                    break;
                                }
                                method = declaredMethods[i2];
                                if (method.getName().equals("pr")) {
                                    break;
                                    break;
                                }
                                i2++;
                            }
                            HashMap map15 = new HashMap();
                            map15.put("t", Integer.valueOf(i));
                            jSONObject9 = new JSONObject();
                            if (!z3) {
                                jSONObject9.put(str8, new JSONObject(map2));
                                if (!z5) {
                                    jSONObject9.put(str11, jSONObject4);
                                }
                                if (!z7) {
                                    jSONObject9.put(str12, jSONObject5);
                                }
                                if (!z10) {
                                    jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                }
                                if (!z9) {
                                    jSONObject9.put(str14, jSONObject7);
                                }
                                if (jSONObject3.length() > 0) {
                                    jSONObject9.put(str10, jSONObject3);
                                }
                                if (jSONObject8.length() > 0) {
                                    jSONObject9.put(str9, jSONObject8);
                                }
                                if (this.c.length() > 0) {
                                    jSONObject9.put(Const.TYPE_BD, this.c);
                                }
                                if (this.d.length() > 0) {
                                    jSONObject9.put("10025", this.d);
                                }
                                if (this.e.length() > 0) {
                                    jSONObject9.put("10033", this.e);
                                }
                                if (this.f.length() > 0) {
                                    jSONObject9.put("10031", this.f);
                                }
                                if (this.g.length() > 0) {
                                    jSONObject9.put("10026", this.g);
                                }
                                if (this.h.length() > 0) {
                                    jSONObject9.put("10034", this.h);
                                }
                            } else {
                                if (!z5) {
                                    jSONObject9.put(str11, jSONObject4);
                                }
                                if (!z7) {
                                    jSONObject9.put(str12, jSONObject5);
                                }
                                if (!z10) {
                                    jSONObject9.put(Const.TYPE_GG, jSONObject6);
                                }
                                if (!z9) {
                                    jSONObject9.put(str14, jSONObject7);
                                }
                                if (jSONObject3.length() > 0) {
                                    jSONObject9.put(str10, jSONObject3);
                                }
                                if (jSONObject8.length() > 0) {
                                    jSONObject9.put(str9, jSONObject8);
                                }
                                if (this.c.length() > 0) {
                                    jSONObject9.put(Const.TYPE_BD, this.c);
                                }
                                if (this.d.length() > 0) {
                                    jSONObject9.put("10025", this.d);
                                }
                                if (this.e.length() > 0) {
                                    jSONObject9.put("10033", this.e);
                                }
                                if (this.f.length() > 0) {
                                    jSONObject9.put("10031", this.f);
                                }
                                if (this.g.length() > 0) {
                                    jSONObject9.put("10026", this.g);
                                }
                                if (this.h.length() > 0) {
                                    jSONObject9.put("10034", this.h);
                                }
                            }
                            map15.put("rad", jSONObject9.toString());
                            method.setAccessible(true);
                            method.invoke(null, this.a, map15);
                            this.b = true;
                            return;
                        }
                        str14 = str13;
                        declaredMethods = Class.forName(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(7)))).getDeclaredMethods();
                        length = declaredMethods.length;
                        i2 = 0;
                        HashMap map16 = new HashMap();
                        map16.put("t", Integer.valueOf(i));
                        jSONObject9 = new JSONObject();
                        if (!z3) {
                            jSONObject9.put(str8, new JSONObject(map2));
                            if (!z5) {
                                jSONObject9.put(str11, jSONObject4);
                            }
                            if (!z7) {
                                jSONObject9.put(str12, jSONObject5);
                            }
                            if (!z10) {
                                jSONObject9.put(Const.TYPE_GG, jSONObject6);
                            }
                            if (!z9) {
                                jSONObject9.put(str14, jSONObject7);
                            }
                            if (jSONObject3.length() > 0) {
                                jSONObject9.put(str10, jSONObject3);
                            }
                            if (jSONObject8.length() > 0) {
                                jSONObject9.put(str9, jSONObject8);
                            }
                            if (this.c.length() > 0) {
                                jSONObject9.put(Const.TYPE_BD, this.c);
                            }
                            if (this.d.length() > 0) {
                                jSONObject9.put("10025", this.d);
                            }
                            if (this.e.length() > 0) {
                                jSONObject9.put("10033", this.e);
                            }
                            if (this.f.length() > 0) {
                                jSONObject9.put("10031", this.f);
                            }
                            if (this.g.length() > 0) {
                                jSONObject9.put("10026", this.g);
                            }
                            if (this.h.length() > 0) {
                                jSONObject9.put("10034", this.h);
                            }
                        } else {
                            if (!z5) {
                                jSONObject9.put(str11, jSONObject4);
                            }
                            if (!z7) {
                                jSONObject9.put(str12, jSONObject5);
                            }
                            if (!z10) {
                                jSONObject9.put(Const.TYPE_GG, jSONObject6);
                            }
                            if (!z9) {
                                jSONObject9.put(str14, jSONObject7);
                            }
                            if (jSONObject3.length() > 0) {
                                jSONObject9.put(str10, jSONObject3);
                            }
                            if (jSONObject8.length() > 0) {
                                jSONObject9.put(str9, jSONObject8);
                            }
                            if (this.c.length() > 0) {
                                jSONObject9.put(Const.TYPE_BD, this.c);
                            }
                            if (this.d.length() > 0) {
                                jSONObject9.put("10025", this.d);
                            }
                            if (this.e.length() > 0) {
                                jSONObject9.put("10033", this.e);
                            }
                            if (this.f.length() > 0) {
                                jSONObject9.put("10031", this.f);
                            }
                            if (this.g.length() > 0) {
                                jSONObject9.put("10026", this.g);
                            }
                            if (this.h.length() > 0) {
                                jSONObject9.put("10034", this.h);
                            }
                        }
                        map16.put("rad", jSONObject9.toString());
                        method.setAccessible(true);
                        method.invoke(null, this.a, map16);
                        this.b = true;
                        return;
                    } catch (Exception unused20) {
                        return;
                    }
                    if (TextUtils.isEmpty(str5)) {
                        str15 = str6;
                        if (str5.equals(str15)) {
                            z3 = z2;
                            str11 = Const.TYPE_GDT;
                            jSONArrayA3 = a(str11);
                            if (a(str5, jSONArrayA3)) {
                                str10 = Const.TYPE_SGM;
                                a(6);
                                jSONObject4.put("r", "1");
                                jSONObject4.put(strB, str5);
                                jSONObject4.put(strB2, String.valueOf(str15));
                                jSONObject4.put(strB3, jSONArrayA3);
                                z4 = false;
                            } else {
                                str10 = Const.TYPE_SGM;
                            }
                        } else {
                            z3 = z2;
                            str10 = Const.TYPE_SGM;
                            str11 = Const.TYPE_GDT;
                        }
                        z4 = true;
                    } else {
                        z3 = z2;
                        str10 = Const.TYPE_SGM;
                        str11 = Const.TYPE_GDT;
                        z4 = true;
                    }
                } catch (Exception unused21) {
                }
                if (TextUtils.isEmpty(str3)) {
                    z7 = z6;
                    str13 = Const.TYPE_PG;
                    z8 = true;
                } else {
                    z7 = z6;
                    str13 = Const.TYPE_PG;
                    z8 = true;
                }
            } catch (Exception unused22) {
                z7 = z6;
                str13 = Const.TYPE_PG;
            }
            if (TextUtils.isEmpty(str4)) {
                z5 = z4;
                str12 = Const.TYPE_KS;
                z6 = true;
            } else {
                z5 = z4;
                str12 = Const.TYPE_KS;
                z6 = true;
            }
        } catch (Exception unused23) {
        }
        String strJ = j();
        boolean z11 = zEquals;
        strA4 = a("UNIAD_PG_APPID", Const.TYPE_PG);
        str2 = strJ;
        z = z11;
        strB = e1.b("kWixxal");
        str3 = str2;
        strB2 = e1.b("{Wixxal");
        String str19 = strA4;
        strB3 = e1.b("{WixxalW`");
        jSONObject = new JSONObject();
        String str110 = strA3;
        jSONObject2 = new JSONObject();
        str4 = strI;
        str5 = strF;
        strK = k();
        map = mapD;
        String strA8 = a("UNIAD_SGM_APPID", Const.TYPE_SGM);
        if (strK != null) {
            str7 = Const.TYPE_CSJ;
        } else {
            str7 = Const.TYPE_CSJ;
        }
        if (listN.size() != 0) {
            strE = e();
            strA5 = a("", "10028");
            if (strE == null) {
                jSONObject3 = jSONObject;
            } else {
                if (strA5 == null) {
                    jSONObject2.put("r", "1");
                    jSONObject2.put(strB, strE);
                } else if (!strE.equals(strA5)) {
                    jSONObject3 = jSONObject;
                    jSONArrayA = a("10028");
                    if (!a(strE, jSONArrayA)) {
                        jSONObject2.put("r", "1");
                        jSONObject2.put(strB, strE);
                        jSONObject2.put(strB2, strA5);
                        jSONObject2.put(strB3, jSONArrayA);
                    }
                }
                jSONObject3 = jSONObject;
            }
        } else {
            strE = e();
            strA5 = a("", "10028");
            if (strE == null) {
                jSONObject3 = jSONObject;
            } else {
                if (strA5 == null) {
                    jSONObject2.put("r", "1");
                    jSONObject2.put(strB, strE);
                } else if (!strE.equals(strA5)) {
                    jSONObject3 = jSONObject;
                    jSONArrayA = a("10028");
                    if (!a(strE, jSONArrayA)) {
                        jSONObject2.put("r", "1");
                        jSONObject2.put(strB, strE);
                        jSONObject2.put(strB2, strA5);
                        jSONObject2.put(strB3, jSONArrayA);
                    }
                }
                jSONObject3 = jSONObject;
            }
        }
        if (listN.size() != 0) {
            c();
        } else {
            c();
        }
        if (listN.size() != 0) {
            h();
        } else {
            h();
        }
        if (listN.size() != 0) {
            g();
        } else {
            g();
        }
        if (listN.size() != 0) {
            m();
        } else {
            m();
        }
        if (listN.size() != 0) {
            b();
        } else {
            b();
        }
        if (listN.size() != 0) {
            l();
        } else {
            l();
        }
        jSONObject4 = new JSONObject();
        jSONObject5 = new JSONObject();
        jSONObject6 = new JSONObject();
        jSONObject7 = new JSONObject();
        map2 = new HashMap();
        z9 = z8;
        strB4 = b(e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
        z10 = true;
        if (z3) {
        }
    }

    private boolean a(String str, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.equals(jSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private String a(String str, String str2) {
        byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(3));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            return (String) Class.forName(strDecrypt).getMethod("da", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return "";
        }
    }

    private JSONArray a(String str) {
        byte[] bArrDecode2bytes = Base64.decode2bytes(r4.a(3));
        if (bArrDecode2bytes == null) {
            a(4);
            return null;
        }
        String strDecrypt = AESUtil.decrypt(e1.e(), e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return null;
        }
        try {
            return (JSONArray) Class.forName(strDecrypt).getMethod("dah", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(int i) {
        if (this.a == null) {
            return;
        }
        g0 g0Var = new g0((Activity) this.a, "");
        TextView textView = new TextView(this.a);
        textView.setAutoLinkMask(1);
        textView.setClickable(true);
        textView.setText(a4.a(this.a).a(AESUtil.decrypt(e1.e(), e1.b(), Base64.decode2bytes(r4.a(i)))));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.addView(textView);
        g0Var.a(linearLayout, textView);
        g0Var.setDuration(1);
        g0Var.setGravity(80, g0Var.getXOffset(), g0Var.getYOffset());
        int iDip2px = CanvasHelper.dip2px(this.a, 10.0f);
        int iDip2px2 = CanvasHelper.dip2px(this.a, 8.0f);
        linearLayout.setPadding(iDip2px, iDip2px2, iDip2px, iDip2px2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(iDip2px2);
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1308622848);
        linearLayout.setBackground(gradientDrawable);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#ffffffff"));
        g0Var.show();
    }
}
