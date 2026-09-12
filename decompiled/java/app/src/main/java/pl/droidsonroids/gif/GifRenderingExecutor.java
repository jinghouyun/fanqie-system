package pl.droidsonroids.gif;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes2.dex */
final class GifRenderingExecutor extends ScheduledThreadPoolExecutor implements AutoCloseable {
    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    private static final class InstanceHolder {
        private static final GifRenderingExecutor INSTANCE = new GifRenderingExecutor();

        private InstanceHolder() {
        }
    }

    static GifRenderingExecutor getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private GifRenderingExecutor() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
