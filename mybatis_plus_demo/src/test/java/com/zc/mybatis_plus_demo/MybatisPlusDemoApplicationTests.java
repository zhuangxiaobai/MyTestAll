package com.zc.mybatis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zc.mybatis_plus_demo.entity.ELog;
import com.zc.mybatis_plus_demo.entity.EVote;
import com.zc.mybatis_plus_demo.mapper.ELogMapper;
import com.zc.mybatis_plus_demo.mapper.EVoteMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
class MybatisPlusDemoApplicationTests {



    @Autowired
    private ELogMapper eLogMapper;

    @Autowired
    private EVoteMapper eVoteMapper;


    @Test
    void contextLoads() {
       //添加--------------
       /* EVote evote = new EVote();
        //evote.setId(2);
        evote.setCreatedAt(LocalDateTime.now());
        evote.setUpdatedAt(LocalDateTime.now());
        evote.setName("asd");
        evote.setStatus(3);
        evote.setType(4);
        eVoteMapper.insert(evote);*/
        //-------------------
        //删除-----------------如果设置了逻辑删除此处会变为逻辑删除
        //根据 entity 条件，删除记录
        /*QueryWrapper<EVote> wrapper = new QueryWrapper<>();
        wrapper.eq("id",3);
        eVoteMapper.delete(wrapper);*/
        // 删除（根据ID 批量删除）
      /*  ArrayList<Integer> idList = new ArrayList();
        idList.add(1);
        idList.add(2);
        eVoteMapper.deleteBatchIds(idList);*/
//        // 根据 ID 删除
       // eVoteMapper.deleteById(3);
//        // 根据 columnMap 条件，删除记录
   /*    HashMap<String,Object> map = new HashMap<>();
        map.put("name","asd");
        eVoteMapper.deleteByMap(map);*/
       //---------------------------

        //
//        EVote evote = new EVote();
//        evote.setId(2);
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name","bb");
//        queryWrapper.setEntity(evote);
//        eVoteMapper.selectList(queryWrapper);
//




     // QueryWrapper queryWrapper = new QueryWrapper();
        // eLogMapper.selectList();
    //      ELog eLog = eLogMapper.selectById(1);
    //      System.out.println(eLog.toString());

//
//            Page<ELog> page = new Page();
//            page.setSize(2);
//            page.setCurrent(1);
//           // page.setSearchCount(false);
//            QueryWrapper queryWrapper = new QueryWrapper(null);
//            Page<ELog> page1 = eLogMapper.selectPage(page, queryWrapper);
//            System.out.println(page1);




//
//
//            EVote evote = new EVote();
//            evote.setId(2);
//           UpdateWrapper<EVote> updateWrapper = new UpdateWrapper<>();
//           updateWrapper.set("deleted",1);
//
//           eVoteMapper.update(evote,updateWrapper);



    }

}
