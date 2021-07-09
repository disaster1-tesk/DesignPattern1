package hongchengstudy.work.lambda;

import java.util.TreeSet;

/*
、TreeSet<Student>中添加Student对象，在创建TreeSet对象时传入比较器，
根据学生姓名字符串排序，如果相同再根据年龄排序（使用lambda表达式），并输出集合中的顺序。
 */
public class Client {
    public static void main(String[] args) {
        TreeSet<Student> studentTreeSet = new TreeSet<>((o1, o2) -> {
            if (o1.getName().length()==o2.getName().length()){
                return o1.getAge()-o2.getAge();
            }
            return o1.getName().length()-o2.getName().length();});
        studentTreeSet.add(new Student("disaster1",10));
        studentTreeSet.add(new Student("disaster2",20));
        studentTreeSet.add(new Student("disaster3",134));
        studentTreeSet.add(new Student("小花",634));
        studentTreeSet.add(new Student("阿斯顿发",45));
        studentTreeSet.add(new Student("阿萨德",3456));
        studentTreeSet.add(new Student(" 到底",346));
        studentTreeSet.add(new Student("多大",775));
        for (Student student : studentTreeSet) {
            System.out.println(student);
        }
    }
}
