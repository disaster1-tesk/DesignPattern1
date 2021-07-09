package com.high.StringBuilder;
/*
StringBuilder底层与StringBuffer一样，他们两的区别就是StringBuffer中的方法带有synchronized关键字，也就是说StringBuffer的方法对于多线程是安全的！
 */
public class StringBuilderDemo1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(100);
        sb.append(111);
        sb.append("asd");
        sb.append(true);
        System.out.println(sb);
    }
}
