package io.dcloud.common.ui.Info;

import io.dcloud.common.DHInterface.IReflectAble;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AndroidPrivacyResponse implements IReflectAble {
    public String buttonAccept;
    public String buttonRefuse;
    public String message;
    public String prompt;
    public String title;
    public String version;
    public String hrefLoader = "default";
    public boolean backToExit = false;
    public SecondDTO second = new SecondDTO();
    public StylesDTO styles = new StylesDTO();
    public disagreeModeDTO disagreeMode = new disagreeModeDTO();

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class SecondDTO implements IReflectAble {
        public String buttonAccept;
        public String buttonRefuse;
        public String message;
        public String title;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class StylesDTO implements IReflectAble {
        public String backgroundColor;
        public String borderRadius;
        public ButtonAcceptDTO buttonAccept;
        public ButtonRefuseDTO buttonRefuse;
        public ButtonRefuseDTO buttonVisitor;
        public ContentDTO content;
        public TitleDTO title;

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        public static class ButtonAcceptDTO implements IReflectAble {
            public String color;
        }

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        public static class ButtonRefuseDTO implements IReflectAble {
            public String color;
        }

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        public static class ContentDTO implements IReflectAble {
            public String color;
        }

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        public static class TitleDTO implements IReflectAble {
            public String color;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class disagreeModeDTO implements IReflectAble {
        public boolean support = false;
        public boolean loadNativePlugins = true;
        public boolean visitorEntry = false;
        public boolean showAlways = false;
    }
}
