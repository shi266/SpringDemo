package com.example.springdemo.test;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class One extends Thread{

    @Override
    public void run() {
        System.out.println("启动  设置时区  休息半分钟");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+4"));
        try {
            Thread.sleep(1*10*1000);
            System.out.println("休息结束");
            SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.println(sdf0.format(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
