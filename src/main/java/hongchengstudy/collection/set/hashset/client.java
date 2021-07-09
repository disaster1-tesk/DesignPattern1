package hongchengstudy.collection.set.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class client {
    public static void main(String[] args) {
        Set<Object> hashSet = new HashSet<>();
        Dog dog1 = new Dog("小黄", 5);
        Dog dog2 = new Dog("小黄", 5);
        Dog dog3 = dog2;
        System.out.println("dog1---" + dog1.hashCode());
        System.out.println("dog2---" + dog2.hashCode());
        System.out.println(dog3.hashCode());
        System.out.println("==================");
        System.out.println(hashSet.add(dog1));
        System.out.println("==================");
        System.out.println(hashSet.add(dog2));
        System.out.println("==================");
        System.out.println(hashSet.add(dog3));
        System.out.println("==================");
        hashSet.add(new Dog("小花", 20));
        System.out.println(hashSet);

    }
}

class Dog implements Comparable{
    private String name;
    private int age;

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this.name + "调用了equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age &&
                Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        System.out.println(this.name + "调用了hashcode方法");
        return Objects.hash(name, age);
    }

    public Dog(String name, int age) {
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

    @Override
    public int compareTo(Object o) {
        Dog dog = null;
        if (o instanceof Dog){
            dog = (Dog) o;
            return dog.age-this.age;
        }
        return -1;
    }
}