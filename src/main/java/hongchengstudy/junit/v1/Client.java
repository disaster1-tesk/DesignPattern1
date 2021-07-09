package hongchengstudy.junit.v1;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Client {
    Client client = null;
    int sub = 0;
    public static void main(String[] args) {

    }
    public int sub(int a,int b){
        return  a/b;
    }
    @Test
    public void add(){
        System.out.println("你好");
        sub = client.sub(5, 3);
        //断言机制
        Assert.assertEquals(3,sub);
    }
    @Before
    public void init(){
         client = new Client();
        System.out.println("初始化方法执行了！");
    }
    @After
    public void after(){
        System.out.println(sub);
    }
}

