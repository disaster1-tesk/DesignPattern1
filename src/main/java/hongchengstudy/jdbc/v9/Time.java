package hongchengstudy.jdbc.v9;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Time
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/9 11:06
 * @Version 1.0
 **/
public class Time {
    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4;
    private String str_date1;
    private String str_date2;
    private String str_date3;
    private String str_date4;

    @Override
    public String toString() {
        return "Time{" +
                "date1=" + date1 +
                ", date2=" + date2 +
                ", date3=" + date3 +
                ", date4=" + date4 +
                ", str_date1='" + str_date1 + '\'' +
                ", str_date2='" + str_date2 + '\'' +
                ", str_date3='" + str_date3 + '\'' +
                ", str_date4='" + str_date4 + '\'' +
                '}';
    }

    public Time() {
    }

    public Time(Date date1, Date date2, Date date3, Date date4) {
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
        this.date4 = date4;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    public String getStr_date1() {
        SimpleDateFormat simpleDateFormat =null;
        if (date1!=null){
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(date1);
        }
        return null;
    }

    public void setStr_date1(String str_date1) {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");

        this.str_date1 = str_date1;
    }

    public String getStr_date2() {
        SimpleDateFormat simpleDateFormat =null;
        if (date2!=null){
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(date2);
        }
        return null;
    }

    public void setStr_date2(String str_date2) {
        this.str_date2 = str_date2;
    }

    public String getStr_date3() {
        SimpleDateFormat simpleDateFormat =null;
        if (date3!=null){
            simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            return simpleDateFormat.format(date3);
        }
        return null;
    }

    public void setStr_date3(String str_date3) {
        this.str_date3 = str_date3;
    }

    public String getStr_date4() {
        SimpleDateFormat simpleDateFormat =null;
        if (date4!=null){
            simpleDateFormat = new SimpleDateFormat("yyyy");
            return simpleDateFormat.format(date4);
        }
        return null;
    }

    public void setStr_date4(String str_date4) {
        this.str_date4 = str_date4;
    }
}
