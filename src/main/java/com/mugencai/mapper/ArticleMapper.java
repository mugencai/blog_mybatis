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

    List<Article> listArticle();

}
