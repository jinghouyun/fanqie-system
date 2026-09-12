package io.dcloud.feature.gg.dcloud;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.dcloud.PdrR;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.feature.gg.AolSplashUtil;
import io.dcloud.feature.internal.splash.ISplash;
import io.dcloud.p.u;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class GGSplashView extends FrameLayout implements ISplash {
    String appid;
    View bottomIcon;
    FrameLayout container;
    Handler handler;
    ICallBack mCallBack;
    private long pullTime;

    public GGSplashView(Activity activity) {
        super(activity);
        this.handler = new Handler(Looper.getMainLooper());
        initView(activity);
    }

    private void initView(Activity activity) {
        try {
            View viewInflate = LayoutInflater.from(activity).inflate(PdrR.getInt(activity, Constants.Name.LAYOUT, PdrUtil.dealString("ilWlkdg}lW{xdi{`")), (ViewGroup) null);
            viewInflate.setBackgroundColor(getBgColor());
            addView(viewInflate);
            this.container = (FrameLayout) viewInflate.findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lW{xdi{`Wkgf|iafmz")));
            Drawable icon = getIcon();
            this.bottomIcon = viewInflate.findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lW{xdi{`Wjg||geWjiz")));
            ImageView imageView = (ImageView) findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lWakgfW{afodm")));
            if (icon == null) {
                imageView.setVisibility(8);
                ((ImageView) findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lWakgf")))).setImageDrawable(AolSplashUtil.getApplicationIcon(activity));
                ((TextView) findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lWfiem")))).setText(AolSplashUtil.getApplicationName(activity));
            } else {
                imageView.setVisibility(0);
                imageView.setImageDrawable(icon);
                findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lWfiem"))).setVisibility(8);
                findViewById(PdrR.getInt(activity, "id", PdrUtil.dealString("ilWlkdg}lWakgf"))).setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    String get(String str) {
        return SP.getBundleData(ADHandler.AdTag, str);
    }

    public int getBgColor() {
        int iStringToColor = PdrUtil.stringToColor(get("bg"));
        if (iStringToColor != -1) {
            return iStringToColor;
        }
        return -1;
    }

    public View getBottomIcon() {
        return this.bottomIcon;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    public Drawable getIcon() {
        Bitmap bitmapDecodeStream;
        String str = get(WXBasicComponentType.IMG);
        if (TextUtils.isEmpty(str)) {
            bitmapDecodeStream = null;
        } else if (!PdrUtil.isDeviceRootDir(str)) {
            bitmapDecodeStream = BitmapFactory.decodeStream(PlatformUtil.getInputStream(str, 0));
        } else if (new File(str).exists()) {
            bitmapDecodeStream = BitmapFactory.decodeFile(str);
        } else {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream != null) {
            return new BitmapDrawable(bitmapDecodeStream);
        }
        return null;
    }

    public FrameLayout getImgContainer() {
        return this.container;
    }

    public void onFinishShow() {
        ICallBack iCallBack = this.mCallBack;
        if (iCallBack != null) {
            iCallBack.onCallBack(1, this.appid);
            this.mCallBack = null;
        }
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public void onWillCloseSplash() {
        if (this.container.getChildCount() == 0) {
            onFinishShow();
        }
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setCallBack(ICallBack iCallBack) {
        this.mCallBack = iCallBack;
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setImageBitmap(Bitmap bitmap) {
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setNameText(String str) {
    }

    public void setPullTime(long j) {
        this.pullTime = j;
    }

    public void showAd(final u uVar) {
        if (getParent() != null) {
            uVar.a((ViewGroup) this.container);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: io.dcloud.feature.gg.dcloud.GGSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GGSplashView.this.getParent() != null) {
                        uVar.a((ViewGroup) GGSplashView.this.container);
                    } else {
                        GGSplashView.this.handler.postDelayed(this, 20L);
                    }
                }
            }, 20L);
        }
    }
}
