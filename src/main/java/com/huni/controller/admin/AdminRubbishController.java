package com.huni.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.Rubbish;
import com.huni.pojo.User;
import com.huni.service.RubbishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/rubbish")
public class AdminRubbishController {
    @Autowired
    RubbishService rubbishService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("rubbishes",rubbishService.list(null));
        return "admin/laji";
    }
    @PostMapping("/search")
    public String search(Model model,String name){
        model.addAttribute("rubbishes",rubbishService.list(new QueryWrapper<Rubbish>().like("name",name)));
        return "admin/laji";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        boolean flag=rubbishService.removeById(id);
        if(flag==true){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/rubbish/list";
    }
    @GetMapping("/add")
    public String add(){
        return "admin/laji_post";
    }
    @PostMapping("/add")
    public String doAdd(HttpServletRequest request, RedirectAttributes attributes,Rubbish rubbish){
        int insert = rubbishService.insert(rubbish);
        if(insert==1){
            attributes.addFlashAttribute("message","添加成功");
        }else {
            attributes.addFlashAttribute("message","添加失败");
        }
        return "redirect:/admin/rubbish/list";
    }
}