package hongchengstudy.Lambda.v4;
/*
用lambda表达式实现延迟加载
 */
public class Client {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        printLog(1,()->{
            System.out.println("getMessage被执行了");
            return s1+s2;});
    }
    public static void printLog(int level,PrintMessage printMessage){
        if (level==1){
            System.out.println("日志信息为："+printMessage.getMessage());
        }
    }
}
interface PrintMessage{
    String getMessage();
    default void forTest(){
        System.out.println("纯测试用");
    }
}