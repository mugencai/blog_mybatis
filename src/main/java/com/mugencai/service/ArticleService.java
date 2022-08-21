package com.mugencai.service;

import com.mugencai.mapper.ArticleMapper;
import com.mugencai.pojo.Article;
import com.mugencai.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    int addArticle(Article article);

    int deleteArticle(int id);

    int updateArticle(Article article);

    Article getArticle(int id);

    Article getDetailedArticle(int id);


    List<Article> listArticle(); /*get articles at adminPage*/

    List<Article> listIndexArticle(); /*get articles at homepage*/

    List<Article> listRecommendArticle(); /*get recommended articles at homepage*/

    List<String> getGroupYear(); /*get list of years*/


    List<Article> listArticleByYear(String year);

    List<Article> listArticleByType(int typeId);

    List<Article> listArticleByTag(int tid);

    List<Article> listArticleBySearch(String query); /*search articles at homepage*/

    int updateViewsById(int id);

    Article getAboutArticle();


}
