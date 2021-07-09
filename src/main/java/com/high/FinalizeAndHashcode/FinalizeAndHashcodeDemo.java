package com.high.FinalizeAndHashcode;
/*
Finalize和静态代码块有点类似，一样是SUN公司给程序员的一个时间段，在这个时间段程序员可以做相应的一些操作！
Finalize是对象被销毁的时候启动的，不需要程序员去调用，只要在类中实现这个方法就行！

Hashcode方法，其实就是生成一个int类型的数
 */
public class FinalizeAndHashcodeDemo {
    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println(person1.hashCode());
        for (int i = 0; i <10000 ; i++) {
            Person person = new Person();
            person = null;
            System.gc();
        }
    }
}
class Person{
    @Override
    protected void finalize() throws Throwable {
        System.out.println(this+"对象销毁！");
    }
}

