package hongchengstudy.work.loginforsocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
使用TCP网络编程完成用户登录功能：客户端输入用户名和密码，向服务器发出登录请求；
服务器接收数据并进行判断，如果用户名和密码均是admin，则登录成功，否则登录失败，返回相应响应信息；
客户端接收响应信息并输出登录结果。
1)用户User类已提供构造方法 public User(String username,String password)。
2)客户端采用ObjectOutputStream发送封装了用户名和密码的User对象。
 */
public class Client {
    public static int port = 6666;
    public static InetAddress host;

    static {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(host, port);
        Scanner scanner = new Scanner(System.in);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String passWord = scanner.next();
        User user = new User(name, passWord);
        objectOutputStream.writeObject(user);
    }
}
