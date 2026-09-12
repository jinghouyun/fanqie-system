package io.dcloud.feature.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.taobao.weex.common.Constants;
import io.dcloud.application.DCLoudApplicationImpl;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IEventCallback;
import io.dcloud.common.DHInterface.ISysEventListener;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.constant.DOMException;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.FileUtil;
import io.dcloud.common.util.JSONUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class AudioPlayer extends AbsAudio implements ISysEventListener, IEventCallback {
    private IApp _app;
    private AudioManager mAudioMgr;
    String mFunId;
    private IWebview mWebview;
    private JSONObject params;
    private int bufferPercent = 0;
    private int startTime = Integer.MIN_VALUE;
    private String mSrcPath = "";
    private float volume = 1.0f;
    private boolean autoplay = false;
    private boolean isCanMix = false;
    private boolean needPause = false;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: io.dcloud.feature.audio.AudioPlayer.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if ((i == -1 || i == -2 || i == -3) && !AudioPlayer.this.needPause) {
                AudioPlayer.this.pause();
            }
        }
    };
    private boolean isPrepared = false;
    private boolean isPlay = false;
    private boolean isCanplay = false;
    private boolean isStoped = false;
    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private Map<String, String> events = new HashMap();

    private AudioPlayer(JSONObject jSONObject, IWebview iWebview) {
        this.params = jSONObject;
        this.mWebview = iWebview;
        addListener();
        this._app = iWebview.obtainFrameView().obtainApp();
        iWebview.obtainFrameView().addFrameViewListener(this);
        this._app.registerSysEventListener(this, ISysEventListener.SysEventType.onStop);
        setStyle(this.params);
    }

    private void addListener() {
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: io.dcloud.feature.audio.AudioPlayer.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                AudioPlayer.this.execEvents("canplay", "");
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: io.dcloud.feature.audio.AudioPlayer.3
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                AudioPlayer.this.execEvents("seeked", "");
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: io.dcloud.feature.audio.AudioPlayer.4
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                AudioPlayer.this.bufferPercent = i;
            }
        });
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: io.dcloud.feature.audio.AudioPlayer.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 701) {
                    AudioPlayer.this.execEvents(IApp.ConfigProperty.CONFIG_WAITING, "");
                    return false;
                }
                if (i != 702 || !mediaPlayer.isPlaying()) {
                    return false;
                }
                AudioPlayer.this.execEvents(Constants.Value.PLAY, "");
                return false;
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: io.dcloud.feature.audio.AudioPlayer.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String string;
                int i3;
                if (i == 1) {
                    string = DOMException.MSG_UNKNOWN_ERROR;
                    i3 = -99;
                } else if (i != 100) {
                    i3 = 0;
                    string = null;
                } else {
                    string = AudioPlayer.this.mWebview.getContext().getString(R.string.dcloud_audio_abnormal_rebuild);
                    i3 = 1303;
                }
                if (i2 == -1010) {
                    string = DOMException.MSG_NOT_SUPPORT;
                    i3 = -3;
                } else if (i2 == -1007) {
                    string = DOMException.MSG_AUDIO_ERROR_MALFORMED;
                    i3 = DOMException.CODE_AUDIO_ERROR_MALFORMED;
                } else if (i2 == -1004) {
                    i3 = -5;
                    string = DOMException.MSG_IO_ERROR;
                } else if (i2 == -110) {
                    string = DOMException.MSG_AUDIO_ERROR_TIMED_OUT;
                    i3 = DOMException.CODE_AUDIO_ERROR_TIMED_OUT;
                }
                if (i3 != 0) {
                    AudioPlayer.this.failCallback(i3, string);
                    AudioPlayer.this.execEvents("error", DOMException.toJSON(i3, string));
                }
                return true;
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: io.dcloud.feature.audio.AudioPlayer.7
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AudioPlayer.this.execEvents("ended", "");
            }
        });
    }

    static AudioPlayer createAudioPlayer(JSONObject jSONObject, IWebview iWebview) {
        return new AudioPlayer(jSONObject, iWebview);
    }

    private void requestAudioFocus() {
        if (this.mAudioMgr == null) {
            this.mAudioMgr = (AudioManager) this.mWebview.getActivity().getSystemService("audio");
        }
        AudioManager audioManager = this.mAudioMgr;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    private void setSpeed() {
        MediaPlayer mediaPlayer;
        JSONObject jSONObject = this.params;
        if (jSONObject == null) {
            return;
        }
        try {
            float f = Float.parseFloat(jSONObject.optString("playbackRate"));
            if (f <= 0.0f || (mediaPlayer = this.mMediaPlayer) == null || Build.VERSION.SDK_INT < 23) {
                return;
            }
            PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f);
            this.mMediaPlayer.setPlaybackParams(playbackParams);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006a  */
    private void setSrc(String str) {
        String strDecode;
        boolean z;
        Uri fileUri;
        try {
            if (str.startsWith("content://")) {
                this.mMediaPlayer.setDataSource(this.mWebview.getActivity(), Uri.parse(str));
            } else {
                if (PdrUtil.isNetPath(str)) {
                    strDecode = URLDecoder.decode(str, "utf-8");
                    z = false;
                } else {
                    strDecode = this._app.convert2AbsFullPath(this.mWebview.obtainFullUrl(), this._app.checkPrivateDirAndCopy2Temp(str));
                    Context context = DCLoudApplicationImpl.self().getContext();
                    if (!FileUtil.needMediaStoreOpenFile(context) || FileUtil.checkPrivatePath(context, strDecode)) {
                        z = false;
                    } else {
                        File file = new File(strDecode);
                        if (!file.exists() || (fileUri = FileUtil.getFileUri(context, file, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)) == null) {
                            z = false;
                        } else {
                            this.mMediaPlayer.setDataSource(this.mWebview.getActivity(), fileUri);
                            z = true;
                        }
                    }
                    if (!z) {
                        if (strDecode.startsWith("/android_asset/")) {
                            strDecode = strDecode.replace("/android_asset/", "");
                        } else if (strDecode.startsWith("android_asset/")) {
                            strDecode = strDecode.replace("android_asset/", "");
                        }
                        if (!PdrUtil.isDeviceRootDir(strDecode)) {
                            AssetFileDescriptor assetFileDescriptorOpenFd = this.mWebview.getActivity().getAssets().openFd(strDecode);
                            this.mMediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                            this.isCanplay = false;
                            this.mMediaPlayer.prepareAsync();
                            return;
                        }
                    }
                }
                if (!z) {
                    this.mMediaPlayer.reset();
                    this.mMediaPlayer.setDataSource(strDecode);
                }
            }
            this.isCanplay = false;
            this.mMediaPlayer.prepareAsync();
        } catch (Exception e) {
            stop();
            failCallback(-5, e.getMessage());
            execEvents("error", DOMException.toJSON(-5, e.getMessage()));
        }
    }

    private void startPlay() {
        requestAudioFocus();
        this.isPrepared = true;
        this.mMediaPlayer.start();
        setSpeed();
        execEvents(Constants.Value.PLAY, "");
        this.isPlay = false;
    }

    private void successCallback() {
        Deprecated_JSUtil.excCallbackSuccess(this.mWebview, this.mFunId, "");
    }

    void addEventListener(String str, String str2) {
        this.events.put(str, str2);
    }

    void destory() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mWebview.obtainFrameView().removeFrameViewListener(this);
            this.mWebview.obtainFrameView().obtainApp().unregisterSysEventListener(this, ISysEventListener.SysEventType.onStop);
            this.mMediaPlayer = null;
            AudioManager audioManager = this.mAudioMgr;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
            }
            this.mAudioMgr = null;
        }
    }

    void execEvents(String str, String str2) {
        String str3 = this.events.get(str);
        if (!PdrUtil.isEmpty(str3)) {
            Deprecated_JSUtil.execCallback(this.mWebview, str3, str2, JSUtil.OK, !PdrUtil.isEmpty(str2), true);
        }
        str.getClass();
        if (str.equals("ended")) {
            pause();
            successCallback();
            return;
        }
        if (str.equals("canplay")) {
            this.isCanplay = true;
            if (this.autoplay) {
                play();
            }
            if (this.isPlay) {
                startPlay();
            }
            int i = this.startTime;
            if (i != Integer.MIN_VALUE) {
                this.mMediaPlayer.seekTo(i);
            }
        }
    }

    void failCallback(int i, String str) {
        Deprecated_JSUtil.excCallbackError(this.mWebview, this.mFunId, DOMException.toJSON(i, str), true);
    }

    String getBuffer() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        return Deprecated_JSUtil.wrapJsVar(PdrUtil.int2DecimalStr(mediaPlayer != null ? (this.bufferPercent * mediaPlayer.getDuration()) / 100 : -1, 1000), false);
    }

    String getDuration() {
        int duration;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && (duration = mediaPlayer.getDuration()) >= 0) {
            return Deprecated_JSUtil.wrapJsVar(PdrUtil.int2DecimalStr(duration, 1000), false);
        }
        return Deprecated_JSUtil.wrapJsVar(Constants.Name.UNDEFINED, false);
    }

    String getPosition() {
        return Deprecated_JSUtil.wrapJsVar(PdrUtil.int2DecimalStr(this.mMediaPlayer.getCurrentPosition(), 1000), false);
    }

    String getStyles(String str) {
        int iOptInt;
        Object objValueOf;
        if (PdrUtil.isEmpty(str)) {
            return JSUtil.wrapJsVar(this.params);
        }
        str.getClass();
        str.hashCode();
        switch (str) {
            case "startTime":
                int i = this.startTime;
                if (i < 0) {
                    iOptInt = this.params.has("startTime") ? this.params.optInt("startTime") : 0;
                } else {
                    iOptInt = i / 1000;
                }
                objValueOf = Integer.valueOf(iOptInt);
                break;
            case "volume":
                objValueOf = Float.valueOf(this.volume);
                break;
            case "src":
                objValueOf = this.mSrcPath;
                break;
            case "loop":
                objValueOf = Boolean.valueOf(this.mMediaPlayer.isLooping());
                break;
            case "playbackRate":
                if (Build.VERSION.SDK_INT < 23) {
                    objValueOf = 1;
                    break;
                } else {
                    objValueOf = Float.valueOf(this.mMediaPlayer.getPlaybackParams().getSpeed());
                    break;
                }
                break;
            case "autoplay":
                objValueOf = Boolean.valueOf(this.params.optBoolean(Constants.Name.AUTOPLAY, false));
                break;
            default:
                return this.params.has(str) ? JSUtil.wrapJsVar(this.params.optString(str)) : Deprecated_JSUtil.wrapJsVar(Constants.Name.UNDEFINED, false);
        }
        return objValueOf != null ? JSUtil.wrapJsVar(objValueOf.toString()) : Deprecated_JSUtil.wrapJsVar(Constants.Name.UNDEFINED, false);
    }

    String getVolume() {
        return JSUtil.wrapJsVar(this.volume);
    }

    public boolean isCanMix() {
        return this.isCanMix;
    }

    String isPause() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        return JSUtil.wrapJsVar(mediaPlayer != null ? true ^ mediaPlayer.isPlaying() : true);
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public Object onCallBack(String str, Object obj) {
        if ((!PdrUtil.isEquals(str, AbsoluteConst.EVENTS_WINDOW_CLOSE) && !PdrUtil.isEquals(str, AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof IWebview)) {
            return null;
        }
        destory();
        return null;
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(ISysEventListener.SysEventType sysEventType, Object obj) {
        if (sysEventType != ISysEventListener.SysEventType.onStop) {
            return false;
        }
        destory();
        return false;
    }

    void pause() {
        this.autoplay = false;
        try {
            this.mMediaPlayer.pause();
        } catch (Exception unused) {
        }
        execEvents("pause", "");
    }

    void play() {
        if (this.isStoped && !this.mMediaPlayer.isPlaying()) {
            try {
                this.mMediaPlayer.prepareAsync();
                this.isStoped = false;
            } catch (Exception unused) {
                this.mSrcPath = "";
                setStyle(this.params);
                this.isStoped = false;
            }
        }
        try {
            this.isPrepared = false;
            this.isPlay = true;
            if (this.isCanplay) {
                startPlay();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            destory();
            failCallback(-1, e.toString());
            execEvents("error", DOMException.toJSON(-1, e.getMessage()));
        } catch (NumberFormatException unused2) {
        }
    }

    public void playbackRate(float f) {
        if (this.params == null) {
            this.params = new JSONObject();
        }
        try {
            this.params.put("playbackRate", f);
        } catch (JSONException unused) {
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        setSpeed();
    }

    void removeEventListener(String str) {
        this.events.remove(str);
    }

    void resume() {
        requestAudioFocus();
        this.mMediaPlayer.start();
        setSpeed();
    }

    void seekTo(int i) {
        this.mMediaPlayer.seekTo(i);
        execEvents("seeking", "");
    }

    public void setCanMix(boolean z) {
        this.needPause = z;
    }

    public void setParams(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    void setSessionCategory(String str) {
        MediaPlayer mediaPlayer;
        if (PdrUtil.isEmpty(str) || (mediaPlayer = this.mMediaPlayer) == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.isCanMix = str.equals("ambient");
    }

    void setStyle(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("src");
        if (!PdrUtil.isEmpty(strOptString) && (PdrUtil.isEmpty(this.mSrcPath) || !strOptString.equals(this.mSrcPath))) {
            this.mMediaPlayer.reset();
            setSrc(strOptString);
        }
        JSONUtil.combinJSONObject(this.params, jSONObject);
        this.mSrcPath = jSONObject.optString("src");
        this.mMediaPlayer.setLooping(this.params.optBoolean("loop"));
        try {
            float f = Float.parseFloat(this.params.optString("volume", "1"));
            this.volume = f;
            if (f < 0.0f) {
                this.volume = 0.0f;
            } else if (f > 1.0f) {
                this.volume = 1.0f;
            }
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            float f2 = this.volume;
            mediaPlayer.setVolume(f2, f2);
            if (this.params.has("startTime")) {
                this.startTime = this.params.optInt("startTime") * 1000;
            }
            this.autoplay = this.params.optBoolean(Constants.Name.AUTOPLAY, false);
        } catch (Exception unused) {
        }
        try {
            float f3 = Float.parseFloat(this.params.optString("playbackRate"));
            if (f3 > 0.0f) {
                playbackRate(f3);
            }
        } catch (Exception unused2) {
        }
    }

    void stop() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.isStoped = true;
            this.isCanplay = false;
            execEvents(Constants.Value.STOP, "");
        }
    }
}
