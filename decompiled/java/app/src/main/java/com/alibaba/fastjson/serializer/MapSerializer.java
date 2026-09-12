package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014e A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0152 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x015a A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0179 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0182  */
    /* JADX WARN: Code duplicated, block: B:11:0x0021 A[PHI: r0
  0x0021: PHI (r0v51 java.util.Map<java.lang.String, java.lang.Object>) = 
  (r0v2 java.util.Map<java.lang.String, java.lang.Object>)
  (r0v2 java.util.Map<java.lang.String, java.lang.Object>)
  (r0v2 java.util.Map<java.lang.String, java.lang.Object>)
  (r0v1 java.util.Map<java.lang.String, java.lang.Object>)
 binds: [B:16:0x002f, B:18:0x0033, B:21:0x003c, B:9:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:120:0x0188 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0190 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x01ac A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x01b6 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x01be A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x01da A[Catch: all -> 0x02f4, TRY_LEAVE, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e7 A[Catch: all -> 0x02d2, TryCatch #0 {all -> 0x02d2, blocks: (B:147:0x01e2, B:150:0x01e7, B:152:0x01eb, B:155:0x01f0, B:194:0x0297, B:196:0x029b, B:203:0x02af, B:158:0x0209), top: B:224:0x01e2 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x01eb A[Catch: all -> 0x02d2, TryCatch #0 {all -> 0x02d2, blocks: (B:147:0x01e2, B:150:0x01e7, B:152:0x01eb, B:155:0x01f0, B:194:0x0297, B:196:0x029b, B:203:0x02af, B:158:0x0209), top: B:224:0x01e2 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0202  */
    /* JADX WARN: Code duplicated, block: B:158:0x0209 A[Catch: all -> 0x02d2, TRY_LEAVE, TryCatch #0 {all -> 0x02d2, blocks: (B:147:0x01e2, B:150:0x01e7, B:152:0x01eb, B:155:0x01f0, B:194:0x0297, B:196:0x029b, B:203:0x02af, B:158:0x0209), top: B:224:0x01e2 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x021e A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0236 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x023b A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0246 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x024d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x024f A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x025a A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0262 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0278 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0282 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0288 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x0297 A[Catch: all -> 0x02d2, TRY_ENTER, TryCatch #0 {all -> 0x02d2, blocks: (B:147:0x01e2, B:150:0x01e7, B:152:0x01eb, B:155:0x01f0, B:194:0x0297, B:196:0x029b, B:203:0x02af, B:158:0x0209), top: B:224:0x01e2 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:205:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:224:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6 A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00ea A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x011a A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x011e A[Catch: all -> 0x02f4, TryCatch #2 {all -> 0x02f4, blocks: (B:29:0x0054, B:30:0x0057, B:32:0x0063, B:41:0x007e, B:43:0x008f, B:44:0x009a, B:46:0x00a0, B:48:0x00b2, B:51:0x00ba, B:54:0x00bf, B:56:0x00c9, B:58:0x00cd, B:61:0x00d8, B:64:0x00e6, B:66:0x00ea, B:69:0x00f2, B:72:0x00f7, B:74:0x0101, B:76:0x0105, B:79:0x0110, B:82:0x011a, B:84:0x011e, B:87:0x0126, B:90:0x012b, B:92:0x0135, B:94:0x0139, B:97:0x0144, B:100:0x014e, B:102:0x0152, B:105:0x015a, B:108:0x015f, B:110:0x0169, B:112:0x016d, B:115:0x0179, B:118:0x0184, B:120:0x0188, B:123:0x0190, B:126:0x0195, B:128:0x019f, B:130:0x01a3, B:131:0x01ac, B:132:0x01b2, B:134:0x01b6, B:137:0x01be, B:140:0x01c3, B:142:0x01cd, B:144:0x01d1, B:145:0x01da, B:162:0x021e, B:166:0x0230, B:168:0x0236, B:170:0x023b, B:171:0x023e, B:173:0x0246, B:174:0x0249, B:187:0x0278, B:189:0x0282, B:191:0x0288, B:192:0x028d, B:198:0x029f, B:200:0x02aa, B:176:0x024f, B:177:0x0252, B:179:0x025a, B:184:0x026e, B:185:0x0271, B:181:0x0262, B:183:0x0266, B:160:0x0217, B:38:0x0077), top: B:228:0x0054 }] */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws Throwable {
        Map<String, Object> treeMap;
        boolean z2;
        List<PropertyPreFilter> list;
        List<PropertyFilter> list2;
        List<PropertyFilter> list3;
        List<NameFilter> list4;
        List<NameFilter> list5;
        Class<?> cls;
        String str;
        int i2;
        Class<?> cls2;
        ObjectSerializer objectSerializer;
        ObjectSerializer objectSerializer2;
        Type type2;
        this = this;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        obj = obj;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> innerMap = (Map) obj;
        int i3 = SerializerFeature.MapSortField.mask;
        if ((serializeWriter.features & i3) == 0 && (i & i3) == 0) {
            treeMap = innerMap;
        } else {
            if (innerMap instanceof JSONObject) {
                innerMap = ((JSONObject) innerMap).getInnerMap();
            }
            if ((innerMap instanceof SortedMap) || (innerMap instanceof LinkedHashMap)) {
                treeMap = innerMap;
            } else {
                try {
                    treeMap = new TreeMap(innerMap);
                } catch (Exception unused) {
                    treeMap = innerMap;
                }
            }
        }
        if (jSONSerializer.containsReference(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        SerialContext serialContext = jSONSerializer2.context;
        jSONSerializer2.setContext(serialContext, obj, obj2, 0);
        if (!z) {
            try {
                serializeWriter.write(123);
            } catch (Throwable th) {
                th = th;
                jSONSerializer2.context = serialContext;
                throw th;
            }
        }
        jSONSerializer2.incrementIndent();
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            String str2 = jSONSerializer2.config.typeKey;
            Class<?> cls3 = treeMap.getClass();
            if ((cls3 == JSONObject.class || cls3 == HashMap.class || cls3 == LinkedHashMap.class) && treeMap.containsKey(str2)) {
                z2 = true;
            } else {
                serializeWriter.writeFieldName(str2);
                serializeWriter.writeString(obj.getClass().getName());
                z2 = false;
            }
        } else {
            z2 = true;
        }
        Class<?> cls4 = null;
        ObjectSerializer objectWriter = null;
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            List<PropertyPreFilter> list6 = jSONSerializer2.propertyPreFilters;
            if (list6 != null && list6.size() > 0) {
                if (key == null || (key instanceof String)) {
                    if (this.applyName(jSONSerializer2, obj, key)) {
                        list = this.propertyPreFilters;
                        if (list == null) {
                            list2 = jSONSerializer2.propertyFilters;
                            if (list2 == null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str3 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str3, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str4 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str4, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            }
                        } else {
                            list2 = jSONSerializer2.propertyFilters;
                            if (list2 == null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str5 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str5, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str6 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str6, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            }
                        }
                    }
                } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || this.applyName(jSONSerializer2, obj, JSON.toJSONString(key))) {
                    list = this.propertyPreFilters;
                    if (list == null) {
                        list2 = jSONSerializer2.propertyFilters;
                        if (list2 == null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str7 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str7, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str8 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str8, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        }
                    } else {
                        list2 = jSONSerializer2.propertyFilters;
                        if (list2 == null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str9 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str9, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str10 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str10, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        }
                    }
                }
                cls = cls4;
                this = this;
                obj = obj;
                cls4 = cls;
            } else {
                list = this.propertyPreFilters;
                if (list == null && list.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        if (this.applyName(jSONSerializer2, obj, key)) {
                            list2 = jSONSerializer2.propertyFilters;
                            if (list2 == null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str11 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str11, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str12 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str12, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            }
                        }
                    } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || this.applyName(jSONSerializer2, obj, JSON.toJSONString(key))) {
                        list2 = jSONSerializer2.propertyFilters;
                        if (list2 == null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str13 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str13, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str14 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str14, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        }
                    }
                    cls = cls4;
                    this = this;
                    obj = obj;
                    cls4 = cls;
                } else {
                    list2 = jSONSerializer2.propertyFilters;
                    if (list2 == null && list2.size() > 0) {
                        if (key == null || (key instanceof String)) {
                            if (this.apply(jSONSerializer2, obj, key, value)) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!this.apply(jSONSerializer2, obj, key, value)) {
                                        }
                                    } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer2.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    } else {
                                        key = this.processKey(jSONSerializer2, obj, key, value);
                                    }
                                }
                                if (key != null) {
                                    if (key instanceof String) {
                                        cls = cls4;
                                        str = key;
                                        jSONSerializer2 = jSONSerializer;
                                        value = processValue(jSONSerializer2, null, obj, str, value, i);
                                        i2 = i;
                                    } else {
                                        if (key instanceof Map) {
                                            cls = cls4;
                                            str = key;
                                        } else {
                                            cls = cls4;
                                            str = key;
                                        }
                                        jSONSerializer2 = jSONSerializer;
                                        i2 = i;
                                    }
                                } else {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                }
                                if (value == null) {
                                }
                                if (str instanceof String) {
                                    String str15 = str;
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer2.println();
                                    }
                                    serializeWriter.writeFieldName(str15, true);
                                } else {
                                    if (!z2) {
                                        serializeWriter.write(44);
                                    }
                                    if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    } else {
                                        jSONSerializer2.write(JSON.toJSONString(str));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (value == null) {
                                    serializeWriter.writeNull();
                                } else {
                                    cls2 = value.getClass();
                                    if (cls2 != cls) {
                                        objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                        cls = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } else {
                                        objectSerializer2 = objectSerializer;
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    }
                                    objectWriter = objectSerializer2;
                                }
                                cls4 = cls;
                                z2 = false;
                            }
                        } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || this.apply(jSONSerializer2, obj, JSON.toJSONString(key), value)) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    }
                                } else if (!this.apply(jSONSerializer2, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer2.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                } else {
                                    key = this.processKey(jSONSerializer2, obj, key, value);
                                }
                            }
                            if (key != null) {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if (key instanceof Map) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        cls = cls4;
                                        str = key;
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } else {
                                cls = cls4;
                                str = key;
                                jSONSerializer2 = jSONSerializer;
                                value = processValue(jSONSerializer2, null, obj, str, value, i);
                                i2 = i;
                            }
                            if (value == null) {
                            }
                            if (str instanceof String) {
                                String str16 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str16, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName)) {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    objectSerializer2.write(jSONSerializer, value, str, null, i);
                                    jSONSerializer2 = jSONSerializer;
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        }
                        cls = cls4;
                        this = this;
                        obj = obj;
                        cls4 = cls;
                    } else {
                        list3 = this.propertyFilters;
                        if (list3 != null && list3.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                if (!this.apply(jSONSerializer2, obj, key, value)) {
                                    cls = cls4;
                                    this = this;
                                    obj = obj;
                                    cls4 = cls;
                                }
                            } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !this.apply(jSONSerializer2, obj, JSON.toJSONString(key), value)) {
                                cls = cls4;
                                this = this;
                                obj = obj;
                                cls4 = cls;
                            }
                        }
                        list4 = jSONSerializer2.nameFilters;
                        if (list4 != null && list4.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = this.processKey(jSONSerializer2, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = this.processKey(jSONSerializer2, obj, JSON.toJSONString(key), value);
                            }
                        }
                        list5 = this.nameFilters;
                        if (list5 != null && list5.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = this.processKey(jSONSerializer2, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = this.processKey(jSONSerializer2, obj, JSON.toJSONString(key), value);
                            }
                        }
                        if (key != null) {
                            try {
                                if (key instanceof String) {
                                    cls = cls4;
                                    str = key;
                                    jSONSerializer2 = jSONSerializer;
                                    value = processValue(jSONSerializer2, null, obj, str, value, i);
                                    i2 = i;
                                } else {
                                    if ((key instanceof Map) || (key instanceof Collection)) {
                                        cls = cls4;
                                        str = key;
                                    } else {
                                        String str17 = key;
                                        str = str17;
                                        cls = cls4;
                                        value = this.processValue(jSONSerializer2, null, obj, JSON.toJSONString(str17), value, i);
                                    }
                                    jSONSerializer2 = jSONSerializer;
                                    i2 = i;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                jSONSerializer2 = jSONSerializer;
                                jSONSerializer2.context = serialContext;
                                throw th;
                            }
                        } else {
                            cls = cls4;
                            str = key;
                            jSONSerializer2 = jSONSerializer;
                            value = processValue(jSONSerializer2, null, obj, str, value, i);
                            i2 = i;
                        }
                        if (value == null || SerializerFeature.isEnabled(serializeWriter.features, i2, SerializerFeature.WriteMapNullValue)) {
                            if (str instanceof String) {
                                String str18 = str;
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer2.println();
                                }
                                serializeWriter.writeFieldName(str18, true);
                            } else {
                                if (!z2) {
                                    serializeWriter.write(44);
                                }
                                if ((!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) || SerializerFeature.isEnabled(i2, SerializerFeature.WriteNonStringKeyAsString)) && !(str instanceof Enum)) {
                                    jSONSerializer2.write(JSON.toJSONString(str));
                                } else {
                                    jSONSerializer2.write((Object) str);
                                }
                                serializeWriter.write(58);
                            }
                            if (value == null) {
                                serializeWriter.writeNull();
                            } else {
                                cls2 = value.getClass();
                                if (cls2 != cls) {
                                    objectWriter = jSONSerializer2.getObjectWriter(cls2);
                                    cls = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (!SerializerFeature.isEnabled(i2, SerializerFeature.WriteClassName) && (objectSerializer instanceof JavaBeanSerializer)) {
                                    if (type instanceof ParameterizedType) {
                                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                        if (actualTypeArguments.length == 2) {
                                            type2 = actualTypeArguments[1];
                                        } else {
                                            type2 = null;
                                        }
                                    } else {
                                        type2 = null;
                                    }
                                    ((JavaBeanSerializer) objectSerializer).writeNoneASM(jSONSerializer2, value, str, type2, i2);
                                    jSONSerializer2 = jSONSerializer;
                                    objectSerializer2 = objectSerializer;
                                } else {
                                    objectSerializer2 = objectSerializer;
                                    try {
                                        objectSerializer2.write(jSONSerializer, value, str, null, i);
                                        jSONSerializer2 = jSONSerializer;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        jSONSerializer2 = jSONSerializer;
                                        jSONSerializer2.context = serialContext;
                                        throw th;
                                    }
                                }
                                objectWriter = objectSerializer2;
                            }
                            cls4 = cls;
                            z2 = false;
                        } else {
                            this = this;
                            obj = obj;
                            cls4 = cls;
                        }
                    }
                }
            }
        }
        jSONSerializer2.context = serialContext;
        jSONSerializer2.decrementIdent();
        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
            jSONSerializer2.println();
        }
        if (z) {
            return;
        }
        serializeWriter.write(125);
    }
}
