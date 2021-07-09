package hongchengstudy.work.showhidefiles;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
    1、提供一个目录
   	2、查询该目录下所有隐藏文件
	3、将所有隐藏文件路径保存到集合中F
	4、遍历集合，打印出所有隐藏文件
 */
public class Client {
    private static List<String> fileList = new ArrayList<>();
    public static void main(String[] args) {
        File file = new File("D:/桌面文件/FIle");
        showFile(getFiles(file));
    }

    public static List<String> getFiles(File file) {
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isHidden()&&file1.isFile()){
                    fileList.add(file1.getPath());
                }else if(file1.isHidden()&&file1.isDirectory()){
                    fileList.add(file1.getPath());
                    getFiles(file1);
                }
            }
            return fileList;
        }
        return null;
    }

    public static void showFile(List<String> fileList) {
        if (fileList != null) {
            for (String str : fileList) {
                System.out.println(str);
            }
        }
    }

}
