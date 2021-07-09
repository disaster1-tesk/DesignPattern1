package com.Thread.Example;

import java.util.ArrayList;
import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread Consumer = new Thread(new Consumer(list));
        Thread Producter = new Thread(new Producter(list));
        Consumer.start();
        Producter.start();

    }
}

class Consumer implements Runnable {
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
//        一直生产
        synchronized (list) {
            while (true) {
                if (list.size() == 10) {
                    try {
                        System.out.println("仓库已满，暂停生产！");
                        Thread.sleep(1000);
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (list.size() >= 0||list.size()<10) {
                    list.notify();
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

class Producter implements Runnable {
    private List list;

    public Producter(List list) {
        this.list = list;
    }

    @Override
    public void run() {
//        一直消费
        synchronized (list) {
            while (true) {
                if (list.size() == 10||list.size()>0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notify();
                    System.out.println("顾客正在消费！");
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