package hongchengstudy.work.savebookinfo;

import java.io.*;

public class BookUtil {
    //通过BufferedWriter写入信息
    public static void write(Book book, File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("图书编号：" + book.getNo() + "，图书名称：" + book.getName() + "，图书单价：" + book.getPrice());
        bw.newLine();
        bw.flush();
        bw.close();
        fw.close();
    }

    //通过ObjectOutputStream写入信息
    public static void write1(Book book, File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(book);
        oos.close();
    }



    //通过BufferedReader读取数据
    public static void read(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String str = "";
        while ((str = bf.readLine()) != null) {
            System.out.print(str);
        }
        fr.close();
        bf.close();
    }

    //通过ObjectInputStream读取数据
    public static void read1(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        Book book = null;
        if (o instanceof Book) {
            book = (Book) o;
            System.out.println(("图书编号：" + book.getNo() + "，图书名称：" + book.getName() + "，图书单价：" + book.getPrice()));
        }
    }


}
