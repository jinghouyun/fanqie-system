package com.taobao.weex.tracing;

import android.os.Looper;
import android.util.SparseArray;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.ITracingAdapter;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXTracing {
    private static final AtomicInteger sIdGenerator = new AtomicInteger(0);

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class TraceEvent {
        public String classname;
        public double duration;
        public Map<String, Object> extParams;
        public boolean firstScreenFinish;
        public String fname;
        public String iid;
        public boolean isSegment;
        public String name;
        public String parentRef;
        public double parseJsonTime;
        public String payload;
        public String ph;
        public String ref;
        public SparseArray<TraceEvent> subEvents;
        private boolean submitted;
        public int parentId = -1;
        public long ts = System.currentTimeMillis();
        public int traceId = WXTracing.nextId();
        public String tname = WXTracing.currentThreadName();

        public void submit() {
            if (!this.submitted) {
                this.submitted = true;
                WXTracing.submit(this);
            } else {
                WXLogUtils.w("WXTracing", "Event " + this.traceId + " has been submitted.");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class TraceInfo {
        public long domQueueTime;
        public long domThreadNanos;
        public int rootEventId;
        public long uiQueueTime;
        public long uiThreadNanos;
        public long domThreadStart = -1;
        public long uiThreadStart = -1;
    }

    public static String currentThreadName() {
        String name = Thread.currentThread().getName();
        if ("WeexJSBridgeThread".equals(name)) {
            return "JSThread";
        }
        if ("WeeXDomThread".equals(name)) {
            return "DOMThread";
        }
        return Looper.getMainLooper() == Looper.myLooper() ? "UIThread" : name;
    }

    public static boolean isAvailable() {
        return WXEnvironment.isApkDebugable();
    }

    public static TraceEvent newEvent(String str, String str2, int i) {
        TraceEvent traceEvent = new TraceEvent();
        traceEvent.fname = str;
        traceEvent.iid = str2;
        traceEvent.traceId = nextId();
        traceEvent.parentId = i;
        return traceEvent;
    }

    public static int nextId() {
        return sIdGenerator.getAndIncrement();
    }

    public static synchronized void submit(TraceEvent traceEvent) {
        ITracingAdapter tracingAdapter = WXSDKManager.getInstance().getTracingAdapter();
        if (tracingAdapter != null) {
            tracingAdapter.submitTracingEvent(traceEvent);
        }
    }
}
