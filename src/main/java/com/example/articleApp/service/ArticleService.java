package com.example.articleApp.service;

import com.example.articleApp.dao.IArticleDAO;
import com.example.articleApp.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleService implements IArticleService {


 @Autowired
 private IArticleDAO iArticleDAO;



    @Override
    public List<Article> getAllArticles() {
        return iArticleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return iArticleDAO.getArticleById(articleId);
    }

    @Override
    public boolean addArticle(Article article) {
        if (iArticleDAO.isArticleExists(article.getTitle(),article.getCategory())) {
            return false;
        }else{
            iArticleDAO.addArticle(article);
        }return true;
    }

    @Override
    public void updateArticle(Article article) {
        iArticleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticleById(int articleId) {
        iArticleDAO.deleteArticleById(articleId);
    }
}
