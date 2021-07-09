package com.high.Exception;
/*
final的面试题：
    下面的mian方法中的代码块和方法块中的方法块中，仔细看这里面的差距！去看class文件
 */
public class ExceptionDemo3 {
    public static void main(String[] args) {
        try {
            System.out.println("你是谁？");
            return;
        }finally {
            System.out.println("我是你爹！");
            int returnnumber = returnnumber();
            System.out.println(returnnumber);
        }


    }
    public static int returnnumber(){
        int   i= 100;
        try{
            return i;
        }finally {
            i++;
        }
    }
}
