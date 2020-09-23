package com.huni.controller;


import com.huni.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huni
 * @since 2020-05-03
 */
@Controller
@RequestMapping("/bulletin")
public class BulletinController {
    @Autowired
    BulletinService bulletinService;
    @GetMapping("/list")
    public String bulletin(Model model){
      model.addAttribute("bulletins",bulletinService.list(null));
    return "bulletin";
}
}

