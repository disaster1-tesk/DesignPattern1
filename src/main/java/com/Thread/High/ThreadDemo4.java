package com.Thread.High;
/*
守护线程和用户线程（又称后台线程与用户线程）
  典型的守护线程（垃圾回收线程）
 */
public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadTest());
        thread.setName("Thread1");
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main--------->"+i);
            Thread.sleep(1000);
        }
    }
}
class ThreadTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--------->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}