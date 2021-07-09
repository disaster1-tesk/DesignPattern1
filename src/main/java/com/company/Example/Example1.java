package com.company.Example;

import java.util.Scanner;

/*
写一个名为Account的类模拟账户。
该类包括的属性：账户id  余额balance  年利率 anualInterestRate
包含的方法：各属性的set和get方法 取款方法withdraw 存款方法deposit

写一个测试程序，
    创建一个Customer，名字叫Jane Smith 他有一个账号为1000，余额为2000，年利率为1.5
    对Jane Smith操作：
    存入100元，再取出960元，再取出2000元。
    打印Jane Smith的基本信息
    信息如下显示：
        成功存入：100
        成功取出：960
        余额不足，取钱失败

        */
public class Example1 {

    public static void main(String[] args) {
        System.out.println("--------------------------银行模拟程序------------------------");
        System.out.println("功能：");
        Account JaneSmith = new Account("Jane Smith",1000.0, 2000.0, 1.5);
        while (true) {
            System.out.println("1.存款");
            System.out.println("2.取款");
            System.out.println("3.查看账户余额");
            System.out.println("请输入你想进行的操作：");
            Scanner scanner = new Scanner(System.in);
            int flag = scanner.nextInt();
            if (flag == 1) {
                JaneSmith.deposit();
            } else if (flag == 2) {
                JaneSmith.withdraw();
            } else {
                JaneSmith.showbalance();
            }
        }
    }
}

class Account {
    private String name;
    private Double id;
    private Double balance;
    private Double anualInterestRate;


    public Account() {
    }

    public Account(String name,Double id, Double balance, Double anualInterestRate) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.anualInterestRate = anualInterestRate;
    }

    //查看余额
    public void showbalance() {
        System.out.println("尊敬的" + this.name+"您的账户余额为："+this.balance);
        System.out.println("---------------------------------------------");
    }

    //取款方法
    public void withdraw() {
        System.out.println("您正在进行取款操作，请输入您要取款金额：");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        this.balance -= count;
        if (balance < 0) {
            System.out.println("余额不足，取钱失败");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("成功取款：" + count + "元");
            System.out.println("取款成功！！账户余额" + this.balance);
            System.out.println("---------------------------------------------");
        }

    }

    //存款方法
    public void deposit() {
        System.out.println("您正在进行存款操作，请输入您要存款金额：");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        this.balance += count;
        System.out.println("存款" + count + "元");
        System.out.println("存款成功！！账户余额" + this.balance);
        System.out.println("---------------------------------------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAnualInterestRate() {
        return anualInterestRate;
    }

    public void setAnualInterestRate(Double anualInterestRate) {
        this.anualInterestRate = anualInterestRate;
    }
}
