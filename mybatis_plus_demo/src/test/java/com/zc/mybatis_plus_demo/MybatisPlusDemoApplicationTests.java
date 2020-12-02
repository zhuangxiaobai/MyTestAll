package com.zc.mybatis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.mybatis_plus_demo.entity.ELog;
import com.zc.mybatis_plus_demo.mapper.ELogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDemoApplicationTests {



    @Autowired
    private ELogMapper eLogMapper;

    @Test
    void contextLoads() {

     // QueryWrapper queryWrapper = new QueryWrapper();
        // eLogMapper.selectList();
    //      ELog eLog = eLogMapper.selectById(1);
    //      System.out.println(eLog.toString());


            Page<ELog> page = new Page();
            page.setSize(2);
            page.setCurrent(1);
           // page.setSearchCount(false);
            QueryWrapper queryWrapper = new QueryWrapper(null);
            Page<ELog> page1 = eLogMapper.selectPage(page, queryWrapper);
            System.out.println(page1);






    }

}
