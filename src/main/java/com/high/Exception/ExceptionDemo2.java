package com.high.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
对于try...catch语句的详细使用：
    finally语句中的代码块是一定会执行的，我们一般拿来关闭流或者线程
 */
public class ExceptionDemo2 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\\\桌面文件\\\\文件夹\\\\大学获奖.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
           /* for (int i = 0; i <100 ; i++) {
                System.out.println("i="+i);
            }*/
            try {
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("捕捉到异常1");
            }
            System.out.println("final语句的执行");
        }
    }
}
