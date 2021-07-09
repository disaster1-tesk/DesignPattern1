package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/6 22:10
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("192.168.20.43", 8888);
        OutputStream oos = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(is);
        DataOutputStream dataOutputStream = new DataOutputStream(oos);
        Scanner scanner = new Scanner(System.in);
        new Thread(()->{
            while (true){
                try {
                    String str = dataInputStream.readUTF();
                    System.out.println("str = " + str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true){
            dataOutputStream.writeUTF(scanner.next());
            dataOutputStream.flush();
        }

    }
}
