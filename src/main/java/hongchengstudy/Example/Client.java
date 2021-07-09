package hongchengstudy.Example;


import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName Cllient
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/5 10:10
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        byte b = 127;
        System.out.println("b = " + b);
        Long l = 10l;
        float f = 10;
        double d = 10;
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String str = new String("str");
        System.out.println("str = " + str);
        String s = str.toUpperCase();
        System.out.println("s = " + s);
        System.out.println(chars.equals(str));
    }
}

class Observer1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {

    }
}
