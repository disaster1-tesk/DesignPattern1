package hongchengstudy.jdbc.v9;

import hongchengstudy.work.usermanager.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM timemap;");
        while (resultSet.next()){
            String string = resultSet.getString(1);
            String string1 = resultSet.getString(2);
            String string2 = resultSet.getString(3);
            String string3 = resultSet.getString(4);
            Time time = new Time();
            time.setStr_date1(string);
            time.setStr_date2(string1);
            time.setStr_date3(string2);
            time.setStr_date4(string3);
            System.out.println("time = " + time);
        }
        JDBCUtil.close(resultSet,statement,connection);
    }
}
