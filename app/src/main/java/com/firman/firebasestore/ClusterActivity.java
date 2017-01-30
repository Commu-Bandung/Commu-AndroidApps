package com.firman.firebasestore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Firman on 1/24/2017.
 */

public class ClusterActivity extends AppCompatActivity implements OnMapReadyCallback {
    // region Constants

    private static final String TAG = "MainActivity";

    //endregion Constants

    // region Members
    private GoogleMap mGoogleMap;
    private LatLng mDummyLatLng = new LatLng(-6.872865, 107.575965);
    private LatLng mDummyLatLng1 = new LatLng(-6.872865, 107.575965);
    private View mCustomMarkerView;
    private ImageView mMarkerImageView;
    private String ImageUrl = "http://2.bp.blogspot.com/_WNwJF6NiDMA/TUk-j4B47TI/AAAAAAAAAAM/MrEk4nIX7MM/s1600/Poltekpos+Logo.JPG";

    // region Members
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster);
        initViews();

    }

    private void initViews() {

        mCustomMarkerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
        mMarkerImageView = (ImageView) mCustomMarkerView.findViewById(R.id.profile_image);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady() called with");
        mGoogleMap = googleMap;
        MapsInitializer.initialize(this);
        addCustomMarker();
    }

    private void addCustomMarker() {
        Log.d(TAG, "addCustomMarker()");
        if (mGoogleMap == null) {
            return;
        }


        // adding a marker on map with image from  drawable
       /* mGoogleMap.addMarker(new MarkerOptions()
                .position(mDummyLatLng)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(mCustomMarkerView, R.drawable.avatar))));*/

        // adding a marker with image from URL using glide image loading library
        Glide.with(getApplicationContext()).
                load(ImageUrl)
                .asBitmap()
                .fitCenter()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                        mGoogleMap.addMarker(new MarkerOptions()
                                .position(mDummyLatLng)
                                .title("Poltekpos")
                                .position(mDummyLatLng1)
                                .title("Poltekpos")
                                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(mCustomMarkerView, bitmap))));
                        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mDummyLatLng, 13f));
                        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mDummyLatLng1, 13f));


                    }
                });


    }

    private Bitmap getMarkerBitmapFromView(View view, @DrawableRes int resId) {

        mMarkerImageView.setImageResource(resId);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = view.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        view.draw(canvas);
        return returnedBitmap;
    }

    private Bitmap getMarkerBitmapFromView(View view, Bitmap bitmap) {

        mMarkerImageView.setImageBitmap(bitmap);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = view.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        view.draw(canvas);
        return returnedBitmap;
    }
}
