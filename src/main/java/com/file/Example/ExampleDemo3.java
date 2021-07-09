package com.file.Example;

import java.io.*;

/*
拷贝目录：

 */
public class ExampleDemo3 {
    public static void main(String[] args) {

    }
}

class CopyUtil {
    public static void copyfile(File sourcefile,File destfile){
       /* if (sourcefile.isFile()){
            FileInputStream fis ;
            FileOutputStream fos;
            try {
                fis = new FileInputStream("");
                fos = new FileOutputStream("");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }*/
        File[] files = sourcefile.listFiles();
        for (File f: files) {
            String absolutePath = f.getAbsolutePath();
            String substring = sourcefile.getAbsolutePath().substring(3);
            System.out.println(substring);
            copyfile(f,destfile);
        }


    }

}