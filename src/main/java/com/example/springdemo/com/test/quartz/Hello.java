package com.example.springdemo.com.test.quartz;


//import com.example.springdemo.com.util.QuartzUtil;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;

public class Hello implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("---------------------------------------");
        System.out.println(context.getTrigger().getKey());
        System.out.println(context.getJobDetail().getKey());
        System.out.println("Hello Quartz");
        System.out.println("---------------------------------------");


    }


}
