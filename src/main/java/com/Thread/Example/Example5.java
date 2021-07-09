package com.Thread.Example;

public class Example5 {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Myrun());
        Thread two = new Thread(new Myrun());
        Thread three = new Thread(new Myrun());
        one.start();
        Thread.sleep(100);
        two.start();three.start();
        one.join();two.join();three.join();
    }
}
class Myrun implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在运行");
    }
}
