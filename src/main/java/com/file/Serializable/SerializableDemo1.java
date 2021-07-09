package com.file.Serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/*
序列化使用的场景：
    序列化主要是因为跨平台和对象存储的需求，因为网络上只允许字符串或者二进制格式，而文件需要使用二进制流格式，
    如果想把一个内存中的对象存储下来就必须使用序列化转换为xml（字符串）、json（字符串）或二进制（流）。

序列化使用的注意事项：
    1.需要序列化的对象需要实现Serializable接口
    2.InvalidClassException这个异常的出现是因为对象在序列化的时候会自动生成一个序列号，每个类只有一个序列号，这是独一无二的，
    但是对于序列号来说，我们程序员可以自动写，不用工具生成
    3.对于序列化的对象中，如果使用transient关键字（游离），表示这个变量无法被序列化！
 */
public class SerializableDemo1 {
    public static void main(String[] args) throws Exception {
        //序列化对象！
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user"));
        oos.writeObject(new User("disaster",20));
        oos.flush();
        oos.close();
    }
}

class User implements Serializable {
    private String name;
    //
    private transient int age;

    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}