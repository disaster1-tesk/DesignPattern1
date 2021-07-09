package hongchengstudy.socket.v4;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\桌面文件\\FIle\\favicon.ico");
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream oos = socket.getOutputStream();
        InputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buff = new byte[1024 * 2];
        int read = bis.read(buff);
     /*   while (read != -1) {
            oos.write(buff, 0, read);
            oos.flush();
            read = bis.read(buff);//-1
            System.out.println(read);
        }*/
//       int read = 0;
        while ((read=bis.read(buff))!=-1){
//            fos.write(buff,0,read);
            oos.write(buff,0,read);
            oos.flush();
            System.out.println(read);
        }
//        socket.close();
//        socket.shutdownOutput();
        oos.close();
        System.out.println("客户端isOutputShutdown:" + socket.isOutputShutdown());
        System.out.println("客户端isInputShutdown:" + socket.isInputShutdown());
        System.out.println("客户端isConnected:" + socket.isConnected());
        System.out.println("客户端isBound:" + socket.isBound());
        System.out.println("客户端isClosed:" + socket.isClosed());
        oos.write(new byte[10]);
        System.out.println("上传成功！");
        socket.close();
        fis.close();
    }
}
