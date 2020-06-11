package com.lingyun.study.springsecurity.common;


import com.lingyun.study.springsecurity.domain.user.entity.User;
import com.lingyun.study.springsecurity.domain.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {
        "com.lingyun.**.controller",
        "com.lingyun.**.service",
        "com.lingyun.**.config"})
@ServletComponentScan("com.lingyun.**.filter")
@EnableJpaRepositories(basePackages = {"com.lingyun.**.repo"})
@EntityScan(basePackages ={"com.lingyun.**.entity"})
public class Application implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext ctx=contextRefreshedEvent.getApplicationContext();

        UserService userService = ctx.getBean("userService", UserService.class);

        if (userService.count()==0){
            User zhangsan=new User();
            zhangsan.setName("zhangsan");
            zhangsan.setPassword("123");
            userService.save(zhangsan);
            User lisi=new User();
            zhangsan.setName("lisi");
            zhangsan.setPassword("123");
            userService.save(lisi);

        }
    }

}
