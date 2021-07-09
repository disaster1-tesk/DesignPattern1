package com.reflect;
/*
        Class、Field、Constructor、Method 三种类的学习：
            Class表示下面整个类：
            public class RefletDemo3 {
                    Field表示这个类中的属性
                    private String name;


                    Constructor表示的是这个类的构造方法
                    public RefletDemo3() {
                    }

                    public RefletDemo3(String name) {
                        this.name = name;
                    }


                    Method表示的是这个类中的方法
                    public void dosome(){
                        System.out.println("111");
                       }
                                 }



        获取Class文件的三种方式：
            第一种：通过“引用”.getClass()方法来获取
            第二种：通过Class.forName()方法来获取
            第三种：通过“类名”.class获取
 */
public class ReflectDemo1 {
    public static void main(String[] args) {
        //第一种
        String str ="abc";
        Class aClass = str.getClass();
        //第二种
        Class aClass1=null;
        try {
             aClass1 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass1==aClass);
        //第三种
        Class aclass2 = String.class;
        System.out.println(aClass1==aclass2);
    }
}
