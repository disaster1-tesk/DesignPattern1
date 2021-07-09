package com.company.Extends;

/**
 * 对于this和super的深度理解、；
 * 如果在构造方法中没有this或者super关键字，那么构造方法中的第一行肯定会有super()（程序员如果不自己写，是看不见的，隐形的！）
 */
public class ExtendsDemo2 {
    public static void main(String[] args) {
        new C();
    }
}
class A{
    public A() {
        System.out.println(1);
    }
}
class B extends A{
    public B() {
        System.out.println(2);
    }
    public B(String name) {
        System.out.println(3);
    }
}
class C extends B{
    public C() {
        this("name");
        System.out.println(4);
    }
    public C(String name){
        super("name");
        System.out.println(5);
    }
}