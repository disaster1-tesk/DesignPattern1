package com.disaster.ThreadAndPool.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleDemo1 {
    static volatile List lists = Collections.synchronizedList(new ArrayList<>());

    public static void add(Object o) {
        lists.add(o);
    }

    public static int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ExampleDemo1.add(new Object());
                System.out.println("add:" + i);
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (ExampleDemo1.size() == 5) {
                    System.out.println("停止运行！！！");
                    Thread.currentThread().stop();
                }
            }
        }).start();
    }
}
