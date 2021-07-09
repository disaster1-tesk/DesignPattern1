package hongchengstudy.socket.v1;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //与服务器进行连接
        Socket socket = new Socket("127.0.0.1", 6666);
        //获取输出流
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        byte[] buff = new byte[1024*2];
        while (true){
            System.out.println("客户端：");
            byte[] bytes = scanner.next().getBytes();
            //发送数据
            outputStream.write(bytes);
            //接收数据
            int read = inputStream.read(buff);
            System.out.println("服务器端："+new String(buff, 0, read));
        }
        //关闭资源
    }
}
