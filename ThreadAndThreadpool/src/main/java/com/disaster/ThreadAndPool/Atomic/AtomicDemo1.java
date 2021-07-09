package com.disaster.ThreadAndPool.Atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo1 {
    AtomicInteger a = new AtomicInteger(0);
    List<Thread> threadList = new ArrayList<>();
    public  void m(){
        for (int i = 0; i < 100; i++) {
//            a.incrementAndGet();
            a.addAndGet(1);
        }
    }
    public static void main(String[] args) {
        AtomicDemo1 M = new AtomicDemo1();
        for (int i = 0; i < 100; i++) {
            M.threadList.add(new Thread(() -> {
                M.m();
            }));
        }
        for (int i = 0; i < 100; i++) {
            M.threadList.get(i).start();
          /*  try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println(M.a);
    }
}
