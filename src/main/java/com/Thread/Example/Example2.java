package com.Thread.Example;

import java.io.*;

public class Example2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

    }
}
class FileThread implements Runnable{

    @Override
    public void run() {

    }
}
class User{

}