package com.disaster.ThreadAndPool.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {
    static  CountDownLatch countDownLatch1 = new CountDownLatch(1);
    static CountDownLatch countDownLatch2 = new CountDownLatch(1);
    static CountDownLatch countDownLatch3 = new CountDownLatch(1);
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("正在输入中、....." + i);
                if (i == 50) {
                    System.out.println("----------------------打开输出锁..");
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            System.out.println("-----------------打开输出锁");
            countDownLatch3.countDown();
        }).start();
        new Thread(() -> {
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("正在输出中...." + i);
                if (i == 50) {
                    System.out.println("---------------------------打开输入锁..");
                    countDownLatch2.countDown();
                    try {
                        countDownLatch3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
