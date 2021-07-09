package com.Thread.Normal;

/*

 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable2());
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        //线程优先级的设置
//        thread.setPriority(10);
        thread.setName("t");
        thread.start();
        for (int i = 0; i < 10000 ; i++) {
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
        //stop()方法终止线程的运行，这个方法不建议使用，因为使用这种方法容易造成数据的丢失
//        thread.stop();
    }
}
class Runnable2 implements Runnable{
    boolean flag = true; //睡眠标志
    @Override
    public void run() {
        for (int i = 0; i < 10000 ; i++) {
            if (i%100==0){
                //进程让位
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}