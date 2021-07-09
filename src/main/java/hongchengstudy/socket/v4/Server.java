package hongchengstudy.socket.v4;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\桌面文件\\FIle\\abc.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        System.out.println("服务器开启！");
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        byte[] buff = new byte[1024 * 2];
        int read = 0;
        while ((read = is.read(buff)) != -1) {
//            fos.write(buff,0,read);
            bos.write(buff, 0, read);
            bos.flush();
            System.out.println(read);
        }
//        accept.close();

        System.out.println("服务器端isOutputShutdown:" + accept.isOutputShutdown());
        System.out.println("服务器端isInputShutdown:" + accept.isInputShutdown());
        System.out.println("服务器端isConnected:" + accept.isConnected());
        System.out.println("服务器端isBound:" + accept.isBound());
        System.out.println("服务器端isClosed:" + accept.isClosed());
        System.out.println("文件传输成功！");
        serverSocket.close();
        accept.close();
        fos.close();
    }
}
