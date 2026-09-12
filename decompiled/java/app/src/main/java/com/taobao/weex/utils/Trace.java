package com.taobao.weex.utils;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class Trace {
    private static final String TAG = "Weex_Trace";
    private static final boolean sEnabled = false;
    private static final AbstractTrace sTrace = new TraceDummy();

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    private static abstract class AbstractTrace {
        private AbstractTrace() {
        }

        abstract void beginSection(String str);

        abstract void endSection();
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    private static final class TraceDummy extends AbstractTrace {
        private TraceDummy() {
            super();
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void beginSection(String str) {
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void endSection() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    private static final class TraceJBMR2 extends AbstractTrace {
        private TraceJBMR2() {
            super();
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void beginSection(String str) {
            android.os.Trace.beginSection(str);
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void endSection() {
            android.os.Trace.endSection();
        }
    }

    public static void beginSection(String str) {
        Log.i(TAG, "beginSection() " + str);
        sTrace.beginSection(str);
    }

    public static void endSection() {
        sTrace.endSection();
        Log.i(TAG, "endSection()");
    }

    public static final boolean getTraceEnabled() {
        return sEnabled;
    }
}
