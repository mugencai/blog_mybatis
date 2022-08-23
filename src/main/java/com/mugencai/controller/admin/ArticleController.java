package com.mugencai.controller.admin;

import com.mugencai.mapper.BlogAndTagMapper;
import com.mugencai.pojo.Article;
import com.mugencai.pojo.BlogAndTag;
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

    @Autowired
    BlogAndTagMapper blogAndTagMapper;

    @RequestMapping("/articleMgmt")
    public String listArticle(Model model){
        List<Article> articleList = articleService.listArticle();
        model.addAttribute("articleList",articleList);
        return"admin/articleMgmt";
    }


    //toAddArticle
    @RequestMapping("/articleInput")
    public String toArticleInput(Model model){

        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList",typeList);

        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);

        return"admin/articleInput";
    }

    //addArticle
    @PostMapping("/articleInput")
    public String addArticle(Article article){

        article.setTags(tagService.getTagByString(article.getTagIds()));

        /*
            Because of the foreign key in intermediate table,
            we must first add article, and then add data to intermediate table
         */

        /*insert data to blog table*/
        articleService.addArticle(article);

        /*
            if tagList is not null，
            insert data to intermediate table
        */
        List<Tag> tagList = article.getTags();
        if (tagList != null){
            for (Tag tag : tagList) {
                blogAndTagMapper.addBlogAndTag(new BlogAndTag(tag.getId(), article.getId()));
            }
        }

        return "redirect:/admin/articleMgmt";
    }

    //delete
    @RequestMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") int id){

        /*
            Delete data in intermediate table which
            id in blog table equals to
            blog_id in intermediate table
        */
        if (blogAndTagMapper.listByBlogId(id) != null){
            blogAndTagMapper.deleteByBlogId(id);
        }

        articleService.deleteArticle(id);
        return "redirect:/admin/articleMgmt";
    }

    //toUpdate
    @RequestMapping("/updateArticle/{id}")
    public String toUpdateArticle(@PathVariable("id") int id,Model model){
        //原article
        Article article = articleService.getArticle(id);
        model.addAttribute("article",article);

        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList",typeList);

        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);

        return"admin/articleUpdate";
    }


    //Update
    @RequestMapping("/updateArticle")
    public String UpdateArticle(Article article){

        /*
            Delete data in intermediate table which
            id in blog table equals to
            blog_id in intermediate table
        */
        if (blogAndTagMapper.listByBlogId(article.getId()) != null){
            blogAndTagMapper.deleteByBlogId(article.getId());
        }

        article.setTags(tagService.getTagByString(article.getTagIds()));

        /*if tagList is not null，insert data to intermediate table*/
        List<Tag> tagList = article.getTags();
        if (tagList != null){
            for (Tag tag : tagList) {
                blogAndTagMapper.addBlogAndTag(new BlogAndTag(tag.getId(), article.getId()));
            }
        }

        articleService.updateArticle(article);

        return "redirect:/admin/articleMgmt";
    }



}
