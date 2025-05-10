package com.mwema.myapplication.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mwema.myapplication.Models.Articles;
import com.mwema.myapplication.R;
import com.squareup.picasso3.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Context context;
    List<Articles> demoList;
    public NewsAdapter(Context context, List<Articles> demoList){
        this.context = context;
        this.demoList = demoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_news_recycler_view_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Articles articles = demoList.get(position);
        holder.newsDescription.setText(articles.getTitle());
        holder.newsSource.setText(articles.getAuthor());
        new Picasso.Builder(context).build().load(articles.getUrlToImage()).into(holder.newsImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"clicked News",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView newsDescription,newsSource;
        CardView cardView;
        ImageView newsImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            newsDescription = itemView.findViewById(R.id.newsDescription);
            newsSource = itemView.findViewById(R.id.newsSource);
            newsImage = itemView.findViewById(R.id.NewsImage);
            cardView = itemView.findViewById(R.id.newsCard);
        }
    }

}
