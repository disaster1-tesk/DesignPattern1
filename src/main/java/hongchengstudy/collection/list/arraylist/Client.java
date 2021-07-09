package hongchengstudy.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/*
ArrayList的扩容是通过grow方法来扩容的int newCapacity = oldCapacity + (oldCapacity >> 1);
oldCapacity>>1 意思是指向右移一位，比如oldCapacity原来的值为6，二进制：110，向右移一位：11，转为10进制为3，所以相当于oldCapacity*0.5
 */
public class Client {
    public static void main(String[] args) {
        int a = 10;
        List<Integer> listInt = new ArrayList<>();
        listInt.add(a);
        listInt.add(a);
        listInt.add(a);
        listInt.add(a);
        listInt.add(a);
        listInt.add(a);
        int index = listInt.indexOf(a);
        System.out.println("index = " + index);
        Object[] array = listInt.toArray();
        for (Object integer: array ) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = listInt.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
     /*   Integer remove = listInt.remove(56);//IndexOutOfBoundsException
        System.out.println(remove);*/
    }
}
class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
