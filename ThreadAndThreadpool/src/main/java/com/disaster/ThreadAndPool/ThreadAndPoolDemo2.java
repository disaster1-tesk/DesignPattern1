package com.disaster.ThreadAndPool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAndPoolDemo2 {
    AtomicInteger a = new AtomicInteger(0);
    //AtomicInteger的底层也是通过CAS实现的
    public void m(){
        a.addAndGet(1);
    }
    public static void main(String[] args) {
        ThreadAndPoolDemo2 M = new ThreadAndPoolDemo2();
        for (int i = 0; i < 10000; i++) {
            new Thread(M::m).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(M.a);

    }
}
