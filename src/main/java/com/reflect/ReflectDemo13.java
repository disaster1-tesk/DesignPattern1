package com.reflect;

import java.lang.reflect.Constructor;

public class ReflectDemo13 {
    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.reflect.Myclass");
        Object o = aClass.newInstance();
        Constructor declaredConstructor1 = aClass.getDeclaredConstructor();
        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, double.class, long.class);
        Object disaster = declaredConstructor.newInstance("disaster", 10, 10.0, 10l);
        Object o1 = declaredConstructor1.newInstance();
        System.out.println(o1);
        System.out.println(disaster);
    }
}
