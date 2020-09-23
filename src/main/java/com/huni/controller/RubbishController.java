package com.huni.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.Rubbish;
import com.huni.service.RubbishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huni
 * @since 2020-04-29
 */
@Controller
@RequestMapping("/rubbish")
public class RubbishController {
    @Autowired
    RubbishService rubbishService;
    @GetMapping("/search")
    public String search(){
        return "search";
    }
    @PostMapping ("/doSearch")
    public String doSearch(Model model,String name){
        model.addAttribute("rubbishes",rubbishService.list(new QueryWrapper<Rubbish>().like("name","%"+name+"%")));
        return "search :: rubbishList";
    }
}

