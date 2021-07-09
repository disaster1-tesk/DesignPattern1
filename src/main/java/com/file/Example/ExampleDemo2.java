package com.file.Example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExampleDemo2 {
    public static void main(String[] args) {
        try {
            new FileCopyUtils("Data2","Data1").copoFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class FileCopyUtils{
    private FileReader fir;
    private FileWriter fiw;
    FileCopyUtils() throws IOException {
        if (fir==null||fiw==null){
            throw new IOException("未创建流对象！");
        }
    }
    public FileCopyUtils(String  fidfile, String fiwfile) throws IOException {
        this.fir = new FileReader(fidfile);
        this.fiw = new FileWriter(fiwfile);
    }
    public boolean copoFile(){
        char[] chars = new char[1024* 1024];
        try {
            int read;
            while((read=fir.read(chars))!=-1){
                fiw.write(chars,0,read);
            }
            fiw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fir.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fiw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}