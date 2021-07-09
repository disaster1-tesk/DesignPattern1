package com.reflect;



import java.lang.reflect.Field;
/*
通过反射机制来获取属性：
    并修改属性的值
 */
public class ReflectDemo9 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName("com.reflect.Myclass");
        Object o = aClass.newInstance();
        Field age = aClass.getDeclaredField("age");
        Field name = aClass.getField("name");
        name.set(o,"123");
        age.setAccessible(true);//当这个属性是private修饰的，需要使用这个方法才能修改这个属性的值
        age.set( o ,11);
        System.out.println(age.get(o));
        System.out.println(name.get(o));
    }
}
