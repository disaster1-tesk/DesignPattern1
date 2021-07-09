package hongchengstudy.io.reader;


import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/桌面文件/FIle/text_modified.txt");
        Reader fileReader = new FileReader(file);
        char[] buffer = new char[2];

        int read = -1;
        while ((read= fileReader.read(buffer))!=-1){
            String s = new String(buffer, 0, read);
            System.out.print(s);
        }
        fileReader.close();
    }
}
