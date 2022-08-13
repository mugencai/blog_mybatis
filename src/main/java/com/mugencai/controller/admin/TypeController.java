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


//templates下所有的页面只能通过controller来跳转
//跳转这个需要模板引擎的支持 thymeleaf
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //在typeMgmt页面，点击"新增"按钮，跳转到typeInput页面
    @RequestMapping("/typeInput")
    public String toTypeInput() {
        return "/admin/typeInput"; //返回templates/admin/typeInput.html
    }

    //在typeInput页面，输入内容，点击"添加",返回typeMgmt页面
    @PostMapping("/typeInput")
    public String typeInput(Type type) {
        typeService.addType(type);
        return "redirect:/admin/typeMgmt";
    }


    //在typeMgmt页面，显示所有type
    @RequestMapping("/typeMgmt")
    public String typeMgmt(Model model) {
        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList", typeList);
        return "/admin/typeMgmt";
    }

    //在typeMgmt页面，删除指定id的类别
    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") String id) {
        typeService.deleteType(Integer.parseInt(id));
        return "redirect:/admin/typeMgmt";
    }


    //在typeMgmt页面，点击"修改"按钮，跳转到typeUpdate页面
    @RequestMapping("/typeUpdate/{id}")
    public String toTypeUpdate(@PathVariable("id") int id, Model model) {
        //获取原来的type对象
        Type type = typeService.getType(id);
        model.addAttribute("type", type);
        return "/admin/typeUpdate"; //返回templates/admin/typeUpdate.html
    }

    //在typeUpdate页面修改种类，之后返回typeMgmt页面
    @RequestMapping("/typeUpdate")
    public String typeUpdate(Type type) {
        typeService.updateType(type);
        return "redirect:/admin/typeMgmt";
    }


}