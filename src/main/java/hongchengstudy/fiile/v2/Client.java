package hongchengstudy.fiile.v2;

import java.io.*;
/*
文件夹的拷贝
 */
public class Client {
    public static void main(String[] args) {
        String srcPath = "D:\\桌面文件\\视频剪辑\\bentk大象变形效果素材";
        String descPath = "D:\\桌面文件\\视频剪辑\\合照";
        copyDir(srcPath, descPath);
    }
    //文件夹的拷贝
    public static void copyDir(String srcPath, String desPath ) {
        File src = new File(srcPath);
        File desc=new File(desPath);
        System.out.println(desc.getAbsolutePath());
        if(src.isDirectory()) {
            desc = new File(desPath,src.getName());
            System.out.println(desc.getAbsolutePath());
        }
        copyDir(src, desc);
    }
    public static void copyDir(File src, File desc) {
        if(src.isDirectory()) {
            desc = new File(desc,src.getName());
            desc.mkdirs();
            for(File sub:src.listFiles()) {
                copyDir(sub,new File(desc,sub.getName()));
            }
        }else if(src.isFile()) {
            try {
                copyFile(src, desc);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //文件的拷贝
    public static  void copyFile(String srcPath, String desPath) throws IOException {
        File src =  new File(srcPath);
        File des = new File(desPath);
        copyFile(src, des);
    }

    public static  void copyFile(File src, File desc) throws IOException {
        if(!src.isFile()) {
            System.out.println("");
            throw new IOException("");
        }
        if(desc.isDirectory()) {
            System.out.println("");
            throw  new IOException("");
        }
        //选择流
        OutputStream os= new FileOutputStream(desc);
        InputStream is = new  FileInputStream(src);
        byte[] buffer = new byte[1024];
        int len=0;
        while(-1!=(len=is.read(buffer))) {
            os.write(buffer);
        }
        os.flush();
        os.close();
        is.close();
    }

}
