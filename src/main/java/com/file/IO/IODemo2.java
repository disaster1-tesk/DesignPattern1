package com.file.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
使用以下这种方式进行文件的读取，无法对大文件进行这样的操作，因为byte数组不适合设置太大！
 */
public class IODemo2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/com/Data");
            byte[] bytes = new byte[fis.available()];
            int read = fis.read(bytes);
            System.out.println("数组长度：" +read);
            System.out.println(new String(bytes).toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
