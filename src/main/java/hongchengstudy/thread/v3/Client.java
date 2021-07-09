package hongchengstudy.thread.v3;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new MyThread();
        myThread.setName("main");
        myThread.start();
        for (int i = 0; i < 10; i++) {
            if (i==5){
                myThread.join();
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"========"+i);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
