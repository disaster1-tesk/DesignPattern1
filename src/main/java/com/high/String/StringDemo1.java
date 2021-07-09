package com.high.String;

public class StringDemo1 {
    public static void main(String[] args) {
        //这是最常见的创建String字符串的方式
        String str = "asd";
        System.out.println(str);
        //这是第二种通过byte【】数组来创建
        byte[] bytes ={65,96,84,74,83};
        String str1 = new String(bytes);
        String str2 = new String(bytes,1,4);
        System.out.println(str1+"----------------"+str2);
        //这是第三种通过char【】数组来创建的方式
        char[] chars = {'a','b','c','d','e'};
        String str3 = new String(chars);
        String str4 = new String(chars,1,4);
        System.out.println(str3+"-----------"+str4);
    }
}
