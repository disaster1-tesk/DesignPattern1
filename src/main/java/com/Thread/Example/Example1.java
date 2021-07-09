package com.Thread.Example;

import java.util.Objects;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Ticket ticket = new Ticket("生活中的玛丽", "动作片", 100);
        Customer customer1 = new Customer("disaster01", 20);
        Customer customer2 = new Customer("disaster02", 20);
        Runnable frontdest1 = new FrontDesk(customer1, ticket);
        Runnable frontdest2 = new FrontDesk(customer2, ticket);
        Thread thread1 = new Thread(frontdest1);
        Thread thread2 = new Thread(frontdest2);
        thread1.start();
        thread2.start();
    }
}

class FrontDesk implements Runnable {
    private Customer customer;
    private volatile Ticket ticket;

    public FrontDesk(Customer customer, Ticket ticket) {
        this.customer = customer;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.getNumber()>=0){
            synchronized (ticket) {
                customer.buyTicket(1, ticket);
            }
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

class Ticket {
    private String name;
    private String Type;
    private int Number;

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }

    public Ticket(String name, String type, int Number) {
        this.name = name;
        Type = type;
        this.Number = Number;
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

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}

class Customer {
    private String name;
    private int age;

    public void buyTicket(int Number, Ticket ticket) {
        System.out.println("电影名：" + ticket.getName());
        System.out.println("类型为：" + ticket.getType());
        System.out.println("姓名为" + getName() + "的先生恭喜您" + "购票成功！剩余票数为：" + (ticket.getNumber() - Number));
        ticket.setNumber(ticket.getNumber()-Number);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}