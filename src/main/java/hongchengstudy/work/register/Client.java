package hongchengstudy.work.register;


import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Register register = new Register();
        System.out.println("========欢迎来到disaster的注册程序========");
        System.out.println("请输入账户：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();
        try {
            register.register(new UserBean(name,pwd));
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
