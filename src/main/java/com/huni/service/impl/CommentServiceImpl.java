package com.huni.service.impl;

import com.huni.pojo.Comment;
import com.huni.mapper.CommentMapper;
import com.huni.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huni.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<CommentVo> listCommentByPostId(Long id) {
        return commentMapper.listCommentByPostId(id);
    }

    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }
}
