package hongchengstudy.socket.v3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        //开启服务器
        System.out.println("服务器端开启...");
        ServerSocket serverSocket = new ServerSocket(6666);
        //监听客户端
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        byte[] buff = new byte[1024];
        //监听客户端发送的消息
        new Thread(()->{
            int read = 0;
            while (true){
                try {
                    read = inputStream.read(buff);
                    System.out.println("客户端："+new String(buff, 0, read));
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        socket.close();
                        serverSocket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
        while (true){
            //发送数据
            System.out.println("服务器端：");
            byte[] bytes = scanner.next().getBytes();
            outputStream.write(bytes);
        }
    }
}
