package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client2
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/7 11:51
 * @Version 1.0
 **/
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.20.43", 8888);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(os);
        DataInputStream dataInputStream = new DataInputStream(is);
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
