package com.zc.mybatis_plus_demo.service;

import com.zc.mybatis_plus_demo.entity.ELog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zc
 * @since 2020-11-24
 */
public interface ELogService extends IService<ELog> {

    Map selectTest();
}
