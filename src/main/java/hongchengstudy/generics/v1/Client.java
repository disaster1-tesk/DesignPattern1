package hongchengstudy.generics.v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lottery<Prizes> Lottery = new Lottery<>(new ArrayList<>());
        while(true){
            System.out.println("==============欢迎来到disaster的抽奖系统============");
            System.out.println("1.添加奖品");
            System.out.println("2.抽奖");
            System.out.println("请输入您想要的操作：");
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    System.out.println();
                    break;
                case 2:
                    if (Lottery.lottery()==null) {
                        System.out.println("当前还没有任何奖品");
                    }else{
                        System.out.println(Lottery.lottery());
                    }
                    break;
                default:
                    System.out.println("请输入您想要的操作：");
                    break;
            }
        }

    }
}
