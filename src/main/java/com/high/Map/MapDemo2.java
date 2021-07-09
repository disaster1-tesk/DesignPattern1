package com.high.Map;

import java.util.Properties;

/*
Properties的底层数据结构是hash表，与HashMap的区别就是它是线程安全的！
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.put(1,"你好！");
        pro.put(2,"世界！");
        System.out.println(  pro.get(1));
        System.out.println(pro.getProperty("1"));
    }
}
