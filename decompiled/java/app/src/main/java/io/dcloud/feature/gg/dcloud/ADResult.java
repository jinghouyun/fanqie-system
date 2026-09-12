package io.dcloud.feature.gg.dcloud;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Process;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.android.bindingx.core.internal.BindingXConstants;
import io.dcloud.EntryProxy;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.adapter.util.CanvasHelper;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.feature.gg.AolSplashUtil;
import io.dcloud.p.a4;
import io.dcloud.p.g0;
import io.dcloud.p.r0;
import io.dcloud.p.u3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class ADResult {
    private String d;
    private u3 handler = (u3) r0.d().a();
    private IAolReceiver[] receivers;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class CADReceiver implements IAolReceiver {
        private Context context;

        public CADReceiver(Context context) {
            this.context = context;
        }

        public void checkPromptData(JSONArray jSONArray) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null && jSONObject.length() > 0) {
                            if (jSONObject.optString("action").equals("prompt")) {
                                final String strOptString = jSONObject.optString("onclose");
                                AlertDialog alertDialogCreate = new AlertDialog.Builder(this.context).setTitle(jSONObject.optString(AbsoluteConst.JSON_KEY_TITLE)).setMessage(jSONObject.optString("message")).setCancelable(false).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: io.dcloud.feature.gg.dcloud.ADResult.CADReceiver.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i2) {
                                        if (strOptString.equals(BindingXConstants.STATE_EXIT)) {
                                            Process.killProcess(Process.myPid());
                                        } else {
                                            dialogInterface.dismiss();
                                        }
                                    }
                                }).create();
                                alertDialogCreate.setCanceledOnTouchOutside(false);
                                alertDialogCreate.show();
                            } else if (jSONObject.optString("action").equals("toast")) {
                                g0 g0Var = new g0((Activity) this.context, "");
                                TextView textView = new TextView(this.context);
                                textView.setAutoLinkMask(1);
                                textView.setClickable(true);
                                textView.setText(a4.a(this.context).a(jSONObject.optString("message")));
                                LinearLayout linearLayout = new LinearLayout(this.context);
                                linearLayout.addView(textView);
                                g0Var.a(linearLayout, textView);
                                g0Var.setDuration(1);
                                g0Var.setGravity(80, g0Var.getXOffset(), g0Var.getYOffset());
                                int iDip2px = CanvasHelper.dip2px(this.context, 10.0f);
                                int iDip2px2 = CanvasHelper.dip2px(this.context, 8.0f);
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
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onError(String str, String str2) {
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onReceiver(JSONObject jSONObject) {
            final JSONArray jSONArrayOptJSONArray;
            if (!jSONObject.has("data") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            ((Activity) this.context).runOnUiThread(new Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADResult.CADReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    CADReceiver.this.checkPromptData(jSONArrayOptJSONArray);
                }
            });
        }
    }

    public ADResult(IAolReceiver... iAolReceiverArr) {
        this.receivers = iAolReceiverArr;
    }

    private String gd() {
        IApp iApp = (IApp) EntryProxy.getInstnace().getCoreHandler().dispatchEvent(IMgr.MgrType.AppMgr, 28, BaseInfo.sDefaultBootApp);
        if (iApp != null) {
            Activity activity = iApp.getActivity();
            this.d = new JSONObject(this.handler.b(activity)).toString();
            this.receivers[0] = new ADHandler.ADReceiver(activity);
            this.receivers[1] = new CADReceiver(activity);
            this.receivers[2] = new AolFeatureImpl.AdReceiver(activity, new Object[]{null, null, ""}, iApp.obtainAppId());
        }
        return this.d;
    }

    public void cad(String str) {
        if (this.receivers != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("ret", -1);
                if (iOptInt == 0) {
                    for (IAolReceiver iAolReceiver : this.receivers) {
                        if ((iAolReceiver instanceof CADReceiver) || (iAolReceiver instanceof ADHandler.ADReceiver)) {
                            iAolReceiver.onReceiver(jSONObject);
                        }
                    }
                    return;
                }
                for (IAolReceiver iAolReceiver2 : this.receivers) {
                    if ((iAolReceiver2 instanceof CADReceiver) || (iAolReceiver2 instanceof ADHandler.ADReceiver)) {
                        iAolReceiver2.onError(String.valueOf(iOptInt), jSONObject.optString("desc"));
                    }
                }
            } catch (JSONException e) {
                for (IAolReceiver iAolReceiver3 : this.receivers) {
                    if ((iAolReceiver3 instanceof CADReceiver) || (iAolReceiver3 instanceof ADHandler.ADReceiver)) {
                        iAolReceiver3.onError("Exception", e.getMessage());
                    }
                }
            }
        }
    }

    public void dc(String str, int i, int i2) {
        IAolReceiver[] iAolReceiverArr = this.receivers;
        if (iAolReceiverArr != null) {
            int i3 = 0;
            if (i != 0) {
                int length = iAolReceiverArr.length;
                while (i3 < length) {
                    IAolReceiver iAolReceiver = iAolReceiverArr[i3];
                    if (!(iAolReceiver instanceof CADReceiver)) {
                        iAolReceiver.onError("NotFountDataError", DOMException.MSG_NETWORK_ERROR);
                    }
                    i3++;
                }
                u3 u3Var = this.handler;
                if (u3Var != null) {
                    u3Var.a(-5007, DOMException.MSG_NETWORK_ERROR);
                    return;
                }
                return;
            }
            if (i2 != 200) {
                int length2 = iAolReceiverArr.length;
                while (i3 < length2) {
                    IAolReceiver iAolReceiver2 = iAolReceiverArr[i3];
                    if (!(iAolReceiver2 instanceof CADReceiver)) {
                        iAolReceiver2.onError("NotFountDataError", String.valueOf(i2));
                    }
                    i3++;
                }
                u3 u3Var2 = this.handler;
                if (u3Var2 != null) {
                    u3Var2.a(-5007, String.valueOf(i2));
                    return;
                }
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("ret", -1);
                if (iOptInt == 0) {
                    for (IAolReceiver iAolReceiver3 : this.receivers) {
                        if (!(iAolReceiver3 instanceof CADReceiver)) {
                            AolSplashUtil.decodeChannel(jSONObject.optJSONObject("data"));
                            iAolReceiver3.onReceiver(jSONObject);
                        }
                    }
                    u3 u3Var3 = this.handler;
                    if (u3Var3 != null) {
                        u3Var3.a(jSONObject);
                        return;
                    }
                    return;
                }
                for (IAolReceiver iAolReceiver4 : this.receivers) {
                    if (!(iAolReceiver4 instanceof CADReceiver)) {
                        iAolReceiver4.onError(String.valueOf(iOptInt), jSONObject.optString("desc"));
                    }
                }
                u3 u3Var4 = this.handler;
                if (u3Var4 != null) {
                    u3Var4.a(-5007, String.valueOf(iOptInt) + ":" + jSONObject.optString("desc"));
                }
            } catch (Exception e) {
                IAolReceiver[] iAolReceiverArr2 = this.receivers;
                int length3 = iAolReceiverArr2.length;
                while (i3 < length3) {
                    IAolReceiver iAolReceiver5 = iAolReceiverArr2[i3];
                    if (!(iAolReceiver5 instanceof CADReceiver)) {
                        iAolReceiver5.onError("Exception", e.getMessage());
                    }
                    i3++;
                }
                u3 u3Var5 = this.handler;
                if (u3Var5 != null) {
                    u3Var5.a(-5007, e.getMessage());
                }
            }
        }
    }
}
