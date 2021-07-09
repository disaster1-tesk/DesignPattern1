package com.high.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
异常：

        1.异常分为两种异常：编译时异常     执行时异常（异常其实就是SUN公司定义的一些类，也就是说，我们开发中常见的异常都是SUN公司都预料到的，需要我们程序员自行解决的）
        2.这两种异常的执行都是在程序运行时的时候执行，但是对于执行时异常，程序员可以不用去解决或者捕捉，但是编译时异常是需要我们程序员去解决的
            我们可以这么理解，编译时异常使我们可以预防的异常，但是运行时异常使我们无法异常的，带有随机行，而且这种几率比较低。
        3.对于编译时异常我们的解决方案有两种：throws上抛（也就是说把这个异常让执行这个方法，或者类的使用者去进行异常的解决，如果使用者在main方法中
            也进行了上抛，那么这个异常会被JVM执行。） try...catch语句（这个语句能对一场进行捕捉，在这个方法体中，我们程序员可以在将这个异常的追踪信息
            给打印出来）
 */
public class ExceptionDemo1 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            System.out.println("错误！"+"----->"+message);
            e.printStackTrace();
        }
    }

    private static void m1() throws FileNotFoundException {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 end");
    }

    private static void m2() throws FileNotFoundException {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 end");
    }

    private static void m3() throws FileNotFoundException {
        new FileInputStream("D:\\桌面文件\\文件夹\\大学获奖.");
        /*try {
            new FileInputStream("D:\\桌面文件\\文件夹\\大学获奖.txt");
        } catch (FileNotFoundException e) {
            //这里的FileNotFoundException就是FileInputStream中上抛的异常对象名，e就是FileInputStream中new出来的FileNotFoundException对象代表的是一个内存地址！！！
            e.printStackTrace();
        }*/
    }
}
