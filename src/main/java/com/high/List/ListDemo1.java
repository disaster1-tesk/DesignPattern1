package com.high.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class ListDemo1 {
    public static void main(String[] args) {

        //List集合与Collection差不多，但是多了一些特殊方法！！
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(123);
        list.add(456);
        list.add(1, "你好啊");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
            System.out.println(list.size());
        }

        //Vector和List差不多，区别在于Vector属于线程安全
        Vector vector = new Vector();
        vector.add("123");
        vector.add(123);
        vector.set(1,"你好吗？");
        Object[] objects = vector.toArray();
        for (int i = 0; i <objects.length ; i++) {
            System.out.println(objects[i]);
        }

        //LinkedList底层是链表
        LinkedList linkedList = new LinkedList();
        linkedList.add("123");
        linkedList.add(456);
        linkedList.add(789);
        Iterator iterator1 = linkedList.iterator();
        //这里进行用迭代器进行集合中元素的删除操作的时候，我们需要使用迭代中的remove方法进行操作，不然用list接口中的remove方法的话会报
        // java.util.ConcurrentModificationException异常。这是因为迭代器每次对集合中的元素进行迭代的时候，都会与集合中的结构进行对照
        //如果集合的结构发生了改变，那么就会发生异常，所以，我们在通过迭代器来删除某个元素的时候，必须使用迭代器中remove方法，这样才不会报错！
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
//            linkedList.remove();
            iterator1.remove();
            System.out.println(linkedList.size());
        }


    }

}
