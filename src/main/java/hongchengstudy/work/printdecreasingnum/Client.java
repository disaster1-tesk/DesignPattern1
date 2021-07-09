package hongchengstudy.work.printdecreasingnum;

/*
3、三个线程打印递减数字
启动3个线程打印递减数字，范围是：30~1。要求数字不能重复，每个线程打印一个数字后，立刻进入睡眠状态，睡眠时间300毫秒。（模拟多线程售票）

提示：定义一个类，其中定义一个数字类型的属性，用于记录要输出数字的上限（本题目中为30），
定义一个方法，用于循环输出数字，循环条件为属性大于0。
每次输出数字的时候让记录数字上限的属性自减1。
注意，在循环输出的时候，使用try...finally代码块保证try中lock获取锁，finally中释放锁。
 */
public class Client {
    public static void main(String[] args) {
        Util util = new Util(30);
        new Thread(new MyThread(util),"小红").start();
        new Thread(new MyThread(util),"小黄").start();
        new Thread(new MyThread(util),"小美").start();
    }
}

class MyThread implements Runnable {
    private Util util = null;

    public MyThread(Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        synchronized (util) {
            while (util.getMAX_NUM() >= 0) {
                util.printNum();
                util.notifyAll();
                try {
                    util.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Util {
    private int MAX_NUM = 0;

    public int getMAX_NUM() {
        return MAX_NUM;
    }

    public Util(int MAX_NUM) {
        this.MAX_NUM = MAX_NUM;
    }

    public void printNum() {
        System.out.println(Thread.currentThread().getName() + "===" + MAX_NUM);
        MAX_NUM--;
    }
}