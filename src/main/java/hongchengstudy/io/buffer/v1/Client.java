package hongchengstudy.io.buffer.v1;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/桌面文件/FIle/hidetxt.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = "";
        while ((s=bufferedReader.readLine())!=null){
            System.out.println(s);
        }
        fileReader.close();
        bufferedReader.close();
    }
}
