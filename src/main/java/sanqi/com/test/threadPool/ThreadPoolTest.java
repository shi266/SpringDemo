package sanqi.com.test.threadPool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        int num =0;
        ExecutorService single = Executors.newSingleThreadExecutor();//线程池中只有一个线程
//        ExecutorService single = Executors.newCachedThreadPool();//线程不固定
//        ExecutorService single = Executors.newFixedThreadPool(5);//固定的线程数量

        try {
            single.execute(new Eat());
            single.execute(new Drink());
//            System.out.println("休息5s");
            Thread.sleep(1000*5);
            System.out.println("----------------");
            single.execute(new Drink());
            single.execute(new Eat());
//            for (int i = 0; i < 30; i++) {
//                single.execute(new Drink());
//            }
            single.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
class Eat implements Runnable{

    @Override
    public void run() {
        System.out.println("开启吃的线程");
        try {
            System.out.println("线程执行中，后边的排队");
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
class Drink implements Runnable{

    @Override
    public void run() {
        System.out.println("开启喝的线程");
        try {
            System.out.println("线程执行中，后边的排队");
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}