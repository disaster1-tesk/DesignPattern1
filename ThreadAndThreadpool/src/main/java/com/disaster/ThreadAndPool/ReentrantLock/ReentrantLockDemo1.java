package com.disaster.ThreadAndPool.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
//    List lists = Collections.synchronizedList(new ArrayList<>());
    public static ReentrantLock Lock = new ReentrantLock(true);

    //为True时为公平锁
    public void m1(){
        for (int i = 0; i < 100; i++) {
            try{
                Lock.lock();
                System.out.println("m1---m1");
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                Lock.unlock();
            }

        }
    }
    public void m2(){
        for (int i = 0; i < 100; i++) {
            try{
                Lock.lock();
                System.out.println("m2---m2");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                Lock.unlock();
            }

        }
    }
    public static void main(String[] args) {
        ReentrantLockDemo1 M = new ReentrantLockDemo1();
        new Thread(M::m1).start();
        new Thread(M::m2).start();
    }
}
