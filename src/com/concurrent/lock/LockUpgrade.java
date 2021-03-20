package com.concurrent.lock;

import org.openjdk.jol.info.ClassLayout;

public class LockUpgrade {

    // JVM 默认延时4s开启偏向锁，未启用的情况下加synchronized，直接变成轻量级锁
    // 取消延时-XX:BiasedLockingStartupDelay=0
    // 禁用偏向锁 -XX:UseBiasedLocking = false
    public static void main(String[] args) throws InterruptedException {
        User u1 = new User();
        System.out.println("无状态(001)：" + ClassLayout.parseInstance(u1).toPrintable());
        // 暂停5s等待开启偏向锁
        Thread.sleep(5000);

        User u2 = new User();
        System.out.println("启用偏向锁(101)：" + ClassLayout.parseInstance(u2).toPrintable());

        for (int i = 0; i < 1; i++) {
            synchronized (u2) {
                System.out.println("偏向锁(101)(带线程ID)：" + ClassLayout.parseInstance(u2).toPrintable());
            }
            System.out.println("偏向锁释放(101)(带线程ID)：" + ClassLayout.parseInstance(u2).toPrintable());
        }

        new Thread(()->{
            synchronized (u2){
                System.out.println("轻量级锁(00)："+ClassLayout.parseInstance(u2).toPrintable());
                try {
                    System.out.println("睡眠3S=======================");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("轻量-->重量(10)："+ClassLayout.parseInstance(u2).toPrintable());
            }
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            synchronized (u2){
                System.out.println("重量级锁(10)："+ClassLayout.parseInstance(u2).toPrintable());
            }
        }).start();
    }
}
