package com.firman.firebasestore.util;

import android.view.View;

/**
 * Created by Firman on 11/8/2016.
 */

public class CustomOnItemClickListener implements View.OnClickListener {
    private OnItemClickCallback onItemClickCallback;
    private int position;

    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);

    }

    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }


}
