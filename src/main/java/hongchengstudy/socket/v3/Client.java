package hongchengstudy.socket.v3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        //获取输出流
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        byte[] bytes = null;
        byte[] buff = new byte[1024];
        //接受服务器端发送消息的线程
        new Thread(() -> {
            int read = 0;
            while (true) {
                try {
                    read = inputStream.read(buff);
                    System.out.println("服务器端：" + new String(buff, 0, read));
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
        while (true) {
            System.out.println("客户端：");
            bytes = scanner.next().getBytes();
            //发送数据
            outputStream.write(bytes);
        }
    }
}
