package io.dcloud.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.text.HtmlCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.common.DHInterface.IMgr;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.ThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.HebrewProber;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p3 {
    private static boolean a = false;
    private static boolean b = false;

    public static void a(final Context context) {
        ThreadPool.self().addThreadTask(new Runnable() { // from class: io.dcloud.p.p3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                p3.c(context);
            }
        }, true);
    }

    private static String b(Context context) {
        try {
            String[] list = context.getAssets().list("");
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (String str : list) {
                    if (!str.startsWith(AbsoluteConst.XML_APPS) && !str.equals("data") && !str.startsWith("uni-js") && !str.startsWith("fonts") && !str.startsWith("dcloud") && !str.startsWith("supplierconfig") && !str.startsWith("amap_") && !str.startsWith("location_") && !str.startsWith("map_") && !str.endsWith(".png") && !str.endsWith(".xml")) {
                        arrayList.add(str);
                        if (!b) {
                            b = a(str);
                        }
                    }
                }
            }
            return TextUtils.join(",", arrayList);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context) {
        HashMap map = new HashMap();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            if (SP.getBundleData(context, "pdr", "vc").equals(str)) {
                return;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            map.put("man", applicationInfo.name);
            map.put("ran", applicationInfo.className);
            map.put("sofs", a(applicationInfo));
            map.put("afs", b(context));
            map.put("isjg", a | b ? "1" : WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            SP.setBundleData(context, "pdr", "vc", str);
            SP.setBundleData(context, "pdr", "packdata", new JSONObject(map).toString());
        } catch (Exception unused) {
        }
    }

    private static String a(ApplicationInfo applicationInfo) {
        File file = new File(applicationInfo.nativeLibraryDir);
        if (!file.isDirectory()) {
            return "";
        }
        File[] fileArrListFiles = file.listFiles();
        ArrayList arrayList = new ArrayList();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (!name.startsWith("libweex") && !name.startsWith("libc++_") && !name.startsWith("libimage") && !name.startsWith("libnative-imagetranscoder") && !name.startsWith("libbreakpad-core") && !name.startsWith("libneonui_shared") && !name.startsWith("libgifimage") && !name.startsWith("libpl_droidsonroids_gif") && !name.startsWith("libnative-filters") && !name.startsWith("libAMapSDK")) {
                    arrayList.add(name);
                    if (!a) {
                        a = b(name);
                    }
                }
            }
        }
        return TextUtils.join(",", arrayList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean b(String str) {
        str.getClass();
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2134158120:
                if (str.equals("libuusafe.so")) {
                    b2 = 0;
                }
                break;
            case -2018608874:
                if (str.equals("libijmDataEncryption.so")) {
                    b2 = 1;
                }
                break;
            case -1985752059:
                if (str.equals("libashield.so")) {
                    b2 = 2;
                }
                break;
            case -1984868023:
                if (str.equals("libkwscmm.so")) {
                    b2 = 3;
                }
                break;
            case -1865052775:
                if (str.equals("libkwscr.so")) {
                    b2 = 4;
                }
                break;
            case -1827573641:
                if (str.equals("libsecenh.so")) {
                    b2 = 5;
                }
                break;
            case -1818427804:
                if (str.equals("libsecexe.so")) {
                    b2 = 6;
                }
                break;
            case -1815798633:
                if (str.equals("libexecv3.so")) {
                    b2 = 7;
                }
                break;
            case -1755954320:
                if (str.equals("libapktoolplus_jiagu.so")) {
                    b2 = 8;
                }
                break;
            case -1673317148:
                if (str.equals("libxloader.so")) {
                    b2 = 9;
                }
                break;
            case -1645444250:
                if (str.equals("libdemolishdata.so")) {
                    b2 = 10;
                }
                break;
            case -1627800481:
                if (str.equals("libshell.so")) {
                    b2 = 11;
                }
                break;
            case -1580880316:
                if (str.equals("libgeiri-x86.so")) {
                    b2 = 12;
                }
                break;
            case -1530914335:
                if (str.equals("libkwslinker.so")) {
                    b2 = 13;
                }
                break;
            case -1496547210:
                if (str.equals("libzuma.so")) {
                    b2 = 14;
                }
                break;
            case -1461833317:
                if (str.equals("OPPOProtect.so")) {
                    b2 = 15;
                }
                break;
            case -1390166100:
                if (str.equals("libchaosvmp.so")) {
                    b2 = 16;
                }
                break;
            case -1322457268:
                if (str.equals("libSafeManageService.so")) {
                    b2 = 17;
                }
                break;
            case -1236264417:
                if (str.equals("libvdog.so")) {
                    b2 = 18;
                }
                break;
            case -1222315281:
                if (str.equals("libjiagu_ls.so")) {
                    b2 = 19;
                }
                break;
            case -1142792868:
                if (str.equals("libprotectClass.so")) {
                    b2 = 20;
                }
                break;
            case -1090990197:
                if (str.equals("libuusafe.jar.so")) {
                    b2 = 21;
                }
                break;
            case -1042237095:
                if (str.equals("libjgdtc.so")) {
                    b2 = 22;
                }
                break;
            case -1032518224:
                if (str.equals("libpreverify1.so")) {
                    b2 = 23;
                }
                break;
            case -1025535434:
                if (str.equals("libtosprotection.x86.so")) {
                    b2 = 24;
                }
                break;
            case -971296287:
                if (str.equals("librsprotect.so")) {
                    b2 = 25;
                }
                break;
            case -839517943:
                if (str.equals("kdpdata.so")) {
                    b2 = 26;
                }
                break;
            case -801661360:
                if (str.equals("libdemolish.so")) {
                    b2 = 27;
                }
                break;
            case -776414063:
                if (str.equals("libhdog.so")) {
                    b2 = 28;
                }
                break;
            case -716134127:
                if (str.equals("libbaiduprotect.so")) {
                    b2 = 29;
                }
                break;
            case -500661150:
                if (str.equals("libSecShell_art.so")) {
                    b2 = 30;
                }
                break;
            case -364172656:
                if (str.equals("libmogosec_dex.so")) {
                    b2 = 31;
                }
                break;
            case -355300191:
                if (str.equals("libSecShel1.so")) {
                    b2 = HebrewProber.SPACE;
                }
                break;
            case -353542522:
                if (str.equals("libSecShell.so")) {
                    b2 = 33;
                }
                break;
            case -341704342:
                if (str.equals("libDexHelper.so")) {
                    b2 = 34;
                }
                break;
            case -212159630:
                if (str.equals("libBugly-yaq.so")) {
                    b2 = 35;
                }
                break;
            case -139075217:
                if (str.equals("libshell-super.2019.so")) {
                    b2 = 36;
                }
                break;
            case -97837887:
                if (str.equals("libxgVipSecurity.so")) {
                    b2 = 37;
                }
                break;
            case -42102419:
                if (str.equals("libbaiduprotect_art.so")) {
                    b2 = 38;
                }
                break;
            case -31461491:
                if (str.equals("libddog.so")) {
                    b2 = 39;
                }
                break;
            case -23531543:
                if (str.equals("libreincp_x86.so")) {
                    b2 = 40;
                }
                break;
            case 26379962:
                if (str.equals("libshellx-super.2021.so")) {
                    b2 = 41;
                }
                break;
            case 45417304:
                if (str.equals("libapssec.so")) {
                    b2 = 42;
                }
                break;
            case 160098941:
                if (str.equals("libomesStdSco.so")) {
                    b2 = 43;
                }
                break;
            case 274614037:
                if (str.equals("libnesec.so")) {
                    b2 = 44;
                }
                break;
            case 284229221:
                if (str.equals("DexHelper.so")) {
                    b2 = 45;
                }
                break;
            case 287292665:
                if (str.equals("libnqshield.so")) {
                    b2 = 46;
                }
                break;
            case 488367136:
                if (str.equals("libashieldAdapter.so")) {
                    b2 = 47;
                }
                break;
            case 560956794:
                if (str.equals("libbaiduprotect_x86.so")) {
                    b2 = 48;
                }
                break;
            case 578150281:
                if (str.equals("libitsec.so")) {
                    b2 = 49;
                }
                break;
            case 584784501:
                if (str.equals("OPPOProtect2019.so")) {
                    b2 = 50;
                }
                break;
            case 594853830:
                if (str.equals("ibvirbox32.so")) {
                    b2 = 51;
                }
                break;
            case 597437074:
                if (str.equals("libAPKProtect.so")) {
                    b2 = 52;
                }
                break;
            case 611072698:
                if (str.equals("libtosprotection.armeabi-v7a.so")) {
                    b2 = 53;
                }
                break;
            case 635413279:
                if (str.equals("libjiagu.so")) {
                    b2 = 54;
                }
                break;
            case 685736589:
                if (str.equals("libgeiri.so")) {
                    b2 = 55;
                }
                break;
            case 705326479:
                if (str.equals("libuusafeempty.so")) {
                    b2 = 56;
                }
                break;
            case 737048669:
                if (str.equals("libenvid-ashield-sdk.so")) {
                    b2 = 57;
                }
                break;
            case 747858267:
                if (str.equals("libexecmain.so")) {
                    b2 = 58;
                }
                break;
            case 792950433:
                if (str.equals("libDexHelper-x86.so")) {
                    b2 = 59;
                }
                break;
            case 856042190:
                if (str.equals("libedog.so")) {
                    b2 = 60;
                }
                break;
            case 874097308:
                if (str.equals("libvenustech.so")) {
                    b2 = Base64.padSymbol;
                }
                break;
            case 888370528:
                if (str.equals("libtup.so")) {
                    b2 = 62;
                }
                break;
            case 935811675:
                if (str.equals("libmogosecurity.so")) {
                    b2 = 63;
                }
                break;
            case 936746009:
                if (str.equals("libegis.so")) {
                    b2 = 64;
                }
                break;
            case 941666627:
                if (str.equals("libx3g.so")) {
                    b2 = 65;
                }
                break;
            case 1007652514:
                if (str.equals("libNSaferOnly.so")) {
                    b2 = 66;
                }
                break;
            case 1025443362:
                if (str.equals("libshel1x.so")) {
                    b2 = 67;
                }
                break;
            case 1049241474:
                if (str.equals("libzBugly-yaq.so")) {
                    b2 = 68;
                }
                break;
            case 1079931101:
                if (str.equals("libshellx.so")) {
                    b2 = 69;
                }
                break;
            case 1109914022:
                if (str.equals("libdSafeShell.so")) {
                    b2 = 70;
                }
                break;
            case 1182294592:
                if (str.equals("libcmvmp.so")) {
                    b2 = 71;
                }
                break;
            case 1245443399:
                if (str.equals("ibmogosecurity.so")) {
                    b2 = 72;
                }
                break;
            case 1257677568:
                if (str.equals("libreincp.so")) {
                    b2 = 73;
                }
                break;
            case 1275966198:
                if (str.equals("libmogosec_sodecrypt.so")) {
                    b2 = 74;
                }
                break;
            case 1324647711:
                if (str.equals("libfakejni.so")) {
                    b2 = 75;
                }
                break;
            case 1413289991:
                if (str.equals("libmobisec.so")) {
                    b2 = 76;
                }
                break;
            case 1419270836:
                if (str.equals("libexec.so")) {
                    b2 = 77;
                }
                break;
            case 1469742639:
                if (str.equals("libsgsecuritybody.so")) {
                    b2 = 78;
                }
                break;
            case 1580679069:
                if (str.equals("libbasec.so")) {
                    b2 = 79;
                }
                break;
            case 1615439237:
                if (str.equals("libsecmain.so")) {
                    b2 = 80;
                }
                break;
            case 1630403175:
                if (str.equals("libtprt.so")) {
                    b2 = 81;
                }
                break;
            case 1743545871:
                if (str.equals("libfdog.so")) {
                    b2 = 82;
                }
                break;
            case 1824193784:
                if (str.equals("libsgmain.so")) {
                    b2 = 83;
                }
                break;
            case 1831927323:
                if (str.equals("libvirbox64.so")) {
                    b2 = 84;
                }
                break;
            case 1938372896:
                if (str.equals("liblegudb.so")) {
                    b2 = 85;
                }
                break;
            case 1988818099:
                if (str.equals("libvenSec.so")) {
                    b2 = 86;
                }
                break;
            case 2084629453:
                if (str.equals("libtosprotection.armeabi.so")) {
                    b2 = 87;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case Opcodes.LSTORE /* 55 */:
            case 56:
            case Opcodes.DSTORE /* 57 */:
            case 58:
            case 59:
            case 60:
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case CharsetProber.ASCII_A_CAPITAL /* 65 */:
            case 66:
            case 67:
            case 68:
            case 69:
            case IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
            case IMgr.WindowEvent.ADD_ANIMATION_CALLBACK /* 71 */:
            case IMgr.WindowEvent.WINDOW_CRATE_TITLENVIEW /* 72 */:
            case IMgr.WindowEvent.WINDOW_APPEND_TITLENVIEW /* 73 */:
            case IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
            case IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
            case IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
            case IMgr.WindowEvent.TITLE_BAR_MENU_ITEM_CLICK /* 77 */:
            case IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
            case 79:
            case 80:
            case IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
            case 82:
            case 83:
            case 84:
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
            case 86:
            case Opcodes.POP /* 87 */:
                return true;
            default:
                return false;
        }
    }

    private static boolean a(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "libuusafe.so":
            case "libijmDataEncryption.so":
            case "baiduprotect.jar":
            case "mogosec_data":
            case "ijiami3.ajm":
            case "mxsafe.data":
            case "libzuma.so":
            case "libuusafe.jar.so":
            case "mxsafe":
            case "libpreverify1.so":
            case "libtosprotection.x86.so":
            case "mogosec_classes":
            case "mxsafe.config":
            case "mxsafe.jar":
            case "ijiami.ajm":
            case "libreincp_x86.so":
            case "itse":
            case "libshellx-super.2021.so":
            case "mogosec_dexinfo":
            case "secData0.jar":
            case "sign.bin":
            case "libtosprotection.armeabi-v7a.so":
            case "jiagu_data.bin":
            case "libreincp.so":
            case "maindata/fake_classes.dex":
            case "mogosec_march":
            case "ijm_lib":
            case "baiduprotect1.jar":
            case "libtosprotection.armeabi.so":
            case "libzumadata.so":
                return true;
            default:
                return false;
        }
    }
}
