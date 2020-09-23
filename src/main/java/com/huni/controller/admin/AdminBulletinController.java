package com.huni.controller.admin;

import com.huni.pojo.Bulletin;
import com.huni.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/bulletin")
public class AdminBulletinController {
    @Autowired
    BulletinService bulletinService;
    @PostMapping("/add")
    public String doAdd(Bulletin bulletin, RedirectAttributes attributes){
        int insert = bulletinService.insert(bulletin);
        if(insert==1){
            attributes.addFlashAttribute("message","发布成功");
        }else {
            attributes.addFlashAttribute("message","发布失败");
        }
        return "redirect:/admin/bulletin/add";
    }
    @GetMapping("/add")
    public String add(){
        return "admin/bulletin_post";
    }

    @GetMapping("/list")
    public String bulletin(Model model){
        model.addAttribute("bulletins",bulletinService.list(null));
        return "admin/bulletin";
    }
    @GetMapping("/delete/{id}")
    public String deleted(@PathVariable Long id,RedirectAttributes attributes){
       boolean flag=bulletinService.removeById(id);
        if(flag==true){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/bulletin/list";
    }
}