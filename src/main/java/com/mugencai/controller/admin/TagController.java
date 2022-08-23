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

    //show all tags
    @RequestMapping("/tagMgmt")
    public String listTag(Model model){
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);
        return"admin/tagMgmt";
    }

    //jump to tagInput
    @RequestMapping("/tagInput")
    public String toTagInput(){
        return"admin/tagInput";
    }

    //add tag
    @PostMapping("/tagInput")
    public String tagInput(Tag tag, Model model){
        tagService.addTag(tag);
        model.addAttribute("tag",tag);
        return "redirect:/admin/tagMgmt";
    }

    //delete tag
    @RequestMapping("/deleteTag/{id}")
    public String deleteTag(@PathVariable("id") int id){
        tagService.deleteTag(id);
        return "redirect:/admin/tagMgmt";
    }

    //jump to tagUpdate
    @RequestMapping("/tagUpdate/{id}")
    public String toUpdateTag(@PathVariable("id") int id, Model model){
        //查询原tag的信息
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return"admin/tagUpdate";
    }

    //update tag
    @PostMapping("/tagUpdate")
    public String updateTag(Tag tag){
        tagService.updateTag(tag);
        return "redirect:/admin/tagMgmt";
    }

}
