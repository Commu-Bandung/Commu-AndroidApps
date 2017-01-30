package com.firman.firebasestore.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firman.firebasestore.DetailActivity;
import com.firman.firebasestore.ItemObject;
import com.firman.firebasestore.R;
import com.firman.firebasestore.holder.MainHolder;

import java.util.List;

/**
 * Created by Firman on 1/7/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainHolder> {

    public List<ItemObject.ObjectBelajar.Results> resultsList;
    public Context context;

    public MainAdapter(Context context, List<ItemObject.ObjectBelajar.Results> resultsList) {
        this.context = context;
        this.resultsList = resultsList;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null);
        MainHolder mainHolder = new MainHolder(view);
        return mainHolder;
    }

    @Override
    public void onBindViewHolder(MainHolder holder, final int position) {
        holder.txt_id.setText(resultsList.get(position).id);
        holder.txt_kategori.setText(resultsList.get(position).kategori);
        holder.cardview_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("id", resultsList.get(position).id);
                i.putExtra("kategori", resultsList.get(position).kategori);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.resultsList.size();
    }
}
