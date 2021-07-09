package com.company.Static;

/**
 * 代码的执行顺序
 */
public class StaticTest2 {
    static String user;
    //静态代码块（执行时间在类加载的时候执行，静态代码块之间按照自上而下的顺序执行！！！）
    static Person p;

    static {
        p = new Person();
        user = "Disaster";
        System.out.println("初始化事务");
    }

    static {
        System.out.println("静态代码块2");
    }

    //实例代码块（执行时间在类的构造方法之前，实例代码块之间按照自上而下的顺序执行！！！）
    {
        System.out.println("实例代码块2执行了！！");
    }

    {
        System.out.println("实例代码块1执行了！");
    }

    public static void main(String[] args) {
        System.out.println("main" +
                "begin");
        new StaticTest2();
    }
}

class Person {
    //静态代码块与静态代码块之间是有先后执行顺序的！！！
    static String name;
    String age;

    static {
        name = "张三";
    }

    public Person(String age) {
        this.age = age;
    }

    public Person() {
    }
}
