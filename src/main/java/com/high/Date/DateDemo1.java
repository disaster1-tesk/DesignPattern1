package com.high.Date;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {
    public static void main(String[] args) {
        Date date = new Date();
        //对时间进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss  SSS");
        String format = sdf.format(date);
        //对数字进行格式化
        DecimalFormat df = new DecimalFormat("###,###.0000");
        String format1 = df.format(1234.15);
        //BigDecimal大数据，这种数据类一般用于财务软件的开发，他的范围很大，比double大很多！
        BigDecimal v1 = new BigDecimal("123");
        BigDecimal v2 = new BigDecimal("456");
        BigDecimal add = v1.add(v2);
        System.out.println(add);
        System.out.println(format1);
        System.out.println(date);
        System.out.println(format);
    }
}
