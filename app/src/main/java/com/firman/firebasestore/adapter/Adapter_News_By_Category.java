package com.firman.firebasestore.adapter;

/**
 * Created by Firman on 1/2/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firman.firebasestore.R;
import com.firman.firebasestore.config.Constant;
import com.firman.firebasestore.config.ImageLoader;
import com.firman.firebasestore.model.ItemNewsList;
import com.firman.firebasestore.ui.News_List_By_Category;

import java.util.List;

public class Adapter_News_By_Category extends ArrayAdapter<ItemNewsList>{

    private News_List_By_Category activity;
    private List<ItemNewsList> itemsnewslist;
    private ItemNewsList objnewslistBean;
    private int row;
    public ImageLoader imageLoader;

    public Adapter_News_By_Category(News_List_By_Category act, int resource, List<ItemNewsList> arrayList, int columnWidth) {
        super(act, resource, arrayList);
        this.activity = act;
        this.row = resource;
        this.itemsnewslist = arrayList;
        imageLoader=new ImageLoader(activity);

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((itemsnewslist == null) || ((position + 1) > itemsnewslist.size()))
            return view;

        objnewslistBean = itemsnewslist.get(position);

        holder.txt_newsheading=(TextView)view.findViewById(R.id.txt_newslistheading);
        holder.txt_newsdate=(TextView)view.findViewById(R.id.txt_newslistdate);

        holder.img_news=(ImageView)view.findViewById(R.id.img_newslist);

        holder.txt_newsheading.setText(objnewslistBean.getNewsHeading().toString());
        holder.txt_newsdate.setText(objnewslistBean.getNewsDate().toString());

        imageLoader.DisplayImage(Constant.SERVER_IMAGE_NEWSLIST_THUMBS+objnewslistBean.getNewsImage().toString(), holder.img_news);

        return view;

    }

    public class ViewHolder {

        public ImageView img_news;
        public  TextView txt_newsheading;
        public  TextView txt_newsdate;

    }
}
