package com.high.Example;

import java.util.Objects;

public class Example3 {
    public static void main(String[] args) {
        Animals fish1 = new Fish("鱼", "小花");
        Animals fish2 = new Fish("鱼", "小花");
        //fish2=null;
        System.out.println(fish1.equals(fish2));
    }
}

class Animals {
    private String Name;
    private String Type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return Objects.equals(Name, animals.Name) &&
                Objects.equals(Type, animals.Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Type);
    }

    public Animals() {
    }

    public Animals(String name, String type) {
        Name = name;
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}

class Fish extends Animals {

    public Fish() {
    }

    public Fish(String type, String name) {
        super(type, name);
    }

}

class Shake extends Animals {
    public Shake() {
    }

    public Shake(String type, String name) {
        super(type, name);
    }
}
