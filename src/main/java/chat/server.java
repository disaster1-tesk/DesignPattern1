package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* * MyServer类，用于监听客户端Socket连接请求 */
public class server {
    private List<MyChannel> channelList = new ArrayList<MyChannel>();

    public static void main(String[] args) throws IOException {
        new server().start();
    }

    public void start() throws IOException {

        @SuppressWarnings("resource")
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动！！！");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.toString() + "已连接");
            MyChannel mychannel = new MyChannel(socket);
            channelList.add(mychannel);
            new Thread(mychannel).start();
        }


    }

    /**
     * 一个客户一个通道
     *
     * @author
     */
    public class MyChannel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;
        private String name;
        private Socket socket;

        public MyChannel(Socket socket) {
            try {
                this.socket = socket;
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
				/*this.name = dis.readUTF();
				sendOther(this.name+"已上线"+"\n");
				System.out.println(this.name);*/
            } catch (IOException e) {
                //e.printStackTrace();
                CloseUtil.closeAll(dis, dos);
                isRunning = false;
            }
        }

        //读取数据
        private String receive() {
            String content = "";
            try {
                content = dis.readUTF();
                System.out.println("读取的数据:" + content);
            } catch (IOException e) {
//				e.printStackTrace();
                System.out.println("读取数据出现错误！");
                CloseUtil.closeAll(dis, dos);
                isRunning = false;
                channelList.remove(this);
            }
            return content;
        }

        //发送数据
        private void send(String content) {
            if (content == null || content.equals("")) {
                return;
            }
            try {
                dos.writeUTF(packMessage(content));
                System.out.println("发送的数据:" + packMessage(content));
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("发送数据出现错误！");
                CloseUtil.closeAll(dis, dos);
                isRunning = false;
                channelList.remove(this);
            }
        }

        //发送数据给其他客户端
        private void sendOther(String content) {
            if (content != null) {
                if (content.indexOf("/") > -1) {
                    String name = getName(content);
                    for (MyChannel other : channelList) {
                        if (other.name.equals(name)) {
                            other.send(content);
                        }
                    }
                } else {
                    for (MyChannel other : channelList) {
                        other.send(content);
                    }
                }
            }
        }

        //得到目标人物的名称
        private String getName(String content) {
            String name = null;
            int Pbegin = content.indexOf("/");
            int Pend = content.indexOf(".");
            name = content.substring(Pbegin + 1, Pend);
            return name;
        }

        //运行
        public void run() {
            while (isRunning) {
                sendOther(this.receive());
            }
        }

        /**
         * 对要广播的数据进行包装
         */
        private String packMessage(String content) {
            String msg = null;
            String time = null;
            String Pcontent = null;
			/*int begin = content.indexOf("<");
			int end = content.indexOf(">");*/
            int Pbegin = content.indexOf("/");
            int Pend = content.indexOf(".");
            if (Pbegin > -1 && Pend > -1) {
                Pcontent = content.substring(Pend + 1);
                time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
                msg = "<" + this.name + ">" + "    " + time + "\n" + "-" + this.name + "悄悄的和你说:" + Pcontent + "\n";

            } else {
				/*name = content.substring(begin,end+1);
				content = content.substring(end+1);*/
                time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
                msg = "<" + this.name + ">" + "  " + time + "\n" + "内容为（群发）:" + content + "\n";
            }
            //System.out.println("有几个客户端运行几次packMessage" + msg);
            return msg;
        }

    }


}

         
		

