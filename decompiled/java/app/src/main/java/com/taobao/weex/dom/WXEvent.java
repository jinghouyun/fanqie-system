package com.taobao.weex.dom;

import io.dcloud.feature.uniapp.dom.AbsEvent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXEvent extends AbsEvent {
    @Override // io.dcloud.feature.uniapp.dom.AbsEvent, java.util.ArrayList
    public WXEvent clone() {
        WXEvent wXEvent = new WXEvent();
        wXEvent.addAll(this);
        if (getEventBindingArgs() != null) {
            wXEvent.setEventBindingArgs(getEventBindingArgs());
        }
        wXEvent.setEventBindingArgsValues(null);
        return wXEvent;
    }
}
