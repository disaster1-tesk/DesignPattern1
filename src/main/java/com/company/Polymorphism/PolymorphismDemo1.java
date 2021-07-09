package com.company.Polymorphism;

/**
 * 多态
 */
public class PolymorphismDemo1 {
    public static void main(String[] args) {
        Animal cat = new Cat("小花", "猫");
        Animal dog = new Dog("小黄", "狗");
        if (cat instanceof Cat){
            Cat c = (Cat) cat;
            c.catchmouse();
        }else if(cat instanceof Dog){
            Dog c =  (Dog) cat;
            c.protecthome();
        }
        if (dog instanceof Cat){
            Cat d = (Cat) dog;
            d.catchmouse();
        }else if(dog instanceof Dog){
            Dog d =  (Dog) dog;
            d.protecthome();
        }
    }

}

class Animal {
    private String name;
    private String Type;

    public Animal() {
    }

    public Animal(String name, String type) {
        this.name = name;
        Type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void dosome() {
        System.out.println("Animal做一些事");
    }
}

class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, String type) {
        super(name, type);
    }

    @Override
    public void dosome() {
        System.out.println("猫走猫步！");
    }
    public void catchmouse(){
        System.out.println("猫正在抓老鼠！");
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
        System.out.println("狗在汪汪汪的叫！");
    }
    public void protecthome(){
        System.out.println("狗在守家！");
    }
}
