package com.Thread.Normal;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable1 r = new Runnable1();
        Thread thread = new Thread(r);
        thread.setName("Thread1");
        thread.start();
        //这种终止线程的睡眠方式是通过java虚拟机的异常机制来终止的，在开发中使用的较少！
//        thread.interrupt();
        //还有一种终止线程睡眠的方式是通过在实现了Runnable接口中的类中假如一个睡眠标志
        System.out.println("1111");
        r.flag=false;
    }
}

class Runnable1 implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "----->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                return;
            }
        }
    }
}
