package io.dcloud.feature.ui.nativeui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.alibaba.android.bindingx.core.internal.BindingXConstants;
import com.dcloud.android.widget.dialog.DCloudAlertDialog;
import com.dcloud.android.widget.toast.ToastCompat;
import com.taobao.weex.common.Constants;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.taobao.weex.ui.module.WXModalUIModule;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IActivityHandler;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.CanvasHelper;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.constant.DataInterface;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.DialogUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.RuningAcitvityUtil;
import io.dcloud.feature.nativeObj.photoview.LongClickEventManager;
import io.dcloud.p.g0;
import io.src.dcloud.adapter.DCloudAdapterUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class NativeUIFeatureImpl implements IFeature {
    int d;
    int e;
    int f;
    int h;
    int i;
    AbsMgr m;
    HashMap a = null;
    HashMap b = null;
    DatePickerDialog c = null;
    TimePickerDialog g = null;
    final byte j = 0;
    final byte k = 1;
    final byte l = 2;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements DialogInterface.OnClickListener {
        final /* synthetic */ byte a;
        final /* synthetic */ EditText b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ AlertDialog f;

        a(byte b, EditText editText, IWebview iWebview, String str, int i, AlertDialog alertDialog) {
            this.a = b;
            this.b = editText;
            this.c = iWebview;
            this.d = str;
            this.e = i;
            this.f = alertDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.a == 2) {
                String jSONableString = JSONUtil.toJSONableString(this.b.getText().toString());
                Deprecated_JSUtil.execCallback(this.c, this.d, "{index:" + this.e + ",message:" + jSONableString + Operators.BLOCK_END_STR, JSUtil.OK, true, false);
            }
            if (this.a == 1) {
                Deprecated_JSUtil.execCallback(this.c, this.d, String.valueOf(this.e), JSUtil.OK, true, false);
            }
            this.f.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements DialogInterface.OnKeyListener {
        final /* synthetic */ byte a;
        final /* synthetic */ EditText b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;
        final /* synthetic */ AlertDialog e;

        b(byte b, EditText editText, IWebview iWebview, String str, AlertDialog alertDialog) {
            this.a = b;
            this.b = editText;
            this.c = iWebview;
            this.d = str;
            this.e = alertDialog;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            if (this.a == 2) {
                String jSONableString = JSONUtil.toJSONableString(this.b.getText().toString());
                Deprecated_JSUtil.execCallback(this.c, this.d, "{index:-1,message:" + jSONableString + Operators.BLOCK_END_STR, JSUtil.OK, true, false);
            }
            if (this.a == 1) {
                Deprecated_JSUtil.execCallback(this.c, this.d, String.valueOf(-1), JSUtil.OK, true, false);
            }
            this.e.dismiss();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c extends LongClickEventManager.OnLongClickListener {
        c(IWebview iWebview, String str) {
            super(iWebview, str);
        }

        @Override // io.dcloud.feature.nativeObj.photoview.LongClickEventManager.OnLongClickListener
        public void onLongClickListener(JSONObject jSONObject) {
            Deprecated_JSUtil.execCallback(getPwebview(), getCallbackIds(), jSONObject.toString(), JSUtil.OK, true, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements io.dcloud.feature.ui.nativeui.a.b {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        d(IWebview iWebview, String str, String str2) {
            this.a = iWebview;
            this.b = str;
            this.c = str2;
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void initCancelText(TextView textView) {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void initTextItem(int i, TextView textView, String str) {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public boolean onDismiss(int i) {
            HashMap map = NativeUIFeatureImpl.this.b;
            if (map == null || !map.containsKey(this.c)) {
                return false;
            }
            NativeUIFeatureImpl.this.b.remove(this.c);
            return false;
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void onItemClick(int i) {
            Deprecated_JSUtil.execCallback(this.a, this.b, "" + i, JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements DatePickerDialog.OnDateSetListener {
        e() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            NativeUIFeatureImpl nativeUIFeatureImpl = NativeUIFeatureImpl.this;
            nativeUIFeatureImpl.d = i;
            nativeUIFeatureImpl.e = i2;
            nativeUIFeatureImpl.f = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class f extends DatePickerDialog {
        int a;
        int b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;
        final /* synthetic */ IWebview h;
        final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Context context, int i, DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, IWebview iWebview, String str) {
            super(context, i, onDateSetListener, i2, i3, i4);
            this.d = i5;
            this.e = i6;
            this.f = i7;
            this.g = z;
            this.h = iWebview;
            this.i = str;
            this.a = i5;
            this.b = i6;
            this.c = i7;
        }

        @Override // android.app.DatePickerDialog, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            super.onClick(dialogInterface, i);
            if (i == -2) {
                Deprecated_JSUtil.execCallback(this.h, this.i, DOMException.toJSON(-2, DOMException.MSG_USER_CANCEL), JSUtil.ERROR, true, false);
            } else if (i == -1) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                if (DeviceInfo.sDeviceSdkVer >= 21) {
                    NativeUIFeatureImpl nativeUIFeatureImpl = NativeUIFeatureImpl.this;
                    gregorianCalendar.set(nativeUIFeatureImpl.d, nativeUIFeatureImpl.e, nativeUIFeatureImpl.f, 0, 0, 0);
                } else {
                    gregorianCalendar.set(this.a, this.b, this.c, 0, 0, 0);
                }
                Deprecated_JSUtil.execCallback(this.h, this.i, String.valueOf(gregorianCalendar.getTime().getTime()), JSUtil.OK, true, false);
            }
            NativeUIFeatureImpl.this.a();
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(2);
        }

        @Override // android.app.DatePickerDialog, android.widget.DatePicker.OnDateChangedListener
        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            if (this.g || DeviceInfo.sVersion_release.equals("4.0.3") || DeviceInfo.sVersion_release.equals("4.0.4")) {
                return;
            }
            super.onDateChanged(datePicker, i, i2, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class g implements DialogInterface.OnDismissListener {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        g(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (NativeUIFeatureImpl.this.c != null) {
                Deprecated_JSUtil.execCallback(this.a, this.b, DOMException.toJSON(-2, DOMException.MSG_USER_CANCEL), JSUtil.ERROR, true, false);
                NativeUIFeatureImpl.this.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class h implements TimePickerDialog.OnTimeSetListener {
        h() {
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            NativeUIFeatureImpl nativeUIFeatureImpl = NativeUIFeatureImpl.this;
            nativeUIFeatureImpl.h = i;
            nativeUIFeatureImpl.i = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class i extends TimePickerDialog {
        int a;
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;
        final /* synthetic */ IWebview f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Context context, int i, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, boolean z, int i4, int i5, boolean z2, IWebview iWebview, String str) {
            super(context, i, onTimeSetListener, i2, i3, z);
            this.c = i4;
            this.d = i5;
            this.e = z2;
            this.f = iWebview;
            this.g = str;
            this.a = i4;
            this.b = i5;
        }

        @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            super.onClick(dialogInterface, i);
            if (i == -2) {
                Deprecated_JSUtil.execCallback(this.f, this.g, DOMException.toJSON(-2, DOMException.MSG_USER_CANCEL), JSUtil.ERROR, true, false);
            } else if (i == -1) {
                Date date = new Date();
                if (DeviceInfo.sDeviceSdkVer >= 21) {
                    date.setHours(NativeUIFeatureImpl.this.h);
                    date.setMinutes(NativeUIFeatureImpl.this.i);
                } else {
                    date.setHours(this.a);
                    date.setMinutes(this.b);
                }
                Deprecated_JSUtil.execCallback(this.f, this.g, String.valueOf(date.getTime()), JSUtil.OK, true, false);
            }
            NativeUIFeatureImpl.this.b();
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(2);
        }

        @Override // android.app.TimePickerDialog, android.widget.TimePicker.OnTimeChangedListener
        public void onTimeChanged(TimePicker timePicker, int i, int i2) {
            this.a = i;
            this.b = i2;
            if (this.e) {
                return;
            }
            setTitle(i + ":" + i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class j implements DialogInterface.OnDismissListener {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String b;

        j(IWebview iWebview, String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (NativeUIFeatureImpl.this.g != null) {
                Deprecated_JSUtil.execCallback(this.a, this.b, DOMException.toJSON(-2, DOMException.MSG_USER_CANCEL), JSUtil.ERROR, true, false);
                NativeUIFeatureImpl.this.b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class k implements DialogInterface.OnClickListener {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ IWebview b;
        final /* synthetic */ String c;

        k(AlertDialog alertDialog, IWebview iWebview, String str) {
            this.a = alertDialog;
            this.b = iWebview;
            this.c = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.dismiss();
            Deprecated_JSUtil.execCallback(this.b, this.c, "{index:0}", JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class l implements DialogInterface.OnKeyListener {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ IWebview b;
        final /* synthetic */ String c;

        l(AlertDialog alertDialog, IWebview iWebview, String str) {
            this.a = alertDialog;
            this.b = iWebview;
            this.c = str;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            this.a.dismiss();
            Deprecated_JSUtil.execCallback(this.b, this.c, "{index:-1}", JSUtil.OK, true, false);
            return true;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
        if (PdrUtil.isEmpty(str)) {
            this.m = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) throws Throwable {
        byte b2;
        IActivityHandler iActivityHandler;
        String strOptString;
        io.dcloud.feature.ui.nativeui.b bVar;
        String[] strArr2;
        IActivityHandler iActivityHandler2;
        NativeUIFeatureImpl nativeUIFeatureImpl;
        boolean z;
        io.dcloud.feature.ui.nativeui.a aVar;
        NativeUIFeatureImpl nativeUIFeatureImpl2;
        String[] strArr3;
        io.dcloud.feature.ui.nativeui.b bVar2;
        IApp iAppObtainApp = iWebview.obtainApp();
        int i2 = 0;
        String str2 = strArr.length >= 1 ? strArr[0] : null;
        JSONArray jSONArrayCreateJSONArray = strArr.length >= 2 ? JSONUtil.createJSONArray(strArr[1]) : null;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "closeToast":
                b2 = 0;
                break;
            case "hideMenu":
                b2 = 1;
                break;
            case "setUiStyle":
                b2 = 2;
                break;
            case "closePreviewImage":
                b2 = 3;
                break;
            case "previewImage":
                b2 = 4;
                break;
            case "WaitingView_setTitle":
                b2 = 5;
                break;
            case "prompt":
                b2 = 6;
                break;
            case "pickDate":
                b2 = 7;
                break;
            case "pickTime":
                b2 = 8;
                break;
            case "showMenu":
                b2 = 9;
                break;
            case "closeWaiting":
                b2 = 10;
                break;
            case "getTitlebarHeight":
                b2 = 11;
                break;
            case "setTitlebarVisible":
                b2 = 12;
                break;
            case "_NativeObj_close":
                b2 = 13;
                break;
            case "alert":
                b2 = 14;
                break;
            case "toast":
                b2 = 15;
                break;
            case "isTitlebarVisible":
                b2 = 16;
                break;
            case "confirm":
                b2 = 17;
                break;
            case "WaitingView_close":
                b2 = 18;
                break;
            case "actionSheet":
                b2 = 19;
                break;
            case "WaitingView":
                b2 = 20;
                break;
            default:
                b2 = -1;
                break;
        }
        String str3 = null;
        switch (b2) {
            case 0:
                g0.a(iAppObtainApp.obtainAppId());
                return null;
            case 1:
                PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "hideMenu", null, new Class[]{Activity.class, String.class}, new Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId()});
                if (iWebview.getActivity() == null || (iActivityHandler = DCloudAdapterUtil.getIActivityHandler(iWebview.getActivity())) == null) {
                    return null;
                }
                iActivityHandler.sideBarHideMenu();
                return null;
            case 2:
                AppRuntime.setAppDarkMode(iWebview.getActivity(), iWebview, strArr[0]);
                return null;
            case 3:
                Activity activity = RuningAcitvityUtil.getActivity("io.dcloud.feature.nativeObj.photoview.PhotoActivity");
                if (activity != null) {
                    activity.onBackPressed();
                    return null;
                }
                str3 = null;
                return str3;
            case 4:
                JSONArray jSONArray = JSONUtil.getJSONArray(jSONArrayCreateJSONArray, 0);
                JSONObject jSONObject = JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1);
                if (jSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        try {
                            String string = jSONArray.getString(i3);
                            arrayList.add((PdrUtil.isNetPath(string) || PdrUtil.isBase64ImagePath(string)) ? string : iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), string));
                            arrayList2.add(string);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    Intent intent = new Intent();
                    intent.setClassName(iAppObtainApp.getActivity().getPackageName(), "io.dcloud.feature.nativeObj.photoview.PhotoActivity");
                    intent.putExtra("image_urlList", arrayList);
                    intent.putExtra("original_image_urlArray", arrayList2);
                    if (jSONObject != null) {
                        intent.putExtra("image_current_index", jSONObject.optInt("current", 0));
                        if (jSONObject.has("background")) {
                            intent.putExtra("image_backgroud_color", PdrUtil.stringToColor(jSONObject.optString("background")));
                        }
                        if (jSONObject.has("loop")) {
                            intent.putExtra("image_loop", jSONObject.optBoolean("loop"));
                        }
                        if (jSONObject.has(WXBasicComponentType.INDICATOR)) {
                            intent.putExtra("image_indicator", jSONObject.optString(WXBasicComponentType.INDICATOR));
                        }
                    }
                    intent.putExtra("image_photo", true);
                    if (jSONArrayCreateJSONArray != null && jSONArrayCreateJSONArray.length() > 2 && (strOptString = jSONArrayCreateJSONArray.optString(2)) != null) {
                        intent.putExtra("preview_callback", strOptString);
                        LongClickEventManager.getInstance().addOnlongClickListener(strOptString, new c(iWebview, strOptString));
                    }
                    intent.putExtra("screen_orientation", iAppObtainApp.getRequestedOrientation());
                    iAppObtainApp.getActivity().startActivity(intent);
                    iAppObtainApp.getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                return null;
            case 5:
                HashMap map = this.a;
                if (map != null && (bVar = (io.dcloud.feature.ui.nativeui.b) map.get(str2)) != null) {
                    bVar.b(JSONUtil.getString(jSONArrayCreateJSONArray, 0));
                    return null;
                }
                return null;
            case 6:
                String string2 = JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                String string3 = JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                String string4 = JSONUtil.getString(jSONArrayCreateJSONArray, 2);
                String string5 = JSONUtil.getString(jSONArrayCreateJSONArray, 3);
                JSONArray jSONArray2 = JSONUtil.getJSONArray(jSONArrayCreateJSONArray, 4);
                if (jSONArray2 != null) {
                    int length = jSONArray2.length();
                    strArr2 = new String[length];
                    while (i2 < length) {
                        strArr2[i2] = JSONUtil.getString(jSONArray2, i2);
                        i2++;
                    }
                } else {
                    strArr2 = null;
                }
                a((byte) 2, string4, null, string2, strArr2, string5, iWebview, string3);
                return null;
            case 7:
                a(iWebview, JSONUtil.getString(jSONArrayCreateJSONArray, 0), JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1));
                return null;
            case 8:
                b(iWebview, JSONUtil.getString(jSONArrayCreateJSONArray, 0), JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1));
                return null;
            case 9:
                PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "showMenu", null, new Class[]{Activity.class, String.class, String.class, String.class, IWebview.class, String.class}, new Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId(), JSONUtil.getString(jSONArrayCreateJSONArray, 0), JSONUtil.getString(jSONArrayCreateJSONArray, 1), iWebview, JSONUtil.getString(jSONArrayCreateJSONArray, 2)});
                if (iWebview.getActivity() == null || (iActivityHandler2 = DCloudAdapterUtil.getIActivityHandler(iWebview.getActivity())) == null) {
                    return null;
                }
                iActivityHandler2.sideBarShowMenu(JSONUtil.getString(jSONArrayCreateJSONArray, 0), JSONUtil.getString(jSONArrayCreateJSONArray, 1), iWebview, JSONUtil.getString(jSONArrayCreateJSONArray, 2));
                return null;
            case 10:
                nativeUIFeatureImpl = this;
                HashMap map2 = nativeUIFeatureImpl.a;
                if (map2 != null) {
                    Iterator it = map2.values().iterator();
                    while (it.hasNext()) {
                        ((io.dcloud.feature.ui.nativeui.b) it.next()).a();
                    }
                    nativeUIFeatureImpl.a.clear();
                    return null;
                }
                return null;
            case 11:
                Object objInvokeMethod = PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "getTitlebarHeight", null, new Class[]{Activity.class}, new Object[]{iWebview.getActivity()});
                return Deprecated_JSUtil.wrapJsVar(String.valueOf(objInvokeMethod instanceof Integer ? Integer.valueOf(objInvokeMethod.toString()).intValue() : 0), false);
            case 12:
                try {
                    z = jSONArrayCreateJSONArray.getBoolean(0);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    z = true;
                }
                PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "setTitlebarVisible", null, new Class[]{Activity.class, String.class, Boolean.TYPE}, new Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId(), Boolean.valueOf(z)});
                return null;
            case 13:
                nativeUIFeatureImpl = this;
                HashMap map3 = nativeUIFeatureImpl.b;
                if (map3 != null && (aVar = (io.dcloud.feature.ui.nativeui.a) map3.remove(str2)) != null) {
                    aVar.a(-1);
                    aVar.b.onItemClick(-1);
                    return null;
                }
                return null;
            case 14:
                a((byte) 0, JSONUtil.getString(jSONArrayCreateJSONArray, 2), null, JSONUtil.getString(jSONArrayCreateJSONArray, 0), new String[]{JSONUtil.getString(jSONArrayCreateJSONArray, 3)}, null, iWebview, JSONUtil.getString(jSONArrayCreateJSONArray, 1));
                return null;
            case 15:
                a(iAppObtainApp, iWebview, JSONUtil.getString(jSONArrayCreateJSONArray, 0), JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1));
                return null;
            case 16:
                Object objInvokeMethod2 = PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "isTitlebarVisible", null, new Class[]{Activity.class, String.class}, new Object[]{iWebview.getActivity(), iWebview.obtainApp().obtainAppId()});
                return Deprecated_JSUtil.wrapJsVar(String.valueOf(objInvokeMethod2 instanceof Boolean ? Boolean.valueOf(objInvokeMethod2.toString()).booleanValue() : false), false);
            case 17:
                nativeUIFeatureImpl2 = this;
                try {
                    String string6 = JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                    String string7 = JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                    Object obj = jSONArrayCreateJSONArray.get(2);
                    try {
                        if (obj instanceof JSONObject) {
                            nativeUIFeatureImpl2.a((byte) 1, string6, (JSONObject) obj, iWebview, string7);
                            return null;
                        }
                        if (!(obj instanceof String)) {
                            nativeUIFeatureImpl2 = this;
                            nativeUIFeatureImpl2.a((byte) 1, null, null, string6, null, null, iWebview, string7);
                            return null;
                        }
                        String str4 = (String) obj;
                        JSONArray jSONArray3 = JSONUtil.getJSONArray(jSONArrayCreateJSONArray, 3);
                        if (jSONArray3 != null) {
                            int length2 = jSONArray3.length();
                            String[] strArr4 = new String[length2];
                            while (i2 < length2) {
                                strArr4[i2] = JSONUtil.getString(jSONArray3, i2);
                                i2++;
                            }
                            strArr3 = strArr4;
                        } else {
                            strArr3 = null;
                        }
                        a((byte) 1, str4, null, string6, strArr3, null, iWebview, string7);
                        return null;
                    } catch (JSONException e4) {
                        e = e4;
                        nativeUIFeatureImpl2 = this;
                    }
                } catch (JSONException e5) {
                    e = e5;
                }
                e.printStackTrace();
                return str3;
            case 18:
                nativeUIFeatureImpl2 = this;
                HashMap map4 = nativeUIFeatureImpl2.a;
                if (map4 != null && (bVar2 = (io.dcloud.feature.ui.nativeui.b) map4.remove(str2)) != null) {
                    bVar2.a();
                    return null;
                }
                return str3;
            case 19:
                nativeUIFeatureImpl2 = this;
                String string8 = JSONUtil.getString(jSONArrayCreateJSONArray, 2);
                io.dcloud.feature.ui.nativeui.a aVarA = nativeUIFeatureImpl2.a(string8, JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 0), JSONUtil.getString(jSONArrayCreateJSONArray, 1), iWebview);
                if (!PdrUtil.isEmpty(string8) && !PdrUtil.isEmpty(aVarA)) {
                    if (nativeUIFeatureImpl2.b == null) {
                        nativeUIFeatureImpl2.b = new HashMap();
                    }
                    nativeUIFeatureImpl2.b.put(string8, aVarA);
                    return null;
                }
                return str3;
            case 20:
                String string9 = JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                JSONObject jSONObject2 = JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1);
                String string10 = JSONUtil.getString(jSONArrayCreateJSONArray, 2);
                Activity topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
                if (!topRuningActivity.isDestroyed()) {
                    io.dcloud.feature.ui.nativeui.b bVar3 = new io.dcloud.feature.ui.nativeui.b(this, iWebview, string9, jSONObject2, string10, topRuningActivity);
                    if (this.a == null) {
                        this.a = new HashMap();
                    }
                    bVar3.f = str2;
                    this.a.put(str2, bVar3);
                    return null;
                }
            default:
                return str3;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.m = absMgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.g = null;
        this.h = 0;
        this.i = 0;
    }

    void a(String str) {
        this.a.remove(str);
    }

    private void b(IWebview iWebview, String str, JSONObject jSONObject) {
        int i2;
        int i3;
        if (this.g != null) {
            Deprecated_JSUtil.execCallback(iWebview, str, DOMException.toJSON(5, ""), JSUtil.ERROR, true, false);
            return;
        }
        Activity topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        boolean z = (jSONObject == null || jSONObject.isNull(AbsoluteConst.JSON_KEY_TITLE)) ? false : true;
        boolean z2 = PdrUtil.parseBoolean(JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_IS24HOUR), true, false);
        String string = JSONUtil.getString(jSONObject, Constants.Value.TIME);
        String string2 = JSONUtil.getString(jSONObject, "__minutes");
        String string3 = JSONUtil.getString(jSONObject, "__hours");
        if (PdrUtil.isEmpty(string3)) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            PdrUtil.isEmpty(string);
            if (z2) {
                i2 = gregorianCalendar.get(11);
            } else {
                i2 = gregorianCalendar.get(10);
            }
            i3 = gregorianCalendar.get(12);
        } else {
            i2 = Integer.parseInt(string3);
            i3 = Integer.parseInt(string2);
        }
        int i4 = i2;
        int i5 = i3;
        i iVar = new i(topRuningActivity, AppRuntime.getAppDarkMode(iWebview.getContext()) ? 4 : 0, new h(), i4, i5, z2, i4, i5, z, iWebview, str);
        if (z) {
            iVar.setTitle(JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_TITLE));
        }
        iVar.setOnDismissListener(new j(iWebview, str));
        iVar.show();
        this.g = iVar;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0294  */
    /* JADX WARN: Code duplicated, block: B:102:0x029b  */
    /* JADX WARN: Code duplicated, block: B:28:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x011e  */
    /* JADX WARN: Code duplicated, block: B:59:0x012a  */
    /* JADX WARN: Code duplicated, block: B:62:0x015b  */
    /* JADX WARN: Code duplicated, block: B:64:0x0160  */
    /* JADX WARN: Code duplicated, block: B:65:0x0175  */
    /* JADX WARN: Code duplicated, block: B:67:0x0189  */
    /* JADX WARN: Code duplicated, block: B:70:0x019c  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:73:0x01af  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:78:0x01be  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:91:0x0213  */
    /* JADX WARN: Code duplicated, block: B:92:0x021a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0231  */
    /* JADX WARN: Code duplicated, block: B:97:0x0241  */
    /* JADX WARN: Code duplicated, block: B:98:0x0278  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(IApp iApp, IWebview iWebview, String str, JSONObject jSONObject) throws Throwable {
        IApp iApp2;
        boolean zEquals;
        int i2;
        int i3;
        int iStringToColor;
        Activity topRuningActivity;
        char c2;
        Toast toastCompat;
        LinearLayout linearLayout;
        int iDip2px;
        GradientDrawable gradientDrawable;
        TextView textView;
        Toast toast;
        LinearLayout.LayoutParams layoutParams;
        String string;
        String string2;
        int i4;
        int iDip2px2;
        String systemProperty;
        float scale = iWebview.getScale();
        int i5 = 80;
        String str2 = AbsoluteConst.JSON_VALUE_BLOCK;
        Bitmap bitmapDecodeStream = null;
        if (jSONObject != null) {
            zEquals = TextUtils.equals(WXBasicComponentType.RICHTEXT, jSONObject.optString("type"));
            if (!jSONObject.isNull("style") && !AbsoluteConst.JSON_VALUE_BLOCK.equals(JSONUtil.getString(jSONObject, "style").toLowerCase(Locale.ENGLISH))) {
                str2 = AbsoluteConst.JSON_VALUE_INLINE;
            }
            if (jSONObject.isNull(AbsoluteConst.JSON_KEY_ICON)) {
                iApp2 = iApp;
            } else {
                iApp2 = iApp;
                String strConvert2AbsFullPath = iApp2.convert2AbsFullPath(iWebview.obtainFullUrl(), JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON));
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                bitmapDecodeStream = BitmapFactory.decodeStream(PlatformUtil.getInputStream(strConvert2AbsFullPath), null, options);
            }
            i2 = (jSONObject.isNull("duration") || !"long".equals(JSONUtil.getString(jSONObject, "duration").toLowerCase(Locale.ENGLISH))) ? 0 : 1;
            if (jSONObject.isNull(AbsoluteConst.JSON_KEY_ALIGN)) {
                i3 = 1;
            } else {
                String string3 = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ALIGN);
                if ("left".equals(string3)) {
                    i3 = 3;
                } else if ("right".equals(string3)) {
                    i3 = 5;
                } else {
                    i3 = 1;
                }
            }
            if (!jSONObject.isNull(AbsoluteConst.JSON_KEY_VERTICAL_ALIGN)) {
                String string4 = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_VERTICAL_ALIGN);
                if ("top".equals(string4)) {
                    i5 = 48;
                } else if (!"bottom".equals(string4)) {
                    i5 = 16;
                }
            }
            if (!jSONObject.isNull("background")) {
                String string5 = JSONUtil.getString(jSONObject, "background");
                iStringToColor = PdrUtil.isEmpty(string5) ? 1 : PdrUtil.stringToColor(string5);
            }
            topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
            if (topRuningActivity == null && topRuningActivity.isFinishing()) {
                return;
            }
            if (bitmapDecodeStream != null && !zEquals) {
                Toast toastMakeText = ToastCompat.makeText(topRuningActivity.getApplicationContext(), (CharSequence) str, i2);
                toastMakeText.setGravity(i3 | i5, toastMakeText.getXOffset(), toastMakeText.getYOffset());
                if (iStringToColor <= 0) {
                    toastMakeText.getView().getBackground().setColorFilter(iStringToColor, PorterDuff.Mode.SRC);
                }
                toast = toastMakeText;
            } else {
                if (zEquals) {
                    c2 = 3;
                    toastCompat = new g0(topRuningActivity, iApp2.obtainAppId());
                } else {
                    c2 = 3;
                    toastCompat = new ToastCompat(topRuningActivity.getApplicationContext());
                }
                linearLayout = new LinearLayout(topRuningActivity);
                int iDip2px3 = CanvasHelper.dip2px(topRuningActivity, 10.0f);
                iDip2px = CanvasHelper.dip2px(topRuningActivity, 8.0f);
                linearLayout.setPadding(iDip2px3, iDip2px, iDip2px3, iDip2px);
                linearLayout.setGravity(17);
                int i6 = i5;
                if (!Build.BRAND.equalsIgnoreCase("xiaomi")) {
                    gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(iDip2px);
                    gradientDrawable.setShape(0);
                    if (iStringToColor <= 0) {
                        gradientDrawable.setColor(iStringToColor);
                    } else {
                        gradientDrawable.setColor(-1308622848);
                    }
                    linearLayout.setBackground(gradientDrawable);
                } else if (iStringToColor <= 0) {
                    Drawable drawable = iWebview.getContext().getResources().getDrawable(R.drawable.toast_frame);
                    drawable.setColorFilter(iStringToColor, PorterDuff.Mode.SRC);
                    linearLayout.setBackground(drawable);
                } else {
                    systemProperty = DataInterface.getSystemProperty();
                    String[] strArr = {"v11", "v12"};
                    if (PdrUtil.isEmpty(systemProperty) && Arrays.binarySearch(strArr, systemProperty.toLowerCase(Locale.ENGLISH)) != -1) {
                        linearLayout.setBackgroundResource(io.dcloud.base.R.drawable.toast_bg);
                    } else {
                        linearLayout.setBackgroundResource(R.drawable.toast_frame);
                    }
                }
                if (bitmapDecodeStream != null) {
                    ImageView imageView = new ImageView(topRuningActivity);
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    string = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON_WIDTH);
                    string2 = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON_HEIGHT);
                    if (TextUtils.isEmpty(string) && string.endsWith("px")) {
                        i4 = 0;
                        layoutParams.width = PdrUtil.convertToScreenInt(string, 0, 0, scale);
                    } else {
                        i4 = 0;
                    }
                    if (!TextUtils.isEmpty(string2) && string2.endsWith("px")) {
                        layoutParams.height = PdrUtil.convertToScreenInt(string2, i4, i4, scale);
                    }
                    iDip2px2 = CanvasHelper.dip2px(topRuningActivity, 7.0f);
                    if (str2.equals(AbsoluteConst.JSON_VALUE_INLINE)) {
                        linearLayout.setOrientation(i4);
                        layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px2);
                    } else {
                        int iDip2px4 = CanvasHelper.dip2px(topRuningActivity, 1.0f);
                        linearLayout.setOrientation(1);
                        layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px4);
                    }
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageBitmap(bitmapDecodeStream);
                    linearLayout.addView(imageView);
                } else {
                    i3 = i3;
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                if (zEquals != 0) {
                    AbsMgr absMgr = this.m;
                    IMgr.MgrType mgrType = IMgr.MgrType.FeatureMgr;
                    Object objObtainFrameView = iWebview.obtainFrameView();
                    Object objOptJSONObject = jSONObject.optJSONObject("richTextStyle");
                    Object[] objArr = new Object[4];
                    objArr[0] = objObtainFrameView;
                    objArr[1] = str;
                    objArr[2] = objOptJSONObject;
                    objArr[c2] = toastCompat;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = iWebview;
                    objArr2[1] = "nativeobj";
                    objArr2[2] = "makeRichText";
                    objArr2[c2] = objArr;
                    textView = (TextView) absMgr.processEvent(mgrType, 10, objArr2);
                } else {
                    TextView textView2 = new TextView(topRuningActivity);
                    textView2.setText(str);
                    textView = textView2;
                }
                textView.setTextColor(Color.parseColor("#ffffffff"));
                textView.setLayoutParams(layoutParams2);
                linearLayout.addView(textView);
                if (zEquals) {
                    ((g0) toastCompat).a(linearLayout, textView);
                } else {
                    toastCompat.setView(linearLayout);
                }
                toastCompat.setGravity(i3 | i6, toastCompat.getXOffset(), toastCompat.getYOffset());
                toastCompat.setDuration(i2);
                toast = toastCompat;
            }
            toast.show();
        }
        iApp2 = iApp;
        zEquals = false;
        i2 = 0;
        i3 = 1;
        topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        if (topRuningActivity == null) {
        }
        if (bitmapDecodeStream != null) {
            if (zEquals) {
                c2 = 3;
                toastCompat = new g0(topRuningActivity, iApp2.obtainAppId());
            } else {
                c2 = 3;
                toastCompat = new ToastCompat(topRuningActivity.getApplicationContext());
            }
            linearLayout = new LinearLayout(topRuningActivity);
            int iDip2px5 = CanvasHelper.dip2px(topRuningActivity, 10.0f);
            iDip2px = CanvasHelper.dip2px(topRuningActivity, 8.0f);
            linearLayout.setPadding(iDip2px5, iDip2px, iDip2px5, iDip2px);
            linearLayout.setGravity(17);
            int i7 = i5;
            if (!Build.BRAND.equalsIgnoreCase("xiaomi")) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(iDip2px);
                gradientDrawable.setShape(0);
                if (iStringToColor <= 0) {
                    gradientDrawable.setColor(iStringToColor);
                } else {
                    gradientDrawable.setColor(-1308622848);
                }
                linearLayout.setBackground(gradientDrawable);
            } else if (iStringToColor <= 0) {
                Drawable drawable2 = iWebview.getContext().getResources().getDrawable(R.drawable.toast_frame);
                drawable2.setColorFilter(iStringToColor, PorterDuff.Mode.SRC);
                linearLayout.setBackground(drawable2);
            } else {
                systemProperty = DataInterface.getSystemProperty();
                String[] strArr2 = {"v11", "v12"};
                if (PdrUtil.isEmpty(systemProperty)) {
                    linearLayout.setBackgroundResource(R.drawable.toast_frame);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.toast_frame);
                }
            }
            if (bitmapDecodeStream != null) {
                ImageView imageView2 = new ImageView(topRuningActivity);
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                string = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON_WIDTH);
                string2 = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON_HEIGHT);
                if (TextUtils.isEmpty(string)) {
                    i4 = 0;
                } else {
                    i4 = 0;
                }
                if (!TextUtils.isEmpty(string2)) {
                    layoutParams.height = PdrUtil.convertToScreenInt(string2, i4, i4, scale);
                }
                iDip2px2 = CanvasHelper.dip2px(topRuningActivity, 7.0f);
                if (str2.equals(AbsoluteConst.JSON_VALUE_INLINE)) {
                    linearLayout.setOrientation(i4);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px2);
                } else {
                    int iDip2px6 = CanvasHelper.dip2px(topRuningActivity, 1.0f);
                    linearLayout.setOrientation(1);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px6);
                }
                imageView2.setLayoutParams(layoutParams);
                imageView2.setImageBitmap(bitmapDecodeStream);
                linearLayout.addView(imageView2);
            } else {
                i3 = i3;
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            if (zEquals != 0) {
                AbsMgr absMgr2 = this.m;
                IMgr.MgrType mgrType2 = IMgr.MgrType.FeatureMgr;
                Object objObtainFrameView2 = iWebview.obtainFrameView();
                Object objOptJSONObject2 = jSONObject.optJSONObject("richTextStyle");
                Object[] objArr3 = new Object[4];
                objArr3[0] = objObtainFrameView2;
                objArr3[1] = str;
                objArr3[2] = objOptJSONObject2;
                objArr3[c2] = toastCompat;
                Object[] objArr4 = new Object[4];
                objArr4[0] = iWebview;
                objArr4[1] = "nativeobj";
                objArr4[2] = "makeRichText";
                objArr4[c2] = objArr3;
                textView = (TextView) absMgr2.processEvent(mgrType2, 10, objArr4);
            } else {
                TextView textView3 = new TextView(topRuningActivity);
                textView3.setText(str);
                textView = textView3;
            }
            textView.setTextColor(Color.parseColor("#ffffffff"));
            textView.setLayoutParams(layoutParams3);
            linearLayout.addView(textView);
            if (zEquals) {
                ((g0) toastCompat).a(linearLayout, textView);
            } else {
                toastCompat.setView(linearLayout);
            }
            toastCompat.setGravity(i3 | i7, toastCompat.getXOffset(), toastCompat.getYOffset());
            toastCompat.setDuration(i2);
            toast = toastCompat;
        } else {
            if (zEquals) {
                c2 = 3;
                toastCompat = new g0(topRuningActivity, iApp2.obtainAppId());
            } else {
                c2 = 3;
                toastCompat = new ToastCompat(topRuningActivity.getApplicationContext());
            }
            linearLayout = new LinearLayout(topRuningActivity);
            int iDip2px7 = CanvasHelper.dip2px(topRuningActivity, 10.0f);
            iDip2px = CanvasHelper.dip2px(topRuningActivity, 8.0f);
            linearLayout.setPadding(iDip2px7, iDip2px, iDip2px7, iDip2px);
            linearLayout.setGravity(17);
            int i8 = i5;
            if (!Build.BRAND.equalsIgnoreCase("xiaomi")) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(iDip2px);
                gradientDrawable.setShape(0);
                if (iStringToColor <= 0) {
                    gradientDrawable.setColor(iStringToColor);
                } else {
                    gradientDrawable.setColor(-1308622848);
                }
                linearLayout.setBackground(gradientDrawable);
            } else if (iStringToColor <= 0) {
                Drawable drawable3 = iWebview.getContext().getResources().getDrawable(R.drawable.toast_frame);
                drawable3.setColorFilter(iStringToColor, PorterDuff.Mode.SRC);
                linearLayout.setBackground(drawable3);
            } else {
                systemProperty = DataInterface.getSystemProperty();
                String[] strArr3 = {"v11", "v12"};
                if (PdrUtil.isEmpty(systemProperty)) {
                    linearLayout.setBackgroundResource(R.drawable.toast_frame);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.toast_frame);
                }
            }
            if (bitmapDecodeStream != null) {
                ImageView imageView3 = new ImageView(topRuningActivity);
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                string = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON_WIDTH);
                string2 = JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_ICON_HEIGHT);
                if (TextUtils.isEmpty(string)) {
                    i4 = 0;
                } else {
                    i4 = 0;
                }
                if (!TextUtils.isEmpty(string2)) {
                    layoutParams.height = PdrUtil.convertToScreenInt(string2, i4, i4, scale);
                }
                iDip2px2 = CanvasHelper.dip2px(topRuningActivity, 7.0f);
                if (str2.equals(AbsoluteConst.JSON_VALUE_INLINE)) {
                    linearLayout.setOrientation(i4);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px2);
                } else {
                    int iDip2px8 = CanvasHelper.dip2px(topRuningActivity, 1.0f);
                    linearLayout.setOrientation(1);
                    layoutParams.setMargins(iDip2px2, iDip2px2, iDip2px2, iDip2px8);
                }
                imageView3.setLayoutParams(layoutParams);
                imageView3.setImageBitmap(bitmapDecodeStream);
                linearLayout.addView(imageView3);
            } else {
                i3 = i3;
            }
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 17;
            if (zEquals != 0) {
                AbsMgr absMgr3 = this.m;
                IMgr.MgrType mgrType3 = IMgr.MgrType.FeatureMgr;
                Object objObtainFrameView3 = iWebview.obtainFrameView();
                Object objOptJSONObject3 = jSONObject.optJSONObject("richTextStyle");
                Object[] objArr5 = new Object[4];
                objArr5[0] = objObtainFrameView3;
                objArr5[1] = str;
                objArr5[2] = objOptJSONObject3;
                objArr5[c2] = toastCompat;
                Object[] objArr6 = new Object[4];
                objArr6[0] = iWebview;
                objArr6[1] = "nativeobj";
                objArr6[2] = "makeRichText";
                objArr6[c2] = objArr5;
                textView = (TextView) absMgr3.processEvent(mgrType3, 10, objArr6);
            } else {
                TextView textView4 = new TextView(topRuningActivity);
                textView4.setText(str);
                textView = textView4;
            }
            textView.setTextColor(Color.parseColor("#ffffffff"));
            textView.setLayoutParams(layoutParams4);
            linearLayout.addView(textView);
            if (zEquals) {
                ((g0) toastCompat).a(linearLayout, textView);
            } else {
                toastCompat.setView(linearLayout);
            }
            toastCompat.setGravity(i3 | i8, toastCompat.getXOffset(), toastCompat.getYOffset());
            toastCompat.setDuration(i2);
            toast = toastCompat;
        }
        toast.show();
    }

    private void a(IWebview iWebview, String str, JSONObject jSONObject) {
        int i2;
        int i3;
        if (this.c != null) {
            Deprecated_JSUtil.execCallback(iWebview, str, DOMException.toJSON(5, ""), JSUtil.ERROR, true, false);
            return;
        }
        Activity topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        int i4 = JSONUtil.getInt(jSONObject, AbsoluteConst.JSON_KEY_STARTYEAR);
        int i5 = JSONUtil.getInt(jSONObject, "startMonth");
        int i6 = JSONUtil.getInt(jSONObject, "startDay");
        int i7 = JSONUtil.getInt(jSONObject, AbsoluteConst.JSON_KEY_ENDYEAR);
        int i8 = JSONUtil.getInt(jSONObject, "endMonth");
        int i9 = JSONUtil.getInt(jSONObject, "endDay");
        int i10 = JSONUtil.getInt(jSONObject, "setYear");
        int i11 = JSONUtil.getInt(jSONObject, "setMonth");
        int i12 = JSONUtil.getInt(jSONObject, "setDay");
        if (i10 == 0) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(new Date());
            int i13 = gregorianCalendar.get(1);
            int i14 = gregorianCalendar.get(2);
            i12 = gregorianCalendar.get(5);
            i10 = i13;
            i11 = i14;
        }
        boolean z = (jSONObject == null || jSONObject.isNull(AbsoluteConst.JSON_KEY_TITLE)) ? false : true;
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        f fVar = new f(topRuningActivity, AppRuntime.getAppDarkMode(iWebview.getContext()) ? 4 : 0, new e(), i10, i11, i12, i10, i11, i12, z, iWebview, str);
        if (DeviceInfo.sDeviceSdkVer >= 11) {
            if (i4 > 1900) {
                gregorianCalendar2.set(1, i4);
                i2 = 2;
                gregorianCalendar2.set(2, i5);
                i3 = 5;
                gregorianCalendar2.set(5, i6);
                fVar.getDatePicker().setMinDate(gregorianCalendar2.getTimeInMillis());
            } else {
                i2 = 2;
                i3 = 5;
            }
            if (i7 > 1900 && i7 >= i4) {
                gregorianCalendar2.set(1, i7);
                gregorianCalendar2.set(i2, i8);
                gregorianCalendar2.set(i3, i9);
                fVar.getDatePicker().setMaxDate(gregorianCalendar2.getTimeInMillis());
            }
        }
        fVar.setOnDismissListener(new g(iWebview, str));
        if (z) {
            fVar.setTitle(JSONUtil.getString(jSONObject, AbsoluteConst.JSON_KEY_TITLE));
        }
        fVar.show();
        this.c = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    private io.dcloud.feature.ui.nativeui.a a(String str, JSONObject jSONObject, String str2, IWebview iWebview) {
        String strOptString = jSONObject.has(AbsoluteConst.JSON_KEY_TITLE) ? jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE) : null;
        String strOptString2 = jSONObject.has(BindingXConstants.STATE_CANCEL) ? jSONObject.optString(BindingXConstants.STATE_CANCEL) : null;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
        if (jSONArrayOptJSONArray == null || a(jSONArrayOptJSONArray, iWebview.obtainApp(), str2, iWebview)) {
            return null;
        }
        d dVar = new d(iWebview, str2, str);
        Activity topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        topRuningActivity.setTheme(NativeUIR.ACTS_STYLE_ActionSheetStyleIOS7);
        iWebview.obtainApp().isFullScreen();
        io.dcloud.feature.ui.nativeui.a aVar = new io.dcloud.feature.ui.nativeui.a(topRuningActivity);
        aVar.b(strOptString2);
        aVar.a(strOptString);
        aVar.a(jSONArrayOptJSONArray);
        aVar.a(dVar);
        aVar.a(true);
        aVar.j();
        return aVar;
    }

    private void a(byte b2, String str, JSONObject jSONObject, IWebview iWebview, String str2) {
        String[] strArr;
        String strOptString = jSONObject.optString(AbsoluteConst.JSON_KEY_VERTICAL_ALIGN, "center");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("buttons");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = JSONUtil.getString(jSONArrayOptJSONArray, i2);
            }
        } else {
            strArr = null;
        }
        String[] strArr2 = strArr;
        if (TextUtils.equals(strOptString, "center")) {
            a(b2, jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE), null, str, strArr2, null, iWebview, str2, 17);
        } else if (TextUtils.equals(strOptString, "top")) {
            a(b2, jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE), null, str, strArr2, null, iWebview, str2, 49);
        } else if (TextUtils.equals(strOptString, "bottom")) {
            a(b2, jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE), null, str, strArr2, null, iWebview, str2, 81);
        }
    }

    private void a(byte b2, String str, String str2, String str3, String[] strArr, String str4, IWebview iWebview, String str5) {
        a(b2, str, str2, str3, strArr, str4, iWebview, str5, 17);
    }

    private void a(byte b2, String str, String str2, String str3, String[] strArr, String str4, IWebview iWebview, String str5, int i2) {
        EditText editText;
        Activity topRuningActivity = RuningAcitvityUtil.getTopRuningActivity(iWebview.getActivity());
        if (b2 == 0) {
            if (a(str3, iWebview.obtainApp(), iWebview, str5)) {
                return;
            }
            DCloudAlertDialog dCloudAlertDialogInitDialogTheme = DialogUtil.initDialogTheme(topRuningActivity, true);
            if (strArr != null && PdrUtil.isEmpty(strArr[0])) {
                strArr[0] = AndroidResources.getString(R.string.ok);
            }
            if (!PdrUtil.isEmpty(str)) {
                dCloudAlertDialogInitDialogTheme.setTitle(str);
            }
            dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
            dCloudAlertDialogInitDialogTheme.setMessage(str3);
            dCloudAlertDialogInitDialogTheme.setButton(-1, strArr[0], new k(dCloudAlertDialogInitDialogTheme, iWebview, str5));
            dCloudAlertDialogInitDialogTheme.setOnKeyListener(new l(dCloudAlertDialogInitDialogTheme, iWebview, str5));
            dCloudAlertDialogInitDialogTheme.show();
            return;
        }
        DCloudAlertDialog dCloudAlertDialogInitDialogTheme2 = DialogUtil.initDialogTheme(topRuningActivity, true);
        dCloudAlertDialogInitDialogTheme2.setMessage(str3);
        if (b2 == 2) {
            editText = new EditText(topRuningActivity);
            if (str4 != null) {
                editText.setHint(str4);
            }
            dCloudAlertDialogInitDialogTheme2.setView(editText);
            Editable text = editText.getText();
            if (text instanceof Spannable) {
                Selection.setSelection(text, text.length());
            }
        } else {
            editText = null;
        }
        if (b2 == 1) {
            Window window = dCloudAlertDialogInitDialogTheme2.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = i2;
            window.setAttributes(attributes);
        }
        if (!PdrUtil.isEmpty(str)) {
            dCloudAlertDialogInitDialogTheme2.setTitle(str);
        }
        dCloudAlertDialogInitDialogTheme2.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme2.setMessage(str3);
        String[] strArr2 = strArr == null ? new String[]{AndroidResources.getString(R.string.ok), AndroidResources.getString(R.string.cancel)} : strArr;
        if (a(b2, str3, strArr2, iWebview.obtainApp(), iWebview, str5)) {
            return;
        }
        int i3 = 0;
        while (i3 < strArr2.length && i3 < 3) {
            DCloudAlertDialog dCloudAlertDialog = dCloudAlertDialogInitDialogTheme2;
            EditText editText2 = editText;
            a aVar = new a(b2, editText2, iWebview, str5, i3, dCloudAlertDialog);
            int i4 = i3;
            if (i4 == 0) {
                dCloudAlertDialog.setButton(-1, strArr2[i4], aVar);
            } else if (i4 == 1) {
                dCloudAlertDialog.setButton(-2, strArr2[i4], aVar);
            } else if (i4 == 2) {
                dCloudAlertDialog.setButton(-3, strArr2[i4], aVar);
            }
            editText = editText2;
            dCloudAlertDialogInitDialogTheme2 = dCloudAlertDialog;
            i3 = i4 + 1;
        }
        DCloudAlertDialog dCloudAlertDialog2 = dCloudAlertDialogInitDialogTheme2;
        EditText editText3 = editText;
        dCloudAlertDialog2.setOnKeyListener(new b(b2, editText3, iWebview, str5, dCloudAlertDialog2));
        dCloudAlertDialog2.show();
        if (b2 != 2 || Build.FINGERPRINT.toLowerCase(Locale.ENGLISH).contains("flyme")) {
            return;
        }
        DeviceInfo.showIME(editText3);
    }

    private boolean a(String str, IApp iApp, IWebview iWebview, String str2) {
        if (TextUtils.isEmpty(str) || !BaseInfo.ISAMU) {
            return false;
        }
        if (!str.contains("更新") && !str.contains("升级") && !str.contains("版本")) {
            return false;
        }
        try {
            Deprecated_JSUtil.execCallback(iWebview, str2, "{index:0}", JSUtil.OK, true, false);
            a(iApp);
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean a(byte b2, String str, String[] strArr, IApp iApp, IWebview iWebview, String str2) {
        if (!TextUtils.isEmpty(str) && strArr != null && BaseInfo.ISAMU) {
            for (int i2 = 0; i2 < strArr.length && i2 < 3; i2++) {
                String str3 = strArr[i2];
                if (str3.contains("更新") || str3.contains("升级") || ((str.contains("更新") || str.contains("升级") || str.contains("版本")) && (str3.equals(WXModalUIModule.OK) || str3.equals("是") || str3.equals("确定")))) {
                    try {
                        if (b2 == 2) {
                            Deprecated_JSUtil.execCallback(iWebview, str2, "{index:" + i2 + ",message:" + JSONUtil.toJSONableString("") + Operators.BLOCK_END_STR, JSUtil.OK, true, false);
                            a(iApp);
                            return true;
                        }
                        if (b2 == 1) {
                            Deprecated_JSUtil.execCallback(iWebview, str2, String.valueOf(i2), JSUtil.OK, true, false);
                            a(iApp);
                            return true;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    private boolean a(JSONArray jSONArray, IApp iApp, String str, IWebview iWebview) {
        String str2;
        IWebview iWebview2;
        if (jSONArray != null && BaseInfo.ISAMU) {
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    String string = jSONArray.getJSONObject(i2).getString(AbsoluteConst.JSON_KEY_TITLE);
                    if (!string.contains("更新") && !string.contains("升级") && !string.contains("版本")) {
                        str2 = str;
                        iWebview2 = iWebview;
                        i2++;
                        iWebview = iWebview2;
                        str = str2;
                    }
                    str2 = str;
                    iWebview2 = iWebview;
                    try {
                        Deprecated_JSUtil.execCallback(iWebview2, str2, "" + (i2 + 1), JSUtil.OK, true, false);
                        a(iApp);
                        return true;
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        i2++;
                        iWebview = iWebview2;
                        str = str2;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str2 = str;
                    iWebview2 = iWebview;
                }
            }
        }
        return false;
    }

    private void a(IApp iApp) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "notify");
        jSONObject.put("appid", iApp.obtainOriginalAppId());
        jSONObject.put("version", iApp.obtainAppVersionName());
        Log.i(AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
    }
}
