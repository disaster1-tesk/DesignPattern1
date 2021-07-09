package com.high.StringBuffer;

import org.junit.Test;

/*
StringBuffer是一个底层为byte【】数据类型类型的一个组装数据，不是基本数据类型，他一般作为字符串的拼接来使用！
怎么优化StringBuffer的使用：
    1.最好在创建StringBuffer的时候进行数组长度的赋值
    2.减少byte数组的copy次数，降低cpu的占有
 */
public class StringBufferDemo1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);
        sb.append("123");
        sb.append(111);
        sb.append(true);
        System.out.println(sb.toString());
    }

    @Test
    public void test() {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(stringBuffer.indexOf("w"));
        System.out.println(stringBuffer.charAt(1));
        System.out.println(stringBuffer.reverse());
    }

    @Test
    public void test1() {
        String str = "hello world";
        System.out.println(str.split(" "));
        System.out.println(str.charAt(1));
        System.out.println(str.getBytes());
        System.out.println(str.trim());
    }
    @Test
    public void test2(){
        Father Son = new Son();
        Son.getField();
    }
}

abstract class Father {
    public String name = "Father";
    public abstract void getField();
}
class Son extends Father{
    @Override
    public void getField() {
        System.out.println(super.name);
    }
}