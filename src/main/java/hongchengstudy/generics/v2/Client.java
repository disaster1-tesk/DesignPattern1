package hongchengstudy.generics.v2;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        int length = list.size();
        for (int i = 0;i<length;i++){

        }
    }
}
class User<T>{
    private T name;
    //泛型类中的普通方法
    public T getName(){
        return name;
    }
    //泛型类中的泛型方法===等同于返回一个Object类型的效果
    /*
    泛型通配符
    限定上限和下限的前提条件是在泛型类中，并且使用的是相同的泛型名称
    <? extends T>限定上限
    <? supper T>限定下限
     */
    public <T> T getAge(T s){
        return s;
    }
    public <T extends Number> int add(T a,T b){
        int sum = a.intValue()+b.intValue();
        return sum;
    }
}
class Person{
    public <T> int getName(T t){
        return 0;
    }
}
