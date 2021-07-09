package hongchengstudy.System;

import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
//        System.setOut(new PrintStream("D:\\桌面文件\\out.txt"));
        Scanner scanner = new Scanner(System.in);//in-->InputStream
        System.out.println("hello world"); //out-->PrintStream
        System.err.println("用来输出异常错误信息");//err-->PrintStream
//        System.arraycopy(); 数组拷贝
        String property = System.getProperty("java.version");//java运行时环境版本
        System.out.println(property);
        System.out.println(System.getProperty("java.home"));//java安装目录
        System.out.println(System.getProperty("os.arch"));//操作系统的架构
        System.out.println(System.getProperty("os.name"));//操作系统的名称
        System.out.println(System.getProperty("os.version"));//操作系统的版本
        System.out.println(System.getProperty("user.name"));//用户的账户名称
        System.out.println(System.getProperty("user.home"));//用户的主目录
        System.out.println(System.getProperty("user.dir"));//用户当前工作目录
    }
}
