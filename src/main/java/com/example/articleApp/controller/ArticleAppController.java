package com.example.articleApp.controller;


import com.example.articleApp.model.Article;
import com.example.articleApp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleAppController {

    @Autowired
    private ArticleService articleService;

        @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @PostMapping("/articles")
    public boolean addArticle (@Valid @RequestBody Article article){
        articleService.addArticle(article);
        return true;
    }
    @GetMapping("/articles/{id}")
    public Article getArticleById (@PathVariable(value = "id") int articleId){
        return articleService.getArticleById(articleId);
    }

    @PutMapping("/articles/{id}")
    public void updateArticle (@Valid @RequestBody Article article) {
        articleService.updateArticle(article);
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticleById (@PathVariable (value = "id") int articleId) {
        articleService.deleteArticleById(articleId);
    }
}