package com.mugencai.controller;

import com.mugencai.pojo.Article;
import com.mugencai.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/about")
    public String aboutShow(Model model){
        Article aboutArticle = articleService.getAboutArticle();
        if (aboutArticle != null){
            articleService.updateViewsById(0);
        }
        model.addAttribute("article",aboutArticle);
        return "/about";
    }


}
