package com.Thread.High;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
线程实现的第三种方法：
        实现Callable接口
 */
public class ThreadDemo6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("futuretask----------begin");
                Thread.sleep(1000*4);
                System.out.println("futuretask----------end");
                return 10;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer integer = futureTask.get();
        System.out.println(integer);
        System.out.println("Hello World");

    }
}
