package com.high.Example;

import java.util.Scanner;

/*
编写程序模拟用户注册：
    1.程序开始执行时，提示用户输入“用户名”和“密码”信息
    2.输入信息之后，后台java程序模拟用户注册
    3.注册时用户名要求长度在[6-14]之间，小于或者大于都表示异常
   注意：
    完成注册的方法放到一个单独的类中、
        异常类自定义即可
        class UserServer{
        }
 */
public class Example6 {
    public static void main(String[] args) {
        System.out.println("-------------------用户注册程序---------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的用户名：");
        String name = scanner.next().trim();
        System.out.println(name);
        System.out.println("请输入您的密码：");
        String password = scanner.next().trim();
        System.out.println(password);
        try {
            new UserServer().register(name, password);
        } catch (NumberLengtheEception e) {
            e.printStackTrace();
        }

    }

}

class UserServer {
    public void register(String name, String password) throws NumberLengtheEception {
        if (name.length() > 14) {
            throw new NumberLengtheEception("用户名长度不能超过14个字符！！");
        } else if (name.length() < 6) {
            throw new NumberLengtheEception("用户名长度不能低于6个字符！！");
        } else if (name ==null||password==null) {
            throw new NumberLengtheEception("用户名或者密码出现空置！");
        } else {
            System.out.println("注册成功！");
        }
    }
}

class NumberLengtheEception extends Exception {
    public NumberLengtheEception() {
    }

    public NumberLengtheEception(String message) {
        super(message);
    }

    public NumberLengtheEception(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberLengtheEception(Throwable cause) {
        super(cause);
    }

    public NumberLengtheEception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
