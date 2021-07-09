package com.high.Enum;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
枚举类就是来表示方法返回值的结果类型：
 */
public class EnumDemo1 {
    public static Seasons getseasons(){
        return Seasons.Autumn;
    }
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis()-1000*60*60*24);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
        String format = sdf.format(date);
        System.out.println(format.toString());
    }
}
 enum Seasons{
    Spring,Summer,Autumn,Winter
}