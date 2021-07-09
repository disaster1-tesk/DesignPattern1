package hongchengstudy.jdbc.v1;


import java.sql.*;

public class Client {
    public static void main(String[] args)  {
//        Class.forName("com.mysql.jdbc.Driver"); 在jdk1.6之后不需要在显示进行驱动的注册，因为在驱动管理器中获取连接的时候会通过SPI机制进行动态驱动的注册
//        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "123456"); 六点三杠
//       DriverManager.getConnection("jdbc:mysql:///test?serverTimezone=UTC", "root", "123456");只针对链接的数据库为本机的，并且默认端口是3306
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");
             Statement statement = connection.createStatement()) {
            System.out.println("connection = " + connection);
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String sex = resultSet.getString(4);
                System.out.println("id:" + id + " 姓名：" + name + " 出生日期：" + gender + "性别：" + sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
