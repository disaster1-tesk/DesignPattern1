package com.reflect;
/*
通过反射获取对象父类的接口
 */
public class ReflectDemo14 {
    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.reflect.Myclass");
        Class superclass = aClass.getSuperclass();
        System.out.println(superclass.getName());

        //在这个版本Object没有实现接口了

        Class[] interfaces = superclass.getInterfaces();
        System.out.println(interfaces.length);
        for (Class inter:interfaces){
            System.out.println(inter.getName());
        }
    }
}
