package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface ISysEventListener {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public enum SysEventType {
        AllSystemEvent,
        onActivityResult,
        onCreateOptionMenu,
        onKeyDown,
        onKeyUp,
        onSaveInstanceState,
        onKeyLongPress,
        onStart,
        onResume,
        onWebAppStop,
        onWebAppReStart,
        onWebAppSaveState,
        onWebAppTrimMemory,
        onWebAppBackground,
        onWebAppPause,
        onWebAppForeground,
        onWebAppSrcUpZip,
        onStop,
        onPause,
        onDeviceNetChanged,
        onSimStateChanged,
        onNewIntent,
        onConfigurationChanged,
        onKeyboardShow,
        onKeyboardHide,
        onRequestPermissionsResult,
        onSplashclosed,
        onSizeChanged
    }

    boolean onExecute(SysEventType sysEventType, Object obj);
}
