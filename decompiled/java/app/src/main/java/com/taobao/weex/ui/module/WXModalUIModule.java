package com.taobao.weex.ui.module;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.alibaba.fastjson.JSONObject;
import com.dcloud.android.widget.toast.ToastCompat;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXModalUIModule extends WXSDKEngine.DestroyableModule {
    public static final String CANCEL = "Cancel";
    public static final String CANCEL_TITLE = "cancelTitle";
    public static final String DATA = "data";
    public static final String DEFAULT = "default";
    public static final String DURATION = "duration";
    public static final String GRAVITY = "gravity";
    public static final String MESSAGE = "message";
    public static final String OK = "OK";
    public static final String OK_TITLE = "okTitle";
    public static final String RESULT = "result";
    private Dialog activeDialog;
    private Toast toast;

    private void tracking(Dialog dialog) {
        this.activeDialog = dialog;
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                WXModalUIModule.this.activeDialog = null;
            }
        });
    }

    @JSMethod(uiThread = true)
    public void alert(JSONObject jSONObject, final JSCallback jSCallback) {
        String string;
        String string2;
        if (!(this.mWXSDKInstance.getContext() instanceof Activity)) {
            WXLogUtils.e("[WXModalUIModule] when call alert mWXSDKInstance.getContext() must instanceof Activity");
            return;
        }
        final String str = OK;
        if (jSONObject != null) {
            try {
                string = jSONObject.getString("message");
                try {
                    string2 = jSONObject.getString(OK_TITLE);
                } catch (Exception e) {
                    e = e;
                    WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                    string2 = OK;
                }
            } catch (Exception e2) {
                e = e2;
                string = "";
            }
        } else {
            string2 = OK;
            string = "";
        }
        String str2 = TextUtils.isEmpty(string) ? "" : string;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
        builder.setMessage(str2);
        if (!TextUtils.isEmpty(string2)) {
            str = string2;
        }
        builder.setPositiveButton(str, new DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 != null) {
                    jSCallback2.invoke(str);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        tracking(alertDialogCreate);
    }

    @JSMethod(uiThread = true)
    public void confirm(JSONObject jSONObject, final JSCallback jSCallback) {
        String string;
        String string2;
        String string3;
        if (!(this.mWXSDKInstance.getContext() instanceof Activity)) {
            WXLogUtils.e("[WXModalUIModule] when call confirm mWXSDKInstance.getContext() must instanceof Activity");
            return;
        }
        final String str = CANCEL;
        final String str2 = OK;
        if (jSONObject != null) {
            try {
                string2 = jSONObject.getString("message");
                try {
                    string = jSONObject.getString(OK_TITLE);
                    try {
                        string3 = jSONObject.getString(CANCEL_TITLE);
                    } catch (Exception e) {
                        e = e;
                        WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                        string3 = CANCEL;
                    }
                } catch (Exception e2) {
                    e = e2;
                    string = OK;
                }
            } catch (Exception e3) {
                e = e3;
                string = OK;
                string2 = "";
            }
        } else {
            string3 = CANCEL;
            string = OK;
            string2 = "";
        }
        String str3 = TextUtils.isEmpty(string2) ? "" : string2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
        builder.setMessage(str3);
        if (!TextUtils.isEmpty(string)) {
            str2 = string;
        }
        if (!TextUtils.isEmpty(string3)) {
            str = string3;
        }
        builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 != null) {
                    jSCallback2.invoke(str2);
                }
            }
        });
        builder.setNegativeButton(str, new DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 != null) {
                    jSCallback2.invoke(str);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        tracking(alertDialogCreate);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        Dialog dialog = this.activeDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.activeDialog.dismiss();
    }

    @JSMethod(uiThread = true)
    public void prompt(JSONObject jSONObject, final JSCallback jSCallback) {
        String string;
        String string2;
        String string3;
        String string4;
        if (!(this.mWXSDKInstance.getContext() instanceof Activity)) {
            WXLogUtils.e("when call prompt mWXSDKInstance.getContext() must instanceof Activity");
            return;
        }
        final String str = CANCEL;
        final String str2 = OK;
        if (jSONObject != null) {
            try {
                string3 = jSONObject.getString("message");
                try {
                    string2 = jSONObject.getString(OK_TITLE);
                    try {
                        string = jSONObject.getString(CANCEL_TITLE);
                        try {
                            string4 = jSONObject.getString("default");
                        } catch (Exception e) {
                            e = e;
                            WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                            string4 = "";
                        }
                    } catch (Exception e2) {
                        e = e2;
                        string = CANCEL;
                    }
                } catch (Exception e3) {
                    e = e3;
                    string = CANCEL;
                    string2 = OK;
                }
            } catch (Exception e4) {
                e = e4;
                string = CANCEL;
                string2 = OK;
                string3 = "";
            }
        } else {
            string = CANCEL;
            string2 = OK;
            string4 = "";
            string3 = string4;
        }
        String str3 = TextUtils.isEmpty(string3) ? "" : string3;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mWXSDKInstance.getContext());
        builder.setMessage(str3);
        final EditText editText = new EditText(this.mWXSDKInstance.getContext());
        editText.setText(string4);
        builder.setView(editText);
        if (!TextUtils.isEmpty(string2)) {
            str2 = string2;
        }
        if (!TextUtils.isEmpty(string)) {
            str = string;
        }
        builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (jSCallback != null) {
                    HashMap map = new HashMap();
                    map.put("result", str2);
                    map.put("data", editText.getText().toString());
                    jSCallback.invoke(map);
                }
            }
        }).setNegativeButton(str, new DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (jSCallback != null) {
                    HashMap map = new HashMap();
                    map.put("result", str);
                    map.put("data", editText.getText().toString());
                    jSCallback.invoke(map);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        tracking(alertDialogCreate);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004c A[PHI: r1 r4
  0x004c: PHI (r1v3 int) = (r1v2 int), (r1v5 int), (r1v5 int), (r1v5 int) binds: [B:23:0x0047, B:13:0x002e, B:15:0x0036, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]
  0x004c: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v4 java.lang.String), (r4v4 java.lang.String), (r4v4 java.lang.String) binds: [B:23:0x0047, B:13:0x002e, B:15:0x0036, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @JSMethod(uiThread = true)
    public void toast(JSONObject jSONObject) {
        int iIntValue;
        int i;
        if (this.mWXSDKInstance.getContext() == null) {
            return;
        }
        String string = "";
        if (jSONObject != null) {
            try {
                string = jSONObject.getString("message");
                iIntValue = jSONObject.containsKey("duration") ? jSONObject.getInteger("duration").intValue() : 0;
                try {
                    if (jSONObject.containsKey(GRAVITY)) {
                        String string2 = jSONObject.getString(GRAVITY);
                        if ((string2 instanceof String) && string2.equals("bottom")) {
                            i = 80;
                        } else {
                            i = 17;
                        }
                    } else {
                        i = 17;
                    }
                } catch (Exception e) {
                    e = e;
                    WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                }
            } catch (Exception e2) {
                e = e2;
                iIntValue = 0;
            }
        } else {
            i = 17;
            iIntValue = 0;
        }
        if (TextUtils.isEmpty(string)) {
            WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
            return;
        }
        int i2 = iIntValue > 3 ? 1 : 0;
        Toast toast = this.toast;
        if (toast == null) {
            this.toast = ToastCompat.makeText(this.mWXSDKInstance.getContext(), (CharSequence) string, i2);
        } else {
            toast.setDuration(i2);
            this.toast.setText(string);
        }
        if (17 == i) {
            this.toast.setGravity(i, 0, 0);
        }
        this.toast.show();
    }
}
