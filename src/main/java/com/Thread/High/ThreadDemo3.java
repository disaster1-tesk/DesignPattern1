package com.Thread.High;
/*
死锁案例：
    一般出现死锁是因为synchronized的嵌套使用，这样很容易造成死锁问题，所以我们程序员在以后的开发中尽量的少使用synchronized的嵌套使用
    ，而且在数据的设计中，能尽量设计局部变量的就设计成局部变量，这是因为局部变量不会成为共享数据，也就无法出现线程安全问题！

线程安全问题出现的条件：
    1.多线程并发
    2.有共享数据

 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(new ThreadUser1(o1,o2));
        Thread thread2 = new Thread(new ThreadUser2(o1,o2));
        thread1.start();
        thread2.start();
    }
}
class ThreadUser1 implements Runnable{
    private Object o1;
    private Object o2;

    public ThreadUser1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1){
            System.out.println("ThreadUser1----->begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("ThreadUser1----->end");
            }
        }
    }
}

class ThreadUser2 implements Runnable{
    private Object o1;
    private Object o2;

    public ThreadUser2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            System.out.println("ThreadUser2----->begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("ThreadUser2----->end");
            }
        }
    }
}