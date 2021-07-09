package com.file.IO;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
FileInputStream类中重载了read方法，方法参数不同，那么返回类型不同！
read()，返回的值就是读取的文件中的一个字节的二进制数！
read(byte b[])，那么返回的值就是读取的字节个数！
read(byte b[], int off, int len)，返回值就是读取的字节个数！
 */
public class IODemo1 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        StringBuffer stringBuffer = new StringBuffer();
        int count;
        try {
            fis = new FileInputStream("src/com/Data");
            byte[] bytes = new byte[5];
            int read = fis.read(bytes, 0, bytes.length);
            System.out.println(read);
            while ((count = fis.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes, 0, count));
            }
            System.out.println(stringBuffer);
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
