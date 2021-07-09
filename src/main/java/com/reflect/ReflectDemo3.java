package com.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
   Properties结合class文件来获取class文件
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileReader fileReader = new FileReader("Information1.properties");
        Properties pro = new Properties();
        pro.load(fileReader);
        String className = pro.getProperty("ClassName");
        Class aClass = Class.forName(className);
        try {
            aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
