package com.high.Abstract;
/*
抽象类无法实例化，但是通过多态，可以巧妙的实现很多和抽象类有关的操作！！
 */
public class AbstartctDemo1 {
    public static void main(String[] args) {
        //Animal bird = new Bird("小黄", "鸟");
        Animal dog = new Dog("小黑", "狗");
       // bird.dosome();
        dog.dosome();
    }
}

//抽象类
abstract class Animal {
    public Animal() {
    }

    public Animal(String name, String type) {
        Name = name;
        Type = type;
    }

    public abstract void dosome();
    private String Name;
    private String Type;

    public  String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}

 class Bird extends Animal {
    public Bird() {
    }

    public Bird(String name, String type) {
        super(name, type);
    }

    @Override
    public void dosome() {
        System.out.println(this.getType() + this.getName() + "在飞翔！");
    }
}

class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, String type) {
        super(name, type);
    }

    @Override
    public void dosome() {
        System.out.println(this.getType() + this.getName() + "在守家！");
    }
}
