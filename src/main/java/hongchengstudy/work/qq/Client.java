package hongchengstudy.work.qq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int count = 0;
        String userName = "disaster";
        String passWord = "123456";
        while (true) {
            System.out.println("===========================欢迎来到disaster的qq系统=============================");
            Map<String, String> userInfo = getUserInfo();
            if (!login(userInfo, userName, passWord)) {
                count++;
                if (count == 3) {
                    System.out.println("您的机会已全部用完，不能再进行登录");
                    break;
                }
                System.out.println("用户名或密码输入有误，请重新登录，当前输错次数为：" + count);
            } else {
                System.out.println("登录成功！！");
                break;
            }
        }
    }

    public static boolean login(Map userInfo, String userName, String passWord) {
        if (userInfo != null && (userInfo.get("userName") != null) && (userInfo.get("passWord") != null)) {
            if ((userInfo.get("userName").equals(userName)) && userInfo.get("passWord").equals(passWord)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> getUserInfo() {
        Map<String, String> userInformation = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = scanner.next();
        System.out.println("请输入密码：");
        String passWord = scanner.next();
        userInformation.put("userName", userName);
        userInformation.put("passWord", passWord);
        return userInformation;
    }
}

