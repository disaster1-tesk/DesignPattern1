package com.Example;
/*
构建者模式：
        将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 */


public class ExampleDemo1 {
    public static void main(String[] args) {
        product product = new product.Builder()
                        .Age(1)
                        .name("asd")
                        .Type("12")
                        .build();
        System.out.println(product.toString());
    }
}
class product{
    private String Name;
    private int Age;
    private String Type;

    public product() {
    }
    public product(Builder builder){
        this.Name = builder.name;
        this.Age = builder.Age;
        this.Type = builder.Type;
    }

    @Override
    public String toString() {
        return "product{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Type='" + Type + '\'' +
                '}';
    }

    public static class Builder{
        String name;
        int Age;
        String Type;

        public Builder() {
        }

        public Builder(product product) {
            this.name = product.Name;
            this.Age = product.Age;
            this.Type = product.Type;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder Age(int Age){
            this.Age = Age;
            return this;
        }
        public Builder Type(String Type){
            this.Type = Type;
            return this;
        }
        public product build(){
            return new product(this);
        }
    }
}