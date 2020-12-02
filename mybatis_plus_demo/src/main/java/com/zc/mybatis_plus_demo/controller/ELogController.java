package com.zc.mybatis_plus_demo.controller;


import com.zc.mybatis_plus_demo.service.ELogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zc
 * @since 2020-11-24
 */
@RestController
@Api(tags = "ELogController", description = "测试接口")
@RequestMapping("/e-log")
public class ELogController {


    @Autowired
    private ELogService eLogService;


    @ApiOperation(value = "测试用")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map goodslistIndex(){

        return eLogService.selectTest();

    }

}

