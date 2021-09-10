package hongchengstudy.jdbc.v10;

import hongchengstudy.work.usermanager.JDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Student> studentList = getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static List<Student> getStudentList() {
        String sql = "select * from student;";
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setSex(resultSet.getString(4));
                student.setPassword(resultSet.getString(5));
                studentArrayList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentArrayList;
    }
}
