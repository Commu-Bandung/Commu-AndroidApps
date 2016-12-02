package com.firman.firebasestore;

/**
 * Created by Firman on 11/8/2016.
 */

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firman.firebasestore.preference.AppPreference;
public class SplashScreenActivity extends AppCompatActivity {

    private AppPreference appPreference;
    private DelayAsync mDelayAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        getSupportActionBar().hide();
        appPreference = new AppPreference(SplashScreenActivity.this);

        mDelayAsync = new DelayAsync();
        mDelayAsync.execute();
    }

    @Override
    protected void onDestroy() {
        mDelayAsync.cancel(true);
        super.onDestroy();
    }

    class DelayAsync extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            }catch (Exception e){}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent intent = null;
            if (appPreference.getUserId().equals("") && appPreference.getEmail().equals("")){
                intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            }else{
                intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
            }

            startActivity(intent);
            finish();
        }
    }


}
