package com.example.springdemo.com.test.quartz;

//import com.example.springdemo.com.util.QuartzUtil;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;

public class QuartzTest {


    public static void main(String[] args) {
//       QuartzUtil quartzUtil = new QuartzUtil();
         /*CronTrigger cronTrigger = quartzUtil.createCronTrigger("cronTriggerHello","cronTriggerGroupHello","0/5 * * * * ?");
        JobDataMap jobDataMap = new JobDataMap();
        String jobName = System.currentTimeMillis() + "_GenerateAmazonAdvertisingCampaignStatisticJob";
        JobDetail jobDetail = quartzUtil.createCronScheduleJob(jobName, Hello.class,jobDataMap);
        try {
            quartzUtil.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/

//        System.out.println("Schedule GenerateAmazonAdvertisingCampaignStatisticJob");
//        String jobName = System.currentTimeMillis() + "_GenerateAmazonAdvertisingCampaignStatisticJob";
//        String cronTriggerName = System.currentTimeMillis() + "_Trigger";
//        String cronTriggerGroupName = cronTriggerName + "_Group";
//        CronTrigger cronTrigger = quartzUtil.createCronTrigger(cronTriggerName,cronTriggerGroupName,"0/5 * * * * ?");
//        JobDataMap jobDataMap = new JobDataMap();
//        JobDetail jobDetail = quartzUtil.createCronScheduleJob(jobName, Hello.class,jobDataMap);
//        System.out.println(jobDetail.getKey());


       /* SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setJobFactory(myJobFactory);
        factoryBean.afterPropertiesSet();
        factoryBean.getScheduler();*/

//        try {
//            quartzUtil.scheduleJob(jobDetail,cronTrigger);
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }



    }
}
