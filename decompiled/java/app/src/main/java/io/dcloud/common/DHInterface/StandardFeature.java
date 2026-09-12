package io.dcloud.common.DHInterface;

import io.dcloud.common.util.JSUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class StandardFeature extends BaseFeature implements IReflectAble {
    private HashMap<String, Method> mInnerClassMethod = null;

    private void arrangeInnerMethod() {
        this.mInnerClassMethod = new HashMap<>(1);
        for (Method method : getClass().getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers) && isStandardFeatureMethod(method.getParameterTypes())) {
                this.mInnerClassMethod.put(method.getName(), method);
            }
        }
    }

    private String executeAction(String str, IWebview iWebview, JSONArray jSONArray) {
        Method method = this.mInnerClassMethod.get(str);
        if (method == null) {
            return JSUtil.wrapJsVar("not found the " + str + " function");
        }
        try {
            Object objInvoke = method.invoke(this, iWebview, jSONArray);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException e) {
            String strWrapJsVar = JSUtil.wrapJsVar(e.getMessage());
            e.printStackTrace();
            return strWrapJsVar;
        } catch (IllegalArgumentException e2) {
            String strWrapJsVar2 = JSUtil.wrapJsVar(e2.getMessage());
            e2.printStackTrace();
            return strWrapJsVar2;
        } catch (InvocationTargetException e3) {
            String strWrapJsVar3 = JSUtil.wrapJsVar(e3.getMessage());
            e3.printStackTrace();
            return strWrapJsVar3;
        }
    }

    private boolean isStandardFeatureMethod(Class[] clsArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length == 2 && clsArr[0].equals(IWebview.class) && clsArr[1].equals(JSONArray.class)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature
    public final String execute(IWebview iWebview, String str, JSONArray jSONArray) {
        return executeAction(str, iWebview, jSONArray);
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        super.init(absMgr, str);
        arrangeInnerMethod();
    }
}
