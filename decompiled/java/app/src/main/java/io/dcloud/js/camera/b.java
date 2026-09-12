package io.dcloud.js.camera;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import io.dcloud.base.R;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
abstract class b {
    /* JADX WARN: Code duplicated, block: B:24:0x002e A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #3 {Exception -> 0x002a, blocks: (B:20:0x0026, B:24:0x002e), top: B:42:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0043 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:32:0x003b, B:36:0x0043), top: B:40:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(Bitmap bitmap, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                try {
                    fileOutputStream.close();
                    bitmap.recycle();
                    return str;
                } catch (Exception e) {
                    e.printStackTrace();
                    return str;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    } else if (bitmap != null) {
                        bitmap.recycle();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    } else if (bitmap != null) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                } else if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                if (bitmap != null) {
                    bitmap.recycle();
                }
            } else if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public static Bitmap b(String str) {
        return BitmapFactory.decodeFile(str, new BitmapFactory.Options());
    }

    public static int c(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a(String str) {
        int iC = c(str);
        if (iC == 0) {
            return str;
        }
        Bitmap bitmapB = b(str);
        if (bitmapB == null) {
            return null;
        }
        return a(a(iC, bitmapB), str);
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        Bitmap bitmap2;
        Bitmap bitmapCreateBitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            bitmap2 = bitmap;
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (OutOfMemoryError unused) {
                bitmapCreateBitmap = null;
            }
        } catch (OutOfMemoryError unused2) {
            bitmap2 = bitmap;
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = bitmap2;
        }
        if (bitmap2 != bitmapCreateBitmap) {
            bitmap2.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Dialog a(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialog_transparent);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dcloud_dialog_loading, (ViewGroup) null);
        viewGroup.findViewById(R.id.loading_background).setBackgroundColor(0);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setView(viewGroup, 0, 0, 0, 0);
        return alertDialogCreate;
    }
}
