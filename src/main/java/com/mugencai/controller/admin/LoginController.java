package com.mugencai.controller.admin;


import com.mugencai.pojo.User;
import com.mugencai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(){
        return "/admin/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession httpSession,
            RedirectAttributes redirectAttributes){

        User user = userService.queryByUserNameAndPassWord(username, password);

        if (user != null){
            user.setPassword(null);
            httpSession.setAttribute("user", username);
            return "/admin/index";
        }else {
            redirectAttributes.addFlashAttribute("message","用户名或者密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/admin";
    }


}
