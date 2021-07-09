package com.high.Interface;

public class InterfaceDemo1 {
    public static void main(String[] args) {
        Interface1 i1=new test();
        i1.dosome();
        if (i1 instanceof test){
            test t1 = (test) i1;
            t1.domything();
        }
        System.out.println(Interface1.π);
    }
}

interface Interface1 {
    public static double π = 3.1415926;
    public abstract void dosome();
}

class test implements Interface1 {
    @Override
    public void dosome() {
        System.out.println("我实现了相关接口！");
    }
    public void domything(){
        System.out.println("做自己的事！");
    }
}
