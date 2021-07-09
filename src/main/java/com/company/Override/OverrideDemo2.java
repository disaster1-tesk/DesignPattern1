package com.company.Override;

public class OverrideDemo2 {
    public static void main(String[] args) {
        new baoma("disaster", "车");
    }
}

/**
 * 在方法的覆盖中，如果方法中有返回值类型：
 * 1.如果是基本数据类型，那么父类和子类的返回值类型必须保持一致
 * 2.如果是引用数据类型，那么父类和子类的返回值类型可以不一致
 */
class Factory {
    private String name;
    private String Type;

    public Factory() {
    }

    public Factory(String name, String type) {
        this.name = name;
        Type = type;
    }

    //dosome
    public Factory dosome() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}

class baoma extends Factory {
    public baoma() {
    }

    public baoma(String name, String type) {
        this.setName(name);
        this.setType(type);
        System.out.println("有参数的构造方法" + this.getName() + this.getType());
        //super(name, type); //TODO这里的调用父类的构造方法和上面这么写的效果一样，一般使用服父类的构造方法，这样实现了代码复用
    }

    @Override
    public baoma dosome() {
        return null;
    }
}
