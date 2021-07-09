package hongchengstudy.jdbc.v3;

import java.sql.*;

public class Client {
    public static void main(String[] args) {
        boolean flag = false;
        String name = "'admin'";
        String password = "'123' OR '1'='1';";
        String sql = "select * from student where sname=" + name + "AND password="+password;
        System.out.println("sql = " + sql);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC","root","123456"); Statement st = connection.createStatement()){
//            ResultSet resultSet = st.executeQuery(sql);
            boolean execute = st.execute(sql);
            flag = execute;
            /*while (resultSet.next()){
                flag = true;
                int id = resultSet.getInt(1);
                String sname = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String spassword = resultSet.getString(5);
                System.out.println("id:" + id + " 姓名：" + sname + " 出生日期：" + gender + "性别：" + sex+"密码："+spassword);
            }*/
            if (flag){
                System.out.println("登录成功！");
            }else{
                System.out.println("登录失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
