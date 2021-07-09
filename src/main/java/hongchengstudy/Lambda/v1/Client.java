package hongchengstudy.Lambda.v1;

import java.util.Arrays;
/*
函数式接口才能使用lambda表达式
函数式接口：接口中只定义了一个方法
如果接口中有default的相关方法也算是函数式接口
 */
public class Client {
    public static void main(String[] args) {
        Person[] personInts = {
                new Person("disaster1", 10),
                new Person("disaster1", 59),
                new Person("disaster1", 28),
                new Person("disaster1", 30),
                new Person("disaster1", 43)
        };
        for (int i = 0; i < personInts.length; i++) {
            System.out.println(personInts[i]);
        }
        //匿名内部类写法
        /*Arrays.sort(personInts, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/
        //lambda表达式写法
        Arrays.sort(personInts, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("======================================");
        for (int i = 0; i < personInts.length; i++) {
            System.out.println(personInts[i]);
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}