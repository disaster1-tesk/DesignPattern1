package com.Thread.High;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
定时器的实现！！！！
 */
public class ThreadDemo5 {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
//        Timer timer = new Timer(true); 守护线程的创建
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        Date date = sdf.parse("2021:02:04 23:24:30");
        timer.schedule(new Timertask(),date,1000*10);
    }
}
class Timertask extends TimerTask {

    @Override
    public void run() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String format = sdf.format(date);
        System.out.println(format+": 完成了一次数据备份！");
    }
}
