package hongchengstudy.calendar;

import java.util.Calendar;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        Calendar build = new Calendar.Builder()
                .setDate(2021, 5, 21)
                .build();
        build.setTime(date);
        System.out.println(build);
        System.out.println(instance);
        System.out.println(build.get(Calendar.MONTH));
        System.out.println(build.get(Calendar.HOUR_OF_DAY));
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH));
        System.out.println(instance.get(Calendar.DATE));
        System.out.println(instance.get(Calendar.HOUR_OF_DAY));

    }
}
