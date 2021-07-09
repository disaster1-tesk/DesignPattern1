package com.disaster.ThreadAndPool.Example;

import java.util.concurrent.TimeUnit;

public class ExampleDemo3 {
    private static volatile boolean flag = true;

    public static void m() {
        System.out.println("begin");
        while (flag) {
//            System.out.println("m方法执行中...");
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ExampleDemo3.m();
        }).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        flag = false;
    }
}
