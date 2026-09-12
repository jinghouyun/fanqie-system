package io.dcloud.feature.gallery.imageedit;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import com.facebook.common.util.UriUtil;
import com.taobao.weex.common.Constants;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.p.b2;
import io.dcloud.p.e2;
import io.dcloud.p.f2;
import io.dcloud.p.k2;
import io.dcloud.p.r2;
import io.dcloud.p.s2;
import io.dcloud.p.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class IMGEditActivity extends a {
    private boolean j = false;
    private int k = 0;
    private int l = 0;
    private int m = 80;
    private boolean n = true;
    private boolean o = false;
    private String p;
    int q;

    @Override // io.dcloud.feature.gallery.imageedit.a, io.dcloud.p.j2.b
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, io.dcloud.p.j2.b
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void c(int i) {
        super.c(i);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void e() {
        finish();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void f() {
        if (!this.j) {
            this.a.a();
            b(this.a.getMode() == k2.CLIP ? 1 : 0);
        } else if (PdrUtil.isEmpty(this.p) || !this.p.equals("camera")) {
            finish();
        } else {
            startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 0, ActivityOptionsCompat.makeCustomAnimation(this, 0, 0).toBundle());
        }
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void g() {
        JSONObject jSONObject;
        int i;
        String stringExtra = getIntent().getStringExtra("IMAGE_CROP");
        this.q = getIntent().getIntExtra("IMAGE_MEDIA_ID", 0);
        if (TextUtils.isEmpty(stringExtra)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(stringExtra);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        }
        if (jSONObject != null && jSONObject.length() > 1) {
            Pattern patternCompile = Pattern.compile("[^0-9]");
            try {
                this.k = Integer.parseInt(patternCompile.matcher(jSONObject.optString("width")).replaceAll(""));
                this.l = Integer.parseInt(patternCompile.matcher(jSONObject.optString("height")).replaceAll(""));
            } catch (Exception unused2) {
            }
            this.m = jSONObject.optInt(Constants.Name.QUALITY, 80);
            this.n = jSONObject.optBoolean("resize", true);
            int i2 = this.k;
            if (i2 > 0 && (i = this.l) > 0) {
                this.a.b(i2, i);
            }
            if (jSONObject.has("saveToAlbum")) {
                this.o = jSONObject.optBoolean("saveToAlbum", false);
            }
            a(k2.CLIP);
            this.j = true;
        }
        this.p = getIntent().getStringExtra("IMAGE_SOURCE");
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void h() {
        Bitmap bitmapI;
        Uri uriInsert;
        int i;
        int i2;
        int i3;
        String stringExtra = getIntent().getStringExtra("IMAGE_SAVE_PATH");
        String str = System.currentTimeMillis() + ".jpg";
        if (TextUtils.isEmpty(stringExtra)) {
            if (Build.VERSION.SDK_INT >= 29) {
                stringExtra = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/DImage/" + str;
            } else {
                stringExtra = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/DImage/" + str;
            }
        }
        String str2 = stringExtra;
        if (TextUtils.isEmpty(str2) || (bitmapI = this.a.i()) == null) {
            setResult(0);
            finish();
            return;
        }
        if (this.q == -1001) {
            File file = new File(str2);
            if (!file.exists()) {
                finish();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                Bitmap bitmapA = a(bitmapI);
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                int i4 = this.m;
                if (i4 > 100) {
                    i3 = 100;
                } else {
                    i3 = i4 < 0 ? 80 : i4;
                }
                bitmapA.compress(compressFormat, i3, fileOutputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            setResult(-1, new Intent());
            finish();
            return;
        }
        if (this.j && !this.o) {
            String str3 = getExternalCacheDir().getPath() + "/DImage/" + str;
            File file2 = new File(str3);
            try {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                Bitmap bitmapA2 = a(bitmapI);
                Bitmap.CompressFormat compressFormat2 = Bitmap.CompressFormat.JPEG;
                int i5 = this.m;
                if (i5 > 100) {
                    i2 = 100;
                } else {
                    i2 = i5 < 0 ? 80 : i5;
                }
                bitmapA2.compress(compressFormat2, i2, fileOutputStream2);
            } catch (IOException unused) {
                setResult(0);
                finish();
            }
            Intent intent = new Intent();
            intent.putExtra("_id", Integer.MAX_VALUE);
            intent.putExtra("IMAGE_INDEX", getIntent().getIntExtra("IMAGE_INDEX", -1));
            intent.putExtra("PATH", str3);
            setResult(-1, intent);
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("is_pending", (Integer) 0);
            contentValues.put("_display_name", str);
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/DImage");
            uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(uriInsert);
                if (this.j) {
                    Bitmap bitmapA3 = a(bitmapI);
                    Bitmap.CompressFormat compressFormat3 = Bitmap.CompressFormat.JPEG;
                    int i6 = this.m;
                    if (i6 > 100) {
                        i6 = 100;
                    } else if (i6 < 0) {
                        i6 = 80;
                    }
                    bitmapA3.compress(compressFormat3, i6, outputStreamOpenOutputStream);
                } else {
                    bitmapI.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                }
            } catch (FileNotFoundException unused2) {
            }
        } else {
            File file3 = new File(str2);
            if (!file3.exists()) {
                try {
                    File parentFile = file3.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                } catch (IOException unused3) {
                }
            }
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                if (this.j) {
                    Bitmap bitmapA4 = a(bitmapI);
                    Bitmap.CompressFormat compressFormat4 = Bitmap.CompressFormat.JPEG;
                    int i7 = this.m;
                    if (i7 > 100) {
                        i7 = 100;
                    } else if (i7 < 0) {
                        i7 = 80;
                    }
                    bitmapA4.compress(compressFormat4, i7, fileOutputStream3);
                } else {
                    bitmapI.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream3);
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("_data", str2);
            contentValues2.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues2.put("mime_type", "image/jpeg");
            uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues2);
        }
        Uri uri = uriInsert;
        Intent intent2 = new Intent();
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "date_added", "mime_type", "_size", "_data", "_id"}, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToNext();
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("date_added"));
            int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("mime_type"));
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
            int i9 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            String strA = a(string2);
            cursorQuery.close();
            intent2.putExtra("_display_name", string);
            intent2.putExtra("date_added", j);
            intent2.putExtra("mime_type", i8);
            intent2.putExtra("_size", j2);
            intent2.putExtra("_id", i9);
            intent2.putExtra("PARENTPATH", strA);
            i = -1;
            intent2.putExtra("IMAGE_INDEX", getIntent().getIntExtra("IMAGE_INDEX", -1));
            intent2.putExtra("PATH", string2);
        } else {
            i = -1;
        }
        setResult(i, intent2);
        finish();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void i() {
        this.a.b();
        if (this.j) {
            h();
        } else {
            b(this.a.getMode() == k2.CLIP ? 1 : 0);
        }
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void j() {
        this.a.h();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void k() {
        this.a.c();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void m() {
        k2 mode = this.a.getMode();
        if (mode == k2.DOODLE) {
            this.a.k();
        } else if (mode == k2.MOSAIC) {
            this.a.l();
        }
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.content.DialogInterface.OnDismissListener
    public /* bridge */ /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.content.DialogInterface.OnShowListener
    public /* bridge */ /* synthetic */ void onShow(DialogInterface dialogInterface) {
        super.onShow(dialogInterface);
    }

    @Override // io.dcloud.feature.gallery.imageedit.b.a
    public void a(r2 r2Var) {
        this.a.a(r2Var);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0041  */
    @Override // io.dcloud.feature.gallery.imageedit.a
    public Bitmap c() {
        Uri uri;
        e2 f2Var;
        FileInputStream fileInputStream;
        InputStream inputStreamOpenInputStream;
        Intent intent = getIntent();
        if (intent == null || (uri = (Uri) intent.getParcelableExtra("IMAGE_URI")) == null) {
            return null;
        }
        if (TextUtils.isEmpty(uri.getPath())) {
            f2Var = null;
        } else {
            String scheme = uri.getScheme();
            scheme.getClass();
            if (scheme.equals("file")) {
                f2Var = new f2(uri);
            } else if (scheme.equals(UriUtil.LOCAL_ASSET_SCHEME)) {
                f2Var = new b2(this, uri);
            } else {
                f2Var = null;
            }
        }
        if (f2Var == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        f2Var.a(options);
        int i = options.outWidth;
        if (i > 1024) {
            options.inSampleSize = s2.a(Math.round((i * 1.0f) / 1024.0f));
        }
        int i2 = options.outHeight;
        if (i2 > 1024) {
            options.inSampleSize = Math.max(options.inSampleSize, s2.a(Math.round((i2 * 1.0f) / 1024.0f)));
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmapA = f2Var.a(options);
        if (bitmapA != null) {
            return bitmapA;
        }
        int intExtra = getIntent().getIntExtra("IMAGE_MEDIA_ID", -1);
        if (intExtra == -1) {
            return null;
        }
        if (intExtra == -1001) {
            try {
                fileInputStream = new FileInputStream(new File(uri.getPath()));
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return BitmapFactory.decodeStream(fileInputStream, null, options);
        }
        try {
            inputStreamOpenInputStream = getContentResolver().openInputStream(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, intExtra));
        } catch (FileNotFoundException unused2) {
            inputStreamOpenInputStream = null;
        }
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        return z.a(inputStreamOpenInputStream, options);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void a(k2 k2Var) {
        if (this.a.getMode() == k2Var) {
            k2Var = k2.NONE;
        }
        this.a.setMode(k2Var);
        n();
        if (k2Var == k2.CLIP) {
            b(1);
        }
    }

    private Bitmap a(Bitmap bitmap) {
        if (!this.n || this.l <= 0 || this.k <= 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(this.k / bitmap.getWidth(), this.l / bitmap.getHeight());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void a(int i) {
        this.a.setPenColor(i);
    }

    public String a(String str) {
        String[] strArrSplit = str.split("/");
        return strArrSplit[strArrSplit.length - 2];
    }
}
