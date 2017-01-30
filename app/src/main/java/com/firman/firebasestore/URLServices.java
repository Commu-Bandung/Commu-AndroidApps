package com.firman.firebasestore;

import android.net.Uri;

/**
 * Created by Firman on 1/7/2017.
 */

public class URLServices {
    public static String URL_SHOW = "http://192.168.100.13/company/api/showkategori.php";
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";

    public static String URL_INSERT(String kategori) {
        return Uri.encode("http://192.168.100.13/company/api/insertkategori.php?kategori=" + kategori , ALLOWED_URI_CHARS);
    }

    public static String URL_DELETE(String id) {
        return "http://192.168.100.13/company/api/delete.php?id=" + id;
    }

    public static String URL_MODIFY(String id, String kategori) {
        return Uri.encode("http://192.168.100.13/company/api/modifykategori.php?id=" + id + "&kategori=" + kategori , ALLOWED_URI_CHARS);
    }
}
