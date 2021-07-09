package com.file.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
File这个类其实就是为了方便我们管理文件目录所创造出来的一个类，作用类似于String
 */
public class FileDemo1 {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\桌面文件\\文件夹\\文本文档");
//        如果文件不存在，以文件的方式创建文件File
       /* if (!file.exists()){
            file.createNewFile();
        }*/
//      如果文件存在，以目录的形式创建文件
        /*if (!file.exists()){
            file.mkdir();
        }*/
//        如果文件不存在，创建整个目录
      /*  if (!file.exists()){
            file.mkdirs();
        }*/
//        输出File的文件名
        String name = file.getName();
        System.out.println(name);
//        输出File文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
//        获取File文件的父目录
        String parent = file.getParent();
        System.out.println(parent);
//        获得目录下面所有的子目录
        File[] files = file.listFiles();
        for (File f: files) {
            System.out.println(f.getName());
        }
//        获取文件上次修改的毫秒数（这里的毫秒数是从1970年开始算的毫秒数）
        long l = file.lastModified();
        Date time = new Date(l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        String format = sdf.format(time);
        System.out.println("文件上次修改的时间："+format);
    }
}
