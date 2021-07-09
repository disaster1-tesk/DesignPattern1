package hongchengstudy.thread.v2;

public class Client {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("thread_1");
        myThread.start();
        Thread.yield();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+"========"+i);
        }
    }
}
