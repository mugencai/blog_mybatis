package com.mugencai.controller.admin;

import com.mugencai.pojo.Type;
import com.mugencai.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //jump to typeInput
    @RequestMapping("/typeInput")
    public String toTypeInput() {
        return "/admin/typeInput"; //返回templates/admin/typeInput.html
    }

    //jump to typeMgmt
    @PostMapping("/typeInput")
    public String typeInput(Type type) {
        typeService.addType(type);
        return "redirect:/admin/typeMgmt";
    }

    //show all types
    @RequestMapping("/typeMgmt")
    public String typeMgmt(Model model) {
        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList", typeList);
        return "/admin/typeMgmt";
    }

    //delete type by typeId
    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") String id) {
        typeService.deleteType(Integer.parseInt(id));
        return "redirect:/admin/typeMgmt";
    }


    //jump to typeUpdate
    @RequestMapping("/typeUpdate/{id}")
    public String toTypeUpdate(@PathVariable("id") int id, Model model) {
        //get type before modification
        Type type = typeService.getType(id);
        model.addAttribute("type", type);
        return "/admin/typeUpdate";
    }

    //update type
    @RequestMapping("/typeUpdate")
    public String typeUpdate(Type type) {
        typeService.updateType(type);
        return "redirect:/admin/typeMgmt";
    }


}