package hongchengstudy.InnerClass;

import java.util.Objects;

/*
内部类的分类：
    1.普通内部类
    2.静态内部类
    3.布局内部类
    4.匿名内部类
 */
public class InnerClassDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        Student student1 = (Student) student.clone();
        System.out.println(student+"===="+student1);
        System.out.println(student.equals(student1));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class Student extends Person{
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public void eat() {
            System.out.println("学生在吃东西");
        }
        Student() {

        }
        public void doSomething(){
            System.out.println("学生在做事情");
        }
        Student(String name, int age) {
            this.age = age;
            this.name = name;
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
    public static class Person implements Cloneable{
        private String name;
        public void eat() {

        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
