package com.zc.spring_security_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.zc.spring_security_demo.mapper"})
public class ZcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcApplication.class, args);
    }

}
