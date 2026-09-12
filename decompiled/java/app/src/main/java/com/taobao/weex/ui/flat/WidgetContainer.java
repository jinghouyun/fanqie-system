package com.taobao.weex.ui.flat;

import android.util.Pair;
import android.view.ViewGroup;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.flat.widget.AndroidViewWidget;
import com.taobao.weex.ui.flat.widget.Widget;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetContainer<T extends ViewGroup> extends WXVContainer<T> {
    protected List<Widget> widgets;

    public WidgetContainer(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    private void addFlatChild(Widget widget, int i) {
        if (this.widgets == null) {
            this.widgets = new LinkedList();
        }
        if (i >= this.widgets.size()) {
            this.widgets.add(widget);
        } else {
            this.widgets.add(i, widget);
        }
        mountFlatGUI();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void createChildViewAt(int i) {
        Widget orCreateFlatWidget;
        if (!intendToBeFlatContainer()) {
            super.createChildViewAt(i);
            return;
        }
        Pair<WXComponent, Integer> pairRearrangeIndexAndGetChild = rearrangeIndexAndGetChild(i);
        Object obj = pairRearrangeIndexAndGetChild.first;
        if (obj != null) {
            WXComponent wXComponent = (WXComponent) obj;
            FlatGUIContext flatUIContext = getInstance().getFlatUIContext();
            WidgetContainer flatComponentAncestor = flatUIContext.getFlatComponentAncestor(this);
            if (flatComponentAncestor == null || flatUIContext.getAndroidViewWidget(this) != null) {
                flatComponentAncestor = this;
            }
            flatUIContext.register(wXComponent, flatComponentAncestor);
            if (wXComponent instanceof FlatComponent) {
                FlatComponent flatComponent = (FlatComponent) wXComponent;
                if (flatComponent.promoteToView(false)) {
                    AndroidViewWidget androidViewWidget = new AndroidViewWidget(flatUIContext);
                    flatUIContext.register(wXComponent, androidViewWidget);
                    wXComponent.createView();
                    androidViewWidget.setContentView(wXComponent.getHostView());
                    flatComponentAncestor.addSubView(wXComponent.getHostView(), -1);
                    orCreateFlatWidget = androidViewWidget;
                } else {
                    orCreateFlatWidget = flatComponent.getOrCreateFlatWidget();
                }
            } else {
                AndroidViewWidget androidViewWidget2 = new AndroidViewWidget(flatUIContext);
                flatUIContext.register(wXComponent, androidViewWidget2);
                wXComponent.createView();
                androidViewWidget2.setContentView(wXComponent.getHostView());
                flatComponentAncestor.addSubView(wXComponent.getHostView(), -1);
                orCreateFlatWidget = androidViewWidget2;
            }
            flatUIContext.register(orCreateFlatWidget, wXComponent);
            addFlatChild(orCreateFlatWidget, ((Integer) pairRearrangeIndexAndGetChild.second).intValue());
        }
    }

    public boolean intendToBeFlatContainer() {
        return false;
    }

    protected abstract void mountFlatGUI();

    protected abstract void unmountFlatGUI();
}
