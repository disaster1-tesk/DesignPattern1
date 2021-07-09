package com.high.Interface;

public class InterfaceDemo2 {
    public static void main(String[] args) {
        math person1 = new person();
        doing person2 = new person();
        int result1 = person1.add(1, 2);
        int result2 = person1.reduce(2, 1);
        System.out.println(result1 + "-----" + result2);
        math test1 = new test1();
        doing test2 = new test2();
        //接口和接口之间能进行强转，但是会报java.lang.ClassCastException异常
        if (test1 instanceof doing){
            test2 t2 = (com.high.Interface.test2) test1;
        }else{
            System.out.println("test1不是doing类型");
        }

    }
}

interface math {
    double π = 3.1415926;

    int add(int a, int b);

    int reduce(int a, int b);
}

interface doing {
    void dosomething();

    void domything();
}

class person implements math, doing {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int reduce(int a, int b) {
        return a - b;
    }

    @Override
    public void dosomething() {
        System.out.println("做别人的事");
    }

    @Override
    public void domything() {
        System.out.println("做自己的事");
    }
}


class test1 implements math {

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int reduce(int a, int b) {
        return 0;
    }
}

class test2 implements doing {

    @Override
    public void dosomething() {

    }

    @Override
    public void domything() {

    }
}