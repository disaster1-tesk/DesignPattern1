package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
    类加载器：ClassLoader
        类加载一共有三种：
            1.启动加载器
            2.扩展加载器
            3.应用加载器
   Field、与Constructor的获取：


 */
public class ReflectDemo7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class Myclass = Class.forName("com.reflect.Myclass");
        //这种方法只能获取public 修饰的变量！
//        Field[] fields = Myclass.getFields();
        Field[] fields = Myclass.getDeclaredFields();
        System.out.println(fields.length);
        for (Field f:
             fields) {
            int modifiers = f.getModifiers();
            String s = Modifier.toString(modifiers);
            System.out.println(s);

            Class type = f.getType();
            //得到全名
            String name = type.getName();
            //得到简单名
            String simpleName = type.getSimpleName();
            System.out.println(simpleName);

            String name1 = f.getName();
            System.out.println(name1);
            System.out.println("-------------");
        }
    }
}
