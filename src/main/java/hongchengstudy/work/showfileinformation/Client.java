package hongchengstudy.work.showfileinformation;

import java.io.File;
import java.text.SimpleDateFormat;

public class Client {
    public static void main(String[] args) {
        File file = new File("D:/桌面文件/FIle");
        File[] files = file.listFiles();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println("文件名称 \t" + "是否为文件夹\t" + "最后修改时间\t" + "文件大小");
        for (File file1 : files) {
            System.out.print(file1.getName() + "\t");
            if (file1.isDirectory()) {
                System.out.print("文件夹\t");
            }else{
                System.out.print("文件\t");
            }
            System.out.print(simpleDateFormat.format(file1.lastModified())+"\t");
            System.out.print(file1.getTotalSpace());
            System.out.println("");

        }
    }
}
