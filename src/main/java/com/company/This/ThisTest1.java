package com.company.This;

/**
 * This关键字的使用：
 * 1.this在内存中代表的是变量的地址
 * 2.this只能在实例代码块中使用，静态代码块中因为没有对象，所以无法使用this关键字
 * 3.“this.”大部分情况下可以省略，在一些特殊的情况下不能省略。
 * 4.“this.”在区分类中的成员变量和参数的时候是不能省略的!!!
 *
 */
public class ThisTest1 {
    String name;
    String age;
    User user;

    //静态代码块
    static {
        System.out.println("静态代码块执行完毕！");
    }

    //实例代码块
    {
        user = new User("Disaster", "19");
        System.out.println("实例代码块执行完毕！");
    }

    public static void main(String[] args) {
        ThisTest1 t1 = new ThisTest1();
        t1.user.show();
    }
}

class User {
    String name;
    String age;

    User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println(this.name + this.age + "正在玩。。。。。");//TODO这里的this.可以省略
    }
}