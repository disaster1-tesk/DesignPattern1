package hongchengstudy.jdbc.v7;

import java.sql.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的账号:");
        String name = scanner.next();
        System.out.println("请输入您的密码：");
        String password = scanner.next();
        Register.execute(name,password);
    }
}

class Register {
    public static boolean execute(String name, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC", "root", "123456"); PreparedStatement ps = connection.prepareStatement("CALL register(?,?)")) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                System.out.println("登录成功！");
            } else {
                System.out.println("账号或密码输入有误,登录失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}