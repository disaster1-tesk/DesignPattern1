package hongchengstudy.work.thread;

public class Client {
    public static void main(String[] args) {
        System.out.println(getPrimNumber(2, 1000));
        new Thread(() -> System.out.println(
                getPrimNumber(100000, 200000))
        ).start();
    }
    //获取素数
    public static int getPrimNumber(int startNum, int endNum) {
        int num = 0;
        for (int i = startNum; i <endNum ; i++) {
            if (isPrime(i)){
                num++;
            }
        }
        return num;
    }
    //判断素数
    public static boolean isPrime(int num) {
        //两个较小数另外处理
        if(num==2 || num==3) {
            return true;
        }
        //不在6的倍数两侧的一定不是素数
        if(num%6!=1 && num%6!=5) {
            return false;
        }
        //在6的倍数两侧的也可能不是素数
        for(int i=5; i<=Math.sqrt(num); i+=6) {
            if(num%i==0 || num%(i+2)==0) {
                return false;
            }
        }
        return true;
    }
    public static boolean check(int m){
        for (int i = 2; i <=Math.sqrt(m) ; i++) {
            if (m%i==0)
                return false;
        }
        return true;
    }
}
