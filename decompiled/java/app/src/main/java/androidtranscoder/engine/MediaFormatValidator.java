package androidtranscoder.engine;

import android.media.MediaFormat;
import androidtranscoder.format.MediaFormatExtraConstants;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class MediaFormatValidator {
    MediaFormatValidator() {
    }

    public static void validateAudioOutputFormat(MediaFormat mediaFormat) {
        String string = mediaFormat.getString("mime");
        if (MediaFormatExtraConstants.MIMETYPE_AUDIO_AAC.equals(string)) {
            return;
        }
        throw new InvalidOutputFormatException("Audio codecs other than AAC is not supported, actual mime type: " + string);
    }

    public static void validateVideoOutputFormat(MediaFormat mediaFormat) {
        String string = mediaFormat.getString("mime");
        if (MediaFormatExtraConstants.MIMETYPE_VIDEO_AVC.equals(string)) {
            return;
        }
        throw new InvalidOutputFormatException("Video codecs other than AVC is not supported, actual mime type: " + string);
    }
}
