package com.reflect;
/*
    通过获取的class文件中的newInstance()方法来创建对象！
 */
public class ReflectDemo2 {
    public static void main(String[] args) {
        Class<String> c1 = String.class;
        String str = null;
        try {
             str = c1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(str.isEmpty());
    }
}
