package com.huni.service.impl;

import com.huni.pojo.Post;
import com.huni.mapper.PostMapper;
import com.huni.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
   @Autowired
   PostMapper postMapper;
    @Override
    public int insert(Post post) {
        return postMapper.insert(post);
    }
}
