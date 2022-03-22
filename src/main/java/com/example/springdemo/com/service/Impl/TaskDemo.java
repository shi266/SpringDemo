package com.example.springdemo.com.service.Impl;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskDemo {




    int num = 0;
    @PostConstruct
//    @Scheduled(cron = "0/5 * * * * ?")
    public void task() throws InterruptedException {

//        log.info("自动任务加载");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+":\t每5秒执行一次,这是第"+(++num)+"次");

    }

}
