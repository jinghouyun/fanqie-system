package androidtranscoder.format;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class MediaFormatStrategyPresets {
    public static final int AUDIO_BITRATE_AS_IS = -1;
    public static final int AUDIO_CHANNELS_AS_IS = -1;

    @Deprecated
    public static final MediaFormatStrategy EXPORT_PRESET_960x540 = new ExportPreset960x540Strategy();

    private MediaFormatStrategyPresets() {
    }

    public static MediaFormatStrategy createAndroid720pStrategy(int i, double d) {
        return new Android720pFormatStrategy(i, d);
    }

    public static MediaFormatStrategy createExportPreset960x540Strategy() {
        return new ExportPreset960x540Strategy();
    }
}
