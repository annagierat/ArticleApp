package com.example.articleApp.dao;

import com.example.articleApp.model.Article;

import java.util.List;

public interface IArticleDAO {

    List<Article> getAllArticles();
    Article getArticleByUd(int articleId);
    Article addArticle(Article article);
    Article updateArticle(int articleId);
    Article deleteArticle(int articleId);
    Article doesArticleExists(Article article);


}
