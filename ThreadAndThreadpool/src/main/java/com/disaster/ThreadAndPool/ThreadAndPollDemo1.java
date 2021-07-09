package com.disaster.ThreadAndPool;

import org.openjdk.jol.info.ClassLayout;

public class ThreadAndPollDemo1 {
    public ThreadAndPollDemo1() {
    }

    public static void main(String[] args) {
        Object o = new Object();
        User u = new User("disaster",10,new User.T());
        User u1 = new User();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(u).toPrintable());
        System.out.println(ClassLayout.parseInstance(u1).toPrintable());
    }
}
class User{
    private String name;
    private int age;
    private T t;
    public User() {
    }

    public User(String name, int age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public User(String name, int age) {
        this(name,age,null);
    }
    public int getage(){
        return this.age;
    }
    public static class T{
        private String name;
        private int age;
    }
}
