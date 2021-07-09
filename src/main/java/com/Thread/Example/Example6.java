package com.Thread.Example;

import java.util.ArrayList;
import java.util.List;

public class Example6 {
    private static List<Thread> threads = new ArrayList<>();
    /*volatile*/ int number = 0;
    public synchronized void m(){
        number++;
    }
    public static void main(String[] args) throws InterruptedException {
        Example6 M = new Example6();
        for (int i= 0; i < 100000; i++) {
            threads.add(new Thread(M::m));
        }
        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }
        System.out.println(M.number);
    }
}
