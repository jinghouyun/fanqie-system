package io.dcloud.js.file;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.alibaba.fastjson.asm.Opcodes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.taobao.weex.common.Constants;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.io.UnicodeInputStream;
import io.dcloud.common.adapter.util.AsyncTaskHandler;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.PermissionUtil;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.FileUtil;
import io.dcloud.common.util.IOUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.Md5Utils;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.StringUtil;
import io.dcloud.common.util.ThreadPool;
import io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class FileFeatureImpl implements IFeature {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ IWebview e;
        final /* synthetic */ String f;

        a(String str, int i, int i2, String str2, IWebview iWebview, String str3) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = str2;
            this.e = iWebview;
            this.f = str3;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(Object obj) {
            if (obj != null) {
                Deprecated_JSUtil.execCallback(this.e, this.f, String.valueOf(obj), JSUtil.OK, true, false);
            } else {
                FileFeatureImpl.this.a(10, this.e, this.f);
            }
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0096 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:47:0x0098 A[Catch: IOException -> 0x0094, TRY_LEAVE, TryCatch #6 {IOException -> 0x0094, blocks: (B:43:0x0090, B:47:0x0098), top: B:71:0x0090 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x00ac A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:59:0x00ae A[Catch: IOException -> 0x00aa, TRY_LEAVE, TryCatch #2 {IOException -> 0x00aa, blocks: (B:55:0x00a6, B:59:0x00ae), top: B:67:0x00a6 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public Object onExecuting() throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            Exception e;
            InputStream inputStream;
            Object obj;
            Throwable th;
            InputStream inputStream2 = null;
            try {
                inputStream = DHFile.getInputStream(DHFile.createFileHandler(this.a));
                try {
                    try {
                        int iAvailable = inputStream.available();
                        try {
                            inputStream = new UnicodeInputStream(inputStream, Charset.defaultCharset().name());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            int i = this.b;
                            if (i > 0) {
                                if (i >= iAvailable) {
                                    i = iAvailable - 1;
                                }
                                int i2 = this.c;
                                int i3 = (i - i2) + 1;
                                byte[] bArr = new byte[i3];
                                inputStream.skip(i2);
                                inputStream.read(bArr, 0, i3);
                                byteArrayOutputStream.write(bArr, 0, i3);
                            } else {
                                while (true) {
                                    byte[] bArr2 = new byte[DHFile.BUF_SIZE];
                                    int i4 = inputStream.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i4);
                                }
                            }
                            String jSONableString = JSONUtil.toJSONableString(PdrUtil.isEmpty(this.d) ? byteArrayOutputStream.toString() : byteArrayOutputStream.toString(this.d));
                            try {
                                inputStream.close();
                                byteArrayOutputStream.close();
                                return jSONableString;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return jSONableString;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            InputStream inputStream3 = inputStream;
                            obj = null;
                            inputStream2 = inputStream3;
                            try {
                                e.printStackTrace();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        return obj;
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                        throw th;
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            } else if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        byteArrayOutputStream = null;
                        inputStream2 = inputStream;
                        obj = null;
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            inputStream2.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } else if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return obj;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    inputStream = inputStream2;
                    th = th;
                    if (inputStream != null) {
                        inputStream.close();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } else if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class b implements AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ IWebview d;
        final /* synthetic */ String e;

        b(String str, int i, int i2, IWebview iWebview, String str2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = iWebview;
            this.e = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(Object obj) {
            if (obj != null) {
                Deprecated_JSUtil.execCallback(this.d, this.e, String.valueOf(obj), JSUtil.OK, true, false);
            } else {
                FileFeatureImpl.this.a(10, this.d, this.e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:51:0x009c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:52:0x009e A[Catch: IOException -> 0x009a, TRY_LEAVE, TryCatch #0 {IOException -> 0x009a, blocks: (B:48:0x0096, B:52:0x009e), top: B:67:0x0096 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x00b0 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:63:0x00b2 A[Catch: IOException -> 0x00ae, TRY_LEAVE, TryCatch #8 {IOException -> 0x00ae, blocks: (B:59:0x00aa, B:63:0x00b2), top: B:78:0x00aa }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:78:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public Object onExecuting() throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            String str;
            String strEncodeToString;
            String mimeType = PdrUtil.getMimeType(this.a);
            InputStream inputStream = null;
            String str2 = null;
            InputStream inputStream2 = null;
            try {
                InputStream inputStream3 = DHFile.getInputStream(DHFile.createFileHandler(this.a));
                try {
                    int iAvailable = inputStream3.available();
                    int i = this.b;
                    if (i > 0) {
                        if (i >= iAvailable) {
                            i = iAvailable - 1;
                        }
                        int i2 = this.c;
                        int i3 = (i - i2) + 1;
                        byte[] bArr = new byte[i3];
                        inputStream3.skip(i2);
                        inputStream3.read(bArr, 0, i3);
                        strEncodeToString = Base64.encodeToString(bArr, 2);
                        byteArrayOutputStream = null;
                    } else {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                try {
                                    byte[] bArr2 = new byte[DHFile.BUF_SIZE];
                                    int i4 = inputStream3.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i4);
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                            throw th;
                                        }
                                    } else if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        return str2;
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return str2;
                            }
                        }
                        strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    }
                    try {
                        try {
                            String str3 = StringUtil.format("data:%s;base64,%s", mimeType, strEncodeToString);
                            try {
                                String jSONableString = JSONUtil.toJSONableString(str3);
                                try {
                                    inputStream3.close();
                                    if (byteArrayOutputStream == null) {
                                        return jSONableString;
                                    }
                                    byteArrayOutputStream.close();
                                    return jSONableString;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return jSONableString;
                                }
                            } catch (Exception e5) {
                                str = str3;
                                e = e5;
                                inputStream2 = inputStream3;
                                String str4 = str;
                                inputStream3 = inputStream2;
                                str2 = str4;
                                e.printStackTrace();
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return str2;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream3;
                        inputStream3 = inputStream;
                        if (inputStream3 != null) {
                            inputStream3.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } else if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream3;
                    str = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e8) {
                e = e8;
                str = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class c extends CustomTarget {
        final /* synthetic */ String a;
        final /* synthetic */ IWebview b;
        final /* synthetic */ String c;

        c(String str, IWebview iWebview, String str2) {
            this.a = str;
            this.b = iWebview;
            this.c = str2;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(File file, Transition transition) {
            if (PdrUtil.isEmpty(this.a)) {
                FileFeatureImpl.this.a(file.getAbsolutePath(), this.b, this.c);
            } else if (DHFile.copyFile(file.getPath(), this.a) != 1) {
                Deprecated_JSUtil.execCallback(this.b, this.c, DOMException.toJSON(13, "Failed to load resource"), JSUtil.ERROR, true, false);
            } else {
                FileFeatureImpl.this.a(this.a, this.b, this.c);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            Deprecated_JSUtil.execCallback(this.b, this.c, DOMException.toJSON(13, "Failed to load resource"), JSUtil.ERROR, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class d implements Runnable {
        final /* synthetic */ File a;
        final /* synthetic */ String b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;

        d(File file, String str, IWebview iWebview, String str2) {
            this.a = file;
            this.b = str;
            this.c = iWebview;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            String strMd5 = Md5Utils.md5(this.a, this.b);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AbsoluteConst.JSON_KEY_SIZE, this.a.length());
                if (strMd5 != null) {
                    jSONObject.put(Constants.CodeCache.BANNER_DIGEST, strMd5.toUpperCase(Locale.US));
                }
            } catch (JSONException unused) {
            }
            Deprecated_JSUtil.execCallback(this.c, this.d, jSONObject.toString(), JSUtil.OK, true, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class e implements ISysEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ IApp b;
        final /* synthetic */ IWebview c;
        final /* synthetic */ String d;

        e(int i, IApp iApp, IWebview iWebview, String str) {
            this.a = i;
            this.b = iApp;
            this.c = iWebview;
            this.d = str;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(ISysEventListener.SysEventType sysEventType, Object obj) {
            Object[] objArr = (Object[]) obj;
            int iIntValue = ((Integer) objArr[0]).intValue();
            Intent intent = (Intent) objArr[2];
            ISysEventListener.SysEventType sysEventType2 = ISysEventListener.SysEventType.onActivityResult;
            if (sysEventType == sysEventType2 && iIntValue == this.a) {
                this.b.unregisterSysEventListener(this, sysEventType2);
                if (intent == null || (intent.getData() == null && intent.getClipData() == null)) {
                    Deprecated_JSUtil.execCallback(this.c, this.d, StringUtil.format(DOMException.JSON_ERROR_INFO, -2, DOMException.MSG_USER_CANCEL), JSUtil.ERROR, true, false);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    ClipData clipData = intent.getClipData();
                    if (clipData != null) {
                        int itemCount = clipData.getItemCount();
                        for (int i = 0; i < itemCount; i++) {
                            jSONArray.put(FileUtil.getPathFromUri(this.b.getActivity(), clipData.getItemAt(i).getUri()));
                        }
                    } else {
                        Uri data = intent.getData();
                        String pathFromUri = FileUtil.getPathFromUri(this.b.getActivity(), data);
                        if (PdrUtil.isEmpty(pathFromUri)) {
                            pathFromUri = data.toString();
                        }
                        jSONArray.put(pathFromUri);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("files", jSONArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Deprecated_JSUtil.execCallback(this.c, this.d, jSONObject.toString(), JSUtil.OK, true, false);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class f implements AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ String[] a;
        final /* synthetic */ IWebview b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        f(String[] strArr, IWebview iWebview, String str, int i, String str2) {
            this.a = strArr;
            this.b = iWebview;
            this.c = str;
            this.d = i;
            this.e = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(Object obj) {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public Object onExecuting() {
            byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(this.a[1]);
            if (bArrDecode2bytes == null) {
                Deprecated_JSUtil.execCallback(this.b, this.c, StringUtil.format(DOMException.JSON_ERROR_INFO, 16, this.b.getContext().getString(R.string.dcloud_io_write_non_base64)).toString(), JSUtil.ERROR, true, false);
                return null;
            }
            DHFile.writeFile(bArrDecode2bytes, this.d, this.e);
            JSUtil.execCallback(this.b, this.c, bArrDecode2bytes.length, JSUtil.OK, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class g implements AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ IWebview d;
        final /* synthetic */ String e;

        g(String str, int i, int i2, IWebview iWebview, String str2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = iWebview;
            this.e = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(Object obj) {
            if (obj != null) {
                Deprecated_JSUtil.execCallback(this.d, this.e, String.valueOf(obj), JSUtil.OK, true, false);
            } else {
                FileFeatureImpl.this.a(10, this.d, this.e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:41:0x0097 A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #3 {IOException -> 0x0093, blocks: (B:37:0x008f, B:41:0x0097), top: B:62:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:54:0x00ad A[Catch: IOException -> 0x00a9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00a9, blocks: (B:50:0x00a5, B:54:0x00ad), top: B:58:0x00a5 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:? A[SYNTHETIC] */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public Object onExecuting() throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            Throwable th;
            String strEncodeToString;
            InputStream inputStream2 = null;
            jSONableString = null;
            jSONableString = null;
            String jSONableString = null;
            try {
                inputStream = DHFile.getInputStream(DHFile.createFileHandler(this.a));
                try {
                    int iAvailable = inputStream.available();
                    int i = this.b;
                    if (i > 0) {
                        if (i >= iAvailable) {
                            i = iAvailable - 1;
                        }
                        int i2 = this.c;
                        int i3 = (i - i2) + 1;
                        byte[] bArr = new byte[i3];
                        inputStream.skip(i2);
                        inputStream.read(bArr, 0, i3);
                        strEncodeToString = Base64.encodeToString(bArr, 2);
                        byteArrayOutputStream = null;
                    } else {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                try {
                                    byte[] bArr2 = new byte[DHFile.BUF_SIZE];
                                    int i4 = inputStream.read(bArr2);
                                    if (i4 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i4);
                                } catch (Exception e) {
                                    e = e;
                                    Deprecated_JSUtil.execCallback(this.d, this.e, StringUtil.format(DOMException.JSON_ERROR_INFO, 13, e.getMessage()), JSUtil.ERROR, true, false);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    } else if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                th = th;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    throw th;
                                }
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        }
                        strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    }
                    try {
                        jSONableString = JSONUtil.toJSONableString(strEncodeToString);
                        try {
                            inputStream.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream2 = inputStream;
                        inputStream = inputStream2;
                        th = th;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            throw th;
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    inputStream = inputStream2;
                    th = th;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                inputStream = inputStream2;
                th = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    throw th;
                }
                byteArrayOutputStream.close();
                throw th;
            }
            return jSONableString;
        }
    }

    private void b(IWebview iWebview, String[] strArr, String str) {
        try {
            String str2 = strArr[0];
            if (!FileUtil.checkPathAccord(iWebview.getContext(), str2)) {
                a(15, iWebview, str);
                return;
            }
            boolean zCheckPrivateDir = iWebview.obtainApp().checkPrivateDir(str2);
            int iIntValue = Integer.valueOf(strArr[2]).intValue();
            try {
                if (strArr[1] != null && !zCheckPrivateDir) {
                    AsyncTaskHandler.executeThreadTask(new f(strArr, iWebview, str, iIntValue, str2));
                    return;
                }
                a(4, iWebview, str);
            } catch (Exception unused) {
                a(10, iWebview, str);
            }
        } catch (Exception unused2) {
        }
    }

    private String c(String str) {
        if (str.startsWith(a)) {
            return AbsoluteConst.MINI_SERVER_APP_WWW + str.substring(a.length(), str.length());
        }
        if (str.startsWith(c)) {
            return AbsoluteConst.MINI_SERVER_APP_DOC + str.substring(c.length(), str.length());
        }
        if (str.startsWith(d)) {
            return "_documents/" + str.substring(d.length(), str.length());
        }
        if (!str.startsWith(e)) {
            return null;
        }
        return "_downloads/" + str.substring(e.length(), str.length());
    }

    private String d(String str) {
        boolean z;
        String strB = b(str);
        if (PdrUtil.isEmpty(strB)) {
            strB = String.valueOf(-1);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (str.startsWith(a)) {
                return String.valueOf(1);
            }
            if (str.startsWith(c)) {
                return String.valueOf(2);
            }
            if (str.startsWith(d)) {
                return String.valueOf(3);
            }
            if (str.startsWith(e)) {
                return String.valueOf(4);
            }
        }
        return strB;
    }

    private boolean e(String str) {
        return str.endsWith(BaseInfo.REL_PRIVATE_WWW_DIR) || str.endsWith(BaseInfo.REL_PUBLIC_DOCUMENTS_DIR) || str.endsWith(BaseInfo.REL_PUBLIC_DOWNLOADS_DIR) || str.endsWith(BaseInfo.REL_PRIVATE_DOC_DIR) || str.endsWith(AbsoluteConst.MINI_SERVER_APP_WWW) || str.endsWith("_documents/") || str.endsWith("_downloads/") || str.endsWith(AbsoluteConst.MINI_SERVER_APP_DOC);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x005b  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(final IWebview iWebview, String str, String[] strArr) throws Throwable {
        byte b2;
        JSONObject jSONObjectA;
        boolean zRenameTo;
        String str2;
        String str3;
        JSONObject jSONObjectA2;
        boolean z;
        String name;
        boolean z2;
        String strOptString;
        Throwable th;
        JSONObject jSONObjectA3;
        String str4;
        FileOutputStream fileOutputStream;
        String str5;
        IWebview iWebview2;
        FileInputStream fileInputStream;
        char c2;
        JSONArray jSONArrayB;
        boolean zOptBoolean;
        String strOptString2 = Md5Utils.ALGORITHM;
        final String str6 = strArr[0];
        IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Io-" + str);
        boolean zIsOnAppRunningMode = iAppObtainApp.isOnAppRunningMode();
        a = iAppObtainApp.getPathByType((byte) 0);
        b = iAppObtainApp.getPathByType((byte) -1);
        boolean z3 = true;
        c = iAppObtainApp.getPathByType((byte) 1);
        d = iAppObtainApp.getPathByType((byte) 2);
        e = iAppObtainApp.getPathByType((byte) 3);
        str.getClass();
        str.hashCode();
        switch (str) {
            case "copyTo":
                b2 = 0;
                break;
            case "requestFileSystem":
                b2 = 1;
                break;
            case "moveTo":
                b2 = 2;
                break;
            case "readAsText":
                b2 = 3;
                break;
            case "getDirectory":
                b2 = 4;
                break;
            case "convertLocalFileSystemURL":
                b2 = 5;
                break;
            case "remove":
                b2 = 6;
                break;
            case "getImageInfo":
                b2 = 7;
                break;
            case "getFileMetadata":
                b2 = 8;
                break;
            case "getFile":
                b2 = 9;
                break;
            case "write":
                b2 = 10;
                break;
            case "getAudioInfo":
                b2 = 11;
                break;
            case "convertAbsoluteFileSystem":
                b2 = 12;
                break;
            case "readAsDataURL":
                b2 = 13;
                break;
            case "writeAsBinary":
                b2 = 14;
                break;
            case "getParent":
                b2 = 15;
                break;
            case "readAsBase64":
                b2 = 16;
                break;
            case "getVideoInfo":
                b2 = 17;
                break;
            case "getFileInfo":
                b2 = 18;
                break;
            case "removeRecursively":
                b2 = 19;
                break;
            case "resolveLocalFileSystemURL":
                b2 = 20;
                break;
            case "getMetadata":
                b2 = 21;
                break;
            case "truncate":
                b2 = 22;
                break;
            case "readEntries":
                b2 = 23;
                break;
            case "chooseFile":
                b2 = 24;
                break;
            default:
                b2 = -1;
                break;
        }
        String strOptString3 = "";
        InputStream inputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        switch (b2) {
            case 0:
                String[] strArrA = a(iWebview, strArr, str6);
                if (strArrA != null) {
                    String string = strArrA[1];
                    if (string != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArrA[1]);
                        String str7 = strArrA[1];
                        String str8 = File.separator;
                        sb.append(str7.endsWith(str8) ? "" : str8);
                        string = sb.toString();
                    }
                    String str9 = string + strArrA[2];
                    String str10 = strArrA[0];
                    if (!FileUtil.checkPathAccord(iWebview.getContext(), str9, str10) && !FileUtil.isFilePathForPublic(iWebview.getContext(), str10)) {
                        a(15, iWebview, str6);
                    } else if (iAppObtainApp.checkPrivateDir(str9)) {
                        a(10, iWebview, str6);
                    } else {
                        try {
                            if (DHFile.isExist(str9) || (!DHFile.isExist(str10) ? !DHFile.copyAssetsFile(str10, str9) : DHFile.copyFile(str10, str9) != 1)) {
                                a(10, iWebview, str6);
                            } else {
                                JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(strArrA[2], str9, iAppObtainApp.convert2RelPath(str9), new File(str9).isDirectory()), JSUtil.OK, false);
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return null;
            case 1:
                try {
                    String[] strArrA2 = a(iWebview, strArr, str6);
                    if (strArrA2 != null) {
                        int i = Integer.parseInt(strArrA2[0]);
                        if (i == 1) {
                            jSONObjectA = io.dcloud.js.file.a.a("PRIVATE_WWW", 1, BaseInfo.REAL_PRIVATE_WWW_DIR, a, BaseInfo.REL_PRIVATE_WWW_DIR);
                        } else if (i == 2) {
                            jSONObjectA = io.dcloud.js.file.a.a("PRIVATE_DOCUMENTS", 2, BaseInfo.REAL_PRIVATE_DOC_DIR, c, BaseInfo.REL_PRIVATE_DOC_DIR);
                        } else if (i == 3) {
                            jSONObjectA = io.dcloud.js.file.a.a("PUBLIC_DOCUMENTS", 3, BaseInfo.REAL_PUBLIC_DOCUMENTS_DIR, d, BaseInfo.REL_PUBLIC_DOCUMENTS_DIR);
                        } else if (i != 4) {
                            String str11 = DeviceInfo.sDeviceRootDir;
                            jSONObjectA = io.dcloud.js.file.a.a("PUBLIC_DEVICE_ROOT", 5, str11, str11, str11);
                        } else {
                            jSONObjectA = io.dcloud.js.file.a.a("PUBLIC_DOWNLOADS", 4, BaseInfo.REAL_PUBLIC_DOWNLOADS_DIR, e, BaseInfo.REL_PUBLIC_DOWNLOADS_DIR);
                        }
                        JSUtil.execCallback(iWebview, str6, jSONObjectA, JSUtil.OK, false);
                        break;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    a(10, iWebview, str6);
                }
                return null;
            case 2:
                String[] strArrA3 = a(iWebview, strArr, str6);
                if (strArrA3 != null) {
                    String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArrA3[1] + strArrA3[2]);
                    if (iAppObtainApp.checkPrivateDir(strArrA3[0]) || iAppObtainApp.checkPrivateDir(strConvert2AbsFullPath)) {
                        a(10, iWebview, str6);
                    } else {
                        String strConvert2AbsFullPath2 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArrA3[0]);
                        if (FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath, strConvert2AbsFullPath2)) {
                            File file = new File(strConvert2AbsFullPath2);
                            boolean zIsDirectory = file.isDirectory();
                            File file2 = new File(strConvert2AbsFullPath);
                            if (file2.exists()) {
                                zRenameTo = false;
                            } else {
                                File parentFile = file2.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                zRenameTo = file.renameTo(file2);
                            }
                            if (zRenameTo) {
                                JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(strArrA3[2], strConvert2AbsFullPath, iAppObtainApp.convert2RelPath(strConvert2AbsFullPath), zIsDirectory), JSUtil.OK, false);
                            } else {
                                a(10, iWebview, str6);
                            }
                        } else {
                            a(15, iWebview, str6);
                        }
                    }
                }
                return null;
            case 3:
                String[] strArrA4 = a(iWebview, strArr, str6);
                if (strArrA4 != null) {
                    String str12 = strArrA4[0];
                    if (FileUtil.checkPathAccord(iWebview.getContext(), str12)) {
                        boolean zCheckPrivateDir = iAppObtainApp.checkPrivateDir(str12);
                        String str13 = strArrA4[1];
                        int i2 = PdrUtil.parseInt(strArrA4[2], 0);
                        int i3 = PdrUtil.parseInt(strArrA4[3], -1);
                        if (zCheckPrivateDir && zIsOnAppRunningMode) {
                            a(10, iWebview, str6);
                        } else {
                            AsyncTaskHandler.executeThreadTask(new a(str12, i3, i2, str13, iWebview, str6));
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 4:
                String[] strArrA5 = a(iWebview, strArr, str6);
                if (strArrA5 != null) {
                    String str14 = strArrA5[0];
                    if (str14 != null && !str14.endsWith("/")) {
                        strArrA5[0] = strArrA5[0] + "/";
                    }
                    String strConvert2AbsFullPath3 = iAppObtainApp.convert2AbsFullPath(strArrA5[0], strArrA5[1]);
                    if (!FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath3)) {
                        a(15, iWebview, str6);
                    } else {
                        if (strArrA5[0] != null && (str2 = strArrA5[1]) != null && str2.indexOf("../") != -1 && e(strArrA5[0])) {
                            a(4, iWebview, str6);
                            return null;
                        }
                        if (!strConvert2AbsFullPath3.endsWith("/")) {
                            strConvert2AbsFullPath3 = strConvert2AbsFullPath3 + "/";
                        }
                        File file3 = new File(strConvert2AbsFullPath3);
                        try {
                            JSONObject jSONObject = new JSONObject(strArrA5[2]);
                            boolean zOptBoolean2 = jSONObject.optBoolean("create");
                            boolean zOptBoolean3 = jSONObject.optBoolean("exclusive");
                            if (!file3.exists()) {
                                if (!zOptBoolean2) {
                                    a(14, iWebview, str6);
                                    return null;
                                }
                                byte bCreateNewFile = DHFile.createNewFile(strConvert2AbsFullPath3);
                                if (bCreateNewFile == -1 || (bCreateNewFile == -2 && zOptBoolean3)) {
                                    throw new RuntimeException();
                                }
                            } else if (zOptBoolean3 && zOptBoolean3) {
                                a(12, iWebview, str6);
                            }
                            JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(strArrA5[1], strConvert2AbsFullPath3, iAppObtainApp.convert2RelPath(strConvert2AbsFullPath3), true), JSUtil.OK, false);
                        } catch (Exception unused) {
                            Logger.d("Not Found " + strConvert2AbsFullPath3);
                            a(10, iWebview, str6);
                        }
                    }
                }
                return null;
            case 5:
                return Deprecated_JSUtil.wrapJsVar(iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[0]), true);
            case 6:
                String[] strArrA6 = a(iWebview, strArr, str6);
                if (strArrA6 != null) {
                    String str15 = strArrA6[0];
                    if (!FileUtil.checkPathAccord(iWebview.getContext(), str15)) {
                        a(15, iWebview, str6);
                    } else {
                        if (iAppObtainApp.checkPrivateDir(str15)) {
                            a(4, iWebview, str6);
                            return null;
                        }
                        if (new File(str15).delete()) {
                            JSUtil.execCallback(iWebview, str6, "", JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    }
                }
                return null;
            case 7:
                String str16 = strArr[0];
                String str17 = strArr[1];
                if (!PdrUtil.isEmpty(str17)) {
                    if (PdrUtil.isNetPath(str17)) {
                        try {
                            if (strArr.length <= 2 || PdrUtil.isEmpty(strArr[2])) {
                                str3 = null;
                            } else {
                                String str18 = strArr[2];
                                if (!str18.endsWith("/")) {
                                    str18 = str18 + "/";
                                }
                                String downloadFilename = PdrUtil.getDownloadFilename(str17, "image/*", str17);
                                if (TextUtils.isEmpty(downloadFilename)) {
                                    downloadFilename = System.currentTimeMillis() + "_" + Math.abs(str17.hashCode());
                                }
                                str3 = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str18) + downloadFilename;
                            }
                            Glide.with(iWebview.getContext()).asFile().load(str17).into(new c(str3, iWebview, str16));
                        } catch (Exception unused2) {
                            Deprecated_JSUtil.execCallback(iWebview, str16, DOMException.toJSON(13, "Failed to load resource"), JSUtil.ERROR, true, false);
                        }
                        break;
                    } else {
                        String strConvert2AbsFullPath4 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str17);
                        if (FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath4) || FileUtil.isFilePathForPublic(iWebview.getContext(), strConvert2AbsFullPath4)) {
                            if (strConvert2AbsFullPath4.startsWith("apps/")) {
                                strConvert2AbsFullPath4 = "/" + strConvert2AbsFullPath4;
                            }
                            if (strConvert2AbsFullPath4.startsWith("/android_asset/")) {
                                strConvert2AbsFullPath4 = strConvert2AbsFullPath4.replace("/android_asset", "");
                            } else if (strConvert2AbsFullPath4.startsWith("android_asset/")) {
                                strConvert2AbsFullPath4 = strConvert2AbsFullPath4.replace("android_asset", "");
                            }
                            String strCheckPrivateDirAndCopy2Temp = iAppObtainApp.checkPrivateDirAndCopy2Temp(strConvert2AbsFullPath4);
                            if (new File(strCheckPrivateDirAndCopy2Temp).exists()) {
                                a(strCheckPrivateDirAndCopy2Temp, iWebview, str16);
                            } else {
                                a(14, iWebview, str6);
                            }
                        } else {
                            a(15, iWebview, str6);
                        }
                    }
                }
                return null;
            case 8:
                String[] strArrA7 = a(iWebview, strArr, str6);
                if (strArrA7 != null) {
                    String str19 = strArrA7[0];
                    if (FileUtil.checkPathAccord(iWebview.getContext(), str19) || FileUtil.isFilePathForPublic(iWebview.getContext(), str19)) {
                        if (iAppObtainApp.checkPrivateDir(str19) && zIsOnAppRunningMode) {
                            jSONObjectA2 = null;
                            z = false;
                        } else {
                            try {
                                jSONObjectA2 = io.dcloud.js.file.a.a(str19, d(str19));
                                z = true;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                jSONObjectA2 = null;
                                z = false;
                            }
                        }
                        if (z) {
                            JSUtil.execCallback(iWebview, str6, jSONObjectA2, JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 9:
                String[] strArrA8 = a(iWebview, strArr, str6);
                if (strArrA8 != null) {
                    String strConvert2AbsFullPath5 = iAppObtainApp.convert2AbsFullPath(strArrA8[0], strArrA8[1]);
                    if (FileUtil.checkPathAccord(iWebview.getContext(), strConvert2AbsFullPath5)) {
                        File file4 = new File(strConvert2AbsFullPath5);
                        try {
                            JSONObject jSONObject2 = new JSONObject(strArrA8[2]);
                            String str20 = strArrA8[1];
                            boolean zOptBoolean4 = jSONObject2.optBoolean("create");
                            boolean zOptBoolean5 = jSONObject2.optBoolean("exclusive");
                            if (file4.exists()) {
                                if (zOptBoolean4 && zOptBoolean5) {
                                    a(12, iWebview, str6);
                                    return null;
                                }
                                name = file4.getName();
                            } else {
                                if (!zOptBoolean4) {
                                    a(14, iWebview, str6);
                                    return null;
                                }
                                byte bCreateNewFile2 = DHFile.createNewFile(file4);
                                name = file4.getName();
                                if (bCreateNewFile2 == -1 || (bCreateNewFile2 == -2 && zOptBoolean5)) {
                                    throw new RuntimeException();
                                }
                            }
                            JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(name, strConvert2AbsFullPath5, iAppObtainApp.convert2RelPath(strConvert2AbsFullPath5), false), JSUtil.OK, false);
                        } catch (Exception unused3) {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 10:
                IWebview iWebview3 = iWebview;
                try {
                    String[] strArrA9 = a(iWebview3, strArr, str6);
                    if (strArrA9 != null) {
                        String str21 = strArrA9[0];
                        if (FileUtil.checkPathAccord(iWebview3.getContext(), str21)) {
                            boolean zCheckPrivateDir2 = iAppObtainApp.checkPrivateDir(str21);
                            int iIntValue = Integer.valueOf(strArrA9[2]).intValue();
                            String str22 = strArrA9[1];
                            if (str22 != null && !zCheckPrivateDir2) {
                                byte[] bytes = str22.getBytes();
                                DHFile.writeFile(bytes, iIntValue, str21);
                                try {
                                    JSUtil.execCallback(iWebview3, str6, bytes.length, JSUtil.OK, false);
                                } catch (Exception unused4) {
                                    str6 = str6;
                                    iWebview3 = iWebview3;
                                    a(10, iWebview3, str6);
                                }
                                break;
                            }
                            a(4, iWebview3, str6);
                            return null;
                        }
                        a(15, iWebview3, str6);
                    }
                } catch (Exception unused5) {
                }
                return null;
            case 11:
            case 17:
                String str23 = strArr[0];
                try {
                    strOptString3 = new JSONObject(strArr[1]).optString("filePath");
                    break;
                } catch (JSONException unused6) {
                }
                a(strOptString3, str23, iWebview, str);
                return null;
            case 12:
                return Deprecated_JSUtil.wrapJsVar(iAppObtainApp.convert2RelPath(strArr[0]), true);
            case 13:
                String[] strArrA10 = a(iWebview, strArr, str6);
                if (strArrA10 != null) {
                    String str24 = strArrA10[0];
                    if (FileUtil.checkPathAccord(iWebview.getContext(), str24)) {
                        boolean zCheckPrivateDir3 = iAppObtainApp.checkPrivateDir(str24);
                        int i4 = PdrUtil.parseInt(strArrA10[1], 0);
                        int i5 = PdrUtil.parseInt(strArrA10[2], -1);
                        if (zCheckPrivateDir3 && zIsOnAppRunningMode) {
                            a(10, iWebview, str6);
                        } else {
                            AsyncTaskHandler.executeThreadTask(new b(str24, i5, i4, iWebview, str6));
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 14:
                String[] strArrA11 = a(iWebview, strArr, str6);
                if (strArrA11 != null) {
                    b(iWebview, strArrA11, str6);
                }
                return null;
            case 15:
                String[] strArrA12 = a(iWebview, strArr, str6);
                if (strArrA12 != null) {
                    String str25 = strArrA12[0];
                    if (FileUtil.checkPathAccord(iWebview.getContext(), str25) || FileUtil.isFilePathForPublic(iWebview.getContext(), str25)) {
                        if (str25 != null && e(str25)) {
                            a(4, iWebview, str6);
                            return null;
                        }
                        File file5 = new File(str25);
                        if (file5.exists()) {
                            String parent = file5.getParent();
                            JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(file5.getParentFile().getName(), parent, iAppObtainApp.convert2RelPath(parent), true), JSUtil.OK, false);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                }
                return null;
            case 16:
                String[] strArrA13 = a(iWebview, strArr, str6);
                if (strArrA13 != null) {
                    a(iWebview, iAppObtainApp, strArrA13, str6);
                }
                return null;
            case 18:
                final String str26 = strArr[0];
                try {
                    JSONObject jSONObject3 = new JSONObject(strArr[1]);
                    strOptString = jSONObject3.optString("filePath");
                    try {
                        strOptString2 = jSONObject3.optString("digestAlgorithm", Md5Utils.ALGORITHM);
                        break;
                    } catch (JSONException unused7) {
                    }
                } catch (JSONException unused8) {
                    strOptString = "";
                }
                if (!PdrUtil.isEmpty(strOptString) && !PdrUtil.isNetPath(strOptString)) {
                    final String strConvert2AbsFullPath6 = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                    try {
                        if (strConvert2AbsFullPath6.startsWith("content://")) {
                            try {
                                InputStream inputStreamOpenInputStream = iWebview.getActivity().getContentResolver().openInputStream(Uri.parse(strConvert2AbsFullPath6));
                                try {
                                    try {
                                        try {
                                            if (inputStreamOpenInputStream == null) {
                                                a(14, iWebview, str6);
                                                if (inputStreamOpenInputStream != null) {
                                                    inputStreamOpenInputStream.close();
                                                }
                                                break;
                                            } else {
                                                final int iAvailable = inputStreamOpenInputStream.available();
                                                try {
                                                    inputStreamOpenInputStream.close();
                                                    break;
                                                } catch (Exception unused9) {
                                                }
                                                final String str27 = strOptString2;
                                                try {
                                                    ThreadPool.self().addThreadTask(new Runnable() { // from class: io.dcloud.js.file.FileFeatureImpl$$ExternalSyntheticLambda2
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            this.f$0.a(iWebview, strConvert2AbsFullPath6, str27, iAvailable, str26, str6);
                                                        }
                                                    });
                                                    inputStreamOpenInputStream.close();
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    throw new RuntimeException(e);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    th = th;
                                                    inputStream = inputStreamOpenInputStream;
                                                    if (inputStream == null) {
                                                        throw th;
                                                    }
                                                    try {
                                                        inputStream.close();
                                                        throw th;
                                                    } catch (IOException e6) {
                                                        e6.printStackTrace();
                                                        throw th;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                } catch (IOException e8) {
                                    e = e8;
                                }
                            } catch (IOException e9) {
                                e = e9;
                            }
                            break;
                        } else {
                            String str28 = strOptString2;
                            if (FileUtil.checkPathAccord(iWebview.getContext(), strOptString) || FileUtil.isFilePathForPublic(iWebview.getContext(), strOptString)) {
                                if (strConvert2AbsFullPath6.startsWith("apps/")) {
                                    strConvert2AbsFullPath6 = "/" + strConvert2AbsFullPath6;
                                }
                                if (strConvert2AbsFullPath6.startsWith("/android_asset/")) {
                                    strConvert2AbsFullPath6 = strConvert2AbsFullPath6.replace("/android_asset", "");
                                } else if (strConvert2AbsFullPath6.startsWith("android_asset/")) {
                                    strConvert2AbsFullPath6 = strConvert2AbsFullPath6.replace("android_asset", "");
                                }
                                File file6 = new File(iAppObtainApp.checkPrivateDirAndCopy2Temp(strConvert2AbsFullPath6));
                                if (file6.exists()) {
                                    ThreadPool.self().addThreadTask(new d(file6, str28, iWebview, str26));
                                } else {
                                    Deprecated_JSUtil.execCallback(iWebview, str26, StringUtil.format(DOMException.JSON_ERROR_INFO, -4, DOMException.MSG_FILE_NOT_EXIST), JSUtil.ERROR, true, false);
                                }
                            } else {
                                a(15, iWebview, str6);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                return null;
            case 19:
                String[] strArrA14 = a(iWebview, strArr, str6);
                if (strArrA14 == null || JSUtil.checkOperateDirErrorAndCallback(iWebview, str6, strArrA14[0])) {
                    return null;
                }
                String str29 = strArrA14[0];
                if (FileUtil.checkPathAccord(iWebview.getContext(), str29)) {
                    File file7 = new File(str29);
                    if (file7.isDirectory()) {
                        try {
                            String strValueOf = String.valueOf(System.currentTimeMillis());
                            DHFile.rename(file7.getAbsolutePath() + "/", strValueOf);
                            file7 = new File(file7.getParent() + "/" + strValueOf);
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (DHFile.delete(file7)) {
                        JSUtil.execCallback(iWebview, str6, "", JSUtil.OK, false);
                    } else {
                        a(10, iWebview, str6);
                    }
                } else {
                    a(15, iWebview, str6);
                }
                return null;
            case 20:
                try {
                    String[] strArrA15 = a(iWebview, strArr, str6);
                    if (strArrA15 != null) {
                        boolean zE = e(strArrA15[0]);
                        boolean z4 = zE && iAppObtainApp.isOnAppRunningMode() && iAppObtainApp.checkPrivateDir(strArrA15[0]);
                        String strConvert2AbsFullPath7 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArrA15[0]);
                        if (z4) {
                            JSONObject jSONObjectA4 = a(strConvert2AbsFullPath7);
                            JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(BaseInfo.REL_PRIVATE_WWW_DIR, strConvert2AbsFullPath7, true, BaseInfo.REL_PRIVATE_WWW_DIR, jSONObjectA4.optString("fsName"), jSONObjectA4.optInt("type"), jSONObjectA4.optJSONObject("fsRoot")), JSUtil.OK, false);
                        } else {
                            File file8 = new File(strConvert2AbsFullPath7);
                            boolean zExists = file8.exists();
                            if (!zExists && zE) {
                                try {
                                    File parentFile2 = file8.getParentFile();
                                    if (!parentFile2.exists()) {
                                        parentFile2.mkdirs();
                                    }
                                    zExists = 1 == DHFile.createNewFile(DHFile.createFileHandler(strConvert2AbsFullPath7));
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (zExists) {
                                JSONObject jSONObjectA5 = a(strConvert2AbsFullPath7);
                                JSUtil.execCallback(iWebview, str6, io.dcloud.js.file.a.a(file8.getName(), strConvert2AbsFullPath7, file8.isDirectory(), strArrA15[0], jSONObjectA5.optString("fsName"), jSONObjectA5.optInt("type"), jSONObjectA5.optJSONObject("fsRoot")), JSUtil.OK, false);
                            } else {
                                a(14, iWebview, str6);
                            }
                        }
                    }
                } catch (JSONException unused10) {
                    a(10, iWebview, str6);
                }
                return null;
            case 21:
                boolean z5 = true;
                String[] strArrA16 = a(iWebview, strArr, str6);
                if (strArrA16 != null) {
                    String str30 = strArrA16[0];
                    if (FileUtil.checkPathAccord(iWebview.getContext(), str30) || FileUtil.isFilePathForPublic(iWebview.getContext(), str30)) {
                        if (iAppObtainApp.checkPrivateDir(str30) && zIsOnAppRunningMode) {
                            jSONObjectA3 = null;
                            z5 = false;
                        } else {
                            try {
                                jSONObjectA3 = io.dcloud.js.file.a.a(str30, (strArrA16.length == 2 && (str4 = strArrA16[1]) != null && str4.equalsIgnoreCase(AbsoluteConst.TRUE)) ? Boolean.parseBoolean(strArrA16[1]) : false);
                            } catch (Exception e12) {
                                e12.printStackTrace();
                                jSONObjectA3 = null;
                                z5 = false;
                            }
                        }
                        if (z5) {
                            JSUtil.execCallback(iWebview, str6, jSONObjectA3, JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                    break;
                }
                return null;
            case 22:
                String[] strArrA17 = a(iWebview, strArr, str6);
                if (strArrA17 != null) {
                    try {
                        String str31 = strArrA17[0];
                        if (FileUtil.checkPathAccord(iWebview.getContext(), str31)) {
                            File file9 = new File(str31);
                            fileInputStream = new FileInputStream(file9);
                            try {
                                File file10 = new File(file9.getParent() + "/" + (System.currentTimeMillis() + file9.getName()));
                                fileOutputStream = new FileOutputStream(file10);
                                try {
                                    try {
                                        int i6 = Integer.parseInt(strArrA17[1]);
                                        int i7 = Integer.parseInt(strArrA17[2]);
                                        byte[] bArr = new byte[Math.min(i7 + i6, 10240)];
                                        int i8 = 0;
                                        while (true) {
                                            int i9 = fileInputStream.read(bArr);
                                            if (i9 != -1) {
                                                c2 = 1;
                                                int iMin = Math.min(i6 - i8, i9 - i7);
                                                if (iMin > 0) {
                                                    fileOutputStream.write(bArr, i7, iMin);
                                                    i8 += iMin;
                                                }
                                                if (i8 < i6) {
                                                    i7 = i7 > 0 ? i7 - i9 : 0;
                                                }
                                            } else {
                                                c2 = 1;
                                            }
                                        }
                                        file9.delete();
                                        file10.renameTo(file9);
                                        try {
                                            Deprecated_JSUtil.execCallback(iWebview, str6, strArrA17[c2], JSUtil.OK, true, false);
                                        } catch (Exception e13) {
                                            e = e13;
                                            iWebview2 = iWebview;
                                            str5 = str6;
                                            try {
                                                e.printStackTrace();
                                                a(10, iWebview2, str5);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                fileInputStream2 = fileInputStream;
                                                fileInputStream = fileInputStream2;
                                                fileOutputStream2 = fileOutputStream;
                                                IOUtil.close(fileInputStream);
                                                IOUtil.close(fileOutputStream2);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileOutputStream2 = fileOutputStream;
                                        IOUtil.close(fileInputStream);
                                        IOUtil.close(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                    str5 = str6;
                                    iWebview2 = iWebview;
                                }
                            } catch (Exception e15) {
                                e = e15;
                                str5 = str6;
                                iWebview2 = iWebview;
                                fileOutputStream = null;
                            } catch (Throwable th7) {
                                th = th7;
                                IOUtil.close(fileInputStream);
                                IOUtil.close(fileOutputStream2);
                                throw th;
                            }
                            IOUtil.close(fileInputStream);
                            IOUtil.close(fileOutputStream);
                        } else {
                            a(15, iWebview, str6);
                            IOUtil.close((InputStream) null);
                            IOUtil.close((OutputStream) null);
                        }
                    } catch (Exception e16) {
                        e = e16;
                        str5 = str6;
                        iWebview2 = iWebview;
                        fileInputStream = null;
                        fileOutputStream = null;
                    } catch (Throwable th8) {
                        th = th8;
                        fileOutputStream = null;
                        fileInputStream = fileInputStream2;
                        fileOutputStream2 = fileOutputStream;
                        IOUtil.close(fileInputStream);
                        IOUtil.close(fileOutputStream2);
                        throw th;
                    }
                    break;
                }
                return null;
            case 23:
                String[] strArrA18 = a(iWebview, strArr, str6);
                if (strArrA18 != null) {
                    String str32 = strArrA18[0];
                    if (FileUtil.checkPathAccord(iWebview.getContext(), str32) || FileUtil.getPathForPublicType(str32) != null) {
                        if (iAppObtainApp.checkPrivateDir(str32) && zIsOnAppRunningMode) {
                            jSONArrayB = null;
                            z3 = false;
                        } else {
                            try {
                                jSONArrayB = io.dcloud.js.file.a.b(str32, iAppObtainApp.convert2RelPath(str32));
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                jSONArrayB = null;
                                z3 = false;
                            }
                        }
                        if (z3) {
                            JSUtil.execCallback(iWebview, str6, jSONArrayB, JSUtil.OK, false);
                        } else {
                            a(10, iWebview, str6);
                        }
                    } else {
                        a(15, iWebview, str6);
                    }
                    break;
                }
                return null;
            case 24:
                String str33 = strArr[0];
                if (strArr.length <= 1 || !PdrUtil.isEmpty(strArr[1])) {
                    zOptBoolean = false;
                } else {
                    try {
                        zOptBoolean = new JSONObject(strArr[1]).optBoolean("multiple", false);
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        zOptBoolean = false;
                    }
                }
                int requestCode = PermissionUtil.getRequestCode();
                iAppObtainApp.registerSysEventListener(new e(requestCode, iAppObtainApp, iWebview, str33), ISysEventListener.SysEventType.onActivityResult);
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                if (zOptBoolean) {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                } else {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                }
                intent.setType("*/*");
                intent.addCategory("android.intent.category.OPENABLE");
                iWebview.getActivity().startActivityForResult(intent, requestCode);
                return null;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IWebview iWebview, String str, String str2, int i, String str3, String str4) {
        IWebview iWebview2;
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = iWebview.getActivity().getContentResolver().openInputStream(Uri.parse(str));
                String strMd5 = Md5Utils.md5(inputStreamOpenInputStream, str2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AbsoluteConst.JSON_KEY_SIZE, i);
                    if (strMd5 != null) {
                        jSONObject.put(Constants.CodeCache.BANNER_DIGEST, strMd5.toUpperCase(Locale.US));
                    }
                } catch (JSONException unused) {
                }
                iWebview2 = iWebview;
                try {
                    Deprecated_JSUtil.execCallback(iWebview2, str3, jSONObject.toString(), JSUtil.OK, true, false);
                } catch (FileNotFoundException unused2) {
                    a(15, iWebview2, str4);
                }
            } catch (FileNotFoundException unused3) {
                iWebview2 = iWebview;
            }
        } finally {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void a(IWebview iWebview, IApp iApp, String[] strArr, String str) {
        String str2 = strArr[0];
        if (!FileUtil.checkPathAccord(iWebview.getContext(), str2)) {
            a(15, iWebview, str);
            return;
        }
        boolean zCheckPrivateDir = iApp.checkPrivateDir(str2);
        int i = PdrUtil.parseInt(strArr[1], 0);
        int i2 = PdrUtil.parseInt(strArr[2], -1);
        if (zCheckPrivateDir && iApp.isOnAppRunningMode()) {
            a(10, iWebview, str);
        } else {
            AsyncTaskHandler.executeThreadTask(new g(str2, i2, i, iWebview, str));
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0248  */
    /* JADX WARN: Code duplicated, block: B:54:0x015b A[Catch: Exception -> 0x0165, TRY_LEAVE, TryCatch #7 {Exception -> 0x0165, blocks: (B:52:0x014f, B:54:0x015b), top: B:146:0x014f }] */
    private void a(String str, String str2, IWebview iWebview, String str3) {
        float f2;
        int i;
        String str4;
        if (PdrUtil.isEmpty(str) || PdrUtil.isNetPath(str)) {
            return;
        }
        String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        if (strConvert2AbsFullPath.startsWith("apps/")) {
            strConvert2AbsFullPath = "/" + strConvert2AbsFullPath;
        }
        if (strConvert2AbsFullPath.startsWith("/android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("/android_asset", "");
        } else if (strConvert2AbsFullPath.startsWith("android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("android_asset", "");
        }
        String strCheckPrivateDirAndCopy2Temp = iWebview.obtainApp().checkPrivateDirAndCopy2Temp(strConvert2AbsFullPath);
        if (!strCheckPrivateDirAndCopy2Temp.startsWith("content://")) {
            if (!FileUtil.checkPathAccord(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp) && !FileUtil.isFilePathForPublic(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp)) {
                a(15, iWebview, str2);
                return;
            } else if (!new File(strCheckPrivateDirAndCopy2Temp).exists()) {
                Deprecated_JSUtil.execCallback(iWebview, str2, StringUtil.format(DOMException.JSON_ERROR_INFO, -4, DOMException.MSG_FILE_NOT_EXIST), JSUtil.ERROR, true, false);
                return;
            }
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (FileUtil.checkPrivatePath(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp)) {
                mediaMetadataRetriever.setDataSource(strCheckPrivateDirAndCopy2Temp);
            } else if (strCheckPrivateDirAndCopy2Temp.startsWith("content://")) {
                mediaMetadataRetriever.setDataSource(iWebview.getContext(), Uri.parse(strCheckPrivateDirAndCopy2Temp));
            } else {
                Uri videoFileUri = FileUtil.getVideoFileUri(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp);
                if (videoFileUri != null) {
                    mediaMetadataRetriever.setDataSource(iWebview.getContext(), videoFileUri);
                }
            }
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
            String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
            JSONObject jSONObject = new JSONObject();
            if (str3.equals("getVideoInfo")) {
                if ("90".equals(strExtractMetadata4) || "270".equals(strExtractMetadata4)) {
                    strExtractMetadata3 = strExtractMetadata2;
                    strExtractMetadata2 = strExtractMetadata3;
                }
                if (strExtractMetadata2 == null || strExtractMetadata3 == null) {
                    f2 = 1000.0f;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strExtractMetadata2);
                    f2 = 1000.0f;
                    sb.append("*");
                    sb.append(strExtractMetadata3);
                    jSONObject.put("resolution", sb.toString());
                }
                if (strExtractMetadata2 != null) {
                    try {
                        jSONObject.put("width", Float.parseFloat(strExtractMetadata2));
                        if (strExtractMetadata3 != null) {
                            jSONObject.put("height", Float.parseFloat(strExtractMetadata3));
                        }
                    } catch (Exception unused) {
                    }
                } else if (strExtractMetadata3 != null) {
                    jSONObject.put("height", Float.parseFloat(strExtractMetadata3));
                }
                if (strCheckPrivateDirAndCopy2Temp.startsWith("content://")) {
                    InputStream inputStreamOpenInputStream = iWebview.getContext().getContentResolver().openInputStream(Uri.parse(strCheckPrivateDirAndCopy2Temp));
                    if (inputStreamOpenInputStream != null) {
                        try {
                            try {
                                jSONObject.put(AbsoluteConst.JSON_KEY_SIZE, inputStreamOpenInputStream.available());
                            } catch (IOException unused2) {
                                jSONObject.put(AbsoluteConst.JSON_KEY_SIZE, 0);
                            }
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException unused3) {
                            }
                            i = 0;
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException unused4) {
                            }
                            throw th;
                        }
                    } else {
                        i = 0;
                        jSONObject.put(AbsoluteConst.JSON_KEY_SIZE, 0);
                    }
                } else {
                    i = 0;
                    jSONObject.put(AbsoluteConst.JSON_KEY_SIZE, new File(strCheckPrivateDirAndCopy2Temp).length());
                }
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(32);
                if (TextUtils.isEmpty(strExtractMetadata5)) {
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    if (FileUtil.checkPrivatePath(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp)) {
                        mediaExtractor.setDataSource(strCheckPrivateDirAndCopy2Temp);
                    } else {
                        Uri videoFileUri2 = FileUtil.getVideoFileUri(iWebview.getContext(), strCheckPrivateDirAndCopy2Temp);
                        if (videoFileUri2 != null) {
                            mediaExtractor.setDataSource(iWebview.getContext(), videoFileUri2, (Map<String, String>) null);
                        }
                    }
                    int trackCount = mediaExtractor.getTrackCount();
                    while (i < trackCount) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                        try {
                            String string = trackFormat.getString("mime");
                            if (!TextUtils.isEmpty(string) && string.startsWith("video/")) {
                                jSONObject.put("fps", trackFormat.getInteger("frame-rate"));
                            }
                        } catch (Exception unused5) {
                        }
                        i++;
                    }
                } else {
                    try {
                        jSONObject.put("fps", Math.ceil((Float.parseFloat(strExtractMetadata5) / Float.parseFloat(strExtractMetadata)) * f2));
                    } catch (Exception unused6) {
                    }
                }
                int iHashCode = strExtractMetadata4.hashCode();
                if (iHashCode != 1815) {
                    if (iHashCode != 48873) {
                        if (iHashCode == 49803 && strExtractMetadata4.equals("270")) {
                            str4 = "left";
                        } else {
                            str4 = "up";
                        }
                    } else if (strExtractMetadata4.equals("180")) {
                        str4 = "down";
                    } else {
                        str4 = "up";
                    }
                } else if (strExtractMetadata4.equals("90")) {
                    str4 = "right";
                } else {
                    str4 = "up";
                }
                jSONObject.put("orientation", str4);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(12);
                if (!TextUtils.isEmpty(strExtractMetadata6)) {
                    jSONObject.put("type", strExtractMetadata6);
                }
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(20);
                if (!TextUtils.isEmpty(strExtractMetadata7)) {
                    try {
                        jSONObject.put("bitrate", Integer.valueOf(Integer.parseInt(strExtractMetadata7) / 1000));
                    } catch (Exception unused7) {
                    }
                }
            } else {
                f2 = 1000.0f;
            }
            try {
                jSONObject.put("duration", BigDecimal.valueOf(Float.parseFloat(strExtractMetadata) / f2).setScale(2, 4));
            } catch (Exception unused8) {
            }
            Deprecated_JSUtil.execCallback(iWebview, str2, jSONObject.toString(), JSUtil.OK, true, false);
        } catch (Exception e2) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("code", 13);
                jSONObject2.put("message", e2.getMessage());
            } catch (JSONException unused9) {
            }
            Deprecated_JSUtil.execCallback(iWebview, str2, jSONObject2.toString(), JSUtil.ERROR, true, false);
        }
    }

    public static String b(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    private JSONObject a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (str.startsWith(a)) {
            jSONObject.put("type", 1);
            jSONObject.put("fsName", "PRIVATE_WWW");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PRIVATE_WWW", a, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(c)) {
            jSONObject.put("type", 2);
            jSONObject.put("fsName", "PRIVATE_DOCUMENTS");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PRIVATE_DOCUMENTS", c, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(d)) {
            jSONObject.put("type", 3);
            jSONObject.put("fsName", "PUBLIC_DOCUMENTS");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PUBLIC_DOCUMENTS", d, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(e)) {
            jSONObject.put("type", 4);
            jSONObject.put("fsName", "PUBLIC_DOWNLOADS");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PUBLIC_DOWNLOADS", e, c(str), true));
            return jSONObject;
        }
        if (str.startsWith(b)) {
            jSONObject.put("type", 1);
            jSONObject.put("fsName", "PRIVATE_WWW");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PRIVATE_WWW", b, c(str), true));
            return jSONObject;
        }
        if (PdrUtil.isDeviceRootDir(str)) {
            jSONObject.put("type", 5);
            jSONObject.put("fsName", "PUBLIC_DEVICE_ROOT");
            jSONObject.put("fsRoot", io.dcloud.js.file.a.a("PUBLIC_DEVICE_ROOT", DeviceInfo.sDeviceRootDir, c(str), true));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, IWebview iWebview, String str) {
        Deprecated_JSUtil.execCallback(iWebview, str, a(iWebview.getContext(), i), JSUtil.ERROR, true, false);
    }

    private String a(Context context, int i) {
        switch (i) {
            case 1:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_file_not_found));
            case 2:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_without_authorization));
            case 3:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_common_cancel));
            case 4:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_file_not_read));
            case 5:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_coding_error));
            case 6:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_no_modification_allowed));
            case 7:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_invalid_state));
            case 8:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_grammar_mistakes));
            case 9:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_invalid_modification));
            case 10:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_perform_error));
            case 11:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_type_mismatch));
            case 12:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_path_exists));
            case 13:
            default:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_unknown_error));
            case 14:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), context.getString(R.string.dcloud_io_path_not_exist));
            case 15:
                return StringUtil.format(DOMException.JSON_ERROR_INFO, Integer.valueOf(i), DOMException.MSG_PATH_NOT_PRIVATE_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0049 A[Catch: IOException -> 0x0116, JSONException -> 0x011a, TRY_ENTER, TryCatch #3 {IOException -> 0x0116, blocks: (B:4:0x000d, B:17:0x0055, B:22:0x006f, B:53:0x00d5, B:57:0x0109, B:56:0x0103, B:16:0x0049), top: B:76:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    public void a(String str, IWebview iWebview, String str2) {
        String str3;
        JSONException jSONException;
        String attribute;
        String str4;
        String str5;
        try {
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    String str6 = null;
                    if (!FileUtil.checkPrivatePath(iWebview.getContext(), str)) {
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                InputStream fileInputStream = FileUtil.getFileInputStream(iWebview.getContext(), str);
                                if (fileInputStream != null) {
                                    BitmapFactory.decodeStream(fileInputStream, null, options);
                                    g4$$ExternalSyntheticApiModelOutline0.m$4();
                                    attribute = g4$$ExternalSyntheticApiModelOutline0.m(fileInputStream).getAttribute("Orientation");
                                    fileInputStream.close();
                                } else {
                                    attribute = null;
                                }
                            } else {
                                attribute = new ExifInterface(str).getAttribute("Orientation");
                                BitmapFactory.decodeFile(str, options);
                            }
                        } catch (JSONException e2) {
                            jSONException = e2;
                            str3 = str2;
                            Deprecated_JSUtil.execCallback(iWebview, str3, StringUtil.format(DOMException.JSON_ERROR_INFO, 13, jSONException.getMessage()), JSUtil.ERROR, true, false);
                        }
                    } else {
                        attribute = new ExifInterface(str).getAttribute("Orientation");
                        BitmapFactory.decodeFile(str, options);
                    }
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    String lowerCase = options.outMimeType;
                    if (!PdrUtil.isEmpty(lowerCase) && lowerCase.contains("/")) {
                        String[] strArrSplit = lowerCase.split("/");
                        lowerCase = strArrSplit[strArrSplit.length - 1];
                    }
                    if (!TextUtils.isEmpty(attribute)) {
                        switch (attribute.hashCode()) {
                            case 48:
                                str4 = WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
                                attribute.equals(str4);
                                str5 = "up";
                                break;
                            case 49:
                                str4 = "1";
                                attribute.equals(str4);
                                str5 = "up";
                                break;
                            case 50:
                                if (attribute.equals("2")) {
                                    str5 = "up-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 51:
                                if (attribute.equals("3")) {
                                    str5 = "down";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 52:
                                if (attribute.equals("4")) {
                                    str5 = "down-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 53:
                                if (attribute.equals("5")) {
                                    str5 = "left-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 54:
                                if (attribute.equals("6")) {
                                    str5 = "right";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case Opcodes.LSTORE /* 55 */:
                                if (attribute.equals("7")) {
                                    str5 = "right-mirrored";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            case 56:
                                if (attribute.equals("8")) {
                                    str5 = "left";
                                } else {
                                    str5 = "up";
                                }
                                break;
                            default:
                                str5 = "up";
                                break;
                        }
                        str6 = str5;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AbsoluteConst.XML_PATH, DeviceInfo.FILE_PROTOCOL + str);
                    jSONObject.put("width", i);
                    jSONObject.put("height", i2);
                    jSONObject.put("orientation", str6);
                    if (!PdrUtil.isEmpty(lowerCase)) {
                        lowerCase = lowerCase.toLowerCase(Locale.ENGLISH);
                    }
                    jSONObject.put("type", lowerCase);
                    str3 = str2;
                    try {
                        JSUtil.execCallback(iWebview, str3, jSONObject, JSUtil.OK, false);
                    } catch (JSONException e3) {
                        e = e3;
                        jSONException = e;
                        Deprecated_JSUtil.execCallback(iWebview, str3, StringUtil.format(DOMException.JSON_ERROR_INFO, 13, jSONException.getMessage()), JSUtil.ERROR, true, false);
                    }
                } catch (IOException e4) {
                    e = e4;
                    Deprecated_JSUtil.execCallback(iWebview, str2, StringUtil.format(DOMException.JSON_ERROR_INFO, 13, e.getMessage()), JSUtil.ERROR, true, false);
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (JSONException e6) {
            e = e6;
            str3 = str2;
        }
    }

    private String[] a(IWebview iWebview, String[] strArr, String str) {
        if (strArr.length > 1 && !PdrUtil.isEmpty(strArr[1])) {
            try {
                return JSUtil.jsonArrayToStringArr(new JSONArray(strArr[1]));
            } catch (JSONException e2) {
                e2.printStackTrace();
                a(8, iWebview, str);
            }
        }
        return null;
    }
}
