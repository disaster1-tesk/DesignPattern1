package com.company.This;

/**
 * 综合实例
 */
public class ThisTest2 {
    public static void main(String[] args) {
        Man man = new Man("123","19","12356");
        Woman woman = new Woman("美女","18","12456");
        man.setWife(woman);
       /* woman.setHusband(man);
        new ThisTest2().getmerry(man,woman);*/
        getmerry(man, woman);
    }

    public static void getmerry(Man man, Woman woman) {
        System.out.println(man.getWife().getName() + "的男人是" + "--->" + man.getName());
    }
}

class Human {
    private String name;
    private String age;
    private String IdCard;

    public Human(String name, String age, String idCard) {
        this.name = name;
        this.age = age;
        IdCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }
}

//男人类
class Man extends Human {
    Woman wife;

    public Man(String name, String age, String idCard) {
        super(name, age, idCard);
    }

    public Man(String name, String age, String idCard, Woman wife) {
        super(name, age, idCard);
        this.wife = wife;
    }
    public Woman getWife() {
        return wife;
    }

    public void setWife(Woman wife) {
        this.wife = wife;
    }
}

//女人类
class Woman extends Human {
    Man husband;

    public Woman(String name, String age, String idCard) {
        super(name, age, idCard);
    }

    public Woman(String name, String age, String idCard, Man husband) {
        super(name, age, idCard);
        this.husband = husband;
    }

    public Man getHusband() {
        return husband;
    }

    public void setHusband(Man husband) {
        this.husband = husband;
    }

}
