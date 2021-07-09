package hongchengstudy.work.volumecalculation;

import java.util.Scanner;

public class Client {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Math<Polygon> polygonMath = new Math<>();
        while (true) {
            System.out.println("==========================计算体积======================");
            System.out.println("1.圆柱形");
            System.out.println("2.矩形");
            System.out.println("请输入你想要计算的多边形类型：");
            int flag = scanner.nextInt();
            switch (flag){
                case 1:
                    System.out.println("请输入圆柱形的半径：");
                    int radius = scanner.nextInt();
                    System.out.println("请输入圆柱形的高：");
                    int height = scanner.nextInt();
                    try {
                        System.out.println(polygonMath.getVolume(new Cylinder(height, radius)));
                    } catch (NumericalException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("请输入矩形的长：");
                    int length1 = scanner.nextInt();
                    System.out.println("请输入矩形的宽：");
                    int width = scanner.nextInt();
                    System.out.println("请输入矩形的高：");
                    int height1 = scanner.nextInt();
                    try {
                        System.out.println(polygonMath.getVolume(new Rectangle(height1, width, length1)));
                    } catch (NumericalException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
