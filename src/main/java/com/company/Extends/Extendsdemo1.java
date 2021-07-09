package com.company.Extends;

import java.io.File;

public class Extendsdemo1 {
    public static void main(String[] args) {
        String str = "nihao";
        System.out.println(str.equals("nihao"));
        System.out.println(Extendsdemo1.class.toString());
        Extendsdemo1.show("你们在干什么？");
        MyThread.run1();
    }
    public static void show(String str){
        System.out.println(str);
    }
}
class FileIn extends File{
    public FileIn(String pathname) {
        super(pathname);
    }

}
class MyThread extends Thread{
    //方法的覆盖与方法的重载有所不同
/*
方法的重载使用的条件：
        1.必须在一个类中进行方法的重载
        2.方法的功能无法满足或者需要修改逻辑
        3.需要构建多个类似的功能

方法的覆盖使用的条件：
        1.要有继承类
        2.覆盖的方法的返回值、名字都必须相同、方法参数数量和类型相同
        3.覆盖的访问权限不能更低，可以更高
        4.覆盖的方法抛出的异常不能更多，可以更少！！
 */
    @Override
    public void run() {
        System.out.println(super.getName());
    }
    public static void run1(){
        String str = new MyThread().getName();
        System.out.println(str);
    }
}
