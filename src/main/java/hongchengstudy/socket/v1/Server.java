package hongchengstudy.socket.v1;


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
        while (true){
            //读取数据
            int read = inputStream.read(buff);
            System.out.println("客户端："+new String(buff, 0, read));
            //发送数据
            System.out.println("服务器端：");
            byte[] bytes = scanner.next().getBytes();
            outputStream.write(bytes);
        }
    }
}
