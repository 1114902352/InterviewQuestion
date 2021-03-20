package com.concurrent.forkjoin;

import java.util.concurrent.CompletableFuture;

public class CompletableTest {


    public static void main(String[] args) {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " Working...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += 1;
            }
            return sum;
        });
        cf.thenAccept((result)->{
            System.out.println(result);
        });
        cf.exceptionally((e)->{
            e.printStackTrace();
           return null;
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
