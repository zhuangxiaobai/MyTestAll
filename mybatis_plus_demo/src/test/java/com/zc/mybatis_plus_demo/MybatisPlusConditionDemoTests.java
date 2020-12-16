package com.zc.mybatis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.zc.mybatis_plus_demo.entity.EVote;
import com.zc.mybatis_plus_demo.mapper.EVoteMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;


@SpringBootTest
public class MybatisPlusConditionDemoTests {



    @Autowired
    private EVoteMapper eVoteMapper;

    /*
       例子： mapper 中的 crud 操作
    */

    @Test
    void contextLoads() {

        // 根据 entity 条件，查询全部记录
        QueryWrapper<EVote> queryWrapper = new QueryWrapper<EVote>();
        Map map = new HashMap(){{
            put("id",1);
            put("name",null);
        }};
        //---allEq--全等---------------
        //包含is null
        //queryWrapper.allEq(map);
        //忽略is null的条件
        //queryWrapper.allEq(map,false);
        //condition起到一个条件开关的功能
        //queryWrapper.allEq(false,map,true);

        //当满足条件的时候，查询条件生效
        /*BiPredicate b = new BiPredicate() {
            @Override
            public boolean test(Object o, Object o2) {

                return o.equals("id")&& (1==(Integer) o2);
            }
        };*/
        //写法1
        /*queryWrapper.allEq(
                (k, v) -> {
                    return k.equals("id")&& (1==(Integer) v);
                } ,map);*/
        //写法2
        //queryWrapper.allEq(b,map);
        //加入null2IsNull 的写法
        //queryWrapper.allEq(b,map,false);
        //加入null2IsNull 的写法,和condition开关
        //queryWrapper.allEq(true,b,map,false);

        //List<EVote> votes  = eVoteMapper.selectList(queryWrapper);
         //---allEq--结束--------------------

         //--eq--相等---
        //queryWrapper.eq("name","asd");
        //queryWrapper.eq(true,"name","aa");
        //-----------

        //--ne----不等
       // queryWrapper.ne("name","asd");
       // queryWrapper.ne(true,"name","asd");
       //------------

        //--gt----大于
        // queryWrapper.gt("name","asd");
        // queryWrapper.gt(true,"name","aa");
        //------------

        //--ge----大于等于
        // queryWrapper.ge("name","asd");
        //queryWrapper.ge(true,"name","aa");
        //------------

        //--lt----小于
        // queryWrapper.lt("name","asd");
        //queryWrapper.lt(true,"name","aa");
        //------------

        //--le----小于等于
         //queryWrapper.le("name","asd");
        //queryWrapper.le(true,"name","aa");
        //------------

        //--between----
        //queryWrapper.between("type",0,2);
        //queryWrapper.between(false,"type",0,2);
        //------------

        //--notBetween----
        //queryWrapper.notBetween("type",0,2);
        //queryWrapper.notBetween(false,"type",0,2);
        //------------

        //--like-----前后都有%--
        //queryWrapper.like("name","a");
       // queryWrapper.like(false,"name","a");
        //--------------

        //--notLike-----前后都有%--
        //queryWrapper.notLike("name","a");
        // queryWrapper.notLike(false,"name","a");
        //--------------

        //--likeLeft-----左边有%--
        //queryWrapper.likeLeft("name","a");
        // queryWrapper.likeLeft(false,"name","a");
        //--------------

        //--likeRight-----右边有%--
        //queryWrapper.likeRight("name","a");
        // queryWrapper.likeRight(false,"name","a");
        //--------------

        //--isNull-------
        //queryWrapper.isNull("name");
        // queryWrapper.isNull(false,"name");
        //--------------

       //--isNotNull-------
        //queryWrapper.isNotNull("name");
        // queryWrapper.isNotNull(false,"name");
        //--------------


        //--in-------
        //queryWrapper.in("type",new ArrayList(){{add(1);add(10);}});
        // queryWrapper.in(false,"type",new ArrayList(){{add(1);add(10);}});
        //queryWrapper.in("type",1,2,10);
        //queryWrapper.in(false,"type",1,2,10);
        //--------------

        //--notIn-------
        //queryWrapper.notIn("type",new ArrayList(){{add(1);add(10);}});
        // queryWrapper.notIn(false,"type",new ArrayList(){{add(1);add(10);}});
        //queryWrapper.notIn("type",1,2,10);
        //queryWrapper.notIn(false,"type",1,2,10);
        //--------------

        //--inSql-------
        //queryWrapper.inSql("type","select type from e_vote" );
        //queryWrapper.inSql(false,"type","select type from e_vote" );
        //--------------

        //--notInSql-------
        //queryWrapper.notInSql("type","select type from e_vote" );
        //queryWrapper.notInSql(false,"type","select type from e_vote" );
        //--------------

        //--groupBy-------
        //queryWrapper.select("name").groupBy("name");
        //queryWrapper.select("name").groupBy(false,"name");
        //--------------

        //--orderByAsc---
        //queryWrapper.orderByAsc("name");
        //queryWrapper.orderByAsc(false,"name");
        //--------------

        //--orderByDesc---
        //queryWrapper.orderByDesc("name");
        //queryWrapper.orderByDesc(false,"name");
        //--------------

        //--orderBy---
        //queryWrapper.orderBy(true,true,"name");
        //--------------

        //--having---要和grouBy一起使用
        //queryWrapper.select("name").groupBy("name").having("sum(type) > 9");
        //{1}对应后面的位置，下标为1的，从0开始
        //queryWrapper.select("name").groupBy("name").having("sum(type) > {1}",1,11);
        //--------------

        //--func----方法(主要方便在出现if...else下调用不同方法能不断链)-----
        /*QueryWrapper func = queryWrapper.func(i -> {
            if (true) {
                i.eq("id", 2);
            } else {
                i.ne("id", 1);
            }
        });
        List<EVote> votes  = eVoteMapper.selectList(func);
        List<EVote> votes  = eVoteMapper.selectList(false,func);
        */
        //------------------------

        //--or---不加or默认and----
       //queryWrapper.eq("id",1).or().eq("name","asd");
       // queryWrapper.eq("id",1).or(false).eq("name","asd");
        // queryWrapper.eq("name","asd").or(i->i.eq("id",1).ne("name","aa"));//i就代表wrapper
        //queryWrapper.eq("name","asd").or(false,i->i.eq("id",1).ne("name","aa"));
        //------------------------

        //--and-------------------
        //queryWrapper.and(i->i.eq("name","aa").or().ne("id",1));
        //queryWrapper.and(false,i->i.eq("name","aa").or().ne("id",1));
        //------------------------

        //--nested-正常嵌套--不带AND或者OR是个()
        // queryWrapper.nested(i->i.eq("id",1).or().eq("name","asd")).eq("name","aa");
        // queryWrapper.nested(false,i->i.eq("id",1).or().eq("name","asd")).eq("name","aa");
        //-------------------------------

        //--apply------拼接sql，使用{0}形式防止sql注入--------
        // queryWrapper.apply("id={0} and name= {1}",1,"aa");
        // queryWrapper.apply(false,"id={0} and name= {1}",1,"aa");
        //-------------------------------

        //--last------无视优化规则直接拼接到 sql 的最后,多次调用以最后一次为准 有sql注入的风险--------
        // queryWrapper.last("limit 1,3");
        // queryWrapper.last(false,"limit 1,3");
        //-------------------------------

        //--exists-------判断查询子句是否有记录-------
         //queryWrapper.exists("select id from e_vote where id = 1");
        // queryWrapper.exists(true,"select id from e_vote where id = 1");
        //-------------------------------

        //--notExists-------判断查询子句没有记录-------
        //queryWrapper.notExists("select id from e_vote where id = 1");
        // queryWrapper.notExists(true,"select id from e_vote where id = 1");
        //-------------------------------

        //-select-----设置查询的字段，queryWrapper专用----
        //只查询哪些字段
        //queryWrapper.select("id","name");
        //入参不包含 class 的调用前需要wrapper内的entity属性有值，去掉字段方法1
        /*EVote eVote = new EVote();
        eVote.setName("aa");
        queryWrapper.setEntity(eVote);
        Predicate<TableFieldInfo> tableFieldInfoPredicate = new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {

                return !tableFieldInfo.getColumn().equals("type") && !tableFieldInfo.getColumn().equals("name");
            }
        };
        queryWrapper.select(tableFieldInfoPredicate);*/
        //方法1写法2
        //queryWrapper.select(i->!i.getColumn().equals("name")&& !i.getColumn().equals("type"));

        //去掉字段方法2
        //去掉哪些字段如下操作，主键无法被去除
        //queryWrapper.select(EVote.class,i->!i.getColumn().equals("name")&& !i.getColumn().equals("type"));

        //List<EVote> votes  = eVoteMapper.selectList(queryWrapper);


       //UpdateWrapper-------------
       //set---设置值为---
        UpdateWrapper<EVote> updateWrapper = new UpdateWrapper<>();
       /* updateWrapper.set("name","lao").eq("id",1);
       // updateWrapper.set(false,"name","222");
        EVote eVote = new EVote();
        //eVote.setType(4);
        eVoteMapper.update(eVote,updateWrapper);//eVote也是设置值
       */

        /*updateWrapper.setSql("name='ac'");
                //.eq("id",1);
        EVote eVote = new EVote();
        //eVoteMapper.update(eVote,updateWrapper);//eVote也是设置值
        eVote.setId(1);
        eVote.setType(3);
        eVoteMapper.updateById(eVote);*/

        EVote eVote1 = eVoteMapper.selectById(1);
        EVote eVote2 = eVoteMapper.selectById(1);


         eVote1.setType(111);
        eVoteMapper.updateById(eVote1);

        eVote2.setType(222);
        eVoteMapper.updateById(eVote2);

    }







}
