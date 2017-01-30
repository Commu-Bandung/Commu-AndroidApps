package com.firman.firebasestore;

/**
 * Created by Firman on 1/3/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.firman.firebasestore.ui.About_Us;
import com.firman.firebasestore.ui.News_Favorite;
import com.firman.firebasestore.ui.SlidingTabLayout;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class MainActivityTab extends AppCompatActivity {

    // Declaring Your View and Variables

    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Event Now","Kategori Event"};
    int Numboftabs =2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_tab);

        Parse.initialize(this, getString(R.string.parse_application_id), getString(R.string.parse_client_key));
        ParseAnalytics.trackAppOpened(getIntent());
        PushService.setDefaultPushCallback(this, MainActivityTab.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();



        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);


        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);


        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });


        tabs.setViewPager(pager);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            MainActivityTab.this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.refresh:
                finish();
                startActivity(getIntent());
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
                return true;

            case R.id.menu_favorite:
                startActivity(new Intent(getApplicationContext(), News_Favorite.class));
                return true;

            case R.id.menu_about:
                Intent about = new Intent(getApplicationContext(), About_Us.class);
                startActivity(about);
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

}
