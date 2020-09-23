package com.huni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String login(){
        return "sign";
    }
    @GetMapping("/")
    public String register(){
        return "index";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
    @GetMapping("/register")
    public String index(){
        return "register";
    }
}