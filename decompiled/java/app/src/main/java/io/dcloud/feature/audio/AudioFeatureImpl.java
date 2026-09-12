package io.dcloud.feature.audio;

import android.media.AudioManager;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MessageHandler;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.feature.audio.recorder.RecordOption;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class AudioFeatureImpl implements IFeature, MessageHandler.IMessages {
    static final String TAG = "AudioFeatureImpl";
    HashMap<String, ArrayList> mAppsAudioObj = null;

    private Object findAppObj(String str, String str2) {
        ArrayList appObjList = getAppObjList(str);
        if (appObjList.isEmpty()) {
            return null;
        }
        int size = appObjList.size();
        int i = 0;
        while (i < size) {
            Object obj = appObjList.get(i);
            i++;
            if ((obj instanceof AbsAudio) && ((AbsAudio) obj).mUuid.equals(str2)) {
                return obj;
            }
        }
        return null;
    }

    private ArrayList getAppObjList(String str) {
        ArrayList arrayList = this.mAppsAudioObj.get(str);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(2);
        this.mAppsAudioObj.put(str, arrayList2);
        return arrayList2;
    }

    private void putAppObjList(String str, Object obj) {
        getAppObjList(str).add(obj);
    }

    private void removeAppObjFromList(String str, Object obj) {
        ArrayList appObjList = getAppObjList(str);
        if (appObjList != null) {
            appObjList.remove(obj);
        }
    }

    private void setCanPlay(String str, String str2, boolean z) {
        ArrayList appObjList = getAppObjList(str);
        int size = appObjList.size();
        int i = 0;
        while (i < size) {
            Object obj = appObjList.get(i);
            i++;
            if (obj instanceof AudioPlayer) {
                AudioPlayer audioPlayer = (AudioPlayer) obj;
                if (!audioPlayer.mUuid.equals(str2) && !z) {
                    audioPlayer.pause();
                }
                audioPlayer.setCanMix(z);
            }
        }
    }

    private void setSpeakerphoneOn(AudioManager audioManager, boolean z) {
        if (z) {
            audioManager.setSpeakerphoneOn(true);
            audioManager.setMode(1);
        } else {
            audioManager.setSpeakerphoneOn(false);
            audioManager.setRouting(0, 1, -1);
            audioManager.setMode(3);
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0044  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        String strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
        Logger.d(TAG, "execute pJsArgs[0]=" + strArr[0]);
        if (!"AudioSyncExecMethod".equals(str)) {
            MessageHandler.sendMessage(this, new Object[]{iWebview, str, strArr});
            return null;
        }
        String str2 = strArr[0];
        JSONArray jSONArrayCreateJSONArray = JSONUtil.createJSONArray(strArr[1]);
        str2.getClass();
        str2.hashCode();
        switch (str2) {
            case "getPosition":
                return String.valueOf(((AudioPlayer) findAppObj(strObtainAppId, JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getPosition());
            case "getDuration":
                return String.valueOf(((AudioPlayer) findAppObj(strObtainAppId, JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getDuration());
            case "getBuffered":
                return ((AudioPlayer) findAppObj(strObtainAppId, JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getBuffer();
            case "getPaused":
                return ((AudioPlayer) findAppObj(strObtainAppId, JSONUtil.getString(jSONArrayCreateJSONArray, 0))).isPause();
            case "getStyles":
                return ((AudioPlayer) findAppObj(strObtainAppId, JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getStyles(jSONArrayCreateJSONArray.length() > 1 ? JSONUtil.getString(jSONArrayCreateJSONArray, 1) : null);
            case "CreatePlayer":
                String string = JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                AudioPlayer audioPlayerCreateAudioPlayer = AudioPlayer.createAudioPlayer(JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1), iWebview);
                audioPlayerCreateAudioPlayer.mUuid = string;
                putAppObjList(iWebview.obtainFrameView().obtainApp().obtainAppId(), audioPlayerCreateAudioPlayer);
                return null;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
        this.mAppsAudioObj = new HashMap<>(2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
    public void execute(Object obj) {
        Object[] objArr = (Object[]) obj;
        IWebview iWebview = (IWebview) objArr[0];
        String strValueOf = String.valueOf(objArr[1]);
        String[] strArr = (String[]) objArr[2];
        IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        String strObtainAppId = iAppObtainApp.obtainAppId();
        String str = strArr[0];
        JSONArray jSONArrayCreateJSONArray = JSONUtil.createJSONArray(strArr[1]);
        String string = JSONUtil.getString(jSONArrayCreateJSONArray, 0);
        if ("RecorderExecMethod".equals(strValueOf)) {
            AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Audio-" + strValueOf);
            try {
                if ("record".equals(str)) {
                    String string2 = JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                    RecordOption recordOption = new RecordOption(iWebview, JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 2));
                    if (JSUtil.checkOperateDirErrorAndCallback(iWebview, string2, recordOption.mFileName)) {
                        return;
                    }
                    AudioRecorderMgr audioRecorderMgrStartRecorder = AudioRecorderMgr.startRecorder(recordOption, string2);
                    audioRecorderMgrStartRecorder.mUuid = string;
                    putAppObjList(strObtainAppId, audioRecorderMgrStartRecorder);
                    return;
                }
                if ("pause".equals(str)) {
                    ((AudioRecorderMgr) findAppObj(strObtainAppId, string)).pause();
                    return;
                }
                if (Constants.Value.STOP.equals(str)) {
                    AudioRecorderMgr audioRecorderMgr = (AudioRecorderMgr) findAppObj(strObtainAppId, string);
                    audioRecorderMgr.stop();
                    audioRecorderMgr.successCallback();
                    removeAppObjFromList(strObtainAppId, audioRecorderMgr);
                    return;
                }
                if (AbsoluteConst.EVENTS_RESUME.equals(str)) {
                    ((AudioRecorderMgr) findAppObj(strObtainAppId, string)).resume();
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.e("RecorderExecMethod _methodName=" + str + "; e =" + e);
                return;
            }
        }
        if (!"AudioExecMethod".equals(strValueOf)) {
            return;
        }
        AudioPlayer audioPlayer = null;
        try {
            AudioPlayer audioPlayer2 = (AudioPlayer) findAppObj(strObtainAppId, string);
            try {
                try {
                    switch (str.hashCode()) {
                        case -934426579:
                            if (str.equals(AbsoluteConst.EVENTS_RESUME)) {
                                setCanPlay(strObtainAppId, string, audioPlayer2.isCanMix());
                                if (BaseInfo.isUniAppAppid(iAppObtainApp)) {
                                    audioPlayer2.mFunId = "";
                                    audioPlayer2.play();
                                    return;
                                } else {
                                    audioPlayer2.resume();
                                    return;
                                }
                            }
                            return;
                        case -906224877:
                            if (str.equals("seekTo")) {
                                try {
                                    int i = Integer.parseInt(JSONUtil.getString(jSONArrayCreateJSONArray, 1));
                                    if (i >= 0) {
                                        audioPlayer2.seekTo(i * 1000);
                                        return;
                                    }
                                    return;
                                } catch (Exception unused) {
                                    int i2 = (int) (Double.parseDouble(JSONUtil.getString(jSONArrayCreateJSONArray, 1)) * 1000.0d);
                                    if (i2 >= 0) {
                                        audioPlayer2.seekTo(i2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        case -625809843:
                            if (str.equals("addEventListener")) {
                                audioPlayer2.addEventListener(jSONArrayCreateJSONArray.optString(1), jSONArrayCreateJSONArray.optString(2));
                                return;
                            }
                            return;
                        case -541487286:
                            if (str.equals("removeEventListener")) {
                                audioPlayer2.removeEventListener(jSONArrayCreateJSONArray.optString(1));
                                return;
                            }
                            return;
                        case -388163342:
                            if (str.equals("setSessionCategory")) {
                                audioPlayer2.setSessionCategory(jSONArrayCreateJSONArray.length() > 1 ? JSONUtil.getString(jSONArrayCreateJSONArray, 1) : null);
                                return;
                            }
                            return;
                        case 3443508:
                            if (str.equals(Constants.Value.PLAY)) {
                                setCanPlay(strObtainAppId, string, audioPlayer2.isCanMix());
                                audioPlayer2.mFunId = JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                                audioPlayer2.play();
                                return;
                            }
                            return;
                        case 3540994:
                            if (str.equals(Constants.Value.STOP)) {
                                audioPlayer2.stop();
                                return;
                            }
                            return;
                        case 94756344:
                            if (str.equals(AbsoluteConst.EVENTS_CLOSE)) {
                                audioPlayer2.destory();
                                removeAppObjFromList(strObtainAppId, audioPlayer2);
                                return;
                            }
                            return;
                        case 106440182:
                            if (str.equals("pause")) {
                                audioPlayer2.pause();
                                return;
                            }
                            return;
                        case 589623268:
                            if (str.equals("setStyles")) {
                                audioPlayer2.setStyle(jSONArrayCreateJSONArray.optJSONObject(1));
                                return;
                            }
                            return;
                        case 1355420059:
                            if (!str.equals("playbackRate") || jSONArrayCreateJSONArray.length() <= 1) {
                                return;
                            }
                            String string3 = JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                            if (TextUtils.isEmpty(string3)) {
                                return;
                            }
                            float f = Float.parseFloat(string3);
                            if (f > 0.0f) {
                                audioPlayer2.playbackRate(f);
                                return;
                            }
                            return;
                        case 1403417351:
                            if (str.equals("setRoute")) {
                                AudioManager audioManager = (AudioManager) iWebview.getContext().getSystemService("audio");
                                if (Integer.parseInt(jSONArrayCreateJSONArray.optString(1)) == 1) {
                                    setSpeakerphoneOn(audioManager, false);
                                    return;
                                } else {
                                    setSpeakerphoneOn(audioManager, true);
                                    return;
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception e2) {
                e = e2;
                audioPlayer = audioPlayer2;
                e.printStackTrace();
                if (audioPlayer != null) {
                    String str2 = DOMException.MSG_PARAMETER_ERROR;
                    audioPlayer.failCallback(-1, str2);
                    audioPlayer.execEvents("onError", DOMException.toJSON(-1, str2));
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
