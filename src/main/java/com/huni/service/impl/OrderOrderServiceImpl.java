package com.huni.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huni.pojo.OrderOrder;
import com.huni.mapper.OrderOrderMapper;
import com.huni.service.OrderOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huni.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-04-24
 */
@Service
public class OrderOrderServiceImpl extends ServiceImpl<OrderOrderMapper, OrderOrder> implements OrderOrderService {
    @Autowired
    OrderOrderMapper orderMapper;

    @Override
    public List<OrderOrder> listByUId(Long id,int status) {
        String o_status = "未付款";
        if (status==1) {
            o_status = "未付款";
        } else if (status==2) {
            o_status = "已提交";
        } else if (status==3) {
            o_status = "已接单";
        }else if (status==4){
            o_status = "已完成";
        }else if (status==5){
            o_status = "已取消";
        }
        QueryWrapper<OrderOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",id).eq("o_status",o_status).orderByDesc("create_time");
        return orderMapper.selectList(wrapper);
    }
    public int insert(OrderOrder order){
        return orderMapper.insert(order);
    }

    @Override
    public List<OrderVo> listOrder(Long u_id, int status) {
        String o_status = "未付款";
        if (status==1) {
            u_id=null;
            o_status = "已提交";
        } else if (status==2) {
            o_status = "已接单";
        }else if (status==3){
            o_status = "已完成";
        }
        Map<String,Object> params = new HashMap<>();
        params.put("u_id",u_id);
        params.put("o_status",o_status);
        return orderMapper.listUdertakeOrder(params);
    }
}
