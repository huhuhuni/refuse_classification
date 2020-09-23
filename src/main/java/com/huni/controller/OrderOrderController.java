package com.huni.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.mapper.OrderOrderMapper;
import com.huni.pojo.OrderOrder;
import com.huni.pojo.User;
import com.huni.service.OrderOrderService;
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
 * </p>
 *
 * @author huni
 * @since 2020-04-24
 */
@Controller
@RequestMapping("/order")
public class OrderOrderController {
    @Autowired
    OrderOrderService orderService;

    @GetMapping("/list/{status}")
    public  String order_list_by_status(Model model,@PathVariable int status,HttpServletRequest request){
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");

            model.addAttribute("orders",orderService.listByUId(user.getId(),status));
            model.addAttribute("statusActive",status);
       // System.out.println(orderMapper.listOrder());
       // System.out.println(orderMapper.selectList(null));
        return "order_list :: orderList";}
        return "redirect:/login";
    }
    @GetMapping("/list")
    public  String order_list(Model model,HttpServletRequest request){
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            model.addAttribute("orders",orderService.listByUId(user.getId(),1));
            model.addAttribute("statusActive",1);
            // System.out.println(orderMapper.listOrder());
            // System.out.println(orderMapper.selectList(null));
            return "order_list";
        }
        return "redirect:/login";
    }
    //取消订单
    @GetMapping("/{id}/cancel")
    public  String cancel(@PathVariable Long id,RedirectAttributes redirectAttributes){
        OrderOrder order = orderService.getById(id);
        order.setOStatus("已取消");
        orderService.update(order,new QueryWrapper<OrderOrder>().eq("id",id));
        redirectAttributes.addFlashAttribute("message","取消成功");
        return "redirect:/order/list";
    }

    //确认完成订单
    @GetMapping("/{id}/finish")
    public  String finish(@PathVariable Long id,RedirectAttributes redirectAttributes){
        OrderOrder order = orderService.getById(id);
        order.setOStatus("已完成");
        orderService.update(order,new QueryWrapper<OrderOrder>().eq("id",id));
        redirectAttributes.addFlashAttribute("message","好的，这个订单完成了。");
        return "redirect:/order/list";
    }
    //添加订单
    @GetMapping("/add")
    public String add(){

        return "order_create";
    }
    @PostMapping("/add")
    public String post_add(OrderOrder order,RedirectAttributes redirectAttributes,HttpServletRequest request){
       // order.setUId());
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            order.setUId(user.getId());
        }

        order.setOStatus("已提交");
        int insert = orderService.insert(order);
        if(insert==1){
            redirectAttributes.addFlashAttribute("message","订单提交成功");
        }else {
            redirectAttributes.addFlashAttribute("message","订单提交失败");
        }
        return "redirect:/order/list";
    }
   //接单信息列表
   @GetMapping("/undertake")
   public String undertake(Model model,Long u_id,HttpServletRequest request){
       //列出可以接的订单、已接的订单、已完成的订单
           model.addAttribute("orders", orderService.listOrder(null,1));
           model.addAttribute("statusActive",1);
           return "order_undertake";
   }
    @GetMapping("/undertake/{status}")
    public String undertake_list_by_status(Model model,@PathVariable int status,Long u_id,HttpServletRequest request){
        //列出可以接的订单、已接的订单、已完成的订单
        if(request.getSession().getAttribute("user")!=null) {
            User user = (User) request.getSession().getAttribute("user");
            model.addAttribute("orders", orderService.listOrder(user.getId(), status));
            model.addAttribute("statusActive",status);
            return "order_undertake ::undertakeList";
        }
        else return "redirect:/login";
    }
   //接下这个id的订单
    @GetMapping("/{id}/undertake")
    public  String undertake(@PathVariable Long id,RedirectAttributes redirectAttributes,HttpServletRequest request){
        OrderOrder order = orderService.getById(id);
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            if(user.getId()==order.getUId()){
                redirectAttributes.addFlashAttribute("message","不能接自己的订单");
                return "redirect:/order/undertake";
            }else{
                order.setUndertakeUId(user.getId());
                order.setOStatus("已接单");
                orderService.update(order,new QueryWrapper<OrderOrder>().eq("id",id));
                redirectAttributes.addFlashAttribute("message","接单成功，可到待完成查看。");
                return "redirect:/order/undertake";
            }
        }
            return "redirect:/login";
        }

}

