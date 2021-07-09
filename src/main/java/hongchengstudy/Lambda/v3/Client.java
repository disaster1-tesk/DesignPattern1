package hongchengstudy.Lambda.v3;

import java.util.Arrays;
import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        String[] strings = {"aaaaa","sadfas","asdfasdfsdfewee","fgh7jdhssdfdg"};
        System.out.println("=============排序前==============");
        System.out.println(Arrays.toString(strings));
        System.out.println("=============排序后==============");
        Arrays.sort(strings,getComparable());
        System.out.println(Arrays.toString(strings));
    }
    public static Comparator<String> getComparable(){
        return (s1,s2)-> s1.length()-s2.length();
    }
}
