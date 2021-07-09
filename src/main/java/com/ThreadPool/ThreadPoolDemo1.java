package com.ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ExecutorService executorService3 = Executors.newFixedThreadPool(10);
        /*public ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler)*/
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                10,
                5,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                (r, executor) -> {

                }
        );
        for (int i = 0; i <100 ; i++) {
            int finalI = i;
            executorService3.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----->"+ finalI);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
/**
 *
 * 线程池：
 *  提交优先级：核心线程------>线程队列------->其他线程数
 *  运行优先级：核心线程------->其他线程------->线程队列
 *
 *   public ThreadPoolExecutor(int corePoolSize,//核心线程数
 *                               int maximumPoolSize,//最大线程数
 *                               long keepAliveTime,//线程生命周期
 *                               TimeUnit unit,//时间类型
 *                               BlockingQueue<Runnable> workQueue,//线程队列
 *                               ThreadFactory threadFactory,//线程工厂
 *                               RejectedExecutionHandler handler//拒绝策略
 *                               ) {
 *         if (corePoolSize < 0 ||
 *             maximumPoolSize <= 0 ||
 *             maximumPoolSize < corePoolSize ||
 *             keepAliveTime < 0)
 *             throw new IllegalArgumentException();
 *         if (workQueue == null || threadFactory == null || handler == null)
 *             throw new NullPointerException();
 *         this.corePoolSize = corePoolSize;
 *         this.maximumPoolSize = maximumPoolSize;
 *         this.workQueue = workQueue;
 *         this.keepAliveTime = unit.toNanos(keepAliveTime);
 *         this.threadFactory = threadFactory;
 *         this.handler = handler;
 *     }
 *
 *  public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
 *         return new ThreadPoolExecutor(nThreads, nThreads,
 *                                       0L, TimeUnit.MILLISECONDS,
 *                                       new LinkedBlockingQueue<Runnable>(),
 *                                       threadFactory);
 *     }
 *
 *  public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
 *         return new FinalizableDelegatedExecutorService
 *             (new ThreadPoolExecutor(1, 1,
 *                                     0L, TimeUnit.MILLISECONDS,
 *                                     new LinkedBlockingQueue<Runnable>(),
 *                                     threadFactory));
 *     }
 *
 *
 *
 *  public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
 *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
 *                                       60L, TimeUnit.SECONDS,
 *                                       new SynchronousQueue<Runnable>(),
 *                                       threadFactory);
 *     }
 *
 *
 */