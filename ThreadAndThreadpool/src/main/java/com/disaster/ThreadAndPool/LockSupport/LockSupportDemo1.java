package com.disaster.ThreadAndPool.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo1 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                if (i==5){
                    LockSupport.park();
                    System.out.println("线程被停止了");
                }
               /* if (i==6){
                    LockSupport.park();
                }*/
                System.out.println(i);
               /* try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

            }
        });
        t.start();
        LockSupport.unpark(t);  //unpark方法可以先于park执行的，但是一次unpark只能抵消一次park的作用
    }
}
