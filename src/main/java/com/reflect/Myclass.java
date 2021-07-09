package com.reflect;

public class Myclass {

    static {
        System.out.println("静态代码块执行！");
    }


    public String name;
    int age;
    protected double leght;
    private long weight;

    @Override
    public String toString() {
        return "Myclass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", leght=" + leght +
                ", weight=" + weight +
                '}';
    }

    public Myclass() {
    }

    public Myclass(String name, int age, double leght, long weight) {
        this.name = name;
        this.age = age;
        this.leght = leght;
        this.weight = weight;
    }

    public void dosomething() {
        System.out.println("dosomething！！！！");
    }

    private boolean login(String name, String password) {
        if (name.equals("admin") && password.equals("123")) {
            System.out.println("登录成功");
            return true;
        }
        return false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLeght() {
        return leght;
    }

    public void setLeght(double leght) {
        this.leght = leght;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
}
