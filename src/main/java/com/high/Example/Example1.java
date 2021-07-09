package com.high.Example;

public class Example1 {
    public static void main(String[] args) {
        Doing bird = new Bird("鸟", "小花");
        bird.doing();
        if (bird instanceof Animal) {
            Animal a = (Animal) bird;
            a.eat();
        } else {
            System.out.println("强转失败！");
        }
        Animal a = new Bird("鸟","小红");
        a.eat();
    }
}

abstract class Animal {
    private String Type;
    private String Name;

    public Animal() {
    }

    public Animal(String type, String name) {
        Type = type;
        Name = name;
    }

    public void eat() {
        System.out.println("吃东西！");
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

interface Doing {
    void doing();
}

class Bird extends Animal implements Doing {
    public Bird(String type, String name) {
        super(type, name);
    }

    @Override
    public void doing() {
        System.out.println(
                "鸟在飞翔、111"
        );
    }
}