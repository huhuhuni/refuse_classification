package com.huni.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.Comment;
import com.huni.pojo.Post;
import com.huni.pojo.User;
import com.huni.service.CommentService;
import com.huni.service.PostService;
import com.huni.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 *
 * </p>
 * 论坛
 * @author huni
 * @since 2020-05-02
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("posts",postService.list(null));
        return "discuss_list";
    }
    @GetMapping("/list/{id}")
    public String list(Model model,@PathVariable Long id){
        model.addAttribute("posts",postService.list(new QueryWrapper<Post>().eq("user_id",id)));
        return "discuss_list";
    }
    @GetMapping("/{id}/page")
    public String page(Model model, @PathVariable Long id){
        Post post = postService.getById(id);
        User user = userService.getById(post.getUserId());
        user.setPassword(null);
        model.addAttribute("post",post);
        model.addAttribute("user",user);
        model.addAttribute("comments",commentService.listCommentByPostId(id));
        return "discuss_page";
    }
    @GetMapping("/add")
    public String add(){
        return "discuss_post";
    }
    @PostMapping("/add")
    public String do_add(RedirectAttributes attributes, Post post, HttpServletRequest request){
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            post.setUserId(user.getId());
            int insert = postService.insert(post);
            if(insert==1){
                attributes.addFlashAttribute("message","发帖成功");
            }else {
                attributes.addFlashAttribute("message","发帖失败");
            }
            return "redirect:/post/list";
        }
       return "redirect:/login";

    }
}

