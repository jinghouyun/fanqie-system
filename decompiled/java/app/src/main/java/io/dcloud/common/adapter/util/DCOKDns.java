package io.dcloud.common.adapter.util;

import dc.squareup.okhttp3.Dns;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DCOKDns implements Dns {
    @Override // dc.squareup.okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                if (inetAddress instanceof Inet4Address) {
                    arrayList.add(0, inetAddress);
                } else {
                    arrayList.add(inetAddress);
                }
            }
            return arrayList;
        } catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException("error");
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
