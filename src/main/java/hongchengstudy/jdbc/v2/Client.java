package hongchengstudy.jdbc.v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
executeUpdate:(用来执行DML（数据操纵语言、增加、删除、修改），返回值
execute:（可以执行所有的sql命令，返回的是否有返回set集合的一个boolean值。
executeQuery(可以执行查询语句，返回一个结果set集合resultSet)
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        String sql = "update student set sname = '王威' where sid = 1";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC","root","123456"); Statement st = connection.createStatement()){
            int i = st.executeUpdate(sql);//返回受影响的行数
            System.out.println("i = " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
