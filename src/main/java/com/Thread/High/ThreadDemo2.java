package com.Thread.High;
/*
对synchronized的使用理解：
    synchronized在代码中的位置：1.方法块中   2.实例方法上（对一个对象进行锁）   3.静态方法上（对一个类对象进行锁）
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        User user = new User("user01",20);
        UserThread userThread = new UserThread(user);
        UserThread1 userThread1 = new UserThread1(user);
        Thread thread1 = new Thread(userThread);
        Thread thread = new Thread(userThread1);
//        thread.start();
//        thread1.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                User.dootherthing();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                User.dootherthing();
            }
        }).start();
    }
}
class UserThread implements Runnable{
    private User user;

    public UserThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        this.user.dosome();
    }
}
class UserThread1 implements Runnable{
    private User user;

    public UserThread1(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        this.user.domything();
    }
}
class User {
    private String name;
    private int age;

    public void dosome(){
        synchronized (this){
            System.out.println("------dosome-----begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------dosome------end");
        }
    }
    public synchronized void domything(){
        System.out.println("------domything-----begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------domything------end");
    }

    public static synchronized void dootherthing(){
        System.out.println("------dootherthing-----begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------dootherthing-----end");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}