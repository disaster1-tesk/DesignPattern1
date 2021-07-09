package com.high.Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
            泛型：
                泛型的使用的优点：
                    1.增强开发者在开发中对代码的可读性
                    2.能够统一集合中的类型并进行相应的操作
                泛型使用的缺点:
                    1.在集合中泛型的使用，降低的集合中元素的多样性
 */
public class GenericDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("Hello Mr.Tree");
        /*
        对集合一共三种遍历方式：
            1.使用迭代器进行遍历
            2.通过下标进行遍历
            3.使用增强for循环进行遍历（foreach)
         */
        //Iterator
        Iterator<String> i=list.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("===============================");

        //通过下标进行遍历
        for (int j = 0; j <list.size() ; j++) {
            String s = list.get(j);
            System.out.println(s);
        }
        System.out.println("===============================");

        //通过foreach进行遍历
        for (String s: list) {
            System.out.println(s);
        }
    }
}
