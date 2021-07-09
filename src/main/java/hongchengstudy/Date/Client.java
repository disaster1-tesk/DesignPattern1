package hongchengstudy.Date;

import java.time.LocalDate;
import java.util.Date;

/*
注意事项：
1.不要在程序中写死一年为 365 天，避免在公历闰年时出现日期转换错误或程序逻辑错误。
2.获取当前毫秒数：System.currentTimeMillis(); 而不是 new Date().getTime()
3.日期格式化时，传入 pattern 中表示年份统一使用小写的 y。
4.不允许在程序任何地方中使用：1）java.sql.Date。 2）java.sql.Time。3）java.sql.Timestamp。
5.在日期格式中分清楚大写的 M 和小写的 m，大写的 H 和小写的 h 分别指代的意义。
说明：日期格式中的这两对字母表意如下：
1） 表示月份是大写的 M；
2） 表示分钟则是小写的 m；
3） 24 小时制的是大写的 H；
4） 12 小时制的则是小写的 h。
 */
public class Client {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(1000);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));

        int daysOfThisYear = LocalDate.now().lengthOfYear();
        int i = LocalDate.of(2008, 1, 1).lengthOfYear();
        System.out.println(daysOfThisYear);
        System.out.println(i);
    }
}
