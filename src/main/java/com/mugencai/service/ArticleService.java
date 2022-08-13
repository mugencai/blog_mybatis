package com.mugencai.service;

import com.mugencai.mapper.ArticleMapper;
import com.mugencai.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    int addArticle(Article article);

    int deleteArticle(int id);

    int updateArticle(Article article);

    Article getArticle(int id);

    List<Article> listArticle();


}
