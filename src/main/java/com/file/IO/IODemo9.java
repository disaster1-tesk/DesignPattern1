package com.file.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
System中的out的println方法与PrintStream方法挂钩！
日志信息框架的实现：

 */
public class IODemo9 {
    public static void main(String[] args) throws Exception {
        LogUtil.Log("这是一个日志工具类！");
    }
}
class LogUtil{
    public static void Log(String msg) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream("Log.txt",true));
        System.setOut(ps);
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss SSS");
        String format = sdf.format(time);
        System.out.println(format+":"+msg);
        ps.close();
    }
}
