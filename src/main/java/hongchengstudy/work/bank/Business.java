package hongchengstudy.work.bank;

public class Business {
    private static int BALANCE = 1;

    public static int getBalance() {
        return BALANCE;
    }

    public static void saveMoney(int money) {
        BALANCE +=money;
    }

    public static boolean getMoney(int money) throws MoneyException {
        if (money<0){
            throw new MoneyException("输入的金额不正确！");
        }
        if (BALANCE-money<1){
            throw new MoneyException("输入的金额不正确");
        }
        BALANCE -=money;
        return true;
    }
}
