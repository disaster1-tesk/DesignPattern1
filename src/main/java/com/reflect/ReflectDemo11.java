package com.reflect;

import java.lang.reflect.Method;

/*
           通过反射机制来调用方法：

 */
public class ReflectDemo11 {
    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.reflect.Myclass");
        Object o = aClass.newInstance();
        Method login = aClass.getDeclaredMethod("login", String.class, String.class);
        //这里的方法是通过private修饰的所以需要加下列代码
        login.setAccessible(true);
        Object admin = login.invoke(o, "admin", "123");
        System.out.println(admin);
    }
}
