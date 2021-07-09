package hongchengstudy.exception.v1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        try {
            a = 10/scanner.nextInt();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }catch (Exception E){
            E.printStackTrace();
        }
        System.out.println(a);
    }
}
