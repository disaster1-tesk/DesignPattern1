package hongchengstudy.fiile.v1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/桌面文件/FIle1/file_test.txt");
        System.out.println(file.getName());//file文件名
        System.out.println(file.getAbsolutePath());//获取绝对路径
        System.out.println(file.getParent());//获取文件父目录
        System.out.println(file.getParentFile());//获取文件父目录的File对象
        System.out.println(file.getUsableSpace());//获取文件可使用的内存空间
        System.out.println(file.getTotalSpace());//获取文件总空间大小
        System.out.println(file.length());//判断文件的大小
        System.out.println(file.exists());//判断文件是否存在
        System.out.println(file.canRead());//判断文件是否可读
        System.out.println(file.canWrite());//判断文件是否可写
        System.out.println(file.canExecute());//判断文件是否可执行
        System.out.println(file.isFile());//判断文件是否为文件
        System.out.println(file.isDirectory());//判断文件是否是目录
        System.out.println(file.isHidden());//判断文件是否是隐藏文件
        System.out.println(file.isAbsolute());//判断文件是否是绝对路径
        System.out.println(file.toPath());//将File转换成路径
        System.out.println(file.toString());//将文件路径转换成字符串
        System.out.println(file.toURI());//将文件路径转换成URL地址
        System.out.println(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss SSS").format(file.lastModified()));//获取文件最后一次修改的时间
        System.out.println(SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.CHINA).format(file.lastModified()));
        System.out.println(file.renameTo(new File("D:/桌面文件/FIle/text_modified.txt")));//在使用这个方法前，需要判断File目录是否在磁盘中存在，如果不存在则会返回false，如果要修改之后的文件名与修改前的一致，那么也会返回false
        System.out.println(file.mkdir());//创建File文件夹
        System.out.println(file.mkdirs());//创建多级目录
        System.out.println(file.delete());//删除文件或目录
        System.out.println(file.createNewFile());//创建文件

    }
    @Test
    public void test(){
        File file = new File("C:\\Program Files\\Java\\jdk1.8.0_152");
        String[] list = file.list();
        for (String f: list) {
            System.out.println(f);
        }
    }
    @Test
    public void test1(){
        File file = new File("C:\\Program Files\\Java\\jdk1.8.0_152");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }

}
