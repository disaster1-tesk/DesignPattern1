package hongchengstudy.work.loginforsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
使用TCP网络编程完成用户登录功能：客户端输入用户名和密码，向服务器发出登录请求；
服务器接收数据并进行判断，如果用户名和密码均是admin，则登录成功，否则登录失败，返回相应响应信息；
客户端接收响应信息并输出登录结果。
1)用户User类已提供构造方法 public User(String username,String password)。
2)客户端采用ObjectOutputStream发送封装了用户名和密码的User对象。
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动！！！");
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Object o = null;
                while (true) {
                    try {
                        if (((o=objectInputStream.readObject()) !=null)){
                            User user = (User)o;
                            if (user.getName().equals("Admin")&&user.getPassWord().equals("admin")){
                                System.out.println("登录成功！");
                            }else{
                                System.out.println("登录失败");
                            }

                        }
                            break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
