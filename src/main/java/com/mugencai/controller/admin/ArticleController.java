package com.mugencai.controller.admin;

import com.mugencai.pojo.Article;
import com.mugencai.pojo.Tag;
import com.mugencai.pojo.Type;
import com.mugencai.service.ArticleService;
import com.mugencai.service.TagService;
import com.mugencai.service.TypeService;
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

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @RequestMapping("/articleMgmt")
    public String listArticle(Model model){
        List<Article> articleList = articleService.listArticle();
        model.addAttribute("articleList",articleList);
        return "/admin/articleMgmt";
    }


    //toAddArticle
    @RequestMapping("/articleInput")
    public String toArticleInput(Model model){

        //查出所有类别
        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList",typeList);


        //查出所有标签
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);

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
        //原article
        Article article = articleService.getArticle(id);
//        article.init();   //将tags集合转换为tagIds字符串
        model.addAttribute("article",article);


        //所有type
        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList",typeList);

        //所有tag
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);


        return "/admin/articleUpdate";
    }

    //Update
    @RequestMapping("/updateArticle")
    public String UpdateArticle(Article article){

        //给原article中的List<Tag>赋值
        article.setTags(tagService.getTagByString(article.getTagIds()));

        articleService.updateArticle(article);
        return "redirect:/admin/articleMgmt";
    }


}
