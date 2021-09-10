package showtable.two;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    private static String testName;
    static {
        try {
            Properties pro = new Properties();
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
            pro.load(resourceAsStream);
            url = ""+pro.remove("url");
            user = ""+pro.remove("user");
            password = ""+pro.remove("password");
            driver = ""+pro.remove("driver");
//            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    //获取Connection
    public static Connection getConnection()  {
        Connection conn = null;
        try {
            DriverManager.setLogWriter(new PrintWriter(System.out));
            conn = DriverManager.getConnection(url, user, password);
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()){
                System.out.println(drivers.nextElement());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源
    public static void close(ResultSet rs, Statement st, Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
