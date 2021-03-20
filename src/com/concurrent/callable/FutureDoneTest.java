package com.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureDoneTest extends FutureTask<Integer> {


    public FutureDoneTest(Callable<Integer> callable) {
        super(callable);
    }

    public void done() {
        System.out.println(Thread.currentThread().getName() + " worked.");
        try {
            System.out.println(this.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FutureDoneTest task = new FutureDoneTest(new Callable<Integer>() {
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
        });
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(task);
        pool.shutdown();
        try {
            if (task.get() != null) {
                System.out.println("Get FutureRes=" + task.get());
            } else {
                System.out.println("Cannot get future result");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
