package junit.v1;

import hongchengstudy.socket.v5.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Client {
    private Server server;
    @Before
    public void before(){
        server = new Server();
    }
    @Test
    public void test() throws IOException {
        server.start();
    }
    @After
    public void after(){
        System.out.println("执行结束！");
    }
}

