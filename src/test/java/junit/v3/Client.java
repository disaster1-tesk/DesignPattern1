package junit.v3;

import hongchengstudy.reflect.v3.Check;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/2 15:31
 * @Version 1.0
 **/
public class Client {
    private Class computer;
    @Before
    public void before(){
        try {
            computer = Class.forName("hongchengstudy.reflect.v3.Computer");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() throws IllegalAccessException, InstantiationException, IOException, InvocationTargetException {
        Object o = computer.newInstance();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Peoperties.txt"),true));
        System.out.println(new File("Peoperties.txt").exists());
        Method[] declaredMethods = computer.getDeclaredMethods();
        int count = 0;
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Check.class)){
                try {
                    declaredMethod.invoke(o);
                } catch (InvocationTargetException e) {
                    count++;
                    bufferedWriter.write(declaredMethod.getName()+"方法有异常");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    bufferedWriter.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    bufferedWriter.write("异常的信息："+e.getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    bufferedWriter.write("==============================");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        }
        System.out.println("一共发生"+count+"异常");
    }
    @Test
    public void test2(){
        String s = new String("hello");
        String t = new String("hello");
        char c [ ] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(t.equals(c));
    }
    @Test
    public void test3(){
       A a = new B();
    }
}
class A{
    static{
        System.out.print("1") ;
    }
    public A(){
        System.out.print("2") ;
    }
}
class B extends A{
    static{
        System .out. print("a") ;
    }
    public B(){
        System .out. print("b") ;
    }
}