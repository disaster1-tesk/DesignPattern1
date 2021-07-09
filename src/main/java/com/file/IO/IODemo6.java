package com.file.IO;

import java.io.*;

/*
BufferedReader是包装流，对于这种流的使用效率没有FiLeInputStream高
 */
public class IODemo6 {
    public static void main(String[] args) {
        BufferedReader br=null;
        try {
//            BufferedReader br = new BufferedReader(new FileInputStream("Data1"));
            br = new BufferedReader(new InputStreamReader(new FileInputStream("Data1")));
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
