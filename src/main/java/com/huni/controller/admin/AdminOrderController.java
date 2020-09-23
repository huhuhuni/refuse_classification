package com.huni.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.OrderOrder;
import com.huni.service.OrderOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
   @Autowired
    OrderOrderService orderService;
   @GetMapping("/list")
   public String list(Model model){
       model.addAttribute("orders",orderService.list(null));
       return "admin/order";
   }
    @GetMapping("/delete/{id}")
    public String deleted(@PathVariable Long id, RedirectAttributes attributes){
        boolean flag=orderService.removeById(id);
        if(flag==true){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/order/list";
    }
    @GetMapping("/cancel/{id}")
    public  String cancel(@PathVariable Long id,RedirectAttributes redirectAttributes){
        OrderOrder order = orderService.getById(id);
        order.setOStatus("已取消");
        orderService.update(order,new QueryWrapper<OrderOrder>().eq("id",id));
        redirectAttributes.addFlashAttribute("message","取消成功");
        return "redirect:/admin/order/list";
    }
}
