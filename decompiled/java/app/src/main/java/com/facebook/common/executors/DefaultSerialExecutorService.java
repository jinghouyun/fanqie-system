package com.facebook.common.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService, AutoCloseable {
    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        UByte$$ExternalSyntheticBackport0.m((ExecutorService) this);
    }

    public DefaultSerialExecutorService(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
