package com.huni.service;

import com.huni.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huni
 * @since 2020-04-27
 */
public interface UserService extends IService<User> {
    public int insert(User user);
}
