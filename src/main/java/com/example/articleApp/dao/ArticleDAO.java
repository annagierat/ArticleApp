package com.example.articleApp.dao;

import com.example.articleApp.model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Article> getAllArticles() {

        String hgl = "FROM Article as atc1 ORDER BY atc1.articleId";
        return entityManager.createQuery(hgl).getResultList();
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);

    }
    @Override
    public void updateArticle(Article article) {
        Article artc1 = getArticleById(article.getArticleId());
        artc1.setTitle(article.getTitle());
        artc1.setCategory(article.getCategory());
    }

    @Override
    public void deleteArticleById(int articleId) {
        entityManager.remove(getArticleById(articleId));

    }






    @Override
    public boolean isArticleExists(String title, String category) {
        String hgl = "FROM Article as atc1 WHERE atc1.title =:title and atc1.categoty =:category";
        int count = entityManager.createQuery(hgl).setParameter("title",title)
                .setParameter("category",category).getResultList().size();
            if (count!=0){
            return true;
        }
        return false;
    }
}
