package com.huni.service;

import com.huni.pojo.OrderOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huni.vo.OrderVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huni
 * @since 2020-04-24
 */
public interface OrderOrderService extends IService<OrderOrder> {
    List<OrderOrder> listByUId(Long id,int status);
    public int insert(OrderOrder order);
    //为接单列出订单
    List<OrderVo> listOrder(Long u_id,int status);
}
