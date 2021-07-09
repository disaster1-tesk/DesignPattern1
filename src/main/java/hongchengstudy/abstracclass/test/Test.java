package hongchengstudy.abstracclass.test;

import hongchengstudy.abstracclass.foradd.Addtion;
import hongchengstudy.abstracclass.fordel.Subtration;

public class Test {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        Addtion addtion = new Addtion();
        Subtration subtration = new Subtration();
        System.out.println(addtion.compute(a, b));
        System.out.println(subtration.compute(a, b));
    }
}

