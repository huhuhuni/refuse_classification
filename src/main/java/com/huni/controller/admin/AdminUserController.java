package com.huni.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.User;
import com.huni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    UserService userService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users",userService.list(null));
        return "admin/user_list";
    }
    @PostMapping("/search")
    public String search(Model model,String username){
        model.addAttribute("users",userService.list(new QueryWrapper<User>().like("username",username)));
        return "admin/user_list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        boolean flag=userService.removeById(id);
        if(flag==true){
            attributes.addFlashAttribute("message","用户删除成功");
        }else {
            attributes.addFlashAttribute("message","用户删除失败");
        }
        return "redirect:/admin/user/list";
    }
}