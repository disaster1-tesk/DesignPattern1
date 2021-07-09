package junit;

public class Person {
    public String name;
    public int age;
    private int height;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
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
    public void add(String args){
        System.out.println(args);
    }
    public void add(String...args){
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }
    }
    private void privateMethod(String[] args){
        for (String arg : args) {
            System.out.println("arg = " + arg);
        }
    }
}
