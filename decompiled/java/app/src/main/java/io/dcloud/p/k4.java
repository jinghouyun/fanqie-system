package io.dcloud.p;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import io.dcloud.sdk.core.adapter.IAdAdapter;
import io.dcloud.sdk.core.entry.DCloudAOLSlot;
import io.dcloud.sdk.core.entry.SplashAOLConfig;
import io.dcloud.sdk.core.interfaces.AOLLoader;
import io.dcloud.sdk.core.module.DCBaseAOL;
import io.dcloud.sdk.core.module.DCBaseAOLLoader;
import io.dcloud.sdk.core.util.AdSizeUtil;
import io.dcloud.sdk.core.util.MainHandlerUtil;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class k4 extends y4 {
    private SplashAOLConfig C;
    private final Queue D;

    public k4(Activity activity, int i) {
        super(activity, i);
        this.D = new ConcurrentLinkedQueue();
        a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DCBaseAOLLoader s() {
        IAdAdapter iAdAdapterB = e.b().b("dcloud");
        if (iAdAdapterB == null) {
            return null;
        }
        DCBaseAOLLoader ad = iAdAdapterB.getAd(a(), this.b);
        this.D.add(ad);
        return ad;
    }

    @Override // io.dcloud.p.i4
    protected int c() {
        return 1;
    }

    public SplashAOLConfig t() {
        return this.C;
    }

    protected void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("src");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        Glide.with(a()).asBitmap().load(strOptString).into(new a(jSONObject));
    }

    @Override // io.dcloud.p.w, io.dcloud.p.j
    public DCBaseAOLLoader i() {
        return this.D.isEmpty() ? s() : (DCBaseAOLLoader) this.D.remove();
    }

    public void a(ViewGroup viewGroup) {
        DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL instanceof DCBaseAOLLoader) {
            ((DCBaseAOLLoader) dCBaseAOL).showIn(viewGroup);
        }
    }

    protected void b(final RelativeLayout relativeLayout, final FrameLayout.LayoutParams layoutParams) {
        MainHandlerUtil.getMainHandler().post(new Runnable() { // from class: io.dcloud.p.k4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(relativeLayout, layoutParams);
            }
        });
    }

    public void a(SplashAOLConfig splashAOLConfig, w2 w2Var) {
        this.C = splashAOLConfig;
        super.a(new DCloudAOLSlot.Builder().height(splashAOLConfig.getHeight()).width(splashAOLConfig.getWidth()).build(), w2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams) {
        w2 w2Var = this.s;
        if (w2Var instanceof AOLLoader.SplashAOLLoadListener) {
            ((AOLLoader.SplashAOLLoadListener) w2Var).redBag(relativeLayout, layoutParams);
        }
    }

    @Override // io.dcloud.p.y4, io.dcloud.p.w, io.dcloud.p.i4
    protected void a(t0 t0Var) {
        super.a(t0Var);
    }

    @Override // io.dcloud.p.w, io.dcloud.p.i4
    protected void a(int i, String str) {
        super.a(i, str);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    protected class b extends b0.b {
        public b() {
            super("");
        }

        @Override // io.dcloud.p.b0.b
        public void a(JSONArray jSONArray) {
        }

        @Override // io.dcloud.p.b0.b
        public void a(JSONArray jSONArray, boolean z) {
            if (jSONArray == null || jSONArray.length() == 0) {
                Iterator it = k4.this.D.iterator();
                while (it.hasNext()) {
                    ((u0) ((DCBaseAOL) it.next())).a((JSONArray) null, true);
                }
                return;
            }
            int i = 0;
            if (k4.this.D.size() <= 0) {
                while (i < jSONArray.length()) {
                    u0 u0Var = (u0) k4.this.s();
                    if (u0Var != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(jSONArray.opt(i));
                        u0Var.a(jSONArray2, true);
                        k4.this.D.add(u0Var);
                    }
                    i++;
                }
                return;
            }
            for (DCBaseAOL dCBaseAOL : k4.this.D) {
                if (jSONArray.length() > i) {
                    JSONArray jSONArray3 = new JSONArray();
                    jSONArray3.put(jSONArray.opt(i));
                    ((u0) dCBaseAOL).a(jSONArray3, true);
                } else {
                    ((u0) dCBaseAOL).a((JSONArray) null, true);
                }
                i++;
            }
            if (jSONArray.length() > i) {
                for (int i2 = i; i2 < jSONArray.length(); i2++) {
                    u0 u0Var2 = (u0) k4.this.s();
                    if (u0Var2 != null) {
                        JSONArray jSONArray4 = new JSONArray();
                        jSONArray4.put(jSONArray.opt(i));
                        u0Var2.a(jSONArray4, true);
                        k4.this.D.add(u0Var2);
                    }
                }
            }
        }

        @Override // io.dcloud.p.b0.b, io.dcloud.p.b0.a
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                jSONObject2.remove("cfgs");
                k4.this.s.getClass().getDeclaredMethod("getConfig", JSONObject.class).invoke(k4.this.s, jSONObject2);
            } catch (Exception unused) {
            }
            k4.this.a(jSONObject);
        }

        @Override // io.dcloud.p.b0.b, io.dcloud.p.b0.a
        public void a(int i, String str) {
            super.a(i, str);
            k4.this.b(i, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a extends CustomTarget {
        final /* synthetic */ JSONObject a;

        a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap bitmap, Transition transition) {
            JSONObject jSONObjectOptJSONObject = this.a.optJSONObject("pos");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            final RelativeLayout relativeLayout = new RelativeLayout(k4.this.a());
            ImageView imageView = new ImageView(k4.this.a());
            int iPxFromDp = AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("width", -2), k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp2 = AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("height", -2), k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp3 = AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("left", -1), k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp4 = AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("right", -1), k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp5 = AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("top", -1), k4.this.a().getResources().getDisplayMetrics());
            int iPxFromDp6 = AdSizeUtil.pxFromDp(jSONObjectOptJSONObject.optInt("bottom", -1), k4.this.a().getResources().getDisplayMetrics());
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, new ViewGroup.LayoutParams(iPxFromDp, iPxFromDp2));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (iPxFromDp4 >= 0) {
                layoutParams.rightMargin = iPxFromDp4;
            } else if (iPxFromDp3 >= 0) {
                layoutParams.leftMargin = iPxFromDp3;
            }
            if (iPxFromDp6 >= 0) {
                layoutParams.bottomMargin = iPxFromDp6;
            } else if (iPxFromDp5 >= 0) {
                layoutParams.topMargin = iPxFromDp5;
            }
            if (iPxFromDp3 >= 0) {
                if (iPxFromDp5 >= 0) {
                    layoutParams.gravity = 8388659;
                }
                if (iPxFromDp6 >= 0) {
                    layoutParams.gravity = 8388691;
                }
            }
            if (iPxFromDp4 >= 0) {
                if (iPxFromDp5 >= 0) {
                    layoutParams.gravity = 8388661;
                }
                if (iPxFromDp6 >= 0) {
                    layoutParams.gravity = 8388693;
                }
            }
            final JSONObject jSONObject = this.a;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: io.dcloud.p.k4$a$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(relativeLayout, jSONObject, view);
                }
            });
            k4.this.b(relativeLayout, layoutParams);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(RelativeLayout relativeLayout, final JSONObject jSONObject, View view) {
            if (relativeLayout.getParent() != null) {
                ((ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
            }
            String strOptString = jSONObject.optString("click_action", "");
            if (strOptString.equals("browser")) {
                c.c(k4.this.a(), jSONObject.optString("url"));
            } else if (strOptString.equals("url")) {
                c.e(k4.this.a(), jSONObject.optString("url"));
            }
            final String appId = r0.d().b().getAppId();
            final String adId = r0.d().b().getAdId();
            x4.a().a(new Runnable() { // from class: io.dcloud.p.k4$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(appId, jSONObject, adId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, JSONObject jSONObject, String str2) {
            c0.a(k4.this.a(), str, jSONObject.optString("tid"), str2, 10, "");
        }
    }
}
