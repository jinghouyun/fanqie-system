package com.alibaba.fastjson.parser.deserializer;

import androidx.webkit.internal.ApiHelperForO$$ExternalSyntheticApiModelOutline2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import io.dcloud.common.adapter.util.Logger;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes.dex */
public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(defaultPatttern);
    private static final DateTimeFormatter defaultFormatter_23 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final DateTimeFormatter formatter_dt19_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn_1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    private static final DateTimeFormatter formatter_dt19_kr = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_us = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_de = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_in = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_d8 = DateTimeFormatter.ofPattern(Logger.TIMESTAMP_YYYY_MM_DD);
    private static final DateTimeFormatter formatter_d10_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter formatter_d10_cn = DateTimeFormatter.ofPattern("yyyy年M月d日");
    private static final DateTimeFormatter formatter_d10_kr = DateTimeFormatter.ofPattern("yyyy년M월d일");
    private static final DateTimeFormatter formatter_d10_us = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter formatter_d10_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter formatter_d10_de = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter formatter_d10_in = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter ISO_FIXED_FORMAT = DateTimeFormatter.ofPattern(defaultPatttern).withZone(ZoneId.systemDefault());
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final DateTimeFormatter formatter_iso8601 = DateTimeFormatter.ofPattern(formatter_iso8601_pattern);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        Long l;
        DateTimeFormatter dateTimeFormatterOfPattern;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() == 4) {
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str == null) {
                dateTimeFormatterOfPattern = null;
            } else if (defaultPatttern.equals(str)) {
                dateTimeFormatterOfPattern = defaultFormatter;
            } else {
                dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(str);
            }
            if ("".equals(strStringVal)) {
                return null;
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$9()) {
                if (strStringVal.length() == 10 || strStringVal.length() == 8) {
                    return (T) LocalDateTime.of(parseLocalDate(strStringVal, str, dateTimeFormatterOfPattern), LocalTime.MIN);
                }
                return (T) parseDateTime(strStringVal, dateTimeFormatterOfPattern);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$8()) {
                if (strStringVal.length() == 23) {
                    LocalDateTime localDateTime = LocalDateTime.parse(strStringVal);
                    return (T) LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
                }
                return (T) parseLocalDate(strStringVal, str, dateTimeFormatterOfPattern);
            }
            int i2 = 0;
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m159m()) {
                if (strStringVal.length() == 23) {
                    LocalDateTime localDateTime2 = LocalDateTime.parse(strStringVal);
                    return (T) LocalTime.of(localDateTime2.getHour(), localDateTime2.getMinute(), localDateTime2.getSecond(), localDateTime2.getNano());
                }
                while (i2 < strStringVal.length()) {
                    char cCharAt = strStringVal.charAt(i2);
                    if (cCharAt < '0' || cCharAt > '9') {
                        return (T) LocalTime.parse(strStringVal);
                    }
                    i2++;
                }
                if (strStringVal.length() > 8 && strStringVal.length() < 19) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(strStringVal)), JSON.defaultTimeZone.toZoneId()).toLocalTime();
                }
                return (T) LocalTime.parse(strStringVal);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$1()) {
                if (dateTimeFormatterOfPattern == defaultFormatter) {
                    dateTimeFormatterOfPattern = ISO_FIXED_FORMAT;
                }
                if (dateTimeFormatterOfPattern == null && strStringVal.length() <= 19) {
                    JSONScanner jSONScanner = new JSONScanner(strStringVal);
                    TimeZone timeZone = defaultJSONParser.lexer.getTimeZone();
                    jSONScanner.setTimeZone(timeZone);
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        return (T) ZonedDateTime.ofInstant(jSONScanner.getCalendar().getTime().toInstant(), timeZone.toZoneId());
                    }
                }
                return (T) parseZonedDateTime(strStringVal, dateTimeFormatterOfPattern);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$2()) {
                return (T) OffsetDateTime.parse(strStringVal);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$3()) {
                return (T) OffsetTime.parse(strStringVal);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$4()) {
                return (T) ZoneId.of(strStringVal);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$5()) {
                return (T) Period.parse(strStringVal);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$6()) {
                return (T) Duration.parse(strStringVal);
            }
            if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$7()) {
                while (i2 < strStringVal.length()) {
                    char cCharAt2 = strStringVal.charAt(i2);
                    if (cCharAt2 < '0' || cCharAt2 > '9') {
                        return (T) Instant.parse(strStringVal);
                    }
                    i2++;
                }
                if (strStringVal.length() > 8 && strStringVal.length() < 19) {
                    return (T) Instant.ofEpochMilli(Long.parseLong(strStringVal));
                }
                return (T) Instant.parse(strStringVal);
            }
        } else {
            if (jSONLexer.token() == 2) {
                long jLongValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                if ("unixtime".equals(str)) {
                    jLongValue *= 1000;
                } else if ("yyyyMMddHHmmss".equals(str)) {
                    int i3 = (int) (jLongValue / 10000000000L);
                    int i4 = (int) ((jLongValue / 100000000) % 100);
                    int i5 = (int) ((jLongValue / 1000000) % 100);
                    int i6 = (int) ((jLongValue / 10000) % 100);
                    int i7 = (int) ((jLongValue / 100) % 100);
                    int i8 = (int) (jLongValue % 100);
                    if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$9()) {
                        return (T) LocalDateTime.of(i3, i4, i5, i6, i7, i8);
                    }
                }
                if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$9()) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jLongValue), JSON.defaultTimeZone.toZoneId());
                }
                if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$8()) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jLongValue), JSON.defaultTimeZone.toZoneId()).toLocalDate();
                }
                if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m159m()) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jLongValue), JSON.defaultTimeZone.toZoneId()).toLocalTime();
                }
                if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$1()) {
                    return (T) ZonedDateTime.ofInstant(Instant.ofEpochMilli(jLongValue), JSON.defaultTimeZone.toZoneId());
                }
                if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$7()) {
                    return (T) Instant.ofEpochMilli(jLongValue);
                }
                throw new UnsupportedOperationException();
            }
            if (jSONLexer.token() == 12) {
                JSONObject object = defaultJSONParser.parseObject();
                if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$7()) {
                    Object obj2 = object.get("epochSecond");
                    Object obj3 = object.get("nano");
                    boolean z = obj2 instanceof Number;
                    if (z && (obj3 instanceof Number)) {
                        return (T) Instant.ofEpochSecond(TypeUtils.longExtractValue((Number) obj2), TypeUtils.longExtractValue((Number) obj3));
                    }
                    if (z) {
                        return (T) Instant.ofEpochSecond(TypeUtils.longExtractValue((Number) obj2));
                    }
                } else if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$6() && (l = object.getLong("seconds")) != null) {
                    return (T) Duration.ofSeconds(l.longValue(), object.getLongValue("nano"));
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ec  */
    protected LocalDateTime parseDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 != ':' || cCharAt5 != ':') {
                    dateTimeFormatter2 = dateTimeFormatter;
                } else if (cCharAt == '-' && cCharAt2 == '-') {
                    if (cCharAt3 == 'T') {
                        dateTimeFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = defaultFormatter;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = formatter_dt19_tw;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = formatter_dt19_eur;
                        } else if (i > 12) {
                            dateTimeFormatter2 = formatter_dt19_us;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = formatter_dt19_us;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = formatter_dt19_eur;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = formatter_dt19_de;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = formatter_dt19_in;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                }
            } else if (str.length() == 23) {
                char cCharAt11 = str.charAt(4);
                char cCharAt12 = str.charAt(7);
                char cCharAt13 = str.charAt(10);
                char cCharAt14 = str.charAt(13);
                char cCharAt15 = str.charAt(16);
                char cCharAt16 = str.charAt(19);
                if (cCharAt14 == ':' && cCharAt15 == ':' && cCharAt11 == '-' && cCharAt12 == '-' && cCharAt13 == ' ' && cCharAt16 == '.') {
                    dateTimeFormatter2 = defaultFormatter_23;
                } else {
                    dateTimeFormatter2 = dateTimeFormatter;
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt17 = str.charAt(4);
                if (cCharAt17 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter2 = formatter_dt19_cn_1;
                    } else {
                        dateTimeFormatter2 = formatter_dt19_cn;
                    }
                } else if (cCharAt17 == 45380) {
                    dateTimeFormatter2 = formatter_dt19_kr;
                }
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        if (dateTimeFormatter2 == null) {
            JSONScanner jSONScanner = new JSONScanner(str);
            if (jSONScanner.scanISO8601DateIfMatch(false)) {
                return LocalDateTime.ofInstant(jSONScanner.getCalendar().toInstant(), ZoneId.systemDefault());
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt18 = str.charAt(i2);
                if (cCharAt18 >= '0' && cCharAt18 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), JSON.defaultTimeZone.toZoneId());
            }
        }
        if (dateTimeFormatter2 == null) {
            return LocalDateTime.parse(str);
        }
        return LocalDateTime.parse(str, dateTimeFormatter2);
    }

    protected LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = formatter_d10_eur;
                    } else if (i > 12) {
                        dateTimeFormatter3 = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = formatter_d10_eur;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = formatter_d10_de;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = formatter_d10_in;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = formatter_d10_cn;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = formatter_d10_kr;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt9 = str.charAt(i2);
                if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), JSON.defaultTimeZone.toZoneId()).toLocalDate();
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, dateTimeFormatter);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00bb  */
    protected ZonedDateTime parseZonedDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 != ':' || cCharAt5 != ':') {
                    dateTimeFormatter2 = dateTimeFormatter;
                } else if (cCharAt == '-' && cCharAt2 == '-') {
                    if (cCharAt3 == 'T') {
                        dateTimeFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = defaultFormatter;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = formatter_dt19_tw;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = formatter_dt19_eur;
                        } else if (i > 12) {
                            dateTimeFormatter2 = formatter_dt19_us;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = formatter_dt19_us;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = formatter_dt19_eur;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = formatter_dt19_de;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = formatter_dt19_in;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter2 = formatter_dt19_cn_1;
                    } else {
                        dateTimeFormatter2 = formatter_dt19_cn;
                    }
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter2 = formatter_dt19_kr;
                }
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt12 = str.charAt(i2);
                if (cCharAt12 >= '0' && cCharAt12 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), JSON.defaultTimeZone.toZoneId());
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        if (dateTimeFormatter2 == null) {
            return ZonedDateTime.parse(str);
        }
        return ZonedDateTime.parse(str, dateTimeFormatter2);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$9()) {
            int mask = SerializerFeature.UseISO8601DateFormat.getMask();
            LocalDateTime localDateTimeM168m = ApiHelperForO$$ExternalSyntheticApiModelOutline2.m168m(obj);
            String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                int i2 = mask & i;
                dateFormatPattern = formatter_iso8601_pattern;
                if (i2 == 0 && !jSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
                    if (jSONSerializer.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
                        dateFormatPattern = (jSONSerializer.getFastJsonConfigDateFormatPattern() == null || jSONSerializer.getFastJsonConfigDateFormatPattern().length() <= 0) ? JSON.DEFFAULT_DATE_FORMAT : jSONSerializer.getFastJsonConfigDateFormatPattern();
                    } else {
                        int nano = localDateTimeM168m.getNano();
                        if (nano != 0) {
                            dateFormatPattern = nano % DurationKt.NANOS_IN_MILLIS == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                        }
                    }
                }
            }
            if (dateFormatPattern != null) {
                write(serializeWriter, localDateTimeM168m, dateFormatPattern);
                return;
            } else {
                serializeWriter.writeLong(localDateTimeM168m.atZone(JSON.defaultTimeZone.toZoneId()).toInstant().toEpochMilli());
                return;
            }
        }
        serializeWriter.writeString(obj.toString());
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, ApiHelperForO$$ExternalSyntheticApiModelOutline2.m182m(obj), beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter dateTimeFormatterOfPattern;
        Instant instant;
        if ("unixtime".equals(str)) {
            if (ApiHelperForO$$ExternalSyntheticApiModelOutline2.m186m((Object) temporalAccessor)) {
                serializeWriter.writeInt((int) ApiHelperForO$$ExternalSyntheticApiModelOutline2.m179m((Object) temporalAccessor).toEpochSecond());
                return;
            } else if (ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$1(temporalAccessor)) {
                serializeWriter.writeInt((int) ApiHelperForO$$ExternalSyntheticApiModelOutline2.m168m((Object) temporalAccessor).atZone(JSON.defaultTimeZone.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (ApiHelperForO$$ExternalSyntheticApiModelOutline2.m186m((Object) temporalAccessor)) {
                instant = ApiHelperForO$$ExternalSyntheticApiModelOutline2.m179m((Object) temporalAccessor).toInstant();
            } else {
                instant = ApiHelperForO$$ExternalSyntheticApiModelOutline2.m$1(temporalAccessor) ? ApiHelperForO$$ExternalSyntheticApiModelOutline2.m168m((Object) temporalAccessor).atZone(JSON.defaultTimeZone.toZoneId()).toInstant() : null;
            }
            if (instant != null) {
                serializeWriter.writeLong(instant.toEpochMilli());
                return;
            }
        }
        if (str == formatter_iso8601_pattern) {
            dateTimeFormatterOfPattern = formatter_iso8601;
        } else {
            dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(str);
        }
        serializeWriter.writeString(dateTimeFormatterOfPattern.format(temporalAccessor));
    }

    public static Object castToLocalDateTime(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = defaultPatttern;
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }
}
