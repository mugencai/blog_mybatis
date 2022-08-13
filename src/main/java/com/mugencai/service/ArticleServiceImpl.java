package com.mugencai.service;

import com.mugencai.mapper.ArticleMapper;
import com.mugencai.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleMapper articleMapper;


    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public int deleteArticle(int id) {
        return articleMapper.deleteArticle(id);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public Article getArticle(int id) {
        return articleMapper.getArticle(id);
    }

    @Override
    public List<Article> listArticle() {
        return articleMapper.listArticle();
    }
}
