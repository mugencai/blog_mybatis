package com.mugencai.controller;


import com.mugencai.pojo.Article;
import com.mugencai.pojo.Type;
import com.mugencai.service.ArticleService;
import com.mugencai.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    TypeService typeService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/type")
    public String showType(Model model){
        List<Type> typeList = typeService.listBlogType();
        model.addAttribute("typeList",typeList);
        return"type";
    }

    @RequestMapping("/type/{typeId}")
    public String showArticlesByType(@PathVariable("typeId") int typeId, Model model){
        List<Article> articleList = articleService.listArticleByType(typeId);
        model.addAttribute("articleList", articleList);
        return"articlesByType";
    }

}
