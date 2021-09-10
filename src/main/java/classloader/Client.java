package classloader;

import java.io.File;

/**
 * @author Lenovo
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader("D:\\桌面文件\\test");
        System.out.println(new File("D:\\桌面文件\\test\\test.java").exists());
        Class clazz = classLoader.findClass("Main");
        System.out.println("clazz = " + clazz);
    }
}
