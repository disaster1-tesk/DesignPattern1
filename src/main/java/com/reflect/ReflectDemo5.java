package com.reflect;
/*
        获取一个文件的绝对路径：
            这种方式只能获取到类包下的文件
 */
public class ReflectDemo5 {
    public static void main(String[] args) {
        String data = Thread.currentThread().getContextClassLoader()
                .getResource("Information2.properties").getPath();

       /* String data = Thread.currentThread().getContextClassLoader()
                .getResource("/src/com/reflect/Information3.properties").getPath();*/
        System.out.println(data);
    }
}
