package com.file.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IODemo4 {
    public static void main(String[] args) {
        FileReader fir=null;
        try {
            fir = new FileReader("Data2");
            char[] chars = new char[10];
            int readcount =0;
            while ((readcount=fir.read(chars))!=-1){
                System.out.print(new String(chars).toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fir != null) {
                try {
                    fir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
