package com.springboot.adminex.controller;

import com.springboot.adminex.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        if (!(StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword()))) {
            model.addAttribute("msg", "账号密码错误!");
            return "/login";
        }
        session.setAttribute("loginUser", user);
        return "redirect:index.html";
    }

    @RequestMapping({"/index.html","index"})
    public String indexPage(HttpSession session, Model model) {
//        if (session.getAttribute("loginUser") == null) {
//            model.addAttribute("msg", "未登录,请重新登录!");
//            return "/login";
//        }
        return "index";
    }

}
