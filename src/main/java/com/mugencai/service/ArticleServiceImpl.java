package com.mugencai.service;

import com.mugencai.mapper.ArticleMapper;
import com.mugencai.pojo.Article;
import com.mugencai.pojo.Tag;
import com.mugencai.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Article getDetailedArticle(int id) {
        Article detailedArticle = articleMapper.getDetailedArticle(id);
        String content = detailedArticle.getContent();
        detailedArticle.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return detailedArticle;
    }

    @Override
    public Article getAboutArticle() {
        Article aboutArticle = articleMapper.getAboutArticle();
        String content = aboutArticle.getContent();
        aboutArticle.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return aboutArticle;
    }


    @Override
    public List<Article> listArticle() {
        return articleMapper.listArticle();
    }

    @Override
    public List<Article> listIndexArticle() {
        return articleMapper.listIndexArticle();
    }

    @Override
    public List<Article> listRecommendArticle() {
        return articleMapper.listRecommendArticle();
    }

    @Override
    public List<String> getGroupYear() {
        return articleMapper.getGroupYear();
    }

    @Override
    public List<Article> listArticleByYear(String year) {
        return articleMapper.listArticleByYear(year);
    }

    @Override
    public List<Article> listArticleByType(int typeId) {
        return articleMapper.listArticleByType(typeId);
    }

    @Override
    public List<Article> listArticleByTag(int tid) {
        return articleMapper.listArticleByTag(tid);
    }

    @Override
    public List<Article> listArticleBySearch(String query) {
        return articleMapper.listArticleBySearch(query);
    }

    @Override
    public int updateViewsById(int id) {
        return articleMapper.updateViewsById(id);
    }


}
