package com.company.Super;

/*
            super关键字
super 不是引用。
super也不是保存内存地址，super也不指向任何对象。
super只是代表当前对象内部的那一块父类型的特征。
this是引用！！
 */
public class SuperDemo1 {
    public static void main(String[] args) {
        new superman("chaoren","20","superman").dosome();
    }
}

class People {
    private String Name;
    private String Age;
    private String Type;

    public People() {
    }

    public People(String name, String age, String type) {
        Name = name;
        Age = age;
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}

class superman extends People {
    private String height;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public superman() {
    }

    public superman(String name, String age, String type) {
        super(name, age, type);
    }
    public void dosome(){
        System.out.println("超人正在做事");
        System.out.println(this.getName());
        System.out.println(super.getName());
        System.out.println(getName());
    }
}