package com.huni.service.impl;

import com.huni.pojo.Rubbish;
import com.huni.mapper.RubbishMapper;
import com.huni.service.RubbishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-04-29
 */
@Service
public class RubbishServiceImpl extends ServiceImpl<RubbishMapper, Rubbish> implements RubbishService {
    @Autowired
    RubbishMapper rubbishMapper;
    @Override
    public int insert(Rubbish rubbish) {
        return rubbishMapper.insert(rubbish);
    }
}
