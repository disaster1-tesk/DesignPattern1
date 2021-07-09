package com.Thread.High;

class TreadDemo1 {
    public static void main(String[] args) {
        AccountThread accountThread = new AccountThread(new Account("acount01",10000),(double)2000);
        Thread thread = new Thread(accountThread);
        Thread thread1 = new Thread(accountThread);
        thread.start();
        thread1.start();
    }
}


class AccountThread implements Runnable{
    private Account account;
    private Double number;
    public AccountThread(Account account,Double number) {
        this.account = account;
        this.number = number;
    }

    @Override
    public void run() {
        this.account.withdrow(number);

    }
}

class Account{
    private String name;
    private double money;
    Object o = new Object();
    public void withdrow(double number){
        synchronized (o){
            double before = this.getMoney();
            double after = before-number;
            this.setMoney(after);
            System.out.println(this.getName()+"取款成功，余额："+this.getMoney());
        }
    }
    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}