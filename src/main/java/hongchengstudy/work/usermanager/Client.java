package hongchengstudy.work.usermanager;

import java.sql.*;
import java.util.Scanner;

public class Client {
    private static Statement statement = null;
    private static User user = null;
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        Scanner scanner = new Scanner(System.in);
        String username = null;
        String password = null;
        while (true){
            System.out.println("============欢迎来到disaster的用户管理系统=============");
            System.out.println("请选择功能：");
            System.out.println("1.用户登录");
            System.out.println("2.注册功能");
            System.out.println("3.修改密码功能");
            System.out.println("4.注销账号功能");
            System.out.println("5.退出系统");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    if (Client.user!=null){
                        System.out.println("您已经登录了！");
                        break;
                    }
                    System.out.println("请输入您的用户名称：");
                     username = scanner.next();
                    System.out.println("请输入您的密码：");
                     password =scanner.next();
                    if (!login(connection,username,password)){
                        System.out.println("登录失败，该用户不存在！");
                        break;
                    }
                    System.out.println("用户登录成功！");
                    break;
                case 2:
                    System.out.println("请输入您的用户名称：");
                    username = scanner.next();
                    System.out.println("请输入您的密码：");
                    password =scanner.next();
                    if (!register(connection,username,password)){
                        System.out.println("注册失败！");
                        break;
                    }
                    System.out.println("注册成功！");
                    break;
                case 3:
                    if (Client.user==null){
                        System.out.println("您还未登录");
                        break;
                    }
                    System.out.println("请输入您要修改的后密码：");
                    password = scanner.next();
                    if (!updatePassWord(connection,Client.user,password)){
                        System.out.println("修改失败！");
                        break;
                    }
                    System.out.println("修改成功！");
                    break;
                case 4:
                    if (Client.user==null){
                        System.out.println("您还未登录");
                        break;
                    }
                    if (!writeOff(connection,Client.user)){
                        System.out.println("注销账号失败！");
                        break;
                    }
                    System.out.println("注销账号成功！");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请您重新选择功能：");
                    choose = scanner.nextInt();
                    break;
            }
            JDBCUtil.close(null,statement,connection);
        }

    }

    //用户注册功能
    public static boolean register(Connection connection, String username, String password) throws SQLException {
        if (password.length() < 9) {//对密码进行判断
            System.out.println("输入的密码不能小于9位");
            return false;
        }
        String sql = "SELECT * FROM user WHERE username = '" + username + "'";
        statement = connection.createStatement();//获取statement
        ResultSet resultSet = statement.executeQuery(sql);//对数据库进行用户信息的查询
        if (resultSet.next()) {//表名该用户已经被注册了
            System.out.println("用户已经存在，注册失败！");
            return false;
        } else {
            sql = "INSERT user VALUES(null,'" + username + "','" + password + "');";//
            if (statement.executeUpdate(sql) == 0) {//如果影响的行数为0表示没有将数据插入数据库中
                return false;
            }
        }
        return true;
    }

    //用户登录功能
    public static boolean login(Connection connection, String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ? AND password =?;";
        statement = connection.prepareStatement(sql);
        PreparedStatement ps = (PreparedStatement) statement;
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if (!resultSet.next()) {
            return false;
        }
        user = new User(username,password);
        return true;
    }
    //修改密码功能
    public static boolean updatePassWord(Connection connection,User user,String password) throws SQLException {
        String sql = "UPDATE user SET password = '"+password+ "' WHERE username = ?;";
        statement = connection.prepareStatement(sql);
        PreparedStatement ps = (PreparedStatement) statement;
        ps.setString(1,user.getName());
        if (ps.executeUpdate()==0){
            return false;
        }
        Client.user.setPassword(password);
        return true;
    }
    //注销功能
    public static boolean writeOff(Connection connection,User user) throws SQLException {
        String sql = "DELETE  FROM user WHERE username = '"+user.getName()+"';";
        statement = connection.createStatement();
        if (statement.executeUpdate(sql)==0){
            return false;
        }
        Client.user = null;
        return true;
    }
}
