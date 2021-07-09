package hongchengstudy.work.formatdate;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Client {
    public static void main(String[] args) {
        Date date = new Date();
        formatDate(date, Locale.CHINA);
        formatDate(date, Locale.US);
        formatDate(date, Locale.CANADA);
        formatDate(date, Locale.JAPAN);
        formatDate(date, Locale.FRENCH);
        formatDate(date, Locale.ENGLISH);
        formatDate(date, Locale.GERMAN);
    }

    public static void formatDate(Date date, Locale aLocale) {
        DateFormat formatter = SimpleDateFormat.getDateTimeInstance(DateFormat.FULL, SimpleDateFormat.MEDIUM, aLocale);
        String formatDate = formatter.format(date);
        if (aLocale == Locale.CHINA) {
            System.out.println("中国日期：" + formatDate);
        } else if (aLocale == Locale.US) {
            System.out.println("美国日期：" + formatDate);
        } else if (aLocale == Locale.CANADA) {
            System.out.println("加拿大日期：" + formatDate);
        } else if (aLocale == Locale.JAPAN) {
            System.out.println("日本日期：" + formatDate);
        } else if (aLocale == Locale.FRENCH) {
            System.out.println("法国日期：" + formatDate);
        } else if (aLocale == Locale.ENGLISH) {
            System.out.println("英国日期：" + formatDate);
        } else if (aLocale == Locale.GERMAN) {
            System.out.println("德国日期：" + formatDate);
        }

    }
}
