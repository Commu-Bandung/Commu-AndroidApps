package com.firman.firebasestore.base;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by Firman on 11/8/2016.
 */

public class StoreOnlineApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }


}
