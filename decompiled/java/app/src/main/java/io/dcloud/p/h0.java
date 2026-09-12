package io.dcloud.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.FileUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.ThreadPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements Runnable {
        final /* synthetic */ IWebview a;
        final /* synthetic */ String[] b;

        a(IWebview iWebview, String[] strArr) {
            this.a = iWebview;
            this.b = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.a(this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static class b {
        float a;
        float b;
        float c;
        float d;
        float e;
        float f;

        public b(String str, String str2, String str3, String str4, float f, float f2) {
            this.e = f;
            this.f = f2;
            this.a = h0.a(str, f2, 0.0f);
            float fA = h0.a(str2, this.e, 0.0f);
            this.b = fA;
            float f3 = this.e;
            this.c = h0.a(str3, f3, f3 - fA);
            float f4 = this.f;
            float fA2 = h0.a(str4, f4, f4 - this.a);
            this.d = fA2;
            float f5 = this.c;
            float f6 = this.b;
            float f7 = f5 + f6;
            float f8 = this.e;
            if (f7 > f8) {
                this.c = f8 - f6;
            }
            float f9 = this.a;
            float f10 = fA2 + f9;
            float f11 = this.f;
            if (f10 > f11) {
                this.d = f11 - f9;
            }
        }

        public boolean a() {
            return this.a <= this.f && this.b <= this.e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01ab A[Catch: all -> 0x021b, TryCatch #0 {, blocks: (B:5:0x0014, B:6:0x0019, B:7:0x001e, B:10:0x002b, B:12:0x0036, B:13:0x003a, B:15:0x0048, B:17:0x004e, B:19:0x0063, B:27:0x00ad, B:31:0x00b9, B:33:0x00bd, B:35:0x00c4, B:37:0x00ca, B:39:0x00fb, B:41:0x0112, B:42:0x011d, B:44:0x0136, B:46:0x015b, B:53:0x0180, B:55:0x01ab, B:60:0x0203, B:62:0x0209, B:56:0x01ec, B:58:0x01f2, B:59:0x01f5, B:49:0x0163, B:51:0x0179, B:22:0x0070, B:23:0x009c, B:16:0x004b, B:67:0x0210), top: B:73:0x0014, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01ec A[Catch: all -> 0x021b, TryCatch #0 {, blocks: (B:5:0x0014, B:6:0x0019, B:7:0x001e, B:10:0x002b, B:12:0x0036, B:13:0x003a, B:15:0x0048, B:17:0x004e, B:19:0x0063, B:27:0x00ad, B:31:0x00b9, B:33:0x00bd, B:35:0x00c4, B:37:0x00ca, B:39:0x00fb, B:41:0x0112, B:42:0x011d, B:44:0x0136, B:46:0x015b, B:53:0x0180, B:55:0x01ab, B:60:0x0203, B:62:0x0209, B:56:0x01ec, B:58:0x01f2, B:59:0x01f5, B:49:0x0163, B:51:0x0179, B:22:0x0070, B:23:0x009c, B:16:0x004b, B:67:0x0210), top: B:73:0x0014, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01f2 A[Catch: all -> 0x021b, TryCatch #0 {, blocks: (B:5:0x0014, B:6:0x0019, B:7:0x001e, B:10:0x002b, B:12:0x0036, B:13:0x003a, B:15:0x0048, B:17:0x004e, B:19:0x0063, B:27:0x00ad, B:31:0x00b9, B:33:0x00bd, B:35:0x00c4, B:37:0x00ca, B:39:0x00fb, B:41:0x0112, B:42:0x011d, B:44:0x0136, B:46:0x015b, B:53:0x0180, B:55:0x01ab, B:60:0x0203, B:62:0x0209, B:56:0x01ec, B:58:0x01f2, B:59:0x01f5, B:49:0x0163, B:51:0x0179, B:22:0x0070, B:23:0x009c, B:16:0x004b, B:67:0x0210), top: B:73:0x0014, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0209 A[Catch: all -> 0x021b, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0014, B:6:0x0019, B:7:0x001e, B:10:0x002b, B:12:0x0036, B:13:0x003a, B:15:0x0048, B:17:0x004e, B:19:0x0063, B:27:0x00ad, B:31:0x00b9, B:33:0x00bd, B:35:0x00c4, B:37:0x00ca, B:39:0x00fb, B:41:0x0112, B:42:0x011d, B:44:0x0136, B:46:0x015b, B:53:0x0180, B:55:0x01ab, B:60:0x0203, B:62:0x0209, B:56:0x01ec, B:58:0x01f2, B:59:0x01f5, B:49:0x0163, B:51:0x0179, B:22:0x0070, B:23:0x009c, B:16:0x004b, B:67:0x0210), top: B:73:0x0014, inners: #1, #3 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x01ab, please report this as an issue */
    public static synchronized void a(IWebview iWebview, String[] strArr) {
        Bitmap bitmap;
        Bitmap bitmapA;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmap2;
        Bitmap bitmapCreateBitmap2;
        int width;
        int height;
        long jA;
        String str = strArr[0];
        String str2 = strArr[1];
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            if (cVar.a(jSONObject, iWebview, str2)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                if (cVar.e < 0) {
                    cVar.e = 50;
                }
                if (cVar.m > 1500000) {
                    options.inSampleSize = 2;
                } else {
                    options.inSampleSize = 1;
                }
                Logger.d("CompressImage", "文件获取完毕 初始化bitmap 获取文件大小" + cVar.m);
                Matrix matrix = null;
                try {
                    try {
                        bitmapA = a(iWebview.getContext(), cVar.a, options);
                    } catch (OutOfMemoryError unused) {
                        Logger.d("CompressImage", "获取bitmap 内存溢出第一次  bitmap路径" + cVar.a);
                        options.inSampleSize = options.inSampleSize * 2;
                        Logger.d("CompressImage", "获取bitmap 内存溢出第一次 第二次获取bitmmap  bitmap路径" + cVar.a);
                        bitmapA = a(iWebview.getContext(), cVar.a, options);
                    }
                    bitmap = bitmapA;
                } catch (IOException unused2) {
                    bitmap = null;
                }
                if (bitmap == null) {
                    a(iWebview, str2, DOMException.MSG_PARAMETER_ERROR, -1);
                    return;
                }
                if (!cVar.l || cVar.f <= 0.0f || cVar.g <= 0.0f) {
                    bitmapCreateBitmap = bitmap;
                } else {
                    Matrix matrix2 = new Matrix();
                    matrix2.setScale(cVar.f / bitmap.getWidth(), cVar.g / bitmap.getHeight());
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, false);
                }
                Logger.d("CompressImage", "缩放完毕" + cVar.a);
                if (cVar.h > 0) {
                    matrix = new Matrix();
                    matrix.postRotate(cVar.h);
                }
                Matrix matrix3 = matrix;
                Logger.d("CompressImage", "旋转完毕" + cVar.a);
                b bVar = cVar.k;
                if (bVar != null) {
                    float f = bVar.a;
                    float f2 = options.inSampleSize;
                    bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, (int) (bVar.b / f2), (int) (f / f2), (int) (bVar.c / f2), (int) (bVar.d / f2), matrix3, false);
                    Bitmap bitmap3 = bitmapCreateBitmap;
                    if (bitmapCreateBitmap2 != bitmap3) {
                        bitmap3.recycle();
                    }
                } else {
                    bitmap2 = bitmapCreateBitmap;
                    if (matrix3 == null) {
                        Logger.d("CompressImage", "裁剪完毕" + cVar.a);
                        width = bitmap2.getWidth();
                        height = bitmap2.getHeight();
                        jA = a(cVar.b, bitmap2, cVar.d, cVar.e);
                        if (jA > 0) {
                            a(cVar.a, cVar.b);
                            Logger.d("CompressImage", "开始保存图片" + cVar.a);
                            a(iWebview, str2, String.format(Locale.ENGLISH, "{path:'file://%s', w:%d, h:%d, size:%d}", cVar.b, Integer.valueOf(width), Integer.valueOf(height), Long.valueOf(jA)));
                        } else {
                            if (!bitmap2.isRecycled()) {
                                bitmap2.recycle();
                            }
                            a(iWebview, str2, iWebview.getContext().getString(R.string.dcloud_common_zip_image_output_failed), -5);
                        }
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } else {
                        bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix3, false);
                        if (bitmapCreateBitmap2 != bitmap2) {
                            bitmap2.recycle();
                        }
                    }
                }
                bitmap2 = bitmapCreateBitmap2;
                Logger.d("CompressImage", "裁剪完毕" + cVar.a);
                width = bitmap2.getWidth();
                height = bitmap2.getHeight();
                jA = a(cVar.b, bitmap2, cVar.d, cVar.e);
                if (jA > 0) {
                    a(cVar.a, cVar.b);
                    Logger.d("CompressImage", "开始保存图片" + cVar.a);
                    a(iWebview, str2, String.format(Locale.ENGLISH, "{path:'file://%s', w:%d, h:%d, size:%d}", cVar.b, Integer.valueOf(width), Integer.valueOf(height), Long.valueOf(jA)));
                } else {
                    if (!bitmap2.isRecycled()) {
                        bitmap2.recycle();
                    }
                    a(iWebview, str2, iWebview.getContext().getString(R.string.dcloud_common_zip_image_output_failed), -5);
                }
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            a(iWebview, str2, DOMException.MSG_PARAMETER_ERROR, -1);
        }
    }

    public static void b(IWebview iWebview, String[] strArr) {
        ThreadPool.self().addThreadTask(new a(iWebview, strArr));
    }

    public static Bitmap.CompressFormat c(String str) {
        return (str.contains(".jpg") || str.contains(".jpeg")) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }

    public static boolean b(String str) {
        try {
            File file = new File(str);
            return file.exists() && file.length() >= 5;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static class c {
        String a;
        String b;
        String c;
        boolean d;
        int e;
        float f;
        float g;
        int h;
        int i;
        int j;
        b k;
        boolean l = false;
        long m;

        c() {
        }

        public boolean a(JSONObject jSONObject, IWebview iWebview, String str) {
            this.a = jSONObject.optString("src");
            this.b = jSONObject.optString("dst");
            if (!a(iWebview, str)) {
                return false;
            }
            this.d = jSONObject.optBoolean("overwrite", false);
            this.c = jSONObject.optString(AbsoluteConst.JSON_KEY_FORMAT);
            this.e = jSONObject.optInt(Constants.Name.QUALITY, -1);
            a(iWebview.getContext(), jSONObject.optString("width", "auto"), jSONObject.optString("height", "auto"));
            this.h = jSONObject.optInt("rotate", -1);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clip");
            if (jSONObjectOptJSONObject == null) {
                return true;
            }
            b bVar = new b(jSONObjectOptJSONObject.optString("top"), jSONObjectOptJSONObject.optString("left"), jSONObjectOptJSONObject.optString("width"), jSONObjectOptJSONObject.optString("height"), this.f, this.g);
            this.k = bVar;
            if (bVar.a()) {
                return true;
            }
            h0.a(iWebview, str, DOMException.MSG_PARAMETER_ERROR, -1);
            return false;
        }

        public boolean a(IWebview iWebview, String str) {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                String strConvert2AbsFullPath = iWebview.obtainFrameView().obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), this.a);
                this.a = strConvert2AbsFullPath;
                if (!h0.b(strConvert2AbsFullPath)) {
                    h0.a(iWebview, str, DOMException.MSG_FILE_NOT_EXIST, -4);
                    return false;
                }
                this.b = iWebview.obtainFrameView().obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), this.b);
                return true;
            }
            h0.a(iWebview, str, DOMException.MSG_PARAMETER_ERROR, -1);
            return false;
        }

        public void a(Context context, String str, String str2) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                h0.a(context, this.a, options);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int i = options.outWidth;
            this.i = i;
            int i2 = options.outHeight;
            this.j = i2;
            if (i2 <= 0 || i <= 0) {
                return;
            }
            this.m = new File(this.a).length();
            if (str.equals("auto") && str2.endsWith("auto")) {
                this.l = false;
                this.f = this.i;
                this.g = this.j;
                return;
            }
            if (str.equals("auto")) {
                this.l = true;
                float f = this.j;
                float f2 = PdrUtil.parseFloat(str2, f, f);
                this.g = f2;
                this.f = (this.i * f2) / this.j;
                return;
            }
            if (str2.equals("auto")) {
                this.l = true;
                float f3 = this.i;
                float f4 = PdrUtil.parseFloat(str, f3, f3);
                this.f = f4;
                this.g = (this.j * f4) / this.i;
                return;
            }
            this.l = true;
            float f5 = this.i;
            this.f = PdrUtil.parseFloat(str, f5, f5);
            float f6 = this.j;
            this.g = PdrUtil.parseFloat(str2, f6, f6);
        }
    }

    private static void a(String str, String str2) {
        Object obj;
        String string;
        String attribute;
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            ExifInterface exifInterface2 = new ExifInterface(str2);
            for (Field field : ExifInterface.class.getFields()) {
                String name = field.getName();
                if (!TextUtils.isEmpty(name) && name.startsWith("TAG") && (obj = field.get(ExifInterface.class)) != null && (attribute = exifInterface.getAttribute((string = obj.toString()))) != null) {
                    exifInterface2.setAttribute(string, attribute);
                }
            }
            exifInterface2.saveAttributes();
        } catch (Throwable unused) {
        }
    }

    public static Bitmap a(Context context, String str, BitmapFactory.Options options) throws IOException {
        if (!FileUtil.checkPrivatePath(context, str)) {
            InputStream fileInputStream = FileUtil.getFileInputStream(context, str);
            if (fileInputStream == null) {
                return null;
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
            return bitmapDecodeStream;
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static void a(IWebview iWebview, String str, String str2, int i) {
        Deprecated_JSUtil.execCallback(iWebview, str, DOMException.toJSON(i, str2), JSUtil.ERROR, true, false);
    }

    public static void a(IWebview iWebview, String str, String str2) {
        Deprecated_JSUtil.execCallback(iWebview, str, str2, JSUtil.OK, true, false);
    }

    public static long a(String str, Bitmap bitmap, boolean z, int i) {
        File file = new File(str);
        if (file.exists()) {
            if (file.length() >= 1 && !z) {
                return -1L;
            }
            file.delete();
        } else if (a(str)) {
            file = new File(str);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(c(str), i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return file.length();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1L;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static boolean a(String str) {
        int iLastIndexOf;
        if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf("/")) != -1 && iLastIndexOf != 0) {
            try {
                File file = new File(str.substring(0, iLastIndexOf));
                if (file.exists()) {
                    return true;
                }
                file.mkdirs();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static float a(String str, float f, float f2) {
        return str.equals("auto") ? f2 : PdrUtil.parseFloat(str, f, f2);
    }
}
