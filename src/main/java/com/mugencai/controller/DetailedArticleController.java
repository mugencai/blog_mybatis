package com.mugencai.controller;


import com.mugencai.pojo.Article;
import com.mugencai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailedArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/article/{id}")
    public String DetailedArticle(@PathVariable("id") int id, Model model){
        Article detailedArticle = articleService.getDetailedArticle(id);
        if (detailedArticle != null){
            articleService.updateViewsById(id);
        }
        model.addAttribute("detailedArticle", detailedArticle);
        return"detailedArticle";
    }


}
