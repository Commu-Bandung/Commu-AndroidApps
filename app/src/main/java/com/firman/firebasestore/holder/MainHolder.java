package com.firman.firebasestore.holder;

/**
 * Created by Firman on 1/7/2017.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firman.firebasestore.R;

public class MainHolder extends RecyclerView.ViewHolder{

    public ImageView img_avatar;
    public TextView txt_id, txt_kategori;
    public CardView cardview_item;

    public MainHolder(View itemView) {
        super(itemView);
        img_avatar = (ImageView)itemView.findViewById(R.id.img_avatar);
        txt_id = (TextView)itemView.findViewById(R.id.txt_id);
        txt_kategori = (TextView) itemView.findViewById(R.id.txt_kategori);
        cardview_item = (CardView) itemView.findViewById(R.id.cardview_item);
    }
}
