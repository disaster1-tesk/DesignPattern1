package com.file.IO;

import java.io.*;

public class IODemo7 {
    public static void main(String[] args) {
        BufferedWriter bw=null;
        try {
             bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
             bw.write("你好！");
             bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
