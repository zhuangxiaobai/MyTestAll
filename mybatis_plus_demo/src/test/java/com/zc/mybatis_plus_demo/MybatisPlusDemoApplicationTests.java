package com.zc.mybatis_plus_demo;

import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
import java.util.List;
import java.util.Map;

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
        // 根据 ID 删除
       // eVoteMapper.deleteById(3);
        // 根据 columnMap 条件，删除记录
   /*    HashMap<String,Object> map = new HashMap<>();
        map.put("name","asd");
        eVoteMapper.deleteByMap(map);*/
       //---------------------------


        //修改----------------------
        // 根据 whereEntity 条件，更新记录
        /*UpdateWrapper<EVote> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name","asd");
        EVote eVote = new EVote();
        eVote.setType(10);
        eVoteMapper.update(eVote,updateWrapper);//前面是set的值，后面是条件 */
        // 根据 ID 修改
        /*EVote eVote = new EVote();
        eVote.setId(1);
        eVote.setType(12);
        eVoteMapper.updateById(eVote);
        */
        //---------------------------

        //查询------------------------
        // 根据 ID 查询
        //EVote eVote = eVoteMapper.selectById(1);
        // 根据 entity 条件，查询一条记录
          /*QueryWrapper<EVote>  queryWrapper = new QueryWrapper<>();
          queryWrapper.eq("id",1);
          eVoteMapper.selectOne(queryWrapper);
          */
        // 查询（根据ID 批量查询）
       /* ArrayList<Integer> idList = new ArrayList();
        idList.add(1);
        idList.add(2);
        List<EVote> eVotes  = eVoteMapper.selectBatchIds(idList);
      */
        // 根据 entity 条件，查询全部记录
        /*QueryWrapper<EVote>  queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","asd");
        List<EVote> votes  = eVoteMapper.selectList(queryWrapper);*/
        // 查询（根据 columnMap 条件）
        /*HashMap<String,Object> map = new HashMap<>();
        map.put("name","asd");
        eVoteMapper.selectByMap(map);*/
        // 根据 Wrapper 条件，查询全部记录
        /*QueryWrapper<EVote>  queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","asd");
        List<Map<String, Object>> mapList =  eVoteMapper.selectMaps(queryWrapper);
        */
        // 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
        /*QueryWrapper<EVote>  queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","asd");
        List<Object>  objects  = eVoteMapper.selectObjs(queryWrapper);
         */

        // 根据 entity 条件，查询全部记录（并翻页）(entity 和 wrapper条件叠加)
        /*Page<EVote> page = new Page();
        page.setSize(2);
        page.setCurrent(1);
//        page.setSearchCount(false);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","asd");
//        EVote eVote = new EVote();
//        eVote.setName("aaa");
//        queryWrapper.setEntity(eVote);
        Page<EVote> eVotePage = eVoteMapper.selectPage(page, queryWrapper);
        System.out.println(JSONUtil.parse(eVotePage).toString());
       */

        // 根据 Wrapper 条件，查询全部记录（并翻页）//默认是一页10条 页数第1页
        /*Page<Map<String, Object>> page = new Page<>();
//        page.setSize(2);
//        page.setCurrent(1);
//        page.setSearchCount(false);
        QueryWrapper<EVote> queryWrapper = new QueryWrapper();
 //       queryWrapper.eq("name","asd");
//        EVote eVote = new EVote();
//        eVote.setName("aaa");
//        queryWrapper.setEntity(eVote);
        Page<Map<String, Object>> mapPage  = eVoteMapper.selectMapsPage(page,queryWrapper);
        System.out.println(JSONUtil.parse(mapPage).toString());
        */

        // 根据 Wrapper 条件，查询总记录数
        /*QueryWrapper<EVote> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","asd");
        Integer  size = eVoteMapper.selectCount(queryWrapper);*/



    }

}
