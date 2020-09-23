package com.huni.vo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.huni.mapper.UserMapper;
import com.huni.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * </p>
 *
 * @author huni
 * @since 2020-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//@TableName(value = "order_order",resultMap = "orderResultMap")
public class OrderVo implements Serializable {

    //private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String oType;

    private Long uId;

    private String address;

    private String tel;

    private String price;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 状态
     */
    private String oStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单服务时间
     */
    private Date serviceTime;

    /**
     * 接单用户id
     */
    private Long undertakeUId;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;


     private User user;

}
