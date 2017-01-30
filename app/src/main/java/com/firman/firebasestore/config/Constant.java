package com.firman.firebasestore.config;

import java.io.Serializable;

/**
 * Created by Firman on 1/2/2017.
 */

public class Constant implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SERVER_IMAGE_CATEGORY="http://192.168.43.68/company/event/upload/category/";
    public static final String SERVER_IMAGE_NEWSLIST_THUMBS="http://192.168.43.68/company/event/upload/thumbs/";
    public static final String SERVER_IMAGE_NEWSLISTDETAILS="http://192.168.43.68/company/event/upload/";
    public static final String LATEST_URL = "http://192.168.43.68/company/event/api.php?latest_news=50";
    public static final String CATEGORY_URL = "http://192.168.43.68/company/event/api.php";
    public static final String CATEGORY_ITEM_URL = "http://192.168.43.68/company/event/api.php?cat_id=";
    public static final String COMPANY_DETAILS_URL = "http://192.168.43.68/company/event/api.php?apps_details";
    public static final String CATEGORY_ARRAY_NAME="NewsApp";
    public static final String CATEGORY_NAME="category_name";
    public static final String CATEGORY_CID="cid";
    public static final String CATEGORY_IMAGE="category_image";
    public static final String CATEGORY_ITEM_CID="cid";
    public static final String CATEGORY_ITEM_NAME="category_name";
    public static final String CATEGORY_ITEM_IMAGE="category_image";
    public static final String CATEGORY_ITEM_STATUS="status";
    public static final String CATEGORY_ITEM_CAT_ID="nid";
    public static final String CATEGORY_ITEM_NEWSHEADING="news_heading";
    public static final String CATEGORY_ITEM_NEWSDESCRI="news_description";
    public static final String CATEGORY_ITEM_NEWSIMAGE="news_image";
    public static final String CATEGORY_ITEM_NEWSDATE="news_date";
    public static final String CATEGORY_ITEM_NEWSSTATUS="news_status";
    public static final String COMPANY_DETAILS_ID="id";
    public static final String COMPANY_DETAILS_APPNAME="app_name";
    public static final String COMPANY_DETAILS_COMLOGO="app_logo";
    public static final String COMPANY_DETAILS_COMMAIL="app_email";
    public static final String COMPANY_DETAILS_COMSITE="app_website";
    public static final String COMPANY_DETAILS_COMDES="app_description";
    public static String CATEGORY_TITLE;
    public static int CATEGORY_IDD;


}
