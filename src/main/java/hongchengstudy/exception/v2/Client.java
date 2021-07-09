package hongchengstudy.exception.v2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        double scores = 0;
        try {
            System.out.println("请输入班级总人数：");
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("人数的输入格式有误");
        }
        try {
            System.out.println("请输入总成绩：");
            scores = scanner.nextDouble();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("输入的成绩格式有误");
        }
        System.out.println("本次考试的平均分为：");
        System.out.println(scores / num);
    }
}
