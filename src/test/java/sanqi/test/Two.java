package sanqi.test;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Two extends Thread{

    @Override
    public void run() {
        System.out.println("额外任务获取的时间");

        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf0.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(sdf0.format(System.currentTimeMillis()));
    }
}
