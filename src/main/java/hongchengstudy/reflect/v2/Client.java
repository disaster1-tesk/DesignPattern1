package hongchengstudy.reflect.v2;

import java.lang.reflect.Method;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/2 14:43
 * @Version 1.0
 **/
@MyRunClass(className = "hongchengstudy.reflect.v2.Person", methodName = "eat")
public class Client {
    public static void main(String[] args) throws Exception {
        MyRunClass annotation = Client.class.getAnnotation(MyRunClass.class);
        System.out.println("annotation = " + annotation);
        String className = annotation.className();
        String methodName = annotation.methodName();
        Class aClass = Class.forName(className);
        Person person = (Person)aClass.newInstance();
        person.eat();
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        Method sleep = aClass.getDeclaredMethod("sleep");
        System.out.println("sleep = " + sleep);
        sleep.setAccessible(true);
        sleep.invoke(person);
        declaredMethod.invoke(person);
    }
}
