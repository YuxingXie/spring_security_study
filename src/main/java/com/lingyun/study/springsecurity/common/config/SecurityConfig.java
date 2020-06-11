package com.lingyun.study.springsecurity.common.config;

import com.lingyun.study.springsecurity.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity //启用web安全性
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private DataSource dataSource;

    @Resource
    private UserService userService;


    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .and().httpBasic();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 用户信息存储在内存
         * @param auth
         * @throws Exception

        auth.inMemoryAuthentication()
                //对应表单的username
                .withUser("zhangsan")
                //对应表单的password
                .password("123")
                //roles方法是给用户授权，不是校验角色
                .roles("USER")
                .and()
                .withUser("lisi")
                .password("123")
                .roles("USER","ADMIN");
        System.out.println("configure once");
         */


        auth.jdbcAuthentication().dataSource(dataSource).and()
        //使用userDetailsService(..)方法可以使用jpa查询而非使用sql查询，有机的将spring-data-jpa和spring-security整合
        .userDetailsService(userService);

    }
}
