package com.disaster.ThreadAndPool.Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo1 {
    static Exchanger exchanger = new Exchanger();
    static String t1 = "t1", t2 = "T2";
    static String xchg1 = "", xchg2 = "";

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                xchg1 = (String) exchanger.exchange(t2);//这里面的t2是两个线程之间需要转换的数据
                System.out.println(Thread.currentThread().getName()+"-------"+xchg1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                xchg2 = (String) exchanger.exchange(t1);
                System.out.println(Thread.currentThread().getName()+"-------"+xchg2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();

    }
}
