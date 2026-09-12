package io.dcloud.sdk.core.util;

import io.dcloud.p.e;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class TidUtil {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:110:0x012b  */
    /* JADX WARN: Code duplicated, block: B:136:0x016f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0059  */
    /* JADX WARN: Code duplicated, block: B:189:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:248:0x0262  */
    /* JADX WARN: Code duplicated, block: B:282:0x02af  */
    /* JADX WARN: Code duplicated, block: B:45:0x009a  */
    public static String getTid(String str, int i) {
        if (!e.b().a(str)) {
            return str + i;
        }
        if (i == 1) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "bd":
                    return "131";
                case "gg":
                    return "1220";
                case "gm":
                    return "132";
                case "hw":
                    return "130";
                case "ks":
                    return "75";
                case "pg":
                    return "1221";
                case "csj":
                    return "68";
                case "gdt":
                    return "67";
                case "sgm":
                    return "110";
                default:
                    return "";
            }
        }
        if (i == 7) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "gm":
                    return "96";
                case "ks":
                    return "95";
                case "csj":
                    return "94";
                case "gdt":
                    return "93";
                case "sgm":
                    return "97";
                default:
                    return "";
            }
        }
        if (i == 15) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "bd":
                    return "127";
                case "gg":
                    return "1230";
                case "gm":
                    return "128";
                case "hw":
                    return "126";
                case "ks":
                    return "125";
                case "pg":
                    return "1231";
                case "csj":
                    return "124";
                case "gdt":
                    return "123";
                case "sgm":
                    return "129";
                default:
                    return "";
            }
        }
        if (i == 4) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "bd":
                    return "78";
                case "gg":
                    return "1200";
                case "gm":
                    return "79";
                case "hw":
                    return "77";
                case "ks":
                    return "76";
                case "pg":
                    return "1201";
                case "csj":
                    return "73";
                case "gdt":
                    return "72";
                default:
                    return "";
            }
        }
        if (i == 5) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "gm":
                    return "1503";
                case "ks":
                    return "1502";
                case "gdt":
                    return "1501";
            }
        }
        switch (i) {
            case 9:
                str.getClass();
                str.hashCode();
                switch (str) {
                    case "bd":
                        return "88";
                    case "gg":
                        return "1210";
                    case "gm":
                        return "89";
                    case "hw":
                        return "87";
                    case "ks":
                        return "85";
                    case "pg":
                        return "1211";
                    case "wm":
                        return "140";
                    case "csj":
                        return "84";
                    case "gdt":
                        return "83";
                    case "sgm":
                        return "86";
                    default:
                        return "";
                }
            case 10:
                str.getClass();
                str.hashCode();
                switch (str) {
                    case "gm":
                        return "106";
                    case "ks":
                        return "105";
                    case "csj":
                        return "104";
                    case "gdt":
                        return "103";
                    default:
                        return "";
                }
            case 11:
                break;
            default:
                return "";
        }
        str.getClass();
        return !str.equals(Const.TYPE_GM) ? "" : "1002111";
    }
}
