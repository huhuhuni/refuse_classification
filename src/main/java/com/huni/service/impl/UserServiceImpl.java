package com.huni.service.impl;

import com.huni.pojo.User;
import com.huni.mapper.UserMapper;
import com.huni.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-04-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    public int insert(User user){
        return userMapper.insert(user);
    }
}
