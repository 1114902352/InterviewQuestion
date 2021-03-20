package com.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Working...");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        // Future
        Future<Integer> future = pool.submit(new CallableTest());
        // FutureTask
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableTest());
        pool.submit(futureTask);
        // 关闭线程池，会等待线程池内的线程完成任务
        pool.shutdown();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Main Working");
        try {
            if(future.get()!=null){
                System.out.println("Get FutureRes="+future.get());
            }else{
                System.out.println("Cannot get future result");
            }

            if(futureTask.get()!=null){
                System.out.println("Get FutureTaskRes="+futureTask.get());
            }else{
                System.out.println("Cannot get future task result");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("All task completed!");
    }
}
