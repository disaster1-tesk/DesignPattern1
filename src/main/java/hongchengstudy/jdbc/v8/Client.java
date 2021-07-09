package hongchengstudy.jdbc.v8;

import java.sql.*;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/8 17:07
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) throws SQLException {
        String sql = "update bank set balance = balance -2000 where cid =1001";
        String sql1 = "update bank set balance = balance +2000 where cid =1002";
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC", "root", "123456");
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
//            int a = 10 / 0;
            ps = connection.prepareStatement(sql1);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            ps.close();
            connection.close();
        }
    }
}
