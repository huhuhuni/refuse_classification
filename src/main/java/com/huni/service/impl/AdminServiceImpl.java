package com.huni.service.impl;

import com.huni.pojo.Admin;
import com.huni.mapper.AdminMapper;
import com.huni.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-05-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
