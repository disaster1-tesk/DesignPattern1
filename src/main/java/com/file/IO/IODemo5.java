package com.file.IO;

import java.io.FileWriter;
import java.io.IOException;

public class IODemo5 {
    public static void main(String[] args) {
        FileWriter fiw = null;
        try {
            fiw = new FileWriter("Data2");
            fiw.write("我是一个中国人！");
            fiw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fiw != null) {
                try {
                    fiw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
