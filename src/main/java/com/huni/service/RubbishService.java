package com.huni.service;

import com.huni.pojo.Rubbish;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huni
 * @since 2020-04-29
 */
public interface RubbishService extends IService<Rubbish> {
    int insert(Rubbish rubbish);
}
