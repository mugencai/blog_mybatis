package com.mugencai.mapper;


import com.mugencai.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {

    int addArticle(Article article);

    int deleteArticle(int id);

    int updateArticle(Article article);

    Article getArticle(int id);

    Article getDetailedArticle(@Param("id") int id);

    List<Article> listArticle();

    List<Article> listIndexArticle(); /*get articles at homepage*/

    List<Article> listRecommendArticle(); /*get recommended articles at homepage*/

    List<String> getGroupYear(); /*get list of years*/

    List<Article> listArticleByYear(String year);

    List<Article> listArticleByType(int typeId);

    List<Article> listArticleByTag(int tid);

    List<Article> listArticleBySearch(String query); /*search at homepage*/

    int updateViewsById(int id);

    Article getAboutArticle();


}
