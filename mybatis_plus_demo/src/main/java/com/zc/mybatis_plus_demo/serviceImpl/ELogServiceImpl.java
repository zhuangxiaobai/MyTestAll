package com.zc.mybatis_plus_demo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.mybatis_plus_demo.entity.ELog;
import com.zc.mybatis_plus_demo.mapper.ELogMapper;
import com.zc.mybatis_plus_demo.service.ELogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zc
 * @since 2020-11-24
 */
@Service
public class ELogServiceImpl extends ServiceImpl<ELogMapper, ELog> implements ELogService {

    @Autowired
    private ELogMapper eLogMapper;



    @Override
    public Map selectTest() {

        Page<ELog> page = new Page();
        page.setSize(2);
        page.setCurrent(1);
        // page.setSearchCount(false);
        QueryWrapper queryWrapper = new QueryWrapper(null);
        Page<ELog> page1 = eLogMapper.selectPage(page, queryWrapper);

        Map map = new HashMap();
        map.put("aaa",page1);


        return map;
    }
}
