package com.firman.firebasestore.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Firman on 11/8/2016.
 */

public class Util {
    public static String getCurrency(double price) {
        Locale indonesia = new Locale("id", "ID");
        NumberFormat indonesiaFormat = NumberFormat.getCurrencyInstance(indonesia);
        return getNormalizedPrice(indonesiaFormat.format(price));
    }

    public static String getNormalizedPrice(String price) {
        String currency = price.substring(0, 2);
        String value = price.substring(2, price.length());
        String normalizedPrice = currency + " " + value;

        return normalizedPrice;
    }

    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }
}