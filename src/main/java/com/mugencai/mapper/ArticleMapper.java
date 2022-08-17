package com.mugencai.mapper;


import com.mugencai.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    int addArticle(Article article);

    int deleteArticle(int id);

    int updateArticle(Article article);

    Article getArticle(int id);

    Article getDetailedArticle(int id);

    List<Article> listArticle();

    List<Article> listIndexArticle(); /*前台获取所有文章*/

    List<Article> listRecommendArticle(); /*前台获取所有推荐文章*/

    List<String> getGroupYear(); /*获取博客对应年份的集合*/

    List<Article> listArticleByYear(String year); /*根据修改年份查找对应的博客列表*/

    List<Article> listArticleByType(int typeId); /*根据type查找对应的博客列表*/

    List<Article> listArticleByTag(int tid); /*根据tag查找对应的博客列表*/


}
