package hongchengstudy.thread.v4;


public class Client {
    public static Thread myThread = new MyThread("disaster1");

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread MyRunnable = new Thread(myRunnable, "disaster2");
        MyRunnable.setPriority(Thread.MAX_PRIORITY);
        myThread.setPriority(Thread.NORM_PRIORITY);
        MyRunnable.start();
        myThread.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "start...");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + "========" + i);
        }
        System.out.println(this.getName() + "end...");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start...");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "======" + i);
            if (i == 5) {
                try {
                    Client.myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "end...");
    }
}