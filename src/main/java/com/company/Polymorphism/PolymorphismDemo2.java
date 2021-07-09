package com.company.Polymorphism;

public class PolymorphismDemo2 {
    public static void main(String[] args) {
        Person Master = new Person("Master", "Disaster", "19");
        Animals bird = new Bird("鸟","唧唧");
        Animals fish = new Fish("鱼","花花");
        Master.feed(bird);
        Master.feed(fish);
    }
}

class Person {
    private String Type;
    private String Name;
    private String age;

    public Person() {
    }

    public Person(String type, String name, String age) {
        Type = type;
        Name = name;
        this.age = age;
    }

    //feed方法
    public void feed(Animals animal) {
        System.out.println(this.getType() + this.getName() + "正在喂食" + animal.getType() + animal.getName());
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

class Animals {
    private String Type;
    private String Name;

    public Animals() {
    }

    public Animals(String type, String name) {
        Type = type;
        Name = name;
    }
        //eat方法
    public void eat(){
        System.out.println(this.getType()+this.getName()+"正在吃东西");
    }
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

class Bird extends Animals{

    public Bird() {
    }

    public Bird(String type, String name) {
        super(type, name);
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void dosome(){
        System.out.println("222");
    }
}

class Fish extends Animals{
    public Fish() {
    }

    public Fish(String type, String name) {
        super(type, name);
    }

    @Override
    public void eat() {
        super.eat();
    }
}