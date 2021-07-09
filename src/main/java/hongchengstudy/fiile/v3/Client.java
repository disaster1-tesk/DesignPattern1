package hongchengstudy.fiile.v3;


import java.io.*;

/*
字节流:
    InputStream
    OutputStream

 */
public class Client {
    public static void main(String[] args) {
        File srcFile = new File("D:/桌面文件/FIle/text_modified.txt");
        File desFile = new File("D:/桌面文件/FIle/text_modified1.txt");
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile,true);
            byte[] buffer = new byte[3];
            int n = 0;
            while ((n = fis.read(buffer)) != -1) {
                fos.write(buffer,0,n);
                //fos.flush();缓冲流才需要进行刷新操作，没带缓冲区的不需要进行刷新
                String s = new String(buffer, 0, n);
                System.out.print(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null&&fos!=null) {
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
