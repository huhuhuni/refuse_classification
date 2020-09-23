package com.huni.service;

import com.huni.pojo.Bulletin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huni
 * @since 2020-05-03
 */
public interface BulletinService extends IService<Bulletin> {
  int insert(Bulletin bulletin);
}
