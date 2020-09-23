package com.huni.mapper;

import com.huni.pojo.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huni.vo.CommentVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
@Component
public interface CommentMapper extends BaseMapper<Comment> {
     List<CommentVo> listCommentByPostId(Long id);
}
