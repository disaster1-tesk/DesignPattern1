package com.file.IO;

import java.io.FileInputStream;
import java.util.Properties;

/*
   基本流：
            FileInputStream(掌握）
            FileOutputStream(掌握）
            FileReader(掌握）
            FileWriter(掌握）

    工具流：
            InputStreamReader(掌握）
            OutputStreamWriter(掌握）


    封装流：
            BufferedInputStream(掌握）
            BufferedOutputStream(掌握）
            BufferedReader(掌握）
            BufferedWriter(掌握）

    系统流：
            PrintStream(掌握）
            WriterStream

    对象流：
            ObjectInputStream(掌握）
            ObjectOutputStream(掌握）

 */
public class IODemo10 {
    public static void main(String[] args) throws Exception{
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream("Information.properties");
        pro.load(fis);

        String username = pro.getProperty("username");
        System.out.println(username);

        String password = pro.getProperty("password");
        System.out.println(password);

        String username1 = pro.getProperty("username1");
        System.out.println(username1);
    }
}
