package com.mugencai.controller;


import com.mugencai.pojo.Article;
import com.mugencai.pojo.Tag;
import com.mugencai.pojo.Type;
import com.mugencai.service.ArticleService;
import com.mugencai.service.TagService;
import com.mugencai.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;



    @RequestMapping("/")
    public String index(){
        return "redirect:/index";
    }



    @RequestMapping("/index")
    public String toIndex(Model model){
        List<Article> articleList = articleService.listIndexArticle();
        List<Article> listRecommendArticle = articleService.listRecommendArticle();
        List<Type> typeList = typeService.listBlogType();
        List<Tag> tagList = tagService.listBlogTag();

        model.addAttribute("articleList",articleList);
        model.addAttribute("listRecommendArticle", listRecommendArticle);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        return "/index";
    }


    @RequestMapping("/search")
    public String search(@RequestParam String query, Model model){
        List<Article> articleList = articleService.listArticleBySearch(query);
        model.addAttribute("articleList",articleList);
//        model.addAttribute("query",query);
        return "/articlesBySearch";
    }



}
