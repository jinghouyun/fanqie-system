package io.dcloud.p;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IEventCallback;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.message.action.PermissionRequestAction;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.ui.AdaFrameView;
import io.dcloud.common.adapter.ui.AdaUniWebView;
import io.dcloud.common.adapter.util.PermissionUtil;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.core.permission.PermissionControler;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.feature.internal.sdk.SDK;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class x2 implements IEventCallback {
    static HashMap b = new HashMap(2);
    static x2 c = null;
    ArrayList a = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends PermissionUtil.Request {
        final /* synthetic */ JSONArray a;
        final /* synthetic */ IWebview b;
        final /* synthetic */ String[] c;
        final /* synthetic */ JSONArray d;
        final /* synthetic */ JSONArray e;
        final /* synthetic */ JSONArray f;

        a(JSONArray jSONArray, IWebview iWebview, String[] strArr, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
            this.a = jSONArray;
            this.b = iWebview;
            this.c = strArr;
            this.d = jSONArray2;
            this.e = jSONArray3;
            this.f = jSONArray4;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(String str) {
            String strConvertNativePermission = PermissionUtil.convertNativePermission(str);
            try {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this.b.getActivity(), strConvertNativePermission)) {
                    this.e.put(strConvertNativePermission);
                } else {
                    this.f.put(strConvertNativePermission);
                }
            } catch (RuntimeException unused) {
            }
            x2.this.a(this.b, this.c, this.d, this.a, this.e, this.f);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(String str) {
            this.a.put(PermissionUtil.convertNativePermission(str));
            x2.this.a(this.b, this.c, this.d, this.a, this.e, this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements ISysEventListener {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        b(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(ISysEventListener.SysEventType sysEventType, Object obj) {
            if (sysEventType != ISysEventListener.SysEventType.onActivityResult) {
                return false;
            }
            Object[] objArr = (Object[]) obj;
            int iIntValue = ((Integer) objArr[0]).intValue();
            int iIntValue2 = ((Integer) objArr[1]).intValue();
            Intent intent = (Intent) objArr[2];
            StringBuffer stringBuffer = new StringBuffer(Operators.ARRAY_START_STR);
            stringBuffer.append(iIntValue);
            stringBuffer.append(",").append(iIntValue2);
            if (intent != null) {
                stringBuffer.append(",").append(x2.a(this.a, intent));
            }
            stringBuffer.append(Operators.ARRAY_END_STR);
            Deprecated_JSUtil.execCallback(this.a, this.b, stringBuffer.toString(), JSUtil.OK, true, true);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c implements IEventCallback {
        final /* synthetic */ IWebview a;
        final /* synthetic */ ISysEventListener b;

        c(IWebview iWebview, ISysEventListener iSysEventListener) {
            this.a = iWebview;
            this.b = iSysEventListener;
        }

        @Override // io.dcloud.common.DHInterface.IEventCallback
        public Object onCallBack(String str, Object obj) {
            if (!PdrUtil.isEquals(str, AbsoluteConst.EVENTS_WINDOW_CLOSE) && !PdrUtil.isEquals(str, AbsoluteConst.EVENTS_CLOSE)) {
                return null;
            }
            this.a.obtainApp().unregisterSysEventListener(this.b, ISysEventListener.SysEventType.onActivityResult);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ISysEventListener.SysEventType.values().length];
            a = iArr;
            try {
                iArr[ISysEventListener.SysEventType.onActivityResult.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public x2(AbsMgr absMgr) {
        c = this;
    }

    static void b(Class cls, JSONStringer jSONStringer, ArrayList arrayList) throws JSONException {
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            String name = superclass.getName();
            if (!arrayList.contains(name)) {
                jSONStringer.value(name);
                arrayList.add(name);
                a(superclass, jSONStringer, arrayList);
            }
            if (superclass == Object.class) {
                return;
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public Object onCallBack(String str, Object obj) {
        if (!PdrUtil.isEquals(str, AbsoluteConst.EVENTS_CLOSE) || !(obj instanceof IWebview)) {
            return null;
        }
        try {
            ((AdaFrameView) ((IWebview) obj).obtainFrameView()).removeFrameViewListener(this);
            this.a.remove(Integer.valueOf(((IWebview) obj).hashCode()));
            HashMap map = (HashMap) b.remove(Integer.valueOf(((IWebview) obj).hashCode()));
            if (map == null) {
                return null;
            }
            for (Map.Entry entry : map.entrySet()) {
                b.remove(entry.getKey());
                ((j3) entry.getValue()).a();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String a(IWebview iWebview, String str, String[] strArr) {
        j3 j3Var;
        JSONArray jSONArray;
        Class cls;
        String str2;
        Object objA;
        JSONArray jSONArray2;
        x2 x2Var = this;
        String[] strArr2 = strArr;
        if (!x2Var.a.contains(Integer.valueOf(iWebview.hashCode()))) {
            x2Var.a.add(Integer.valueOf(iWebview.hashCode()));
            ((AdaFrameView) iWebview.obtainFrameView()).addFrameViewListener(x2Var);
        }
        boolean zOptBoolean = true;
        int i = 0;
        if ("__Instance".equals(str)) {
            String str3 = strArr2[0];
            String str4 = strArr2[1];
            if (strArr2.length <= 2 || PdrUtil.isEmpty(strArr2[2])) {
                jSONArray2 = null;
            } else {
                JSONArray jSONArrayCreateJSONArray = JSONUtil.createJSONArray(strArr2[2]);
                JSONObject jSONObject = JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 0);
                zOptBoolean = jSONObject != null ? "boolean".equals(jSONObject.optString("type")) ? jSONObject.optBoolean("value") : true ^ PdrUtil.isEquals("__super__constructor__", JSONUtil.getString(jSONObject, "value")) : true;
                jSONArray2 = jSONArrayCreateJSONArray;
            }
            if (zOptBoolean) {
                try {
                    try {
                        a(iWebview, str3, new j3(iWebview, x2Var, k3.a(str4), str3, jSONArray2));
                        return null;
                    } catch (Exception e) {
                        e = e;
                        String strA = a(e, "new " + str4);
                        Log.e("InvProxy", "NativeObject.execMethod __Instance " + str4 + " method ; params=" + jSONArray2 + e);
                        return strA;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } else {
            IWebview iWebview2 = iWebview;
            if ("release".equals(str) || "__autoCollection".equals(str)) {
                String str5 = strArr[0];
                HashMap mapA = a(iWebview);
                if (mapA != null && (j3Var = (j3) mapA.remove(str5)) != null) {
                    j3Var.a();
                }
            } else {
                if ("getWebviewById".equals(str)) {
                    return b(iWebview2, SDK.obtainWebview(iWebview2.obtainFrameView().obtainApp().obtainAppId(), strArr2[0]).obtainWebview());
                }
                if ("currentWebview".equals(str)) {
                    return iWebview2 instanceof AdaUniWebView ? "" : b(iWebview2, iWebview2.obtainWebview());
                }
                if ("getContext".equals(str)) {
                    String str6 = strArr2[0];
                    String strB = b(iWebview2, iWebview2.getActivity());
                    x2Var.a(iWebview2, "onActivityResult", str6);
                    return strB;
                }
                if ("importFields".equals(str)) {
                    j3 j3VarA = x2Var.a(iWebview2, strArr2[0]);
                    if (j3VarA != null) {
                        return JSUtil.wrapJsVar(j3VarA.a(iWebview2, j3VarA.a));
                    }
                } else {
                    if ("import".equals(str)) {
                        return Deprecated_JSUtil.wrapJsVar(k3.a(iWebview2, x2Var, strArr2[0]), false);
                    }
                    if ("__plusGetAttribute".equals(str)) {
                        String str7 = strArr2[0];
                        String str8 = strArr2[1];
                        j3 j3VarA2 = x2Var.a(iWebview2, str7);
                        if (j3VarA2 != null && (objA = j3.a(j3VarA2.b, j3VarA2.c, str8)) != null) {
                            return b(iWebview2, objA);
                        }
                    } else if ("__plusSetAttribute".equals(str)) {
                        String str9 = strArr2[0];
                        String str10 = strArr2[1];
                        JSONArray jSONArrayCreateJSONArray2 = JSONUtil.createJSONArray(strArr2[2]);
                        j3 j3VarA3 = x2Var.a(iWebview2, str9);
                        if (j3VarA3 != null) {
                            j3.b(iWebview, x2Var, j3VarA3.b, j3VarA3.c, str10, jSONArrayCreateJSONArray2);
                            return null;
                        }
                    } else {
                        if ("implements".equals(str)) {
                            String str11 = strArr2[0];
                            y2 y2Var = new y2(iWebview2, strArr2[1], JSONUtil.createJSONArray(strArr2[2]), strArr2[3]);
                            y2Var.a = str11;
                            return b(iWebview2, y2Var.a(null));
                        }
                        if (!"__loadDylib".equals(str) && !"__release".equals(str)) {
                            if ("__inheritList".equals(str)) {
                                String str12 = strArr2[0];
                                try {
                                    String str13 = strArr2[1];
                                    if (TextUtils.isEmpty(str13)) {
                                        return k3.b(str12);
                                    }
                                    j3 j3VarA4 = x2Var.a(iWebview2, str13);
                                    return j3VarA4 != null ? k3.c(j3VarA4.b) : k3.b(str12);
                                } catch (Exception e3) {
                                    return a(e3, "importClass " + str12);
                                }
                            }
                            if (!"__execCFunction".equals(str)) {
                                if ("__newObject".equals(str)) {
                                    String str14 = strArr2[0];
                                    JSONArray jSONArrayCreateJSONArray3 = JSONUtil.createJSONArray(strArr2[1]);
                                    try {
                                        return b(iWebview2, j3.a(iWebview2, x2Var, k3.a(str14), jSONArrayCreateJSONArray3));
                                    } catch (Exception e4) {
                                        String strA2 = a(e4, "newObject " + str14);
                                        Log.e("InvProxy", "NativeObject.execMethod __newObject " + str14 + " method ; params=" + jSONArrayCreateJSONArray3 + e4);
                                        return strA2;
                                    }
                                }
                                if ("__execStatic".equals(str)) {
                                    String str15 = strArr2[0];
                                    String str16 = strArr2[1];
                                    if (!x2Var.a(str15, str16, iWebview2)) {
                                        JSONArray jSONArrayCreateJSONArray4 = (strArr2.length <= 2 || PdrUtil.isEmpty(strArr2[2])) ? null : JSONUtil.createJSONArray(strArr2[2]);
                                        Class clsA = k3.a(str15);
                                        if (clsA == null) {
                                            str2 = str15;
                                            cls = String.class;
                                        } else {
                                            cls = clsA;
                                            str2 = null;
                                        }
                                        try {
                                            Object objA2 = j3.a(iWebview2, x2Var, cls, str2, str16, jSONArrayCreateJSONArray4);
                                            if (objA2 != null) {
                                                try {
                                                    return b(iWebview2, objA2);
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    String strA3 = a(e, "static " + cls.getName() + Operators.DOT_STR + str16);
                                                    Log.e("InvProxy", "NativeObject.execMethod " + str16 + " method ; params=" + cls + e);
                                                    return strA3;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                        }
                                    }
                                } else if ("__exec".equals(str)) {
                                    String str17 = strArr2[0];
                                    String str18 = strArr2[1];
                                    if (!x2Var.a("", str18, iWebview2)) {
                                        JSONArray jSONArrayCreateJSONArray5 = JSONUtil.createJSONArray(strArr2[2]);
                                        j3 j3VarA5 = x2Var.a(iWebview2, str17);
                                        if (j3VarA5 != null) {
                                            try {
                                                Object objA3 = j3VarA5.a(iWebview2, str18, jSONArrayCreateJSONArray5);
                                                if (objA3 != null) {
                                                    return b(iWebview2, objA3);
                                                }
                                            } catch (Exception e7) {
                                                String strA4 = a(e7, j3VarA5.b.getName() + Operators.DOT_STR + str18);
                                                Log.e("InvProxy", "NativeObject.execMethod " + str18 + " method ; params=" + jSONArrayCreateJSONArray5 + e7);
                                                return strA4;
                                            }
                                        }
                                    }
                                } else {
                                    if ("__saveContent".equals(str)) {
                                        DHFile.writeFile(strArr2[1].toString().getBytes(), 0, iWebview2.obtainFrameView().obtainApp().convert2AbsFullPath(iWebview2.obtainFullUrl(), strArr2[0]));
                                        return null;
                                    }
                                    if ("requestPermissions".equals(str)) {
                                        JSONArray jSONArrayCreateJSONArray6 = JSONUtil.createJSONArray(strArr2[1]);
                                        ArrayList arrayList = new ArrayList();
                                        JSONArray jSONArray3 = new JSONArray();
                                        JSONArray jSONArray4 = new JSONArray();
                                        JSONArray jSONArray5 = new JSONArray();
                                        ArrayList arrayList2 = new ArrayList();
                                        int i2 = 0;
                                        while (i2 < jSONArrayCreateJSONArray6.length()) {
                                            String strOptString = jSONArrayCreateJSONArray6.optString(i2);
                                            int iCheckSelfPermission = PermissionChecker.checkSelfPermission(iWebview2.getActivity(), strOptString);
                                            arrayList2.add(strOptString);
                                            if (iCheckSelfPermission != 0) {
                                                if (iWebview2.getActivity().getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
                                                    jSONArray5.put(strOptString);
                                                    x2Var.a(iWebview2, strArr2, jSONArrayCreateJSONArray6, jSONArray3, jSONArray4, jSONArray4);
                                                } else {
                                                    arrayList.add(strOptString);
                                                }
                                                jSONArray = jSONArray5;
                                            } else {
                                                jSONArray3.put(strOptString);
                                                jSONArray = jSONArray5;
                                                a(iWebview, strArr, jSONArrayCreateJSONArray6, jSONArray3, jSONArray4, jSONArray);
                                            }
                                            i2++;
                                            x2Var = this;
                                            iWebview2 = iWebview;
                                            strArr2 = strArr;
                                            jSONArray5 = jSONArray;
                                        }
                                        JSONArray jSONArray6 = jSONArray5;
                                        PermissionControler.invokeUTSAndroidPermissionRequest(PermissionRequestAction.TYPE_REQUEST, (String[]) arrayList2.toArray(new String[0]));
                                        if (arrayList.size() == 0) {
                                            PermissionControler.invokeUTSAndroidPermissionRequest(PermissionRequestAction.TYPE_COMPLETE, (String[]) arrayList2.toArray(new String[0]));
                                            return null;
                                        }
                                        if (jSONArray3.length() > 0 || jSONArray6.length() > 0) {
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                                arrayList3.add(jSONArray3.optString(i3));
                                            }
                                            for (int i4 = 0; i4 < jSONArray6.length(); i4++) {
                                                arrayList3.add(jSONArray6.optString(i4));
                                            }
                                            PermissionControler.invokeUTSAndroidPermissionRequest(PermissionRequestAction.TYPE_COMPLETE, (String[]) arrayList3.toArray(new String[0]));
                                        }
                                        String[] strArr3 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                                        a aVar = new a(jSONArray3, iWebview, strArr, jSONArrayCreateJSONArray6, jSONArray4, jSONArray6);
                                        aVar.setTriggerRequestEvent(true);
                                        PermissionUtil.requestSystemPermissions(iWebview.getActivity(), strArr3, PermissionUtil.getRequestCode(), aVar, false);
                                        return null;
                                    }
                                    if ("checkPermission".equals(str)) {
                                        String str19 = strArr[0];
                                        int iCheckSelfPermission2 = PermissionChecker.checkSelfPermission(iWebview.getActivity(), strArr[1]);
                                        if (iCheckSelfPermission2 == -2) {
                                            i = -2;
                                        } else if (iCheckSelfPermission2 == -1) {
                                            i = -1;
                                        } else if (iCheckSelfPermission2 != 0) {
                                            i = iCheckSelfPermission2;
                                        }
                                        Deprecated_JSUtil.execCallback(iWebview, str19, "{checkResult:+" + i + Operators.BLOCK_END_STR, JSUtil.OK, true, false);
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    static String b(IWebview iWebview, Object obj) {
        String str;
        Class<?> cls = obj.getClass();
        String strB = k3.b(cls);
        if (!k3.a((Class) cls) && cls != String.class && cls != CharSequence.class && !cls.isArray()) {
            str = "object";
        } else {
            str = "basic";
        }
        StringBuffer stringBuffer = new StringBuffer();
        a(iWebview, obj, cls, stringBuffer);
        return Deprecated_JSUtil.wrapJsVar(StringUtil.format("{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}", str, stringBuffer.toString(), strB, a((Class) cls)), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IWebview iWebview, String[] strArr, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        if (jSONArray.length() == jSONArray2.length() + jSONArray3.length() + jSONArray4.length()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("granted", jSONArray2);
                jSONObject.put("deniedPresent", jSONArray3);
                jSONObject.put("deniedAlways", jSONArray4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Deprecated_JSUtil.execCallback(iWebview, strArr[0], jSONObject.toString(), JSUtil.OK, true, false);
        }
    }

    private static String a(Exception exc, String str) {
        Exception message;
        StringBuilder sb = new StringBuilder();
        if (exc.getCause() != null) {
            message = exc.getCause();
        } else if (!TextUtils.isEmpty(exc.getMessage())) {
            message = exc;
            message = exc.getMessage();
        }
        message = exc;
        sb.append(message);
        sb.append(";at ");
        sb.append(str);
        return StringUtil.format("throw '%s';", sb.toString());
    }

    private void a(IWebview iWebview, String str, String str2) {
        if (d.a[ISysEventListener.SysEventType.valueOf(str).ordinal()] != 1) {
            return;
        }
        b bVar = new b(iWebview, str2);
        iWebview.obtainApp().registerSysEventListener(bVar, ISysEventListener.SysEventType.onActivityResult);
        iWebview.obtainFrameView().addFrameViewListener(new c(iWebview, bVar));
    }

    static String a(IWebview iWebview, Object obj) {
        String strValueOf;
        Class<?> cls = obj.getClass();
        String strB = k3.b(cls);
        if (cls != String.class && cls != CharSequence.class) {
            if (k3.a((Class) cls)) {
                strValueOf = String.valueOf(obj);
            } else {
                String strA = a(obj);
                a(iWebview, strA, obj);
                return StringUtil.format("plus.ios.__Tool.New(%s, true)", Deprecated_JSUtil.wrapJsVar(StringUtil.format("{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}", "object", JSUtil.QUOTE + strA + JSUtil.QUOTE, strB, a((Class) cls)), false));
            }
        } else {
            strValueOf = JSUtil.QUOTE + String.valueOf(obj) + JSUtil.QUOTE;
        }
        return Deprecated_JSUtil.wrapJsVar(StringUtil.format("{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}", "basic", strValueOf, strB, a((Class) cls)), false);
    }

    static String a(Class cls) {
        JSONStringer jSONStringer = new JSONStringer();
        ArrayList arrayList = new ArrayList();
        try {
            jSONStringer.array();
            b(cls, jSONStringer, arrayList);
            jSONStringer.endArray();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String string = jSONStringer.toString();
        return string == null ? "[]" : string;
    }

    static void a(Class cls, JSONStringer jSONStringer, ArrayList arrayList) throws JSONException {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces != null) {
            for (Class<?> cls2 : interfaces) {
                String name = cls2.getName();
                if (!arrayList.contains(name)) {
                    jSONStringer.value(name);
                    arrayList.add(name);
                    a(cls2, jSONStringer, arrayList);
                }
            }
        }
    }

    static void a(IWebview iWebview, Object obj, Class cls, StringBuffer stringBuffer) {
        if (cls != String.class && cls != CharSequence.class) {
            if (k3.a(cls)) {
                stringBuffer.append(String.valueOf(obj));
                return;
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                stringBuffer.append(Operators.ARRAY_START_STR);
                for (int i = 0; i < length; i++) {
                    stringBuffer.append(b(iWebview, k3.a(Array.get(obj, i), cls)));
                    if (i != length - 1) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append(Operators.ARRAY_END_STR);
                return;
            }
            String strA = a(obj);
            a(iWebview, strA, obj);
            stringBuffer.append(JSUtil.QUOTE).append(strA).append(JSUtil.QUOTE);
            return;
        }
        stringBuffer.append(JSONObject.quote(String.valueOf(obj)));
    }

    private static HashMap a(IWebview iWebview) {
        HashMap map = (HashMap) b.get(Integer.valueOf(iWebview.hashCode()));
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap(2);
        b.put(Integer.valueOf(iWebview.hashCode()), map2);
        return map2;
    }

    j3 a(HashMap map, String str) {
        return (j3) map.get(str);
    }

    j3 a(IWebview iWebview, String str) {
        return a(a(iWebview), str);
    }

    private static void a(IWebview iWebview, String str, j3 j3Var) {
        a(iWebview).put(str, j3Var);
    }

    private static j3 a(IWebview iWebview, String str, Object obj) {
        j3 j3Var = new j3(c, obj.getClass(), str, obj);
        a(iWebview, str, j3Var);
        return j3Var;
    }

    static String a(Object obj) {
        return IFeature.F_INVOCATION + obj.hashCode();
    }

    private boolean a(String str, String str2, IWebview iWebview) {
        return iWebview != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && Boolean.parseBoolean(iWebview.obtainApp().obtainConfigProperty(IApp.ConfigProperty.CONFIG_USE_ENCRYPTION)) && "setWebContentsDebuggingEnabled".equalsIgnoreCase(str2) && (TextUtils.isEmpty(str) || "WebView".equalsIgnoreCase(str) || "android.webkit.WebView".equalsIgnoreCase(str));
    }

    public void a(String str) {
        TextUtils.isEmpty(str);
    }
}
