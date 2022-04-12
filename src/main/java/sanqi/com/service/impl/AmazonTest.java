package sanqi.com.service.impl;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Date;

public class AmazonTest implements SchedulingConfigurer {
    public void download(){
        System.out.println("下载测试");
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        download();
        taskRegistrar.addTriggerTask(
                new Runnable() {
                    @Override
                    public void run() {
                        download();
                    }
                },
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext triggerContext) {
                        return null;
                    }
                }
        );
    }
}
