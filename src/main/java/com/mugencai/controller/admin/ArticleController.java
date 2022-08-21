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

        //给article中的List<Tag>赋值
        article.setTags(tagService.getTagByString(article.getTagIds()));

        /*
            必须按照先添加文章，再添加blog_tags数据表中的数据来，
            原因是外键在blog_tags数据表上，先添加blog_tags数据表中数据会报错
         */

        //先在blog数据表中添加文章
        articleService.addArticle(article);

        /*如果文章的标签列表不为空，就循环遍历，依次将blog_id和tag_id插入到blog_tags数据表中*/
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

        /*如果blog_tags中存在blog_id为文章id的情况，就删除blog_tags中所有blog_id为文章id的记录*/
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
    public String UpdateArticle(Article article){ /*注意：这里的article是前端传来的article*/

        /*如果blog_tags中存在blog_id为文章id的情况，就删除blog_tags中所有blog_id为文章id的记录*/
        if (blogAndTagMapper.listByBlogId(article.getId()) != null){
            blogAndTagMapper.deleteByBlogId(article.getId());
        }

        //给article中的List<Tag>赋值
        article.setTags(tagService.getTagByString(article.getTagIds()));
        /*如果文章的标签列表不为空，就循环遍历，依次将blog_id和tag_id插入到blog_tags数据表中*/
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
