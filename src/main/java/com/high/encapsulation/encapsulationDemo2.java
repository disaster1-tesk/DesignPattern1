package com.high.encapsulation;

public class encapsulationDemo2 {
    public static void main(String[] args) {
        /*
        String   Integer       int
        三种类型的相互转换
         */
//        String------>Integer
        Integer integer = Integer.valueOf("123");
//        String------>int
        Integer.parseInt("123");
//        int------->String
        String.valueOf(123);
//        int------->Integer
        Integer.valueOf(1);
//        Integer----->int
        int i = integer;
//        Integer----->String
        String.valueOf(integer);
        String str = integer+"";
        //互相转换的方法可能不只一种，但是在以后的开发中只需要会一种转换的方式就行！
    }
}
