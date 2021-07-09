package com.high.Set;

import java.util.HashSet;
import java.util.Iterator;

/*
Set集合中的元素是不可重复的，同时也是无序的，进入的顺序和出来的顺序可能不一样！
 */
public class SetDemo1 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("123");
        hashSet.add(123);
        hashSet.add("你好");
        hashSet.add("你好");
        hashSet.add("456");
        hashSet.add("456");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
            System.out.println(hashSet.size());
        }
    }
}
