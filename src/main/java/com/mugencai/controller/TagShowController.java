package com.mugencai.controller;

import com.mugencai.pojo.Article;
import com.mugencai.pojo.Tag;
import com.mugencai.service.ArticleService;
import com.mugencai.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    TagService tagService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/tag")
    public String tagShow(Model model){
        List<Tag> tagList = tagService.listBlogTag();
        model.addAttribute("tagList",tagList);
        return"tag";
    }

    @RequestMapping("/tag/{tid}")
    public String articlesByTag(@PathVariable("tid") int tid, Model model){
        List<Article> articleList = articleService.listArticleByTag(tid);
        model.addAttribute("articleList", articleList);
        return"articlesByTag";
    }

}
