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


    List<Article> listArticle(); /*后台获取所有博客*/

    List<Article> listIndexArticle(); /*前台获取所有博客*/

    List<Article> listRecommendArticle(); /*前台获取所有推荐文章*/

    List<String> getGroupYear(); /*获取博客对应年份的集合*/


    List<Article> listArticleByYear(String year);

    List<Article> listArticleByType(int typeId); /*根据type查找对应的博客列表*/

    List<Article> listArticleByTag(int tid); /*根据tag查找对应的博客列表*/

    List<Article> listArticleBySearch(String query); /*前台搜索*/

    int updateViewsById(int id); /*更新文章浏览量*/

    Article getAboutArticle(); /*获取自我介绍的文章*/


}
