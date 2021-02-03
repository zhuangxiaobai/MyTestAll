/*
package com.zc.spring_security_demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.zc.spring_security_demo.config.MyCustomDsl.customDsl;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .apply(customDsl())
                .flag(true)
                .and()
            ;
    }
}*/
