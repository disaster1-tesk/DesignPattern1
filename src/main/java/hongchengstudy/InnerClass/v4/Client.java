package hongchengstudy.InnerClass.v4;


import java.util.Random;
import java.util.Scanner;

public class Client {
    protected static int userIndex = -1;
    protected static User user = null;

    public static void main(String[] args) {
        int random = new Random().nextInt(100000);
        Operation operation = new Operation(20);
        while (true) {
            System.out.println("=========================欢迎来到Disaster的大富翁游戏=======================");
            System.out.println("请您选择相关的选项：");
            System.out.println("1.注册用户");
            System.out.println("2.登录用户");
            System.out.println("3.抽奖");
            System.out.println("4.查询");
            System.out.println("5.修改密码");
            System.out.println("6.删除账号");
            System.out.println("                     其他数字退出系统");
            System.out.println("=========================");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    while (true) {
                        System.out.println("请输入您的账号：");
                        String name = sc.next();
                        System.out.println("请输入您的密码：");
                        String password = sc.next();
                        User user1 = new User(name, password, new Random().nextInt(30000000));
                        if (operation.register(user1) >= 0) {
                            System.out.println("用户名          密码              会员号");
                            System.out.println(user1.getName() + "           " + user1.getPassWord() + "       " + user1.getVipID());
                        } else {
                            System.out.println("注册失败");
                        }
                        System.out.println("还需要继续注册吗？(Y/N)");
                        String next = sc.next();
                        if (next.equals("N"))
                            break;
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("请输入您的账号：");
                        String name = sc.next();
                        System.out.println("请输入您的密码：");
                        String password = sc.next();
                        userIndex = operation.login(name, password);
                        if ((userIndex) >= 0) {
                            System.out.println("登录成功！");
                            user = operation.getUserList()[userIndex];
                            break;
                        } else {
                            System.out.println("登录失败！");
                        }
                        System.out.println("您是否重新登录？（Y/N）");
                        String flog = sc.next();
                        if (flog.equals("N")) break;
                    }
                    break;
                case 3:
                    if (user != null) {
                        operation.lottery(random);
                    } else {
                        System.out.println("需要用户先登录才能使用抽奖功能");
                    }
                    break;
                case 4:
                    operation.findAll();
                    break;
                case 5:
                    while (true) {
                        System.out.println("请输入想要修改的密码：");
                        String passWord = sc.next();
                        if (operation.updatePassWord(userIndex, passWord)) {
                            System.out.println("修改成功");
                            break;
                        } else {
                            System.out.println("修改失败！");
                        }
                        System.out.println("您是否要重新修改密码？（Y/N）");
                        String flog = sc.next();
                        if (flog.equals("N")) break;
                    }
                    break;
                case 6:
                    while (true) {
//                        System.out.println("请输入您想要删除的用户：");
                        if (operation.deleteUser(userIndex)) {
                            System.out.println("删除成功！");
                            break;
                        } else {
                            System.out.println("删除失败！");
                        }
                        System.out.println("您是否要重新删除？（Y/N）");
                        String flog = sc.next();
                        if (flog.equals("N")) break;
                    }
                    break;
            }
        }
    }
}
