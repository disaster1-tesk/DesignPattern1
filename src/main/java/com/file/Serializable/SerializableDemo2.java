package com.file.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableDemo2 {
    public static void main(String[] args) throws Exception{
        //反序列化对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user"));
        User o = (User)ois.readObject();
        User u = (User)ois.readObject();
        System.out.println(o);
        System.out.println(u);
    }
}
