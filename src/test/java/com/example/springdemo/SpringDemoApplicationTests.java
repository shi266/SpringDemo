package com.example.springdemo;

import com.example.springdemo.com.entity.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringDemoApplicationTests {
        Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //日志级别 由低到高
        logger.trace("trace 级别日志");
        logger.debug("debug 级别日志");
        logger.info("info 级别日志");
        logger.warn("warn 级别日志");
        logger.error("error 级别日志");
      /*  System.out.println(ioc.getApplicationName());
        if(ioc.containsBean("RecruitmentInformation")){
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }
        System.out.println(person);*/
    }

}
