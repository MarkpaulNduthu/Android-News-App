package com.mwema.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mwema.myapplication.Models.Articles;
import com.mwema.myapplication.RetrofitAPI.RetrofitInstance;
import com.mwema.myapplication.ViewModels.NewsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        news = findViewById(R.id.newsContent);
        news.setLayoutManager(new LinearLayoutManager(this));
        fetchNews();
    }
    private void fetchNews(){
        new Thread(()->{
            List<Articles> articlesList = RetrofitInstance.getTopHeadlines("us");

            runOnUiThread(()->{
                if(articlesList != null){
                    news.setAdapter(new NewsAdapter(MainActivity.this,articlesList));
                }else{
                    Toast.makeText(this,"articlesList is null",Toast.LENGTH_SHORT).show();
                }
            });

        }).start();
    }

}