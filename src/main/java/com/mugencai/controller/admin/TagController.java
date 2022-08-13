package com.mugencai.controller.admin;

import com.mugencai.pojo.Tag;
import com.mugencai.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    //显示所有tag
    @RequestMapping("/tagMgmt")
    public String listTag(Model model){
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);
        return "/admin/tagMgmt";
    }

    //跳转到tagInput页面
    @RequestMapping("/tagInput")
    public String toTagInput(){
        return "/admin/tagInput";
    }

    //增加tag
    @PostMapping("/tagInput")
    public String tagInput(Tag tag, Model model){
        tagService.addTag(tag);
        model.addAttribute("tag",tag);
        return "redirect:/admin/tagMgmt";
    }

    //删除tag
    @RequestMapping("/deleteTag/{id}")
    public String deleteTag(@PathVariable("id") int id){
        tagService.deleteTag(id);
        return "redirect:/admin/tagMgmt";
    }

    //跳转到tagUpdate页面
    @RequestMapping("/tagUpdate/{id}")
    public String toUpdateTag(@PathVariable("id") int id, Model model){
        //查询原tag的信息
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return "/admin/tagUpdate";
    }

    //在tagUpdate页面修改tag
    @PostMapping("/tagUpdate")
    public String updateTag(Tag tag){
        tagService.updateTag(tag);
        System.out.println("here");
        return "redirect:/admin/tagMgmt";
    }



}
