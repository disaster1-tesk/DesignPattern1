package com.high.Final;
/*
只有成员变量才有初始化，且成员变量的初始化，都是在一个对象new出来的时候进行赋值，也就是在构造方法中进行赋值，但是成员变量中的静态变量的话则是在构造方法前面进行赋值！
也就是说，成员变量中的实例变量加final关键字的时候，只要在构造方法完成之前赋值就符合语法，不然无法通过编译！！！！
 */
public class FinalDemo1 {
    public static void main(String[] args) {
       final test t= new test1(20);
       //t = new test1(10);final修饰的变量只能被赋一次值
       t.test();
    }
}
class test{
    private final int age;//如果没有自动赋值，那么系统会默认给这个变量赋一个null值，但是一旦在变量的前面家final关键值之后，系统不会自动给这个变量赋值

    public int getAge() {
        return age;
    }

    test(int age) {
        this.age = age;
    }

    public void test(){
        System.out.println("你不好");
    }
}
class test1 extends test{

    test1(int age) {
        super(age);
    }

    public final void test(){
        System.out.println("你好");
    }
}