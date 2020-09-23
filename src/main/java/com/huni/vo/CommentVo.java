package com.huni.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.huni.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long postId;

    private Long userId;

    private String content;

    private Date createTime;

    @TableLogic
    private Boolean deleted;

    private User user;

}
