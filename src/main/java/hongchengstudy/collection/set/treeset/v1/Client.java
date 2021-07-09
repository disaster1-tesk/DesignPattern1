package hongchengstudy.collection.set.treeset.v1;

import java.util.Set;
import java.util.TreeSet;

public class Client {
    public static void main(String[] args) {
        Set<User> treeSet = new TreeSet<>();
        User user1 = new User("disaster1",10);
        User user2 = new User("disaster2",5);
        User user3 = new User("disaster3",8);
        treeSet.add(user2);
        treeSet.add(user1);
        treeSet.add(user3);
        System.out.println(treeSet);
    }
}
class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    @Override
    public int compareTo(Object o) {//如果返回值为0表示两个元素相同
        User user = null;
        if (o instanceof User){
             user = (User)o;
             //根据年龄排序
            return this.age-user.age;
        }
        return -1;
    }
}