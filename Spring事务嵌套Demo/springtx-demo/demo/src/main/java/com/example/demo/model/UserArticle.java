package com.example.demo.model;

import java.io.Serializable;

public class UserArticle implements Serializable {

    private String articleId;

    private String userId;

    private String title;

    private String context;

    public UserArticle(String articleId, String userId, String title, String context) {
        this.articleId = articleId;
        this.userId = userId;
        this.title = title;
        this.context = context;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
