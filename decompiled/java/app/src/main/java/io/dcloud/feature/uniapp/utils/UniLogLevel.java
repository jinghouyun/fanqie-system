package io.dcloud.feature.uniapp.utils;

import io.dcloud.common.constant.AbsoluteConst;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public enum UniLogLevel implements AbsLogLevel {
    OFF(DebugKt.DEBUG_PROPERTY_VALUE_OFF, 8, 7),
    WTF("wtf", 7, 7),
    TLOG("tlog", 6, 6),
    ERROR("error", 5, 6),
    WARN("warn", 4, 5),
    INFO("info", 3, 4),
    DEBUG(AbsoluteConst.XML_DEBUG, 2, 3),
    VERBOSE("verbose", 1, 2),
    ALL("all", 0, 2);

    String name;
    int priority;
    int value;

    UniLogLevel(String str, int i, int i2) {
        this.name = str;
        this.value = i;
        this.priority = i2;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public int compare(AbsLogLevel absLogLevel) {
        return this.value - absLogLevel.getValue();
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public String getName() {
        return this.name;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public int getPriority() {
        return this.priority;
    }

    @Override // io.dcloud.feature.uniapp.utils.AbsLogLevel
    public int getValue() {
        return this.value;
    }
}
