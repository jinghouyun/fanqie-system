package io.dcloud.feature.gallery.imageedit;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.ViewSwitcher;
import io.dcloud.base.R;
import io.dcloud.feature.gallery.imageedit.view.IMGColorGroup;
import io.dcloud.feature.gallery.imageedit.view.IMGView;
import io.dcloud.p.j2;
import io.dcloud.p.k2;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
abstract class a extends Activity implements View.OnClickListener, b.a, RadioGroup.OnCheckedChangeListener, DialogInterface.OnShowListener, DialogInterface.OnDismissListener, j2.b {
    protected IMGView a;
    private RadioGroup b;
    private IMGColorGroup c;
    private b d;
    private View e;
    private View f;
    private View g;
    private ViewSwitcher h;
    private ViewSwitcher i;

    /* JADX INFO: renamed from: io.dcloud.feature.gallery.imageedit.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static /* synthetic */ class C0041a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k2.values().length];
            a = iArr;
            try {
                iArr[k2.DOODLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k2.MOSAIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k2.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    a() {
    }

    private void d() {
        this.a = (IMGView) findViewById(R.id.image_canvas);
        this.b = (RadioGroup) findViewById(R.id.rg_modes);
        this.a.setDoodleTouchListener(this);
        this.h = (ViewSwitcher) findViewById(R.id.vs_op);
        this.i = (ViewSwitcher) findViewById(R.id.vs_op_sub);
        IMGColorGroup iMGColorGroup = (IMGColorGroup) findViewById(R.id.cg_colors);
        this.c = iMGColorGroup;
        iMGColorGroup.setOnCheckedChangeListener(this);
        this.e = findViewById(R.id.layout_op_sub);
        this.f = findViewById(R.id.dcloud_image_edit_head);
        this.g = findViewById(R.id.dcloud_image_edit_foot);
    }

    public void a() {
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    public abstract void a(int i);

    public abstract void a(k2 k2Var);

    public void b(int i) {
        if (i >= 0) {
            this.h.setDisplayedChild(i);
        }
    }

    public abstract Bitmap c();

    public void c(int i) {
        if (i < 0) {
            this.e.setVisibility(8);
        } else {
            this.i.setDisplayedChild(i);
            this.e.setVisibility(0);
        }
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public void l() {
        if (this.d == null) {
            b bVar = new b(this, this);
            this.d = bVar;
            bVar.setOnShowListener(this);
            this.d.setOnDismissListener(this);
        }
        this.d.show();
    }

    public abstract void m();

    public void n() {
        int i = C0041a.a[this.a.getMode().ordinal()];
        if (i == 1) {
            this.b.check(R.id.rb_doodle);
            c(0);
        } else if (i == 2) {
            this.b.check(R.id.rb_mosaic);
            c(1);
        } else {
            if (i != 3) {
                return;
            }
            this.b.clearCheck();
            c(-1);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.a.getMode() == k2.CLIP) {
            f();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        a(this.c.getCheckColor());
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rb_doodle) {
            a(k2.DOODLE);
            return;
        }
        if (id == R.id.btn_text) {
            l();
            return;
        }
        if (id == R.id.rb_mosaic) {
            a(k2.MOSAIC);
            return;
        }
        if (id == R.id.btn_clip) {
            a(k2.CLIP);
            return;
        }
        if (id == R.id.btn_undo) {
            m();
            return;
        }
        if (id == R.id.tv_done) {
            h();
            return;
        }
        if (id == R.id.tv_cancel) {
            e();
            return;
        }
        if (id == R.id.ib_clip_cancel) {
            f();
            return;
        }
        if (id == R.id.ib_clip_done) {
            i();
        } else if (id == R.id.tv_clip_reset) {
            j();
        } else if (id == R.id.ib_clip_rotate) {
            k();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bitmap bitmapC = c();
        if (bitmapC != null) {
            setContentView(R.layout.image_edit_activity);
            d();
            this.a.setImageBitmap(bitmapC);
            g();
        } else {
            finish();
        }
        int i = Build.VERSION.SDK_INT;
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(512);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        if (i >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.h.setVisibility(0);
    }

    public void onShow(DialogInterface dialogInterface) {
        this.h.setVisibility(8);
    }

    public void b() {
        this.f.setVisibility(4);
        this.g.setVisibility(4);
    }
}
