package com.Thread.Normal;
/*
多线程实现的几种方式：
        1.编写的类继承Thread类，并重写run方法
        2.编写的类实现Runnable接口
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        //通过编写继承Thread类的工具类实现
        ThreadUtil ThreadUtil = new ThreadUtil();
        ThreadUtil.start();
        //通过实现Runnable接口实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread--3");
            }
        }).start();
    }
}
class ThreadUtil extends Thread{
    @Override
    public void run() {
        System.out.println("Thread--2");
    }
}