package com.company.Static;

/**
 * 静态(Static）关键字的使用：
 */
public class StaticTest1 {
    public static void main(String[] args) {
        Chinese C2 = new Chinese("1231456", "李四");
        Chinese C1 = new Chinese("1231456", "张三");
        System.out.println(C1.IdCard);
        System.out.println(C2.IdCard);
        System.out.println(Chinese.Country);
        System.out.println(C1.Country);
        Chinese.Show("张三", "1256");
        Chinese Chinese = null;
        System.out.println(Chinese.IdCard);
    }
}
class User{
    String name;
    String ID;

    public  String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
class Chinese {
    String IdCard;
    String Name;
    static String Country = "中国";

    public Chinese() {
    }

    public Chinese(String idCard, String name) {
        IdCard = idCard;
        Name = name;
    }

    public static void Show(String name, String IdCard) {
        System.out.println(name + IdCard + "他的国籍是" + Country);
    }
}
