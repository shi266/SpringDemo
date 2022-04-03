package com.example.springdemo.com.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyThread3  implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("线程执行的方法体");
        int a = 5;
        try {
            System.out.println("休眠5秒");
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "banana";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread3 thread3 = new MyThread3();
        FutureTask<String> future = new FutureTask<String>(thread3);
        future.cancel(true);
       new Thread(future,"有返回值的线程").start();
        System.out.println("子线程的返回值："+future.get());//get()方法会阻塞，直到子线程执行结束才返回
        System.out.println(future.isCancelled());

    }
}
