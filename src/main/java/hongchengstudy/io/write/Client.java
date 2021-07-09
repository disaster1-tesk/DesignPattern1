package hongchengstudy.io.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/桌面文件/FIle/hidetxt.txt");
        Writer fileWriter = new FileWriter(file);
        char[] buffer = {'你','好'};
        fileWriter.write(buffer);
        fileWriter.close();
    }
}
