package hongchengstudy.abstracclass.v3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        double d = 10;
        float f = (float) d;
        int a1 = (int) f;
        Character c = 10;
        Character.isDigit('0');
        System.out.println(a+","+d+","+f);
        System.out.println("f = " + f);
        System.out.println("args = " + Arrays.deepToString(args));
    }
}
