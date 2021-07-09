package com.high.Map;
import java.util.Comparator;
import java.util.TreeSet;
/*
在使用treeset中自动排序的时候，如果集合中存储的数据没有实现Comparable接口，那么会出现ClassCastException异常，因为在底层中，treeset集合中的元素会向Comparable
类型转换，再进行大小的比较！
 */
public class MapDemo3 {
    public static void main(String[] args) {
        //第一种方式
        TreeSet<person> treeset = new TreeSet<>();
        treeset.add(new person("disaster", 20));
        treeset.add(new person("王威", 23));
        for (person p : treeset) {
            System.out.println(p);
        }
        //第二种方式
        TreeSet<user> treeSet = new TreeSet<>(new ByAgeCompare());
        treeSet.add(new user("disaster",20));
        treeSet.add(new user("王威",23));
        for (user u:treeSet){
            System.out.println(u);
        }
    }
}

class person implements Comparable<person>{
    private String name;
    private int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(person o) {
        return this.age-o.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class ByAgeCompare implements Comparator<user>{

    @Override
    public int compare(user o1, user o2) {
        return o1.getAge()-o2.getAge();
    }
}
class user{
    private String name;
    private int age;

    public user() {
    }

    public user(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}