package com.huni.service.impl;

import com.huni.pojo.Bulletin;
import com.huni.mapper.BulletinMapper;
import com.huni.service.BulletinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huni
 * @since 2020-05-03
 */
@Service
public class BulletinServiceImpl extends ServiceImpl<BulletinMapper, Bulletin> implements BulletinService {
    @Autowired
    BulletinMapper bulletinMapper;
    @Override
    public int insert(Bulletin bulletin) {
        return bulletinMapper.insert(bulletin);
    }
}
