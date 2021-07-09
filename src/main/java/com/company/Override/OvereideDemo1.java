package com.company.Override;

public class OvereideDemo1 {
    public static void main(String[] args) {
        Person chinese = new chinese("大威哥", "19", "中国", "汉语");
        Person america = new Americal("Disaster", "20", "美国", "English");
        chinese.speak("我是中国人");
        america.speak("我是美国人");
    }
}

class Person {
    private String name;
    private String age;
    private String country;
    private String language;

    public Person() {
    }

    public Person(String name, String age, String country, String language) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public void speak(String str) {
        System.out.println(str);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

class chinese extends Person {
    public chinese() {
    }

    public chinese(String name, String age, String country, String language) {
        super(name, age, country, language);
    }

    @Override
    public void speak(String str) {
        System.out.println(this.getName() + "正在说" + str);
    }

    public void speak(String str, String name) {
        System.out.println(name + "正在说" + str);
    }
}

class Americal extends Person {
    public Americal() {
    }

    public Americal(String name, String age, String country, String language) {
        super(name, age, country, language);
    }

    @Override
    public void speak(String str) {
        System.out.println(this.getName() + "正在说" + str);
    }
}
