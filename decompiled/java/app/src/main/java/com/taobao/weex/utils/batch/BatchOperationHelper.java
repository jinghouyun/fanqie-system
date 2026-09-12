package com.taobao.weex.utils.batch;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class BatchOperationHelper implements Interceptor {
    private boolean isCollecting;
    private BactchExecutor mExecutor;
    private CopyOnWriteArrayList<Runnable> sRegisterTasks = new CopyOnWriteArrayList<>();

    public BatchOperationHelper(BactchExecutor bactchExecutor) {
        this.isCollecting = false;
        this.mExecutor = bactchExecutor;
        bactchExecutor.setInterceptor(this);
        this.isCollecting = true;
    }

    public void flush() {
        this.isCollecting = false;
        this.mExecutor.post(new Runnable() { // from class: com.taobao.weex.utils.batch.BatchOperationHelper.1
            @Override // java.lang.Runnable
            public void run() {
                for (Runnable runnable : BatchOperationHelper.this.sRegisterTasks) {
                    runnable.run();
                    BatchOperationHelper.this.sRegisterTasks.remove(runnable);
                }
            }
        });
        this.mExecutor.setInterceptor(null);
    }

    @Override // com.taobao.weex.utils.batch.Interceptor
    public boolean take(Runnable runnable) {
        if (!this.isCollecting) {
            return false;
        }
        this.sRegisterTasks.add(runnable);
        return true;
    }
}
