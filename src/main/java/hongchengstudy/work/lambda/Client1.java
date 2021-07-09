package hongchengstudy.work.lambda;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
4、TreeMap<String,Student>中添加String和Student键值对数据，在创建TreeMap对象时传入比较器，
比较字符串的长度（使用lambda表达式），并输出集合中的顺序。
 */
public class Client1 {
    public static void main(String[] args) {
        TreeMap<String, Student> studentTreeMap = new TreeMap<>((s1,s2)->s1.length()-s2.length());//比较的key的字符串长度
        studentTreeMap.put("ad",new Student("asdfasd",2));
        studentTreeMap.put("adfas",new Student("gsfgfhhhh",2));
        studentTreeMap.put("asdfasfa",new Student("as",2));
        studentTreeMap.put("asdfasdfff",new Student("23ga",2));
        studentTreeMap.put("asdasdfsdfff",new Student("23njgh",2));
        Set<Map.Entry<String, Student>> entries = studentTreeMap.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey()+"======="+entry.getValue());
        }
    }
}