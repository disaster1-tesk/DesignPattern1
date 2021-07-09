package hongchengstudy.work.Operation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    private static boolean isExc = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        try {
            System.out.println("请输入第一个数字：");
            a = scanner.nextInt();
            System.out.println("请输入第二个数字：");
            b = scanner.nextInt();
            if (b == 0) {
                isExc = true;
            }
        } catch (InputMismatchException e) {
            isExc = true;
        } catch (ArithmeticException e) {
            isExc = true;
        } finally {
            System.out.println("相加=" + add(a, b));
            System.out.println("相减=" + sub(a, b));
            System.out.println("相乘=" + mul(a, b));
            System.out.println("相除=" + div(a, b));
            if (isExc == true) {
                System.out.println("程序发生异常");
            } else {
                System.out.println("程序没有发生意外");
            }
        }

    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static long mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
