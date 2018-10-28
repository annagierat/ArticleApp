package com.example.articleApp.dao;

import com.example.articleApp.model.Article;

import java.util.List;

public interface IArticleDAO {

    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle (Article article);
    void deleteArticleById(int articleId);
    boolean isArticleExists(String title, String category);

}
