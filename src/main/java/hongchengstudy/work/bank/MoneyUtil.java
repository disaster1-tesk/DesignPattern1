package hongchengstudy.work.bank;

public class MoneyUtil {
    public static int typeConversion(String money){
        int result = 0;
        try {
             result = Integer.valueOf(money);
        } catch (NumberFormatException e) {
            return -1;
        }
        return result;
        /*Boolean strResult = money.matches("-?[0-9]+.？[0-9]*");
        if(strResult == true) {
            return Integer.valueOf(money);
        } else {
            return -1;
        }*/
    }
}
