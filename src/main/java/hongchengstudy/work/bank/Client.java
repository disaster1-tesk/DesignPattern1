package hongchengstudy.work.bank;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===========登录============");
        System.out.println("请输入您的账号：");
        String name = scanner.next();
        System.out.println("请输入您的密码：");
        String passWord = scanner.next();
        if (!Login.login(name, passWord)) {
            System.out.println("输入的账号或者密码错误！");
        } else {
            System.out.println("登录成功！");
            while (true) {
                System.out.println("==================欢迎来到disaster的银行系统================");
                System.out.println("1.存款");
                System.out.println("2.取款");
                System.out.println("请选择功能：");
                int flag = scanner.nextInt();
                switch (flag) {
                    case 1:
                        System.out.println("请输入您想存取的金额：");
                        int i = MoneyUtil.typeConversion(scanner.next());
                        if (i == -1) {
                            System.out.println("存款失败！");
                        } else {
                            Business.saveMoney(i);
                            System.out.println("您的余额为：" + Business.getBalance());
                        }
                        break;
                    case 2:
                        System.out.println("请输入您想取的金额：");
                        int i1 = MoneyUtil.typeConversion(scanner.next());
                        if (i1 == -1) {
                            System.out.println("取款失败！");
                        } else {
                            try {
                                Business.getMoney(i1);
                            } catch (MoneyException e) {
                                e.printStackTrace();
                            } finally {
                                System.out.println("您的余额为：" + Business.getBalance());
                            }
                        }
                        break;
                }
            }
        }
    }
}
