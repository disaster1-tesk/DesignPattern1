package com.high.encapsulation;
/*
    基本数据类型                              封装类型
    byte                                    Byte
    int                                     Integer
    float                                   Float
    double                                  Double
    short                                   Short
    long                                    Long
    boolean                                 Boolean
    char                                    Character
    上面前六中基本数据类型的封装类都是继承Number类，所以Number类上的方法这些封装类都可以使用
    后面两种封装类继承的事Object类


 */
public class encapsulationDemo1 {
    public static void main(String[] args) {
        //因为前六种封装类差不太多，所以，这里就用Integer封装类来举例子
        Integer integer = new Integer("123");
        /*
        这种创建方式已经jdk9之后就被淘汰了@Deprecated(since="9")    以后的开发中使用的方式都是与String的用法差不多
        因为有了自动装箱和自动拆箱，所以在以后的开发中这些封装类的创建都是与String类的创建方式一样来进行创建
        */


        //将Integer类型转换成前六种封装数据类型（前六种封装数据类型都可以互相转换，因为这些方法都是继承自Number类）
        int i = integer.intValue();
        long l = integer.longValue();
        byte b = integer.byteValue();
        double v = integer.doubleValue();
        short s = integer.shortValue();
        System.out.println(l+"----"+b+"-------"+v+"-------------"+s);
        System.out.println("Max值："+integer.MAX_VALUE+"----------Min值："+integer.MIN_VALUE);


       // Integer.parseInt("asd");//java.lang.NumberFormatException数据类型转换异常，这是一种非常经典的异常需要我们注意
        int i1 = Integer.parseInt("123");
        System.out.println(i1);


    }
}
