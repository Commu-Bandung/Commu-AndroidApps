package com.firman.firebasestore;

/**
 * Created by Firman on 1/14/2017.
 */

public class Config {

    //URL to our login.php file
    //Kalau bisa dihosting
    //IP dari Internet harus nyambung

    //Via IP Address LocalHost
    public static final String LOGIN_URL = "http://192.168.43.68/company/api/login.php";


    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";


}