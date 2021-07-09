package com.reflect;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReflectDemo6 {
    public static void main(String[] args) throws IOException {
        //通过获取文件路劲，再通过文件路劲来读取文件(第一种方式）
        String path = Thread.currentThread().getContextClassLoader().getResource("Information2.properties").getPath();
        FileReader fr = new FileReader(path);
        Properties pro  = new Properties();
        pro.load(fr);
        fr.close();
        String className = pro.getProperty("className");
        System.out.println(className);


        //通过获取文件路劲，再通过文件路劲来读取文件(第二种方式）
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Information2.properties");
        pro.load(resourceAsStream);
        String className1 = pro.getProperty("className");
        System.out.println(className1);


        //通过获取文件路劲，再通过文件路劲来读取文件(第三种方式,且这种方式只能读取.properties后缀的文件,所以在文件路劲的填写的时候不用加后缀）
        ResourceBundle bundle = ResourceBundle.getBundle("Information2");
        String className2 = bundle.getString("className");
        System.out.println(className2);
    }
}
