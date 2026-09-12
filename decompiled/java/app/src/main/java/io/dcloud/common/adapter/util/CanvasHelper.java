package io.dcloud.common.adapter.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.statfs.StatFsHelper;
import io.dcloud.common.util.IOUtil;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class CanvasHelper {
    public static final int BASELINE = 0;
    public static final int BOTTOM = 80;
    private static final int DEVIANT = 5;
    public static final int HCENTER = 1;
    public static final int LEFT = 3;
    public static final int RIGHT = 5;
    public static final int TOP = 48;
    public static final int VCENTER = 16;
    private static BitmapDrawable sDrawable;

    public static void clearData() {
        BitmapDrawable bitmapDrawable = sDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.getBitmap().recycle();
            sDrawable = null;
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static void drawClipBitmap(Canvas canvas, Bitmap bitmap, Paint paint, int i, int i2, int i3, int i4, int i5, int i6) {
        canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        canvas.drawBitmap(bitmap, i5, i6, paint);
        canvas.restore();
    }

    public static void drawNinePatchs(Canvas canvas, Bitmap bitmap, int[] iArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Paint paint = new Paint();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        char c = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1;
        while (i21 <= 9) {
            if (i21 == 1) {
                int i22 = iArr[c];
                int i23 = iArr[1];
                i5 = i;
                i9 = i5;
                i6 = i2;
                i10 = i6;
                i11 = i22;
                i12 = i11;
                i13 = i23;
                i14 = i13;
                i7 = i + i22;
                i8 = i2 + i23;
            } else if (i21 == 2) {
                int i24 = iArr[c];
                int i25 = (width - i24) - iArr[2];
                int i26 = iArr[1];
                int i27 = i + i24;
                i9 = i;
                i6 = i2;
                i10 = i6;
                i11 = (i3 - i24) - iArr[3];
                i12 = i25;
                i13 = i26;
                i14 = i13;
                i5 = i27;
                i7 = i27 + i25;
                i8 = i2 + i26;
            } else if (i21 == 3) {
                int i28 = iArr[2];
                int i29 = iArr[1];
                int i30 = i + i3;
                i6 = i2;
                i10 = i6;
                i11 = i28;
                i12 = i11;
                i13 = i29;
                i14 = i13;
                i7 = i30;
                i5 = i30 - i28;
                i8 = i2 + i29;
                i9 = i30 - width;
            } else if (i21 == 4) {
                int i31 = iArr[c];
                int i32 = iArr[1];
                int i33 = iArr[3];
                int i34 = (height - i32) - i33;
                int i35 = i2 + i32;
                i5 = i;
                i9 = i5;
                i10 = i2;
                i11 = i31;
                i12 = i11;
                i13 = (i4 - i32) - i33;
                i14 = i34;
                i6 = i35;
                i7 = i + i31;
                i8 = i35 + i34;
            } else if (i21 == 5) {
                int i36 = iArr[c];
                int i37 = iArr[2];
                int i38 = (width - i36) - i37;
                int i39 = iArr[1];
                int i40 = iArr[3];
                int i41 = (height - i39) - i40;
                int i42 = i + i36;
                int i43 = i2 + i39;
                i9 = i;
                i10 = i2;
                i13 = (i4 - i39) - i40;
                i14 = i41;
                i5 = i42;
                i6 = i43;
                i7 = i42 + i38;
                i8 = i43 + i41;
                i11 = (i3 - i36) - i37;
                i12 = i38;
            } else if (i21 == 6) {
                int i44 = iArr[2];
                int i45 = iArr[1];
                int i46 = iArr[3];
                int i47 = (height - i45) - i46;
                int i48 = i + i3;
                int i49 = i48 - i44;
                int i50 = i2 + i45;
                i10 = i2;
                i12 = i44;
                i13 = (i4 - i45) - i46;
                i14 = i47;
                i7 = i48;
                i5 = i49;
                i6 = i50;
                i8 = i50 + i47;
                i9 = i49 - (width - i44);
                i11 = i12;
            } else if (i21 == 7) {
                int i51 = iArr[c];
                int i52 = iArr[3];
                int i53 = (i2 + i4) - i52;
                i5 = i;
                i9 = i5;
                i11 = i51;
                i12 = i11;
                i13 = i52;
                i14 = i13;
                i6 = i53;
                i7 = i + i51;
                i8 = i53 + i52;
                i10 = (i53 - height) + i52;
            } else if (i21 == 8) {
                int i54 = iArr[c];
                int i55 = iArr[2];
                int i56 = (width - i54) - i55;
                int i57 = iArr[3];
                int i58 = i + i54;
                int i59 = (i2 + i4) - i57;
                i9 = i;
                i12 = i56;
                i13 = i57;
                i14 = i13;
                i5 = i58;
                i6 = i59;
                i7 = i58 + i56;
                i8 = i59 + i57;
                i10 = (i59 - height) + i57;
                i11 = (i3 - i54) - i55;
            } else if (i21 == 9) {
                int i60 = iArr[2];
                int i61 = iArr[3];
                int i62 = i + i3;
                int i63 = (i2 + i4) - i61;
                i11 = i60;
                i12 = i11;
                i13 = i61;
                i14 = i13;
                i7 = i62;
                i5 = i62 - i60;
                i6 = i63;
                i8 = i63 + i61;
                i9 = i62 - width;
                i10 = (i63 - height) + i61;
            } else {
                i5 = i15;
                i6 = i16;
                i7 = i17;
                i8 = i18;
                i9 = i19;
                i10 = i20;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                i14 = 0;
            }
            int i64 = (i13 / i14) + (i13 % i14 > 0 ? 1 : 0);
            int i65 = (i11 / i12) + (i11 % i12 > 0 ? 1 : 0);
            int i66 = 0;
            while (i66 < i64) {
                int i67 = 0;
                while (i67 < i65) {
                    int i68 = i67 * i12;
                    int i69 = i7 + i68;
                    int i70 = i11 + i5;
                    if (i69 > i70) {
                        i69 = i70;
                    }
                    int i71 = i66 * i14;
                    int i72 = i8 + i71;
                    int i73 = i13 + i6;
                    if (i72 > i73) {
                        i72 = i73;
                    }
                    drawClipBitmap(canvas, bitmap, paint, i5 + i68, i6 + i71, i69, i72, i9 + i68, i10 + i71);
                    i67++;
                    i64 = i64;
                    i65 = i65;
                    i66 = i66;
                }
                i66++;
            }
            i21++;
            i15 = i5;
            i16 = i6;
            i17 = i7;
            i18 = i8;
            i19 = i9;
            i20 = i10;
            c = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public static void drawString(Canvas canvas, String str, int i, int i2, int i3, Paint paint) {
        int i4;
        int i5;
        if (canvas == null || paint == null) {
            return;
        }
        int textSize = (int) paint.getTextSize();
        if ((i3 & 3) == 3) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else if ((i3 & 5) == 5) {
            paint.setTextAlign(Paint.Align.RIGHT);
        } else if ((i3 & 1) != 1) {
            paint.setTextAlign(Paint.Align.LEFT);
        }
        if ((i3 & 48) != 48) {
            if ((i3 & 80) == 80) {
                i4 = i2 - ((int) (paint.getFontMetrics().descent / 2.0f));
            } else {
                i4 = i2 + textSize;
                if ((i3 & 16) != 16) {
                    i5 = textSize / 5;
                }
            }
            if (str != null) {
                canvas.drawText(str, i, i4, paint);
            }
        }
        i4 = i2 + textSize;
        i5 = textSize / 5;
        i4 -= i5;
        if (str != null) {
            canvas.drawText(str, i, i4, paint);
        }
    }

    public static Bitmap getBitmap(String str) {
        Bitmap bitmapDecodeStream = null;
        try {
            InputStream inputStream = PlatformUtil.getInputStream(str);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            IOUtil.close(inputStream);
            return bitmapDecodeStream;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    public static Drawable getDrawable() {
        if (sDrawable == null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, Bitmap.Config.RGB_565);
            new Canvas(bitmapCreateBitmap).drawColor(0);
            sDrawable = new BitmapDrawable(bitmapCreateBitmap);
        }
        return sDrawable;
    }

    public static int getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
    }

    public static float getViablePx(int i) {
        return i * DeviceInfo.sDensity;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Drawable getDrawable(Context context, String str) {
        Bitmap bitmap = getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Drawable getDrawable(String str) {
        Bitmap bitmap = getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(bitmap);
    }
}
