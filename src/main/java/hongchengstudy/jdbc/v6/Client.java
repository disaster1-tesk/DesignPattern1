package hongchengstudy.jdbc.v6;

import java.sql.*;
import java.util.ArrayList;

/*
jdbc批处理：batch
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student(null, "disaster1", "2021-07-02", "男", "123456"));
        studentArrayList.add(new Student(null, "disaster3", "2021-07-02", "女", "123456"));
        studentArrayList.add(new Student(null, "disaster4", "2021-07-02", "女", "123456"));
        studentArrayList.add(new Student(null, "disaster6", "2021-07-02", "男", "123456"));
        studentArrayList.add(new Student(null, "disaster7", "2021-07-02", "男", "123456"));
        String sql = "insert student values (null,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql:///test?serverTimezone = UTC", "root", "123456"); PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Student student : studentArrayList) {
                ps.setString(1,student.getName());
                ps.setString(2,student.getAge());
                ps.setString(3,student.getSex());
                ps.setString(4,student.getPassword());
                ps.addBatch();
            }
            int[] ints = ps.executeBatch();
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
