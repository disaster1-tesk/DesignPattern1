package com.Thread.Example;

import java.util.ArrayList;
import java.util.List;

public class Example4 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread Consumer1 = new Thread(new Consumer1(list,10));
        Thread Comsumer2 = new Thread(new Consumer1(list,10));
        Thread Producter = new Thread(new Producter1(list,10));
        Comsumer2.setName("Comsumer2");
        Consumer1.setName("Consumer1");
        Consumer1.start();
        Comsumer2.start();
        Producter.start();

    }
}

class Consumer1 implements Runnable {
    private List list;
    private int Number;
    public Consumer1(List list,int Number) {
        this.list = list;
        this.Number = Number;
    }

    @Override
    public void run() {
//        一直生产
        synchronized (list) {
            while (true) {
                if (list.size() == Number) {
                    try {
                        System.out.println("仓库已满，暂停生产！");
                        Thread.sleep(1000);
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (list.size() >= 0||list.size()<Number) {
                    list.notifyAll();
                    list.add(1);
                    System.out.println("工厂正在生产商品，已有商品："+list.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Producter1 implements Runnable {
    private List list;
    private int Number;

    public Producter1(List list,int Number) {
        this.list = list;
        this.Number = Number;
    }

    @Override
    public void run() {
//        一直消费
        synchronized (list) {
            while (true) {
                if (list.size() == Number||list.size()>0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notifyAll();
                    System.out.println(Thread.currentThread().getName()+"顾客正在消费！");
                    list.remove(0);
                    System.out.println("剩余商品：" + list.size());
                    System.out.println("--------------");
                }
                if (list.size() == 0) {
                    try {
                        list.wait();
                        System.out.println("仓库已空！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}