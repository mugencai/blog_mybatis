package com.mugencai.controller;

import com.mugencai.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class ArchiveShowController {

    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/archive")
    public String archiveShow(Model model){
        List<String> yearList = articleMapper.getGroupYear();
        HashMap<Object, Object> map = new HashMap<>();
        for (String year : yearList) {
            map.put(year, articleMapper.listArticleByYear(year));
        }
        model.addAttribute("map", map);
        return "/archive";
    }

}
