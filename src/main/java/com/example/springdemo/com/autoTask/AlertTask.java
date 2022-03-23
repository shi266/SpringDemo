package com.example.springdemo.com.autoTask;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AlertTask {
    static  int num =1;
//    @PostConstruct
//    @Scheduled(cron = "0/5 * * * * ?")
    public void toALert(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+":\t每5秒执行一次,这是第"+(num++)+"次");

    }
}
