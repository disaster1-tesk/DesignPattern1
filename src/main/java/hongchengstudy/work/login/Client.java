package hongchengstudy.work.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> userArrayList = new ArrayList<>();
        Login login = new LoginImpl(userArrayList);
        while (true) {
            System.out.println("====================欢迎来到disaster的登录注册界面==================");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("请输入您的操作指令：");
            int operation = scanner.nextInt();
            if (operation == 1) {
                System.out.println("请输入您的账户：");
                String name = scanner.next();
                System.out.println("请输入您的密码：");
                String passWord = scanner.next();
                if (login.login(new User(name, passWord))) {
                    System.out.println("登录成功");
                }else{
                    System.out.println("登录失败！");
                }
            }else if (operation==2){
                System.out.println("请输入您的账户：");
                String name = scanner.next();
                System.out.println("请输入您的密码：");
                String passWord = scanner.next();
                if (login.register(new User(name, passWord))) {
                    System.out.println("注册成功");
                }else{
                    System.out.println("注册失败");
                }

            }
        }
    }
}
