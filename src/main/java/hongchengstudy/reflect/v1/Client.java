package hongchengstudy.reflect.v1;


import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {

    }
}

class InstanceObjectUtil {
    private static Properties properties;
    private static BufferedInputStream fis;
    private static File filePath;
    private static HashSet<String> keySet;

    private InstanceObjectUtil() {
    }

    static {
        properties = new Properties();
        keySet = new HashSet<>();
        try {
            fis = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(fis);
            Enumeration<?> enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                keySet.add(key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设置文件的路径
    public static boolean setFilePath(File file) throws FileNotFoundException {
        filePath = file;
        if (!filePath.exists()) {
            throw new FileNotFoundException("文件找不到");
        }
        return true;
    }

    //通过用户输入的对象路径创建相应的对象
    public static Object getInstanceObject() throws ClassNotFoundException, ClassFormatError, IllegalAccessException, InstantiationException {
        String className = getType("className");
        Class aClass = Class.forName(className);
        return aClass.newInstance();
    }

    public static String getType(String type) {
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(type)) {
                return iterator.next();
            }
        }
        throw new ClassFormatError("类格式有问题");
    }

    public static void invokeMethod(String methodName,Object...args) {

    }
}