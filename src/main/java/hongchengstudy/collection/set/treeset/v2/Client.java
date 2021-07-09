package hongchengstudy.collection.set.treeset.v2;


import java.util.Set;
import java.util.TreeSet;

public class Client {
    public static void main(String[] args) {
        Set<Dog> treeSet = new TreeSet<>((o1, o2) -> (o2.getAge() - o1.getAge()));
        treeSet.add(new Dog("小黄",20));
        treeSet.add(new Dog("小黄",5));
        treeSet.add(new Dog("小黄",7));
        treeSet.add(new Dog("小黄",8));
        treeSet.add(new Dog("小黄",20));
        treeSet.add(new Dog("小黄",43));
        treeSet.add(new Dog("小黄",67));
        treeSet.add(new Dog("小黄",97));
        System.out.println(treeSet);

    }
}
class MyComparable implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}