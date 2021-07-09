package hongchengstudy.work.reflect;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws Exception {
        File file = new File("Peoperties.txt");
        System.out.println(file.exists());//判断文件是否存在
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));//创建流对象
        String ObjectReference = bufferedReader.readLine();//读取类文件路径
        String method = bufferedReader.readLine();//读取方法名称
        String[] strArr = new String[]{"aaa", "bbbb", "ccc"};
        Object[] objects = {strArr,};
        String methodName = method.split("=")[1];//获取方法名称
        String className = ObjectReference.split("=")[1];//获取类文件名称
        Class aClass = Class.forName(className);//获取class对象
        Constructor constructor = aClass.getConstructor(String.class, int.class);//得到构造方法
        Person person = (Person) constructor.newInstance("disaster", 20);//创建实例
        Method declaredMethod = aClass.getDeclaredMethod(methodName, String[].class);//获取方法
        declaredMethod.invoke(person, objects);//执行方法
        System.out.println("person = " + person);
    }
}
