package com.zc.spring_security_demo.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zc
 * @since 2021-01-19
 */
@Api(tags = {""})
@RestController
@RequestMapping("/e-user")
public class EUserController {




        @GetMapping("hello")
        public String hello() {
                return "hello spring security";
        }





        }

