package com.firman.firebasestore;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.firman.firebasestore.adapter.ImagePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Firman on 11/8/2016.
 */

public class DetailImageActivity extends AppCompatActivity {
    private ArrayList<String> listImageUrl;
    private int selectedPosition;
    private ViewPager mViewPager;
    private ImagePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image);

        getSupportActionBar().hide();
        mViewPager = (ViewPager)findViewById(R.id.viewpager);

        listImageUrl = getIntent().getStringArrayListExtra("url_images");
        selectedPosition = getIntent().getIntExtra("position", 0);

        adapter = new ImagePagerAdapter(getSupportFragmentManager());
        adapter.setListImages(listImageUrl);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(selectedPosition);
    }
}

