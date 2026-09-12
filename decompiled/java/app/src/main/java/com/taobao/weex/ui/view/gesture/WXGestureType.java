package com.taobao.weex.ui.view.gesture;

import com.taobao.weex.ui.component.list.BasicListComponent;
import io.dcloud.common.constant.AbsoluteConst;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface WXGestureType {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public static class GestureInfo {
        public static final String DIRECTION = "direction";
        public static final String HISTORICAL_XY = "changedTouches";
        public static final String PAGE_X = "pageX";
        public static final String PAGE_Y = "pageY";
        public static final String POINTER_ID = "identifier";
        public static final String SCREEN_X = "screenX";
        public static final String SCREEN_Y = "screenY";
        public static final String STATE = "state";
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public enum HighLevelGesture implements WXGestureType {
        SWIPE("swipe"),
        LONG_PRESS(BasicListComponent.DragTriggerType.LONG_PRESS),
        PAN_START("panstart"),
        PAN_MOVE("panmove"),
        PAN_END("panend"),
        HORIZONTALPAN("horizontalpan"),
        VERTICALPAN("verticalpan");

        private String description;

        HighLevelGesture(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public enum LowLevelGesture implements WXGestureType {
        ACTION_DOWN(AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START),
        ACTION_MOVE("touchmove"),
        ACTION_UP("touchend"),
        ACTION_CANCEL("touchcancel");

        private String description;

        LowLevelGesture(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }
}
