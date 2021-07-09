package com.disaster.ThreadAndPool.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleDemo2 {
    public static class Container<T> {
        private List<T> objectList = new ArrayList<>();
        private final int MAX = 90;
        private int Count = 0;
        private ReentrantLock Lock = new ReentrantLock();
        private Condition producer = Lock.newCondition();
        private Condition comsumer = Lock.newCondition();

        public void put(T t) {
            try {
                Lock.lock();
                while (objectList.size() == MAX) {
                    producer.await();
                }
                objectList.add(t);
                Count++;
                comsumer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Lock.unlock();
            }

        }

        public T get() {
            T t = null;
            try {
                Lock.lock();
                while (objectList.size() == 0) {
                    comsumer.await();
                }
                t = objectList.get(objectList.size());
                Count--;
                producer.signalAll();
            } finally {
                Lock.unlock();
                return t;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Container<Object> container = new Container<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                container.put(new Object());
                System.out.println(Thread.currentThread().getName() + "------->" + "放值");
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                container.get();
                System.out.println(Thread.currentThread().getName() + "------->" + "取值");
            }).start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println(container.Count);
    }
}
