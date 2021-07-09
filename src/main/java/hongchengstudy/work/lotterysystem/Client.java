package hongchengstudy.work.lotterysystem;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotterySys lotterySys = new LotterySys();
        Map<String, String> empAndPrize = null;
        Set<String> emp = null;
        while (true) {
            System.out.println("==============欢迎来到disaster的抽奖系统===============");
            System.out.println("1.抽奖");
            System.out.println("2.退出抽奖");
            System.out.println("请输入您想操作的指令：");
            int flag = scanner.nextInt();
            switch (flag) {
                case 1:
                    empAndPrize = lotterySys.lottery();
                    if (empAndPrize==null){
                        System.out.println("抽奖已结束！");
                        System.exit(0);
                    }
                    emp = empAndPrize.keySet();
                    for (String e : emp) {
                        if (empAndPrize.get(e) == null) {
                            System.out.println("很遗憾" + e + "未能抽中奖品");
                        } else {
                            System.out.println("恭喜" + e + "抽中" + empAndPrize.get(e));
                        }
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请您重新输入：");
                    break;
            }
        }
    }
}
