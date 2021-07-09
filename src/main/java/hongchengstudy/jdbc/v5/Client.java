package hongchengstudy.jdbc.v5;

import java.sql.*;


public class Client {
    public static void main(String[] args) {
        String sql = "CALL select1;";
        String sql1 = "CALL doadd(?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC","root","123456");CallableStatement cs = connection.prepareCall(sql1)){
            cs.setInt(1,5);
            cs.setInt("b",10);
            cs.registerOutParameter(3,Types.INTEGER);
            cs.execute();
            int anInt = cs.getInt(3);
            System.out.println("anInt = " + anInt);
            /*ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String sname = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String spassword = resultSet.getString(5);
                System.out.println("id:" + id + " 姓名：" + sname + " 出生日期：" + gender + "性别：" + sex+"密码："+spassword);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
