package com.example.clinto.retrofit_sample2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Clinto on 21-Aug-17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.SubClass> {


    private List<NewsItem> newsList;
    Context context;
    public RecycleAdapter(Context context, List<NewsItem> retlist) {
        this.context = context;
        this.newsList = retlist;
    }

    @Override
    public RecycleAdapter.SubClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row, parent, false);
        return new SubClass(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.SubClass holder, int position) {

        NewsItem newsItem = newsList.get(position);
        String img_url = "http://iroidtech.com/wecare/uploads/news_events/";
        if (!TextUtils.isEmpty(newsItem.getImage())) {
            Picasso.with(context).load(img_url + newsItem.getImage()).error(R.drawable.imggg1).placeholder(R.drawable.imggg1)
                    .into(holder.ivNewsImage);
        }

        holder.tvNewsTitle.setText(newsItem.getTitle());


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public class SubClass extends RecyclerView.ViewHolder{
        protected CircleImageView ivNewsImage;
        protected TextView tvNewsTitle, tvNewsContent, tvNewsDate;


        public SubClass(View view) {
            super(view);
            ivNewsImage =   (CircleImageView) view.findViewById(R.id.thumbnail);
            tvNewsTitle =  (TextView) view.findViewById(R.id.title);
            tvNewsContent = (TextView) view.findViewById(R.id.content);
            tvNewsDate =  (TextView) view.findViewById(R.id.date);
        }
    }
}




