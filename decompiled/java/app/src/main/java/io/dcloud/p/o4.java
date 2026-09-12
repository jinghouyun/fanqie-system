package io.dcloud.p;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nostra13.dcloudimageloader.core.download.BaseImageDownloader;
import io.dcloud.base.R;
import io.dcloud.sdk.base.entry.AdData;
import java.io.IOException;
import java.util.Locale;
import pl.droidsonroids.gif.GifDrawable;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class o4 extends RelativeLayout implements View.OnClickListener {
    Drawable a;
    private ViewGroup b;
    private View c;
    private ImageView d;
    private TextView e;
    private v2.c f;
    private AdData g;
    private int h;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o4.this.f != null) {
                o4.this.f.k();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements Runnable {
        final /* synthetic */ ViewGroup a;

        b(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!io.dcloud.p.a.a(this.a)) {
                if (o4.this.f != null) {
                    o4.this.f.a(60010, "广告容器不可见");
                    return;
                }
                return;
            }
            o4 o4Var = o4.this;
            if (o4Var.a == null) {
                if (o4Var.f != null) {
                    o4.this.f.a(60004, "图片资源加载失败");
                    return;
                }
                return;
            }
            this.a.removeAllViews();
            this.a.getGlobalVisibleRect(new Rect());
            this.a.getRootView().getGlobalVisibleRect(new Rect());
            this.a.addView(o4.this, new ViewGroup.LayoutParams(-1, -1));
            o4.this.g.a(new RectF(this.a.getX(), this.a.getY(), 0.0f, 0.0f));
            o4.this.d.setImageDrawable(o4.this.a);
            if (o4.this.f != null) {
                o4.this.f.onAdShow();
            }
            o4.this.g.a();
            l4.a().b(o4.this.getContext(), o4.this.g.k());
        }
    }

    public o4(Context context, v2.c cVar, AdData adData) {
        super(context);
        this.h = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.f = cVar;
        this.g = adData;
        this.h = adData.i();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.dcloud_ad_splash_container, (ViewGroup) null);
        this.b = viewGroup;
        this.c = viewGroup.findViewById(R.id.ad_dcloud_main_skip);
        this.d = (ImageView) this.b.findViewById(R.id.ad_dcloud_main_img);
        this.e = (TextView) this.b.findViewById(R.id.ad_dcloud_main_click);
        this.d.setOnClickListener(this);
        this.c.setOnClickListener(this);
        addView(this.b, -1);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (adData.g() == null) {
            BitmapFactory.decodeFile(adData.f(), options);
            String str = options.outMimeType;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ENGLISH).contains("gif")) {
                this.a = new m4(BitmapFactory.decodeFile(adData.f()), getContext());
                return;
            }
            try {
                this.a = new GifDrawable(adData.f());
                return;
            } catch (IOException unused) {
                this.a = new m4(BitmapFactory.decodeFile(adData.f()), getContext());
                return;
            }
        }
        BitmapFactory.decodeByteArray(adData.g(), 0, adData.g().length, options);
        String str2 = options.outMimeType;
        if (TextUtils.isEmpty(str2) || !str2.toLowerCase(Locale.ENGLISH).contains("gif")) {
            this.a = new m4(BitmapFactory.decodeByteArray(adData.g(), 0, adData.g().length), getContext());
            return;
        }
        try {
            this.a = new GifDrawable(adData.g());
        } catch (IOException unused2) {
            this.a = new m4(BitmapFactory.decodeByteArray(adData.g(), 0, adData.g().length), getContext());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g.a(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            this.g.b(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ad_dcloud_main_skip) {
            v2.c cVar = this.f;
            if (cVar != null) {
                cVar.l();
                return;
            }
            return;
        }
        if (view.getId() == R.id.ad_dcloud_main_img) {
            v2.c cVar2 = this.f;
            if (cVar2 != null) {
                cVar2.onAdClicked();
            }
            this.g.a(getContext());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.postDelayed(new a(), this.h);
        viewGroup.postDelayed(new b(viewGroup), 50L);
    }
}
