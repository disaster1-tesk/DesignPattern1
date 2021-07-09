package com.file.Example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleDemo1 {
    public static void main(String[] args) {
        String sourceFile = "src/com/Data";
        String destFile = "Data2";
        try {
            FileCopyUtil fileCopyUtil = new FileCopyUtil(sourceFile,destFile);
            boolean copy = fileCopyUtil.copy();
            if (copy){
                System.out.println("复制成功！");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class FileCopyUtil{
    private FileOutputStream fos;
    private FileInputStream fis;

    public FileOutputStream getFos() {
        return fos;
    }

    public void setFos(FileOutputStream fos) {
        this.fos = fos;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public FileCopyUtil(String sourcefile,String destfile) throws FileNotFoundException {
        this.fos = new FileOutputStream(destfile);
        this.fis = new FileInputStream(sourcefile);
    }

    public FileCopyUtil() throws IOException {
        if (this.fos == null||this.fis==null) {
            throw new IOException("没有创建流对象！");
        }
    }

    public boolean copy(){
        try {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}
