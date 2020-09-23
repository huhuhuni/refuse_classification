package com.huni.service;

import com.huni.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huni.vo.CommentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
public interface CommentService extends IService<Comment> {
          List<CommentVo> listCommentByPostId(Long id);
          int insert(Comment comment);
}
