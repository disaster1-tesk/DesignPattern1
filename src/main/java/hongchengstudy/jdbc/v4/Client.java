package hongchengstudy.jdbc.v4;


import java.sql.*;

public class Client {
    public static void main(String[] args) {
        String sql = "select * from student where sname = ? ";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC","root","123456"); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,"王威");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String sname = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String spassword = resultSet.getString(5);
                System.out.println("id:" + id + " 姓名：" + sname + " 出生日期：" + gender + "性别：" + sex+"密码："+spassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
