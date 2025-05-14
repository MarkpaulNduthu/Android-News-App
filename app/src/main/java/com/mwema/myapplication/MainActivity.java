package com.mwema.myapplication;

import android.os.Bundle;
import android.widget.Button;
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
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
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
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        news.setLayoutManager(new LinearLayoutManager(this));
        btn1.setOnClickListener(view -> {
            String value = (String) btn1.getText();
            fetchNews(value);
        });
        btn2.setOnClickListener(view -> {
            String value = (String) btn2.getText();
            fetchNews(value);
        });
        btn3.setOnClickListener(view -> {
            String value = (String) btn3.getText();
            fetchNews(value);
        });
        btn4.setOnClickListener(view -> {
            String value = (String) btn4.getText();
            fetchNews(value);
        });
        btn5.setOnClickListener(view -> {
            String value = (String) btn5.getText();
            fetchNews(value);
        });
        btn6.setOnClickListener(view -> {
            String value = (String) btn6.getText();
            fetchNews(value);
        });
        btn7.setOnClickListener(view -> {
            String value = (String) btn7.getText();
            fetchNews(value);
        });

        fetchNews(null);
    }
    private void fetchNews(String query){
        new Thread(()->{
            List<Articles> articlesList = RetrofitInstance.getTopHeadlines("us",query);

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