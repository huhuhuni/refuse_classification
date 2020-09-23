package com.huni.controller;



import com.huni.pojo.Comment;
import com.huni.pojo.User;
import com.huni.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/add")
    public String add(Comment comment, HttpServletRequest request, RedirectAttributes attributes){
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            comment.setUserId(user.getId());
            int insert = commentService.insert(comment);
            if(insert==1){
                attributes.addFlashAttribute("message","评论成功");
            }else {
                attributes.addFlashAttribute("message","评论失败");
            }
            return "redirect:/post/"+comment.getPostId()+"/page";
        }
        return "redirect:/login";
    }

}

