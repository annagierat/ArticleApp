package com.example.articleApp.service;

import com.example.articleApp.model.Article;

import java.util.List;

public interface IArticleService {


    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    boolean addArticle(Article article);
    void updateArticle (Article article);
    void deleteArticleById(int articleId);

}
