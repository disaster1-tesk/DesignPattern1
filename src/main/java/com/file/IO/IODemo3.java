package com.file.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 对于FileInputStream和FileOutputStream都是实现了Closeable， AutoCloseable 这两个接口，而FileOutputStream则实现了 Flushable接口，因为对于
 写入流需要在写完之后就进行刷新操作，不然会操作数据的丢失！
 */
public class IODemo3 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //这种构造方法，在写入数据的时候，会覆盖文件之前写的数据
           // fos= new FileOutputStream("src/com/Data");
//            这种方式是在文件末尾写入数据！
            fos= new FileOutputStream("src/com/Data",true);
            String str = "我是一个中国人，我非常的骄傲！！！";
            fos.write(str.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
