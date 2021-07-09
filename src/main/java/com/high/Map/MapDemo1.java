package com.high.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
            Map（使用key、value的形式来存储数据）
                对Map的遍历：
                    1.通过获取Key值进而获取value的值
                    2.通过Entry方法来进行遍历

           HashMap的底层内存结构:（哈希表）底层是数组和单向链表的结合，每一个数组中的元素是一个单向链表，使用这种数据结构，对于集合中的元素的存储的增删改查等操作都有一定的效率
           HashMap中存取数据的过程或者方式:
            1.存数据：
                1.1.将key和value的值转换成Node对象
                1.2.调用key中的HashCode方法
                1.3.将通过调用key的HashCode方法得到的hash值通过哈希算法得到数组的下标，如果数组当前下标中没有元素，则把Node对象存入数组中，如果有元素，则调用key中的
                equals方法来与数组中的元素的key值进行比较，如果不相等，那么将Node对象放入，这个数组下标的元素的下面，也就是单向链表中，如果相等，则把之前存进去的Node对象
                中的value值改成放进去的Node对象中的Value值。
            2.取数据：
                2.1.将key和value的值转换成Node对象
                2.2.调用key中的HashCode方法
                2.3.将通过调用key的HashCode方法得到的hash值通过哈希算法得到数组的下标，如果数组当前下标中没有元素，那么会抛出异常，如果有，则调用key的equals方法对这
                单向链表中的每个元素进行遍历比较，找到相同的则取出！
 */
public class MapDemo1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Hello");
        map.put(2,"World");
        map.put(3,"Hello");
        map.put(4,"Kitty");

        //通过key值来进行遍历
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            String value = map.get(next);
            System.out.println(value);
        }

        //通过Entry方法来进行遍历
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator1 = entries.iterator();
        while(iterator1.hasNext()){
            Map.Entry<Integer, String> next = iterator1.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println(key+"----->"+value);
        }
    }
}
