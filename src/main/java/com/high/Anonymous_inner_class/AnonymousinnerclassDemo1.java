package com.high.Anonymous_inner_class;
/*
匿名内部类：是一种新的语法，有点别扭，接口对象是不能new的，所以SUN公司就想出一种新的写法，直接实现接口中的方法，
可以不用定义一个新的内部类，这种方法在一定程度上减少了程序员的代码量。
匿名内部类缺点:
1.可读性差、代码复用性低
 */
public class AnonymousinnerclassDemo1 {
    public static void main(String[] args) {
        test t = new test();
        t.mysum(new Mymath(),100,200);
        //这两种实现的功能一样
        t.mysum(new MymathInterface() {
            @Override
            public int sum(int a, int b) {
                return 0;
            }
        },100,200);
    }
}
//测试类
class test{
    public void mysum(MymathInterface mymathInterface,int a,int b){
        mymathInterface.sum(a,b);
    }
}
//接口
interface MymathInterface {
    int sum(int a, int b);
}
//接口实现类
class Mymath implements MymathInterface {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
