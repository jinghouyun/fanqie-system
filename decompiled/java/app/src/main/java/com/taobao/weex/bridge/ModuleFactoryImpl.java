package com.taobao.weex.bridge;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ModuleFactoryImpl {
    public boolean hasRigster;
    public ModuleFactory mFactory;

    public ModuleFactoryImpl(ModuleFactory moduleFactory) {
        this.hasRigster = false;
        this.mFactory = moduleFactory;
    }

    public ModuleFactoryImpl(ModuleFactory moduleFactory, boolean z) {
        this.mFactory = moduleFactory;
        this.hasRigster = z;
    }
}
