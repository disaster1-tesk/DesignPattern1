package junit.v2;

import junit.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.misc.Launcher;

import java.lang.reflect.*;
import java.net.URL;

public class Client {
    private Class aClass;

    //第一种方式：源码阶段
    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass);
    }

    //第二种方式：类加载阶段
    @Test
    public void test2() {
        Class aClass = String.class;
        System.out.println(aClass);
    }

    //第三种方式：运行阶段
    @Test
    public void test3() {
        String string = new String();
        Class aClass = string.getClass();
        System.out.println(aClass);
    }

    /*
BootstrapClassLoader（启动类加载器）c++编写，加载java核心库 java.*,构造ExtClassLoader和AppClassLoader。由于引导类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用，所以不允许直接通过引用进行操作并不继承子java.lang.ClassLoader，没有父加载器处于安全考虑，Bootstrap启动类加载器只加载包名为java、javax、sun等开头的类加载扩展类和应用程序类加载器
，并指定为他们的父类加载器

ExtClassLoader （标准扩展类加载器）java编写，加载扩展库，如classpath中的jre ，javax.*或者 java.ext.dir 指定位置中的类，开发者可以直接使用标准扩展类加载器。

AppClassLoader（系统类加载器）java编写，加载程序所在的目录，如user.dir所在的位置的class

CustomClassLoader（用户自定义类加载器）java编写,用户自定义的类加载器,可加载指定路径的class文件
    1.除了顶层的启动类加载器外，其余的类加载器都应当有自己的“父类”加载器
    2.不同类加载器看似是集成（Inheritance）关系，实际上是包含关系。在下层加载器中，包含着上层加载器的引用
     */
    @Before
    public void before() {
        aClass = Person.class;
    }

    @Test
    public void test4() {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println(Launcher.getLauncher().getClassLoader());
        System.out.println(Launcher.getLauncher().getClassLoader().getParent());
        System.out.println(Launcher.getLauncher().getClassLoader().getParent().getResource(""));
        for (URL url : urLs) {
            System.out.println(url);
        }
    }

    @Test
    public void test5() {
        Class aClass = Person.class;
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void test6() {
        Class aClass = Person.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }

    @Test
    public void test7() throws NoSuchMethodException {
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        System.out.println(aClass.getConstructor(String.class, int.class));
        System.out.println(aClass.getClassLoader());
    }

    /*
获取ClassLoader类的几种方式：
    1.Class.forName("java.lang.String").getClassLoader()
    2.ClassLoader.getSystemClassLoader().getParent();
    3.Thread.currentThread().getContextClassLoader();
 */
    @Test
    public void test8() {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
/*
对类进行一个反射
 */
    @Test
    public void test9() {
        StringBuilder strs = new StringBuilder();
        strs.append(Modifier.toString(aClass.getModifiers()) + " class " + aClass.getSimpleName() + " {\n");
        Method[] Methods = aClass.getDeclaredMethods();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            String s = Modifier.toString(f.getModifiers());
            String simpleName = f.getType().getSimpleName();
            String name = f.getName();
            strs.append("\t");
            strs.append(s);
            strs.append(" ");
            strs.append(simpleName);
            strs.append(" ");
            strs.append(name);
            strs.append(";");
            strs.append("\n");
        }
        for (Method method : Methods) {
            strs.append("\t");
            strs.append(Modifier.toString(method.getModifiers()));
            strs.append(" ");
            strs.append(method.getReturnType().getSimpleName());
            strs.append(" ");
            strs.append(method.getName());
            strs.append("(");
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length > 0) {
                for (Class parameter : parameterTypes) {
                    strs.append(parameter.getSimpleName());
                    strs.append(",");
                }
                strs.deleteCharAt(strs.length() - 1);
                strs.append("){}\n");
            } else {
                strs.append("){}\n");
            }

        }
        strs.append("}");
        System.out.println(strs);
    }
//    对成员变量的学习
    @Test
    public void test10() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field name = aClass.getField("name");
        Field height = aClass.getDeclaredField("height");
        Object o = aClass.newInstance();
        height.setAccessible(true);
        name.set(o,"世界");
        height.set(o,10);
        System.out.println(height.get(o));
        System.out.println(name.get(o));
    }
    //对构造方法的学习
    @Test
    public void test11() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = aClass.getConstructor();
        Constructor constructor1 = aClass.getConstructor(String.class, int.class);
        Constructor constructor2 = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        constructor2.setAccessible(true);
        Person p2 = (Person) constructor2.newInstance("你好",10,140);
        System.out.println("p2 = " + p2);
        Person p = (Person) constructor.newInstance();
        System.out.println("p = " + p);
        Person p1 = (Person) constructor1.newInstance("你好",10);
        System.out.println("p1 = " + p1);
    }
    //对成员方法对象的学习
    @Test
    public void test12() throws Exception {
        String[] strArr = new String[] {
                "aaa", "bbbb", "ccc"
        };
        Object[] objects = {
                strArr,
        };
//        String[] strings = (String[])objects;
        Method add = aClass.getDeclaredMethod("add",String.class);
        add.invoke(aClass.newInstance(),"你好");
        Method privateMethod = aClass.getDeclaredMethod("privateMethod",String[].class);
        privateMethod.setAccessible(true);
        //传实际数组参数的时候需要包一层Object对象
        privateMethod.invoke(aClass.newInstance(),/*strArr*/new Object[] {
                strArr,
        });
    }
}
