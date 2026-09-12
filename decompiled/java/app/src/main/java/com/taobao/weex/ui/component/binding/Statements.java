package com.taobao.weex.ui.component.binding;

import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.dom.binding.ELUtils;
import com.taobao.weex.dom.binding.JSONUtils;
import com.taobao.weex.dom.binding.WXStatement;
import com.taobao.weex.el.parse.ArrayStack;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.el.parse.Token;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.action.GraphicPosition;
import com.taobao.weex.ui.action.GraphicSize;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentFactory;
import com.taobao.weex.ui.component.WXImage;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.template.CellDataManager;
import com.taobao.weex.ui.component.list.template.CellRenderContext;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle;
import com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList;
import com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class Statements {
    private static final ThreadLocal<Map<String, Object>> dynamicLocal = new ThreadLocal<>();

    public static WXComponent copyComponentTree(WXComponent wXComponent) {
        return copyComponentTree(wXComponent, wXComponent.getParent());
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0150  */
    private static void doBindingAttrsEventAndRenderChildNode(WXComponent wXComponent, CellRenderContext cellRenderContext, List<WXComponent> list) {
        char c;
        char c2;
        String str;
        boolean z;
        Object objRenderProps;
        Object obj;
        boolean z2;
        Object obj2;
        WXAttr attrs = wXComponent.getAttrs();
        ArrayStack arrayStack = cellRenderContext.stack;
        if (attrs.get(ELUtils.IS_COMPONENT_ROOT) == null || !WXUtils.getBoolean(attrs.get(ELUtils.IS_COMPONENT_ROOT), Boolean.FALSE).booleanValue() || attrs.get(ELUtils.COMPONENT_PROPS) == null || !JSONUtils.isJSON(attrs.get(ELUtils.COMPONENT_PROPS))) {
            c = 3;
            c2 = 0;
            str = null;
            z = false;
        } else {
            String str2 = (String) attrs.get(CellDataManager.SUB_COMPONENT_TEMPLATE_ID);
            if (TextUtils.isEmpty(str2)) {
                c = 3;
                c2 = 0;
                str = null;
                z = false;
                objRenderProps = renderProps((JSONObject) attrs.get(ELUtils.COMPONENT_PROPS), cellRenderContext.stack);
            } else {
                String strCreateVirtualComponentId = cellRenderContext.getRenderState().getVirtualComponentIds().get(wXComponent.getViewTreeKey());
                if (strCreateVirtualComponentId == null) {
                    c = 3;
                    c2 = 0;
                    strCreateVirtualComponentId = CellDataManager.createVirtualComponentId(cellRenderContext.templateList.getRef(), wXComponent.getViewTreeKey(), cellRenderContext.templateList.getItemId(cellRenderContext.position));
                    Map<String, Object> mapRenderProps = renderProps(JSONUtils.toJSON(attrs.get(ELUtils.COMPONENT_PROPS)), cellRenderContext.stack);
                    EventResult eventResultSyncCallJSEventWithResult = WXBridgeManager.getInstance().syncCallJSEventWithResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, str2, VirtualComponentLifecycle.LIFECYCLE, "create", new Object[]{strCreateVirtualComponentId, mapRenderProps}, null);
                    if (eventResultSyncCallJSEventWithResult != null && eventResultSyncCallJSEventWithResult.getResult() != null && (eventResultSyncCallJSEventWithResult.getResult() instanceof Map)) {
                        mapRenderProps.putAll((Map) eventResultSyncCallJSEventWithResult.getResult());
                    }
                    cellRenderContext.getRenderState().getVirtualComponentIds().put(wXComponent.getViewTreeKey(), strCreateVirtualComponentId);
                    cellRenderContext.templateList.getCellDataManager().createVirtualComponentData(cellRenderContext.position, strCreateVirtualComponentId, mapRenderProps);
                    z2 = true;
                    obj2 = mapRenderProps;
                } else {
                    c = 3;
                    c2 = 0;
                    Object obj3 = cellRenderContext.getRenderState().getVirtualComponentDatas().get(strCreateVirtualComponentId);
                    if (cellRenderContext.getRenderState().isHasDataUpdate()) {
                        Map<String, Object> mapRenderProps2 = renderProps((JSONObject) attrs.get(ELUtils.COMPONENT_PROPS), cellRenderContext.stack);
                        EventResult eventResultSyncCallJSEventWithResult2 = WXBridgeManager.getInstance().syncCallJSEventWithResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, strCreateVirtualComponentId, VirtualComponentLifecycle.LIFECYCLE, VirtualComponentLifecycle.SYNSTATE, new Object[]{strCreateVirtualComponentId, mapRenderProps2}, null);
                        if (eventResultSyncCallJSEventWithResult2 == null || eventResultSyncCallJSEventWithResult2.getResult() == null || !(eventResultSyncCallJSEventWithResult2.getResult() instanceof Map)) {
                            obj = obj3;
                        } else {
                            mapRenderProps2.putAll((Map) eventResultSyncCallJSEventWithResult2.getResult());
                            cellRenderContext.templateList.getCellDataManager().updateVirtualComponentData(strCreateVirtualComponentId, mapRenderProps2);
                            obj = mapRenderProps2;
                        }
                    } else {
                        obj = obj3;
                    }
                    z2 = false;
                    obj2 = obj;
                }
                wXComponent.getAttrs().put(CellDataManager.VIRTUAL_COMPONENT_ID, (Object) strCreateVirtualComponentId);
                z = z2;
                str = strCreateVirtualComponentId;
                objRenderProps = obj2;
            }
            ArrayStack arrayStack2 = new ArrayStack();
            cellRenderContext.stack = arrayStack2;
            if (objRenderProps != null) {
                arrayStack2.push(objRenderProps);
            }
        }
        if ((attrs.getStatement() != null ? attrs.getStatement().get(WXStatement.WX_ONCE) : null) != null) {
            ArrayStack arrayStackCopyStack = cellRenderContext.getRenderState().getOnceComponentStates().get(wXComponent.getViewTreeKey());
            if (arrayStackCopyStack == null) {
                arrayStackCopyStack = cellRenderContext.templateList.copyStack(cellRenderContext, arrayStack);
                cellRenderContext.getRenderState().getOnceComponentStates().put(wXComponent.getViewTreeKey(), arrayStackCopyStack);
            }
            cellRenderContext.stack = arrayStackCopyStack;
        }
        doRenderBindingAttrsAndEvent(wXComponent, cellRenderContext);
        if (wXComponent instanceof WXVContainer) {
            if (wXComponent.isWaste() && !(wXComponent instanceof WXCell)) {
                return;
            }
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            int iDoRenderComponent = 0;
            while (iDoRenderComponent < wXVContainer.getChildCount()) {
                iDoRenderComponent += doRenderComponent(wXVContainer.getChild(iDoRenderComponent), cellRenderContext, list);
            }
        }
        if (arrayStack != cellRenderContext.stack) {
            cellRenderContext.stack = arrayStack;
        }
        if (!z || str == null) {
            return;
        }
        WXBridgeManager wXBridgeManager = WXBridgeManager.getInstance();
        String instanceId = wXComponent.getInstanceId();
        Object[] objArr = new Object[1];
        objArr[c2] = TemplateDom.findAllComponentRefs(cellRenderContext.templateList.getRef(), cellRenderContext.position, wXComponent);
        Object[] objArr2 = new Object[4];
        objArr2[c2] = str;
        objArr2[1] = VirtualComponentLifecycle.LIFECYCLE;
        objArr2[2] = "attach";
        objArr2[c] = objArr;
        wXBridgeManager.asyncCallJSEventVoidResult(WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, instanceId, null, objArr2);
    }

    public static final void doInitCompontent(List<WXComponent> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (WXComponent wXComponent : list) {
            if (wXComponent.getParent() == null) {
                throw new IllegalArgumentException("render node parent cann't find");
            }
            WXVContainer parent = wXComponent.getParent();
            int iIndexOf = parent.indexOf(wXComponent);
            if (iIndexOf < 0) {
                throw new IllegalArgumentException("render node cann't find");
            }
            parent.createChildViewAt(iIndexOf);
            wXComponent.applyLayoutAndEvent(wXComponent);
            wXComponent.bindData(wXComponent);
        }
    }

    public static final List<WXComponent> doRender(WXComponent wXComponent, CellRenderContext cellRenderContext) {
        ArrayList arrayList = new ArrayList(4);
        try {
            doRenderComponent(wXComponent, cellRenderContext, arrayList);
            return arrayList;
        } catch (Exception e) {
            WXLogUtils.e("WeexStatementRender", e);
            return arrayList;
        }
    }

    private static void doRenderBindingAttrsAndEvent(WXComponent wXComponent, CellRenderContext cellRenderContext) {
        ArrayStack arrayStack = cellRenderContext.stack;
        wXComponent.setWaste(false);
        WXAttr attrs = wXComponent.getAttrs();
        if (attrs != null && attrs.getBindingAttrs() != null && attrs.getBindingAttrs().size() > 0) {
            Map<String, Object> mapRenderBindingAttrs = renderBindingAttrs(wXComponent.getAttrs().getBindingAttrs(), arrayStack);
            Iterator<Map.Entry<String, Object>> it = mapRenderBindingAttrs.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                Object value = next.getValue();
                Object obj = attrs.get(key);
                if (value == null) {
                    if (obj == null) {
                        it.remove();
                    }
                } else if (value.equals(obj)) {
                    it.remove();
                }
            }
            if (mapRenderBindingAttrs.size() > 0) {
                if (mapRenderBindingAttrs.size() == 1 && mapRenderBindingAttrs.get("src") != null && (wXComponent instanceof WXImage)) {
                    wXComponent.getAttrs().put("src", mapRenderBindingAttrs.get("src"));
                } else {
                    wXComponent.nativeUpdateAttrs(mapRenderBindingAttrs);
                }
                if (isMainThread()) {
                    wXComponent.updateProperties(mapRenderBindingAttrs);
                }
                mapRenderBindingAttrs.clear();
            }
        }
        WXStyle styles = wXComponent.getStyles();
        if (styles != null && styles.getBindingStyle() != null) {
            Map<String, Object> mapRenderBindingAttrs2 = renderBindingAttrs(styles.getBindingStyle(), arrayStack);
            Iterator<Map.Entry<String, Object>> it2 = mapRenderBindingAttrs2.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Object> next2 = it2.next();
                String key2 = next2.getKey();
                Object value2 = next2.getValue();
                Object obj2 = styles.get(key2);
                if (value2 == null) {
                    if (obj2 == null) {
                        it2.remove();
                    }
                } else if (value2.equals(obj2)) {
                    it2.remove();
                }
            }
            if (mapRenderBindingAttrs2.size() > 0) {
                wXComponent.updateNativeStyles(mapRenderBindingAttrs2);
                if (isMainThread()) {
                    wXComponent.updateProperties(mapRenderBindingAttrs2);
                }
            }
        }
        WXEvent events = wXComponent.getEvents();
        if (events == null || events.getEventBindingArgs() == null) {
            return;
        }
        for (Map.Entry entry : events.getEventBindingArgs().entrySet()) {
            List<Object> bindingEventArgs = getBindingEventArgs(arrayStack, entry.getValue());
            if (bindingEventArgs != null) {
                events.putEventBindingArgsValue((String) entry.getKey(), bindingEventArgs);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:87:0x01ed  */
    private static final int doRenderComponent(WXComponent wXComponent, CellRenderContext cellRenderContext, List<WXComponent> list) {
        int i;
        Collection collectionKeySet;
        Map map;
        Object obj;
        boolean z;
        WXComponent wXComponentCopyComponentTree;
        Map map2;
        String str;
        int i2;
        WXVContainer parent = wXComponent.getParent();
        WXStatement statement = wXComponent.getAttrs().getStatement();
        if (statement == null) {
            i = 1;
        } else {
            Token token = statement.get(WXStatement.WX_IF) instanceof Token ? (Token) statement.get(WXStatement.WX_IF) : null;
            String str2 = WXStatement.WX_FOR;
            JSONObject jSONObject = statement.get(WXStatement.WX_FOR) instanceof JSONObject ? (JSONObject) statement.get(WXStatement.WX_FOR) : null;
            if (jSONObject != null) {
                int iIndexOf = parent.indexOf(wXComponent);
                if (jSONObject.get(WXStatement.WX_FOR_LIST) instanceof Token) {
                    Token token2 = (Token) jSONObject.get(WXStatement.WX_FOR_LIST);
                    String string = jSONObject.getString(WXStatement.WX_FOR_INDEX);
                    String string2 = jSONObject.getString(WXStatement.WX_FOR_ITEM);
                    Object objExecute = token2 != null ? token2.execute(cellRenderContext.stack) : null;
                    boolean z2 = objExecute instanceof List;
                    if (z2 || (objExecute instanceof Map)) {
                        if (z2) {
                            collectionKeySet = (List) objExecute;
                            map = null;
                        } else {
                            Map map3 = (Map) objExecute;
                            collectionKeySet = map3.keySet();
                            map = map3;
                        }
                        HashMap map4 = new HashMap();
                        int i3 = 0;
                        for (Object obj2 : collectionKeySet) {
                            if (map == null) {
                                Integer numValueOf = Integer.valueOf(i3);
                                i3++;
                                obj = obj2;
                                obj2 = numValueOf;
                            } else {
                                obj = map.get(obj2);
                            }
                            i3 = i3;
                            if (string != null) {
                                map4.put(string, obj2);
                            }
                            if (string2 != null) {
                                map4.put(string2, obj);
                            } else {
                                cellRenderContext.stack.push(obj);
                            }
                            if (map4.size() > 0) {
                                cellRenderContext.stack.push(map4);
                            }
                            if (token == null || Operators.isTrue(token.execute(cellRenderContext.stack))) {
                                if (iIndexOf < parent.getChildCount()) {
                                    wXComponentCopyComponentTree = parent.getChild(iIndexOf);
                                    if (!isCreateFromNodeStatement(wXComponentCopyComponentTree, wXComponent)) {
                                        wXComponentCopyComponentTree = null;
                                    }
                                    if (wXComponentCopyComponentTree == null || !wXComponentCopyComponentTree.isWaste()) {
                                        z = false;
                                    } else {
                                        z = false;
                                        wXComponentCopyComponentTree.setWaste(false);
                                    }
                                } else {
                                    z = false;
                                    wXComponentCopyComponentTree = null;
                                }
                                if (wXComponentCopyComponentTree == null) {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    wXComponentCopyComponentTree = copyComponentTree(wXComponent, parent);
                                    wXComponentCopyComponentTree.setWaste(z);
                                    if (wXComponentCopyComponentTree.getAttrs().getStatement() != null) {
                                        wXComponentCopyComponentTree.getAttrs().getStatement().remove(str2);
                                        wXComponentCopyComponentTree.getAttrs().getStatement().remove(WXStatement.WX_IF);
                                    }
                                    parent.addChild(wXComponentCopyComponentTree, iIndexOf);
                                    map2 = map;
                                    str = str2;
                                    i2 = iIndexOf;
                                    NativeRenderObjectUtils.nativeAddChildRenderObject(parent.getRenderObjectPtr(), wXComponentCopyComponentTree.getRenderObjectPtr());
                                    list.add(wXComponentCopyComponentTree);
                                    if (WXEnvironment.isApkDebugable()) {
                                        WXLogUtils.d(WXRecyclerTemplateList.TAG, Thread.currentThread().getName() + wXComponentCopyComponentTree.getRef() + wXComponentCopyComponentTree.getComponentType() + "statements copy component tree used " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                    }
                                } else {
                                    map2 = map;
                                    str = str2;
                                    i2 = iIndexOf;
                                }
                                doBindingAttrsEventAndRenderChildNode(wXComponentCopyComponentTree, cellRenderContext, list);
                                iIndexOf = i2 + 1;
                                if (map4.size() > 0) {
                                    cellRenderContext.stack.push(map4);
                                }
                                if (string2 == null) {
                                    cellRenderContext.stack.pop();
                                }
                                map = map2;
                                str2 = str;
                            }
                        }
                    }
                } else {
                    WXLogUtils.e(WXRecyclerTemplateList.TAG, jSONObject.toJSONString() + " not call vfor block, for pre compile");
                }
                while (iIndexOf < parent.getChildCount()) {
                    WXComponent child = parent.getChild(iIndexOf);
                    if (!isCreateFromNodeStatement(child, wXComponent)) {
                        break;
                    }
                    child.setWaste(true);
                    iIndexOf++;
                }
                return iIndexOf - parent.indexOf(wXComponent);
            }
            if (token == null) {
                i = 1;
            } else {
                if (!Operators.isTrue(token.execute(cellRenderContext.stack))) {
                    wXComponent.setWaste(true);
                    return 1;
                }
                i = 1;
                wXComponent.setWaste(false);
            }
        }
        doBindingAttrsEventAndRenderChildNode(wXComponent, cellRenderContext, list);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0036  */
    public static List<Object> getBindingEventArgs(ArrayStack arrayStack, Object obj) {
        ArrayList arrayList = new ArrayList(4);
        if (!(obj instanceof JSONArray)) {
            if (!(obj instanceof JSONObject)) {
                arrayList.add(obj.toString());
                return arrayList;
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.get(ELUtils.BINDING) instanceof Token) {
                arrayList.add(((Token) jSONObject.get(ELUtils.BINDING)).execute(arrayStack));
                return arrayList;
            }
            arrayList.add(obj.toString());
            return arrayList;
        }
        JSONArray jSONArray = (JSONArray) obj;
        for (int i = 0; i < jSONArray.size(); i++) {
            Object obj2 = jSONArray.get(i);
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj2;
                if (jSONObject2.get(ELUtils.BINDING) instanceof Token) {
                    arrayList.add(((Token) jSONObject2.get(ELUtils.BINDING)).execute(arrayStack));
                } else {
                    arrayList.add(obj2);
                }
            } else {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static String getComponentId(WXComponent wXComponent) {
        if ((wXComponent instanceof WXCell) || wXComponent == null) {
            return null;
        }
        WXAttr attrs = wXComponent.getAttrs();
        if (attrs.get(ELUtils.IS_COMPONENT_ROOT) == null || !WXUtils.getBoolean(attrs.get(ELUtils.IS_COMPONENT_ROOT), Boolean.FALSE).booleanValue() || attrs.get(ELUtils.COMPONENT_PROPS) == null || !(attrs.get(ELUtils.COMPONENT_PROPS) instanceof JSONObject)) {
            return getComponentId(wXComponent.getParent());
        }
        Object obj = attrs.get(CellDataManager.VIRTUAL_COMPONENT_ID);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static void initLazyComponent(WXComponent wXComponent, WXVContainer wXVContainer) {
        if (wXComponent.isLazy() || wXComponent.getHostView() == null) {
            wXComponent.lazy(false);
            if (wXVContainer != null) {
                wXVContainer.createChildViewAt(wXVContainer.indexOf(wXComponent));
            } else {
                wXComponent.createView();
            }
            wXComponent.applyLayoutAndEvent(wXComponent);
            wXComponent.bindData(wXComponent);
        }
    }

    private static boolean isCreateFromNodeStatement(WXComponent wXComponent, WXComponent wXComponent2) {
        return wXComponent.getRef() != null && wXComponent.getRef().equals(wXComponent2.getRef());
    }

    private static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void parseStatementsToken(WXComponent wXComponent) {
        if (wXComponent.getBasicComponentData().isRenderPtrEmpty()) {
            wXComponent.getBasicComponentData().setRenderObjectPr(wXComponent.getRenderObjectPtr());
        }
        if (wXComponent.getBasicComponentData() != null) {
            BasicComponentData basicComponentData = wXComponent.getBasicComponentData();
            basicComponentData.getAttrs().parseStatements();
            basicComponentData.getStyles().parseStatements();
            basicComponentData.getEvents().parseStatements();
        }
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            int childCount = wXVContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                parseStatementsToken(wXVContainer.getChild(i));
            }
        }
    }

    public static Map<String, Object> renderBindingAttrs(ArrayMap arrayMap, ArrayStack arrayStack) {
        Set<Map.Entry> setEntrySet = arrayMap.entrySet();
        ThreadLocal<Map<String, Object>> threadLocal = dynamicLocal;
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        if (map.size() > 0) {
            map.clear();
        }
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            String str = (String) entry.getKey();
            if (value instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) value;
                if (jSONObject.get(ELUtils.BINDING) instanceof Token) {
                    map.put(str, ((Token) jSONObject.get(ELUtils.BINDING)).execute(arrayStack));
                }
            }
            if (value instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) value;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < jSONArray.size(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof CharSequence) {
                        sb.append(obj);
                    } else if (obj instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        if (jSONObject2.get(ELUtils.BINDING) instanceof Token) {
                            Object objExecute = ((Token) jSONObject2.get(ELUtils.BINDING)).execute(arrayStack);
                            if (objExecute == null) {
                                objExecute = "";
                            }
                            sb.append(objExecute);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 256 && WXEnvironment.isApkDebugable()) {
                    WXLogUtils.w(WXRecyclerTemplateList.TAG, " warn too big string " + string);
                }
                map.put(str, string);
            }
        }
        return map;
    }

    public static Map<String, Object> renderProps(JSONObject jSONObject, ArrayStack arrayStack) {
        Set<Map.Entry<String, Object>> setEntrySet = jSONObject.entrySet();
        ArrayMap arrayMap = new ArrayMap(4);
        for (Map.Entry<String, Object> entry : setEntrySet) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) value;
                if (jSONObject2.get(ELUtils.BINDING) instanceof Token) {
                    arrayMap.put(key, ((Token) jSONObject2.get(ELUtils.BINDING)).execute(arrayStack));
                }
            }
            arrayMap.put(key, value);
        }
        return arrayMap;
    }

    private static final WXComponent copyComponentTree(WXComponent wXComponent, WXVContainer wXVContainer) {
        BasicComponentData basicComponentDataMo419clone;
        try {
            basicComponentDataMo419clone = wXComponent.getBasicComponentData().mo419clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            basicComponentDataMo419clone = null;
        }
        WXComponent wXComponentNewInstance = WXComponentFactory.newInstance(wXComponent.getInstance(), wXVContainer, basicComponentDataMo419clone);
        GraphicPosition layoutPosition = wXComponent.getLayoutPosition();
        GraphicSize layoutSize = wXComponent.getLayoutSize();
        wXComponentNewInstance.updateDemission(layoutPosition.getTop(), layoutPosition.getBottom(), layoutPosition.getLeft(), layoutPosition.getRight(), layoutSize.getHeight(), layoutSize.getWidth());
        wXComponentNewInstance.updateExtra(wXComponent.getExtra());
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer2 = (WXVContainer) wXComponent;
            WXVContainer wXVContainer3 = (WXVContainer) wXComponentNewInstance;
            int childCount = wXVContainer2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WXComponent child = wXVContainer2.getChild(i);
                if (child != null) {
                    WXComponent wXComponentCopyComponentTree = copyComponentTree(child, wXVContainer3);
                    wXVContainer3.addChild(wXComponentCopyComponentTree);
                    NativeRenderObjectUtils.nativeAddChildRenderObject(wXVContainer3.getRenderObjectPtr(), wXComponentCopyComponentTree.getRenderObjectPtr());
                }
            }
        }
        if (wXComponent.isWaste()) {
            wXComponentNewInstance.setWaste(true);
        }
        return wXComponentNewInstance;
    }
}
