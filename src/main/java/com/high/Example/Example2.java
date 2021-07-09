package com.high.Example;

/*
开放型题目：
    设计一个笔记本电脑类，属性随意，并且进行属性私有化，对外提供公开的set和get方法
    设计一个可插拔的接口：InsertDrawable，该接口有什么办法自行定义。
        设计一个鼠标类、键盘类、显示器类、打印机类，实现InsertDrawable接口，并实现方法
    在“笔记本”类中有一个InsertDrawable接口属性，可以让笔记本电脑可插拔鼠标、键盘、显示器、打印机等。

 */
public class Example2 {
    public static void main(String[] args) {
        Computer computer = new Computer("小新锐","联想");
        InsertDrawable mouse = new Mouse();
        InsertDrawable keyboard = new Keyboard();
        InsertDrawable display = new Display();
        InsertDrawable printer = new Printer();
        computer.setInsertDrawable(mouse);
        computer.setInsertDrawable(keyboard);
        computer.device();
    }
}

class Computer {
private String Name;
private String Type;
private InsertDrawable InsertDrawable;

public Computer() {
        }

public Computer(String name, String type) {
        Name = name;
        Type = type;
        }
public void device(){
    if (this.InsertDrawable instanceof Mouse){
        this.InsertDrawable.move();
    }else if (this.InsertDrawable instanceof Printer){
        this.InsertDrawable.print();
    }else if (this.InsertDrawable instanceof Keyboard){
        this.InsertDrawable.doing();
    }else if (this.InsertDrawable instanceof Display){
        this.InsertDrawable.show();
    }

}
public com.high.Example.InsertDrawable getInsertDrawable() {
        return InsertDrawable;
        }

public void setInsertDrawable(com.high.Example.InsertDrawable insertDrawable) {
        InsertDrawable = insertDrawable;
        }

public String getName() {
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

interface InsertDrawable {
    void move();

    void show();

    void print();

    void doing();
}

class Mouse implements InsertDrawable {

    @Override
    public void move() {
        System.out.println("鼠标正在移动！");
    }

    @Override
    public void show() {

    }

    @Override
    public void print() {

    }

    @Override
    public void doing() {

    }
}

class Keyboard implements InsertDrawable {
    @Override
    public void move() {

    }

    @Override
    public void show() {

    }

    @Override
    public void print() {

    }

    @Override
    public void doing() {
        System.out.println("正在敲键盘");
    }
}

class Display implements InsertDrawable {
    @Override
    public void move() {

    }

    @Override
    public void show() {
        System.out.println("显示器正在显示！");
    }

    @Override
    public void print() {

    }

    @Override
    public void doing() {

    }
}

class Printer implements InsertDrawable {
    @Override
    public void move() {

    }

    @Override
    public void show() {

    }

    @Override
    public void print() {
        System.out.println("打印机正在打印！");
    }

    @Override
    public void doing() {


    }
}