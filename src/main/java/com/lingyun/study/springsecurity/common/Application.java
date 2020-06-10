package com.lingyun.study.springsecurity.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {
        "com.lingyun.**.controller",
        "com.lingyun.**.service",
        "com.lingyun.**.config"})
@ServletComponentScan("com.lingyun.**.filter")
@EnableJpaRepositories(basePackages = {"com.lingyun.**.repo"})
@EntityScan(basePackages ={"com.lingyun.**.entity"})
public class Application{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
