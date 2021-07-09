package hongchengstudy.reflect.v3;

import java.io.File;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/2 15:28
 * @Version 1.0
 **/
public class Computer {
    @Check
    public void add(){
        System.out.println("执行了加的方法...");
        int a = 1/0;
    }
    @Check
    public void sub(){
        String str = null;
        new File(str);
        System.out.println("执行了减的方法...");
    }
    @Check
    public void div(){
        System.out.println("执行了乘的方法...");
    }
    @Check
    public void mul(){
        System.out.println("执行了除的方法...");
    }
    public void good(){
        System.out.println("这是一个好方法....");
    }
}
