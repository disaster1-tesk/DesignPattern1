package com.disaster.ThreadAndPool.ReentrantReadWriteLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo1 {
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    public static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    public static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    readLock.lock();
                    System.out.println("读数据....");
                } finally {
                    readLock.unlock();
                }

            }).start();

        }
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    writeLock.lock();
                    System.out.println("写数据....");
                } finally {
                    writeLock.unlock();
                }
            }).start();
        }
    }
}
