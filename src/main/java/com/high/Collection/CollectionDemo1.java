package com.high.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
Collection接口中常用的方法：
        1.boolean isEmpty(); 判断集合是否为空
        2.boolean contains(Object o); 判断集合中是否有对象o（这个方法的底层实现是通过对象的equals方法来实现的，所以，存放在集合中的类型，一定要重写equals方法，
        不然比较的就是两个对象中的内存地址，而不是内容了！）
        3.Iterator<E> iterator(); 继承了Iterable中的方法，返回一个Iterator类（迭代器）
        4.Object[] toArray(); 将集合转换成数组
        5. boolean remove(Object o); 将集合中的对象o移除(这个方法的底层实现也调用了equals方法，用法与contains方法类似！
        6. boolean add(E e); 添加集合元素
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection c = new ArrayList();

        //boolean add(E e);
        c.add("hello");
        c.add("world");
        c.add("你好");
        c.add("世界");

        //boolean remove(Object o);
        c.remove("hello");

        //Object[] toArray();
        Object[] objects = c.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects);
        }

        //boolean contains(Object o);
        String str1 = new String("111");
        String str2 = new String("111");
        c.add(str1);
        System.out.println(c.contains(str2));//true

        //Iterator<E> iterator();
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
