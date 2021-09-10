package showtable.two;


import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.DriverManager;

public class ClassPathDemo {
    public static void main(String[] args) {
        //引导类加载器
        System.out.println("=====引导类加载器====");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println("urL = " + urL);
        }
        System.out.println("======================扩展类加载器==========================");
        URLClassLoader extClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader().getParent();
        URL[] urLs1 = extClassLoader.getURLs();
        for (URL url : urLs1) {
            System.out.println("url = " + url);
        }
        System.out.println("======================应用类加载器==========================");
        URLClassLoader contextClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
        URL[] urLs2 = contextClassLoader.getURLs();
        for (URL url : urLs2) {
            System.out.println("url = " + url);
        }
        String property = System.getProperty("java.class.path");
        String[] split = property.split(";");
        for (String s : split) {
            System.out.println("s = " + s);
        }
    }
}
