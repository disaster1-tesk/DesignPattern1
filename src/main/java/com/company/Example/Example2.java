package com.company.Example;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        System.out.println("请设置数值：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        B b = new B(i);
        while(true){
            System.out.println("请输入猜测的数字：");
            int num = scanner.nextInt();
            b.cai(num);
        }
    }
}

class A {
    private int v;

    public A() {
    }

    public A(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
class B extends A{
    public B() {
    }
    public B(int v) {
        super(v);
    }
    public void cai(int i){
        if(i>super.getV()){
            System.out.println("大了");
        }else if (i<super.getV()){
            System.out.println("小了");
        }else{
            System.out.println("相等");
            System.exit(0);
        }
    }
}
