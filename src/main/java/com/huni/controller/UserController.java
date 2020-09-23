package com.huni.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.User;
import com.huni.service.UserService;
import com.huni.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huni
 * @since 2020-04-25
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password, HttpSession session, HttpServletRequest request, RedirectAttributes attributes){
        User user = userService.getOne(new QueryWrapper<User>().eq("email", email).eq("password", MD5Utils.MD5(password)));
        if(user!=null){
           // request.getSession().setAttribute("user",u);
           // session.setAttribute("user",u);
            user.setPassword(null);
            session.setAttribute("user",user);
            System.out.println(session.getId()+session.getAttribute("user"));
            return "index";
        }else{
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/login";
        }
    }

    @PostMapping("/register")
    public String register(User user, HttpSession session,RedirectAttributes attributes){
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        int insert = userService.insert(user);
        if(insert==1){
            attributes.addFlashAttribute("message","用户注册成功");
        }else {
            attributes.addFlashAttribute("message","用户注册失败");
        }
        return "redirect:/register";
    }

}

