package com.huni.controller.admin;

import com.huni.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/post")
public class AdminPostController {
    @Autowired
    PostService postService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("posts",postService.list(null));
        return "admin/discuss";
    }
    @GetMapping("/delete/{id}")
    public String deleted(@PathVariable Long id, RedirectAttributes attributes){
        boolean flag=postService.removeById(id);
        if(flag==true){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/post/list";
    }
}