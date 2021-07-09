package hongchengstudy.work.filetransfer;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static int port = 6666;
    public static InetAddress host;

    static {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static File file = new File("D:" + File.separator + "桌面文件" + File.separator + "FIle" + File.separator + "desfile");
    public static File desfile = null;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(host, port);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        byte[] buff = new byte[1024];
        int read = 0;
        while ((read = is.read(buff)) != -1) {
            System.out.println(new String(buff, 0, read));
        }
        String str = scanner.next();
        os.write(str.getBytes());
        new Thread(new Runnable() {
            @Override
            public void run() {
                int read = 0;
                int num = 0;
                String s = new String(buff, 0, read);
                desfile = new File(file.toString() + File.separator + s);
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(desfile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    while ((read = is.read(buff)) != -1) {
                        fos.write(buff);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }).start();
    }
}
