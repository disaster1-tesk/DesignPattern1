package hongchengstudy.socket.v5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                /*while ((str=bufferedReader.readLine())!=null){
                    System.out.println(str);
                }*/
                String filePath = bufferedReader.readLine().split(" ")[1].substring(1);//去掉斜杠才能扫描到本地目录
                if (!filePath.isEmpty()){
                    File file = new File(filePath);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] buff = new byte[1024];
                    outputStream.write("HTTP/2 200 OK\r\n".getBytes());
                    outputStream.write("content-type: text/html\r\n".getBytes());
                    outputStream.write("\r\n".getBytes());
                    int read = 0;
                    while ((read = fileInputStream.read(buff)) != -1) {
                        outputStream.write(buff, 0, read);
                        outputStream.flush();
                    }
                    socket.shutdownOutput();
                    socket.close();
                    fileInputStream.close();
                }else{
                    System.out.println("找不到此文件");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
