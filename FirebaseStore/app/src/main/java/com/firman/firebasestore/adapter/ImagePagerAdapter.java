package com.firman.firebasestore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.firman.firebasestore.fragment.ImageFragment;

import java.util.ArrayList;

/**
 * Created by Firman on 11/8/2016.
 */

public class ImagePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> listImages;

    public ArrayList<String> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<String> listImages) {
        this.listImages = listImages;
    }

    public ImagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        ImageFragment mImageFragment = new ImageFragment();
        mImageFragment.setImageUrl(getListImages().get(position));
        return mImageFragment;
    }

    @Override
    public int getCount() {
        return getListImages().size();
    }
}

