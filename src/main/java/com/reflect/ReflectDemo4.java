package com.reflect;
/*
    通过反射机制来实现运行一个类中的静态代码块
        Class.forName()方法会类加载
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class aClass = Class.forName("D:\\IDEA\\JavaSEStuding\\src\\com\\reflect\\ReflectDemo1.java");
    }
}
