package com.taobao.weex.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.tools.LogDetail;
import com.taobao.weex.utils.tools.TimeCalculator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXThread extends HandlerThread {
    private Handler mHandler;

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    static class SafeCallback implements Handler.Callback {
        static final String TAG = "SafeCallback";
        final Handler.Callback mCallback;

        SafeCallback(Handler.Callback callback) {
            this.mCallback = callback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                Handler.Callback callback = this.mCallback;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
                return false;
            } catch (Throwable th) {
                if (!WXEnvironment.isApkDebugable()) {
                    return false;
                }
                WXLogUtils.e(TAG, "SafeCallback handleMessage throw expection:" + th.getMessage());
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    static class SafeRunnable implements Runnable {
        static final String TAG = "SafeRunnable";
        private WeakReference<WXSDKInstance> mInstance;
        final Runnable mTask;
        private LogDetail mTimelineLog;

        SafeRunnable(Runnable runnable) {
            this(runnable, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<WXSDKInstance> weakReference;
            WXSDKInstance wXSDKInstance;
            TimeCalculator timeCalculator;
            try {
                if (this.mTask != null) {
                    LogDetail logDetail = this.mTimelineLog;
                    if (logDetail != null) {
                        logDetail.taskStart();
                    }
                    this.mTask.run();
                    LogDetail logDetail2 = this.mTimelineLog;
                    if (logDetail2 != null) {
                        logDetail2.taskEnd();
                    }
                }
            } catch (Throwable th) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.e(TAG, "SafeRunnable run throw expection:" + th.getMessage());
                    throw th;
                }
                WXLogUtils.w(TAG, th);
            }
            if (this.mTimelineLog == null || (weakReference = this.mInstance) == null || (wXSDKInstance = weakReference.get()) == null || (timeCalculator = wXSDKInstance.mTimeCalculator) == null) {
                return;
            }
            timeCalculator.addLog(this.mTimelineLog);
        }

        SafeRunnable(Runnable runnable, String str) {
            this(runnable, null, str);
        }

        SafeRunnable(Runnable runnable, WXSDKInstance wXSDKInstance, String str) {
            this.mTimelineLog = null;
            this.mTask = runnable;
            if (str != null) {
                LogDetail logDetail = new LogDetail();
                this.mTimelineLog = logDetail;
                logDetail.info.platform = TimeCalculator.PLATFORM_ANDROID;
                logDetail.name(str);
                this.mInstance = new WeakReference<>(wXSDKInstance);
            }
        }
    }

    public WXThread(String str) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public static Runnable secure(Runnable runnable) {
        return secure(runnable, null, null);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public boolean isWXThreadAlive() {
        return (this.mHandler == null || getLooper() == null || !isAlive()) ? false : true;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }

    public static Runnable secure(Runnable runnable, WXSDKInstance wXSDKInstance, String str) {
        return (runnable == null || (runnable instanceof SafeRunnable)) ? runnable : new SafeRunnable(runnable, wXSDKInstance, str);
    }

    public WXThread(String str, Handler.Callback callback) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper(), secure(callback));
    }

    public static Handler.Callback secure(Handler.Callback callback) {
        return (callback == null || (callback instanceof SafeCallback)) ? callback : new SafeCallback(callback);
    }

    public WXThread(String str, int i, Handler.Callback callback) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper(), secure(callback));
    }

    public WXThread(String str, int i) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper());
    }
}
