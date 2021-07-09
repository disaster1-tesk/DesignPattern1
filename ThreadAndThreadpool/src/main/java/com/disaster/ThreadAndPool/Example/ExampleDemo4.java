package com.disaster.ThreadAndPool.Example;

import org.openjdk.jol.info.ClassLayout;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

 public class ExampleDemo4 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        long first = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            t.age = i+1;
        }
//        TimeUnit.MILLISECONDS.sleep(1000);
        long end = System.currentTimeMillis();
        long time = end - first;
        System.out.println(time);
//        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }

}

class T {
//    private Long p1, p2, p3, p4, p5, p6;
    public String name;
    public int age;
//    private Long m1, m2, m3, m4, m5, m6;

}