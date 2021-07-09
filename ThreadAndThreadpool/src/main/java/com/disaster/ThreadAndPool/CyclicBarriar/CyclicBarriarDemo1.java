package com.disaster.ThreadAndPool.CyclicBarriar;

import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarriarDemo1 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
        @Override
        public void run() {
            System.out.println("满人，走起！");
        }
    });
    public static void main(String[] args)  {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
