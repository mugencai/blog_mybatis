package com.mugencai.controller.admin;

import com.mugencai.pojo.Article;
import com.mugencai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("admin")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/articleMgmt")
    public String listArticle(Model model){
        List<Article> articleList = articleService.listArticle();
        model.addAttribute("articleList",articleList);
        System.out.println(articleList);
        return "/admin/articleMgmt";
    }


    //toAddArticle
    @RequestMapping("/articleInput")
    public String toArticleInput(){
        return "/admin/articleInput";
    }

    //addArticle
    @PostMapping("/articleInput")
    public String addArticle(Article article){
        articleService.addArticle(article);
        return "redirect:/admin/articleMgmt";
    }

    //delete
    @RequestMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return "redirect:/admin/articleMgmt";
    }

    //toUpdate
    @RequestMapping("/updateArticle/{id}")
    public String toUpdateArticle(@PathVariable("id") int id,Model model){
        Article article = articleService.getArticle(id);
        model.addAttribute("article",article);
        return "/admin/articleUpdate";
    }

    //Update
    @RequestMapping("/updateArticle")
    public String UpdateArticle(Article article){
        articleService.updateArticle(article);
        return "redirect:/admin/articleMgmt";
    }


}
