package com.disaster.ThreadAndPool.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo1 {
    static Semaphore semaphore = new Semaphore(10, true);//permit决定能拦截的线程数目，fair表示栈中是线程的进出原则（true表示先进先出）

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            if (i==0){
                semaphore.release();
            }
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(semaphore.getQueueLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
