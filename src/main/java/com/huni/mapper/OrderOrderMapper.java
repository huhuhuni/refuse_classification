package com.huni.mapper;

import com.huni.pojo.OrderOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huni.vo.OrderVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huni
 * @since 2020-04-24
 */
@Component
public interface OrderOrderMapper extends BaseMapper<OrderOrder> {
   List<OrderOrder> listOrder();

    List<OrderVo> listUdertakeOrder(Map params);

}
