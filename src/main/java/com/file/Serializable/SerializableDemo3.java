package com.file.Serializable;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo3 {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user"));
        oos.writeObject(new User("disaster",20));
        oos.writeObject(new User("王威",30));
        oos.flush();
        oos.close();
    }
}
