package hongchengstudy.work.filetransfer;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动！！！");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.toString() + "已连接");
            new Thread(new MyChannel(socket)).start();
        }
    }

    public static class MyChannel implements Runnable {
        private BufferedOutputStream bos;
        private BufferedInputStream bis;
        private FileInputStream fis;
        private FileOutputStream fos;
        private Socket socket;
        private File srcFile = new File("D:" + File.separator + "桌面文件" + File.separator + "FIle" + File.separator + "srcfile");

        public MyChannel(Socket socket) {
            try {
                this.socket = socket;
                bos = new BufferedOutputStream(this.socket.getOutputStream());
                bis = new BufferedInputStream(this.socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            File[] files = srcFile.listFiles();
            int num = 1;
            try {
                menu();
                for (File file : files) {
                    bos.write((num + "." + file.getName() + "\t").getBytes());
                    bos.flush();
                    num++;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int read = 0;
                        int read1 = 0;
                        File file = null;
                        byte[] buff = new byte[1024];
                        byte[] buffF2 = new byte[1024];
                        try {
                            while ((read = bis.read(buff)) != -1) {
                                String str = new String(buff, 0, read);
                                if (str.equals("1")) {
                                    file = new File(srcFile.toString() + File.separator + "favicon.ico");
                                    setFis(new FileInputStream(file));
                                    setFos(new FileOutputStream(file));
                                    fos.write("favicon.ico".getBytes());
                                } else if (str.equals("2")) {
                                    file = new File(srcFile.toString() + File.separator + "a.txt");
                                    setFis(new FileInputStream(file));
                                    setFos(new FileOutputStream(file));
                                    fos.write("a.txt".getBytes());
                                } else if (str.equals("3")) {
                                    file = new File(srcFile.toString() + File.separator + "晴天 - 周杰伦.mp3");
                                    setFis(new FileInputStream(file));
                                    setFos(new FileOutputStream(file));
                                    fos.write("晴天 - 周杰伦.mp3".getBytes());
                                } else {
                                    while ((read1 = fis.read(buffF2)) != -1) {
                                        fos.write(buffF2);
                                    }
                                    socket.shutdownOutput();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                        }
                    }
                }).start();
            } catch (IOException e) {
                CloseUtil.closeAll(bos, bis);
            } finally {
                try {
                    socket.shutdownOutput();
                } catch (IOException e) {
                    CloseUtil.closeAll(bos, bis);
                }
            }

        }

        private void menu() throws IOException {
            bos.write("欢迎来到disaster的文件传输系统".getBytes());
            bos.flush();
            bos.write("\n".getBytes());
            bos.flush();
            bos.write("请选择你想下载的文件：".getBytes());
            bos.flush();
            bos.write("\n".getBytes());
            bos.flush();
        }

        public FileInputStream getFis() {
            return fis;
        }

        public void setFis(FileInputStream fis) {
            this.fis = fis;
        }

        public FileOutputStream getFos() {
            return fos;
        }

        public void setFos(FileOutputStream fos) {
            this.fos = fos;
        }
    }
}
