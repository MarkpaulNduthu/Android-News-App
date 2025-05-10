package com.mwema.myapplication.Models;

import java.util.ArrayList;
import java.util.List;

public class NewsApiResponseModel {
    String status = "";
    String totalResults = "";
    List<Articles> articles = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticlesList() {
        return articles;
    }

    public void setArticlesList(List<Articles> articles) {
        this.articles = articles;
    }
}
