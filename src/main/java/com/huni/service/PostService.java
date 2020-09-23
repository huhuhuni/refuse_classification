package com.huni.service;

import com.huni.pojo.Post;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huni
 * @since 2020-05-02
 */
public interface PostService extends IService<Post> {
     int insert(Post post);
}
