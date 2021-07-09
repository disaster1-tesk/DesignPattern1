package hongchengstudy.io.buffer.v2;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/桌面文件/FIle/hidetxt.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter,2);
        fileWriter.write("你好啊，disaster");


        bufferedWriter.newLine();
        bufferedWriter.flush();


        fileWriter.close();
        bufferedWriter.close();
    }
}
