package com.huni.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.Admin;
import com.huni.pojo.User;
import com.huni.service.AdminService;
import com.huni.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    @Autowired
    AdminService adminService;
    @GetMapping("")
    public String index(){
        return "admin/index";
    }
    @GetMapping("/login")
    public String login(){
        return "admin/sign";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password, HttpSession session, HttpServletRequest request, RedirectAttributes attributes){
        Admin admin = adminService.getOne(new QueryWrapper<Admin>().eq("email", email).eq("password", MD5Utils.MD5(password)));
        if(admin!=null){
            // request.getSession().setAttribute("user",u);
            // session.setAttribute("user",u);
            admin.setPassword(null);
            session.setAttribute("admin",admin);
            return "admin/index";
        }else{
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin/login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/admin/login";
    }
}