package sanqi.com.test.ScheduledTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Service
public class ScheduledTest implements SchedulingConfigurer ,Runnable{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

    public ScheduledTest(){
        System.out.println("自动任务的构造方法");
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        System.out.println("配置自动任务");
        taskRegistrar.addCronTask(this,"0/10 * * * * ?");//开启的线程 ， cron（定时）
    }


    @Scheduled(cron = "0/5 * * * * ?")
    public void autoTask(){
        System.out.println(sdf.format(new Date())+" 自动任务");

    }

    @Override
    public void run() {
        System.out.println(sdf.format(new Date())+" 自动任务开启的线程");
    }
}
