package hongchengstudy.work.savebookinfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        File file = new File("D:" + File.separator + "桌面文件" + File.separator + "FIle" + File.separator + "图书" + File.separator + "tushu1.txt");
        bookArrayList.add(new Book(1001, "走进java编程世界", 36));
        bookArrayList.add(new Book(1002, "走进java面向对象程序设计", 68));
        for (int i = 0; i < bookArrayList.size(); i++) {
            BookUtil.write1(bookArrayList.get(i),file);
            BookUtil.read1(file);
        }
    }
}
