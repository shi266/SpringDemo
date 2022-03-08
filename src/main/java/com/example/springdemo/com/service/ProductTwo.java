package com.example.springdemo.com.service;


import com.example.springdemo.com.test.quartz.Hello;
//import com.example.springdemo.com.util.QuartzUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProductTwo /*implements Job */{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    ProductTwo(){
//        System.out.println("ProductTwo构造方法");
//        logger.info("logger   初始化bean  ProductTwo");



    }


  /*  @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("自动任务 "+new Date(sdf.format(System.currentTimeMillis())));
    }*/
}
