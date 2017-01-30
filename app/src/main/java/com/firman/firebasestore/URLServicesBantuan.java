package com.firman.firebasestore;

import android.net.Uri;

/**
 * Created by Firman on 1/17/2017.
 */

public class URLServicesBantuan {
    public static String URL_SHOW = "http://192.168.100.5/company/api/showbantuan.php";
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";

    public static String URL_INSERT(String nama_organisasi, String nama_penerima, String jumlah_dana) {
        return Uri.encode("http://192.168.100.5/company/api/insertbantuandana.php?nama_organisasi=" + nama_organisasi + "&nama_penerima=" + nama_penerima + "&jumlah_dana=" + jumlah_dana, ALLOWED_URI_CHARS);
    }

    public static String URL_DELETE(String id_penerima) {
        return "http://192.168.100.5/company/api/deletebantuandana.php?id=" + id_penerima;
    }

    public static String URL_MODIFY(String id, String name, String office, String email) {
        return Uri.encode("http://192.168.100.5/user/modify.php?id=" + id + "&name=" + name + "&office=" + office + "&email=" + email, ALLOWED_URI_CHARS);
    }
}
